package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class byte_vectors_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public byte_vectors_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(byte_vectors_pair byte_vectors_pairVar) {
        if (byte_vectors_pairVar == null) {
            return 0L;
        }
        return byte_vectors_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_byte_vectors_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public byte_vectors_pair() {
        this(libtorrent_jni.new_byte_vectors_pair__SWIG_0(), true);
    }

    public byte_vectors_pair(byte_vector byte_vectorVar, byte_vector byte_vectorVar2) {
        this(libtorrent_jni.new_byte_vectors_pair__SWIG_1(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2), true);
    }

    public byte_vectors_pair(byte_vectors_pair byte_vectors_pairVar) {
        this(libtorrent_jni.new_byte_vectors_pair__SWIG_2(getCPtr(byte_vectors_pairVar), byte_vectors_pairVar), true);
    }

    public void setFirst(byte_vector byte_vectorVar) {
        libtorrent_jni.byte_vectors_pair_first_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getFirst() {
        long byte_vectors_pair_first_get = libtorrent_jni.byte_vectors_pair_first_get(this.swigCPtr, this);
        if (byte_vectors_pair_first_get == 0) {
            return null;
        }
        return new byte_vector(byte_vectors_pair_first_get, false);
    }

    public void setSecond(byte_vector byte_vectorVar) {
        libtorrent_jni.byte_vectors_pair_second_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getSecond() {
        long byte_vectors_pair_second_get = libtorrent_jni.byte_vectors_pair_second_get(this.swigCPtr, this);
        if (byte_vectors_pair_second_get == 0) {
            return null;
        }
        return new byte_vector(byte_vectors_pair_second_get, false);
    }
}
