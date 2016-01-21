package izio_server.network.input;

import java.io.IOException;

/**
 *
 * @author Richard
 */
public class SeekableByteInputStream implements ImplSeekableInputByteStream {

    private int position = 0;
    private long bytesRead = 0;
    private byte[] array;
    
    public SeekableByteInputStream(byte[] array) {
        this.array = array;
    }

    @Override
    public long getPosition() {
        return position;
    }

    @Override
    public void seek(long offset) throws IOException {
        position = (int) offset;
    }

    @Override
    public long getBytesRead() {
        return bytesRead;
    }

    @Override
    public int readByte() {
        bytesRead++;
        return ((int) array[position++]) & 0xFF;
    }
    
    @Override
    public long availableBytes() {
        return array.length - position;
    }
}
