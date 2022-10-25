package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.peer_connect_alert;

/* loaded from: classes2.dex */
public final class PeerConnectAlert extends PeerAlert<peer_connect_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerConnectAlert(peer_connect_alert peer_connect_alertVar) {
        super(peer_connect_alertVar);
    }

    public int socketType() {
        return ((peer_connect_alert) this.alert).getSocket_type();
    }
}
