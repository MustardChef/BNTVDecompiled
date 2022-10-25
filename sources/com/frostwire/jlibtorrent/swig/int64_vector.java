package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class int64_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected int64_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(int64_vector int64_vectorVar) {
        if (int64_vectorVar == null) {
            return 0L;
        }
        return int64_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_int64_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public int64_vector() {
        this(libtorrent_jni.new_int64_vector(), true);
    }

    public long size() {
        return libtorrent_jni.int64_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.int64_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.int64_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.int64_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.int64_vector_clear(this.swigCPtr, this);
    }

    public void push_back(long j) {
        libtorrent_jni.int64_vector_push_back(this.swigCPtr, this, j);
    }

    public long get(int i) {
        return libtorrent_jni.int64_vector_get(this.swigCPtr, this, i);
    }

    public void set(int i, long j) {
        libtorrent_jni.int64_vector_set(this.swigCPtr, this, i, j);
    }
}
