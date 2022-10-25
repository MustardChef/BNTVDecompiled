package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class alerts_dropped_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.alerts_dropped_alert_priority_get();
    public static final int alert_type = libtorrent_jni.alerts_dropped_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.alerts_dropped_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public alerts_dropped_alert(long j, boolean z) {
        super(libtorrent_jni.alerts_dropped_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(alerts_dropped_alert alerts_dropped_alertVar) {
        if (alerts_dropped_alertVar == null) {
            return 0L;
        }
        return alerts_dropped_alertVar.swigCPtr;
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
                libtorrent_jni.delete_alerts_dropped_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.alerts_dropped_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.alerts_dropped_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.alerts_dropped_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.alerts_dropped_alert_message(this.swigCPtr, this);
    }

    public void setDropped_alerts(SWIGTYPE_p_std__bitsetT_97_t sWIGTYPE_p_std__bitsetT_97_t) {
        libtorrent_jni.alerts_dropped_alert_dropped_alerts_set(this.swigCPtr, this, SWIGTYPE_p_std__bitsetT_97_t.getCPtr(sWIGTYPE_p_std__bitsetT_97_t));
    }

    public SWIGTYPE_p_std__bitsetT_97_t getDropped_alerts() {
        long alerts_dropped_alert_dropped_alerts_get = libtorrent_jni.alerts_dropped_alert_dropped_alerts_get(this.swigCPtr, this);
        if (alerts_dropped_alert_dropped_alerts_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__bitsetT_97_t(alerts_dropped_alert_dropped_alerts_get, false);
    }
}
