package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_put_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.dht_put_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_put_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_put_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_put_alert(long j, boolean z) {
        super(libtorrent_jni.dht_put_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_put_alert dht_put_alertVar) {
        if (dht_put_alertVar == null) {
            return 0L;
        }
        return dht_put_alertVar.swigCPtr;
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
                libtorrent_jni.delete_dht_put_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_put_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_put_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_put_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_put_alert_message(this.swigCPtr, this);
    }

    public void setTarget(sha1_hash sha1_hashVar) {
        libtorrent_jni.dht_put_alert_target_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getTarget() {
        long dht_put_alert_target_get = libtorrent_jni.dht_put_alert_target_get(this.swigCPtr, this);
        if (dht_put_alert_target_get == 0) {
            return null;
        }
        return new sha1_hash(dht_put_alert_target_get, false);
    }

    public void setNum_success(int i) {
        libtorrent_jni.dht_put_alert_num_success_set(this.swigCPtr, this, i);
    }

    public int getNum_success() {
        return libtorrent_jni.dht_put_alert_num_success_get(this.swigCPtr, this);
    }

    public byte_vector get_public_key() {
        return new byte_vector(libtorrent_jni.dht_put_alert_get_public_key(this.swigCPtr, this), true);
    }

    public byte_vector get_signature() {
        return new byte_vector(libtorrent_jni.dht_put_alert_get_signature(this.swigCPtr, this), true);
    }

    public byte_vector get_salt() {
        return new byte_vector(libtorrent_jni.dht_put_alert_get_salt(this.swigCPtr, this), true);
    }

    public long get_seq() {
        return libtorrent_jni.dht_put_alert_get_seq(this.swigCPtr, this);
    }
}
