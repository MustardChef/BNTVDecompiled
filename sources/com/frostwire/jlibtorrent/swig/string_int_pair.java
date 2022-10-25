package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_int_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_int_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(string_int_pair string_int_pairVar) {
        if (string_int_pairVar == null) {
            return 0L;
        }
        return string_int_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_int_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public string_int_pair() {
        this(libtorrent_jni.new_string_int_pair__SWIG_0(), true);
    }

    public string_int_pair(String str, int i) {
        this(libtorrent_jni.new_string_int_pair__SWIG_1(str, i), true);
    }

    public string_int_pair(string_int_pair string_int_pairVar) {
        this(libtorrent_jni.new_string_int_pair__SWIG_2(getCPtr(string_int_pairVar), string_int_pairVar), true);
    }

    public void setFirst(String str) {
        libtorrent_jni.string_int_pair_first_set(this.swigCPtr, this, str);
    }

    public String getFirst() {
        return libtorrent_jni.string_int_pair_first_get(this.swigCPtr, this);
    }

    public void setSecond(int i) {
        libtorrent_jni.string_int_pair_second_set(this.swigCPtr, this, i);
    }

    public int getSecond() {
        return libtorrent_jni.string_int_pair_second_get(this.swigCPtr, this);
    }
}
