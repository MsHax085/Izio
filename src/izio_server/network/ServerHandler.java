package izio_server.network;

import izio_server.Client;
import izio_server.network.input.SeekableByteInputStream;
import izio_server.network.input.littleEndian.GenericSeekableLittleEndianReader;
import izio_server.network.input.littleEndian.ImplSeekableLittleEndianReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Richard
 */
public class ServerHandler extends IoHandlerAdapter {
    
    private final PacketProcessor packetProcessor = new PacketProcessor();

    public ServerHandler() {
        packetProcessor.loadRecvHandlers();
    }
    
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
    
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("Received: " + message);
        final byte[] content = (byte[]) message;
        final ImplSeekableLittleEndianReader isle = new GenericSeekableLittleEndianReader(new SeekableByteInputStream(content));
        final short packetId = isle.readShort();
        final Client client = (Client) session.getAttribute(Client.CLIENT_KEY);
        final ImplPacketHandler packetHandler = packetProcessor.getHandler(packetId);
        if (packetHandler != null) packetHandler.handlePacket(isle, client);
        else System.out.println("Could not find handler for packet opcode: " + packetId);
    }
    
    @Override
    public void sessionOpened(IoSession session) {
        System.out.println("IoSession opened with " + session.getRemoteAddress());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Client client = new Client(session);
        session.setAttribute(Client.CLIENT_KEY, client);
//        System.out.println("sending ...");
//        PacketLittleEndianWriter plew = new PacketLittleEndianWriter(3);
//        plew.writeShort(SendPacketOpcode.HELLO.getValue());
//        plew.write(1);
//        session.write(plew.getPacket());
//        System.out.println("sent!");
    }
    
    @Override
    public void sessionClosed(IoSession session) {
        final Client client = (Client) session.getAttribute(Client.CLIENT_KEY);
        if (client != null) {
            session.removeAttribute(Client.CLIENT_KEY);
        }
        System.out.println("IoSession closed with " + session.getRemoteAddress());
    }
    
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("Session idle (" + session.getIdleCount(status) + ") with " + session.getRemoteAddress());
    }
}
