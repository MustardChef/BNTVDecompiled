package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class byte_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public byte_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(byte_vector byte_vectorVar) {
        if (byte_vectorVar == null) {
            return 0L;
        }
        return byte_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_byte_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public byte_vector() {
        this(libtorrent_jni.new_byte_vector(), true);
    }

    public long size() {
        return libtorrent_jni.byte_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.byte_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.byte_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.byte_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.byte_vector_clear(this.swigCPtr, this);
    }

    public void push_back(byte b) {
        libtorrent_jni.byte_vector_push_back(this.swigCPtr, this, b);
    }

    public void resize(long j) {
        libtorrent_jni.byte_vector_resize(this.swigCPtr, this, j);
    }

    public byte get(int i) {
        return libtorrent_jni.byte_vector_get(this.swigCPtr, this, i);
    }

    public void set(int i, byte b) {
        libtorrent_jni.byte_vector_set(this.swigCPtr, this, i, b);
    }
}
