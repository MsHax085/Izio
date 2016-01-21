package izio_server.network;

/**
 *
 * @author Richard
 */
public enum SendPacketOpcode {
    LICENSE_RESPONSE(0x11);
    
    private int value;
    
    private SendPacketOpcode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
