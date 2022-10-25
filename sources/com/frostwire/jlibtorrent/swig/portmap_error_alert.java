package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class portmap_error_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.portmap_error_alert_priority_get();
    public static final int alert_type = libtorrent_jni.portmap_error_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.portmap_error_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public portmap_error_alert(long j, boolean z) {
        super(libtorrent_jni.portmap_error_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(portmap_error_alert portmap_error_alertVar) {
        if (portmap_error_alertVar == null) {
            return 0L;
        }
        return portmap_error_alertVar.swigCPtr;
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
                libtorrent_jni.delete_portmap_error_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.portmap_error_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.portmap_error_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.portmap_error_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.portmap_error_alert_message(this.swigCPtr, this);
    }

    public int getMapping() {
        return libtorrent_jni.portmap_error_alert_mapping_get(this.swigCPtr, this);
    }

    public void setMap_transport(portmap_transport portmap_transportVar) {
        libtorrent_jni.portmap_error_alert_map_transport_set(this.swigCPtr, this, portmap_transportVar.swigValue());
    }

    public portmap_transport getMap_transport() {
        return portmap_transport.swigToEnum(libtorrent_jni.portmap_error_alert_map_transport_get(this.swigCPtr, this));
    }

    public error_code getError() {
        long portmap_error_alert_error_get = libtorrent_jni.portmap_error_alert_error_get(this.swigCPtr, this);
        if (portmap_error_alert_error_get == 0) {
            return null;
        }
        return new error_code(portmap_error_alert_error_get, false);
    }
}
