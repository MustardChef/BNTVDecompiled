package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class alert_category_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public alert_category_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(alert_category_t alert_category_tVar) {
        if (alert_category_tVar == null) {
            return 0L;
        }
        return alert_category_tVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_alert_category_t(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static alert_category_t all() {
        return new alert_category_t(libtorrent_jni.alert_category_t_all(), true);
    }

    public boolean nonZero() {
        return libtorrent_jni.alert_category_t_nonZero(this.swigCPtr, this);
    }

    /* renamed from: eq */
    public boolean m6055eq(alert_category_t alert_category_tVar) {
        return libtorrent_jni.alert_category_t_eq(this.swigCPtr, this, getCPtr(alert_category_tVar), alert_category_tVar);
    }

    /* renamed from: ne */
    public boolean m6054ne(alert_category_t alert_category_tVar) {
        return libtorrent_jni.alert_category_t_ne(this.swigCPtr, this, getCPtr(alert_category_tVar), alert_category_tVar);
    }

    public alert_category_t or_(alert_category_t alert_category_tVar) {
        return new alert_category_t(libtorrent_jni.alert_category_t_or_(this.swigCPtr, this, getCPtr(alert_category_tVar), alert_category_tVar), true);
    }

    public alert_category_t and_(alert_category_t alert_category_tVar) {
        return new alert_category_t(libtorrent_jni.alert_category_t_and_(this.swigCPtr, this, getCPtr(alert_category_tVar), alert_category_tVar), true);
    }

    public alert_category_t xor(alert_category_t alert_category_tVar) {
        return new alert_category_t(libtorrent_jni.alert_category_t_xor(this.swigCPtr, this, getCPtr(alert_category_tVar), alert_category_tVar), true);
    }

    public alert_category_t inv() {
        return new alert_category_t(libtorrent_jni.alert_category_t_inv(this.swigCPtr, this), true);
    }

    public int to_int() {
        return libtorrent_jni.alert_category_t_to_int(this.swigCPtr, this);
    }

    public alert_category_t() {
        this(libtorrent_jni.new_alert_category_t(), true);
    }
}
