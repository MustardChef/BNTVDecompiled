package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.dht_reply_alert;

/* loaded from: classes2.dex */
public final class DhtReplyAlert extends TrackerAlert<dht_reply_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtReplyAlert(dht_reply_alert dht_reply_alertVar) {
        super(dht_reply_alertVar);
    }

    public int numPeers() {
        return ((dht_reply_alert) this.alert).getNum_peers();
    }
}
