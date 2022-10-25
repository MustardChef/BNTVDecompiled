package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_entry_map {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_entry_map(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(string_entry_map string_entry_mapVar) {
        if (string_entry_mapVar == null) {
            return 0L;
        }
        return string_entry_mapVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_entry_map(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public string_entry_map() {
        this(libtorrent_jni.new_string_entry_map__SWIG_0(), true);
    }

    public string_entry_map(string_entry_map string_entry_mapVar) {
        this(libtorrent_jni.new_string_entry_map__SWIG_1(getCPtr(string_entry_mapVar), string_entry_mapVar), true);
    }

    public long size() {
        return libtorrent_jni.string_entry_map_size(this.swigCPtr, this);
    }

    public boolean empty() {
        return libtorrent_jni.string_entry_map_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.string_entry_map_clear(this.swigCPtr, this);
    }

    public entry get(String str) {
        return new entry(libtorrent_jni.string_entry_map_get(this.swigCPtr, this, str), false);
    }

    public void set(String str, entry entryVar) {
        libtorrent_jni.string_entry_map_set(this.swigCPtr, this, str, entry.getCPtr(entryVar), entryVar);
    }

    public void erase(String str) {
        libtorrent_jni.string_entry_map_erase(this.swigCPtr, this, str);
    }

    public boolean has_key(String str) {
        return libtorrent_jni.string_entry_map_has_key(this.swigCPtr, this, str);
    }

    public string_vector keys() {
        return new string_vector(libtorrent_jni.string_entry_map_keys(this.swigCPtr, this), true);
    }
}
