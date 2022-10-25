package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class portmap_log_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.portmap_log_alert_priority_get();
    public static final int alert_type = libtorrent_jni.portmap_log_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.portmap_log_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public portmap_log_alert(long j, boolean z) {
        super(libtorrent_jni.portmap_log_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(portmap_log_alert portmap_log_alertVar) {
        if (portmap_log_alertVar == null) {
            return 0L;
        }
        return portmap_log_alertVar.swigCPtr;
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
                libtorrent_jni.delete_portmap_log_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.portmap_log_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.portmap_log_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.portmap_log_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.portmap_log_alert_message(this.swigCPtr, this);
    }

    public portmap_transport getMap_transport() {
        return portmap_transport.swigToEnum(libtorrent_jni.portmap_log_alert_map_transport_get(this.swigCPtr, this));
    }

    public String log_message() {
        return libtorrent_jni.portmap_log_alert_log_message(this.swigCPtr, this);
    }
}
