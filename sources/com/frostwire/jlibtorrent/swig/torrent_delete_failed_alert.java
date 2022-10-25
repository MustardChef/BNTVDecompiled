package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class torrent_delete_failed_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.torrent_delete_failed_alert_priority_get();
    public static final int alert_type = libtorrent_jni.torrent_delete_failed_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.torrent_delete_failed_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public torrent_delete_failed_alert(long j, boolean z) {
        super(libtorrent_jni.torrent_delete_failed_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(torrent_delete_failed_alert torrent_delete_failed_alertVar) {
        if (torrent_delete_failed_alertVar == null) {
            return 0L;
        }
        return torrent_delete_failed_alertVar.swigCPtr;
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
                libtorrent_jni.delete_torrent_delete_failed_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.torrent_delete_failed_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.torrent_delete_failed_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.torrent_delete_failed_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.torrent_delete_failed_alert_message(this.swigCPtr, this);
    }

    public error_code getError() {
        long j = libtorrent_jni.torrent_delete_failed_alert_error_get(this.swigCPtr, this);
        if (j == 0) {
            return null;
        }
        return new error_code(j, false);
    }

    public void setInfo_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.torrent_delete_failed_alert_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getInfo_hash() {
        long j = libtorrent_jni.torrent_delete_failed_alert_info_hash_get(this.swigCPtr, this);
        if (j == 0) {
            return null;
        }
        return new sha1_hash(j, false);
    }
}
