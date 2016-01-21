package izio_server.network;

/**
 *
 * @author Richard
 */
public enum RecvPacketOpcode {
    LICENSE(0x10);
    
    private int value;
    
    private RecvPacketOpcode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
