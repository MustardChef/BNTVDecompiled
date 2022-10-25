package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class partial_piece_info_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected partial_piece_info_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(partial_piece_info_vector partial_piece_info_vectorVar) {
        if (partial_piece_info_vectorVar == null) {
            return 0L;
        }
        return partial_piece_info_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_partial_piece_info_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public partial_piece_info_vector() {
        this(libtorrent_jni.new_partial_piece_info_vector(), true);
    }

    public long size() {
        return libtorrent_jni.partial_piece_info_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.partial_piece_info_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.partial_piece_info_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.partial_piece_info_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.partial_piece_info_vector_clear(this.swigCPtr, this);
    }

    public void push_back(partial_piece_info partial_piece_infoVar) {
        libtorrent_jni.partial_piece_info_vector_push_back(this.swigCPtr, this, partial_piece_info.getCPtr(partial_piece_infoVar), partial_piece_infoVar);
    }

    public partial_piece_info get(int i) {
        return new partial_piece_info(libtorrent_jni.partial_piece_info_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, partial_piece_info partial_piece_infoVar) {
        libtorrent_jni.partial_piece_info_vector_set(this.swigCPtr, this, i, partial_piece_info.getCPtr(partial_piece_infoVar), partial_piece_infoVar);
    }
}
