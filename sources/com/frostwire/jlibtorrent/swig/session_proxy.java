package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class session_proxy {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public session_proxy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(session_proxy session_proxyVar) {
        if (session_proxyVar == null) {
            return 0L;
        }
        return session_proxyVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_session_proxy(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public session_proxy() {
        this(libtorrent_jni.new_session_proxy__SWIG_0(), true);
    }

    public session_proxy(session_proxy session_proxyVar) {
        this(libtorrent_jni.new_session_proxy__SWIG_1(getCPtr(session_proxyVar), session_proxyVar), true);
    }
}
