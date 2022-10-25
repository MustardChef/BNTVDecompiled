package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.UdpEndpoint;
import com.frostwire.jlibtorrent.swig.udp_error_alert;

/* loaded from: classes2.dex */
public final class UdpErrorAlert extends AbstractAlert<udp_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UdpErrorAlert(udp_error_alert udp_error_alertVar) {
        super(udp_error_alertVar);
    }

    public UdpEndpoint endpoint() {
        return new UdpEndpoint(((udp_error_alert) this.alert).get_endpoint());
    }

    public Operation operation() {
        return Operation.fromSwig(((udp_error_alert) this.alert).getOperation());
    }

    public ErrorCode error() {
        return new ErrorCode(((udp_error_alert) this.alert).getError());
    }
}
