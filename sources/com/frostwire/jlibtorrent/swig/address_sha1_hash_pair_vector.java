package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class address_sha1_hash_pair_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public address_sha1_hash_pair_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar) {
        if (address_sha1_hash_pair_vectorVar == null) {
            return 0L;
        }
        return address_sha1_hash_pair_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_address_sha1_hash_pair_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public address_sha1_hash_pair_vector() {
        this(libtorrent_jni.new_address_sha1_hash_pair_vector(), true);
    }

    public long size() {
        return libtorrent_jni.address_sha1_hash_pair_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.address_sha1_hash_pair_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.address_sha1_hash_pair_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.address_sha1_hash_pair_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.address_sha1_hash_pair_vector_clear(this.swigCPtr, this);
    }

    public void push_back(address_sha1_hash_pair address_sha1_hash_pairVar) {
        libtorrent_jni.address_sha1_hash_pair_vector_push_back(this.swigCPtr, this, address_sha1_hash_pair.getCPtr(address_sha1_hash_pairVar), address_sha1_hash_pairVar);
    }

    public address_sha1_hash_pair get(int i) {
        return new address_sha1_hash_pair(libtorrent_jni.address_sha1_hash_pair_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, address_sha1_hash_pair address_sha1_hash_pairVar) {
        libtorrent_jni.address_sha1_hash_pair_vector_set(this.swigCPtr, this, i, address_sha1_hash_pair.getCPtr(address_sha1_hash_pairVar), address_sha1_hash_pairVar);
    }
}
