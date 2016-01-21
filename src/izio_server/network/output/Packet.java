package izio_server.network.output;

/**
 *
 * @author Richard
 */
public class Packet implements ImplPacket {

    private byte[] data;
    
    public Packet(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] getBytes() {
        return data;
    }
}
