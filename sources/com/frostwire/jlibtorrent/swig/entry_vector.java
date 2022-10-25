package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class entry_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public entry_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(entry_vector entry_vectorVar) {
        if (entry_vectorVar == null) {
            return 0L;
        }
        return entry_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_entry_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public entry_vector() {
        this(libtorrent_jni.new_entry_vector(), true);
    }

    public long size() {
        return libtorrent_jni.entry_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.entry_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.entry_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.entry_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.entry_vector_clear(this.swigCPtr, this);
    }

    public void push_back(entry entryVar) {
        libtorrent_jni.entry_vector_push_back(this.swigCPtr, this, entry.getCPtr(entryVar), entryVar);
    }

    public entry get(int i) {
        return new entry(libtorrent_jni.entry_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, entry entryVar) {
        libtorrent_jni.entry_vector_set(this.swigCPtr, this, i, entry.getCPtr(entryVar), entryVar);
    }
}
