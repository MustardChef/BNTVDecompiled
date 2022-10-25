package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.announce_endpoint_vector;
import com.frostwire.jlibtorrent.swig.announce_entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AnnounceEntry {

    /* renamed from: e */
    private final announce_entry f2806e;

    public AnnounceEntry(announce_entry announce_entryVar) {
        this.f2806e = announce_entryVar;
    }

    public AnnounceEntry(String str) {
        this(new announce_entry(Vectors.ascii2byte_vector(str)));
    }

    public announce_entry swig() {
        return this.f2806e;
    }

    public List<AnnounceEndpoint> endpoints() {
        announce_endpoint_vector endpoints = this.f2806e.getEndpoints();
        int size = (int) endpoints.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new AnnounceEndpoint(endpoints.get(i)));
        }
        return arrayList;
    }

    public String url() {
        return Vectors.byte_vector2ascii(this.f2806e.get_url());
    }

    public void url(String str) {
        this.f2806e.set_url(Vectors.ascii2byte_vector(str));
    }

    public String trackerId() {
        return Vectors.byte_vector2ascii(this.f2806e.get_trackerid());
    }

    public void trackerId(String str) {
        this.f2806e.set_trackerid(Vectors.ascii2byte_vector(str));
    }

    public int tier() {
        return this.f2806e.getTier();
    }

    public void tier(short s) {
        this.f2806e.setTier(s);
    }

    public int failLimit() {
        return this.f2806e.getFail_limit();
    }

    public void failLimit(short s) {
        this.f2806e.setFail_limit(s);
    }

    public int source() {
        return this.f2806e.getSource();
    }

    public boolean isVerified() {
        return this.f2806e.getVerified();
    }
}
