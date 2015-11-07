package aula8;

import javafx.scene.input.PickResult;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class PanelImage extends JPanel {
    BufferedImage bi;
    /**
     * @param pixels - Byte Array with Pixels
     * @param w - Image Width (columns)
     * @param h - Image Heigth (row)
     */
    PanelImage(byte[] pixels, int w, int h, boolean quad){
        if (quad) {
            bi = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
            bi.setRGB(0, 0, w, h, byteArrayToIntArrayQuad(pixels), 0, w);
        } else {
            bi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            bi.setRGB(0, 0, w, h, byteArrayToIntArray(pixels, w, h), 0, w);
        }
        this.setPreferredSize(new Dimension(w, h));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, this);
    }

    private int[] byteArrayToIntArrayQuad(byte[] arr){
        int[] ret = new int[arr.length / 4];
        for (int i = 0; i < ret.length; i++)
            ret [i] = (arr[i*4 + 3]<<24 | (arr[i*4 + 2]&0xff)<<16 | (arr[i*4 + 1]&0xff)<<8 | (arr[i*4]&0xff));
        return ret;
    }

    private int[] byteArrayToIntArray(byte[] arr, int w, int h){
        int[] ret = new int[arr.length / 3];
        for (int i = 0; i < ret.length; i++)
            ret [i] = (-1 << 24 | (arr[i * 3 + 2] & 0xff) << 16 | (arr[i * 3 + 1] & 0xff) << 8 | (arr[i * 3] & 0xff));
        return ret;
    }
}
