package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_routing_bucket_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_routing_bucket_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(dht_routing_bucket_vector dht_routing_bucket_vectorVar) {
        if (dht_routing_bucket_vectorVar == null) {
            return 0L;
        }
        return dht_routing_bucket_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_routing_bucket_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public dht_routing_bucket_vector() {
        this(libtorrent_jni.new_dht_routing_bucket_vector(), true);
    }

    public long size() {
        return libtorrent_jni.dht_routing_bucket_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.dht_routing_bucket_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.dht_routing_bucket_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.dht_routing_bucket_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.dht_routing_bucket_vector_clear(this.swigCPtr, this);
    }

    public void push_back(dht_routing_bucket dht_routing_bucketVar) {
        libtorrent_jni.dht_routing_bucket_vector_push_back(this.swigCPtr, this, dht_routing_bucket.getCPtr(dht_routing_bucketVar), dht_routing_bucketVar);
    }

    public dht_routing_bucket get(int i) {
        return new dht_routing_bucket(libtorrent_jni.dht_routing_bucket_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, dht_routing_bucket dht_routing_bucketVar) {
        libtorrent_jni.dht_routing_bucket_vector_set(this.swigCPtr, this, i, dht_routing_bucket.getCPtr(dht_routing_bucketVar), dht_routing_bucketVar);
    }
}
