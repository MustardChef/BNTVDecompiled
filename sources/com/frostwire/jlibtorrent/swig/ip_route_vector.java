package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class ip_route_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ip_route_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(ip_route_vector ip_route_vectorVar) {
        if (ip_route_vectorVar == null) {
            return 0L;
        }
        return ip_route_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_ip_route_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ip_route_vector() {
        this(libtorrent_jni.new_ip_route_vector(), true);
    }

    public long size() {
        return libtorrent_jni.ip_route_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.ip_route_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.ip_route_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.ip_route_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.ip_route_vector_clear(this.swigCPtr, this);
    }

    public void push_back(ip_route ip_routeVar) {
        libtorrent_jni.ip_route_vector_push_back(this.swigCPtr, this, ip_route.getCPtr(ip_routeVar), ip_routeVar);
    }

    public ip_route get(int i) {
        return new ip_route(libtorrent_jni.ip_route_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, ip_route ip_routeVar) {
        libtorrent_jni.ip_route_vector_set(this.swigCPtr, this, i, ip_route.getCPtr(ip_routeVar), ip_routeVar);
    }
}
