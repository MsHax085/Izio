package izio_server;

import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Richard
 */
public class Client {

    public static final String CLIENT_KEY = "CLIENT";
    private IoSession ioSession;
    
    public Client(IoSession ioSession) {
        this.ioSession = ioSession;
    }
    
    public IoSession getSession() {
        return ioSession;
    }
}
