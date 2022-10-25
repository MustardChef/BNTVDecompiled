package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_request {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_request(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(peer_request peer_requestVar) {
        if (peer_requestVar == null) {
            return 0L;
        }
        return peer_requestVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_request(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPiece(int i) {
        libtorrent_jni.peer_request_piece_set(this.swigCPtr, this, i);
    }

    public int getPiece() {
        return libtorrent_jni.peer_request_piece_get(this.swigCPtr, this);
    }

    public void setStart(int i) {
        libtorrent_jni.peer_request_start_set(this.swigCPtr, this, i);
    }

    public int getStart() {
        return libtorrent_jni.peer_request_start_get(this.swigCPtr, this);
    }

    public void setLength(int i) {
        libtorrent_jni.peer_request_length_set(this.swigCPtr, this, i);
    }

    public int getLength() {
        return libtorrent_jni.peer_request_length_get(this.swigCPtr, this);
    }

    public boolean op_eq(peer_request peer_requestVar) {
        return libtorrent_jni.peer_request_op_eq(this.swigCPtr, this, getCPtr(peer_requestVar), peer_requestVar);
    }

    public peer_request() {
        this(libtorrent_jni.new_peer_request(), true);
    }
}
