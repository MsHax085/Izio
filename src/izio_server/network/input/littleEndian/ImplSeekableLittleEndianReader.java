package izio_server.network.input.littleEndian;

import java.io.IOException;

/**
 *
 * @author Richard
 */
public interface ImplSeekableLittleEndianReader extends ImplLittleEndianReader {

    /**
     * Seeks the stream by offset.
     * @param offset Number of bytes to seek
     * @throws IOException 
     */
    public void seek(long offset) throws IOException;
    
    /**
     * Returns the current position of the stream.
     * @return The stream position.
     * @throws IOException 
     */
    public long getPosition() throws IOException;
}
