package izio_server.network.input.littleEndian;

/**
 *
 * @author Richard
 */
public interface ImplLittleEndianReader {
    
    public byte readByte();
    
    public char readChar();
    
    public short readShort();
    
    public int readInt();
    
    public long readLong();
    
    public void skip(int num);
    
    public byte[] read(int num);
    
    public float readFloat();
    
    public double readDouble();
    
    public String readAsciiString(int n);
    
    public String readTerminatedAsciiString();
    
    public long getBytesRead();
    
    public long availableBytes();
}
