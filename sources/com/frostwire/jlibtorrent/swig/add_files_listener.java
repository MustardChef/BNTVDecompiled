package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class add_files_listener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected add_files_listener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(add_files_listener add_files_listenerVar) {
        if (add_files_listenerVar == null) {
            return 0L;
        }
        return add_files_listenerVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_add_files_listener(j);
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
        libtorrent_jni.add_files_listener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        libtorrent_jni.add_files_listener_change_ownership(this, this.swigCPtr, true);
    }

    public boolean pred(String str) {
        return getClass() == add_files_listener.class ? libtorrent_jni.add_files_listener_pred(this.swigCPtr, this, str) : libtorrent_jni.add_files_listener_predSwigExplicitadd_files_listener(this.swigCPtr, this, str);
    }

    public add_files_listener() {
        this(libtorrent_jni.new_add_files_listener(), true);
        libtorrent_jni.add_files_listener_director_connect(this, this.swigCPtr, true, true);
    }
}
