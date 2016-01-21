package izio_server.network.input.littleEndian;

import izio_server.network.input.ImplSeekableInputByteStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class GenericSeekableLittleEndianReader extends GenericLittleEndianReader implements ImplSeekableLittleEndianReader {

    private ImplSeekableInputByteStream isibs;
    
    public GenericSeekableLittleEndianReader(ImplSeekableInputByteStream isibs) {
        super(isibs);
        this.isibs = isibs;
    }

    /**
     * Move pointer to offset.
     * @param offset Offset
     */
    @Override
    public void seek(long offset) {
        try {
            isibs.seek(offset);
        } catch (IOException ex) {
            Logger.getLogger(GenericSeekableLittleEndianReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Return the position of the pointer.
     * @return Position of the pointer.
     */
    @Override
    public long getPosition() {
        try {
            return isibs.getPosition();
        } catch (IOException ex) {
            Logger.getLogger(GenericSeekableLittleEndianReader.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    /**
     * Skip n number of bytes in stream.
     * @param n number of bytes to skip.
     */
    @Override
    public void skip(int n) {
        seek(getPosition() + n);
    }
}
