package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class ip_interface_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ip_interface_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ip_interface_vector ip_interface_vectorVar) {
        if (ip_interface_vectorVar == null) {
            return 0L;
        }
        return ip_interface_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_ip_interface_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ip_interface_vector() {
        this(libtorrent_jni.new_ip_interface_vector(), true);
    }

    public long size() {
        return libtorrent_jni.ip_interface_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.ip_interface_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.ip_interface_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.ip_interface_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.ip_interface_vector_clear(this.swigCPtr, this);
    }

    public void push_back(ip_interface ip_interfaceVar) {
        libtorrent_jni.ip_interface_vector_push_back(this.swigCPtr, this, ip_interface.getCPtr(ip_interfaceVar), ip_interfaceVar);
    }

    public ip_interface get(int i) {
        return new ip_interface(libtorrent_jni.ip_interface_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, ip_interface ip_interfaceVar) {
        libtorrent_jni.ip_interface_vector_set(this.swigCPtr, this, i, ip_interface.getCPtr(ip_interfaceVar), ip_interfaceVar);
    }
}
