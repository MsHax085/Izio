package izio_server.network.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 *
 * @author Richard
 */
public class CodecFactory implements ProtocolCodecFactory {

    private final ProtocolEncoder encoder;
    private final ProtocolDecoder decoder;
    
    public CodecFactory() {
        this.encoder = new PacketEncoder();
        this.decoder = new PacketDecoder();
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession is) throws Exception {
        return decoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession is) throws Exception {
        return encoder;
    }
}
