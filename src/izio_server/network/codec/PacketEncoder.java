package izio_server.network.codec;

import izio_server.network.output.ImplPacket;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 *
 * @author Richard
 */
public class PacketEncoder implements ProtocolEncoder {

    @Override
    public void dispose(IoSession session) throws Exception {
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        out.write(IoBuffer.wrap(((ImplPacket) message).getBytes()));
    }
}
