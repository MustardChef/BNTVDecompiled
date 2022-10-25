package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class add_piece_flags_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public add_piece_flags_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(add_piece_flags_t add_piece_flags_tVar) {
        if (add_piece_flags_tVar == null) {
            return 0L;
        }
        return add_piece_flags_tVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_add_piece_flags_t(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static add_piece_flags_t all() {
        return new add_piece_flags_t(libtorrent_jni.add_piece_flags_t_all(), true);
    }

    public boolean nonZero() {
        return libtorrent_jni.add_piece_flags_t_nonZero(this.swigCPtr, this);
    }

    /* renamed from: eq */
    public boolean m6057eq(add_piece_flags_t add_piece_flags_tVar) {
        return libtorrent_jni.add_piece_flags_t_eq(this.swigCPtr, this, getCPtr(add_piece_flags_tVar), add_piece_flags_tVar);
    }

    /* renamed from: ne */
    public boolean m6056ne(add_piece_flags_t add_piece_flags_tVar) {
        return libtorrent_jni.add_piece_flags_t_ne(this.swigCPtr, this, getCPtr(add_piece_flags_tVar), add_piece_flags_tVar);
    }

    public add_piece_flags_t or_(add_piece_flags_t add_piece_flags_tVar) {
        return new add_piece_flags_t(libtorrent_jni.add_piece_flags_t_or_(this.swigCPtr, this, getCPtr(add_piece_flags_tVar), add_piece_flags_tVar), true);
    }

    public add_piece_flags_t and_(add_piece_flags_t add_piece_flags_tVar) {
        return new add_piece_flags_t(libtorrent_jni.add_piece_flags_t_and_(this.swigCPtr, this, getCPtr(add_piece_flags_tVar), add_piece_flags_tVar), true);
    }

    public add_piece_flags_t xor(add_piece_flags_t add_piece_flags_tVar) {
        return new add_piece_flags_t(libtorrent_jni.add_piece_flags_t_xor(this.swigCPtr, this, getCPtr(add_piece_flags_tVar), add_piece_flags_tVar), true);
    }

    public add_piece_flags_t inv() {
        return new add_piece_flags_t(libtorrent_jni.add_piece_flags_t_inv(this.swigCPtr, this), true);
    }

    public int to_int() {
        return libtorrent_jni.add_piece_flags_t_to_int(this.swigCPtr, this);
    }

    public add_piece_flags_t() {
        this(libtorrent_jni.new_add_piece_flags_t(), true);
    }
}
