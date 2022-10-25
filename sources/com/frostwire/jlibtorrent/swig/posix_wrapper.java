package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class posix_wrapper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected posix_wrapper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(posix_wrapper posix_wrapperVar) {
        if (posix_wrapperVar == null) {
            return 0L;
        }
        return posix_wrapperVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_posix_wrapper(j);
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
        libtorrent_jni.posix_wrapper_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        libtorrent_jni.posix_wrapper_change_ownership(this, this.swigCPtr, true);
    }

    public int open(String str, int i, int i2) {
        return getClass() == posix_wrapper.class ? libtorrent_jni.posix_wrapper_open(this.swigCPtr, this, str, i, i2) : libtorrent_jni.posix_wrapper_openSwigExplicitposix_wrapper(this.swigCPtr, this, str, i, i2);
    }

    public int stat(String str, posix_stat_t posix_stat_tVar) {
        return getClass() == posix_wrapper.class ? libtorrent_jni.posix_wrapper_stat(this.swigCPtr, this, str, posix_stat_t.getCPtr(posix_stat_tVar), posix_stat_tVar) : libtorrent_jni.posix_wrapper_statSwigExplicitposix_wrapper(this.swigCPtr, this, str, posix_stat_t.getCPtr(posix_stat_tVar), posix_stat_tVar);
    }

    public int mkdir(String str, int i) {
        return getClass() == posix_wrapper.class ? libtorrent_jni.posix_wrapper_mkdir(this.swigCPtr, this, str, i) : libtorrent_jni.posix_wrapper_mkdirSwigExplicitposix_wrapper(this.swigCPtr, this, str, i);
    }

    public int rename(String str, String str2) {
        return getClass() == posix_wrapper.class ? libtorrent_jni.posix_wrapper_rename(this.swigCPtr, this, str, str2) : libtorrent_jni.posix_wrapper_renameSwigExplicitposix_wrapper(this.swigCPtr, this, str, str2);
    }

    public int remove(String str) {
        return getClass() == posix_wrapper.class ? libtorrent_jni.posix_wrapper_remove(this.swigCPtr, this, str) : libtorrent_jni.posix_wrapper_removeSwigExplicitposix_wrapper(this.swigCPtr, this, str);
    }

    public posix_wrapper() {
        this(libtorrent_jni.new_posix_wrapper(), true);
        libtorrent_jni.posix_wrapper_director_connect(this, this.swigCPtr, true, true);
    }
}
