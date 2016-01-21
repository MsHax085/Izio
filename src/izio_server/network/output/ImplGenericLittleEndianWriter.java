package izio_server.network.output;

/**
 *
 * @author Richard
 */
public interface ImplGenericLittleEndianWriter {

    public void setByteOutputStream(ImplByteOutputStream ibos);
    
    public void write(byte[] b);
    
    public void write(byte b);
    
    public void writeZeros(int times);
    
    public void write(int b);
    
    public void writeShort(int i);
    
    public void writeInt(int i);
    
    public void writeAsciiString(String s);
    
    public void writeTerminatedAsciiString(String s);
    
    public void writeLong(long l);
}
