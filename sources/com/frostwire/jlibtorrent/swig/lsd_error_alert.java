package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class lsd_error_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.lsd_error_alert_priority_get();
    public static final int alert_type = libtorrent_jni.lsd_error_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.lsd_error_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public lsd_error_alert(long j, boolean z) {
        super(libtorrent_jni.lsd_error_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(lsd_error_alert lsd_error_alertVar) {
        if (lsd_error_alertVar == null) {
            return 0L;
        }
        return lsd_error_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_lsd_error_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.lsd_error_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.lsd_error_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.lsd_error_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.lsd_error_alert_message(this.swigCPtr, this);
    }

    public void setError(error_code error_codeVar) {
        libtorrent_jni.lsd_error_alert_error_set(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public error_code getError() {
        long lsd_error_alert_error_get = libtorrent_jni.lsd_error_alert_error_get(this.swigCPtr, this);
        if (lsd_error_alert_error_get == 0) {
            return null;
        }
        return new error_code(lsd_error_alert_error_get, false);
    }
}
