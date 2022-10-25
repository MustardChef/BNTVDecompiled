package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_lookup_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_lookup_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(dht_lookup_vector dht_lookup_vectorVar) {
        if (dht_lookup_vectorVar == null) {
            return 0L;
        }
        return dht_lookup_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_lookup_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public dht_lookup_vector() {
        this(libtorrent_jni.new_dht_lookup_vector(), true);
    }

    public long size() {
        return libtorrent_jni.dht_lookup_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.dht_lookup_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.dht_lookup_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.dht_lookup_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.dht_lookup_vector_clear(this.swigCPtr, this);
    }

    public void push_back(dht_lookup dht_lookupVar) {
        libtorrent_jni.dht_lookup_vector_push_back(this.swigCPtr, this, dht_lookup.getCPtr(dht_lookupVar), dht_lookupVar);
    }

    public dht_lookup get(int i) {
        return new dht_lookup(libtorrent_jni.dht_lookup_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, dht_lookup dht_lookupVar) {
        libtorrent_jni.dht_lookup_vector_set(this.swigCPtr, this, i, dht_lookup.getCPtr(dht_lookupVar), dht_lookupVar);
    }
}
