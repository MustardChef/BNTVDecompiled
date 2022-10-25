package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class read_piece_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.read_piece_alert_priority_get();
    public static final int alert_type = libtorrent_jni.read_piece_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.read_piece_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public read_piece_alert(long j, boolean z) {
        super(libtorrent_jni.read_piece_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(read_piece_alert read_piece_alertVar) {
        if (read_piece_alertVar == null) {
            return 0L;
        }
        return read_piece_alertVar.swigCPtr;
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
                libtorrent_jni.delete_read_piece_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.read_piece_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.read_piece_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.read_piece_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.read_piece_alert_message(this.swigCPtr, this);
    }

    public error_code getError() {
        long read_piece_alert_error_get = libtorrent_jni.read_piece_alert_error_get(this.swigCPtr, this);
        if (read_piece_alert_error_get == 0) {
            return null;
        }
        return new error_code(read_piece_alert_error_get, false);
    }

    public int getPiece() {
        return libtorrent_jni.read_piece_alert_piece_get(this.swigCPtr, this);
    }

    public int getSize() {
        return libtorrent_jni.read_piece_alert_size_get(this.swigCPtr, this);
    }

    public long buffer_ptr() {
        return libtorrent_jni.read_piece_alert_buffer_ptr(this.swigCPtr, this);
    }
}
