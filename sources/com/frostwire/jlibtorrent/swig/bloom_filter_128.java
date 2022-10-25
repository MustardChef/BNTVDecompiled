package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class bloom_filter_128 {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected bloom_filter_128(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(bloom_filter_128 bloom_filter_128Var) {
        if (bloom_filter_128Var == null) {
            return 0L;
        }
        return bloom_filter_128Var.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_bloom_filter_128(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean find(sha1_hash sha1_hashVar) {
        return libtorrent_jni.bloom_filter_128_find(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void set(sha1_hash sha1_hashVar) {
        libtorrent_jni.bloom_filter_128_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void clear() {
        libtorrent_jni.bloom_filter_128_clear(this.swigCPtr, this);
    }

    public float size() {
        return libtorrent_jni.bloom_filter_128_size(this.swigCPtr, this);
    }

    public bloom_filter_128() {
        this(libtorrent_jni.new_bloom_filter_128(), true);
    }

    public byte_vector to_bytes() {
        return new byte_vector(libtorrent_jni.bloom_filter_128_to_bytes(this.swigCPtr, this), true);
    }

    public void from_bytes(byte_vector byte_vectorVar) {
        libtorrent_jni.bloom_filter_128_from_bytes(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }
}
