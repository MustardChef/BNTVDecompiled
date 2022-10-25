package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class file_slice_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public file_slice_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(file_slice_vector file_slice_vectorVar) {
        if (file_slice_vectorVar == null) {
            return 0L;
        }
        return file_slice_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_file_slice_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public file_slice_vector() {
        this(libtorrent_jni.new_file_slice_vector(), true);
    }

    public long size() {
        return libtorrent_jni.file_slice_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.file_slice_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.file_slice_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.file_slice_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.file_slice_vector_clear(this.swigCPtr, this);
    }

    public void push_back(file_slice file_sliceVar) {
        libtorrent_jni.file_slice_vector_push_back(this.swigCPtr, this, file_slice.getCPtr(file_sliceVar), file_sliceVar);
    }

    public file_slice get(int i) {
        return new file_slice(libtorrent_jni.file_slice_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, file_slice file_sliceVar) {
        libtorrent_jni.file_slice_vector_set(this.swigCPtr, this, i, file_slice.getCPtr(file_sliceVar), file_sliceVar);
    }
}
