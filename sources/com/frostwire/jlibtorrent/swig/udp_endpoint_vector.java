package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class udp_endpoint_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public udp_endpoint_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(udp_endpoint_vector udp_endpoint_vectorVar) {
        if (udp_endpoint_vectorVar == null) {
            return 0L;
        }
        return udp_endpoint_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_udp_endpoint_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public udp_endpoint_vector() {
        this(libtorrent_jni.new_udp_endpoint_vector(), true);
    }

    public long size() {
        return libtorrent_jni.udp_endpoint_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.udp_endpoint_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.udp_endpoint_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.udp_endpoint_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.udp_endpoint_vector_clear(this.swigCPtr, this);
    }

    public void push_back(udp_endpoint udp_endpointVar) {
        libtorrent_jni.udp_endpoint_vector_push_back(this.swigCPtr, this, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar);
    }

    public udp_endpoint get(int i) {
        return new udp_endpoint(libtorrent_jni.udp_endpoint_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, udp_endpoint udp_endpointVar) {
        libtorrent_jni.udp_endpoint_vector_set(this.swigCPtr, this, i, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar);
    }
}
