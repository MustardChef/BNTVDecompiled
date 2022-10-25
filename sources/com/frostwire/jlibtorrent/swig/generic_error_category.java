package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class generic_error_category {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected generic_error_category(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(generic_error_category generic_error_categoryVar) {
        if (generic_error_categoryVar == null) {
            return 0L;
        }
        return generic_error_categoryVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_generic_error_category(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public generic_error_category() {
        this(libtorrent_jni.new_generic_error_category(), true);
    }

    public String name() {
        return libtorrent_jni.generic_error_category_name(this.swigCPtr, this);
    }

    public String message(int i) {
        return libtorrent_jni.generic_error_category_message__SWIG_0(this.swigCPtr, this, i);
    }

    public String message(int i, String str, long j) {
        return libtorrent_jni.generic_error_category_message__SWIG_1(this.swigCPtr, this, i, str, j);
    }
}
