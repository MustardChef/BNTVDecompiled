package com.frostwire.jlibtorrent.swig;

import com.frostwire.jlibtorrent.swig.torrent_status;

/* loaded from: classes2.dex */
public class state_changed_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.state_changed_alert_priority_get();
    public static final int alert_type = libtorrent_jni.state_changed_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.state_changed_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public state_changed_alert(long j, boolean z) {
        super(libtorrent_jni.state_changed_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(state_changed_alert state_changed_alertVar) {
        if (state_changed_alertVar == null) {
            return 0L;
        }
        return state_changed_alertVar.swigCPtr;
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
                libtorrent_jni.delete_state_changed_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.state_changed_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.state_changed_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.state_changed_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.state_changed_alert_message(this.swigCPtr, this);
    }

    public torrent_status.state_t getState() {
        return torrent_status.state_t.swigToEnum(libtorrent_jni.state_changed_alert_state_get(this.swigCPtr, this));
    }

    public torrent_status.state_t getPrev_state() {
        return torrent_status.state_t.swigToEnum(libtorrent_jni.state_changed_alert_prev_state_get(this.swigCPtr, this));
    }
}
