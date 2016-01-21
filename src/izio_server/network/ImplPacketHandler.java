package izio_server.network;

import izio_server.Client;
import izio_server.network.input.littleEndian.ImplSeekableLittleEndianReader;

/**
 *
 * @author Richard
 */
public interface ImplPacketHandler {

    public void handlePacket(ImplSeekableLittleEndianReader isle, Client client);
}
