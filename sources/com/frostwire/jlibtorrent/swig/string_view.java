package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_view {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_view(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(string_view string_viewVar) {
        if (string_viewVar == null) {
            return 0L;
        }
        return string_viewVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_view(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public byte_vector to_bytes() {
        return new byte_vector(libtorrent_jni.string_view_to_bytes(this.swigCPtr, this), true);
    }

    public string_view() {
        this(libtorrent_jni.new_string_view(), true);
    }
}
