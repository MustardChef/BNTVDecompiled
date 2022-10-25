package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_stats_alert extends alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.dht_stats_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_stats_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_stats_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_stats_alert(long j, boolean z) {
        super(libtorrent_jni.dht_stats_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_stats_alert dht_stats_alertVar) {
        if (dht_stats_alertVar == null) {
            return 0L;
        }
        return dht_stats_alertVar.swigCPtr;
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
                libtorrent_jni.delete_dht_stats_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_stats_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_stats_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_stats_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_stats_alert_message(this.swigCPtr, this);
    }

    public void setActive_requests(dht_lookup_vector dht_lookup_vectorVar) {
        libtorrent_jni.dht_stats_alert_active_requests_set(this.swigCPtr, this, dht_lookup_vector.getCPtr(dht_lookup_vectorVar), dht_lookup_vectorVar);
    }

    public dht_lookup_vector getActive_requests() {
        long dht_stats_alert_active_requests_get = libtorrent_jni.dht_stats_alert_active_requests_get(this.swigCPtr, this);
        if (dht_stats_alert_active_requests_get == 0) {
            return null;
        }
        return new dht_lookup_vector(dht_stats_alert_active_requests_get, false);
    }

    public void setRouting_table(dht_routing_bucket_vector dht_routing_bucket_vectorVar) {
        libtorrent_jni.dht_stats_alert_routing_table_set(this.swigCPtr, this, dht_routing_bucket_vector.getCPtr(dht_routing_bucket_vectorVar), dht_routing_bucket_vectorVar);
    }

    public dht_routing_bucket_vector getRouting_table() {
        long dht_stats_alert_routing_table_get = libtorrent_jni.dht_stats_alert_routing_table_get(this.swigCPtr, this);
        if (dht_stats_alert_routing_table_get == 0) {
            return null;
        }
        return new dht_routing_bucket_vector(dht_stats_alert_routing_table_get, false);
    }
}
