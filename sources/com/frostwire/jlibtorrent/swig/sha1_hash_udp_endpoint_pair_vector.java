package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class sha1_hash_udp_endpoint_pair_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public sha1_hash_udp_endpoint_pair_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar) {
        if (sha1_hash_udp_endpoint_pair_vectorVar == null) {
            return 0L;
        }
        return sha1_hash_udp_endpoint_pair_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_sha1_hash_udp_endpoint_pair_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public sha1_hash_udp_endpoint_pair_vector() {
        this(libtorrent_jni.new_sha1_hash_udp_endpoint_pair_vector(), true);
    }

    public long size() {
        return libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_clear(this.swigCPtr, this);
    }

    public void push_back(sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar) {
        libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_push_back(this.swigCPtr, this, sha1_hash_udp_endpoint_pair.getCPtr(sha1_hash_udp_endpoint_pairVar), sha1_hash_udp_endpoint_pairVar);
    }

    public sha1_hash_udp_endpoint_pair get(int i) {
        return new sha1_hash_udp_endpoint_pair(libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar) {
        libtorrent_jni.sha1_hash_udp_endpoint_pair_vector_set(this.swigCPtr, this, i, sha1_hash_udp_endpoint_pair.getCPtr(sha1_hash_udp_endpoint_pairVar), sha1_hash_udp_endpoint_pairVar);
    }
}
