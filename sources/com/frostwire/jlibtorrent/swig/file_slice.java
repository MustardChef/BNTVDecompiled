package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class file_slice {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public file_slice(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(file_slice file_sliceVar) {
        if (file_sliceVar == null) {
            return 0L;
        }
        return file_sliceVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_file_slice(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setFile_index(int i) {
        libtorrent_jni.file_slice_file_index_set(this.swigCPtr, this, i);
    }

    public int getFile_index() {
        return libtorrent_jni.file_slice_file_index_get(this.swigCPtr, this);
    }

    public void setOffset(long j) {
        libtorrent_jni.file_slice_offset_set(this.swigCPtr, this, j);
    }

    public long getOffset() {
        return libtorrent_jni.file_slice_offset_get(this.swigCPtr, this);
    }

    public void setSize(long j) {
        libtorrent_jni.file_slice_size_set(this.swigCPtr, this, j);
    }

    public long getSize() {
        return libtorrent_jni.file_slice_size_get(this.swigCPtr, this);
    }

    public file_slice() {
        this(libtorrent_jni.new_file_slice(), true);
    }
}
