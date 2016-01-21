package izio_server.network.input.littleEndian;

import izio_server.network.input.ImplByteInputStream;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author Richard
 */
public class GenericLittleEndianReader implements ImplLittleEndianReader {

    private ImplByteInputStream ibis;
    
    public GenericLittleEndianReader(ImplByteInputStream ibis) {
        this.ibis = ibis;
    }

    @Override
    public byte readByte() {
        return (byte) ibis.readByte();
    }

    @Override
    public int readInt() {
        return ibis.readByte() +
               (ibis.readByte() << 8) +
               (ibis.readByte() << 16) +
               (ibis.readByte() << 24);
    }

    @Override
    public short readShort() {
        return (short) (ibis.readByte() +
                       (ibis.readByte() << 8));
    }

    @Override
    public char readChar() {
        return (char) readShort();
    }

    @Override
    public long readLong() {
        long b1 = ibis.readByte(),
             b2 = ibis.readByte(),
             b3 = ibis.readByte(),
             b4 = ibis.readByte(),
             b5 = ibis.readByte(),
             b6 = ibis.readByte(),
             b7 = ibis.readByte(),
             b8 = ibis.readByte();
        return (b8 << 56) +
               (b7 << 48) +
               (b6 << 40) +
               (b5 << 32) +
               (b4 << 24) +
               (b3 << 16) +
               (b2 << 8) +
               b1;
    }

    @Override
    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public String readAsciiString(int n) {
        char ret[] = new char[n];
        for (int x = 0; x < n; x++) ret[x] = (char) readByte();
        return String.valueOf(ret);
    }

    @Override
    public String readTerminatedAsciiString() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte b;
        while (true) {
            b = readByte();
            if (b == 0) break;
            baos.write(b);
        }
        
        byte[] buffer = baos.toByteArray();
        char[] charBuffer = new char[buffer.length];
        for (int x = 0; x < buffer.length; x++) charBuffer[x] = (char) buffer[x];
        return String.valueOf(charBuffer);
    }

    @Override
    public long getBytesRead() {
        return ibis.getBytesRead();
    }

    @Override
    public byte[] read(int num) {
        byte[] ret = new byte[num];
        for (int x = 0; x < num; x++) ret[x] = readByte();
        return ret;
    }

    @Override
    public void skip(int num) {
        for (int x = 0; x < num; x++) readByte();
    }

    @Override
    public long availableBytes() {
        return ibis.availableBytes();
    }
}
