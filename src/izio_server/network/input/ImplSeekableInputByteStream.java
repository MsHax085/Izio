package izio_server.network.input;

import java.io.IOException;

/**
 *
 * @author Richard
 */
public interface ImplSeekableInputByteStream extends ImplByteInputStream {

    /**
     * Seeks the stream for offset.
     * @param offset Bytes to seek
     * @throws IOException 
     */
    public void seek(long offset) throws IOException;
    
    /**
     * Returns current position of stream.
     * @return The stream position.
     * @throws IOException 
     */
    public long getPosition() throws IOException;
}
