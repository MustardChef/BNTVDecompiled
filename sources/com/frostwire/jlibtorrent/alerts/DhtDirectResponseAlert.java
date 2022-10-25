package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.BDecodeNode;
import com.frostwire.jlibtorrent.UdpEndpoint;
import com.frostwire.jlibtorrent.swig.dht_direct_response_alert;

/* loaded from: classes2.dex */
public final class DhtDirectResponseAlert extends AbstractAlert<dht_direct_response_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtDirectResponseAlert(dht_direct_response_alert dht_direct_response_alertVar) {
        super(dht_direct_response_alertVar);
    }

    public long userdata() {
        return ((dht_direct_response_alert) this.alert).get_userdata();
    }

    public UdpEndpoint endpoint() {
        return new UdpEndpoint(((dht_direct_response_alert) this.alert).get_endpoint());
    }

    public BDecodeNode response() {
        return new BDecodeNode(((dht_direct_response_alert) this.alert).response());
    }
}
