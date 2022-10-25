package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.dht_routing_bucket;

/* loaded from: classes2.dex */
public final class DhtRoutingBucket {

    /* renamed from: t */
    private final dht_routing_bucket f2810t;

    public DhtRoutingBucket(dht_routing_bucket dht_routing_bucketVar) {
        this.f2810t = dht_routing_bucketVar;
    }

    public dht_routing_bucket swig() {
        return this.f2810t;
    }

    public int numNodes() {
        return this.f2810t.getNum_nodes();
    }

    public int numReplacements() {
        return this.f2810t.getNum_replacements();
    }

    public int lastActive() {
        return this.f2810t.getLast_active();
    }
}
