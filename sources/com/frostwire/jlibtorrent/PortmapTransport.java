package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.portmap_transport;

/* loaded from: classes2.dex */
public enum PortmapTransport {
    NAT_PMP(portmap_transport.natpmp.swigValue()),
    UPNP(portmap_transport.upnp.swigValue());
    
    private final int swigValue;

    PortmapTransport(int i) {
        this.swigValue = i;
    }

    public int swig() {
        return this.swigValue;
    }

    public static PortmapTransport fromSwig(int i) {
        PortmapTransport[] portmapTransportArr;
        for (PortmapTransport portmapTransport : (PortmapTransport[]) PortmapTransport.class.getEnumConstants()) {
            if (portmapTransport.swig() == i) {
                return portmapTransport;
            }
        }
        throw new IllegalArgumentException("No enum " + PortmapTransport.class + " with value " + i);
    }
}
