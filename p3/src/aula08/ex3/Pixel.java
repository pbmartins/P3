package aula08.ex3;
import java.util.*;

public class Pixel {
    private byte R;
    private byte G;
    private byte B;
    private byte A;

    public Pixel (byte R, byte B, byte G, byte A) {
        this.R = R;
        this.B = G;
        this.G = B;
        this.A = A;
    }

    public Pixel (byte[] array) {
        this(array[0], array[1], array[2], array[3]);
    }

    public byte[] getRGB() {
        return new byte[]{this.R, this.G, this.B};
    }

    public byte[] getBGR() {
        return new byte[]{this.B, this.G, this.R};
    }

    public byte[] getRGBA() {
        return new byte[]{this.R, this.G, this.B, this.A};
    }

    public byte[] getABGR() {
        return new byte[]{this.A, this.B, this.G, this.R};
    }


    @Override public String toString() {
        return "R: " + this.R + ", G: " + this.G + ", B: " + this.B + ", A: " + this.A;
    }

    @Override public boolean equals(Object p) {
        if (p == null)
            return false;
        if (p.getClass() != this.getClass())
            return false;
        return Arrays.equals(((Pixel)p).getRGB(), this.getRGB());
    }
}
