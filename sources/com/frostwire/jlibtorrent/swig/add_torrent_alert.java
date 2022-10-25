package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class add_torrent_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.add_torrent_alert_priority_get();
    public static final int alert_type = libtorrent_jni.add_torrent_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.add_torrent_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public add_torrent_alert(long j, boolean z) {
        super(libtorrent_jni.add_torrent_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(add_torrent_alert add_torrent_alertVar) {
        if (add_torrent_alertVar == null) {
            return 0L;
        }
        return add_torrent_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_add_torrent_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.add_torrent_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.add_torrent_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.add_torrent_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.add_torrent_alert_message(this.swigCPtr, this);
    }

    public void setParams(add_torrent_params add_torrent_paramsVar) {
        libtorrent_jni.add_torrent_alert_params_set(this.swigCPtr, this, add_torrent_params.getCPtr(add_torrent_paramsVar), add_torrent_paramsVar);
    }

    public add_torrent_params getParams() {
        long add_torrent_alert_params_get = libtorrent_jni.add_torrent_alert_params_get(this.swigCPtr, this);
        if (add_torrent_alert_params_get == 0) {
            return null;
        }
        return new add_torrent_params(add_torrent_alert_params_get, false);
    }

    public void setError(error_code error_codeVar) {
        libtorrent_jni.add_torrent_alert_error_set(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public error_code getError() {
        long add_torrent_alert_error_get = libtorrent_jni.add_torrent_alert_error_get(this.swigCPtr, this);
        if (add_torrent_alert_error_get == 0) {
            return null;
        }
        return new error_code(add_torrent_alert_error_get, false);
    }
}
