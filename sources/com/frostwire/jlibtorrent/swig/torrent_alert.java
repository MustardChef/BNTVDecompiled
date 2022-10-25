package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class torrent_alert extends alert {
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public torrent_alert(long j, boolean z) {
        super(libtorrent_jni.torrent_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(torrent_alert torrent_alertVar) {
        if (torrent_alertVar == null) {
            return 0L;
        }
        return torrent_alertVar.swigCPtr;
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
                libtorrent_jni.delete_torrent_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.torrent_alert_message(this.swigCPtr, this);
    }

    public void setHandle(torrent_handle torrent_handleVar) {
        libtorrent_jni.torrent_alert_handle_set(this.swigCPtr, this, torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar);
    }

    public torrent_handle getHandle() {
        long j = libtorrent_jni.torrent_alert_handle_get(this.swigCPtr, this);
        if (j == 0) {
            return null;
        }
        return new torrent_handle(j, false);
    }

    public String torrent_name() {
        return libtorrent_jni.torrent_alert_torrent_name(this.swigCPtr, this);
    }
}
