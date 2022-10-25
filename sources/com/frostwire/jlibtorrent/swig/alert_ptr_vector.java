package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class alert_ptr_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected alert_ptr_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(alert_ptr_vector alert_ptr_vectorVar) {
        if (alert_ptr_vectorVar == null) {
            return 0L;
        }
        return alert_ptr_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_alert_ptr_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public alert_ptr_vector() {
        this(libtorrent_jni.new_alert_ptr_vector(), true);
    }

    public long size() {
        return libtorrent_jni.alert_ptr_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.alert_ptr_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.alert_ptr_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.alert_ptr_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.alert_ptr_vector_clear(this.swigCPtr, this);
    }

    public void push_back(alert alertVar) {
        libtorrent_jni.alert_ptr_vector_push_back(this.swigCPtr, this, alert.getCPtr(alertVar), alertVar);
    }

    public alert get(int i) {
        long alert_ptr_vector_get = libtorrent_jni.alert_ptr_vector_get(this.swigCPtr, this, i);
        if (alert_ptr_vector_get == 0) {
            return null;
        }
        return new alert(alert_ptr_vector_get, false);
    }

    public void set(int i, alert alertVar) {
        libtorrent_jni.alert_ptr_vector_set(this.swigCPtr, this, i, alert.getCPtr(alertVar), alertVar);
    }
}
