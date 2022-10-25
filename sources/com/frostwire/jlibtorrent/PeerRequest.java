package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.peer_request;

/* loaded from: classes2.dex */
public final class PeerRequest {

    /* renamed from: r */
    private final peer_request f2821r;

    public PeerRequest(peer_request peer_requestVar) {
        this.f2821r = peer_requestVar;
    }

    public peer_request swig() {
        return this.f2821r;
    }

    public int piece() {
        return this.f2821r.getPiece();
    }

    public int start() {
        return this.f2821r.getStart();
    }

    public int length() {
        return this.f2821r.getLength();
    }

    public String toString() {
        return "PeerRequest(piece: " + piece() + ", start: " + start() + ", length: " + length() + ")";
    }
}
