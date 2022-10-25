package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_connect_alert extends peer_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.peer_connect_alert_priority_get();
    public static final int alert_type = libtorrent_jni.peer_connect_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.peer_connect_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_connect_alert(long j, boolean z) {
        super(libtorrent_jni.peer_connect_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(peer_connect_alert peer_connect_alertVar) {
        if (peer_connect_alertVar == null) {
            return 0L;
        }
        return peer_connect_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_connect_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.peer_connect_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.peer_connect_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.peer_connect_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.peer_connect_alert_message(this.swigCPtr, this);
    }

    public int getSocket_type() {
        return libtorrent_jni.peer_connect_alert_socket_type_get(this.swigCPtr, this);
    }
}
