package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class partial_piece_info {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public partial_piece_info(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(partial_piece_info partial_piece_infoVar) {
        if (partial_piece_infoVar == null) {
            return 0L;
        }
        return partial_piece_infoVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_partial_piece_info(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPiece_index(int i) {
        libtorrent_jni.partial_piece_info_piece_index_set(this.swigCPtr, this, i);
    }

    public int getPiece_index() {
        return libtorrent_jni.partial_piece_info_piece_index_get(this.swigCPtr, this);
    }

    public void setBlocks_in_piece(int i) {
        libtorrent_jni.partial_piece_info_blocks_in_piece_set(this.swigCPtr, this, i);
    }

    public int getBlocks_in_piece() {
        return libtorrent_jni.partial_piece_info_blocks_in_piece_get(this.swigCPtr, this);
    }

    public void setFinished(int i) {
        libtorrent_jni.partial_piece_info_finished_set(this.swigCPtr, this, i);
    }

    public int getFinished() {
        return libtorrent_jni.partial_piece_info_finished_get(this.swigCPtr, this);
    }

    public void setWriting(int i) {
        libtorrent_jni.partial_piece_info_writing_set(this.swigCPtr, this, i);
    }

    public int getWriting() {
        return libtorrent_jni.partial_piece_info_writing_get(this.swigCPtr, this);
    }

    public void setRequested(int i) {
        libtorrent_jni.partial_piece_info_requested_set(this.swigCPtr, this, i);
    }

    public int getRequested() {
        return libtorrent_jni.partial_piece_info_requested_get(this.swigCPtr, this);
    }

    public partial_piece_info() {
        this(libtorrent_jni.new_partial_piece_info(), true);
    }
}
