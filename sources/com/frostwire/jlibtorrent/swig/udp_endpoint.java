package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class udp_endpoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public udp_endpoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(udp_endpoint udp_endpointVar) {
        if (udp_endpointVar == null) {
            return 0L;
        }
        return udp_endpointVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_udp_endpoint(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public udp_endpoint() {
        this(libtorrent_jni.new_udp_endpoint__SWIG_0(), true);
    }

    public udp_endpoint(address addressVar, int i) {
        this(libtorrent_jni.new_udp_endpoint__SWIG_1(address.getCPtr(addressVar), addressVar, i), true);
    }

    public udp_endpoint(udp_endpoint udp_endpointVar) {
        this(libtorrent_jni.new_udp_endpoint__SWIG_2(getCPtr(udp_endpointVar), udp_endpointVar), true);
    }

    public int port() {
        return libtorrent_jni.udp_endpoint_port(this.swigCPtr, this);
    }

    public address address() {
        return new address(libtorrent_jni.udp_endpoint_address(this.swigCPtr, this), true);
    }
}
