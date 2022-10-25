package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.PortmapTransport;
import com.frostwire.jlibtorrent.swig.portmap_error_alert;

/* loaded from: classes2.dex */
public final class PortmapErrorAlert extends AbstractAlert<portmap_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PortmapErrorAlert(portmap_error_alert portmap_error_alertVar) {
        super(portmap_error_alertVar);
    }

    public int mapping() {
        return ((portmap_error_alert) this.alert).getMapping();
    }

    public PortmapTransport mapTransport() {
        return PortmapTransport.fromSwig(((portmap_error_alert) this.alert).getMap_transport().swigValue());
    }

    public ErrorCode error() {
        return new ErrorCode(((portmap_error_alert) this.alert).getError());
    }
}
