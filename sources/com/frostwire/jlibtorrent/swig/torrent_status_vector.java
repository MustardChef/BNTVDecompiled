package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class torrent_status_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public torrent_status_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(torrent_status_vector torrent_status_vectorVar) {
        if (torrent_status_vectorVar == null) {
            return 0L;
        }
        return torrent_status_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_torrent_status_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public torrent_status_vector() {
        this(libtorrent_jni.new_torrent_status_vector(), true);
    }

    public long size() {
        return libtorrent_jni.torrent_status_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.torrent_status_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.torrent_status_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.torrent_status_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.torrent_status_vector_clear(this.swigCPtr, this);
    }

    public void push_back(torrent_status torrent_statusVar) {
        libtorrent_jni.torrent_status_vector_push_back(this.swigCPtr, this, torrent_status.getCPtr(torrent_statusVar), torrent_statusVar);
    }

    public torrent_status get(int i) {
        return new torrent_status(libtorrent_jni.torrent_status_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, torrent_status torrent_statusVar) {
        libtorrent_jni.torrent_status_vector_set(this.swigCPtr, this, i, torrent_status.getCPtr(torrent_statusVar), torrent_statusVar);
    }
}
