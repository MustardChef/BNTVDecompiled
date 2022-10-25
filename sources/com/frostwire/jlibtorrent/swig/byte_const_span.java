package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class byte_const_span {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public byte_const_span(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(byte_const_span byte_const_spanVar) {
        if (byte_const_spanVar == null) {
            return 0L;
        }
        return byte_const_spanVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_byte_const_span(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public byte_const_span() {
        this(libtorrent_jni.new_byte_const_span(), true);
    }

    public long size() {
        return libtorrent_jni.byte_const_span_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return libtorrent_jni.byte_const_span_empty(this.swigCPtr, this);
    }

    public byte front() {
        return libtorrent_jni.byte_const_span_front(this.swigCPtr, this);
    }

    public byte back() {
        return libtorrent_jni.byte_const_span_back(this.swigCPtr, this);
    }

    public byte_const_span first(long j) {
        return new byte_const_span(libtorrent_jni.byte_const_span_first(this.swigCPtr, this, j), true);
    }

    public byte_const_span last(long j) {
        return new byte_const_span(libtorrent_jni.byte_const_span_last(this.swigCPtr, this, j), true);
    }

    public byte_const_span subspan(long j) {
        return new byte_const_span(libtorrent_jni.byte_const_span_subspan__SWIG_0(this.swigCPtr, this, j), true);
    }

    public byte_const_span subspan(long j, long j2) {
        return new byte_const_span(libtorrent_jni.byte_const_span_subspan__SWIG_1(this.swigCPtr, this, j, j2), true);
    }

    public byte get(long j) {
        return libtorrent_jni.byte_const_span_get(this.swigCPtr, this, j);
    }
}
