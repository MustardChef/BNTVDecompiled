package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_connection_handle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_connection_handle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(peer_connection_handle peer_connection_handleVar) {
        if (peer_connection_handleVar == null) {
            return 0L;
        }
        return peer_connection_handleVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_connection_handle(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public connection_type type() {
        return connection_type.swigToEnum(libtorrent_jni.peer_connection_handle_type(this.swigCPtr, this));
    }

    public boolean is_seed() {
        return libtorrent_jni.peer_connection_handle_is_seed(this.swigCPtr, this);
    }

    public boolean upload_only() {
        return libtorrent_jni.peer_connection_handle_upload_only(this.swigCPtr, this);
    }

    public sha1_hash pid() {
        return new sha1_hash(libtorrent_jni.peer_connection_handle_pid(this.swigCPtr, this), false);
    }

    public boolean has_piece(int i) {
        return libtorrent_jni.peer_connection_handle_has_piece(this.swigCPtr, this, i);
    }

    public boolean is_interesting() {
        return libtorrent_jni.peer_connection_handle_is_interesting(this.swigCPtr, this);
    }

    public boolean is_choked() {
        return libtorrent_jni.peer_connection_handle_is_choked(this.swigCPtr, this);
    }

    public boolean is_peer_interested() {
        return libtorrent_jni.peer_connection_handle_is_peer_interested(this.swigCPtr, this);
    }

    public boolean has_peer_choked() {
        return libtorrent_jni.peer_connection_handle_has_peer_choked(this.swigCPtr, this);
    }

    public void choke_this_peer() {
        libtorrent_jni.peer_connection_handle_choke_this_peer(this.swigCPtr, this);
    }

    public void maybe_unchoke_this_peer() {
        libtorrent_jni.peer_connection_handle_maybe_unchoke_this_peer(this.swigCPtr, this);
    }

    public void get_peer_info(peer_info peer_infoVar) {
        libtorrent_jni.peer_connection_handle_get_peer_info(this.swigCPtr, this, peer_info.getCPtr(peer_infoVar), peer_infoVar);
    }

    public torrent_handle associated_torrent() {
        return new torrent_handle(libtorrent_jni.peer_connection_handle_associated_torrent(this.swigCPtr, this), true);
    }

    public tcp_endpoint remote() {
        return new tcp_endpoint(libtorrent_jni.peer_connection_handle_remote(this.swigCPtr, this), false);
    }

    public tcp_endpoint local_endpoint() {
        return new tcp_endpoint(libtorrent_jni.peer_connection_handle_local_endpoint(this.swigCPtr, this), true);
    }

    public void disconnect(error_code error_codeVar, operation_t operation_tVar, int i) {
        libtorrent_jni.peer_connection_handle_disconnect__SWIG_0(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar, operation_tVar.swigValue(), i);
    }

    public void disconnect(error_code error_codeVar, operation_t operation_tVar) {
        libtorrent_jni.peer_connection_handle_disconnect__SWIG_1(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar, operation_tVar.swigValue());
    }

    public boolean is_disconnecting() {
        return libtorrent_jni.peer_connection_handle_is_disconnecting(this.swigCPtr, this);
    }

    public boolean is_connecting() {
        return libtorrent_jni.peer_connection_handle_is_connecting(this.swigCPtr, this);
    }

    public boolean is_outgoing() {
        return libtorrent_jni.peer_connection_handle_is_outgoing(this.swigCPtr, this);
    }

    public boolean on_local_network() {
        return libtorrent_jni.peer_connection_handle_on_local_network(this.swigCPtr, this);
    }

    public boolean ignore_unchoke_slots() {
        return libtorrent_jni.peer_connection_handle_ignore_unchoke_slots(this.swigCPtr, this);
    }

    public boolean failed() {
        return libtorrent_jni.peer_connection_handle_failed(this.swigCPtr, this);
    }

    public boolean can_disconnect(error_code error_codeVar) {
        return libtorrent_jni.peer_connection_handle_can_disconnect(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public boolean has_metadata() {
        return libtorrent_jni.peer_connection_handle_has_metadata(this.swigCPtr, this);
    }

    public boolean in_handshake() {
        return libtorrent_jni.peer_connection_handle_in_handshake(this.swigCPtr, this);
    }

    public void send_buffer(String str, int i) {
        libtorrent_jni.peer_connection_handle_send_buffer(this.swigCPtr, this, str, i);
    }

    public long last_seen_complete() {
        return libtorrent_jni.peer_connection_handle_last_seen_complete(this.swigCPtr, this);
    }

    public boolean op_eq(peer_connection_handle peer_connection_handleVar) {
        return libtorrent_jni.peer_connection_handle_op_eq(this.swigCPtr, this, getCPtr(peer_connection_handleVar), peer_connection_handleVar);
    }

    public boolean op_ne(peer_connection_handle peer_connection_handleVar) {
        return libtorrent_jni.peer_connection_handle_op_ne(this.swigCPtr, this, getCPtr(peer_connection_handleVar), peer_connection_handleVar);
    }

    public boolean op_lt(peer_connection_handle peer_connection_handleVar) {
        return libtorrent_jni.peer_connection_handle_op_lt(this.swigCPtr, this, getCPtr(peer_connection_handleVar), peer_connection_handleVar);
    }

    public long get_time_of_last_unchoke() {
        return libtorrent_jni.peer_connection_handle_get_time_of_last_unchoke(this.swigCPtr, this);
    }
}
