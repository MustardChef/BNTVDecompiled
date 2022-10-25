package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class file_index_string_map {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected file_index_string_map(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(file_index_string_map file_index_string_mapVar) {
        if (file_index_string_mapVar == null) {
            return 0L;
        }
        return file_index_string_mapVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_file_index_string_map(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public file_index_string_map() {
        this(libtorrent_jni.new_file_index_string_map__SWIG_0(), true);
    }

    public file_index_string_map(file_index_string_map file_index_string_mapVar) {
        this(libtorrent_jni.new_file_index_string_map__SWIG_1(getCPtr(file_index_string_mapVar), file_index_string_mapVar), true);
    }

    public long size() {
        return libtorrent_jni.file_index_string_map_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return libtorrent_jni.file_index_string_map_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.file_index_string_map_clear(this.swigCPtr, this);
    }

    public String get(int i) {
        return libtorrent_jni.file_index_string_map_get(this.swigCPtr, this, i);
    }

    public void set(int i, String str) {
        libtorrent_jni.file_index_string_map_set(this.swigCPtr, this, i, str);
    }

    public void erase(int i) {
        libtorrent_jni.file_index_string_map_erase(this.swigCPtr, this, i);
    }

    public boolean has_key(int i) {
        return libtorrent_jni.file_index_string_map_has_key(this.swigCPtr, this, i);
    }

    public file_index_vector keys() {
        return new file_index_vector(libtorrent_jni.file_index_string_map_keys(this.swigCPtr, this), true);
    }
}
