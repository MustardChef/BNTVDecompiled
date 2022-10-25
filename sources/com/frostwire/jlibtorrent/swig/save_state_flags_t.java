package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class save_state_flags_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public save_state_flags_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(save_state_flags_t save_state_flags_tVar) {
        if (save_state_flags_tVar == null) {
            return 0L;
        }
        return save_state_flags_tVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_save_state_flags_t(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static save_state_flags_t all() {
        return new save_state_flags_t(libtorrent_jni.save_state_flags_t_all(), true);
    }

    public boolean nonZero() {
        return libtorrent_jni.save_state_flags_t_nonZero(this.swigCPtr, this);
    }

    /* renamed from: eq */
    public boolean m6026eq(save_state_flags_t save_state_flags_tVar) {
        return libtorrent_jni.save_state_flags_t_eq(this.swigCPtr, this, getCPtr(save_state_flags_tVar), save_state_flags_tVar);
    }

    /* renamed from: ne */
    public boolean m6025ne(save_state_flags_t save_state_flags_tVar) {
        return libtorrent_jni.save_state_flags_t_ne(this.swigCPtr, this, getCPtr(save_state_flags_tVar), save_state_flags_tVar);
    }

    public save_state_flags_t or_(save_state_flags_t save_state_flags_tVar) {
        return new save_state_flags_t(libtorrent_jni.save_state_flags_t_or_(this.swigCPtr, this, getCPtr(save_state_flags_tVar), save_state_flags_tVar), true);
    }

    public save_state_flags_t and_(save_state_flags_t save_state_flags_tVar) {
        return new save_state_flags_t(libtorrent_jni.save_state_flags_t_and_(this.swigCPtr, this, getCPtr(save_state_flags_tVar), save_state_flags_tVar), true);
    }

    public save_state_flags_t xor(save_state_flags_t save_state_flags_tVar) {
        return new save_state_flags_t(libtorrent_jni.save_state_flags_t_xor(this.swigCPtr, this, getCPtr(save_state_flags_tVar), save_state_flags_tVar), true);
    }

    public save_state_flags_t inv() {
        return new save_state_flags_t(libtorrent_jni.save_state_flags_t_inv(this.swigCPtr, this), true);
    }

    public int to_int() {
        return libtorrent_jni.save_state_flags_t_to_int(this.swigCPtr, this);
    }

    public save_state_flags_t() {
        this(libtorrent_jni.new_save_state_flags_t(), true);
    }
}
