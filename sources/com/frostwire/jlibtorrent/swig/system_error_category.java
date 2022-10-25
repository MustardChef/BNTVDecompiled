package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class system_error_category {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected system_error_category(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(system_error_category system_error_categoryVar) {
        if (system_error_categoryVar == null) {
            return 0L;
        }
        return system_error_categoryVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_system_error_category(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public system_error_category() {
        this(libtorrent_jni.new_system_error_category(), true);
    }

    public String name() {
        return libtorrent_jni.system_error_category_name(this.swigCPtr, this);
    }

    public SWIGTYPE_p_boost__system__error_condition default_error_condition(int i) {
        return new SWIGTYPE_p_boost__system__error_condition(libtorrent_jni.system_error_category_default_error_condition(this.swigCPtr, this, i), true);
    }

    public String message(int i) {
        return libtorrent_jni.system_error_category_message__SWIG_0(this.swigCPtr, this, i);
    }

    public String message(int i, String str, long j) {
        return libtorrent_jni.system_error_category_message__SWIG_1(this.swigCPtr, this, i, str, j);
    }
}
