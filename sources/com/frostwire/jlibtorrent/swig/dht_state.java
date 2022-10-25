package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_state {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_state(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(dht_state dht_stateVar) {
        if (dht_stateVar == null) {
            return 0L;
        }
        return dht_stateVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_state(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setNids(address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar) {
        libtorrent_jni.dht_state_nids_set(this.swigCPtr, this, address_sha1_hash_pair_vector.getCPtr(address_sha1_hash_pair_vectorVar), address_sha1_hash_pair_vectorVar);
    }

    public address_sha1_hash_pair_vector getNids() {
        long dht_state_nids_get = libtorrent_jni.dht_state_nids_get(this.swigCPtr, this);
        if (dht_state_nids_get == 0) {
            return null;
        }
        return new address_sha1_hash_pair_vector(dht_state_nids_get, false);
    }

    public void setNodes(udp_endpoint_vector udp_endpoint_vectorVar) {
        libtorrent_jni.dht_state_nodes_set(this.swigCPtr, this, udp_endpoint_vector.getCPtr(udp_endpoint_vectorVar), udp_endpoint_vectorVar);
    }

    public udp_endpoint_vector getNodes() {
        long dht_state_nodes_get = libtorrent_jni.dht_state_nodes_get(this.swigCPtr, this);
        if (dht_state_nodes_get == 0) {
            return null;
        }
        return new udp_endpoint_vector(dht_state_nodes_get, false);
    }

    public void setNodes6(udp_endpoint_vector udp_endpoint_vectorVar) {
        libtorrent_jni.dht_state_nodes6_set(this.swigCPtr, this, udp_endpoint_vector.getCPtr(udp_endpoint_vectorVar), udp_endpoint_vectorVar);
    }

    public udp_endpoint_vector getNodes6() {
        long dht_state_nodes6_get = libtorrent_jni.dht_state_nodes6_get(this.swigCPtr, this);
        if (dht_state_nodes6_get == 0) {
            return null;
        }
        return new udp_endpoint_vector(dht_state_nodes6_get, false);
    }

    public void clear() {
        libtorrent_jni.dht_state_clear(this.swigCPtr, this);
    }

    public dht_state() {
        this(libtorrent_jni.new_dht_state(), true);
    }
}
