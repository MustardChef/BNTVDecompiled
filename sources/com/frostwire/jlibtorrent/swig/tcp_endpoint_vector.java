package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class tcp_endpoint_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public tcp_endpoint_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(tcp_endpoint_vector tcp_endpoint_vectorVar) {
        if (tcp_endpoint_vectorVar == null) {
            return 0L;
        }
        return tcp_endpoint_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_tcp_endpoint_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public tcp_endpoint_vector() {
        this(libtorrent_jni.new_tcp_endpoint_vector(), true);
    }

    public long size() {
        return libtorrent_jni.tcp_endpoint_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.tcp_endpoint_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.tcp_endpoint_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.tcp_endpoint_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.tcp_endpoint_vector_clear(this.swigCPtr, this);
    }

    public void push_back(tcp_endpoint tcp_endpointVar) {
        libtorrent_jni.tcp_endpoint_vector_push_back(this.swigCPtr, this, tcp_endpoint.getCPtr(tcp_endpointVar), tcp_endpointVar);
    }

    public tcp_endpoint get(int i) {
        return new tcp_endpoint(libtorrent_jni.tcp_endpoint_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, tcp_endpoint tcp_endpointVar) {
        libtorrent_jni.tcp_endpoint_vector_set(this.swigCPtr, this, i, tcp_endpoint.getCPtr(tcp_endpointVar), tcp_endpointVar);
    }
}
