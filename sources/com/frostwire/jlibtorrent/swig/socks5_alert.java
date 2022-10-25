package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class socks5_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.socks5_alert_priority_get();
    public static final int alert_type = libtorrent_jni.socks5_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.socks5_alert_static_category_get(), false);

    protected socks5_alert(long j, boolean z) {
        super(libtorrent_jni.socks5_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(socks5_alert socks5_alertVar) {
        if (socks5_alertVar == null) {
            return 0L;
        }
        return socks5_alertVar.swigCPtr;
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
                libtorrent_jni.delete_socks5_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.socks5_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.socks5_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.socks5_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.socks5_alert_message(this.swigCPtr, this);
    }

    public void setError(error_code error_codeVar) {
        libtorrent_jni.socks5_alert_error_set(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public error_code getError() {
        long socks5_alert_error_get = libtorrent_jni.socks5_alert_error_get(this.swigCPtr, this);
        if (socks5_alert_error_get == 0) {
            return null;
        }
        return new error_code(socks5_alert_error_get, false);
    }

    public void setOp(operation_t operation_tVar) {
        libtorrent_jni.socks5_alert_op_set(this.swigCPtr, this, operation_tVar.swigValue());
    }

    public operation_t getOp() {
        return operation_t.swigToEnum(libtorrent_jni.socks5_alert_op_get(this.swigCPtr, this));
    }

    public void setIp(C2429x843b1605 c2429x843b1605) {
        libtorrent_jni.socks5_alert_ip_set(this.swigCPtr, this, C2429x843b1605.getCPtr(c2429x843b1605));
    }

    public C2429x843b1605 getIp() {
        long socks5_alert_ip_get = libtorrent_jni.socks5_alert_ip_get(this.swigCPtr, this);
        if (socks5_alert_ip_get == 0) {
            return null;
        }
        return new C2429x843b1605(socks5_alert_ip_get, false);
    }
}
