package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class piece_index_int_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public piece_index_int_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(piece_index_int_pair piece_index_int_pairVar) {
        if (piece_index_int_pairVar == null) {
            return 0L;
        }
        return piece_index_int_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_piece_index_int_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public piece_index_int_pair() {
        this(libtorrent_jni.new_piece_index_int_pair__SWIG_0(), true);
    }

    public piece_index_int_pair(int i, int i2) {
        this(libtorrent_jni.new_piece_index_int_pair__SWIG_1(i, i2), true);
    }

    public piece_index_int_pair(piece_index_int_pair piece_index_int_pairVar) {
        this(libtorrent_jni.new_piece_index_int_pair__SWIG_2(getCPtr(piece_index_int_pairVar), piece_index_int_pairVar), true);
    }

    public void setFirst(int i) {
        libtorrent_jni.piece_index_int_pair_first_set(this.swigCPtr, this, i);
    }

    public int getFirst() {
        return libtorrent_jni.piece_index_int_pair_first_get(this.swigCPtr, this);
    }

    public void setSecond(int i) {
        libtorrent_jni.piece_index_int_pair_second_set(this.swigCPtr, this, i);
    }

    public int getSecond() {
        return libtorrent_jni.piece_index_int_pair_second_get(this.swigCPtr, this);
    }
}
