package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_string_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_string_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(string_string_pair string_string_pairVar) {
        if (string_string_pairVar == null) {
            return 0L;
        }
        return string_string_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_string_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public string_string_pair() {
        this(libtorrent_jni.new_string_string_pair__SWIG_0(), true);
    }

    public string_string_pair(String str, String str2) {
        this(libtorrent_jni.new_string_string_pair__SWIG_1(str, str2), true);
    }

    public string_string_pair(string_string_pair string_string_pairVar) {
        this(libtorrent_jni.new_string_string_pair__SWIG_2(getCPtr(string_string_pairVar), string_string_pairVar), true);
    }

    public void setFirst(String str) {
        libtorrent_jni.string_string_pair_first_set(this.swigCPtr, this, str);
    }

    public String getFirst() {
        return libtorrent_jni.string_string_pair_first_get(this.swigCPtr, this);
    }

    public void setSecond(String str) {
        libtorrent_jni.string_string_pair_second_set(this.swigCPtr, this, str);
    }

    public String getSecond() {
        return libtorrent_jni.string_string_pair_second_get(this.swigCPtr, this);
    }
}
