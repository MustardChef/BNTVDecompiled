package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_info_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected peer_info_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(peer_info_vector peer_info_vectorVar) {
        if (peer_info_vectorVar == null) {
            return 0L;
        }
        return peer_info_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_info_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public peer_info_vector() {
        this(libtorrent_jni.new_peer_info_vector(), true);
    }

    public long size() {
        return libtorrent_jni.peer_info_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.peer_info_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.peer_info_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.peer_info_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.peer_info_vector_clear(this.swigCPtr, this);
    }

    public void push_back(peer_info peer_infoVar) {
        libtorrent_jni.peer_info_vector_push_back(this.swigCPtr, this, peer_info.getCPtr(peer_infoVar), peer_infoVar);
    }

    public peer_info get(int i) {
        return new peer_info(libtorrent_jni.peer_info_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, peer_info peer_infoVar) {
        libtorrent_jni.peer_info_vector_set(this.swigCPtr, this, i, peer_info.getCPtr(peer_infoVar), peer_infoVar);
    }
}
