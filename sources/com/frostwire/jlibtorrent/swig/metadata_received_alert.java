package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class metadata_received_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.metadata_received_alert_priority_get();
    public static final int alert_type = libtorrent_jni.metadata_received_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.metadata_received_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public metadata_received_alert(long j, boolean z) {
        super(libtorrent_jni.metadata_received_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(metadata_received_alert metadata_received_alertVar) {
        if (metadata_received_alertVar == null) {
            return 0L;
        }
        return metadata_received_alertVar.swigCPtr;
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
                libtorrent_jni.delete_metadata_received_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.metadata_received_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.metadata_received_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.metadata_received_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.metadata_received_alert_message(this.swigCPtr, this);
    }
}
