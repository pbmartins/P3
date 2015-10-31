package aula7;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class BitmapInfoHeader {
    private static final int size = 40;     // the size of this header (40 bytes)
    private int width;                      // the bitmap width in pixels
    private int height;                     // the bitmap height in pixels
                                            // Positive for bottom to top pixel order.
                                            // Negative for top to bottom pixel order.
    private static final short planes = 1;  // the number of color planes being used. Must be set to 1
    private short bitCount;                 // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
                                            // w * h * 3 , 24 bits, 3 bytes, RGB
                                            // sendo 8 bits, 1 byte, precisamos de uma palete de cores, 0 a 255
                                            // colocar excep‹o para os tipos suportados, suporta apenas inicialmente com 3bytes
    private int compression;                // the compression method being used
    private int sizeImage; 	                // the image size. This is the size of the raw bitmap data
    private int xPelsPerMeter;              // the horizontal resolution of the image (pixel per meter)
    private int yPelsPerMeter;              // the vertical resolution of the image (pixel per meter)
    private int clrUsed;                    // the number of colors in the color palette, or 0 to default to 2n
    private int clrImportant;               // the number of important colors used, or 0 when every color is important

    public BitmapInfoHeader(int width, int height, short bitCount, int compression, int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {
        this.width = width;
        this.height = height;
        this.bitCount = bitCount;
        this.compression = compression;
        this.sizeImage = sizeImage;
        this.xPelsPerMeter = xPelsPerMeter;
        this.yPelsPerMeter = yPelsPerMeter;
        this.clrUsed = clrUsed;
        this.clrImportant = clrImportant;
    }

    public BitmapInfoHeader(byte[] array) {
        ByteBuffer wrapper = ByteBuffer.wrap(array);
        if (Integer.reverseBytes(wrapper.getInt(0)) != size || Short.reverseBytes(wrapper.getShort(12)) != planes)
            throw new IllegalArgumentException("Cabeçalho inválido.");
        this.width = Integer.reverseBytes(wrapper.getInt(4));
        this.height = Integer.reverseBytes(wrapper.getInt(8));
        this.bitCount = Short.reverseBytes(wrapper.getShort(14));
        this.compression = Integer.reverseBytes(wrapper.getInt(16));
        this.sizeImage = Integer.reverseBytes(wrapper.getInt(20));
        this.xPelsPerMeter = Integer.reverseBytes(wrapper.getInt(24));
        this.yPelsPerMeter = Integer.reverseBytes(wrapper.getInt(28));
        this.clrUsed = Integer.reverseBytes(wrapper.getInt(32));
        this.clrImportant = Integer.reverseBytes(wrapper.getInt(36));
    }

    public byte[] getInfoHeader() {
        ByteBuffer wrapper = ByteBuffer.allocate(40);
        wrapper.putInt(0, size);
        wrapper.putInt(4, width);
        wrapper.putInt(8, height);
        wrapper.putShort(12, planes);
        wrapper.putShort(14, bitCount);
        wrapper.putInt(16, compression);
        wrapper.putInt(20, sizeImage);
        wrapper.putInt(24, xPelsPerMeter);
        wrapper.putInt(28, yPelsPerMeter);
        wrapper.putInt(32, clrUsed);
        wrapper.putInt(36, clrImportant);
        return wrapper.array();
    }

    public byte[] getReversedInfoHeader() {
        ByteBuffer wrapper = ByteBuffer.allocate(40);
        wrapper.putInt(0, Integer.reverseBytes(size));
        wrapper.putInt(4, Integer.reverseBytes(width));
        wrapper.putInt(8, Integer.reverseBytes(height));
        wrapper.putShort(12, Short.reverseBytes(planes));
        wrapper.putShort(14, Short.reverseBytes(bitCount));
        wrapper.putInt(16, Integer.reverseBytes(compression));
        wrapper.putInt(20, Integer.reverseBytes(sizeImage));
        wrapper.putInt(24, Integer.reverseBytes(xPelsPerMeter));
        wrapper.putInt(28, Integer.reverseBytes(yPelsPerMeter));
        wrapper.putInt(32, Integer.reverseBytes(clrUsed));
        wrapper.putInt(36, Integer.reverseBytes(clrImportant));
        return wrapper.array();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public short getBitCount() {
        return this.bitCount;
    }

    public int getCompression() {
        return compression;
    }

    public int getSizeImage() {
        return sizeImage;
    }

    public int getxPelsPerMeter() {
        return xPelsPerMeter;
    }

    public int getyPelsPerMeter() {
        return yPelsPerMeter;
    }

    public int getClrUsed() {
        return clrUsed;
    }

    public int getClrImportant() {
        return clrImportant;
    }

    @Override public String toString() {
        return "Size of the header: " + size + " bits" +
                "\nWidth: " + width + " pixeis" +
                "\nHeight: " + height +" pixeis" +
                "\nPlanes: " + planes +
                "\nBitCount: " + bitCount +
                "\nEspaço de cor: " + ((bitCount==24) ? "RGB" : "") +
                "\nCompression: " + compression +
                "\nSize of Image: " + sizeImage +
                "\nxPelsPerMeter: " + xPelsPerMeter +
                "\nyPelsPerMeter: " + yPelsPerMeter +
                "\nClrUsed: " + clrUsed +
                "\nClrImportant: " + clrImportant +
                "\n\nNote: Height of the bitmap in pixels. Positive for bottom to top pixel order." +
                "\nNegative for top to bottom pixel order.\n";
    }

    @Override public boolean equals(Object bih) {
        if (bih == null)
            return false;
        if (bih.getClass() != this.getClass())
            return false;
        return Arrays.equals(((BitmapInfoHeader) bih).getInfoHeader(), this.getInfoHeader());
    }

    public static int getSize() {
        return size;
    }

    public static short getPlanes() {
        return planes;
    }
}
