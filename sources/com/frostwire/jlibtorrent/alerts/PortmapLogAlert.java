package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.PortmapTransport;
import com.frostwire.jlibtorrent.swig.portmap_log_alert;

/* loaded from: classes2.dex */
public final class PortmapLogAlert extends AbstractAlert<portmap_log_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PortmapLogAlert(portmap_log_alert portmap_log_alertVar) {
        super(portmap_log_alertVar);
    }

    public PortmapTransport mapType() {
        return PortmapTransport.fromSwig(((portmap_log_alert) this.alert).getMap_transport().swigValue());
    }

    public String logMessage() {
        return ((portmap_log_alert) this.alert).log_message();
    }
}
