package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_get_peers_reply_alert extends alert {
    private transient long swigCPtr;
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_get_peers_reply_alert_static_category_get(), false);
    public static final int priority = libtorrent_jni.dht_get_peers_reply_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_get_peers_reply_alert_alert_type_get();

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_get_peers_reply_alert(long j, boolean z) {
        super(libtorrent_jni.dht_get_peers_reply_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_get_peers_reply_alert dht_get_peers_reply_alertVar) {
        if (dht_get_peers_reply_alertVar == null) {
            return 0L;
        }
        return dht_get_peers_reply_alertVar.swigCPtr;
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
                libtorrent_jni.delete_dht_get_peers_reply_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_get_peers_reply_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_get_peers_reply_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_get_peers_reply_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_get_peers_reply_alert_message(this.swigCPtr, this);
    }

    public void setInfo_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.dht_get_peers_reply_alert_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getInfo_hash() {
        long dht_get_peers_reply_alert_info_hash_get = libtorrent_jni.dht_get_peers_reply_alert_info_hash_get(this.swigCPtr, this);
        if (dht_get_peers_reply_alert_info_hash_get == 0) {
            return null;
        }
        return new sha1_hash(dht_get_peers_reply_alert_info_hash_get, false);
    }

    public int num_peers() {
        return libtorrent_jni.dht_get_peers_reply_alert_num_peers(this.swigCPtr, this);
    }

    public tcp_endpoint_vector peers() {
        return new tcp_endpoint_vector(libtorrent_jni.dht_get_peers_reply_alert_peers(this.swigCPtr, this), true);
    }
}
