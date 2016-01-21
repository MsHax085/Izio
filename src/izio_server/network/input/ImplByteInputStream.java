package izio_server.network.input;

/**
 *
 * @author Richard
 */
public interface ImplByteInputStream {

    public int readByte();
    
    public long getBytesRead();
    
    public long availableBytes();
}
