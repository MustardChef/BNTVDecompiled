package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class address {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public address(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(address addressVar) {
        if (addressVar == null) {
            return 0L;
        }
        return addressVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_address(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public address() {
        this(libtorrent_jni.new_address__SWIG_0(), true);
    }

    public address(address addressVar) {
        this(libtorrent_jni.new_address__SWIG_1(getCPtr(addressVar), addressVar), true);
    }

    public boolean is_v4() {
        return libtorrent_jni.address_is_v4(this.swigCPtr, this);
    }

    public boolean is_v6() {
        return libtorrent_jni.address_is_v6(this.swigCPtr, this);
    }

    public String to_string(error_code error_codeVar) {
        return libtorrent_jni.address_to_string(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public boolean is_loopback() {
        return libtorrent_jni.address_is_loopback(this.swigCPtr, this);
    }

    public boolean is_unspecified() {
        return libtorrent_jni.address_is_unspecified(this.swigCPtr, this);
    }

    public boolean is_multicast() {
        return libtorrent_jni.address_is_multicast(this.swigCPtr, this);
    }

    public boolean op_lt(address addressVar) {
        return libtorrent_jni.address_op_lt(this.swigCPtr, this, getCPtr(addressVar), addressVar);
    }

    public static int compare(address addressVar, address addressVar2) {
        return libtorrent_jni.address_compare(getCPtr(addressVar), addressVar, getCPtr(addressVar2), addressVar2);
    }

    public static address from_string(String str, error_code error_codeVar) {
        return new address(libtorrent_jni.address_from_string(str, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }
}
