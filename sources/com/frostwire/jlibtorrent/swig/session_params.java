package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class session_params {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public session_params(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(session_params session_paramsVar) {
        if (session_paramsVar == null) {
            return 0L;
        }
        return session_paramsVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_session_params(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public session_params(settings_pack settings_packVar) {
        this(libtorrent_jni.new_session_params__SWIG_0(settings_pack.getCPtr(settings_packVar), settings_packVar), true);
    }

    public session_params() {
        this(libtorrent_jni.new_session_params__SWIG_1(), true);
    }

    public session_params(session_params session_paramsVar) {
        this(libtorrent_jni.new_session_params__SWIG_2(getCPtr(session_paramsVar), session_paramsVar), true);
    }

    public void setSettings(settings_pack settings_packVar) {
        libtorrent_jni.session_params_settings_set(this.swigCPtr, this, settings_pack.getCPtr(settings_packVar), settings_packVar);
    }

    public settings_pack getSettings() {
        long session_params_settings_get = libtorrent_jni.session_params_settings_get(this.swigCPtr, this);
        if (session_params_settings_get == 0) {
            return null;
        }
        return new settings_pack(session_params_settings_get, false);
    }

    public void setDht_settings(dht_settings dht_settingsVar) {
        libtorrent_jni.session_params_dht_settings_set(this.swigCPtr, this, dht_settings.getCPtr(dht_settingsVar), dht_settingsVar);
    }

    public dht_settings getDht_settings() {
        long session_params_dht_settings_get = libtorrent_jni.session_params_dht_settings_get(this.swigCPtr, this);
        if (session_params_dht_settings_get == 0) {
            return null;
        }
        return new dht_settings(session_params_dht_settings_get, false);
    }

    public void setDht_state(dht_state dht_stateVar) {
        libtorrent_jni.session_params_dht_state_set(this.swigCPtr, this, dht_state.getCPtr(dht_stateVar), dht_stateVar);
    }

    public dht_state getDht_state() {
        long session_params_dht_state_get = libtorrent_jni.session_params_dht_state_get(this.swigCPtr, this);
        if (session_params_dht_state_get == 0) {
            return null;
        }
        return new dht_state(session_params_dht_state_get, false);
    }
}
