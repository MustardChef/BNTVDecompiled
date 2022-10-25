package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class tracker_warning_alert extends tracker_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.tracker_warning_alert_priority_get();
    public static final int alert_type = libtorrent_jni.tracker_warning_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.tracker_warning_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public tracker_warning_alert(long j, boolean z) {
        super(libtorrent_jni.tracker_warning_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(tracker_warning_alert tracker_warning_alertVar) {
        if (tracker_warning_alertVar == null) {
            return 0L;
        }
        return tracker_warning_alertVar.swigCPtr;
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
                libtorrent_jni.delete_tracker_warning_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.tracker_warning_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.tracker_warning_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.tracker_warning_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.tracker_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.tracker_warning_alert_message(this.swigCPtr, this);
    }

    public String warning_message() {
        return libtorrent_jni.tracker_warning_alert_warning_message(this.swigCPtr, this);
    }
}
