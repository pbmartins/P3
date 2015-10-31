package aula7;
import java.util.*;

public class Pixel {
    private byte R;
    private byte G;
    private byte B;

    public Pixel (byte R, byte B, byte G) {
        this.R = R;
        this.B = G;
        this.G = B;
    }

    public Pixel (byte[] array) {
        this(array[0], array[1], array[2]);
    }

    public byte[] getRGB() {
        return new byte[]{this.R, this.G, this.B};
    }

    public byte[] getBGR() {
        return new byte[]{this.B, this.G, this.R};
    }

    @Override public String toString() {
        return "R: " + this.R + ", G: " + this.G + ", B: " + this.B;
    }

    @Override public boolean equals(Object p) {
        if (p == null)
            return false;
        if (p.getClass() != this.getClass())
            return false;
        return Arrays.equals(((Pixel)p).getRGB(), this.getRGB());
    }
}
