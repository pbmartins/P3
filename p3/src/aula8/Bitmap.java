package aula8;

import com.sun.javafx.image.PixelAccessor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Bitmap {
    private BitmapFileHeader bitmapFileHeader;
    private BitmapInfoHeader bitmapInfoHeader;
    private Pixel[][] pixelData; // pixel data, only for 24bits, 3 bytes R G B
    private byte[] rgbQuad;
    private byte[] rgb;
    private String nameOfFile;

    public Bitmap(BitmapFileHeader bfh, BitmapInfoHeader bih, Pixel[][] pixelData, String nameOfFile) {
        if (bfh == null)
            throw new IllegalArgumentException("BitmapFileHeader inválido.");
        if (bih == null)
            throw new IllegalArgumentException("BitmapInfoHeader inválido.");
        if (pixelData == null)
            throw new IllegalArgumentException("PixelData inválido.");
        if (nameOfFile == null || nameOfFile.length() == 0)
            throw new IllegalArgumentException("Nome do ficheiro inválido.");
        this.bitmapFileHeader = bfh;
        this.bitmapInfoHeader = bih;
        this.pixelData = pixelData;
        this.nameOfFile = nameOfFile;
    }

    public Bitmap(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");
        String[] info = path.split("\\.");
        if (!info[info.length - 1].equals("bmp"))
            throw new IllegalArgumentException("Extensão inválido.");

        info = path.split("/");
        this.nameOfFile = info[info.length - 1];

        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");
            // Get File Header
            byte[] bfh = new byte[14];
            file.read(bfh);
            this.bitmapFileHeader = new BitmapFileHeader(bfh);

            // Get Info Header
            byte[] bih = new byte[40];
            file.read(bih);
            this.bitmapInfoHeader = new BitmapInfoHeader(bih);

            // Get pixel data
            int w = Math.abs(this.bitmapInfoHeader.getWidth());
            int h = Math.abs(this.bitmapInfoHeader.getHeight());
           /* BufferedImage bi = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "bmp", baos);
            baos.flush();
            rgb = baos.toByteArray();
            baos.close();*/

            int rowSize = (this.bitmapInfoHeader.getBitCount() * w + 31) / 32 * 4;
            System.out.println(rowSize);


            rgb = new byte[Math.abs(this.bitmapInfoHeader.getHeight() * rowSize)];
            file.read(rgb);
            file.close();

/*          byte[] newarr = new byte[rgb.length];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < rowSize; j++) {
                    newarr[i * w * 3 + j] = rgb[(h - i - 1) * w * 3 + j];
                }
            }
            rgb = newarr;*/

            this.pixelData = new Pixel[h][w];

            int k = 0;
            for (int i = 0; i < this.pixelData.length; i++) {
                for (int j = 0; j < this.pixelData[0].length; j++) {
                    byte R = 0, G = 0, B = 0;
                    if (this.bitmapInfoHeader.getBitCount() == 24) {
                        B = rgb[k++];
                        G = rgb[k++];
                        R = rgb[k++];
                    } else {
                        R = rgb[k++];
                        G = rgb[k++];
                        B = rgb[k++];
                    }
                    this.pixelData[i][j] = new Pixel(R, G, B);
                }
            }

            getRGBQuadData();
            //getRGBData();
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void save(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");

            file.write(this.bitmapFileHeader.getReversedFileHeader());
            file.write(this.bitmapInfoHeader.getReversedInfoHeader());

            for (int i = 0; i < this.pixelData.length; i++) {
                for (int j = 0; j < this.pixelData[0].length; j++) {
                    if (this.bitmapInfoHeader.getBitCount() == 24)
                        file.write(this.pixelData[i][j].getBGR());
                    else
                        file.write(this.pixelData[i][j].getRGB());
                }
            }
            file.close();
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void saveToRAW(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");
        String[] info = path.split("\\.");
        if (!info[info.length - 1].equals("raw"))
            throw new IllegalArgumentException("Extensão inválido.");
        try {
            RandomAccessFile file = new RandomAccessFile(path, "rw");

            for (int i = 0; i < this.pixelData.length; i++) {
                for (int j = 0; j < this.pixelData[0].length; j++) {
                    file.write(this.pixelData[i][j].getRGB());
                }
            }
            file.close();
        } catch (IOException e) {
            System.err.format("IOException: %s\n", e);
        }
    }

    public void saveToAFourth(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");
        String[] info = path.split("\\.");
        if (!info[info.length - 1].equals("bmp"))
            throw new IllegalArgumentException("Extensão inválido.");

        int newWidth = this.bitmapInfoHeader.getWidth() / 2;
        int newHeight = this.bitmapInfoHeader.getHeight() / 2;

        BitmapFileHeader newBFH = new BitmapFileHeader(Math.abs(newHeight * newWidth * 3), this.bitmapFileHeader.getOffBits());
        BitmapInfoHeader newBIH = new BitmapInfoHeader(newWidth, newHeight, this.bitmapInfoHeader.getBitCount(),
                this.bitmapInfoHeader.getCompression(), this.bitmapInfoHeader.getSizeImage(), this.bitmapInfoHeader.getxPelsPerMeter(),
                this.bitmapInfoHeader.getyPelsPerMeter(), this.bitmapInfoHeader.getClrUsed(), this.bitmapInfoHeader.getClrImportant());

        Pixel[][] newPixelData = new Pixel[Math.abs(newHeight)][newWidth];

        for (int i = 0, ni = 0 ; i < this.pixelData.length && ni < newPixelData.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0, nj = 0 ; j < this.pixelData[0].length && nj < newPixelData[0].length; j++) {
                    if (j % 2 == 0)
                        newPixelData[ni][nj++] = this.pixelData[i][j];
                }
                ni++;
            }
        }

        Bitmap resized = new Bitmap(newBFH, newBIH, newPixelData, path);
        resized.save(path);
    }

    public void saveFlipped(String path, int type) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("Caminho inválido.");
        String[] info = path.split("\\.");
        if (!info[info.length - 1].equals("bmp"))
            throw new IllegalArgumentException("Extensão inválido.");
        if (type != 0 && type != 1)
            throw new IllegalArgumentException("Só é aceite: Horizontal(0) e Vertical(1).");


        Pixel[][] newPixelData = new Pixel[this.pixelData.length][this.pixelData[0].length];

        if (type == 0) { // Horizontally
            for (int i = 0; i < this.pixelData.length; i++) {
                for (int j = this.pixelData[0].length - 1, nj = 0; j >= 0; j--, nj++) {
                    newPixelData[i][nj] = this.pixelData[i][j];
                }
            }
        } else {
            for (int i = this.pixelData.length - 1, ni = 0; i >= 0; i--, ni++) {
                for (int j = 0; j < this.pixelData[0].length; j++) {
                    newPixelData[ni][j] = this.pixelData[i][j];
                }
            }
        }

        Bitmap flipped = new Bitmap(this.bitmapFileHeader, this.bitmapInfoHeader, newPixelData, path);
        flipped.save(path);
    }

    public String getNameOfFile() {
        return this.nameOfFile;
    }

    public BitmapFileHeader getBitmapFileHeader() {
        return this.bitmapFileHeader;
    }

    public BitmapInfoHeader getBitmapInfoHeader() {
        return this.bitmapInfoHeader;
    }

    public Pixel[][] getPixelData() {
        return this.pixelData;
    }

    public byte[] getRGBQuad() {
        return this.rgbQuad;
    }

    public byte[] getRGB() {
        return this.rgb;
    }

    @Override public String toString() {
        return "Name of file: " + this.nameOfFile +
                "\n--- BitmapFileHeader ---\n" + this.bitmapFileHeader.toString() +
                "\n--- BitmapInfoHeader ---\n" + this.bitmapInfoHeader.toString();
    }

    @Override public boolean equals(Object b) {
        if (b == null)
            return false;
        if (b.getClass() != this.getClass())
            return false;
        return ((Bitmap)b).getNameOfFile().equals(this.nameOfFile) && ((Bitmap)b).getBitmapFileHeader().equals(this.bitmapFileHeader) &&
                ((Bitmap)b).getBitmapInfoHeader().equals(this.bitmapInfoHeader) && Arrays.equals(((Bitmap)b).getPixelData(), this.pixelData) &&
                Arrays.equals(((Bitmap)b).getRGBQuad(), this.rgbQuad);
    }

    private void getRGBQuadData() {
        this.rgbQuad = new byte[pixelData.length * pixelData[0].length * 4];
        int k = 0;
        for (int i = 0; i < pixelData.length; i++) {
            for (int j = 0; j < pixelData[0].length; j++) {
                this.rgbQuad[k++] = (byte)0;
                this.rgbQuad[k++] = pixelData[i][j].getRGB()[2];
                this.rgbQuad[k++] = pixelData[i][j].getRGB()[1];
                this.rgbQuad[k++] = pixelData[i][j].getRGB()[0];
            }
        }
    }

    private void getRGBData() {
        this.rgb = new byte[pixelData.length * pixelData[0].length * 3];
        int k = 0;
        for (int i = 0; i < pixelData.length; i++) {
            for (int j = 0; j < pixelData[0].length; j++) {
                this.rgb[k++] = pixelData[i][j].getRGB()[2];
                this.rgb[k++] = pixelData[i][j].getRGB()[1];
                this.rgb[k++] = pixelData[i][j].getRGB()[0];
            }
        }
    }
}
