package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.socket_type_t;

/* loaded from: classes2.dex */
public enum SocketType {
    TCP(socket_type_t.tcp.swigValue()),
    TCP_SSL(socket_type_t.tcp_ssl.swigValue()),
    UDP(socket_type_t.udp.swigValue()),
    I2P(socket_type_t.i2p.swigValue()),
    SOCKS5(socket_type_t.socks5.swigValue()),
    UTP_SSL(socket_type_t.utp_ssl.swigValue()),
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
