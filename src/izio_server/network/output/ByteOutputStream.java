package izio_server.network.output;

import java.io.ByteArrayOutputStream;

/**
 *
 * @author Richard
 */
public class ByteOutputStream implements ImplByteOutputStream {

    private final ByteArrayOutputStream baos;
    
    public ByteOutputStream(ByteArrayOutputStream baos) {
        super();
        this.baos = baos;
    }
    
    @Override
    public void writeByte(byte b) {
        baos.write(b);
    }
}
