package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_alert extends torrent_alert {
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_alert(long j, boolean z) {
        super(libtorrent_jni.peer_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(peer_alert peer_alertVar) {
        if (peer_alertVar == null) {
            return 0L;
        }
        return peer_alertVar.swigCPtr;
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
                libtorrent_jni.delete_peer_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.peer_alert_message(this.swigCPtr, this);
    }

    public void setPid(sha1_hash sha1_hashVar) {
        libtorrent_jni.peer_alert_pid_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getPid() {
        long peer_alert_pid_get = libtorrent_jni.peer_alert_pid_get(this.swigCPtr, this);
        if (peer_alert_pid_get == 0) {
            return null;
        }
        return new sha1_hash(peer_alert_pid_get, false);
    }

    public tcp_endpoint get_endpoint() {
        return new tcp_endpoint(libtorrent_jni.peer_alert_get_endpoint(this.swigCPtr, this), true);
    }
}
