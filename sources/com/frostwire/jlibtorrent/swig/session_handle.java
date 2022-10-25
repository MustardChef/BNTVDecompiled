package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class session_handle {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;
    public static final save_state_flags_t save_settings = new save_state_flags_t(libtorrent_jni.session_handle_save_settings_get(), false);
    public static final save_state_flags_t save_dht_settings = new save_state_flags_t(libtorrent_jni.session_handle_save_dht_settings_get(), false);
    public static final save_state_flags_t save_dht_state = new save_state_flags_t(libtorrent_jni.session_handle_save_dht_state_get(), false);
    public static final int disk_cache_no_pieces = libtorrent_jni.session_handle_disk_cache_no_pieces_get();
    public static final remove_flags_t delete_files = new remove_flags_t(libtorrent_jni.session_handle_delete_files_get(), false);
    public static final remove_flags_t delete_partfile = new remove_flags_t(libtorrent_jni.session_handle_delete_partfile_get(), false);
    public static final session_flags_t add_default_plugins = new session_flags_t(libtorrent_jni.session_handle_add_default_plugins_get(), false);
    public static final portmap_protocol udp = portmap_protocol.swigToEnum(libtorrent_jni.session_handle_udp_get());
    public static final portmap_protocol tcp = portmap_protocol.swigToEnum(libtorrent_jni.session_handle_tcp_get());
    public static final reopen_network_flags_t reopen_map_ports = new reopen_network_flags_t(libtorrent_jni.session_handle_reopen_map_ports_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public session_handle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(session_handle session_handleVar) {
        if (session_handleVar == null) {
            return 0L;
        }
        return session_handleVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_session_handle(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public session_handle() {
        this(libtorrent_jni.new_session_handle__SWIG_0(), true);
    }

    public session_handle(session_handle session_handleVar) {
        this(libtorrent_jni.new_session_handle__SWIG_1(getCPtr(session_handleVar), session_handleVar), true);
    }

    public boolean is_valid() {
        return libtorrent_jni.session_handle_is_valid(this.swigCPtr, this);
    }

    public void save_state(entry entryVar, save_state_flags_t save_state_flags_tVar) {
        libtorrent_jni.session_handle_save_state__SWIG_0(this.swigCPtr, this, entry.getCPtr(entryVar), entryVar, save_state_flags_t.getCPtr(save_state_flags_tVar), save_state_flags_tVar);
    }

    public void save_state(entry entryVar) {
        libtorrent_jni.session_handle_save_state__SWIG_1(this.swigCPtr, this, entry.getCPtr(entryVar), entryVar);
    }

    public void load_state(bdecode_node bdecode_nodeVar, save_state_flags_t save_state_flags_tVar) {
        libtorrent_jni.session_handle_load_state__SWIG_0(this.swigCPtr, this, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, save_state_flags_t.getCPtr(save_state_flags_tVar), save_state_flags_tVar);
    }

    public void load_state(bdecode_node bdecode_nodeVar) {
        libtorrent_jni.session_handle_load_state__SWIG_1(this.swigCPtr, this, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar);
    }

    public void refresh_torrent_status(torrent_status_vector torrent_status_vectorVar, status_flags_t status_flags_tVar) {
        libtorrent_jni.session_handle_refresh_torrent_status__SWIG_0(this.swigCPtr, this, torrent_status_vector.getCPtr(torrent_status_vectorVar), torrent_status_vectorVar, status_flags_t.getCPtr(status_flags_tVar), status_flags_tVar);
    }

    public void refresh_torrent_status(torrent_status_vector torrent_status_vectorVar) {
        libtorrent_jni.session_handle_refresh_torrent_status__SWIG_1(this.swigCPtr, this, torrent_status_vector.getCPtr(torrent_status_vectorVar), torrent_status_vectorVar);
    }

    public void post_torrent_updates(status_flags_t status_flags_tVar) {
        libtorrent_jni.session_handle_post_torrent_updates__SWIG_0(this.swigCPtr, this, status_flags_t.getCPtr(status_flags_tVar), status_flags_tVar);
    }

    public void post_torrent_updates() {
        libtorrent_jni.session_handle_post_torrent_updates__SWIG_1(this.swigCPtr, this);
    }

    public void post_session_stats() {
        libtorrent_jni.session_handle_post_session_stats(this.swigCPtr, this);
    }

    public void post_dht_stats() {
        libtorrent_jni.session_handle_post_dht_stats(this.swigCPtr, this);
    }

    public torrent_handle find_torrent(sha1_hash sha1_hashVar) {
        return new torrent_handle(libtorrent_jni.session_handle_find_torrent(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar), true);
    }

    public torrent_handle_vector get_torrents() {
        return new torrent_handle_vector(libtorrent_jni.session_handle_get_torrents(this.swigCPtr, this), true);
    }

    public torrent_handle add_torrent(add_torrent_params add_torrent_paramsVar, error_code error_codeVar) {
        return new torrent_handle(libtorrent_jni.session_handle_add_torrent(this.swigCPtr, this, add_torrent_params.getCPtr(add_torrent_paramsVar), add_torrent_paramsVar, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }

    public void async_add_torrent(add_torrent_params add_torrent_paramsVar) {
        libtorrent_jni.session_handle_async_add_torrent(this.swigCPtr, this, add_torrent_params.getCPtr(add_torrent_paramsVar), add_torrent_paramsVar);
    }

    public void pause() {
        libtorrent_jni.session_handle_pause(this.swigCPtr, this);
    }

    public void resume() {
        libtorrent_jni.session_handle_resume(this.swigCPtr, this);
    }

    public boolean is_paused() {
        return libtorrent_jni.session_handle_is_paused(this.swigCPtr, this);
    }

    public void set_dht_settings(dht_settings dht_settingsVar) {
        libtorrent_jni.session_handle_set_dht_settings(this.swigCPtr, this, dht_settings.getCPtr(dht_settingsVar), dht_settingsVar);
    }

    public boolean is_dht_running() {
        return libtorrent_jni.session_handle_is_dht_running(this.swigCPtr, this);
    }

    public dht_settings get_dht_settings() {
        return new dht_settings(libtorrent_jni.session_handle_get_dht_settings(this.swigCPtr, this), true);
    }

    public void add_dht_node(string_int_pair string_int_pairVar) {
        libtorrent_jni.session_handle_add_dht_node(this.swigCPtr, this, string_int_pair.getCPtr(string_int_pairVar), string_int_pairVar);
    }

    public void dht_get_item(sha1_hash sha1_hashVar) {
        libtorrent_jni.session_handle_dht_get_item__SWIG_0(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash dht_put_item(entry entryVar) {
        return new sha1_hash(libtorrent_jni.session_handle_dht_put_item__SWIG_0(this.swigCPtr, this, entry.getCPtr(entryVar), entryVar), true);
    }

    public void dht_get_peers(sha1_hash sha1_hashVar) {
        libtorrent_jni.session_handle_dht_get_peers(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void dht_announce(sha1_hash sha1_hashVar, int i, int i2) {
        libtorrent_jni.session_handle_dht_announce__SWIG_0(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar, i, i2);
    }

    public void dht_announce(sha1_hash sha1_hashVar, int i) {
        libtorrent_jni.session_handle_dht_announce__SWIG_1(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar, i);
    }

    public void dht_announce(sha1_hash sha1_hashVar) {
        libtorrent_jni.session_handle_dht_announce__SWIG_2(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void dht_live_nodes(sha1_hash sha1_hashVar) {
        libtorrent_jni.session_handle_dht_live_nodes(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void dht_sample_infohashes(udp_endpoint udp_endpointVar, sha1_hash sha1_hashVar) {
        libtorrent_jni.session_handle_dht_sample_infohashes(this.swigCPtr, this, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public void dht_direct_request(udp_endpoint udp_endpointVar, entry entryVar) {
        libtorrent_jni.session_handle_dht_direct_request__SWIG_0(this.swigCPtr, this, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar, entry.getCPtr(entryVar), entryVar);
    }

    public void set_ip_filter(ip_filter ip_filterVar) {
        libtorrent_jni.session_handle_set_ip_filter(this.swigCPtr, this, ip_filter.getCPtr(ip_filterVar), ip_filterVar);
    }

    public ip_filter get_ip_filter() {
        return new ip_filter(libtorrent_jni.session_handle_get_ip_filter(this.swigCPtr, this), true);
    }

    public void set_port_filter(port_filter port_filterVar) {
        libtorrent_jni.session_handle_set_port_filter(this.swigCPtr, this, port_filter.getCPtr(port_filterVar), port_filterVar);
    }

    public static int getGlobal_peer_class_id() {
        return libtorrent_jni.session_handle_global_peer_class_id_get();
    }

    public static int getTcp_peer_class_id() {
        return libtorrent_jni.session_handle_tcp_peer_class_id_get();
    }

    public static int getLocal_peer_class_id() {
        return libtorrent_jni.session_handle_local_peer_class_id_get();
    }

    public int listen_port() {
        return libtorrent_jni.session_handle_listen_port(this.swigCPtr, this);
    }

    public int ssl_listen_port() {
        return libtorrent_jni.session_handle_ssl_listen_port(this.swigCPtr, this);
    }

    public boolean is_listening() {
        return libtorrent_jni.session_handle_is_listening(this.swigCPtr, this);
    }

    public void set_peer_class_filter(ip_filter ip_filterVar) {
        libtorrent_jni.session_handle_set_peer_class_filter(this.swigCPtr, this, ip_filter.getCPtr(ip_filterVar), ip_filterVar);
    }

    public ip_filter get_peer_class_filter() {
        return new ip_filter(libtorrent_jni.session_handle_get_peer_class_filter(this.swigCPtr, this), true);
    }

    public void set_peer_class_type_filter(peer_class_type_filter peer_class_type_filterVar) {
        libtorrent_jni.session_handle_set_peer_class_type_filter(this.swigCPtr, this, peer_class_type_filter.getCPtr(peer_class_type_filterVar), peer_class_type_filterVar);
    }

    public peer_class_type_filter get_peer_class_type_filter() {
        return new peer_class_type_filter(libtorrent_jni.session_handle_get_peer_class_type_filter(this.swigCPtr, this), true);
    }

    public int create_peer_class(String str) {
        return libtorrent_jni.session_handle_create_peer_class(this.swigCPtr, this, str);
    }

    public void delete_peer_class(int i) {
        libtorrent_jni.session_handle_delete_peer_class(this.swigCPtr, this, i);
    }

    public peer_class_info get_peer_class(int i) {
        return new peer_class_info(libtorrent_jni.session_handle_get_peer_class(this.swigCPtr, this, i), true);
    }

    public void set_peer_class(int i, peer_class_info peer_class_infoVar) {
        libtorrent_jni.session_handle_set_peer_class(this.swigCPtr, this, i, peer_class_info.getCPtr(peer_class_infoVar), peer_class_infoVar);
    }

    public void remove_torrent(torrent_handle torrent_handleVar, remove_flags_t remove_flags_tVar) {
        libtorrent_jni.session_handle_remove_torrent__SWIG_0(this.swigCPtr, this, torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar, remove_flags_t.getCPtr(remove_flags_tVar), remove_flags_tVar);
    }

    public void remove_torrent(torrent_handle torrent_handleVar) {
        libtorrent_jni.session_handle_remove_torrent__SWIG_1(this.swigCPtr, this, torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar);
    }

    public void apply_settings(settings_pack settings_packVar) {
        libtorrent_jni.session_handle_apply_settings(this.swigCPtr, this, settings_pack.getCPtr(settings_packVar), settings_packVar);
    }

    public settings_pack get_settings() {
        return new settings_pack(libtorrent_jni.session_handle_get_settings(this.swigCPtr, this), true);
    }

    public void pop_alerts(alert_ptr_vector alert_ptr_vectorVar) {
        libtorrent_jni.session_handle_pop_alerts(this.swigCPtr, this, alert_ptr_vector.getCPtr(alert_ptr_vectorVar), alert_ptr_vectorVar);
    }

    public port_mapping_t_vector add_port_mapping(portmap_protocol portmap_protocolVar, int i, int i2) {
        return new port_mapping_t_vector(libtorrent_jni.session_handle_add_port_mapping(this.swigCPtr, this, portmap_protocolVar.swigValue(), i, i2), true);
    }

    public void delete_port_mapping(int i) {
        libtorrent_jni.session_handle_delete_port_mapping(this.swigCPtr, this, i);
    }

    public void reopen_network_sockets(reopen_network_flags_t reopen_network_flags_tVar) {
        libtorrent_jni.session_handle_reopen_network_sockets__SWIG_0(this.swigCPtr, this, reopen_network_flags_t.getCPtr(reopen_network_flags_tVar), reopen_network_flags_tVar);
    }

    public void reopen_network_sockets() {
        libtorrent_jni.session_handle_reopen_network_sockets__SWIG_1(this.swigCPtr, this);
    }

    public void dht_get_item(byte_vector byte_vectorVar, byte_vector byte_vectorVar2) {
        libtorrent_jni.session_handle_dht_get_item__SWIG_1(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2);
    }

    public void dht_put_item(byte_vector byte_vectorVar, byte_vector byte_vectorVar2, entry entryVar, byte_vector byte_vectorVar3) {
        libtorrent_jni.session_handle_dht_put_item__SWIG_1(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2, entry.getCPtr(entryVar), entryVar, byte_vector.getCPtr(byte_vectorVar3), byte_vectorVar3);
    }

    public void dht_direct_request(udp_endpoint udp_endpointVar, entry entryVar, long j) {
        libtorrent_jni.session_handle_dht_direct_request__SWIG_1(this.swigCPtr, this, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar, entry.getCPtr(entryVar), entryVar, j);
    }

    public alert wait_for_alert_ms(long j) {
        long session_handle_wait_for_alert_ms = libtorrent_jni.session_handle_wait_for_alert_ms(this.swigCPtr, this, j);
        if (session_handle_wait_for_alert_ms == 0) {
            return null;
        }
        return new alert(session_handle_wait_for_alert_ms, false);
    }

    public void set_alert_notify_callback(alert_notify_callback alert_notify_callbackVar) {
        libtorrent_jni.session_handle_set_alert_notify_callback(this.swigCPtr, this, alert_notify_callback.getCPtr(alert_notify_callbackVar), alert_notify_callbackVar);
    }

    public void add_extension(swig_plugin swig_pluginVar) {
        libtorrent_jni.session_handle_add_extension(this.swigCPtr, this, swig_plugin.getCPtr(swig_pluginVar), swig_pluginVar);
    }
}
