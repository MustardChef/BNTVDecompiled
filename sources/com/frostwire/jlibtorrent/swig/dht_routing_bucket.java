package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_routing_bucket {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_routing_bucket(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(dht_routing_bucket dht_routing_bucketVar) {
        if (dht_routing_bucketVar == null) {
            return 0L;
        }
        return dht_routing_bucketVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_routing_bucket(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setNum_nodes(int i) {
        libtorrent_jni.dht_routing_bucket_num_nodes_set(this.swigCPtr, this, i);
    }

    public int getNum_nodes() {
        return libtorrent_jni.dht_routing_bucket_num_nodes_get(this.swigCPtr, this);
    }

    public void setNum_replacements(int i) {
        libtorrent_jni.dht_routing_bucket_num_replacements_set(this.swigCPtr, this, i);
    }

    public int getNum_replacements() {
        return libtorrent_jni.dht_routing_bucket_num_replacements_get(this.swigCPtr, this);
    }

    public void setLast_active(int i) {
        libtorrent_jni.dht_routing_bucket_last_active_set(this.swigCPtr, this, i);
    }

    public int getLast_active() {
        return libtorrent_jni.dht_routing_bucket_last_active_get(this.swigCPtr, this);
    }

    public dht_routing_bucket() {
        this(libtorrent_jni.new_dht_routing_bucket(), true);
    }
}
