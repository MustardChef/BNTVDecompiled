package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(string_vector string_vectorVar) {
        if (string_vectorVar == null) {
            return 0L;
        }
        return string_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public string_vector() {
        this(libtorrent_jni.new_string_vector(), true);
    }

    public long size() {
        return libtorrent_jni.string_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.string_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.string_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.string_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.string_vector_clear(this.swigCPtr, this);
    }

    public void push_back(String str) {
        libtorrent_jni.string_vector_push_back(this.swigCPtr, this, str);
    }

    public String get(int i) {
        return libtorrent_jni.string_vector_get(this.swigCPtr, this, i);
    }

    public void set(int i, String str) {
        libtorrent_jni.string_vector_set(this.swigCPtr, this, i, str);
    }
}
