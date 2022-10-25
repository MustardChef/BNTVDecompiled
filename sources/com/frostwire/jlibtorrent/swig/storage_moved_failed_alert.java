package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class storage_moved_failed_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.storage_moved_failed_alert_priority_get();
    public static final int alert_type = libtorrent_jni.storage_moved_failed_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.storage_moved_failed_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public storage_moved_failed_alert(long j, boolean z) {
        super(libtorrent_jni.storage_moved_failed_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(storage_moved_failed_alert storage_moved_failed_alertVar) {
        if (storage_moved_failed_alertVar == null) {
            return 0L;
        }
        return storage_moved_failed_alertVar.swigCPtr;
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
                libtorrent_jni.delete_storage_moved_failed_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.storage_moved_failed_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.storage_moved_failed_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.storage_moved_failed_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.storage_moved_failed_alert_message(this.swigCPtr, this);
    }

    public error_code getError() {
        long storage_moved_failed_alert_error_get = libtorrent_jni.storage_moved_failed_alert_error_get(this.swigCPtr, this);
        if (storage_moved_failed_alert_error_get == 0) {
            return null;
        }
        return new error_code(storage_moved_failed_alert_error_get, false);
    }

    public String file_path() {
        return libtorrent_jni.storage_moved_failed_alert_file_path(this.swigCPtr, this);
    }

    public void setOp(operation_t operation_tVar) {
        libtorrent_jni.storage_moved_failed_alert_op_set(this.swigCPtr, this, operation_tVar.swigValue());
    }

    public operation_t getOp() {
        return operation_t.swigToEnum(libtorrent_jni.storage_moved_failed_alert_op_get(this.swigCPtr, this));
    }
}
