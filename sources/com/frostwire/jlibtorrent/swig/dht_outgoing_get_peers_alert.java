package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_outgoing_get_peers_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.dht_outgoing_get_peers_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_outgoing_get_peers_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_outgoing_get_peers_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_outgoing_get_peers_alert(long j, boolean z) {
        super(libtorrent_jni.dht_outgoing_get_peers_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar) {
        if (dht_outgoing_get_peers_alertVar == null) {
            return 0L;
        }
        return dht_outgoing_get_peers_alertVar.swigCPtr;
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
                libtorrent_jni.delete_dht_outgoing_get_peers_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_outgoing_get_peers_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_outgoing_get_peers_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_outgoing_get_peers_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_outgoing_get_peers_alert_message(this.swigCPtr, this);
    }

    public void setInfo_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.dht_outgoing_get_peers_alert_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getInfo_hash() {
        long dht_outgoing_get_peers_alert_info_hash_get = libtorrent_jni.dht_outgoing_get_peers_alert_info_hash_get(this.swigCPtr, this);
        if (dht_outgoing_get_peers_alert_info_hash_get == 0) {
            return null;
        }
        return new sha1_hash(dht_outgoing_get_peers_alert_info_hash_get, false);
    }

    public void setObfuscated_info_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.dht_outgoing_get_peers_alert_obfuscated_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getObfuscated_info_hash() {
        long dht_outgoing_get_peers_alert_obfuscated_info_hash_get = libtorrent_jni.dht_outgoing_get_peers_alert_obfuscated_info_hash_get(this.swigCPtr, this);
        if (dht_outgoing_get_peers_alert_obfuscated_info_hash_get == 0) {
            return null;
        }
        return new sha1_hash(dht_outgoing_get_peers_alert_obfuscated_info_hash_get, false);
    }

    public udp_endpoint get_endpoint() {
        return new udp_endpoint(libtorrent_jni.dht_outgoing_get_peers_alert_get_endpoint(this.swigCPtr, this), true);
    }
}
