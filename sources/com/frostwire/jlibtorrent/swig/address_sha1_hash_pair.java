package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class address_sha1_hash_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public address_sha1_hash_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(address_sha1_hash_pair address_sha1_hash_pairVar) {
        if (address_sha1_hash_pairVar == null) {
            return 0L;
        }
        return address_sha1_hash_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_address_sha1_hash_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public address_sha1_hash_pair() {
        this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_0(), true);
    }

    public address_sha1_hash_pair(address addressVar, sha1_hash sha1_hashVar) {
        this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_1(address.getCPtr(addressVar), addressVar, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar), true);
    }

    public address_sha1_hash_pair(address_sha1_hash_pair address_sha1_hash_pairVar) {
        this(libtorrent_jni.new_address_sha1_hash_pair__SWIG_2(getCPtr(address_sha1_hash_pairVar), address_sha1_hash_pairVar), true);
    }

    public void setFirst(address addressVar) {
        libtorrent_jni.address_sha1_hash_pair_first_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getFirst() {
        long address_sha1_hash_pair_first_get = libtorrent_jni.address_sha1_hash_pair_first_get(this.swigCPtr, this);
        if (address_sha1_hash_pair_first_get == 0) {
            return null;
        }
        return new address(address_sha1_hash_pair_first_get, false);
    }

    public void setSecond(sha1_hash sha1_hashVar) {
        libtorrent_jni.address_sha1_hash_pair_second_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getSecond() {
        long address_sha1_hash_pair_second_get = libtorrent_jni.address_sha1_hash_pair_second_get(this.swigCPtr, this);
        if (address_sha1_hash_pair_second_get == 0) {
            return null;
        }
        return new sha1_hash(address_sha1_hash_pair_second_get, false);
    }
}
