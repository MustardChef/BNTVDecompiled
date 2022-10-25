package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class state_update_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.state_update_alert_priority_get();
    public static final int alert_type = libtorrent_jni.state_update_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.state_update_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public state_update_alert(long j, boolean z) {
        super(libtorrent_jni.state_update_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(state_update_alert state_update_alertVar) {
        if (state_update_alertVar == null) {
            return 0L;
        }
        return state_update_alertVar.swigCPtr;
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
                libtorrent_jni.delete_state_update_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.state_update_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.state_update_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.state_update_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.state_update_alert_message(this.swigCPtr, this);
    }

    public void setStatus(torrent_status_vector torrent_status_vectorVar) {
        libtorrent_jni.state_update_alert_status_set(this.swigCPtr, this, torrent_status_vector.getCPtr(torrent_status_vectorVar), torrent_status_vectorVar);
    }

    public torrent_status_vector getStatus() {
        long state_update_alert_status_get = libtorrent_jni.state_update_alert_status_get(this.swigCPtr, this);
        if (state_update_alert_status_get == 0) {
            return null;
        }
        return new torrent_status_vector(state_update_alert_status_get, false);
    }
}
