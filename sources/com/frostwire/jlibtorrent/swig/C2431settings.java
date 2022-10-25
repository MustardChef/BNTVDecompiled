package com.frostwire.jlibtorrent.swig;

/* renamed from: com.frostwire.jlibtorrent.swig.settings */
/* loaded from: classes2.dex */
public class C2431settings extends dht_settings {
    private transient long swigCPtr;

    protected C2431settings(long j, boolean z) {
        super(libtorrent_jni.settings_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(C2431settings c2431settings) {
        if (c2431settings == null) {
            return 0L;
        }
        return c2431settings.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.dht_settings
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.dht_settings
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_settings(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void setPrefer_verified_node_ids(boolean z) {
        libtorrent_jni.settings_prefer_verified_node_ids_set(this.swigCPtr, this, z);
    }

    public boolean getPrefer_verified_node_ids() {
        return libtorrent_jni.settings_prefer_verified_node_ids_get(this.swigCPtr, this);
    }

    public C2431settings() {
        this(libtorrent_jni.new_settings(), true);
    }
}
