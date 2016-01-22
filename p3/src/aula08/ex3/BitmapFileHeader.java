package aula08.ex3;

import java.nio.ByteBuffer;

public class BitmapFileHeader{
    private static final short type = 19778;   // 4D 42 - must be 'BM' to declare a bmp-file
    private int size;                          // specifies the size of the file in bytes
    private static final short reserved1 = 0;  // P3 must always be set to zero
    private static final short reserved2 = 0;  // must always be set to zero
    private int offBits;                       // specifies the offset from the beginning of the file to the bitmap data

    public BitmapFileHeader(int size, int offBits) {
        this.size = size;
        this.offBits = offBits;
    }

    public BitmapFileHeader(byte[] array) {
        ByteBuffer wrapper = ByteBuffer.wrap(array);
        if (Short.reverseBytes(wrapper.getShort(0)) != type)
            throw new IllegalArgumentException("Tipo de ficheiro invalido.");
        this.size = Integer.reverseBytes(wrapper.getInt(2));
        this.offBits = Integer.reverseBytes(wrapper.getInt(10));
    }

    public byte[] getFileHeader() {
        ByteBuffer wrapper = ByteBuffer.allocate(14);
        wrapper.putShort(0, type);
        wrapper.putInt(2, size);
        wrapper.putShort(6, reserved1);
        wrapper.putShort(8, reserved2);
        wrapper.putInt(10, offBits);
        return wrapper.array();
    }

    public byte[] getReversedFileHeader() {
        ByteBuffer wrapper = ByteBuffer.allocate(14);
        wrapper.putShort(0, Short.reverseBytes(type));
        wrapper.putInt(2, Integer.reverseBytes(size));
        wrapper.putShort(6, Short.reverseBytes(reserved1));
        wrapper.putShort(8, Short.reverseBytes(reserved2));
        wrapper.putInt(10, Integer.reverseBytes(offBits));
        return wrapper.array();
    }

    public int getSize() {
        return this.size;
    }

    public int getOffBits() {
        return this.offBits;
    }

    @Override public String toString() {
        return "Type: " + type +
                "\nSize: " + this.size +
                "\nReserved1: " + reserved1 +
                "\nReserved2: " + reserved2 +
                "\nOffset Bits: " + this.offBits;
    }

    @Override public boolean equals(Object bfh) {
        if (bfh == null)
            return false;
        if (bfh.getClass() != this.getClass())
            return false;
        return ((BitmapFileHeader)bfh).getSize() == this.size && ((BitmapFileHeader)bfh).getOffBits() == this.offBits;
    }
}
