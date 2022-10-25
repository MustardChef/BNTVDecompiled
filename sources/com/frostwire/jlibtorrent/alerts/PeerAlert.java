package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.TcpEndpoint;
import com.frostwire.jlibtorrent.swig.peer_alert;

/* loaded from: classes2.dex */
public class PeerAlert<T extends peer_alert> extends TorrentAlert<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerAlert(T t) {
        super(t);
    }

    public TcpEndpoint endpoint() {
        return new TcpEndpoint(((peer_alert) this.alert).get_endpoint());
    }

    public Sha1Hash peerId() {
        return new Sha1Hash(((peer_alert) this.alert).getPid());
    }
}
