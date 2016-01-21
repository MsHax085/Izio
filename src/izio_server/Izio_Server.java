package izio_server;

import izio_server.network.ServerHandler;
import izio_server.network.codec.CodecFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @author Richard
 */
public class Izio_Server {
    
    private static final int PORT = 8484;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
//        final IoAcceptor acceptor = new NioSocketAcceptor();
//        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
////        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
//        TextLineCodecFactory o = new TextLineCodecFactory( Charset.forName( "UTF-8" ));
//        o.setDecoderMaxLineLength(Integer.MAX_VALUE);
//        o.setEncoderMaxLineLength(Integer.MAX_VALUE);
//        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(o));
//        acceptor.getSessionConfig().setWriteTimeout(10);
//        acceptor.setHandler(new ServerHandler());
//        acceptor.getSessionConfig().setReadBufferSize(2048);
//        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
//        acceptor.bind(new InetSocketAddress(PORT));
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
//        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CodecFactory()));
        acceptor.setHandler(new ServerHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        acceptor.bind(new InetSocketAddress(PORT));
    }
}
