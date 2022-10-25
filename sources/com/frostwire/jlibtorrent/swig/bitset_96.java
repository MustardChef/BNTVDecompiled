package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class bitset_96 {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected bitset_96(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(bitset_96 bitset_96Var) {
        if (bitset_96Var == null) {
            return 0L;
        }
        return bitset_96Var.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_bitset_96(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean test(long j) {
        return libtorrent_jni.bitset_96_test(this.swigCPtr, this, j);
    }

    public boolean all() {
        return libtorrent_jni.bitset_96_all(this.swigCPtr, this);
    }

    public boolean any() {
        return libtorrent_jni.bitset_96_any(this.swigCPtr, this);
    }

    public boolean none() {
        return libtorrent_jni.bitset_96_none(this.swigCPtr, this);
    }

    public long count() {
        return libtorrent_jni.bitset_96_count(this.swigCPtr, this);
    }

    public long size() {
        return libtorrent_jni.bitset_96_size(this.swigCPtr, this);
    }

    public boolean get(long j) {
        return libtorrent_jni.bitset_96_get(this.swigCPtr, this, j);
    }

    public bitset_96() {
        this(libtorrent_jni.new_bitset_96(), true);
    }
}
