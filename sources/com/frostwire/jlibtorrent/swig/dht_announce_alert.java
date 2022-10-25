package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_announce_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.dht_announce_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_announce_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_announce_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_announce_alert(long j, boolean z) {
        super(libtorrent_jni.dht_announce_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_announce_alert dht_announce_alertVar) {
        if (dht_announce_alertVar == null) {
            return 0L;
        }
        return dht_announce_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_announce_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_announce_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_announce_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_announce_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_announce_alert_message(this.swigCPtr, this);
    }

    public void setPort(int i) {
        libtorrent_jni.dht_announce_alert_port_set(this.swigCPtr, this, i);
    }

    public int getPort() {
        return libtorrent_jni.dht_announce_alert_port_get(this.swigCPtr, this);
    }

    public void setInfo_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.dht_announce_alert_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getInfo_hash() {
        long dht_announce_alert_info_hash_get = libtorrent_jni.dht_announce_alert_info_hash_get(this.swigCPtr, this);
        if (dht_announce_alert_info_hash_get == 0) {
            return null;
        }
        return new sha1_hash(dht_announce_alert_info_hash_get, false);
    }

    public address get_ip() {
        return new address(libtorrent_jni.dht_announce_alert_get_ip(this.swigCPtr, this), true);
    }
}
