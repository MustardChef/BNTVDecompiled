package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class file_index_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public file_index_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(file_index_vector file_index_vectorVar) {
        if (file_index_vectorVar == null) {
            return 0L;
        }
        return file_index_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_file_index_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public file_index_vector() {
        this(libtorrent_jni.new_file_index_vector(), true);
    }

    public long size() {
        return libtorrent_jni.file_index_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.file_index_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.file_index_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.file_index_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.file_index_vector_clear(this.swigCPtr, this);
    }

    public void push_back(int i) {
        libtorrent_jni.file_index_vector_push_back(this.swigCPtr, this, i);
    }

    public int get(int i) {
        return libtorrent_jni.file_index_vector_get(this.swigCPtr, this, i);
    }

    public void set(int i, int i2) {
        libtorrent_jni.file_index_vector_set(this.swigCPtr, this, i, i2);
    }
}
