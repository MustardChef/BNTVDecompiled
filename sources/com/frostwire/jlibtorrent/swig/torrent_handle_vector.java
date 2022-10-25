package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class torrent_handle_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public torrent_handle_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(torrent_handle_vector torrent_handle_vectorVar) {
        if (torrent_handle_vectorVar == null) {
            return 0L;
        }
        return torrent_handle_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_torrent_handle_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public torrent_handle_vector() {
        this(libtorrent_jni.new_torrent_handle_vector(), true);
    }

    public long size() {
        return libtorrent_jni.torrent_handle_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.torrent_handle_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.torrent_handle_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.torrent_handle_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.torrent_handle_vector_clear(this.swigCPtr, this);
    }

    public void push_back(torrent_handle torrent_handleVar) {
        libtorrent_jni.torrent_handle_vector_push_back(this.swigCPtr, this, torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar);
    }

    public torrent_handle get(int i) {
        return new torrent_handle(libtorrent_jni.torrent_handle_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, torrent_handle torrent_handleVar) {
        libtorrent_jni.torrent_handle_vector_set(this.swigCPtr, this, i, torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar);
    }
}
