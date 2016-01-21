package izio_server.network.output;

import java.io.ByteArrayOutputStream;

/**
 *
 * @author Richard
 */
public class PacketLittleEndianWriter extends GenericLittleEndianWriter {

    private ByteArrayOutputStream baos;
    
    public PacketLittleEndianWriter() {
        this(32);
    }
    
    public PacketLittleEndianWriter(int size) {
        this.baos = new ByteArrayOutputStream(size);
        this.setByteOutputStream(new ByteOutputStream(this.baos));
    }
    
    public Packet getPacket() {
        return new Packet(baos.toByteArray());
    }
}
