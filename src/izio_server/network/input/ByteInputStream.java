package izio_server.network.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class ByteInputStream implements ImplByteInputStream {
    
    private InputStream is;
    private long readBytes = 0;
    
    public ByteInputStream(InputStream is) {
        this.is = is;
    }

    /**
     * Read the next byte in the stream.
     * @return The next byte in the stream.
     */
    @Override
    public int readByte() {
        int temp;
        try {
            temp = is.read();
            if (temp == -1) throw new RuntimeException("EOF");
            readBytes++;
            return temp;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Return the number of bytes read from the stream.
     * @return Number of bytes read from the stream.
     */
    @Override
    public long getBytesRead() {
        return readBytes;
    }

    /**
     * Return the number of bytes left in the stream.
     * @return The number of bytes left in the stream.
     */
    @Override
    public long availableBytes() {
        try {
            return is.available();
        } catch (IOException ex) {
            Logger.getLogger(ByteInputStream.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
