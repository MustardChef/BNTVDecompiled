package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class alert_notify_callback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected alert_notify_callback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(alert_notify_callback alert_notify_callbackVar) {
        if (alert_notify_callbackVar == null) {
            return 0L;
        }
        return alert_notify_callbackVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_alert_notify_callback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        libtorrent_jni.alert_notify_callback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        libtorrent_jni.alert_notify_callback_change_ownership(this, this.swigCPtr, true);
    }

    public void on_alert() {
        if (getClass() == alert_notify_callback.class) {
            libtorrent_jni.alert_notify_callback_on_alert(this.swigCPtr, this);
        } else {
            libtorrent_jni.alert_notify_callback_on_alertSwigExplicitalert_notify_callback(this.swigCPtr, this);
        }
    }

    public alert_notify_callback() {
        this(libtorrent_jni.new_alert_notify_callback(), true);
        libtorrent_jni.alert_notify_callback_director_connect(this, this.swigCPtr, true, true);
    }
}
