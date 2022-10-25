package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.UdpEndpoint;
import com.frostwire.jlibtorrent.swig.dht_outgoing_get_peers_alert;

/* loaded from: classes2.dex */
public final class DhtOutgoingGetPeersAlert extends AbstractAlert<dht_outgoing_get_peers_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtOutgoingGetPeersAlert(dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar) {
        super(dht_outgoing_get_peers_alertVar);
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(((dht_outgoing_get_peers_alert) this.alert).getInfo_hash());
    }

    public Sha1Hash obfuscatedInfoHash() {
        return new Sha1Hash(((dht_outgoing_get_peers_alert) this.alert).getObfuscated_info_hash());
    }

    public UdpEndpoint endpoint() {
        return new UdpEndpoint(((dht_outgoing_get_peers_alert) this.alert).get_endpoint());
    }
}
