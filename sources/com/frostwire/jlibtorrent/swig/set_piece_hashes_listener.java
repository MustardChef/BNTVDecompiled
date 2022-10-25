package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class set_piece_hashes_listener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected set_piece_hashes_listener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(set_piece_hashes_listener set_piece_hashes_listenerVar) {
        if (set_piece_hashes_listenerVar == null) {
            return 0L;
        }
        return set_piece_hashes_listenerVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_set_piece_hashes_listener(j);
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
        libtorrent_jni.set_piece_hashes_listener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        libtorrent_jni.set_piece_hashes_listener_change_ownership(this, this.swigCPtr, true);
    }

    public void progress(int i) {
        if (getClass() == set_piece_hashes_listener.class) {
            libtorrent_jni.set_piece_hashes_listener_progress(this.swigCPtr, this, i);
        } else {
            libtorrent_jni.m6045x4f33fdd0(this.swigCPtr, this, i);
        }
    }

    public set_piece_hashes_listener() {
        this(libtorrent_jni.new_set_piece_hashes_listener(), true);
        libtorrent_jni.set_piece_hashes_listener_director_connect(this, this.swigCPtr, true, true);
    }
}
