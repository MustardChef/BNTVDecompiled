package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class tracker_error_alert extends tracker_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.tracker_error_alert_priority_get();
    public static final int alert_type = libtorrent_jni.tracker_error_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.tracker_error_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public tracker_error_alert(long j, boolean z) {
        super(libtorrent_jni.tracker_error_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(tracker_error_alert tracker_error_alertVar) {
        if (tracker_error_alertVar == null) {
            return 0L;
        }
        return tracker_error_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.tracker_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.tracker_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_tracker_error_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.tracker_error_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.tracker_error_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.tracker_error_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.tracker_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.tracker_error_alert_message(this.swigCPtr, this);
    }

    public int getTimes_in_row() {
        return libtorrent_jni.tracker_error_alert_times_in_row_get(this.swigCPtr, this);
    }

    public error_code getError() {
        long tracker_error_alert_error_get = libtorrent_jni.tracker_error_alert_error_get(this.swigCPtr, this);
        if (tracker_error_alert_error_get == 0) {
            return null;
        }
        return new error_code(tracker_error_alert_error_get, false);
    }

    public String error_message() {
        return libtorrent_jni.tracker_error_alert_error_message(this.swigCPtr, this);
    }
}
