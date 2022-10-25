package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.dht_lookup;

/* loaded from: classes2.dex */
public final class DhtLookup {

    /* renamed from: l */
    private final dht_lookup f2809l;

    public DhtLookup(dht_lookup dht_lookupVar) {
        this.f2809l = dht_lookupVar;
    }

    public dht_lookup swig() {
        return this.f2809l;
    }

    public String type() {
        return this.f2809l.get_type();
    }

    public int outstandingRequests() {
        return this.f2809l.getOutstanding_requests();
    }

    public int timeouts() {
        return this.f2809l.getTimeouts();
    }

    public int responses() {
        return this.f2809l.getResponses();
    }

    public int branchFactor() {
        return this.f2809l.getBranch_factor();
    }

    public int nodesLeft() {
        return this.f2809l.getNodes_left();
    }

    public int lastSent() {
        return this.f2809l.getLast_sent();
    }

    public int firstTimeout() {
        return this.f2809l.getFirst_timeout();
    }

    public Sha1Hash target() {
        return new Sha1Hash(this.f2809l.getTarget());
    }
}
