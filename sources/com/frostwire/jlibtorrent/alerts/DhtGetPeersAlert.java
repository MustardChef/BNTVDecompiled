package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.swig.dht_get_peers_alert;

/* loaded from: classes2.dex */
public final class DhtGetPeersAlert extends AbstractAlert<dht_get_peers_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtGetPeersAlert(dht_get_peers_alert dht_get_peers_alertVar) {
        super(dht_get_peers_alertVar);
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(((dht_get_peers_alert) this.alert).getInfo_hash());
    }
}
