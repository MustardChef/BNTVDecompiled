package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class tcp_endpoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public tcp_endpoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(tcp_endpoint tcp_endpointVar) {
        if (tcp_endpointVar == null) {
            return 0L;
        }
        return tcp_endpointVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_tcp_endpoint(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public tcp_endpoint() {
        this(libtorrent_jni.new_tcp_endpoint__SWIG_0(), true);
    }

    public tcp_endpoint(address addressVar, int i) {
        this(libtorrent_jni.new_tcp_endpoint__SWIG_1(address.getCPtr(addressVar), addressVar, i), true);
    }

    public tcp_endpoint(tcp_endpoint tcp_endpointVar) {
        this(libtorrent_jni.new_tcp_endpoint__SWIG_2(getCPtr(tcp_endpointVar), tcp_endpointVar), true);
    }

    public int port() {
        return libtorrent_jni.tcp_endpoint_port(this.swigCPtr, this);
    }

    public address address() {
        return new address(libtorrent_jni.tcp_endpoint_address(this.swigCPtr, this), true);
    }
}
