package izio_server.packets;

import izio_server.Client;
import izio_server.network.ImplPacketHandler;
import izio_server.network.SendPacketOpcode;
import izio_server.network.input.littleEndian.ImplSeekableLittleEndianReader;
import izio_server.network.output.PacketLittleEndianWriter;

/**
 *
 * @author Richard
 */
public final class LicenseHandler implements ImplPacketHandler {
    
    private final String LICENSE = "NHLE-L6MI-4GE4-ETEV";
    private final int LICENSE_LENGTH = LICENSE.length();

    @Override
    public void handlePacket(ImplSeekableLittleEndianReader isle, Client client) {
        System.out.println("License handler reached");
        String recievedLicense = isle.readAsciiString(LICENSE_LENGTH);
        byte valid = 0;
        if (recievedLicense.equals(LICENSE)) {
            valid = 1;
            System.out.println("License valid!");
        } else {
            System.out.println("License invalid!");
        }
        
        PacketLittleEndianWriter plew = new PacketLittleEndianWriter(3);
        plew.writeShort(SendPacketOpcode.LICENSE_RESPONSE.getValue());
        plew.write(valid);
        client.getSession().write(plew.getPacket());
    }
}
