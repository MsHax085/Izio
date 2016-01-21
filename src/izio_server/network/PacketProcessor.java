package izio_server.network;

import izio_server.packets.LicenseHandler;
import java.util.HashMap;

/**
 *
 * @author Richard
 */
public class PacketProcessor {
    
    private HashMap<Integer, ImplPacketHandler> handlers;

    public ImplPacketHandler getHandler(int opCode) {
        return handlers.get(opCode);
    }
    
    public void loadRecvHandlers() {
        handlers = new HashMap<>();
        handlers.put(RecvPacketOpcode.LICENSE.getValue(), new LicenseHandler());
    }
}
