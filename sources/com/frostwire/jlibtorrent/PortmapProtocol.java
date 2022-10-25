package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.portmap_protocol;

/* loaded from: classes2.dex */
public enum PortmapProtocol {
    NONE(portmap_protocol.none.swigValue()),
    TCP(portmap_protocol.tcp.swigValue()),
    UDP(portmap_protocol.udp.swigValue());
    
    private final int swigValue;

    PortmapProtocol(int i) {
        this.swigValue = i;
    }

    public int swig() {
        return this.swigValue;
    }

    public static PortmapProtocol fromSwig(int i) {
        PortmapProtocol[] portmapProtocolArr;
        for (PortmapProtocol portmapProtocol : (PortmapProtocol[]) PortmapProtocol.class.getEnumConstants()) {
            if (portmapProtocol.swig() == i) {
                return portmapProtocol;
            }
        }
        throw new IllegalArgumentException("No enum " + PortmapProtocol.class + " with value " + i);
    }
}
