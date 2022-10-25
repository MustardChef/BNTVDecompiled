package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class load_torrent_limits {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected load_torrent_limits(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(load_torrent_limits load_torrent_limitsVar) {
        if (load_torrent_limitsVar == null) {
            return 0L;
        }
        return load_torrent_limitsVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_load_torrent_limits(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMax_buffer_size(int i) {
        libtorrent_jni.load_torrent_limits_max_buffer_size_set(this.swigCPtr, this, i);
    }

    public int getMax_buffer_size() {
        return libtorrent_jni.load_torrent_limits_max_buffer_size_get(this.swigCPtr, this);
    }

    public void setMax_pieces(int i) {
        libtorrent_jni.load_torrent_limits_max_pieces_set(this.swigCPtr, this, i);
    }

    public int getMax_pieces() {
        return libtorrent_jni.load_torrent_limits_max_pieces_get(this.swigCPtr, this);
    }

    public void setMax_decode_depth(int i) {
        libtorrent_jni.load_torrent_limits_max_decode_depth_set(this.swigCPtr, this, i);
    }

    public int getMax_decode_depth() {
        return libtorrent_jni.load_torrent_limits_max_decode_depth_get(this.swigCPtr, this);
    }

    public void setMax_decode_tokens(int i) {
        libtorrent_jni.load_torrent_limits_max_decode_tokens_set(this.swigCPtr, this, i);
    }

    public int getMax_decode_tokens() {
        return libtorrent_jni.load_torrent_limits_max_decode_tokens_get(this.swigCPtr, this);
    }

    public load_torrent_limits() {
        this(libtorrent_jni.new_load_torrent_limits(), true);
    }
}
