package izio_server.network.codec;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 *
 * @author Richard
 */
public class PacketDecoder extends CumulativeProtocolDecoder {

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        if (in.remaining() <= 0) return false;
        final byte[] packetData = new byte[in.remaining()];
        in.get(packetData);// Fill packetData
        out.write(packetData);
        return true;
    }
}
