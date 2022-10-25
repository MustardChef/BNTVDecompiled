package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.PortmapProtocol;
import com.frostwire.jlibtorrent.PortmapTransport;
import com.frostwire.jlibtorrent.swig.portmap_alert;

/* loaded from: classes2.dex */
public final class PortmapAlert extends AbstractAlert<portmap_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PortmapAlert(portmap_alert portmap_alertVar) {
        super(portmap_alertVar);
    }

    public int mapping() {
        return ((portmap_alert) this.alert).getMapping();
    }

    public int externalPort() {
        return ((portmap_alert) this.alert).getExternal_port();
    }

    public PortmapTransport mapTransport() {
        return PortmapTransport.fromSwig(((portmap_alert) this.alert).getMap_transport().swigValue());
    }

    public PortmapProtocol mapProtocol() {
        return PortmapProtocol.fromSwig(((portmap_alert) this.alert).getMap_protocol().swigValue());
    }
}
