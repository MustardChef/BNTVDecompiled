package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.swig.peer_disconnected_alert;

/* loaded from: classes2.dex */
public final class PeerDisconnectedAlert extends PeerAlert<peer_disconnected_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerDisconnectedAlert(peer_disconnected_alert peer_disconnected_alertVar) {
        super(peer_disconnected_alertVar);
    }

    public int socketType() {
        return ((peer_disconnected_alert) this.alert).getSocket_type();
    }

    public Operation operation() {
        return Operation.fromSwig(((peer_disconnected_alert) this.alert).getOp());
    }

    public ErrorCode error() {
        return new ErrorCode(((peer_disconnected_alert) this.alert).getError());
    }

    public CloseReason reason() {
        return CloseReason.fromSwig(((peer_disconnected_alert) this.alert).getReason().swigValue());
    }
}
