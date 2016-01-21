package izio_server.network.output;

import java.nio.charset.Charset;

/**
 * To little-endian
 * @author Richard
 */
public class GenericLittleEndianWriter implements ImplGenericLittleEndianWriter {
    
    private final Charset charset = Charset.forName("UTF-8");
    private ImplByteOutputStream ibos;

    @Override
    public void setByteOutputStream(ImplByteOutputStream ibos) {
        this.ibos = ibos;
    }

    @Override
    public void write(byte[] b) {
        for (int x = 0; x < b.length; x++) ibos.writeByte(b[x]);
    }

    @Override
    public void write(byte b) {
        ibos.writeByte(b);
    }

    @Override
    public void writeZeros(int times) {
        for (int x = 0; x < times; x++) ibos.writeByte((byte) 0);
    }

    @Override
    public void write(int b) {
        ibos.writeByte((byte) b);
    }

    @Override
    public void writeShort(int i) {
        ibos.writeByte((byte) (i & 0xFF));// Mask first byte
        ibos.writeByte((byte) ((i >>> 8 & 0xFF)));// Zero fill right shift by 8
    }

    @Override
    public void writeInt(int i) {
        ibos.writeByte((byte) (i & 0xFF));// Mask first byte
        ibos.writeByte((byte) ((i >>> 8 & 0xFF)));// Zero fill right shift by 8
        ibos.writeByte((byte) ((i >>> 16 & 0xFF)));
        ibos.writeByte((byte) ((i >>> 24 & 0xFF)));
    }

    @Override
    public void writeAsciiString(String s) {
        write(s.getBytes(charset));
    }

    @Override
    public void writeTerminatedAsciiString(String s) {
        writeAsciiString(s);
        write(0);
    }

    @Override
    public void writeLong(long l) {
        ibos.writeByte((byte) (l & 0xFF));// Mask first byte
        ibos.writeByte((byte) ((l >>> 8 & 0xFF)));// Zero fill right shift by 8
        ibos.writeByte((byte) ((l >>> 16 & 0xFF)));
        ibos.writeByte((byte) ((l >>> 24 & 0xFF)));
        ibos.writeByte((byte) ((l >>> 32 & 0xFF)));
        ibos.writeByte((byte) ((l >>> 40 & 0xFF)));
        ibos.writeByte((byte) ((l >>> 48 & 0xFF)));
        ibos.writeByte((byte) ((l >>> 56 & 0xFF)));
    }
}
