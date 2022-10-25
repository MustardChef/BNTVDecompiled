package com.frostwire.jlibtorrent.swig;

/* renamed from: com.frostwire.jlibtorrent.swig.session */
/* loaded from: classes2.dex */
public class C2430session extends session_handle {
    private transient long swigCPtr;

    protected C2430session(long j, boolean z) {
        super(libtorrent_jni.session_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(C2430session c2430session) {
        if (c2430session == null) {
            return 0L;
        }
        return c2430session.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.session_handle
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.session_handle
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_session(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public C2430session(session_params session_paramsVar) {
        this(libtorrent_jni.new_session__SWIG_0(session_params.getCPtr(session_paramsVar), session_paramsVar), true);
    }

    public C2430session() {
        this(libtorrent_jni.new_session__SWIG_1(), true);
    }

    public C2430session(settings_pack settings_packVar, session_flags_t session_flags_tVar) {
        this(libtorrent_jni.new_session__SWIG_2(settings_pack.getCPtr(settings_packVar), settings_packVar, session_flags_t.getCPtr(session_flags_tVar), session_flags_tVar), true);
    }

    public C2430session(settings_pack settings_packVar) {
        this(libtorrent_jni.new_session__SWIG_3(settings_pack.getCPtr(settings_packVar), settings_packVar), true);
    }

    public C2430session(C2430session c2430session) {
        this(libtorrent_jni.new_session__SWIG_4(getCPtr(c2430session), c2430session), true);
    }

    public session_proxy abort() {
        return new session_proxy(libtorrent_jni.session_abort(this.swigCPtr, this), true);
    }
}
