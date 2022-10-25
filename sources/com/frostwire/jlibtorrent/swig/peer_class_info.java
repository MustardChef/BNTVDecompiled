package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_class_info {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_class_info(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(peer_class_info peer_class_infoVar) {
        if (peer_class_infoVar == null) {
            return 0L;
        }
        return peer_class_infoVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_class_info(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setIgnore_unchoke_slots(boolean z) {
        libtorrent_jni.peer_class_info_ignore_unchoke_slots_set(this.swigCPtr, this, z);
    }

    public boolean getIgnore_unchoke_slots() {
        return libtorrent_jni.peer_class_info_ignore_unchoke_slots_get(this.swigCPtr, this);
    }

    public void setConnection_limit_factor(int i) {
        libtorrent_jni.peer_class_info_connection_limit_factor_set(this.swigCPtr, this, i);
    }

    public int getConnection_limit_factor() {
        return libtorrent_jni.peer_class_info_connection_limit_factor_get(this.swigCPtr, this);
    }

    public void setLabel(String str) {
        libtorrent_jni.peer_class_info_label_set(this.swigCPtr, this, str);
    }

    public String getLabel() {
        return libtorrent_jni.peer_class_info_label_get(this.swigCPtr, this);
    }

    public void setUpload_limit(int i) {
        libtorrent_jni.peer_class_info_upload_limit_set(this.swigCPtr, this, i);
    }

    public int getUpload_limit() {
        return libtorrent_jni.peer_class_info_upload_limit_get(this.swigCPtr, this);
    }

    public void setDownload_limit(int i) {
        libtorrent_jni.peer_class_info_download_limit_set(this.swigCPtr, this, i);
    }

    public int getDownload_limit() {
        return libtorrent_jni.peer_class_info_download_limit_get(this.swigCPtr, this);
    }

    public void setUpload_priority(int i) {
        libtorrent_jni.peer_class_info_upload_priority_set(this.swigCPtr, this, i);
    }

    public int getUpload_priority() {
        return libtorrent_jni.peer_class_info_upload_priority_get(this.swigCPtr, this);
    }

    public void setDownload_priority(int i) {
        libtorrent_jni.peer_class_info_download_priority_set(this.swigCPtr, this, i);
    }

    public int getDownload_priority() {
        return libtorrent_jni.peer_class_info_download_priority_get(this.swigCPtr, this);
    }

    public peer_class_info() {
        this(libtorrent_jni.new_peer_class_info(), true);
    }
}
