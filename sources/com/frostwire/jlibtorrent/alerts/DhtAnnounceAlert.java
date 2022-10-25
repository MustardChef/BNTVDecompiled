package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Address;
import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.swig.dht_announce_alert;

/* loaded from: classes2.dex */
public final class DhtAnnounceAlert extends AbstractAlert<dht_announce_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtAnnounceAlert(dht_announce_alert dht_announce_alertVar) {
        super(dht_announce_alertVar);
    }

    /* renamed from: ip */
    public Address m6058ip() {
        return new Address(((dht_announce_alert) this.alert).get_ip());
    }

    public int port() {
        return ((dht_announce_alert) this.alert).getPort();
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(((dht_announce_alert) this.alert).getInfo_hash());
    }
}
