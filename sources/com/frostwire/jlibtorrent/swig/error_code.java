package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class error_code {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public error_code(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(error_code error_codeVar) {
        if (error_codeVar == null) {
            return 0L;
        }
        return error_codeVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_error_code(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public error_code() {
        this(libtorrent_jni.new_error_code(), true);
    }

    public void clear() {
        libtorrent_jni.error_code_clear(this.swigCPtr, this);
    }

    public int value() {
        return libtorrent_jni.error_code_value(this.swigCPtr, this);
    }

    public String message() {
        return libtorrent_jni.error_code_message__SWIG_0(this.swigCPtr, this);
    }

    public String message(String str, long j) {
        return libtorrent_jni.error_code_message__SWIG_1(this.swigCPtr, this, str, j);
    }

    public boolean failed() {
        return libtorrent_jni.error_code_failed(this.swigCPtr, this);
    }

    public boolean op_bool() {
        return libtorrent_jni.error_code_op_bool(this.swigCPtr, this);
    }
}
