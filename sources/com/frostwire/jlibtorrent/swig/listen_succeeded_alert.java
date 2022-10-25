package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class listen_succeeded_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.listen_succeeded_alert_priority_get();
    public static final int alert_type = libtorrent_jni.listen_succeeded_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.listen_succeeded_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public listen_succeeded_alert(long j, boolean z) {
        super(libtorrent_jni.listen_succeeded_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(listen_succeeded_alert listen_succeeded_alertVar) {
        if (listen_succeeded_alertVar == null) {
            return 0L;
        }
        return listen_succeeded_alertVar.swigCPtr;
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
                libtorrent_jni.delete_listen_succeeded_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.listen_succeeded_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.listen_succeeded_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.listen_succeeded_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.listen_succeeded_alert_message(this.swigCPtr, this);
    }

    public int getPort() {
        return libtorrent_jni.listen_succeeded_alert_port_get(this.swigCPtr, this);
    }

    public socket_type_t getSocket_type() {
        return socket_type_t.swigToEnum(libtorrent_jni.listen_succeeded_alert_socket_type_get(this.swigCPtr, this));
    }

    public address get_address() {
        return new address(libtorrent_jni.listen_succeeded_alert_get_address(this.swigCPtr, this), true);
    }
}