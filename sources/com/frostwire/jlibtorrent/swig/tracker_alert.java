package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class tracker_alert extends torrent_alert {
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public tracker_alert(long j, boolean z) {
        super(libtorrent_jni.tracker_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(tracker_alert tracker_alertVar) {
        if (tracker_alertVar == null) {
            return 0L;
        }
        return tracker_alertVar.swigCPtr;
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
                libtorrent_jni.delete_tracker_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.tracker_alert_message(this.swigCPtr, this);
    }

    public String tracker_url() {
        return libtorrent_jni.tracker_alert_tracker_url(this.swigCPtr, this);
    }

    public tcp_endpoint get_local_endpoint() {
        return new tcp_endpoint(libtorrent_jni.tracker_alert_get_local_endpoint(this.swigCPtr, this), true);
    }
}
