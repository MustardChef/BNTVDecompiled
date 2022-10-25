package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class posix_stat_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public posix_stat_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(posix_stat_t posix_stat_tVar) {
        if (posix_stat_tVar == null) {
            return 0L;
        }
        return posix_stat_tVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_posix_stat_t(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSize(long j) {
        libtorrent_jni.posix_stat_t_size_set(this.swigCPtr, this, j);
    }

    public long getSize() {
        return libtorrent_jni.posix_stat_t_size_get(this.swigCPtr, this);
    }

    public void setAtime(long j) {
        libtorrent_jni.posix_stat_t_atime_set(this.swigCPtr, this, j);
    }

    public long getAtime() {
        return libtorrent_jni.posix_stat_t_atime_get(this.swigCPtr, this);
    }

    public void setMtime(long j) {
        libtorrent_jni.posix_stat_t_mtime_set(this.swigCPtr, this, j);
    }

    public long getMtime() {
        return libtorrent_jni.posix_stat_t_mtime_get(this.swigCPtr, this);
    }

    public void setCtime(long j) {
        libtorrent_jni.posix_stat_t_ctime_set(this.swigCPtr, this, j);
    }

    public long getCtime() {
        return libtorrent_jni.posix_stat_t_ctime_get(this.swigCPtr, this);
    }

    public void setMode(int i) {
        libtorrent_jni.posix_stat_t_mode_set(this.swigCPtr, this, i);
    }

    public int getMode() {
        return libtorrent_jni.posix_stat_t_mode_get(this.swigCPtr, this);
    }

    public posix_stat_t() {
        this(libtorrent_jni.new_posix_stat_t(), true);
    }
}
