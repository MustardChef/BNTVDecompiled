package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.TcpEndpoint;
import com.frostwire.jlibtorrent.swig.incoming_connection_alert;

/* loaded from: classes2.dex */
public final class IncomingConnectionAlert extends AbstractAlert<incoming_connection_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IncomingConnectionAlert(incoming_connection_alert incoming_connection_alertVar) {
        super(incoming_connection_alertVar);
    }

    public SocketType socketType() {
        return SocketType.fromSwig(((incoming_connection_alert) this.alert).getSocket_type());
    }

    public TcpEndpoint endpoint() {
        return new TcpEndpoint(((incoming_connection_alert) this.alert).get_endpoint());
    }

    /* loaded from: classes2.dex */
    public enum SocketType {
        NONE(0),
        TCP(1),
        SOCKS5(2),
        HTTP(3),
        UTP(4),
        I2P(5),
        SSL_TCP(6),
        SSL_SOCKS5(7),
        HTTPS(8),
        SSL_UTP(9),
        UNKNOWN(-1);
        
        private final int swigValue;

        SocketType(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static SocketType fromSwig(int i) {
            SocketType[] socketTypeArr;
            for (SocketType socketType : (SocketType[]) SocketType.class.getEnumConstants()) {
                if (socketType.swig() == i) {
                    return socketType;
                }
            }
            return UNKNOWN;
        }
    }
}
