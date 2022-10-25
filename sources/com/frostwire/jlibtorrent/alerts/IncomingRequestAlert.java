package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.PeerRequest;
import com.frostwire.jlibtorrent.swig.incoming_request_alert;

/* loaded from: classes2.dex */
public final class IncomingRequestAlert extends PeerAlert<incoming_request_alert> {
    public IncomingRequestAlert(incoming_request_alert incoming_request_alertVar) {
        super(incoming_request_alertVar);
    }

    public PeerRequest request() {
        return new PeerRequest(((incoming_request_alert) this.alert).getReq());
    }
}
