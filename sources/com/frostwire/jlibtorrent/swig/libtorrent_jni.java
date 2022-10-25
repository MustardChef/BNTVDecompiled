package com.frostwire.jlibtorrent.swig;

import java.nio.Buffer;

/* loaded from: classes2.dex */
public class libtorrent_jni {
    public static final native String LIBTORRENT_REVISION_get();

    public static final native int LIBTORRENT_VERSION_MAJOR_get();

    public static final native int LIBTORRENT_VERSION_MINOR_get();

    public static final native int LIBTORRENT_VERSION_NUM_get();

    public static final native int LIBTORRENT_VERSION_TINY_get();

    public static final native String LIBTORRENT_VERSION_get();

    public static final native int accepted_get();

    public static final native void add_files__SWIG_0(long j, file_storage file_storageVar, String str, long j2, create_flags_t create_flags_tVar);

    public static final native void add_files__SWIG_1(long j, file_storage file_storageVar, String str);

    public static final native void add_files_ex(long j, file_storage file_storageVar, String str, long j2, add_files_listener add_files_listenerVar, long j3, create_flags_t create_flags_tVar);

    public static final native void add_files_listener_change_ownership(add_files_listener add_files_listenerVar, long j, boolean z);

    public static final native void add_files_listener_director_connect(add_files_listener add_files_listenerVar, long j, boolean z, boolean z2);

    public static final native boolean add_files_listener_pred(long j, add_files_listener add_files_listenerVar, String str);

    public static final native boolean add_files_listener_predSwigExplicitadd_files_listener(long j, add_files_listener add_files_listenerVar, String str);

    public static final native long add_piece_flags_t_all();

    public static final native long add_piece_flags_t_and_(long j, add_piece_flags_t add_piece_flags_tVar, long j2, add_piece_flags_t add_piece_flags_tVar2);

    public static final native boolean add_piece_flags_t_eq(long j, add_piece_flags_t add_piece_flags_tVar, long j2, add_piece_flags_t add_piece_flags_tVar2);

    public static final native long add_piece_flags_t_inv(long j, add_piece_flags_t add_piece_flags_tVar);

    public static final native boolean add_piece_flags_t_ne(long j, add_piece_flags_t add_piece_flags_tVar, long j2, add_piece_flags_t add_piece_flags_tVar2);

    public static final native boolean add_piece_flags_t_nonZero(long j, add_piece_flags_t add_piece_flags_tVar);

    public static final native long add_piece_flags_t_or_(long j, add_piece_flags_t add_piece_flags_tVar, long j2, add_piece_flags_t add_piece_flags_tVar2);

    public static final native int add_piece_flags_t_to_int(long j, add_piece_flags_t add_piece_flags_tVar);

    public static final native long add_piece_flags_t_xor(long j, add_piece_flags_t add_piece_flags_tVar, long j2, add_piece_flags_t add_piece_flags_tVar2);

    public static final native long add_torrent_alert_SWIGUpcast(long j);

    public static final native int add_torrent_alert_alert_type_get();

    public static final native long add_torrent_alert_category(long j, add_torrent_alert add_torrent_alertVar);

    public static final native long add_torrent_alert_error_get(long j, add_torrent_alert add_torrent_alertVar);

    public static final native void add_torrent_alert_error_set(long j, add_torrent_alert add_torrent_alertVar, long j2, error_code error_codeVar);

    public static final native String add_torrent_alert_message(long j, add_torrent_alert add_torrent_alertVar);

    public static final native long add_torrent_alert_params_get(long j, add_torrent_alert add_torrent_alertVar);

    public static final native void add_torrent_alert_params_set(long j, add_torrent_alert add_torrent_alertVar, long j2, add_torrent_params add_torrent_paramsVar);

    public static final native int add_torrent_alert_priority_get();

    public static final native long add_torrent_alert_static_category_get();

    public static final native int add_torrent_alert_type(long j, add_torrent_alert add_torrent_alertVar);

    public static final native String add_torrent_alert_what(long j, add_torrent_alert add_torrent_alertVar);

    public static final native int add_torrent_params_active_time_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_active_time_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_added_time_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_added_time_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native long add_torrent_params_completed_time_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_completed_time_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native long add_torrent_params_create_instance();

    public static final native long add_torrent_params_create_instance_disabled_storage();

    public static final native long add_torrent_params_create_instance_zero_storage();

    public static final native int add_torrent_params_download_limit_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_download_limit_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native int add_torrent_params_finished_time_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_finished_time_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_flags_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_flags_set(long j, add_torrent_params add_torrent_paramsVar, long j2, torrent_flags_t torrent_flags_tVar);

    public static final native long add_torrent_params_get_banned_peers(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_get_dht_nodes(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_get_peers(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_get_tracker_tiers(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_get_trackers(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_get_url_seeds(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_have_pieces_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_have_pieces_set(long j, add_torrent_params add_torrent_paramsVar, long j2, piece_index_bitfield piece_index_bitfieldVar);

    public static final native long add_torrent_params_info_hash_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_info_hash_set(long j, add_torrent_params add_torrent_paramsVar, long j2, sha1_hash sha1_hashVar);

    public static final native long add_torrent_params_last_download_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_last_download_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native long add_torrent_params_last_seen_complete_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_last_seen_complete_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native long add_torrent_params_last_upload_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_last_upload_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native int add_torrent_params_max_connections_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_max_connections_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native int add_torrent_params_max_uploads_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_max_uploads_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native String add_torrent_params_name_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_name_set(long j, add_torrent_params add_torrent_paramsVar, String str);

    public static final native int add_torrent_params_num_complete_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_num_complete_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native int add_torrent_params_num_downloaded_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_num_downloaded_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native int add_torrent_params_num_incomplete_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_num_incomplete_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_parse_magnet_uri(String str, long j, error_code error_codeVar);

    public static final native long add_torrent_params_read_resume_data__SWIG_0(long j, bdecode_node bdecode_nodeVar, long j2, error_code error_codeVar);

    public static final native long add_torrent_params_read_resume_data__SWIG_1(long j, byte_vector byte_vectorVar, long j2, error_code error_codeVar);

    public static final native String add_torrent_params_save_path_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_save_path_set(long j, add_torrent_params add_torrent_paramsVar, String str);

    public static final native int add_torrent_params_seeding_time_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_seeding_time_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native void add_torrent_params_set_banned_peers(long j, add_torrent_params add_torrent_paramsVar, long j2, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native void add_torrent_params_set_default_storage(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_set_dht_nodes(long j, add_torrent_params add_torrent_paramsVar, long j2, string_int_pair_vector string_int_pair_vectorVar);

    public static final native void add_torrent_params_set_disabled_storage(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_set_file_priorities2(long j, add_torrent_params add_torrent_paramsVar, long j2, byte_vector byte_vectorVar);

    public static final native void add_torrent_params_set_http_seeds(long j, add_torrent_params add_torrent_paramsVar, long j2, string_vector string_vectorVar);

    public static final native void add_torrent_params_set_merkle_tree(long j, add_torrent_params add_torrent_paramsVar, long j2, sha1_hash_vector sha1_hash_vectorVar);

    public static final native void add_torrent_params_set_peers(long j, add_torrent_params add_torrent_paramsVar, long j2, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native void add_torrent_params_set_piece_priorities2(long j, add_torrent_params add_torrent_paramsVar, long j2, byte_vector byte_vectorVar);

    public static final native void add_torrent_params_set_renamed_files(long j, add_torrent_params add_torrent_paramsVar, long j2, file_index_string_map file_index_string_mapVar);

    public static final native void add_torrent_params_set_ti(long j, add_torrent_params add_torrent_paramsVar, long j2, torrent_info torrent_infoVar);

    public static final native void add_torrent_params_set_tracker_tiers(long j, add_torrent_params add_torrent_paramsVar, long j2, int_vector int_vectorVar);

    public static final native void add_torrent_params_set_trackers(long j, add_torrent_params add_torrent_paramsVar, long j2, string_vector string_vectorVar);

    public static final native void add_torrent_params_set_url_seeds(long j, add_torrent_params add_torrent_paramsVar, long j2, string_vector string_vectorVar);

    public static final native void add_torrent_params_set_zero_storage(long j, add_torrent_params add_torrent_paramsVar);

    public static final native int add_torrent_params_storage_mode_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_storage_mode_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_ti_ptr(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_total_downloaded_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_total_downloaded_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native long add_torrent_params_total_uploaded_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_total_uploaded_set(long j, add_torrent_params add_torrent_paramsVar, long j2);

    public static final native String add_torrent_params_trackerid_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_trackerid_set(long j, add_torrent_params add_torrent_paramsVar, String str);

    public static final native int add_torrent_params_upload_limit_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_upload_limit_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_verified_pieces_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_verified_pieces_set(long j, add_torrent_params add_torrent_paramsVar, long j2, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int add_torrent_params_version_get(long j, add_torrent_params add_torrent_paramsVar);

    public static final native void add_torrent_params_version_set(long j, add_torrent_params add_torrent_paramsVar, int i);

    public static final native long add_torrent_params_write_resume_data(long j, add_torrent_params add_torrent_paramsVar);

    public static final native long add_torrent_params_write_resume_data_buf(long j, add_torrent_params add_torrent_paramsVar);

    public static final native int address_compare(long j, address addressVar, long j2, address addressVar2);

    public static final native int address_family_not_supported_get();

    public static final native long address_from_string(String str, long j, error_code error_codeVar);

    public static final native int address_in_use_get();

    public static final native boolean address_is_loopback(long j, address addressVar);

    public static final native boolean address_is_multicast(long j, address addressVar);

    public static final native boolean address_is_unspecified(long j, address addressVar);

    public static final native boolean address_is_v4(long j, address addressVar);

    public static final native boolean address_is_v6(long j, address addressVar);

    public static final native int address_not_available_get();

    public static final native boolean address_op_lt(long j, address addressVar, long j2, address addressVar2);

    public static final native long address_sha1_hash_pair_first_get(long j, address_sha1_hash_pair address_sha1_hash_pairVar);

    public static final native void address_sha1_hash_pair_first_set(long j, address_sha1_hash_pair address_sha1_hash_pairVar, long j2, address addressVar);

    public static final native long address_sha1_hash_pair_second_get(long j, address_sha1_hash_pair address_sha1_hash_pairVar);

    public static final native void address_sha1_hash_pair_second_set(long j, address_sha1_hash_pair address_sha1_hash_pairVar, long j2, sha1_hash sha1_hashVar);

    public static final native long address_sha1_hash_pair_vector_capacity(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar);

    public static final native void address_sha1_hash_pair_vector_clear(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar);

    public static final native boolean address_sha1_hash_pair_vector_empty(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar);

    public static final native long address_sha1_hash_pair_vector_get(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar, int i);

    public static final native void address_sha1_hash_pair_vector_push_back(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar, long j2, address_sha1_hash_pair address_sha1_hash_pairVar);

    public static final native void address_sha1_hash_pair_vector_reserve(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar, long j2);

    public static final native void address_sha1_hash_pair_vector_set(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar, int i, long j2, address_sha1_hash_pair address_sha1_hash_pairVar);

    public static final native long address_sha1_hash_pair_vector_size(long j, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar);

    public static final native String address_to_string(long j, address addressVar, long j2, error_code error_codeVar);

    public static final native long alert_all_categories_get();

    public static final native long alert_block_progress_notification_get();

    public static final native long alert_cast_to_add_torrent_alert(long j, alert alertVar);

    public static final native long alert_cast_to_alerts_dropped_alert(long j, alert alertVar);

    public static final native long alert_cast_to_block_downloading_alert(long j, alert alertVar);

    public static final native long alert_cast_to_block_finished_alert(long j, alert alertVar);

    public static final native long alert_cast_to_block_timeout_alert(long j, alert alertVar);

    public static final native long alert_cast_to_block_uploaded_alert(long j, alert alertVar);

    public static final native long alert_cast_to_cache_flushed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_announce_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_bootstrap_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_direct_response_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_get_peers_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_get_peers_reply_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_immutable_item_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_live_nodes_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_mutable_item_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_outgoing_get_peers_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_pkt_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_put_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_reply_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_sample_infohashes_alert(long j, alert alertVar);

    public static final native long alert_cast_to_dht_stats_alert(long j, alert alertVar);

    public static final native long alert_cast_to_external_ip_alert(long j, alert alertVar);

    public static final native long alert_cast_to_fastresume_rejected_alert(long j, alert alertVar);

    public static final native long alert_cast_to_file_completed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_file_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_file_rename_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_file_renamed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_hash_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_i2p_alert(long j, alert alertVar);

    public static final native long alert_cast_to_incoming_connection_alert(long j, alert alertVar);

    public static final native long alert_cast_to_incoming_request_alert(long j, alert alertVar);

    public static final native long alert_cast_to_invalid_request_alert(long j, alert alertVar);

    public static final native long alert_cast_to_listen_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_listen_succeeded_alert(long j, alert alertVar);

    public static final native long alert_cast_to_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_lsd_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_lsd_peer_alert(long j, alert alertVar);

    public static final native long alert_cast_to_metadata_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_metadata_received_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_ban_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_blocked_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_connect_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_disconnected_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_snubbed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_peer_unsnubbed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_performance_alert(long j, alert alertVar);

    public static final native long alert_cast_to_picker_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_piece_finished_alert(long j, alert alertVar);

    public static final native long alert_cast_to_portmap_alert(long j, alert alertVar);

    public static final native long alert_cast_to_portmap_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_portmap_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_read_piece_alert(long j, alert alertVar);

    public static final native long alert_cast_to_request_dropped_alert(long j, alert alertVar);

    public static final native long alert_cast_to_save_resume_data_alert(long j, alert alertVar);

    public static final native long alert_cast_to_save_resume_data_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_scrape_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_scrape_reply_alert(long j, alert alertVar);

    public static final native long alert_cast_to_session_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_session_stats_alert(long j, alert alertVar);

    public static final native long alert_cast_to_session_stats_header_alert(long j, alert alertVar);

    public static final native long alert_cast_to_state_changed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_state_update_alert(long j, alert alertVar);

    public static final native long alert_cast_to_stats_alert(long j, alert alertVar);

    public static final native long alert_cast_to_storage_moved_alert(long j, alert alertVar);

    public static final native long alert_cast_to_storage_moved_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_checked_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_delete_failed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_deleted_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_finished_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_log_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_need_cert_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_paused_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_removed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_torrent_resumed_alert(long j, alert alertVar);

    public static final native long alert_cast_to_tracker_announce_alert(long j, alert alertVar);

    public static final native long alert_cast_to_tracker_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_tracker_reply_alert(long j, alert alertVar);

    public static final native long alert_cast_to_tracker_warning_alert(long j, alert alertVar);

    public static final native long alert_cast_to_trackerid_alert(long j, alert alertVar);

    public static final native long alert_cast_to_udp_error_alert(long j, alert alertVar);

    public static final native long alert_cast_to_unwanted_block_alert(long j, alert alertVar);

    public static final native long alert_cast_to_url_seed_alert(long j, alert alertVar);

    public static final native long alert_category(long j, alert alertVar);

    public static final native long alert_category_t_all();

    public static final native long alert_category_t_and_(long j, alert_category_t alert_category_tVar, long j2, alert_category_t alert_category_tVar2);

    public static final native boolean alert_category_t_eq(long j, alert_category_t alert_category_tVar, long j2, alert_category_t alert_category_tVar2);

    public static final native long alert_category_t_inv(long j, alert_category_t alert_category_tVar);

    public static final native boolean alert_category_t_ne(long j, alert_category_t alert_category_tVar, long j2, alert_category_t alert_category_tVar2);

    public static final native boolean alert_category_t_nonZero(long j, alert_category_t alert_category_tVar);

    public static final native long alert_category_t_or_(long j, alert_category_t alert_category_tVar, long j2, alert_category_t alert_category_tVar2);

    public static final native int alert_category_t_to_int(long j, alert_category_t alert_category_tVar);

    public static final native long alert_category_t_xor(long j, alert_category_t alert_category_tVar, long j2, alert_category_t alert_category_tVar2);

    public static final native long alert_connect_notification_get();

    public static final native long alert_dht_log_notification_get();

    public static final native long alert_dht_notification_get();

    public static final native long alert_dht_operation_notification_get();

    public static final native long alert_error_notification_get();

    public static final native long alert_file_progress_notification_get();

    public static final native long alert_get_timestamp(long j, alert alertVar);

    public static final native long alert_incoming_request_notification_get();

    public static final native long alert_ip_block_notification_get();

    public static final native String alert_message(long j, alert alertVar);

    public static final native String alert_name(int i);

    public static final native void alert_notify_callback_change_ownership(alert_notify_callback alert_notify_callbackVar, long j, boolean z);

    public static final native void alert_notify_callback_director_connect(alert_notify_callback alert_notify_callbackVar, long j, boolean z, boolean z2);

    public static final native void alert_notify_callback_on_alert(long j, alert_notify_callback alert_notify_callbackVar);

    public static final native void alert_notify_callback_on_alertSwigExplicitalert_notify_callback(long j, alert_notify_callback alert_notify_callbackVar);

    public static final native long alert_peer_log_notification_get();

    public static final native long alert_peer_notification_get();

    public static final native long alert_performance_warning_get();

    public static final native long alert_picker_log_notification_get();

    public static final native long alert_piece_progress_notification_get();

    public static final native long alert_port_mapping_log_notification_get();

    public static final native long alert_port_mapping_notification_get();

    public static final native int alert_priority_normal_get();

    public static final native long alert_ptr_vector_capacity(long j, alert_ptr_vector alert_ptr_vectorVar);

    public static final native void alert_ptr_vector_clear(long j, alert_ptr_vector alert_ptr_vectorVar);

    public static final native boolean alert_ptr_vector_empty(long j, alert_ptr_vector alert_ptr_vectorVar);

    public static final native long alert_ptr_vector_get(long j, alert_ptr_vector alert_ptr_vectorVar, int i);

    public static final native void alert_ptr_vector_push_back(long j, alert_ptr_vector alert_ptr_vectorVar, long j2, alert alertVar);

    public static final native void alert_ptr_vector_reserve(long j, alert_ptr_vector alert_ptr_vectorVar, long j2);

    public static final native void alert_ptr_vector_set(long j, alert_ptr_vector alert_ptr_vectorVar, int i, long j2, alert alertVar);

    public static final native long alert_ptr_vector_size(long j, alert_ptr_vector alert_ptr_vectorVar);

    public static final native long alert_session_log_notification_get();

    public static final native long alert_stats_notification_get();

    public static final native long alert_status_notification_get();

    public static final native long alert_storage_notification_get();

    public static final native long alert_torrent_log_notification_get();

    public static final native long alert_tracker_notification_get();

    public static final native int alert_type(long j, alert alertVar);

    public static final native long alert_upload_notification_get();

    public static final native String alert_what(long j, alert alertVar);

    public static final native long alerts_dropped_alert_SWIGUpcast(long j);

    public static final native int alerts_dropped_alert_alert_type_get();

    public static final native long alerts_dropped_alert_category(long j, alerts_dropped_alert alerts_dropped_alertVar);

    public static final native long alerts_dropped_alert_dropped_alerts_get(long j, alerts_dropped_alert alerts_dropped_alertVar);

    public static final native void alerts_dropped_alert_dropped_alerts_set(long j, alerts_dropped_alert alerts_dropped_alertVar, long j2);

    public static final native String alerts_dropped_alert_message(long j, alerts_dropped_alert alerts_dropped_alertVar);

    public static final native int alerts_dropped_alert_priority_get();

    public static final native long alerts_dropped_alert_static_category_get();

    public static final native int alerts_dropped_alert_type(long j, alerts_dropped_alert alerts_dropped_alertVar);

    public static final native String alerts_dropped_alert_what(long j, alerts_dropped_alert alerts_dropped_alertVar);

    public static final native long all_get();

    public static final native int already_connected_get();

    public static final native short announce_endpoint_fails_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_fails_set(long j, announce_endpoint announce_endpointVar, short s);

    public static final native long announce_endpoint_get_message(long j, announce_endpoint announce_endpointVar);

    public static final native long announce_endpoint_get_min_announce(long j, announce_endpoint announce_endpointVar);

    public static final native long announce_endpoint_get_next_announce(long j, announce_endpoint announce_endpointVar);

    public static final native boolean announce_endpoint_is_working(long j, announce_endpoint announce_endpointVar);

    public static final native long announce_endpoint_last_error_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_last_error_set(long j, announce_endpoint announce_endpointVar, long j2, error_code error_codeVar);

    public static final native long announce_endpoint_local_endpoint_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_local_endpoint_set(long j, announce_endpoint announce_endpointVar, long j2, tcp_endpoint tcp_endpointVar);

    public static final native int announce_endpoint_scrape_complete_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_scrape_complete_set(long j, announce_endpoint announce_endpointVar, int i);

    public static final native int announce_endpoint_scrape_downloaded_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_scrape_downloaded_set(long j, announce_endpoint announce_endpointVar, int i);

    public static final native int announce_endpoint_scrape_incomplete_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_scrape_incomplete_set(long j, announce_endpoint announce_endpointVar, int i);

    public static final native boolean announce_endpoint_updating_get(long j, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_updating_set(long j, announce_endpoint announce_endpointVar, boolean z);

    public static final native long announce_endpoint_vector_capacity(long j, announce_endpoint_vector announce_endpoint_vectorVar);

    public static final native void announce_endpoint_vector_clear(long j, announce_endpoint_vector announce_endpoint_vectorVar);

    public static final native boolean announce_endpoint_vector_empty(long j, announce_endpoint_vector announce_endpoint_vectorVar);

    public static final native long announce_endpoint_vector_get(long j, announce_endpoint_vector announce_endpoint_vectorVar, int i);

    public static final native void announce_endpoint_vector_push_back(long j, announce_endpoint_vector announce_endpoint_vectorVar, long j2, announce_endpoint announce_endpointVar);

    public static final native void announce_endpoint_vector_reserve(long j, announce_endpoint_vector announce_endpoint_vectorVar, long j2);

    public static final native void announce_endpoint_vector_set(long j, announce_endpoint_vector announce_endpoint_vectorVar, int i, long j2, announce_endpoint announce_endpointVar);

    public static final native long announce_endpoint_vector_size(long j, announce_endpoint_vector announce_endpoint_vectorVar);

    public static final native long announce_entry_endpoints_get(long j, announce_entry announce_entryVar);

    public static final native void announce_entry_endpoints_set(long j, announce_entry announce_entryVar, long j2, announce_endpoint_vector announce_endpoint_vectorVar);

    public static final native short announce_entry_fail_limit_get(long j, announce_entry announce_entryVar);

    public static final native void announce_entry_fail_limit_set(long j, announce_entry announce_entryVar, short s);

    public static final native long announce_entry_get_trackerid(long j, announce_entry announce_entryVar);

    public static final native long announce_entry_get_url(long j, announce_entry announce_entryVar);

    public static final native void announce_entry_set_trackerid(long j, announce_entry announce_entryVar, long j2, byte_vector byte_vectorVar);

    public static final native void announce_entry_set_url(long j, announce_entry announce_entryVar, long j2, byte_vector byte_vectorVar);

    public static final native int announce_entry_source_client_get();

    public static final native short announce_entry_source_get(long j, announce_entry announce_entryVar);

    public static final native int announce_entry_source_magnet_link_get();

    public static final native void announce_entry_source_set(long j, announce_entry announce_entryVar, short s);

    public static final native int announce_entry_source_tex_get();

    public static final native int announce_entry_source_torrent_get();

    public static final native short announce_entry_tier_get(long j, announce_entry announce_entryVar);

    public static final native void announce_entry_tier_set(long j, announce_entry announce_entryVar, short s);

    public static final native long announce_entry_vector_capacity(long j, announce_entry_vector announce_entry_vectorVar);

    public static final native void announce_entry_vector_clear(long j, announce_entry_vector announce_entry_vectorVar);

    public static final native boolean announce_entry_vector_empty(long j, announce_entry_vector announce_entry_vectorVar);

    public static final native long announce_entry_vector_get(long j, announce_entry_vector announce_entry_vectorVar, int i);

    public static final native void announce_entry_vector_push_back(long j, announce_entry_vector announce_entry_vectorVar, long j2, announce_entry announce_entryVar);

    public static final native void announce_entry_vector_reserve(long j, announce_entry_vector announce_entry_vectorVar, long j2);

    public static final native void announce_entry_vector_set(long j, announce_entry_vector announce_entry_vectorVar, int i, long j2, announce_entry announce_entryVar);

    public static final native long announce_entry_vector_size(long j, announce_entry_vector announce_entry_vectorVar);

    public static final native boolean announce_entry_verified_get(long j, announce_entry announce_entryVar);

    public static final native void announce_entry_verified_set(long j, announce_entry announce_entryVar, boolean z);

    public static final native long apply_ip_filter_get();

    public static final native int argument_list_too_long_get();

    public static final native int argument_out_of_domain_get();

    public static final native boolean arm_neon_support();

    public static final native long auto_managed_get();

    public static final native int bad_address_get();

    public static final native int bad_file_descriptor_get();

    public static final native int bad_gateway_get();

    public static final native int bad_message_get();

    public static final native int bad_request_get();

    public static final native long bandwidth_state_flags_t_all();

    public static final native long bandwidth_state_flags_t_and_(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar2);

    public static final native boolean bandwidth_state_flags_t_eq(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar2);

    public static final native long bandwidth_state_flags_t_inv(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar);

    public static final native boolean bandwidth_state_flags_t_ne(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar2);

    public static final native boolean bandwidth_state_flags_t_nonZero(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar);

    public static final native long bandwidth_state_flags_t_or_(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar2);

    public static final native int bandwidth_state_flags_t_to_int(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar);

    public static final native long bandwidth_state_flags_t_xor(long j, bandwidth_state_flags_t bandwidth_state_flags_tVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar2);

    public static final native int bdecode_no_error_get();

    public static final native int bdecode_node_bdecode(long j, byte_vector byte_vectorVar, long j2, bdecode_node bdecode_nodeVar, long j3, error_code error_codeVar);

    public static final native void bdecode_node_clear(long j, bdecode_node bdecode_nodeVar);

    public static final native long bdecode_node_dict_at(long j, bdecode_node bdecode_nodeVar, int i);

    public static final native long bdecode_node_dict_find_dict_s(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native long bdecode_node_dict_find_int_s(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native long bdecode_node_dict_find_int_value_s__SWIG_0(long j, bdecode_node bdecode_nodeVar, String str, long j2);

    public static final native long bdecode_node_dict_find_int_value_s__SWIG_1(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native long bdecode_node_dict_find_list_s(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native long bdecode_node_dict_find_s(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native long bdecode_node_dict_find_string_s(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native String bdecode_node_dict_find_string_value_s__SWIG_0(long j, bdecode_node bdecode_nodeVar, String str, String str2);

    public static final native String bdecode_node_dict_find_string_value_s__SWIG_1(long j, bdecode_node bdecode_nodeVar, String str);

    public static final native int bdecode_node_dict_size(long j, bdecode_node bdecode_nodeVar);

    public static final native long bdecode_node_int_value(long j, bdecode_node bdecode_nodeVar);

    public static final native long bdecode_node_list_at(long j, bdecode_node bdecode_nodeVar, int i);

    public static final native long bdecode_node_list_int_value_at__SWIG_0(long j, bdecode_node bdecode_nodeVar, int i, long j2);

    public static final native long bdecode_node_list_int_value_at__SWIG_1(long j, bdecode_node bdecode_nodeVar, int i);

    public static final native int bdecode_node_list_size(long j, bdecode_node bdecode_nodeVar);

    public static final native String bdecode_node_list_string_value_at_s__SWIG_0(long j, bdecode_node bdecode_nodeVar, int i, String str);

    public static final native String bdecode_node_list_string_value_at_s__SWIG_1(long j, bdecode_node bdecode_nodeVar, int i);

    public static final native boolean bdecode_node_op_bool(long j, bdecode_node bdecode_nodeVar);

    public static final native int bdecode_node_string_length(long j, bdecode_node bdecode_nodeVar);

    public static final native String bdecode_node_string_value_s(long j, bdecode_node bdecode_nodeVar);

    public static final native String bdecode_node_to_string(long j, bdecode_node bdecode_nodeVar, boolean z, int i);

    public static final native int bdecode_node_type(long j, bdecode_node bdecode_nodeVar);

    public static final native boolean bitset_96_all(long j, bitset_96 bitset_96Var);

    public static final native boolean bitset_96_any(long j, bitset_96 bitset_96Var);

    public static final native long bitset_96_count(long j, bitset_96 bitset_96Var);

    public static final native boolean bitset_96_get(long j, bitset_96 bitset_96Var, long j2);

    public static final native boolean bitset_96_none(long j, bitset_96 bitset_96Var);

    public static final native long bitset_96_size(long j, bitset_96 bitset_96Var);

    public static final native boolean bitset_96_test(long j, bitset_96 bitset_96Var, long j2);

    public static final native long block_downloading_alert_SWIGUpcast(long j);

    public static final native int block_downloading_alert_alert_type_get();

    public static final native int block_downloading_alert_block_index_get(long j, block_downloading_alert block_downloading_alertVar);

    public static final native long block_downloading_alert_category(long j, block_downloading_alert block_downloading_alertVar);

    public static final native String block_downloading_alert_message(long j, block_downloading_alert block_downloading_alertVar);

    public static final native int block_downloading_alert_piece_index_get(long j, block_downloading_alert block_downloading_alertVar);

    public static final native int block_downloading_alert_priority_get();

    public static final native long block_downloading_alert_static_category_get();

    public static final native int block_downloading_alert_type(long j, block_downloading_alert block_downloading_alertVar);

    public static final native String block_downloading_alert_what(long j, block_downloading_alert block_downloading_alertVar);

    public static final native long block_finished_alert_SWIGUpcast(long j);

    public static final native int block_finished_alert_alert_type_get();

    public static final native int block_finished_alert_block_index_get(long j, block_finished_alert block_finished_alertVar);

    public static final native long block_finished_alert_category(long j, block_finished_alert block_finished_alertVar);

    public static final native String block_finished_alert_message(long j, block_finished_alert block_finished_alertVar);

    public static final native int block_finished_alert_piece_index_get(long j, block_finished_alert block_finished_alertVar);

    public static final native int block_finished_alert_priority_get();

    public static final native long block_finished_alert_static_category_get();

    public static final native int block_finished_alert_type(long j, block_finished_alert block_finished_alertVar);

    public static final native String block_finished_alert_what(long j, block_finished_alert block_finished_alertVar);

    public static final native long block_info_block_size_get(long j, block_info block_infoVar);

    public static final native void block_info_block_size_set(long j, block_info block_infoVar, long j2);

    public static final native long block_info_bytes_progress_get(long j, block_info block_infoVar);

    public static final native void block_info_bytes_progress_set(long j, block_info block_infoVar, long j2);

    public static final native long block_info_num_peers_get(long j, block_info block_infoVar);

    public static final native void block_info_num_peers_set(long j, block_info block_infoVar, long j2);

    public static final native long block_info_peer(long j, block_info block_infoVar);

    public static final native long block_info_state_get(long j, block_info block_infoVar);

    public static final native void block_info_state_set(long j, block_info block_infoVar, long j2);

    public static final native long block_info_vector_capacity(long j, block_info_vector block_info_vectorVar);

    public static final native void block_info_vector_clear(long j, block_info_vector block_info_vectorVar);

    public static final native boolean block_info_vector_empty(long j, block_info_vector block_info_vectorVar);

    public static final native long block_info_vector_get(long j, block_info_vector block_info_vectorVar, int i);

    public static final native void block_info_vector_push_back(long j, block_info_vector block_info_vectorVar, long j2, block_info block_infoVar);

    public static final native void block_info_vector_reserve(long j, block_info_vector block_info_vectorVar, long j2);

    public static final native void block_info_vector_set(long j, block_info_vector block_info_vectorVar, int i, long j2, block_info block_infoVar);

    public static final native long block_info_vector_size(long j, block_info_vector block_info_vectorVar);

    public static final native long block_timeout_alert_SWIGUpcast(long j);

    public static final native int block_timeout_alert_alert_type_get();

    public static final native int block_timeout_alert_block_index_get(long j, block_timeout_alert block_timeout_alertVar);

    public static final native long block_timeout_alert_category(long j, block_timeout_alert block_timeout_alertVar);

    public static final native String block_timeout_alert_message(long j, block_timeout_alert block_timeout_alertVar);

    public static final native int block_timeout_alert_piece_index_get(long j, block_timeout_alert block_timeout_alertVar);

    public static final native int block_timeout_alert_priority_get();

    public static final native long block_timeout_alert_static_category_get();

    public static final native int block_timeout_alert_type(long j, block_timeout_alert block_timeout_alertVar);

    public static final native String block_timeout_alert_what(long j, block_timeout_alert block_timeout_alertVar);

    public static final native long block_uploaded_alert_SWIGUpcast(long j);

    public static final native int block_uploaded_alert_alert_type_get();

    public static final native int block_uploaded_alert_block_index_get(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native long block_uploaded_alert_category(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native String block_uploaded_alert_message(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native int block_uploaded_alert_piece_index_get(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native int block_uploaded_alert_priority_get();

    public static final native long block_uploaded_alert_static_category_get();

    public static final native int block_uploaded_alert_type(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native String block_uploaded_alert_what(long j, block_uploaded_alert block_uploaded_alertVar);

    public static final native void bloom_filter_128_clear(long j, bloom_filter_128 bloom_filter_128Var);

    public static final native boolean bloom_filter_128_find(long j, bloom_filter_128 bloom_filter_128Var, long j2, sha1_hash sha1_hashVar);

    public static final native void bloom_filter_128_from_bytes(long j, bloom_filter_128 bloom_filter_128Var, long j2, byte_vector byte_vectorVar);

    public static final native void bloom_filter_128_set(long j, bloom_filter_128 bloom_filter_128Var, long j2, sha1_hash sha1_hashVar);

    public static final native float bloom_filter_128_size(long j, bloom_filter_128 bloom_filter_128Var);

    public static final native long bloom_filter_128_to_bytes(long j, bloom_filter_128 bloom_filter_128Var);

    public static final native void bloom_filter_256_clear(long j, bloom_filter_256 bloom_filter_256Var);

    public static final native boolean bloom_filter_256_find(long j, bloom_filter_256 bloom_filter_256Var, long j2, sha1_hash sha1_hashVar);

    public static final native void bloom_filter_256_from_bytes(long j, bloom_filter_256 bloom_filter_256Var, long j2, byte_vector byte_vectorVar);

    public static final native void bloom_filter_256_set(long j, bloom_filter_256 bloom_filter_256Var, long j2, sha1_hash sha1_hashVar);

    public static final native float bloom_filter_256_size(long j, bloom_filter_256 bloom_filter_256Var);

    public static final native long bloom_filter_256_to_bytes(long j, bloom_filter_256 bloom_filter_256Var);

    public static final native String boost_lib_version();

    public static final native int boost_version();

    public static final native int broken_pipe_get();

    public static final native long bt_peer_connection_handle_SWIGUpcast(long j);

    public static final native boolean bt_peer_connection_handle_packet_finished(long j, bt_peer_connection_handle bt_peer_connection_handleVar);

    public static final native boolean bt_peer_connection_handle_support_extensions(long j, bt_peer_connection_handle bt_peer_connection_handleVar);

    public static final native boolean bt_peer_connection_handle_supports_encryption(long j, bt_peer_connection_handle bt_peer_connection_handleVar);

    public static final native byte byte_const_span_back(long j, byte_const_span byte_const_spanVar);

    public static final native boolean byte_const_span_empty(long j, byte_const_span byte_const_spanVar);

    public static final native long byte_const_span_first(long j, byte_const_span byte_const_spanVar, long j2);

    public static final native byte byte_const_span_front(long j, byte_const_span byte_const_spanVar);

    public static final native byte byte_const_span_get(long j, byte_const_span byte_const_spanVar, long j2);

    public static final native long byte_const_span_last(long j, byte_const_span byte_const_spanVar, long j2);

    public static final native long byte_const_span_size(long j, byte_const_span byte_const_spanVar);

    public static final native long byte_const_span_subspan__SWIG_0(long j, byte_const_span byte_const_spanVar, long j2);

    public static final native long byte_const_span_subspan__SWIG_1(long j, byte_const_span byte_const_spanVar, long j2, long j3);

    public static final native byte byte_span_back(long j, byte_span byte_spanVar);

    public static final native boolean byte_span_empty(long j, byte_span byte_spanVar);

    public static final native long byte_span_first(long j, byte_span byte_spanVar, long j2);

    public static final native byte byte_span_front(long j, byte_span byte_spanVar);

    public static final native byte byte_span_get(long j, byte_span byte_spanVar, long j2);

    public static final native long byte_span_last(long j, byte_span byte_spanVar, long j2);

    public static final native void byte_span_set(long j, byte_span byte_spanVar, long j2, byte b);

    public static final native long byte_span_size(long j, byte_span byte_spanVar);

    public static final native long byte_span_subspan__SWIG_0(long j, byte_span byte_spanVar, long j2);

    public static final native long byte_span_subspan__SWIG_1(long j, byte_span byte_spanVar, long j2, long j3);

    public static final native long byte_vector_capacity(long j, byte_vector byte_vectorVar);

    public static final native void byte_vector_clear(long j, byte_vector byte_vectorVar);

    public static final native boolean byte_vector_empty(long j, byte_vector byte_vectorVar);

    public static final native byte byte_vector_get(long j, byte_vector byte_vectorVar, int i);

    public static final native void byte_vector_push_back(long j, byte_vector byte_vectorVar, byte b);

    public static final native void byte_vector_reserve(long j, byte_vector byte_vectorVar, long j2);

    public static final native void byte_vector_resize(long j, byte_vector byte_vectorVar, long j2);

    public static final native void byte_vector_set(long j, byte_vector byte_vectorVar, int i, byte b);

    public static final native long byte_vector_size(long j, byte_vector byte_vectorVar);

    public static final native long byte_vectors_pair_first_get(long j, byte_vectors_pair byte_vectors_pairVar);

    public static final native void byte_vectors_pair_first_set(long j, byte_vectors_pair byte_vectors_pairVar, long j2, byte_vector byte_vectorVar);

    public static final native long byte_vectors_pair_second_get(long j, byte_vectors_pair byte_vectors_pairVar);

    public static final native void byte_vectors_pair_second_set(long j, byte_vectors_pair byte_vectors_pairVar, long j2, byte_vector byte_vectorVar);

    public static final native long cache_flushed_alert_SWIGUpcast(long j);

    public static final native int cache_flushed_alert_alert_type_get();

    public static final native long cache_flushed_alert_category(long j, cache_flushed_alert cache_flushed_alertVar);

    public static final native int cache_flushed_alert_priority_get();

    public static final native long cache_flushed_alert_static_category_get();

    public static final native int cache_flushed_alert_type(long j, cache_flushed_alert cache_flushed_alertVar);

    public static final native String cache_flushed_alert_what(long j, cache_flushed_alert cache_flushed_alertVar);

    public static final native int close_reason_t_encryption_error_get();

    public static final native int close_reason_t_none_get();

    public static final native int connection_aborted_get();

    public static final native int connection_already_in_progress_get();

    public static final native int connection_refused_get();

    public static final native int connection_reset_get();

    public static final native int cont_get();

    public static final native void copy_byte_vector_to_char_array(long j, byte_vector byte_vectorVar, String str, long j2);

    public static final native long create_flags_t_all();

    public static final native long create_flags_t_and_(long j, create_flags_t create_flags_tVar, long j2, create_flags_t create_flags_tVar2);

    public static final native boolean create_flags_t_eq(long j, create_flags_t create_flags_tVar, long j2, create_flags_t create_flags_tVar2);

    public static final native long create_flags_t_inv(long j, create_flags_t create_flags_tVar);

    public static final native boolean create_flags_t_ne(long j, create_flags_t create_flags_tVar, long j2, create_flags_t create_flags_tVar2);

    public static final native boolean create_flags_t_nonZero(long j, create_flags_t create_flags_tVar);

    public static final native long create_flags_t_or_(long j, create_flags_t create_flags_tVar, long j2, create_flags_t create_flags_tVar2);

    public static final native int create_flags_t_to_int(long j, create_flags_t create_flags_tVar);

    public static final native long create_flags_t_xor(long j, create_flags_t create_flags_tVar, long j2, create_flags_t create_flags_tVar2);

    public static final native void create_torrent_add_collection(long j, create_torrent create_torrentVar, String str);

    public static final native void create_torrent_add_http_seed(long j, create_torrent create_torrentVar, String str);

    public static final native void create_torrent_add_node(long j, create_torrent create_torrentVar, long j2, string_int_pair string_int_pairVar);

    public static final native void create_torrent_add_similar_torrent(long j, create_torrent create_torrentVar, long j2, sha1_hash sha1_hashVar);

    public static final native void create_torrent_add_tracker(long j, create_torrent create_torrentVar, String str, int i);

    public static final native void create_torrent_add_url_seed(long j, create_torrent create_torrentVar, String str);

    public static final native long create_torrent_files(long j, create_torrent create_torrentVar);

    public static final native long create_torrent_generate(long j, create_torrent create_torrentVar);

    public static final native long create_torrent_merkle_get();

    public static final native long create_torrent_merkle_tree(long j, create_torrent create_torrentVar);

    public static final native long create_torrent_modification_time_get();

    public static final native long create_torrent_mutable_torrent_support_get();

    public static final native int create_torrent_num_pieces(long j, create_torrent create_torrentVar);

    public static final native long create_torrent_optimize_alignment_get();

    public static final native int create_torrent_piece_length(long j, create_torrent create_torrentVar);

    public static final native int create_torrent_piece_size(long j, create_torrent create_torrentVar, int i);

    public static final native boolean create_torrent_priv(long j, create_torrent create_torrentVar);

    public static final native void create_torrent_set_comment(long j, create_torrent create_torrentVar, String str);

    public static final native void create_torrent_set_creator(long j, create_torrent create_torrentVar, String str);

    public static final native void create_torrent_set_file_hash(long j, create_torrent create_torrentVar, int i, long j2, sha1_hash sha1_hashVar);

    public static final native void create_torrent_set_hash(long j, create_torrent create_torrentVar, int i, long j2, sha1_hash sha1_hashVar);

    public static final native void create_torrent_set_priv(long j, create_torrent create_torrentVar, boolean z);

    public static final native void create_torrent_set_root_cert2(long j, create_torrent create_torrentVar, long j2, byte_vector byte_vectorVar);

    public static final native long create_torrent_symlinks_get();

    public static final native int created_get();

    public static final native int cross_device_link_get();

    public static final native long deadline_flags_t_all();

    public static final native long deadline_flags_t_and_(long j, deadline_flags_t deadline_flags_tVar, long j2, deadline_flags_t deadline_flags_tVar2);

    public static final native boolean deadline_flags_t_eq(long j, deadline_flags_t deadline_flags_tVar, long j2, deadline_flags_t deadline_flags_tVar2);

    public static final native long deadline_flags_t_inv(long j, deadline_flags_t deadline_flags_tVar);

    public static final native boolean deadline_flags_t_ne(long j, deadline_flags_t deadline_flags_tVar, long j2, deadline_flags_t deadline_flags_tVar2);

    public static final native boolean deadline_flags_t_nonZero(long j, deadline_flags_t deadline_flags_tVar);

    public static final native long deadline_flags_t_or_(long j, deadline_flags_t deadline_flags_tVar, long j2, deadline_flags_t deadline_flags_tVar2);

    public static final native int deadline_flags_t_to_int(long j, deadline_flags_t deadline_flags_tVar);

    public static final native long deadline_flags_t_xor(long j, deadline_flags_t deadline_flags_tVar, long j2, deadline_flags_t deadline_flags_tVar2);

    public static final native long default_flags_get();

    public static final native long default_settings();

    public static final native void delete_add_files_listener(long j);

    public static final native void delete_add_piece_flags_t(long j);

    public static final native void delete_add_torrent_alert(long j);

    public static final native void delete_add_torrent_params(long j);

    public static final native void delete_address(long j);

    public static final native void delete_address_sha1_hash_pair(long j);

    public static final native void delete_address_sha1_hash_pair_vector(long j);

    public static final native void delete_alert(long j);

    public static final native void delete_alert_category_t(long j);

    public static final native void delete_alert_notify_callback(long j);

    public static final native void delete_alert_ptr_vector(long j);

    public static final native void delete_alerts_dropped_alert(long j);

    public static final native void delete_announce_endpoint(long j);

    public static final native void delete_announce_endpoint_vector(long j);

    public static final native void delete_announce_entry(long j);

    public static final native void delete_announce_entry_vector(long j);

    public static final native void delete_bandwidth_state_flags_t(long j);

    public static final native void delete_bdecode_node(long j);

    public static final native void delete_bitset_96(long j);

    public static final native void delete_block_downloading_alert(long j);

    public static final native void delete_block_finished_alert(long j);

    public static final native void delete_block_info(long j);

    public static final native void delete_block_info_vector(long j);

    public static final native void delete_block_timeout_alert(long j);

    public static final native void delete_block_uploaded_alert(long j);

    public static final native void delete_bloom_filter_128(long j);

    public static final native void delete_bloom_filter_256(long j);

    public static final native void delete_bt_peer_connection_handle(long j);

    public static final native void delete_byte_const_span(long j);

    public static final native void delete_byte_span(long j);

    public static final native void delete_byte_vector(long j);

    public static final native void delete_byte_vectors_pair(long j);

    public static final native void delete_cache_flushed_alert(long j);

    public static final native void delete_create_flags_t(long j);

    public static final native void delete_create_torrent(long j);

    public static final native void delete_deadline_flags_t(long j);

    public static final native void delete_dht_announce_alert(long j);

    public static final native void delete_dht_bootstrap_alert(long j);

    public static final native void delete_dht_direct_response_alert(long j);

    public static final native void delete_dht_error_alert(long j);

    public static final native void delete_dht_get_peers_alert(long j);

    public static final native void delete_dht_get_peers_reply_alert(long j);

    public static final native void delete_dht_immutable_item_alert(long j);

    public static final native void delete_dht_live_nodes_alert(long j);

    public static final native void delete_dht_log_alert(long j);

    public static final native void delete_dht_lookup(long j);

    public static final native void delete_dht_lookup_vector(long j);

    public static final native void delete_dht_mutable_item_alert(long j);

    public static final native void delete_dht_outgoing_get_peers_alert(long j);

    public static final native void delete_dht_pkt_alert(long j);

    public static final native void delete_dht_put_alert(long j);

    public static final native void delete_dht_reply_alert(long j);

    public static final native void delete_dht_routing_bucket(long j);

    public static final native void delete_dht_routing_bucket_vector(long j);

    public static final native void delete_dht_sample_infohashes_alert(long j);

    public static final native void delete_dht_settings(long j);

    public static final native void delete_dht_state(long j);

    public static final native void delete_dht_stats_alert(long j);

    public static final native void delete_entry(long j);

    public static final native void delete_entry_vector(long j);

    public static final native void delete_error_code(long j);

    public static final native void delete_external_ip_alert(long j);

    public static final native void delete_fastresume_rejected_alert(long j);

    public static final native void delete_file_completed_alert(long j);

    public static final native void delete_file_error_alert(long j);

    public static final native void delete_file_flags_t(long j);

    public static final native void delete_file_index_string_map(long j);

    public static final native void delete_file_index_vector(long j);

    public static final native void delete_file_rename_failed_alert(long j);

    public static final native void delete_file_renamed_alert(long j);

    public static final native void delete_file_slice(long j);

    public static final native void delete_file_slice_vector(long j);

    public static final native void delete_file_storage(long j);

    public static final native void delete_generic_error_category(long j);

    public static final native void delete_hash_failed_alert(long j);

    public static final native void delete_i2p_alert(long j);

    public static final native void delete_incoming_connection_alert(long j);

    public static final native void delete_incoming_request_alert(long j);

    public static final native void delete_int64_vector(long j);

    public static final native void delete_int_vector(long j);

    public static final native void delete_invalid_request_alert(long j);

    public static final native void delete_ip_filter(long j);

    public static final native void delete_ip_interface(long j);

    public static final native void delete_ip_interface_vector(long j);

    public static final native void delete_ip_route(long j);

    public static final native void delete_ip_route_vector(long j);

    public static final native void delete_listen_failed_alert(long j);

    public static final native void delete_listen_succeeded_alert(long j);

    public static final native void delete_load_torrent_limits(long j);

    public static final native void delete_log_alert(long j);

    public static final native void delete_lsd_error_alert(long j);

    public static final native void delete_lsd_peer_alert(long j);

    public static final native void delete_metadata_failed_alert(long j);

    public static final native void delete_metadata_received_alert(long j);

    public static final native void delete_partial_piece_info(long j);

    public static final native void delete_partial_piece_info_vector(long j);

    public static final native void delete_pause_flags_t(long j);

    public static final native void delete_peer_alert(long j);

    public static final native void delete_peer_ban_alert(long j);

    public static final native void delete_peer_blocked_alert(long j);

    public static final native void delete_peer_class_info(long j);

    public static final native void delete_peer_class_type_filter(long j);

    public static final native void delete_peer_connect_alert(long j);

    public static final native void delete_peer_connection_handle(long j);

    public static final native void delete_peer_disconnected_alert(long j);

    public static final native void delete_peer_error_alert(long j);

    public static final native void delete_peer_flags_t(long j);

    public static final native void delete_peer_info(long j);

    public static final native void delete_peer_info_vector(long j);

    public static final native void delete_peer_log_alert(long j);

    public static final native void delete_peer_request(long j);

    public static final native void delete_peer_snubbed_alert(long j);

    public static final native void delete_peer_source_flags_t(long j);

    public static final native void delete_peer_unsnubbed_alert(long j);

    public static final native void delete_performance_alert(long j);

    public static final native void delete_pex_flags_t(long j);

    public static final native void delete_picker_flags_t(long j);

    public static final native void delete_picker_log_alert(long j);

    public static final native void delete_piece_finished_alert(long j);

    public static final native void delete_piece_index_bitfield(long j);

    public static final native void delete_piece_index_int_pair(long j);

    public static final native void delete_piece_index_int_pair_vector(long j);

    public static final native void delete_piece_index_vector(long j);

    public static final native void delete_port_filter(long j);

    public static final native void delete_port_mapping_t_vector(long j);

    public static final native void delete_portmap_alert(long j);

    public static final native void delete_portmap_error_alert(long j);

    public static final native void delete_portmap_log_alert(long j);

    public static final native void delete_posix_stat_t(long j);

    public static final native void delete_posix_wrapper(long j);

    public static final native void delete_read_piece_alert(long j);

    public static final native void delete_reannounce_flags_t(long j);

    public static final native void delete_remove_flags_t(long j);

    public static final native void delete_reopen_network_flags_t(long j);

    public static final native void delete_request_dropped_alert(long j);

    public static final native void delete_resume_data_flags_t(long j);

    public static final native void delete_save_resume_data_alert(long j);

    public static final native void delete_save_resume_data_failed_alert(long j);

    public static final native void delete_save_state_flags_t(long j);

    public static final native void delete_scrape_failed_alert(long j);

    public static final native void delete_scrape_reply_alert(long j);

    public static final native void delete_session(long j);

    public static final native void delete_session_error_alert(long j);

    public static final native void delete_session_flags_t(long j);

    public static final native void delete_session_handle(long j);

    public static final native void delete_session_params(long j);

    public static final native void delete_session_proxy(long j);

    public static final native void delete_session_stats_alert(long j);

    public static final native void delete_session_stats_header_alert(long j);

    public static final native void delete_set_piece_hashes_listener(long j);

    public static final native void delete_settings(long j);

    public static final native void delete_settings_pack(long j);

    public static final native void delete_sha1_hash(long j);

    public static final native void delete_sha1_hash_udp_endpoint_pair(long j);

    public static final native void delete_sha1_hash_udp_endpoint_pair_vector(long j);

    public static final native void delete_sha1_hash_vector(long j);

    public static final native void delete_socks5_alert(long j);

    public static final native void delete_state_changed_alert(long j);

    public static final native void delete_state_update_alert(long j);

    public static final native void delete_stats_alert(long j);

    public static final native void delete_stats_metric(long j);

    public static final native void delete_stats_metric_vector(long j);

    public static final native void delete_status_flags_t(long j);

    public static final native void delete_storage_moved_alert(long j);

    public static final native void delete_storage_moved_failed_alert(long j);

    public static final native void delete_string_entry_map(long j);

    public static final native void delete_string_int_pair(long j);

    public static final native void delete_string_int_pair_vector(long j);

    public static final native void delete_string_long_map(long j);

    public static final native void delete_string_string_pair(long j);

    public static final native void delete_string_string_pair_vector(long j);

    public static final native void delete_string_vector(long j);

    public static final native void delete_string_view(long j);

    public static final native void delete_string_view_bdecode_node_pair(long j);

    public static final native void delete_swig_plugin(long j);

    public static final native void delete_system_error_category(long j);

    public static final native void delete_tcp_endpoint(long j);

    public static final native void delete_tcp_endpoint_vector(long j);

    public static final native void delete_torrent_alert(long j);

    public static final native void delete_torrent_checked_alert(long j);

    public static final native void delete_torrent_delete_failed_alert(long j);

    public static final native void delete_torrent_deleted_alert(long j);

    public static final native void delete_torrent_error_alert(long j);

    public static final native void delete_torrent_finished_alert(long j);

    public static final native void delete_torrent_flags_t(long j);

    public static final native void delete_torrent_handle(long j);

    public static final native void delete_torrent_handle_vector(long j);

    public static final native void delete_torrent_info(long j);

    public static final native void delete_torrent_log_alert(long j);

    public static final native void delete_torrent_need_cert_alert(long j);

    public static final native void delete_torrent_paused_alert(long j);

    public static final native void delete_torrent_removed_alert(long j);

    public static final native void delete_torrent_resumed_alert(long j);

    public static final native void delete_torrent_status(long j);

    public static final native void delete_torrent_status_vector(long j);

    public static final native void delete_tracker_alert(long j);

    public static final native void delete_tracker_announce_alert(long j);

    public static final native void delete_tracker_error_alert(long j);

    public static final native void delete_tracker_reply_alert(long j);

    public static final native void delete_tracker_warning_alert(long j);

    public static final native void delete_trackerid_alert(long j);

    public static final native void delete_udp_endpoint(long j);

    public static final native void delete_udp_endpoint_vector(long j);

    public static final native void delete_udp_error_alert(long j);

    public static final native void delete_unwanted_block_alert(long j);

    public static final native void delete_url_seed_alert(long j);

    public static final native void delete_web_seed_entry(long j);

    public static final native void delete_web_seed_entry_vector(long j);

    public static final native int destination_address_required_get();

    public static final native int device_or_resource_busy_get();

    public static final native long dht_announce_alert_SWIGUpcast(long j);

    public static final native int dht_announce_alert_alert_type_get();

    public static final native long dht_announce_alert_category(long j, dht_announce_alert dht_announce_alertVar);

    public static final native long dht_announce_alert_get_ip(long j, dht_announce_alert dht_announce_alertVar);

    public static final native long dht_announce_alert_info_hash_get(long j, dht_announce_alert dht_announce_alertVar);

    public static final native void dht_announce_alert_info_hash_set(long j, dht_announce_alert dht_announce_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String dht_announce_alert_message(long j, dht_announce_alert dht_announce_alertVar);

    public static final native int dht_announce_alert_port_get(long j, dht_announce_alert dht_announce_alertVar);

    public static final native void dht_announce_alert_port_set(long j, dht_announce_alert dht_announce_alertVar, int i);

    public static final native int dht_announce_alert_priority_get();

    public static final native long dht_announce_alert_static_category_get();

    public static final native int dht_announce_alert_type(long j, dht_announce_alert dht_announce_alertVar);

    public static final native String dht_announce_alert_what(long j, dht_announce_alert dht_announce_alertVar);

    public static final native long dht_bootstrap_alert_SWIGUpcast(long j);

    public static final native int dht_bootstrap_alert_alert_type_get();

    public static final native long dht_bootstrap_alert_category(long j, dht_bootstrap_alert dht_bootstrap_alertVar);

    public static final native String dht_bootstrap_alert_message(long j, dht_bootstrap_alert dht_bootstrap_alertVar);

    public static final native int dht_bootstrap_alert_priority_get();

    public static final native long dht_bootstrap_alert_static_category_get();

    public static final native int dht_bootstrap_alert_type(long j, dht_bootstrap_alert dht_bootstrap_alertVar);

    public static final native String dht_bootstrap_alert_what(long j, dht_bootstrap_alert dht_bootstrap_alertVar);

    public static final native long dht_direct_response_alert_SWIGUpcast(long j);

    public static final native int dht_direct_response_alert_alert_type_get();

    public static final native long dht_direct_response_alert_category(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native long dht_direct_response_alert_get_endpoint(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native long dht_direct_response_alert_get_userdata(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native String dht_direct_response_alert_message(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native int dht_direct_response_alert_priority_get();

    public static final native long dht_direct_response_alert_response(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native long dht_direct_response_alert_static_category_get();

    public static final native int dht_direct_response_alert_type(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native String dht_direct_response_alert_what(long j, dht_direct_response_alert dht_direct_response_alertVar);

    public static final native long dht_error_alert_SWIGUpcast(long j);

    public static final native int dht_error_alert_alert_type_get();

    public static final native long dht_error_alert_category(long j, dht_error_alert dht_error_alertVar);

    public static final native long dht_error_alert_error_get(long j, dht_error_alert dht_error_alertVar);

    public static final native void dht_error_alert_error_set(long j, dht_error_alert dht_error_alertVar, long j2, error_code error_codeVar);

    public static final native String dht_error_alert_message(long j, dht_error_alert dht_error_alertVar);

    public static final native int dht_error_alert_op_get(long j, dht_error_alert dht_error_alertVar);

    public static final native void dht_error_alert_op_set(long j, dht_error_alert dht_error_alertVar, int i);

    public static final native int dht_error_alert_priority_get();

    public static final native long dht_error_alert_static_category_get();

    public static final native int dht_error_alert_type(long j, dht_error_alert dht_error_alertVar);

    public static final native String dht_error_alert_what(long j, dht_error_alert dht_error_alertVar);

    public static final native long dht_get_peers_alert_SWIGUpcast(long j);

    public static final native int dht_get_peers_alert_alert_type_get();

    public static final native long dht_get_peers_alert_category(long j, dht_get_peers_alert dht_get_peers_alertVar);

    public static final native long dht_get_peers_alert_info_hash_get(long j, dht_get_peers_alert dht_get_peers_alertVar);

    public static final native void dht_get_peers_alert_info_hash_set(long j, dht_get_peers_alert dht_get_peers_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String dht_get_peers_alert_message(long j, dht_get_peers_alert dht_get_peers_alertVar);

    public static final native int dht_get_peers_alert_priority_get();

    public static final native long dht_get_peers_alert_static_category_get();

    public static final native int dht_get_peers_alert_type(long j, dht_get_peers_alert dht_get_peers_alertVar);

    public static final native String dht_get_peers_alert_what(long j, dht_get_peers_alert dht_get_peers_alertVar);

    public static final native long dht_get_peers_reply_alert_SWIGUpcast(long j);

    public static final native int dht_get_peers_reply_alert_alert_type_get();

    public static final native long dht_get_peers_reply_alert_category(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native long dht_get_peers_reply_alert_info_hash_get(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native void dht_get_peers_reply_alert_info_hash_set(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String dht_get_peers_reply_alert_message(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native int dht_get_peers_reply_alert_num_peers(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native long dht_get_peers_reply_alert_peers(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native int dht_get_peers_reply_alert_priority_get();

    public static final native long dht_get_peers_reply_alert_static_category_get();

    public static final native int dht_get_peers_reply_alert_type(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native String dht_get_peers_reply_alert_what(long j, dht_get_peers_reply_alert dht_get_peers_reply_alertVar);

    public static final native long dht_immutable_item_alert_SWIGUpcast(long j);

    public static final native int dht_immutable_item_alert_alert_type_get();

    public static final native long dht_immutable_item_alert_category(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native long dht_immutable_item_alert_item_get(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native void dht_immutable_item_alert_item_set(long j, dht_immutable_item_alert dht_immutable_item_alertVar, long j2, entry entryVar);

    public static final native String dht_immutable_item_alert_message(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native int dht_immutable_item_alert_priority_get();

    public static final native long dht_immutable_item_alert_static_category_get();

    public static final native long dht_immutable_item_alert_target_get(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native void dht_immutable_item_alert_target_set(long j, dht_immutable_item_alert dht_immutable_item_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native int dht_immutable_item_alert_type(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native String dht_immutable_item_alert_what(long j, dht_immutable_item_alert dht_immutable_item_alertVar);

    public static final native long dht_live_nodes_alert_SWIGUpcast(long j);

    public static final native int dht_live_nodes_alert_alert_type_get();

    public static final native long dht_live_nodes_alert_category(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native String dht_live_nodes_alert_message(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native long dht_live_nodes_alert_node_id_get(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native void dht_live_nodes_alert_node_id_set(long j, dht_live_nodes_alert dht_live_nodes_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native long dht_live_nodes_alert_nodes(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native int dht_live_nodes_alert_num_nodes(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native int dht_live_nodes_alert_priority_get();

    public static final native long dht_live_nodes_alert_static_category_get();

    public static final native int dht_live_nodes_alert_type(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native String dht_live_nodes_alert_what(long j, dht_live_nodes_alert dht_live_nodes_alertVar);

    public static final native long dht_log_alert_SWIGUpcast(long j);

    public static final native int dht_log_alert_alert_type_get();

    public static final native long dht_log_alert_category(long j, dht_log_alert dht_log_alertVar);

    public static final native String dht_log_alert_log_message(long j, dht_log_alert dht_log_alertVar);

    public static final native String dht_log_alert_message(long j, dht_log_alert dht_log_alertVar);

    public static final native int dht_log_alert_module_get(long j, dht_log_alert dht_log_alertVar);

    public static final native void dht_log_alert_module_set(long j, dht_log_alert dht_log_alertVar, int i);

    public static final native int dht_log_alert_priority_get();

    public static final native long dht_log_alert_static_category_get();

    public static final native int dht_log_alert_type(long j, dht_log_alert dht_log_alertVar);

    public static final native String dht_log_alert_what(long j, dht_log_alert dht_log_alertVar);

    public static final native int dht_lookup_branch_factor_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_branch_factor_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native int dht_lookup_first_timeout_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_first_timeout_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native String dht_lookup_get_type(long j, dht_lookup dht_lookupVar);

    public static final native int dht_lookup_last_sent_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_last_sent_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native int dht_lookup_nodes_left_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_nodes_left_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native int dht_lookup_outstanding_requests_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_outstanding_requests_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native int dht_lookup_responses_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_responses_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native long dht_lookup_target_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_target_set(long j, dht_lookup dht_lookupVar, long j2, sha1_hash sha1_hashVar);

    public static final native int dht_lookup_timeouts_get(long j, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_timeouts_set(long j, dht_lookup dht_lookupVar, int i);

    public static final native long dht_lookup_vector_capacity(long j, dht_lookup_vector dht_lookup_vectorVar);

    public static final native void dht_lookup_vector_clear(long j, dht_lookup_vector dht_lookup_vectorVar);

    public static final native boolean dht_lookup_vector_empty(long j, dht_lookup_vector dht_lookup_vectorVar);

    public static final native long dht_lookup_vector_get(long j, dht_lookup_vector dht_lookup_vectorVar, int i);

    public static final native void dht_lookup_vector_push_back(long j, dht_lookup_vector dht_lookup_vectorVar, long j2, dht_lookup dht_lookupVar);

    public static final native void dht_lookup_vector_reserve(long j, dht_lookup_vector dht_lookup_vectorVar, long j2);

    public static final native void dht_lookup_vector_set(long j, dht_lookup_vector dht_lookup_vectorVar, int i, long j2, dht_lookup dht_lookupVar);

    public static final native long dht_lookup_vector_size(long j, dht_lookup_vector dht_lookup_vectorVar);

    public static final native long dht_mutable_item_alert_SWIGUpcast(long j);

    public static final native int dht_mutable_item_alert_alert_type_get();

    public static final native boolean dht_mutable_item_alert_authoritative_get(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native void dht_mutable_item_alert_authoritative_set(long j, dht_mutable_item_alert dht_mutable_item_alertVar, boolean z);

    public static final native long dht_mutable_item_alert_category(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_mutable_item_alert_get_key(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_mutable_item_alert_get_salt(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_mutable_item_alert_get_seq(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_mutable_item_alert_get_signature(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_mutable_item_alert_item_get(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native void dht_mutable_item_alert_item_set(long j, dht_mutable_item_alert dht_mutable_item_alertVar, long j2, entry entryVar);

    public static final native String dht_mutable_item_alert_message(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native int dht_mutable_item_alert_priority_get();

    public static final native long dht_mutable_item_alert_static_category_get();

    public static final native int dht_mutable_item_alert_type(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native String dht_mutable_item_alert_what(long j, dht_mutable_item_alert dht_mutable_item_alertVar);

    public static final native long dht_outgoing_get_peers_alert_SWIGUpcast(long j);

    public static final native int dht_outgoing_get_peers_alert_alert_type_get();

    public static final native long dht_outgoing_get_peers_alert_category(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native long dht_outgoing_get_peers_alert_get_endpoint(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native long dht_outgoing_get_peers_alert_info_hash_get(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native void dht_outgoing_get_peers_alert_info_hash_set(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String dht_outgoing_get_peers_alert_message(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native long dht_outgoing_get_peers_alert_obfuscated_info_hash_get(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native void dht_outgoing_get_peers_alert_obfuscated_info_hash_set(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native int dht_outgoing_get_peers_alert_priority_get();

    public static final native long dht_outgoing_get_peers_alert_static_category_get();

    public static final native int dht_outgoing_get_peers_alert_type(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native String dht_outgoing_get_peers_alert_what(long j, dht_outgoing_get_peers_alert dht_outgoing_get_peers_alertVar);

    public static final native long dht_pkt_alert_SWIGUpcast(long j);

    public static final native int dht_pkt_alert_alert_type_get();

    public static final native long dht_pkt_alert_category(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native int dht_pkt_alert_direction_get(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native void dht_pkt_alert_direction_set(long j, dht_pkt_alert dht_pkt_alertVar, int i);

    public static final native long dht_pkt_alert_get_node(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native String dht_pkt_alert_message(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native long dht_pkt_alert_pkt_buf(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native int dht_pkt_alert_priority_get();

    public static final native long dht_pkt_alert_static_category_get();

    public static final native int dht_pkt_alert_type(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native String dht_pkt_alert_what(long j, dht_pkt_alert dht_pkt_alertVar);

    public static final native long dht_put_alert_SWIGUpcast(long j);

    public static final native int dht_put_alert_alert_type_get();

    public static final native long dht_put_alert_category(long j, dht_put_alert dht_put_alertVar);

    public static final native long dht_put_alert_get_public_key(long j, dht_put_alert dht_put_alertVar);

    public static final native long dht_put_alert_get_salt(long j, dht_put_alert dht_put_alertVar);

    public static final native long dht_put_alert_get_seq(long j, dht_put_alert dht_put_alertVar);

    public static final native long dht_put_alert_get_signature(long j, dht_put_alert dht_put_alertVar);

    public static final native String dht_put_alert_message(long j, dht_put_alert dht_put_alertVar);

    public static final native int dht_put_alert_num_success_get(long j, dht_put_alert dht_put_alertVar);

    public static final native void dht_put_alert_num_success_set(long j, dht_put_alert dht_put_alertVar, int i);

    public static final native int dht_put_alert_priority_get();

    public static final native long dht_put_alert_static_category_get();

    public static final native long dht_put_alert_target_get(long j, dht_put_alert dht_put_alertVar);

    public static final native void dht_put_alert_target_set(long j, dht_put_alert dht_put_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native int dht_put_alert_type(long j, dht_put_alert dht_put_alertVar);

    public static final native String dht_put_alert_what(long j, dht_put_alert dht_put_alertVar);

    public static final native long dht_reply_alert_SWIGUpcast(long j);

    public static final native int dht_reply_alert_alert_type_get();

    public static final native long dht_reply_alert_category(long j, dht_reply_alert dht_reply_alertVar);

    public static final native String dht_reply_alert_message(long j, dht_reply_alert dht_reply_alertVar);

    public static final native int dht_reply_alert_num_peers_get(long j, dht_reply_alert dht_reply_alertVar);

    public static final native int dht_reply_alert_priority_get();

    public static final native long dht_reply_alert_static_category_get();

    public static final native int dht_reply_alert_type(long j, dht_reply_alert dht_reply_alertVar);

    public static final native String dht_reply_alert_what(long j, dht_reply_alert dht_reply_alertVar);

    public static final native int dht_routing_bucket_last_active_get(long j, dht_routing_bucket dht_routing_bucketVar);

    public static final native void dht_routing_bucket_last_active_set(long j, dht_routing_bucket dht_routing_bucketVar, int i);

    public static final native int dht_routing_bucket_num_nodes_get(long j, dht_routing_bucket dht_routing_bucketVar);

    public static final native void dht_routing_bucket_num_nodes_set(long j, dht_routing_bucket dht_routing_bucketVar, int i);

    public static final native int dht_routing_bucket_num_replacements_get(long j, dht_routing_bucket dht_routing_bucketVar);

    public static final native void dht_routing_bucket_num_replacements_set(long j, dht_routing_bucket dht_routing_bucketVar, int i);

    public static final native long dht_routing_bucket_vector_capacity(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar);

    public static final native void dht_routing_bucket_vector_clear(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar);

    public static final native boolean dht_routing_bucket_vector_empty(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar);

    public static final native long dht_routing_bucket_vector_get(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar, int i);

    public static final native void dht_routing_bucket_vector_push_back(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar, long j2, dht_routing_bucket dht_routing_bucketVar);

    public static final native void dht_routing_bucket_vector_reserve(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar, long j2);

    public static final native void dht_routing_bucket_vector_set(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar, int i, long j2, dht_routing_bucket dht_routing_bucketVar);

    public static final native long dht_routing_bucket_vector_size(long j, dht_routing_bucket_vector dht_routing_bucket_vectorVar);

    public static final native long dht_sample_infohashes_alert_SWIGUpcast(long j);

    public static final native int dht_sample_infohashes_alert_alert_type_get();

    public static final native long dht_sample_infohashes_alert_category(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native long dht_sample_infohashes_alert_get_endpoint(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native long dht_sample_infohashes_alert_get_interval(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native String dht_sample_infohashes_alert_message(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native long dht_sample_infohashes_alert_nodes(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native int dht_sample_infohashes_alert_num_infohashes_get(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native int dht_sample_infohashes_alert_num_nodes(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native int dht_sample_infohashes_alert_num_samples(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native int dht_sample_infohashes_alert_priority_get();

    public static final native long dht_sample_infohashes_alert_samples(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native long dht_sample_infohashes_alert_static_category_get();

    public static final native int dht_sample_infohashes_alert_type(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native String dht_sample_infohashes_alert_what(long j, dht_sample_infohashes_alert dht_sample_infohashes_alertVar);

    public static final native boolean dht_settings_aggressive_lookups_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_aggressive_lookups_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native int dht_settings_block_ratelimit_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_block_ratelimit_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_block_timeout_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_block_timeout_set(long j, dht_settings dht_settingsVar, int i);

    public static final native boolean dht_settings_enforce_node_id_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_enforce_node_id_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native boolean dht_settings_extended_routing_table_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_extended_routing_table_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native boolean dht_settings_ignore_dark_internet_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_ignore_dark_internet_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native int dht_settings_item_lifetime_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_item_lifetime_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_dht_items_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_dht_items_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_fail_count_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_fail_count_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_infohashes_sample_count_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_infohashes_sample_count_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_peers_get(long j, dht_settings dht_settingsVar);

    public static final native int dht_settings_max_peers_reply_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_peers_reply_set(long j, dht_settings dht_settingsVar, int i);

    public static final native void dht_settings_max_peers_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_torrent_search_reply_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_torrent_search_reply_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_max_torrents_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_max_torrents_set(long j, dht_settings dht_settingsVar, int i);

    public static final native boolean dht_settings_privacy_lookups_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_privacy_lookups_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native boolean dht_settings_read_only_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_read_only_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native boolean dht_settings_restrict_routing_ips_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_restrict_routing_ips_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native boolean dht_settings_restrict_search_ips_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_restrict_search_ips_set(long j, dht_settings dht_settingsVar, boolean z);

    public static final native int dht_settings_sample_infohashes_interval_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_sample_infohashes_interval_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_search_branching_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_search_branching_set(long j, dht_settings dht_settingsVar, int i);

    public static final native int dht_settings_upload_rate_limit_get(long j, dht_settings dht_settingsVar);

    public static final native void dht_settings_upload_rate_limit_set(long j, dht_settings dht_settingsVar, int i);

    public static final native void dht_state_clear(long j, dht_state dht_stateVar);

    public static final native long dht_state_nids_get(long j, dht_state dht_stateVar);

    public static final native void dht_state_nids_set(long j, dht_state dht_stateVar, long j2, address_sha1_hash_pair_vector address_sha1_hash_pair_vectorVar);

    public static final native long dht_state_nodes6_get(long j, dht_state dht_stateVar);

    public static final native void dht_state_nodes6_set(long j, dht_state dht_stateVar, long j2, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native long dht_state_nodes_get(long j, dht_state dht_stateVar);

    public static final native void dht_state_nodes_set(long j, dht_state dht_stateVar, long j2, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native long dht_stats_alert_SWIGUpcast(long j);

    public static final native long dht_stats_alert_active_requests_get(long j, dht_stats_alert dht_stats_alertVar);

    public static final native void dht_stats_alert_active_requests_set(long j, dht_stats_alert dht_stats_alertVar, long j2, dht_lookup_vector dht_lookup_vectorVar);

    public static final native int dht_stats_alert_alert_type_get();

    public static final native long dht_stats_alert_category(long j, dht_stats_alert dht_stats_alertVar);

    public static final native String dht_stats_alert_message(long j, dht_stats_alert dht_stats_alertVar);

    public static final native int dht_stats_alert_priority_get();

    public static final native long dht_stats_alert_routing_table_get(long j, dht_stats_alert dht_stats_alertVar);

    public static final native void dht_stats_alert_routing_table_set(long j, dht_stats_alert dht_stats_alertVar, long j2, dht_routing_bucket_vector dht_routing_bucket_vectorVar);

    public static final native long dht_stats_alert_static_category_get();

    public static final native int dht_stats_alert_type(long j, dht_stats_alert dht_stats_alertVar);

    public static final native String dht_stats_alert_what(long j, dht_stats_alert dht_stats_alertVar);

    public static final native long directBufferAddress(Buffer buffer);

    public static final native long directBufferCapacity(Buffer buffer);

    public static final native int directory_not_empty_get();

    public static final native long disable_dht_get();

    public static final native long disable_lsd_get();

    public static final native long disable_pex_get();

    public static final native long duplicate_is_error_get();

    public static final native long ed25519_add_scalar_public(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2);

    public static final native long ed25519_add_scalar_secret(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2);

    public static final native long ed25519_create_keypair(long j, byte_vector byte_vectorVar);

    public static final native long ed25519_create_seed();

    public static final native long ed25519_key_exchange(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2);

    public static final native long ed25519_sign(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2, long j3, byte_vector byte_vectorVar3);

    public static final native boolean ed25519_verify(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2, long j3, byte_vector byte_vectorVar3);

    public static final native long entry_bdecode(long j, byte_vector byte_vectorVar);

    public static final native long entry_bencode(long j, entry entryVar);

    public static final native long entry_dict(long j, entry entryVar);

    public static final native long entry_find_key(long j, entry entryVar, long j2, string_view string_viewVar);

    public static final native long entry_from_preformatted_bytes(long j, byte_vector byte_vectorVar);

    public static final native long entry_from_string_bytes(long j, byte_vector byte_vectorVar);

    public static final native long entry_get(long j, entry entryVar, String str);

    public static final native long entry_integer(long j, entry entryVar);

    public static final native long entry_list(long j, entry entryVar);

    public static final native long entry_preformatted_bytes(long j, entry entryVar);

    public static final native void entry_set__SWIG_0(long j, entry entryVar, String str, String str2);

    public static final native void entry_set__SWIG_1(long j, entry entryVar, String str, long j2, byte_vector byte_vectorVar);

    public static final native void entry_set__SWIG_2(long j, entry entryVar, String str, long j2);

    public static final native void entry_set__SWIG_3(long j, entry entryVar, String str, long j2, entry entryVar2);

    public static final native String entry_string(long j, entry entryVar);

    public static final native long entry_string_bytes(long j, entry entryVar);

    public static final native String entry_to_string(long j, entry entryVar);

    public static final native int entry_type(long j, entry entryVar);

    public static final native long entry_vector_capacity(long j, entry_vector entry_vectorVar);

    public static final native void entry_vector_clear(long j, entry_vector entry_vectorVar);

    public static final native boolean entry_vector_empty(long j, entry_vector entry_vectorVar);

    public static final native long entry_vector_get(long j, entry_vector entry_vectorVar, int i);

    public static final native void entry_vector_push_back(long j, entry_vector entry_vectorVar, long j2, entry entryVar);

    public static final native void entry_vector_reserve(long j, entry_vector entry_vectorVar, long j2);

    public static final native void entry_vector_set(long j, entry_vector entry_vectorVar, int i, long j2, entry entryVar);

    public static final native long entry_vector_size(long j, entry_vector entry_vectorVar);

    public static final native long enum_net_interfaces(long j, C2430session c2430session);

    public static final native long enum_routes(long j, C2430session c2430session);

    public static final native void error_code_clear(long j, error_code error_codeVar);

    public static final native boolean error_code_failed(long j, error_code error_codeVar);

    public static final native String error_code_message__SWIG_0(long j, error_code error_codeVar);

    public static final native String error_code_message__SWIG_1(long j, error_code error_codeVar, String str, long j2);

    public static final native boolean error_code_op_bool(long j, error_code error_codeVar);

    public static final native int error_code_value(long j, error_code error_codeVar);

    public static final native int executable_format_error_get();

    public static final native long external_ip_alert_SWIGUpcast(long j);

    public static final native int external_ip_alert_alert_type_get();

    public static final native long external_ip_alert_category(long j, external_ip_alert external_ip_alertVar);

    public static final native long external_ip_alert_get_external_address(long j, external_ip_alert external_ip_alertVar);

    public static final native String external_ip_alert_message(long j, external_ip_alert external_ip_alertVar);

    public static final native int external_ip_alert_priority_get();

    public static final native long external_ip_alert_static_category_get();

    public static final native int external_ip_alert_type(long j, external_ip_alert external_ip_alertVar);

    public static final native String external_ip_alert_what(long j, external_ip_alert external_ip_alertVar);

    public static final native boolean failed_impl(int i, long j);

    public static final native long fastresume_rejected_alert_SWIGUpcast(long j);

    public static final native int fastresume_rejected_alert_alert_type_get();

    public static final native long fastresume_rejected_alert_category(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native long fastresume_rejected_alert_error_get(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native void fastresume_rejected_alert_error_set(long j, fastresume_rejected_alert fastresume_rejected_alertVar, long j2, error_code error_codeVar);

    public static final native String fastresume_rejected_alert_file_path(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native String fastresume_rejected_alert_message(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native int fastresume_rejected_alert_op_get(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native void fastresume_rejected_alert_op_set(long j, fastresume_rejected_alert fastresume_rejected_alertVar, int i);

    public static final native int fastresume_rejected_alert_priority_get();

    public static final native long fastresume_rejected_alert_static_category_get();

    public static final native int fastresume_rejected_alert_type(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native String fastresume_rejected_alert_what(long j, fastresume_rejected_alert fastresume_rejected_alertVar);

    public static final native long file_completed_alert_SWIGUpcast(long j);

    public static final native int file_completed_alert_alert_type_get();

    public static final native long file_completed_alert_category(long j, file_completed_alert file_completed_alertVar);

    public static final native int file_completed_alert_index_get(long j, file_completed_alert file_completed_alertVar);

    public static final native String file_completed_alert_message(long j, file_completed_alert file_completed_alertVar);

    public static final native int file_completed_alert_priority_get();

    public static final native long file_completed_alert_static_category_get();

    public static final native int file_completed_alert_type(long j, file_completed_alert file_completed_alertVar);

    public static final native String file_completed_alert_what(long j, file_completed_alert file_completed_alertVar);

    public static final native long file_error_alert_SWIGUpcast(long j);

    public static final native int file_error_alert_alert_type_get();

    public static final native long file_error_alert_category(long j, file_error_alert file_error_alertVar);

    public static final native long file_error_alert_error_get(long j, file_error_alert file_error_alertVar);

    public static final native String file_error_alert_filename(long j, file_error_alert file_error_alertVar);

    public static final native String file_error_alert_message(long j, file_error_alert file_error_alertVar);

    public static final native int file_error_alert_op_get(long j, file_error_alert file_error_alertVar);

    public static final native void file_error_alert_op_set(long j, file_error_alert file_error_alertVar, int i);

    public static final native int file_error_alert_priority_get();

    public static final native long file_error_alert_static_category_get();

    public static final native int file_error_alert_type(long j, file_error_alert file_error_alertVar);

    public static final native String file_error_alert_what(long j, file_error_alert file_error_alertVar);

    public static final native int file_exists_get();

    public static final native long file_flags_t_all();

    public static final native long file_flags_t_and_(long j, file_flags_t file_flags_tVar, long j2, file_flags_t file_flags_tVar2);

    public static final native boolean file_flags_t_eq(long j, file_flags_t file_flags_tVar, long j2, file_flags_t file_flags_tVar2);

    public static final native long file_flags_t_inv(long j, file_flags_t file_flags_tVar);

    public static final native boolean file_flags_t_ne(long j, file_flags_t file_flags_tVar, long j2, file_flags_t file_flags_tVar2);

    public static final native boolean file_flags_t_nonZero(long j, file_flags_t file_flags_tVar);

    public static final native long file_flags_t_or_(long j, file_flags_t file_flags_tVar, long j2, file_flags_t file_flags_tVar2);

    public static final native int file_flags_t_to_int(long j, file_flags_t file_flags_tVar);

    public static final native long file_flags_t_xor(long j, file_flags_t file_flags_tVar, long j2, file_flags_t file_flags_tVar2);

    public static final native void file_index_string_map_clear(long j, file_index_string_map file_index_string_mapVar);

    public static final native boolean file_index_string_map_empty(long j, file_index_string_map file_index_string_mapVar);

    public static final native void file_index_string_map_erase(long j, file_index_string_map file_index_string_mapVar, int i);

    public static final native String file_index_string_map_get(long j, file_index_string_map file_index_string_mapVar, int i);

    public static final native boolean file_index_string_map_has_key(long j, file_index_string_map file_index_string_mapVar, int i);

    public static final native long file_index_string_map_keys(long j, file_index_string_map file_index_string_mapVar);

    public static final native void file_index_string_map_set(long j, file_index_string_map file_index_string_mapVar, int i, String str);

    public static final native long file_index_string_map_size(long j, file_index_string_map file_index_string_mapVar);

    public static final native long file_index_vector_capacity(long j, file_index_vector file_index_vectorVar);

    public static final native void file_index_vector_clear(long j, file_index_vector file_index_vectorVar);

    public static final native boolean file_index_vector_empty(long j, file_index_vector file_index_vectorVar);

    public static final native int file_index_vector_get(long j, file_index_vector file_index_vectorVar, int i);

    public static final native void file_index_vector_push_back(long j, file_index_vector file_index_vectorVar, int i);

    public static final native void file_index_vector_reserve(long j, file_index_vector file_index_vectorVar, long j2);

    public static final native void file_index_vector_set(long j, file_index_vector file_index_vectorVar, int i, int i2);

    public static final native long file_index_vector_size(long j, file_index_vector file_index_vectorVar);

    public static final native long file_rename_failed_alert_SWIGUpcast(long j);

    public static final native int file_rename_failed_alert_alert_type_get();

    public static final native long file_rename_failed_alert_category(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native long file_rename_failed_alert_error_get(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native int file_rename_failed_alert_index_get(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native String file_rename_failed_alert_message(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native int file_rename_failed_alert_priority_get();

    public static final native long file_rename_failed_alert_static_category_get();

    public static final native int file_rename_failed_alert_type(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native String file_rename_failed_alert_what(long j, file_rename_failed_alert file_rename_failed_alertVar);

    public static final native long file_renamed_alert_SWIGUpcast(long j);

    public static final native int file_renamed_alert_alert_type_get();

    public static final native long file_renamed_alert_category(long j, file_renamed_alert file_renamed_alertVar);

    public static final native int file_renamed_alert_index_get(long j, file_renamed_alert file_renamed_alertVar);

    public static final native String file_renamed_alert_message(long j, file_renamed_alert file_renamed_alertVar);

    public static final native String file_renamed_alert_new_name(long j, file_renamed_alert file_renamed_alertVar);

    public static final native int file_renamed_alert_priority_get();

    public static final native long file_renamed_alert_static_category_get();

    public static final native int file_renamed_alert_type(long j, file_renamed_alert file_renamed_alertVar);

    public static final native String file_renamed_alert_what(long j, file_renamed_alert file_renamed_alertVar);

    public static final native int file_slice_file_index_get(long j, file_slice file_sliceVar);

    public static final native void file_slice_file_index_set(long j, file_slice file_sliceVar, int i);

    public static final native long file_slice_offset_get(long j, file_slice file_sliceVar);

    public static final native void file_slice_offset_set(long j, file_slice file_sliceVar, long j2);

    public static final native long file_slice_size_get(long j, file_slice file_sliceVar);

    public static final native void file_slice_size_set(long j, file_slice file_sliceVar, long j2);

    public static final native long file_slice_vector_capacity(long j, file_slice_vector file_slice_vectorVar);

    public static final native void file_slice_vector_clear(long j, file_slice_vector file_slice_vectorVar);

    public static final native boolean file_slice_vector_empty(long j, file_slice_vector file_slice_vectorVar);

    public static final native long file_slice_vector_get(long j, file_slice_vector file_slice_vectorVar, int i);

    public static final native void file_slice_vector_push_back(long j, file_slice_vector file_slice_vectorVar, long j2, file_slice file_sliceVar);

    public static final native void file_slice_vector_reserve(long j, file_slice_vector file_slice_vectorVar, long j2);

    public static final native void file_slice_vector_set(long j, file_slice_vector file_slice_vectorVar, int i, long j2, file_slice file_sliceVar);

    public static final native long file_slice_vector_size(long j, file_slice_vector file_slice_vectorVar);

    public static final native void file_storage_add_file__SWIG_0(long j, file_storage file_storageVar, String str, long j2, long j3, file_flags_t file_flags_tVar, long j4, long j5, string_view string_viewVar);

    public static final native void file_storage_add_file__SWIG_1(long j, file_storage file_storageVar, String str, long j2, long j3, file_flags_t file_flags_tVar, long j4);

    public static final native void file_storage_add_file__SWIG_2(long j, file_storage file_storageVar, String str, long j2, long j3, file_flags_t file_flags_tVar);

    public static final native void file_storage_add_file__SWIG_3(long j, file_storage file_storageVar, String str, long j2);

    public static final native void file_storage_add_file__SWIG_4(long j, file_storage file_storageVar, String str, long j2, long j3, file_flags_t file_flags_tVar, long j4, String str2);

    public static final native void file_storage_add_file_borrow__SWIG_0(long j, file_storage file_storageVar, long j2, string_view string_viewVar, String str, long j3, long j4, file_flags_t file_flags_tVar, String str2, long j5, long j6, string_view string_viewVar2);

    public static final native void file_storage_add_file_borrow__SWIG_1(long j, file_storage file_storageVar, long j2, string_view string_viewVar, String str, long j3, long j4, file_flags_t file_flags_tVar, String str2, long j5);

    public static final native void file_storage_add_file_borrow__SWIG_2(long j, file_storage file_storageVar, long j2, string_view string_viewVar, String str, long j3, long j4, file_flags_t file_flags_tVar, String str2);

    public static final native void file_storage_add_file_borrow__SWIG_3(long j, file_storage file_storageVar, long j2, string_view string_viewVar, String str, long j3, long j4, file_flags_t file_flags_tVar);

    public static final native void file_storage_add_file_borrow__SWIG_4(long j, file_storage file_storageVar, long j2, string_view string_viewVar, String str, long j3);

    public static final native int file_storage_end_file(long j, file_storage file_storageVar);

    public static final native int file_storage_end_piece(long j, file_storage file_storageVar);

    public static final native boolean file_storage_file_absolute_path(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_file_flags(long j, file_storage file_storageVar, int i);

    public static final native int file_storage_file_index_at_offset(long j, file_storage file_storageVar, long j2);

    public static final native long file_storage_file_name(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_file_offset(long j, file_storage file_storageVar, int i);

    public static final native String file_storage_file_path__SWIG_0(long j, file_storage file_storageVar, int i, String str);

    public static final native String file_storage_file_path__SWIG_1(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_file_size(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_flag_executable_get();

    public static final native long file_storage_flag_hidden_get();

    public static final native long file_storage_flag_pad_file_get();

    public static final native long file_storage_flag_symlink_get();

    public static final native long file_storage_hash(long j, file_storage file_storageVar, int i);

    public static final native boolean file_storage_is_valid(long j, file_storage file_storageVar);

    public static final native int file_storage_last_piece(long j, file_storage file_storageVar);

    public static final native long file_storage_map_block(long j, file_storage file_storageVar, int i, long j2, int i2);

    public static final native long file_storage_map_file(long j, file_storage file_storageVar, int i, long j2, int i2);

    public static final native long file_storage_mtime(long j, file_storage file_storageVar, int i);

    public static final native String file_storage_name(long j, file_storage file_storageVar);

    public static final native int file_storage_num_files(long j, file_storage file_storageVar);

    public static final native int file_storage_num_pieces(long j, file_storage file_storageVar);

    public static final native void file_storage_optimize__SWIG_0(long j, file_storage file_storageVar, int i, int i2, boolean z);

    public static final native void file_storage_optimize__SWIG_1(long j, file_storage file_storageVar, int i, int i2);

    public static final native void file_storage_optimize__SWIG_2(long j, file_storage file_storageVar, int i);

    public static final native void file_storage_optimize__SWIG_3(long j, file_storage file_storageVar);

    public static final native boolean file_storage_pad_file_at(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_paths(long j, file_storage file_storageVar);

    public static final native int file_storage_piece_length(long j, file_storage file_storageVar);

    public static final native int file_storage_piece_size(long j, file_storage file_storageVar, int i);

    public static final native void file_storage_rename_file(long j, file_storage file_storageVar, int i, String str);

    public static final native void file_storage_reserve(long j, file_storage file_storageVar, int i);

    public static final native void file_storage_set_name(long j, file_storage file_storageVar, String str);

    public static final native void file_storage_set_num_pieces(long j, file_storage file_storageVar, int i);

    public static final native void file_storage_set_piece_length(long j, file_storage file_storageVar, int i);

    public static final native void file_storage_swap(long j, file_storage file_storageVar, long j2, file_storage file_storageVar2);

    public static final native String file_storage_symlink(long j, file_storage file_storageVar, int i);

    public static final native long file_storage_total_size(long j, file_storage file_storageVar);

    public static final native int file_too_large_get();

    public static final native int filename_too_long_get();

    public static final native int find_metric_idx_s(String str);

    public static final native int forbidden_get();

    public static final native int function_not_supported_get();

    public static final native String generate_fingerprint(String str, int i, int i2, int i3, int i4);

    public static final native String generic_error_category_message__SWIG_0(long j, generic_error_category generic_error_categoryVar, int i);

    public static final native String generic_error_category_message__SWIG_1(long j, generic_error_category generic_error_categoryVar, int i, String str, long j2);

    public static final native String generic_error_category_name(long j, generic_error_category generic_error_categoryVar);

    public static final native long get_gateway(long j, C2430session c2430session, long j2, ip_interface ip_interfaceVar, long j3, ip_route_vector ip_route_vectorVar);

    public static final native long hash_failed_alert_SWIGUpcast(long j);

    public static final native int hash_failed_alert_alert_type_get();

    public static final native long hash_failed_alert_category(long j, hash_failed_alert hash_failed_alertVar);

    public static final native String hash_failed_alert_message(long j, hash_failed_alert hash_failed_alertVar);

    public static final native int hash_failed_alert_piece_index_get(long j, hash_failed_alert hash_failed_alertVar);

    public static final native int hash_failed_alert_priority_get();

    public static final native long hash_failed_alert_static_category_get();

    public static final native int hash_failed_alert_type(long j, hash_failed_alert hash_failed_alertVar);

    public static final native String hash_failed_alert_what(long j, hash_failed_alert hash_failed_alertVar);

    public static final native long high_performance_seed();

    public static final native int host_unreachable_get();

    public static final native int http_parse_error_get();

    public static final native long i2p_alert_SWIGUpcast(long j);

    public static final native int i2p_alert_alert_type_get();

    public static final native long i2p_alert_category(long j, i2p_alert i2p_alertVar);

    public static final native long i2p_alert_error_get(long j, i2p_alert i2p_alertVar);

    public static final native void i2p_alert_error_set(long j, i2p_alert i2p_alertVar, long j2, error_code error_codeVar);

    public static final native String i2p_alert_message(long j, i2p_alert i2p_alertVar);

    public static final native int i2p_alert_priority_get();

    public static final native long i2p_alert_static_category_get();

    public static final native int i2p_alert_type(long j, i2p_alert i2p_alertVar);

    public static final native String i2p_alert_what(long j, i2p_alert i2p_alertVar);

    public static final native int identifier_removed_get();

    public static final native int illegal_byte_sequence_get();

    public static final native int inappropriate_io_control_operation_get();

    public static final native long incoming_connection_alert_SWIGUpcast(long j);

    public static final native int incoming_connection_alert_alert_type_get();

    public static final native long incoming_connection_alert_category(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native long incoming_connection_alert_get_endpoint(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native String incoming_connection_alert_message(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native int incoming_connection_alert_priority_get();

    public static final native int incoming_connection_alert_socket_type_get(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native long incoming_connection_alert_static_category_get();

    public static final native int incoming_connection_alert_type(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native String incoming_connection_alert_what(long j, incoming_connection_alert incoming_connection_alertVar);

    public static final native long incoming_request_alert_SWIGUpcast(long j);

    public static final native int incoming_request_alert_alert_type_get();

    public static final native long incoming_request_alert_category(long j, incoming_request_alert incoming_request_alertVar);

    public static final native String incoming_request_alert_message(long j, incoming_request_alert incoming_request_alertVar);

    public static final native int incoming_request_alert_priority_get();

    public static final native long incoming_request_alert_req_get(long j, incoming_request_alert incoming_request_alertVar);

    public static final native void incoming_request_alert_req_set(long j, incoming_request_alert incoming_request_alertVar, long j2, peer_request peer_requestVar);

    public static final native long incoming_request_alert_static_category_get();

    public static final native int incoming_request_alert_type(long j, incoming_request_alert incoming_request_alertVar);

    public static final native String incoming_request_alert_what(long j, incoming_request_alert incoming_request_alertVar);

    public static final native long int64_vector_capacity(long j, int64_vector int64_vectorVar);

    public static final native void int64_vector_clear(long j, int64_vector int64_vectorVar);

    public static final native boolean int64_vector_empty(long j, int64_vector int64_vectorVar);

    public static final native long int64_vector_get(long j, int64_vector int64_vectorVar, int i);

    public static final native void int64_vector_push_back(long j, int64_vector int64_vectorVar, long j2);

    public static final native void int64_vector_reserve(long j, int64_vector int64_vectorVar, long j2);

    public static final native void int64_vector_set(long j, int64_vector int64_vectorVar, int i, long j2);

    public static final native long int64_vector_size(long j, int64_vector int64_vectorVar);

    public static final native long int_vector_capacity(long j, int_vector int_vectorVar);

    public static final native void int_vector_clear(long j, int_vector int_vectorVar);

    public static final native boolean int_vector_empty(long j, int_vector int_vectorVar);

    public static final native int int_vector_get(long j, int_vector int_vectorVar, int i);

    public static final native void int_vector_push_back(long j, int_vector int_vectorVar, int i);

    public static final native void int_vector_reserve(long j, int_vector int_vectorVar, long j2);

    public static final native void int_vector_set(long j, int_vector int_vectorVar, int i, int i2);

    public static final native long int_vector_size(long j, int_vector int_vectorVar);

    public static final native int internal_server_error_get();

    public static final native int interrupted_get();

    public static final native int invalid_argument_get();

    public static final native long invalid_request_alert_SWIGUpcast(long j);

    public static final native int invalid_request_alert_alert_type_get();

    public static final native long invalid_request_alert_category(long j, invalid_request_alert invalid_request_alertVar);

    public static final native String invalid_request_alert_message(long j, invalid_request_alert invalid_request_alertVar);

    public static final native boolean invalid_request_alert_peer_interested_get(long j, invalid_request_alert invalid_request_alertVar);

    public static final native int invalid_request_alert_priority_get();

    public static final native long invalid_request_alert_request_get(long j, invalid_request_alert invalid_request_alertVar);

    public static final native long invalid_request_alert_static_category_get();

    public static final native int invalid_request_alert_type(long j, invalid_request_alert invalid_request_alertVar);

    public static final native boolean invalid_request_alert_we_have_get(long j, invalid_request_alert invalid_request_alertVar);

    public static final native String invalid_request_alert_what(long j, invalid_request_alert invalid_request_alertVar);

    public static final native boolean invalid_request_alert_withheld_get(long j, invalid_request_alert invalid_request_alertVar);

    public static final native int invalid_seek_get();

    public static final native int io_error_get();

    public static final native long ip_filter_access(long j, ip_filter ip_filterVar, long j2, address addressVar);

    public static final native void ip_filter_add_rule(long j, ip_filter ip_filterVar, long j2, address addressVar, long j3, address addressVar2, long j4);

    public static final native int ip_filter_blocked_get();

    public static final native long ip_interface_description_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_description_set(long j, ip_interface ip_interfaceVar, long j2, byte_vector byte_vectorVar);

    public static final native long ip_interface_friendly_name_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_friendly_name_set(long j, ip_interface ip_interfaceVar, long j2, byte_vector byte_vectorVar);

    public static final native long ip_interface_interface_address_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_interface_address_set(long j, ip_interface ip_interfaceVar, long j2, address addressVar);

    public static final native long ip_interface_name_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_name_set(long j, ip_interface ip_interfaceVar, long j2, byte_vector byte_vectorVar);

    public static final native long ip_interface_netmask_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_netmask_set(long j, ip_interface ip_interfaceVar, long j2, address addressVar);

    public static final native boolean ip_interface_preferred_get(long j, ip_interface ip_interfaceVar);

    public static final native void ip_interface_preferred_set(long j, ip_interface ip_interfaceVar, boolean z);

    public static final native long ip_interface_vector_capacity(long j, ip_interface_vector ip_interface_vectorVar);

    public static final native void ip_interface_vector_clear(long j, ip_interface_vector ip_interface_vectorVar);

    public static final native boolean ip_interface_vector_empty(long j, ip_interface_vector ip_interface_vectorVar);

    public static final native long ip_interface_vector_get(long j, ip_interface_vector ip_interface_vectorVar, int i);

    public static final native void ip_interface_vector_push_back(long j, ip_interface_vector ip_interface_vectorVar, long j2, ip_interface ip_interfaceVar);

    public static final native void ip_interface_vector_reserve(long j, ip_interface_vector ip_interface_vectorVar, long j2);

    public static final native void ip_interface_vector_set(long j, ip_interface_vector ip_interface_vectorVar, int i, long j2, ip_interface ip_interfaceVar);

    public static final native long ip_interface_vector_size(long j, ip_interface_vector ip_interface_vectorVar);

    public static final native long ip_route_destination_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_destination_set(long j, ip_route ip_routeVar, long j2, address addressVar);

    public static final native long ip_route_gateway_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_gateway_set(long j, ip_route ip_routeVar, long j2, address addressVar);

    public static final native int ip_route_mtu_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_mtu_set(long j, ip_route ip_routeVar, int i);

    public static final native long ip_route_name_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_name_set(long j, ip_route ip_routeVar, long j2, byte_vector byte_vectorVar);

    public static final native long ip_route_netmask_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_netmask_set(long j, ip_route ip_routeVar, long j2, address addressVar);

    public static final native long ip_route_source_hint_get(long j, ip_route ip_routeVar);

    public static final native void ip_route_source_hint_set(long j, ip_route ip_routeVar, long j2, address addressVar);

    public static final native long ip_route_vector_capacity(long j, ip_route_vector ip_route_vectorVar);

    public static final native void ip_route_vector_clear(long j, ip_route_vector ip_route_vectorVar);

    public static final native boolean ip_route_vector_empty(long j, ip_route_vector ip_route_vectorVar);

    public static final native long ip_route_vector_get(long j, ip_route_vector ip_route_vectorVar, int i);

    public static final native void ip_route_vector_push_back(long j, ip_route_vector ip_route_vectorVar, long j2, ip_route ip_routeVar);

    public static final native void ip_route_vector_reserve(long j, ip_route_vector ip_route_vectorVar, long j2);

    public static final native void ip_route_vector_set(long j, ip_route_vector ip_route_vectorVar, int i, long j2, ip_route ip_routeVar);

    public static final native long ip_route_vector_size(long j, ip_route_vector ip_route_vectorVar);

    public static final native int is_a_directory_get();

    public static String jlibtorrentVersion() {
        return "1.2.5.0";
    }

    public static final native int libtorrent_no_error_get();

    public static final native long listen_failed_alert_SWIGUpcast(long j);

    public static final native int listen_failed_alert_alert_type_get();

    public static final native long listen_failed_alert_category(long j, listen_failed_alert listen_failed_alertVar);

    public static final native long listen_failed_alert_error_get(long j, listen_failed_alert listen_failed_alertVar);

    public static final native long listen_failed_alert_get_address(long j, listen_failed_alert listen_failed_alertVar);

    public static final native String listen_failed_alert_listen_interface(long j, listen_failed_alert listen_failed_alertVar);

    public static final native String listen_failed_alert_message(long j, listen_failed_alert listen_failed_alertVar);

    public static final native int listen_failed_alert_op_get(long j, listen_failed_alert listen_failed_alertVar);

    public static final native void listen_failed_alert_op_set(long j, listen_failed_alert listen_failed_alertVar, int i);

    public static final native int listen_failed_alert_port_get(long j, listen_failed_alert listen_failed_alertVar);

    public static final native int listen_failed_alert_priority_get();

    public static final native int listen_failed_alert_socket_type_get(long j, listen_failed_alert listen_failed_alertVar);

    public static final native long listen_failed_alert_static_category_get();

    public static final native int listen_failed_alert_type(long j, listen_failed_alert listen_failed_alertVar);

    public static final native String listen_failed_alert_what(long j, listen_failed_alert listen_failed_alertVar);

    public static final native long listen_succeeded_alert_SWIGUpcast(long j);

    public static final native int listen_succeeded_alert_alert_type_get();

    public static final native long listen_succeeded_alert_category(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native long listen_succeeded_alert_get_address(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native String listen_succeeded_alert_message(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native int listen_succeeded_alert_port_get(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native int listen_succeeded_alert_priority_get();

    public static final native int listen_succeeded_alert_socket_type_get(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native long listen_succeeded_alert_static_category_get();

    public static final native int listen_succeeded_alert_type(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native String listen_succeeded_alert_what(long j, listen_succeeded_alert listen_succeeded_alertVar);

    public static final native int load_torrent_limits_max_buffer_size_get(long j, load_torrent_limits load_torrent_limitsVar);

    public static final native void load_torrent_limits_max_buffer_size_set(long j, load_torrent_limits load_torrent_limitsVar, int i);

    public static final native int load_torrent_limits_max_decode_depth_get(long j, load_torrent_limits load_torrent_limitsVar);

    public static final native void load_torrent_limits_max_decode_depth_set(long j, load_torrent_limits load_torrent_limitsVar, int i);

    public static final native int load_torrent_limits_max_decode_tokens_get(long j, load_torrent_limits load_torrent_limitsVar);

    public static final native void load_torrent_limits_max_decode_tokens_set(long j, load_torrent_limits load_torrent_limitsVar, int i);

    public static final native int load_torrent_limits_max_pieces_get(long j, load_torrent_limits load_torrent_limitsVar);

    public static final native void load_torrent_limits_max_pieces_set(long j, load_torrent_limits load_torrent_limitsVar, int i);

    public static final native long log_alert_SWIGUpcast(long j);

    public static final native int log_alert_alert_type_get();

    public static final native long log_alert_category(long j, log_alert log_alertVar);

    public static final native String log_alert_log_message(long j, log_alert log_alertVar);

    public static final native String log_alert_message(long j, log_alert log_alertVar);

    public static final native int log_alert_priority_get();

    public static final native long log_alert_static_category_get();

    public static final native int log_alert_type(long j, log_alert log_alertVar);

    public static final native String log_alert_what(long j, log_alert log_alertVar);

    public static final native long lsd_error_alert_SWIGUpcast(long j);

    public static final native int lsd_error_alert_alert_type_get();

    public static final native long lsd_error_alert_category(long j, lsd_error_alert lsd_error_alertVar);

    public static final native long lsd_error_alert_error_get(long j, lsd_error_alert lsd_error_alertVar);

    public static final native void lsd_error_alert_error_set(long j, lsd_error_alert lsd_error_alertVar, long j2, error_code error_codeVar);

    public static final native String lsd_error_alert_message(long j, lsd_error_alert lsd_error_alertVar);

    public static final native int lsd_error_alert_priority_get();

    public static final native long lsd_error_alert_static_category_get();

    public static final native int lsd_error_alert_type(long j, lsd_error_alert lsd_error_alertVar);

    public static final native String lsd_error_alert_what(long j, lsd_error_alert lsd_error_alertVar);

    public static final native long lsd_peer_alert_SWIGUpcast(long j);

    public static final native int lsd_peer_alert_alert_type_get();

    public static final native long lsd_peer_alert_category(long j, lsd_peer_alert lsd_peer_alertVar);

    public static final native String lsd_peer_alert_message(long j, lsd_peer_alert lsd_peer_alertVar);

    public static final native int lsd_peer_alert_priority_get();

    public static final native long lsd_peer_alert_static_category_get();

    public static final native int lsd_peer_alert_type(long j, lsd_peer_alert lsd_peer_alertVar);

    public static final native String lsd_peer_alert_what(long j, lsd_peer_alert lsd_peer_alertVar);

    public static final native long make_error_code(int i);

    public static final native String make_magnet_uri__SWIG_0(long j, torrent_handle torrent_handleVar);

    public static final native String make_magnet_uri__SWIG_1(long j, torrent_info torrent_infoVar);

    public static final native int message_size_get();

    public static final native long metadata_failed_alert_SWIGUpcast(long j);

    public static final native int metadata_failed_alert_alert_type_get();

    public static final native long metadata_failed_alert_category(long j, metadata_failed_alert metadata_failed_alertVar);

    public static final native long metadata_failed_alert_error_get(long j, metadata_failed_alert metadata_failed_alertVar);

    public static final native String metadata_failed_alert_message(long j, metadata_failed_alert metadata_failed_alertVar);

    public static final native int metadata_failed_alert_priority_get();

    public static final native long metadata_failed_alert_static_category_get();

    public static final native int metadata_failed_alert_type(long j, metadata_failed_alert metadata_failed_alertVar);

    public static final native String metadata_failed_alert_what(long j, metadata_failed_alert metadata_failed_alertVar);

    public static final native long metadata_received_alert_SWIGUpcast(long j);

    public static final native int metadata_received_alert_alert_type_get();

    public static final native long metadata_received_alert_category(long j, metadata_received_alert metadata_received_alertVar);

    public static final native String metadata_received_alert_message(long j, metadata_received_alert metadata_received_alertVar);

    public static final native int metadata_received_alert_priority_get();

    public static final native long metadata_received_alert_static_category_get();

    public static final native int metadata_received_alert_type(long j, metadata_received_alert metadata_received_alertVar);

    public static final native String metadata_received_alert_what(long j, metadata_received_alert metadata_received_alertVar);

    public static final native long min_memory_usage();

    public static final native int missing_file_sizes_get();

    public static final native int moved_permanently_get();

    public static final native int moved_temporarily_get();

    public static final native int multiple_choices_get();

    public static final native String name_for_setting(int i);

    public static final native long need_save_resume_get();

    public static final native int network_down_get();

    public static final native int network_reset_get();

    public static final native int network_unreachable_get();

    public static final native long new_add_files_listener();

    public static final native long new_add_piece_flags_t();

    public static final native long new_address__SWIG_0();

    public static final native long new_address__SWIG_1(long j, address addressVar);

    public static final native long new_address_sha1_hash_pair__SWIG_0();

    public static final native long new_address_sha1_hash_pair__SWIG_1(long j, address addressVar, long j2, sha1_hash sha1_hashVar);

    public static final native long new_address_sha1_hash_pair__SWIG_2(long j, address_sha1_hash_pair address_sha1_hash_pairVar);

    public static final native long new_address_sha1_hash_pair_vector();

    public static final native long new_alert_category_t();

    public static final native long new_alert_notify_callback();

    public static final native long new_alert_ptr_vector();

    public static final native long new_announce_endpoint_vector();

    public static final native long new_announce_entry(long j, byte_vector byte_vectorVar);

    public static final native long new_announce_entry_vector();

    public static final native long new_bandwidth_state_flags_t();

    public static final native long new_bdecode_node__SWIG_0();

    public static final native long new_bdecode_node__SWIG_1(long j, bdecode_node bdecode_nodeVar);

    public static final native long new_bitset_96();

    public static final native long new_block_info();

    public static final native long new_block_info_vector();

    public static final native long new_bloom_filter_128();

    public static final native long new_bloom_filter_256();

    public static final native long new_bt_peer_connection_handle(long j, peer_connection_handle peer_connection_handleVar);

    public static final native long new_byte_const_span();

    public static final native long new_byte_span();

    public static final native long new_byte_vector();

    public static final native long new_byte_vectors_pair__SWIG_0();

    public static final native long new_byte_vectors_pair__SWIG_1(long j, byte_vector byte_vectorVar, long j2, byte_vector byte_vectorVar2);

    public static final native long new_byte_vectors_pair__SWIG_2(long j, byte_vectors_pair byte_vectors_pairVar);

    public static final native long new_create_flags_t();

    public static final native long new_create_torrent__SWIG_0(long j, file_storage file_storageVar, int i, int i2, long j2, create_flags_t create_flags_tVar, int i3);

    public static final native long new_create_torrent__SWIG_1(long j, file_storage file_storageVar, int i, int i2, long j2, create_flags_t create_flags_tVar);

    public static final native long new_create_torrent__SWIG_2(long j, file_storage file_storageVar, int i, int i2);

    public static final native long new_create_torrent__SWIG_3(long j, file_storage file_storageVar, int i);

    public static final native long new_create_torrent__SWIG_4(long j, file_storage file_storageVar);

    public static final native long new_create_torrent__SWIG_5(long j, torrent_info torrent_infoVar);

    public static final native long new_deadline_flags_t();

    public static final native long new_dht_lookup();

    public static final native long new_dht_lookup_vector();

    public static final native long new_dht_routing_bucket();

    public static final native long new_dht_routing_bucket_vector();

    public static final native long new_dht_settings();

    public static final native long new_dht_state();

    public static final native long new_entry__SWIG_0(long j, string_entry_map string_entry_mapVar);

    public static final native long new_entry__SWIG_1(long j, byte_const_span byte_const_spanVar);

    public static final native long new_entry__SWIG_2(String str);

    public static final native long new_entry__SWIG_3(long j, entry_vector entry_vectorVar);

    public static final native long new_entry__SWIG_4(long j);

    public static final native long new_entry__SWIG_5(int i);

    public static final native long new_entry__SWIG_6(long j, entry entryVar);

    public static final native long new_entry__SWIG_7();

    public static final native long new_entry_vector();

    public static final native long new_error_code();

    public static final native long new_file_flags_t();

    public static final native long new_file_index_string_map__SWIG_0();

    public static final native long new_file_index_string_map__SWIG_1(long j, file_index_string_map file_index_string_mapVar);

    public static final native long new_file_index_vector();

    public static final native long new_file_slice();

    public static final native long new_file_slice_vector();

    public static final native long new_file_storage__SWIG_0();

    public static final native long new_file_storage__SWIG_1(long j, file_storage file_storageVar);

    public static final native long new_generic_error_category();

    public static final native long new_int64_vector();

    public static final native long new_int_vector();

    public static final native long new_ip_filter();

    public static final native long new_ip_interface();

    public static final native long new_ip_interface_vector();

    public static final native long new_ip_route();

    public static final native long new_ip_route_vector();

    public static final native long new_load_torrent_limits();

    public static final native long new_partial_piece_info();

    public static final native long new_partial_piece_info_vector();

    public static final native long new_pause_flags_t();

    public static final native long new_peer_class_info();

    public static final native long new_peer_class_type_filter();

    public static final native long new_peer_flags_t();

    public static final native long new_peer_info();

    public static final native long new_peer_info_vector();

    public static final native long new_peer_request();

    public static final native long new_peer_source_flags_t();

    public static final native long new_pex_flags_t();

    public static final native long new_picker_flags_t();

    public static final native long new_piece_index_bitfield__SWIG_0();

    public static final native long new_piece_index_bitfield__SWIG_1(int i);

    public static final native long new_piece_index_bitfield__SWIG_2(int i, boolean z);

    public static final native long new_piece_index_bitfield__SWIG_3(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native long new_piece_index_int_pair__SWIG_0();

    public static final native long new_piece_index_int_pair__SWIG_1(int i, int i2);

    public static final native long new_piece_index_int_pair__SWIG_2(long j, piece_index_int_pair piece_index_int_pairVar);

    public static final native long new_piece_index_int_pair_vector();

    public static final native long new_piece_index_vector();

    public static final native long new_port_filter();

    public static final native long new_port_mapping_t_vector();

    public static final native long new_posix_stat_t();

    public static final native long new_posix_wrapper();

    public static final native long new_reannounce_flags_t();

    public static final native long new_remove_flags_t();

    public static final native long new_reopen_network_flags_t();

    public static final native long new_resume_data_flags_t();

    public static final native long new_save_state_flags_t();

    public static final native long new_session__SWIG_0(long j, session_params session_paramsVar);

    public static final native long new_session__SWIG_1();

    public static final native long new_session__SWIG_2(long j, settings_pack settings_packVar, long j2, session_flags_t session_flags_tVar);

    public static final native long new_session__SWIG_3(long j, settings_pack settings_packVar);

    public static final native long new_session__SWIG_4(long j, C2430session c2430session);

    public static final native long new_session_flags_t();

    public static final native long new_session_handle__SWIG_0();

    public static final native long new_session_handle__SWIG_1(long j, session_handle session_handleVar);

    public static final native long new_session_params__SWIG_0(long j, settings_pack settings_packVar);

    public static final native long new_session_params__SWIG_1();

    public static final native long new_session_params__SWIG_2(long j, session_params session_paramsVar);

    public static final native long new_session_proxy__SWIG_0();

    public static final native long new_session_proxy__SWIG_1(long j, session_proxy session_proxyVar);

    public static final native long new_set_piece_hashes_listener();

    public static final native long new_settings();

    public static final native long new_settings_pack__SWIG_0();

    public static final native long new_settings_pack__SWIG_1(long j, settings_pack settings_packVar);

    public static final native long new_sha1_hash__SWIG_0();

    public static final native long new_sha1_hash__SWIG_1(long j, sha1_hash sha1_hashVar);

    public static final native long new_sha1_hash__SWIG_2(long j, byte_vector byte_vectorVar);

    public static final native long new_sha1_hash_udp_endpoint_pair__SWIG_0();

    public static final native long new_sha1_hash_udp_endpoint_pair__SWIG_1(long j, sha1_hash sha1_hashVar, long j2, udp_endpoint udp_endpointVar);

    public static final native long new_sha1_hash_udp_endpoint_pair__SWIG_2(long j, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar);

    public static final native long new_sha1_hash_udp_endpoint_pair_vector();

    public static final native long new_sha1_hash_vector();

    public static final native long new_stats_metric();

    public static final native long new_stats_metric_vector();

    public static final native long new_status_flags_t();

    public static final native long new_string_entry_map__SWIG_0();

    public static final native long new_string_entry_map__SWIG_1(long j, string_entry_map string_entry_mapVar);

    public static final native long new_string_int_pair__SWIG_0();

    public static final native long new_string_int_pair__SWIG_1(String str, int i);

    public static final native long new_string_int_pair__SWIG_2(long j, string_int_pair string_int_pairVar);

    public static final native long new_string_int_pair_vector();

    public static final native long new_string_long_map__SWIG_0();

    public static final native long new_string_long_map__SWIG_1(long j, string_long_map string_long_mapVar);

    public static final native long new_string_string_pair__SWIG_0();

    public static final native long new_string_string_pair__SWIG_1(String str, String str2);

    public static final native long new_string_string_pair__SWIG_2(long j, string_string_pair string_string_pairVar);

    public static final native long new_string_string_pair_vector();

    public static final native long new_string_vector();

    public static final native long new_string_view();

    public static final native long new_string_view_bdecode_node_pair__SWIG_0();

    public static final native long new_string_view_bdecode_node_pair__SWIG_1(long j, string_view string_viewVar, long j2, bdecode_node bdecode_nodeVar);

    public static final native long new_string_view_bdecode_node_pair__SWIG_2(long j, string_view_bdecode_node_pair string_view_bdecode_node_pairVar);

    public static final native long new_swig_plugin();

    public static final native long new_system_error_category();

    public static final native long new_tcp_endpoint__SWIG_0();

    public static final native long new_tcp_endpoint__SWIG_1(long j, address addressVar, int i);

    public static final native long new_tcp_endpoint__SWIG_2(long j, tcp_endpoint tcp_endpointVar);

    public static final native long new_tcp_endpoint_vector();

    public static final native long new_torrent_flags_t();

    public static final native long new_torrent_handle_vector();

    public static final native long new_torrent_info__SWIG_0(long j, torrent_info torrent_infoVar);

    public static final native long new_torrent_info__SWIG_1(long j, sha1_hash sha1_hashVar);

    public static final native long new_torrent_info__SWIG_2(long j, bdecode_node bdecode_nodeVar, long j2, error_code error_codeVar);

    public static final native long new_torrent_info__SWIG_3(String str, long j, error_code error_codeVar);

    public static final native long new_torrent_info__SWIG_4(long j, int i, long j2, error_code error_codeVar);

    public static final native long new_torrent_status__SWIG_0();

    public static final native long new_torrent_status__SWIG_1(long j, torrent_status torrent_statusVar);

    public static final native long new_torrent_status_vector();

    public static final native long new_udp_endpoint__SWIG_0();

    public static final native long new_udp_endpoint__SWIG_1(long j, address addressVar, int i);

    public static final native long new_udp_endpoint__SWIG_2(long j, udp_endpoint udp_endpointVar);

    public static final native long new_udp_endpoint_vector();

    public static final native long new_web_seed_entry__SWIG_0(String str, int i, String str2, long j, string_string_pair_vector string_string_pair_vectorVar);

    public static final native long new_web_seed_entry__SWIG_1(String str, int i, String str2);

    public static final native long new_web_seed_entry__SWIG_2(String str, int i);

    public static final native long new_web_seed_entry_vector();

    public static final native int no_buffer_space_get();

    public static final native int no_child_process_get();

    public static final native int no_content_get();

    public static final native int no_entropy_get();

    public static final native int no_i2p_endpoint_get();

    public static final native int no_i2p_router_get();

    public static final native int no_link_get();

    public static final native int no_lock_available_get();

    public static final native int no_message_available_get();

    public static final native int no_message_get();

    public static final native int no_protocol_option_get();

    public static final native int no_space_on_device_get();

    public static final native int no_stream_resources_get();

    public static final native int no_such_device_get();

    public static final native int no_such_device_or_address_get();

    public static final native int no_such_file_or_directory_get();

    public static final native int no_such_process_get();

    public static final native int not_a_directory_get();

    public static final native int not_a_socket_get();

    public static final native int not_a_stream_get();

    public static final native int not_connected_get();

    public static final native int not_enough_memory_get();

    public static final native int not_found_get();

    public static final native int not_implemented_get();

    public static final native int not_modified_get();

    public static final native int not_supported_get();

    public static final native int num_alert_types_get();

    public static final native int ok_get();

    public static final native boolean op_eq__SWIG_0(long j, peer_class_type_filter peer_class_type_filterVar, long j2, peer_class_type_filter peer_class_type_filterVar2);

    public static final native boolean op_eq__SWIG_1(long j, error_code error_codeVar, long j2, error_code error_codeVar2);

    public static final native boolean op_lt__SWIG_1(long j, error_code error_codeVar, long j2, error_code error_codeVar2);

    public static final native boolean op_lte(long j, address addressVar, long j2, address addressVar2);

    public static final native boolean op_ne(long j, error_code error_codeVar, long j2, error_code error_codeVar2);

    public static final native int openssl_version_number();

    public static final native String openssl_version_text();

    public static final native int operation_canceled_get();

    public static final native int operation_in_progress_get();

    public static final native String operation_name(int i);

    public static final native int operation_not_permitted_get();

    public static final native int operation_not_supported_get();

    public static final native int operation_would_block_get();

    public static final native long override_trackers_get();

    public static final native long override_web_seeds_get();

    public static final native int owner_dead_get();

    public static final native int partial_piece_info_blocks_in_piece_get(long j, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_blocks_in_piece_set(long j, partial_piece_info partial_piece_infoVar, int i);

    public static final native int partial_piece_info_finished_get(long j, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_finished_set(long j, partial_piece_info partial_piece_infoVar, int i);

    public static final native int partial_piece_info_piece_index_get(long j, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_piece_index_set(long j, partial_piece_info partial_piece_infoVar, int i);

    public static final native int partial_piece_info_requested_get(long j, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_requested_set(long j, partial_piece_info partial_piece_infoVar, int i);

    public static final native long partial_piece_info_vector_capacity(long j, partial_piece_info_vector partial_piece_info_vectorVar);

    public static final native void partial_piece_info_vector_clear(long j, partial_piece_info_vector partial_piece_info_vectorVar);

    public static final native boolean partial_piece_info_vector_empty(long j, partial_piece_info_vector partial_piece_info_vectorVar);

    public static final native long partial_piece_info_vector_get(long j, partial_piece_info_vector partial_piece_info_vectorVar, int i);

    public static final native void partial_piece_info_vector_push_back(long j, partial_piece_info_vector partial_piece_info_vectorVar, long j2, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_vector_reserve(long j, partial_piece_info_vector partial_piece_info_vectorVar, long j2);

    public static final native void partial_piece_info_vector_set(long j, partial_piece_info_vector partial_piece_info_vectorVar, int i, long j2, partial_piece_info partial_piece_infoVar);

    public static final native long partial_piece_info_vector_size(long j, partial_piece_info_vector partial_piece_info_vectorVar);

    public static final native int partial_piece_info_writing_get(long j, partial_piece_info partial_piece_infoVar);

    public static final native void partial_piece_info_writing_set(long j, partial_piece_info partial_piece_infoVar, int i);

    public static final native long pause_flags_t_all();

    public static final native long pause_flags_t_and_(long j, pause_flags_t pause_flags_tVar, long j2, pause_flags_t pause_flags_tVar2);

    public static final native boolean pause_flags_t_eq(long j, pause_flags_t pause_flags_tVar, long j2, pause_flags_t pause_flags_tVar2);

    public static final native long pause_flags_t_inv(long j, pause_flags_t pause_flags_tVar);

    public static final native boolean pause_flags_t_ne(long j, pause_flags_t pause_flags_tVar, long j2, pause_flags_t pause_flags_tVar2);

    public static final native boolean pause_flags_t_nonZero(long j, pause_flags_t pause_flags_tVar);

    public static final native long pause_flags_t_or_(long j, pause_flags_t pause_flags_tVar, long j2, pause_flags_t pause_flags_tVar2);

    public static final native int pause_flags_t_to_int(long j, pause_flags_t pause_flags_tVar);

    public static final native long pause_flags_t_xor(long j, pause_flags_t pause_flags_tVar, long j2, pause_flags_t pause_flags_tVar2);

    public static final native long paused_get();

    public static final native long peer_alert_SWIGUpcast(long j);

    public static final native long peer_alert_get_endpoint(long j, peer_alert peer_alertVar);

    public static final native String peer_alert_message(long j, peer_alert peer_alertVar);

    public static final native long peer_alert_pid_get(long j, peer_alert peer_alertVar);

    public static final native void peer_alert_pid_set(long j, peer_alert peer_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native long peer_ban_alert_SWIGUpcast(long j);

    public static final native int peer_ban_alert_alert_type_get();

    public static final native long peer_ban_alert_category(long j, peer_ban_alert peer_ban_alertVar);

    public static final native String peer_ban_alert_message(long j, peer_ban_alert peer_ban_alertVar);

    public static final native int peer_ban_alert_priority_get();

    public static final native long peer_ban_alert_static_category_get();

    public static final native int peer_ban_alert_type(long j, peer_ban_alert peer_ban_alertVar);

    public static final native String peer_ban_alert_what(long j, peer_ban_alert peer_ban_alertVar);

    public static final native long peer_blocked_alert_SWIGUpcast(long j);

    public static final native int peer_blocked_alert_alert_type_get();

    public static final native long peer_blocked_alert_category(long j, peer_blocked_alert peer_blocked_alertVar);

    public static final native String peer_blocked_alert_message(long j, peer_blocked_alert peer_blocked_alertVar);

    public static final native int peer_blocked_alert_priority_get();

    public static final native int peer_blocked_alert_reason_get(long j, peer_blocked_alert peer_blocked_alertVar);

    public static final native long peer_blocked_alert_static_category_get();

    public static final native int peer_blocked_alert_type(long j, peer_blocked_alert peer_blocked_alertVar);

    public static final native String peer_blocked_alert_what(long j, peer_blocked_alert peer_blocked_alertVar);

    public static final native int peer_class_info_connection_limit_factor_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_connection_limit_factor_set(long j, peer_class_info peer_class_infoVar, int i);

    public static final native int peer_class_info_download_limit_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_download_limit_set(long j, peer_class_info peer_class_infoVar, int i);

    public static final native int peer_class_info_download_priority_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_download_priority_set(long j, peer_class_info peer_class_infoVar, int i);

    public static final native boolean peer_class_info_ignore_unchoke_slots_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_ignore_unchoke_slots_set(long j, peer_class_info peer_class_infoVar, boolean z);

    public static final native String peer_class_info_label_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_label_set(long j, peer_class_info peer_class_infoVar, String str);

    public static final native int peer_class_info_upload_limit_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_upload_limit_set(long j, peer_class_info peer_class_infoVar, int i);

    public static final native int peer_class_info_upload_priority_get(long j, peer_class_info peer_class_infoVar);

    public static final native void peer_class_info_upload_priority_set(long j, peer_class_info peer_class_infoVar, int i);

    public static final native void peer_class_type_filter_add(long j, peer_class_type_filter peer_class_type_filterVar, int i, int i2);

    public static final native void peer_class_type_filter_allow(long j, peer_class_type_filter peer_class_type_filterVar, int i, int i2);

    public static final native long peer_class_type_filter_apply(long j, peer_class_type_filter peer_class_type_filterVar, int i, long j2);

    public static final native void peer_class_type_filter_disallow(long j, peer_class_type_filter peer_class_type_filterVar, int i, int i2);

    public static final native void peer_class_type_filter_remove(long j, peer_class_type_filter peer_class_type_filterVar, int i, int i2);

    public static final native int peer_class_type_filter_tcp_socket_get();

    public static final native long peer_connect_alert_SWIGUpcast(long j);

    public static final native int peer_connect_alert_alert_type_get();

    public static final native long peer_connect_alert_category(long j, peer_connect_alert peer_connect_alertVar);

    public static final native String peer_connect_alert_message(long j, peer_connect_alert peer_connect_alertVar);

    public static final native int peer_connect_alert_priority_get();

    public static final native int peer_connect_alert_socket_type_get(long j, peer_connect_alert peer_connect_alertVar);

    public static final native long peer_connect_alert_static_category_get();

    public static final native int peer_connect_alert_type(long j, peer_connect_alert peer_connect_alertVar);

    public static final native String peer_connect_alert_what(long j, peer_connect_alert peer_connect_alertVar);

    public static final native long peer_connection_handle_associated_torrent(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_can_disconnect(long j, peer_connection_handle peer_connection_handleVar, long j2, error_code error_codeVar);

    public static final native void peer_connection_handle_choke_this_peer(long j, peer_connection_handle peer_connection_handleVar);

    public static final native void peer_connection_handle_disconnect__SWIG_0(long j, peer_connection_handle peer_connection_handleVar, long j2, error_code error_codeVar, int i, int i2);

    public static final native void peer_connection_handle_disconnect__SWIG_1(long j, peer_connection_handle peer_connection_handleVar, long j2, error_code error_codeVar, int i);

    public static final native boolean peer_connection_handle_failed(long j, peer_connection_handle peer_connection_handleVar);

    public static final native void peer_connection_handle_get_peer_info(long j, peer_connection_handle peer_connection_handleVar, long j2, peer_info peer_infoVar);

    public static final native long peer_connection_handle_get_time_of_last_unchoke(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_has_metadata(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_has_peer_choked(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_has_piece(long j, peer_connection_handle peer_connection_handleVar, int i);

    public static final native boolean peer_connection_handle_ignore_unchoke_slots(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_in_handshake(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_choked(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_connecting(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_disconnecting(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_interesting(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_outgoing(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_peer_interested(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_is_seed(long j, peer_connection_handle peer_connection_handleVar);

    public static final native long peer_connection_handle_last_seen_complete(long j, peer_connection_handle peer_connection_handleVar);

    public static final native long peer_connection_handle_local_endpoint(long j, peer_connection_handle peer_connection_handleVar);

    public static final native void peer_connection_handle_maybe_unchoke_this_peer(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_on_local_network(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_op_eq(long j, peer_connection_handle peer_connection_handleVar, long j2, peer_connection_handle peer_connection_handleVar2);

    public static final native boolean peer_connection_handle_op_lt(long j, peer_connection_handle peer_connection_handleVar, long j2, peer_connection_handle peer_connection_handleVar2);

    public static final native boolean peer_connection_handle_op_ne(long j, peer_connection_handle peer_connection_handleVar, long j2, peer_connection_handle peer_connection_handleVar2);

    public static final native long peer_connection_handle_pid(long j, peer_connection_handle peer_connection_handleVar);

    public static final native long peer_connection_handle_remote(long j, peer_connection_handle peer_connection_handleVar);

    public static final native void peer_connection_handle_send_buffer(long j, peer_connection_handle peer_connection_handleVar, String str, int i);

    public static final native int peer_connection_handle_type(long j, peer_connection_handle peer_connection_handleVar);

    public static final native boolean peer_connection_handle_upload_only(long j, peer_connection_handle peer_connection_handleVar);

    public static final native long peer_disconnected_alert_SWIGUpcast(long j);

    public static final native int peer_disconnected_alert_alert_type_get();

    public static final native long peer_disconnected_alert_category(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native long peer_disconnected_alert_error_get(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native String peer_disconnected_alert_message(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native int peer_disconnected_alert_op_get(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native int peer_disconnected_alert_priority_get();

    public static final native int peer_disconnected_alert_reason_get(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native int peer_disconnected_alert_socket_type_get(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native long peer_disconnected_alert_static_category_get();

    public static final native int peer_disconnected_alert_type(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native String peer_disconnected_alert_what(long j, peer_disconnected_alert peer_disconnected_alertVar);

    public static final native long peer_error_alert_SWIGUpcast(long j);

    public static final native int peer_error_alert_alert_type_get();

    public static final native long peer_error_alert_category(long j, peer_error_alert peer_error_alertVar);

    public static final native long peer_error_alert_error_get(long j, peer_error_alert peer_error_alertVar);

    public static final native String peer_error_alert_message(long j, peer_error_alert peer_error_alertVar);

    public static final native int peer_error_alert_op_get(long j, peer_error_alert peer_error_alertVar);

    public static final native void peer_error_alert_op_set(long j, peer_error_alert peer_error_alertVar, int i);

    public static final native int peer_error_alert_priority_get();

    public static final native long peer_error_alert_static_category_get();

    public static final native int peer_error_alert_type(long j, peer_error_alert peer_error_alertVar);

    public static final native String peer_error_alert_what(long j, peer_error_alert peer_error_alertVar);

    public static final native long peer_flags_t_all();

    public static final native long peer_flags_t_and_(long j, peer_flags_t peer_flags_tVar, long j2, peer_flags_t peer_flags_tVar2);

    public static final native boolean peer_flags_t_eq(long j, peer_flags_t peer_flags_tVar, long j2, peer_flags_t peer_flags_tVar2);

    public static final native long peer_flags_t_inv(long j, peer_flags_t peer_flags_tVar);

    public static final native boolean peer_flags_t_ne(long j, peer_flags_t peer_flags_tVar, long j2, peer_flags_t peer_flags_tVar2);

    public static final native boolean peer_flags_t_nonZero(long j, peer_flags_t peer_flags_tVar);

    public static final native long peer_flags_t_or_(long j, peer_flags_t peer_flags_tVar, long j2, peer_flags_t peer_flags_tVar2);

    public static final native int peer_flags_t_to_int(long j, peer_flags_t peer_flags_tVar);

    public static final native long peer_flags_t_xor(long j, peer_flags_t peer_flags_tVar, long j2, peer_flags_t peer_flags_tVar2);

    public static final native int peer_info_busy_requests_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_busy_requests_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_bw_disk_get();

    public static final native long peer_info_bw_idle_get();

    public static final native long peer_info_bw_limit_get();

    public static final native long peer_info_bw_network_get();

    public static final native long peer_info_choked_get();

    public static final native long peer_info_connecting_get();

    public static final native int peer_info_connection_type_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_connection_type_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_dht_get();

    public static final native int peer_info_down_speed_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_down_speed_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_download_queue_length_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_download_queue_length_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_download_rate_peak_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_download_rate_peak_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_downloading_block_index_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_downloading_block_index_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_downloading_piece_index_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_downloading_piece_index_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_downloading_progress_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_downloading_progress_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_downloading_total_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_downloading_total_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_endgame_mode_get();

    public static final native int peer_info_estimated_reciprocation_rate_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_estimated_reciprocation_rate_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_failcount_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_failcount_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_flags_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_flags_set(long j, peer_info peer_infoVar, long j2, peer_flags_t peer_flags_tVar);

    public static final native long peer_info_get_client(long j, peer_info peer_infoVar);

    public static final native long peer_info_get_download_queue_time(long j, peer_info peer_infoVar);

    public static final native int peer_info_get_flags(long j, peer_info peer_infoVar);

    public static final native long peer_info_get_last_active(long j, peer_info peer_infoVar);

    public static final native long peer_info_get_last_request(long j, peer_info peer_infoVar);

    public static final native byte peer_info_get_read_state(long j, peer_info peer_infoVar);

    public static final native byte peer_info_get_source(long j, peer_info peer_infoVar);

    public static final native byte peer_info_get_write_state(long j, peer_info peer_infoVar);

    public static final native long peer_info_handshake_get();

    public static final native long peer_info_holepunched_get();

    public static final native int peer_info_http_seed_get();

    public static final native long peer_info_i2p_socket_get();

    public static final native long peer_info_incoming_get();

    public static final native long peer_info_interesting_get();

    public static final native long peer_info_ip_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_ip_set(long j, peer_info peer_infoVar, long j2, tcp_endpoint tcp_endpointVar);

    public static final native long peer_info_local_connection_get();

    public static final native long peer_info_local_endpoint_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_local_endpoint_set(long j, peer_info peer_infoVar, long j2, tcp_endpoint tcp_endpointVar);

    public static final native long peer_info_lsd_get();

    public static final native int peer_info_num_hashfails_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_num_hashfails_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_num_pieces_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_num_pieces_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_on_parole_get();

    public static final native long peer_info_optimistic_unchoke_get();

    public static final native int peer_info_payload_down_speed_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_payload_down_speed_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_payload_up_speed_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_payload_up_speed_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_pending_disk_bytes_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_pending_disk_bytes_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_pending_disk_read_bytes_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_pending_disk_read_bytes_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_pex_get();

    public static final native long peer_info_pid_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_pid_set(long j, peer_info peer_infoVar, long j2, sha1_hash sha1_hashVar);

    public static final native long peer_info_pieces_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_pieces_set(long j, peer_info peer_infoVar, long j2, piece_index_bitfield piece_index_bitfieldVar);

    public static final native long peer_info_plaintext_encrypted_get();

    public static final native float peer_info_progress_get(long j, peer_info peer_infoVar);

    public static final native int peer_info_progress_ppm_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_progress_ppm_set(long j, peer_info peer_infoVar, int i);

    public static final native void peer_info_progress_set(long j, peer_info peer_infoVar, float f);

    public static final native int peer_info_queue_bytes_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_queue_bytes_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_rc4_encrypted_get();

    public static final native long peer_info_read_state_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_read_state_set(long j, peer_info peer_infoVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar);

    public static final native int peer_info_receive_buffer_size_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_receive_buffer_size_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_receive_buffer_watermark_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_receive_buffer_watermark_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_receive_quota_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_receive_quota_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_remote_choked_get();

    public static final native long peer_info_remote_interested_get();

    public static final native int peer_info_request_timeout_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_request_timeout_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_requests_in_buffer_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_requests_in_buffer_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_resume_data_get();

    public static final native int peer_info_rtt_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_rtt_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_seed_get();

    public static final native int peer_info_send_buffer_size_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_send_buffer_size_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_send_quota_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_send_quota_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_snubbed_get();

    public static final native long peer_info_source_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_source_set(long j, peer_info peer_infoVar, long j2, peer_source_flags_t peer_source_flags_tVar);

    public static final native long peer_info_ssl_socket_get();

    public static final native int peer_info_standard_bittorrent_get();

    public static final native long peer_info_supports_extensions_get();

    public static final native int peer_info_target_dl_queue_length_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_target_dl_queue_length_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_timed_out_requests_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_timed_out_requests_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_total_download_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_total_download_set(long j, peer_info peer_infoVar, long j2);

    public static final native long peer_info_total_upload_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_total_upload_set(long j, peer_info peer_infoVar, long j2);

    public static final native long peer_info_tracker_get();

    public static final native int peer_info_up_speed_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_up_speed_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_upload_only_get();

    public static final native int peer_info_upload_queue_length_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_upload_queue_length_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_upload_rate_peak_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_upload_rate_peak_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_used_receive_buffer_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_used_receive_buffer_set(long j, peer_info peer_infoVar, int i);

    public static final native int peer_info_used_send_buffer_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_used_send_buffer_set(long j, peer_info peer_infoVar, int i);

    public static final native long peer_info_utp_socket_get();

    public static final native long peer_info_vector_capacity(long j, peer_info_vector peer_info_vectorVar);

    public static final native void peer_info_vector_clear(long j, peer_info_vector peer_info_vectorVar);

    public static final native boolean peer_info_vector_empty(long j, peer_info_vector peer_info_vectorVar);

    public static final native long peer_info_vector_get(long j, peer_info_vector peer_info_vectorVar, int i);

    public static final native void peer_info_vector_push_back(long j, peer_info_vector peer_info_vectorVar, long j2, peer_info peer_infoVar);

    public static final native void peer_info_vector_reserve(long j, peer_info_vector peer_info_vectorVar, long j2);

    public static final native void peer_info_vector_set(long j, peer_info_vector peer_info_vectorVar, int i, long j2, peer_info peer_infoVar);

    public static final native long peer_info_vector_size(long j, peer_info_vector peer_info_vectorVar);

    public static final native int peer_info_web_seed_get();

    public static final native long peer_info_write_state_get(long j, peer_info peer_infoVar);

    public static final native void peer_info_write_state_set(long j, peer_info peer_infoVar, long j2, bandwidth_state_flags_t bandwidth_state_flags_tVar);

    public static final native long peer_log_alert_SWIGUpcast(long j);

    public static final native int peer_log_alert_alert_type_get();

    public static final native long peer_log_alert_category(long j, peer_log_alert peer_log_alertVar);

    public static final native int peer_log_alert_direction_get(long j, peer_log_alert peer_log_alertVar);

    public static final native void peer_log_alert_direction_set(long j, peer_log_alert peer_log_alertVar, int i);

    public static final native String peer_log_alert_get_event_type(long j, peer_log_alert peer_log_alertVar);

    public static final native String peer_log_alert_log_message(long j, peer_log_alert peer_log_alertVar);

    public static final native String peer_log_alert_message(long j, peer_log_alert peer_log_alertVar);

    public static final native int peer_log_alert_priority_get();

    public static final native long peer_log_alert_static_category_get();

    public static final native int peer_log_alert_type(long j, peer_log_alert peer_log_alertVar);

    public static final native String peer_log_alert_what(long j, peer_log_alert peer_log_alertVar);

    public static final native int peer_request_length_get(long j, peer_request peer_requestVar);

    public static final native void peer_request_length_set(long j, peer_request peer_requestVar, int i);

    public static final native boolean peer_request_op_eq(long j, peer_request peer_requestVar, long j2, peer_request peer_requestVar2);

    public static final native int peer_request_piece_get(long j, peer_request peer_requestVar);

    public static final native void peer_request_piece_set(long j, peer_request peer_requestVar, int i);

    public static final native int peer_request_start_get(long j, peer_request peer_requestVar);

    public static final native void peer_request_start_set(long j, peer_request peer_requestVar, int i);

    public static final native long peer_snubbed_alert_SWIGUpcast(long j);

    public static final native int peer_snubbed_alert_alert_type_get();

    public static final native long peer_snubbed_alert_category(long j, peer_snubbed_alert peer_snubbed_alertVar);

    public static final native String peer_snubbed_alert_message(long j, peer_snubbed_alert peer_snubbed_alertVar);

    public static final native int peer_snubbed_alert_priority_get();

    public static final native long peer_snubbed_alert_static_category_get();

    public static final native int peer_snubbed_alert_type(long j, peer_snubbed_alert peer_snubbed_alertVar);

    public static final native String peer_snubbed_alert_what(long j, peer_snubbed_alert peer_snubbed_alertVar);

    public static final native long peer_source_flags_t_all();

    public static final native long peer_source_flags_t_and_(long j, peer_source_flags_t peer_source_flags_tVar, long j2, peer_source_flags_t peer_source_flags_tVar2);

    public static final native boolean peer_source_flags_t_eq(long j, peer_source_flags_t peer_source_flags_tVar, long j2, peer_source_flags_t peer_source_flags_tVar2);

    public static final native long peer_source_flags_t_inv(long j, peer_source_flags_t peer_source_flags_tVar);

    public static final native boolean peer_source_flags_t_ne(long j, peer_source_flags_t peer_source_flags_tVar, long j2, peer_source_flags_t peer_source_flags_tVar2);

    public static final native boolean peer_source_flags_t_nonZero(long j, peer_source_flags_t peer_source_flags_tVar);

    public static final native long peer_source_flags_t_or_(long j, peer_source_flags_t peer_source_flags_tVar, long j2, peer_source_flags_t peer_source_flags_tVar2);

    public static final native int peer_source_flags_t_to_int(long j, peer_source_flags_t peer_source_flags_tVar);

    public static final native long peer_source_flags_t_xor(long j, peer_source_flags_t peer_source_flags_tVar, long j2, peer_source_flags_t peer_source_flags_tVar2);

    public static final native long peer_unsnubbed_alert_SWIGUpcast(long j);

    public static final native int peer_unsnubbed_alert_alert_type_get();

    public static final native long peer_unsnubbed_alert_category(long j, peer_unsnubbed_alert peer_unsnubbed_alertVar);

    public static final native String peer_unsnubbed_alert_message(long j, peer_unsnubbed_alert peer_unsnubbed_alertVar);

    public static final native int peer_unsnubbed_alert_priority_get();

    public static final native long peer_unsnubbed_alert_static_category_get();

    public static final native int peer_unsnubbed_alert_type(long j, peer_unsnubbed_alert peer_unsnubbed_alertVar);

    public static final native String peer_unsnubbed_alert_what(long j, peer_unsnubbed_alert peer_unsnubbed_alertVar);

    public static final native long performance_alert_SWIGUpcast(long j);

    public static final native int performance_alert_alert_type_get();

    public static final native long performance_alert_category(long j, performance_alert performance_alertVar);

    public static final native String performance_alert_message(long j, performance_alert performance_alertVar);

    public static final native int performance_alert_priority_get();

    public static final native long performance_alert_static_category_get();

    public static final native int performance_alert_type(long j, performance_alert performance_alertVar);

    public static final native int performance_alert_warning_code_get(long j, performance_alert performance_alertVar);

    public static final native String performance_alert_what(long j, performance_alert performance_alertVar);

    public static final native int permission_denied_get();

    public static final native long pex_encryption_get();

    public static final native long pex_flags_t_all();

    public static final native long pex_flags_t_and_(long j, pex_flags_t pex_flags_tVar, long j2, pex_flags_t pex_flags_tVar2);

    public static final native boolean pex_flags_t_eq(long j, pex_flags_t pex_flags_tVar, long j2, pex_flags_t pex_flags_tVar2);

    public static final native long pex_flags_t_inv(long j, pex_flags_t pex_flags_tVar);

    public static final native boolean pex_flags_t_ne(long j, pex_flags_t pex_flags_tVar, long j2, pex_flags_t pex_flags_tVar2);

    public static final native boolean pex_flags_t_nonZero(long j, pex_flags_t pex_flags_tVar);

    public static final native long pex_flags_t_or_(long j, pex_flags_t pex_flags_tVar, long j2, pex_flags_t pex_flags_tVar2);

    public static final native int pex_flags_t_to_int(long j, pex_flags_t pex_flags_tVar);

    public static final native long pex_flags_t_xor(long j, pex_flags_t pex_flags_tVar, long j2, pex_flags_t pex_flags_tVar2);

    public static final native long pex_holepunch_get();

    public static final native long pex_seed_get();

    public static final native long pex_utp_get();

    public static final native long picker_flags_t_all();

    public static final native long picker_flags_t_and_(long j, picker_flags_t picker_flags_tVar, long j2, picker_flags_t picker_flags_tVar2);

    public static final native boolean picker_flags_t_eq(long j, picker_flags_t picker_flags_tVar, long j2, picker_flags_t picker_flags_tVar2);

    public static final native long picker_flags_t_inv(long j, picker_flags_t picker_flags_tVar);

    public static final native boolean picker_flags_t_ne(long j, picker_flags_t picker_flags_tVar, long j2, picker_flags_t picker_flags_tVar2);

    public static final native boolean picker_flags_t_nonZero(long j, picker_flags_t picker_flags_tVar);

    public static final native long picker_flags_t_or_(long j, picker_flags_t picker_flags_tVar, long j2, picker_flags_t picker_flags_tVar2);

    public static final native int picker_flags_t_to_int(long j, picker_flags_t picker_flags_tVar);

    public static final native long picker_flags_t_xor(long j, picker_flags_t picker_flags_tVar, long j2, picker_flags_t picker_flags_tVar2);

    public static final native long picker_log_alert_SWIGUpcast(long j);

    public static final native int picker_log_alert_alert_type_get();

    public static final native long picker_log_alert_backup1_get();

    public static final native long picker_log_alert_backup2_get();

    public static final native long picker_log_alert_category(long j, picker_log_alert picker_log_alertVar);

    public static final native long picker_log_alert_end_game_get();

    public static final native long picker_log_alert_extent_affinity_get();

    public static final native String picker_log_alert_message(long j, picker_log_alert picker_log_alertVar);

    public static final native long picker_log_alert_partial_ratio_get();

    public static final native long picker_log_alert_picker_flags_get(long j, picker_log_alert picker_log_alertVar);

    public static final native long picker_log_alert_prefer_contiguous_get();

    public static final native long picker_log_alert_prio_sequential_pieces_get();

    public static final native long picker_log_alert_prioritize_partials_get();

    public static final native int picker_log_alert_priority_get();

    public static final native long picker_log_alert_random_pieces_get();

    public static final native long picker_log_alert_rarest_first_get();

    public static final native long picker_log_alert_rarest_first_partials_get();

    public static final native long picker_log_alert_reverse_pieces_get();

    public static final native long picker_log_alert_reverse_rarest_first_get();

    public static final native long picker_log_alert_reverse_sequential_get();

    public static final native long picker_log_alert_sequential_pieces_get();

    public static final native long picker_log_alert_static_category_get();

    public static final native long picker_log_alert_suggested_pieces_get();

    public static final native long picker_log_alert_time_critical_get();

    public static final native int picker_log_alert_type(long j, picker_log_alert picker_log_alertVar);

    public static final native String picker_log_alert_what(long j, picker_log_alert picker_log_alertVar);

    public static final native long piece_finished_alert_SWIGUpcast(long j);

    public static final native int piece_finished_alert_alert_type_get();

    public static final native long piece_finished_alert_category(long j, piece_finished_alert piece_finished_alertVar);

    public static final native String piece_finished_alert_message(long j, piece_finished_alert piece_finished_alertVar);

    public static final native int piece_finished_alert_piece_index_get(long j, piece_finished_alert piece_finished_alertVar);

    public static final native int piece_finished_alert_priority_get();

    public static final native long piece_finished_alert_static_category_get();

    public static final native int piece_finished_alert_type(long j, piece_finished_alert piece_finished_alertVar);

    public static final native String piece_finished_alert_what(long j, piece_finished_alert piece_finished_alertVar);

    public static final native boolean piece_index_bitfield_all_set(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native void piece_index_bitfield_clear(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native void piece_index_bitfield_clear_all(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native void piece_index_bitfield_clear_bit(long j, piece_index_bitfield piece_index_bitfieldVar, int i);

    public static final native int piece_index_bitfield_count(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native boolean piece_index_bitfield_empty(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int piece_index_bitfield_end_index(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int piece_index_bitfield_find_first_set(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int piece_index_bitfield_find_last_clear(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native boolean piece_index_bitfield_get_bit(long j, piece_index_bitfield piece_index_bitfieldVar, int i);

    public static final native boolean piece_index_bitfield_none_set(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int piece_index_bitfield_num_words(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native void piece_index_bitfield_resize__SWIG_0(long j, piece_index_bitfield piece_index_bitfieldVar, int i, boolean z);

    public static final native void piece_index_bitfield_resize__SWIG_1(long j, piece_index_bitfield piece_index_bitfieldVar, int i);

    public static final native void piece_index_bitfield_set_all(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native void piece_index_bitfield_set_bit(long j, piece_index_bitfield piece_index_bitfieldVar, int i);

    public static final native int piece_index_bitfield_size(long j, piece_index_bitfield piece_index_bitfieldVar);

    public static final native int piece_index_int_pair_first_get(long j, piece_index_int_pair piece_index_int_pairVar);

    public static final native void piece_index_int_pair_first_set(long j, piece_index_int_pair piece_index_int_pairVar, int i);

    public static final native int piece_index_int_pair_second_get(long j, piece_index_int_pair piece_index_int_pairVar);

    public static final native void piece_index_int_pair_second_set(long j, piece_index_int_pair piece_index_int_pairVar, int i);

    public static final native long piece_index_int_pair_vector_capacity(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar);

    public static final native void piece_index_int_pair_vector_clear(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar);

    public static final native boolean piece_index_int_pair_vector_empty(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar);

    public static final native long piece_index_int_pair_vector_get(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar, int i);

    public static final native void piece_index_int_pair_vector_push_back(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar, long j2, piece_index_int_pair piece_index_int_pairVar);

    public static final native void piece_index_int_pair_vector_reserve(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar, long j2);

    public static final native void piece_index_int_pair_vector_set(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar, int i, long j2, piece_index_int_pair piece_index_int_pairVar);

    public static final native long piece_index_int_pair_vector_size(long j, piece_index_int_pair_vector piece_index_int_pair_vectorVar);

    public static final native long piece_index_vector_capacity(long j, piece_index_vector piece_index_vectorVar);

    public static final native void piece_index_vector_clear(long j, piece_index_vector piece_index_vectorVar);

    public static final native boolean piece_index_vector_empty(long j, piece_index_vector piece_index_vectorVar);

    public static final native int piece_index_vector_get(long j, piece_index_vector piece_index_vectorVar, int i);

    public static final native void piece_index_vector_push_back(long j, piece_index_vector piece_index_vectorVar, int i);

    public static final native void piece_index_vector_reserve(long j, piece_index_vector piece_index_vectorVar, long j2);

    public static final native void piece_index_vector_set(long j, piece_index_vector piece_index_vectorVar, int i, int i2);

    public static final native long piece_index_vector_size(long j, piece_index_vector piece_index_vectorVar);

    public static final native long port_filter_access(long j, port_filter port_filterVar, int i);

    public static final native void port_filter_add_rule(long j, port_filter port_filterVar, int i, int i2, long j2);

    public static final native int port_filter_blocked_get();

    public static final native long port_mapping_t_vector_capacity(long j, port_mapping_t_vector port_mapping_t_vectorVar);

    public static final native void port_mapping_t_vector_clear(long j, port_mapping_t_vector port_mapping_t_vectorVar);

    public static final native boolean port_mapping_t_vector_empty(long j, port_mapping_t_vector port_mapping_t_vectorVar);

    public static final native int port_mapping_t_vector_get(long j, port_mapping_t_vector port_mapping_t_vectorVar, int i);

    public static final native void port_mapping_t_vector_push_back(long j, port_mapping_t_vector port_mapping_t_vectorVar, int i);

    public static final native void port_mapping_t_vector_reserve(long j, port_mapping_t_vector port_mapping_t_vectorVar, long j2);

    public static final native void port_mapping_t_vector_set(long j, port_mapping_t_vector port_mapping_t_vectorVar, int i, int i2);

    public static final native long port_mapping_t_vector_size(long j, port_mapping_t_vector port_mapping_t_vectorVar);

    public static final native long portmap_alert_SWIGUpcast(long j);

    public static final native int portmap_alert_alert_type_get();

    public static final native long portmap_alert_category(long j, portmap_alert portmap_alertVar);

    public static final native int portmap_alert_external_port_get(long j, portmap_alert portmap_alertVar);

    public static final native int portmap_alert_map_protocol_get(long j, portmap_alert portmap_alertVar);

    public static final native int portmap_alert_map_transport_get(long j, portmap_alert portmap_alertVar);

    public static final native int portmap_alert_mapping_get(long j, portmap_alert portmap_alertVar);

    public static final native String portmap_alert_message(long j, portmap_alert portmap_alertVar);

    public static final native int portmap_alert_priority_get();

    public static final native long portmap_alert_static_category_get();

    public static final native int portmap_alert_type(long j, portmap_alert portmap_alertVar);

    public static final native String portmap_alert_what(long j, portmap_alert portmap_alertVar);

    public static final native long portmap_error_alert_SWIGUpcast(long j);

    public static final native int portmap_error_alert_alert_type_get();

    public static final native long portmap_error_alert_category(long j, portmap_error_alert portmap_error_alertVar);

    public static final native long portmap_error_alert_error_get(long j, portmap_error_alert portmap_error_alertVar);

    public static final native int portmap_error_alert_map_transport_get(long j, portmap_error_alert portmap_error_alertVar);

    public static final native void portmap_error_alert_map_transport_set(long j, portmap_error_alert portmap_error_alertVar, int i);

    public static final native int portmap_error_alert_mapping_get(long j, portmap_error_alert portmap_error_alertVar);

    public static final native String portmap_error_alert_message(long j, portmap_error_alert portmap_error_alertVar);

    public static final native int portmap_error_alert_priority_get();

    public static final native long portmap_error_alert_static_category_get();

    public static final native int portmap_error_alert_type(long j, portmap_error_alert portmap_error_alertVar);

    public static final native String portmap_error_alert_what(long j, portmap_error_alert portmap_error_alertVar);

    public static final native long portmap_log_alert_SWIGUpcast(long j);

    public static final native int portmap_log_alert_alert_type_get();

    public static final native long portmap_log_alert_category(long j, portmap_log_alert portmap_log_alertVar);

    public static final native String portmap_log_alert_log_message(long j, portmap_log_alert portmap_log_alertVar);

    public static final native int portmap_log_alert_map_transport_get(long j, portmap_log_alert portmap_log_alertVar);

    public static final native String portmap_log_alert_message(long j, portmap_log_alert portmap_log_alertVar);

    public static final native int portmap_log_alert_priority_get();

    public static final native long portmap_log_alert_static_category_get();

    public static final native int portmap_log_alert_type(long j, portmap_log_alert portmap_log_alertVar);

    public static final native String portmap_log_alert_what(long j, portmap_log_alert portmap_log_alertVar);

    public static final native long posix_stat_t_atime_get(long j, posix_stat_t posix_stat_tVar);

    public static final native void posix_stat_t_atime_set(long j, posix_stat_t posix_stat_tVar, long j2);

    public static final native long posix_stat_t_ctime_get(long j, posix_stat_t posix_stat_tVar);

    public static final native void posix_stat_t_ctime_set(long j, posix_stat_t posix_stat_tVar, long j2);

    public static final native int posix_stat_t_mode_get(long j, posix_stat_t posix_stat_tVar);

    public static final native void posix_stat_t_mode_set(long j, posix_stat_t posix_stat_tVar, int i);

    public static final native long posix_stat_t_mtime_get(long j, posix_stat_t posix_stat_tVar);

    public static final native void posix_stat_t_mtime_set(long j, posix_stat_t posix_stat_tVar, long j2);

    public static final native long posix_stat_t_size_get(long j, posix_stat_t posix_stat_tVar);

    public static final native void posix_stat_t_size_set(long j, posix_stat_t posix_stat_tVar, long j2);

    public static final native void posix_wrapper_change_ownership(posix_wrapper posix_wrapperVar, long j, boolean z);

    public static final native void posix_wrapper_director_connect(posix_wrapper posix_wrapperVar, long j, boolean z, boolean z2);

    public static final native int posix_wrapper_mkdir(long j, posix_wrapper posix_wrapperVar, String str, int i);

    public static final native int posix_wrapper_mkdirSwigExplicitposix_wrapper(long j, posix_wrapper posix_wrapperVar, String str, int i);

    public static final native int posix_wrapper_open(long j, posix_wrapper posix_wrapperVar, String str, int i, int i2);

    public static final native int posix_wrapper_openSwigExplicitposix_wrapper(long j, posix_wrapper posix_wrapperVar, String str, int i, int i2);

    public static final native int posix_wrapper_remove(long j, posix_wrapper posix_wrapperVar, String str);

    public static final native int posix_wrapper_removeSwigExplicitposix_wrapper(long j, posix_wrapper posix_wrapperVar, String str);

    public static final native int posix_wrapper_rename(long j, posix_wrapper posix_wrapperVar, String str, String str2);

    public static final native int posix_wrapper_renameSwigExplicitposix_wrapper(long j, posix_wrapper posix_wrapperVar, String str, String str2);

    public static final native int posix_wrapper_stat(long j, posix_wrapper posix_wrapperVar, String str, long j2, posix_stat_t posix_stat_tVar);

    public static final native int posix_wrapper_statSwigExplicitposix_wrapper(long j, posix_wrapper posix_wrapperVar, String str, long j2, posix_stat_t posix_stat_tVar);

    public static final native String print_error(long j, error_code error_codeVar);

    public static final native int protocol_error_get();

    public static final native int protocol_not_supported_get();

    public static final native int read_only_file_system_get();

    public static final native long read_piece_alert_SWIGUpcast(long j);

    public static final native int read_piece_alert_alert_type_get();

    public static final native long read_piece_alert_buffer_ptr(long j, read_piece_alert read_piece_alertVar);

    public static final native long read_piece_alert_category(long j, read_piece_alert read_piece_alertVar);

    public static final native long read_piece_alert_error_get(long j, read_piece_alert read_piece_alertVar);

    public static final native String read_piece_alert_message(long j, read_piece_alert read_piece_alertVar);

    public static final native int read_piece_alert_piece_get(long j, read_piece_alert read_piece_alertVar);

    public static final native int read_piece_alert_priority_get();

    public static final native int read_piece_alert_size_get(long j, read_piece_alert read_piece_alertVar);

    public static final native long read_piece_alert_static_category_get();

    public static final native int read_piece_alert_type(long j, read_piece_alert read_piece_alertVar);

    public static final native String read_piece_alert_what(long j, read_piece_alert read_piece_alertVar);

    public static final native long read_session_params__SWIG_0(long j, bdecode_node bdecode_nodeVar, long j2, save_state_flags_t save_state_flags_tVar);

    public static final native long read_session_params__SWIG_1(long j, bdecode_node bdecode_nodeVar);

    public static final native long reannounce_flags_t_all();

    public static final native long reannounce_flags_t_and_(long j, reannounce_flags_t reannounce_flags_tVar, long j2, reannounce_flags_t reannounce_flags_tVar2);

    public static final native boolean reannounce_flags_t_eq(long j, reannounce_flags_t reannounce_flags_tVar, long j2, reannounce_flags_t reannounce_flags_tVar2);

    public static final native long reannounce_flags_t_inv(long j, reannounce_flags_t reannounce_flags_tVar);

    public static final native boolean reannounce_flags_t_ne(long j, reannounce_flags_t reannounce_flags_tVar, long j2, reannounce_flags_t reannounce_flags_tVar2);

    public static final native boolean reannounce_flags_t_nonZero(long j, reannounce_flags_t reannounce_flags_tVar);

    public static final native long reannounce_flags_t_or_(long j, reannounce_flags_t reannounce_flags_tVar, long j2, reannounce_flags_t reannounce_flags_tVar2);

    public static final native int reannounce_flags_t_to_int(long j, reannounce_flags_t reannounce_flags_tVar);

    public static final native long reannounce_flags_t_xor(long j, reannounce_flags_t reannounce_flags_tVar, long j2, reannounce_flags_t reannounce_flags_tVar2);

    public static final native long remove_flags_t_all();

    public static final native long remove_flags_t_and_(long j, remove_flags_t remove_flags_tVar, long j2, remove_flags_t remove_flags_tVar2);

    public static final native boolean remove_flags_t_eq(long j, remove_flags_t remove_flags_tVar, long j2, remove_flags_t remove_flags_tVar2);

    public static final native long remove_flags_t_inv(long j, remove_flags_t remove_flags_tVar);

    public static final native boolean remove_flags_t_ne(long j, remove_flags_t remove_flags_tVar, long j2, remove_flags_t remove_flags_tVar2);

    public static final native boolean remove_flags_t_nonZero(long j, remove_flags_t remove_flags_tVar);

    public static final native long remove_flags_t_or_(long j, remove_flags_t remove_flags_tVar, long j2, remove_flags_t remove_flags_tVar2);

    public static final native int remove_flags_t_to_int(long j, remove_flags_t remove_flags_tVar);

    public static final native long remove_flags_t_xor(long j, remove_flags_t remove_flags_tVar, long j2, remove_flags_t remove_flags_tVar2);

    public static final native long reopen_network_flags_t_all();

    public static final native long reopen_network_flags_t_and_(long j, reopen_network_flags_t reopen_network_flags_tVar, long j2, reopen_network_flags_t reopen_network_flags_tVar2);

    public static final native boolean reopen_network_flags_t_eq(long j, reopen_network_flags_t reopen_network_flags_tVar, long j2, reopen_network_flags_t reopen_network_flags_tVar2);

    public static final native long reopen_network_flags_t_inv(long j, reopen_network_flags_t reopen_network_flags_tVar);

    public static final native boolean reopen_network_flags_t_ne(long j, reopen_network_flags_t reopen_network_flags_tVar, long j2, reopen_network_flags_t reopen_network_flags_tVar2);

    public static final native boolean reopen_network_flags_t_nonZero(long j, reopen_network_flags_t reopen_network_flags_tVar);

    public static final native long reopen_network_flags_t_or_(long j, reopen_network_flags_t reopen_network_flags_tVar, long j2, reopen_network_flags_t reopen_network_flags_tVar2);

    public static final native int reopen_network_flags_t_to_int(long j, reopen_network_flags_t reopen_network_flags_tVar);

    public static final native long reopen_network_flags_t_xor(long j, reopen_network_flags_t reopen_network_flags_tVar, long j2, reopen_network_flags_t reopen_network_flags_tVar2);

    public static final native long request_dropped_alert_SWIGUpcast(long j);

    public static final native int request_dropped_alert_alert_type_get();

    public static final native int request_dropped_alert_block_index_get(long j, request_dropped_alert request_dropped_alertVar);

    public static final native long request_dropped_alert_category(long j, request_dropped_alert request_dropped_alertVar);

    public static final native String request_dropped_alert_message(long j, request_dropped_alert request_dropped_alertVar);

    public static final native int request_dropped_alert_piece_index_get(long j, request_dropped_alert request_dropped_alertVar);

    public static final native int request_dropped_alert_priority_get();

    public static final native long request_dropped_alert_static_category_get();

    public static final native int request_dropped_alert_type(long j, request_dropped_alert request_dropped_alertVar);

    public static final native String request_dropped_alert_what(long j, request_dropped_alert request_dropped_alertVar);

    public static final native int resource_deadlock_would_occur_get();

    public static final native int resource_unavailable_try_again_get();

    public static final native int result_out_of_range_get();

    public static final native long resume_data_flags_t_all();

    public static final native long resume_data_flags_t_and_(long j, resume_data_flags_t resume_data_flags_tVar, long j2, resume_data_flags_t resume_data_flags_tVar2);

    public static final native boolean resume_data_flags_t_eq(long j, resume_data_flags_t resume_data_flags_tVar, long j2, resume_data_flags_t resume_data_flags_tVar2);

    public static final native long resume_data_flags_t_inv(long j, resume_data_flags_t resume_data_flags_tVar);

    public static final native boolean resume_data_flags_t_ne(long j, resume_data_flags_t resume_data_flags_tVar, long j2, resume_data_flags_t resume_data_flags_tVar2);

    public static final native boolean resume_data_flags_t_nonZero(long j, resume_data_flags_t resume_data_flags_tVar);

    public static final native long resume_data_flags_t_or_(long j, resume_data_flags_t resume_data_flags_tVar, long j2, resume_data_flags_t resume_data_flags_tVar2);

    public static final native int resume_data_flags_t_to_int(long j, resume_data_flags_t resume_data_flags_tVar);

    public static final native long resume_data_flags_t_xor(long j, resume_data_flags_t resume_data_flags_tVar, long j2, resume_data_flags_t resume_data_flags_tVar2);

    public static final native long save_resume_data_alert_SWIGUpcast(long j);

    public static final native int save_resume_data_alert_alert_type_get();

    public static final native long save_resume_data_alert_category(long j, save_resume_data_alert save_resume_data_alertVar);

    public static final native String save_resume_data_alert_message(long j, save_resume_data_alert save_resume_data_alertVar);

    public static final native long save_resume_data_alert_params_get(long j, save_resume_data_alert save_resume_data_alertVar);

    public static final native void save_resume_data_alert_params_set(long j, save_resume_data_alert save_resume_data_alertVar, long j2, add_torrent_params add_torrent_paramsVar);

    public static final native int save_resume_data_alert_priority_get();

    public static final native long save_resume_data_alert_static_category_get();

    public static final native int save_resume_data_alert_type(long j, save_resume_data_alert save_resume_data_alertVar);

    public static final native String save_resume_data_alert_what(long j, save_resume_data_alert save_resume_data_alertVar);

    public static final native long save_resume_data_failed_alert_SWIGUpcast(long j);

    public static final native int save_resume_data_failed_alert_alert_type_get();

    public static final native long save_resume_data_failed_alert_category(long j, save_resume_data_failed_alert save_resume_data_failed_alertVar);

    public static final native long save_resume_data_failed_alert_error_get(long j, save_resume_data_failed_alert save_resume_data_failed_alertVar);

    public static final native String save_resume_data_failed_alert_message(long j, save_resume_data_failed_alert save_resume_data_failed_alertVar);

    public static final native int save_resume_data_failed_alert_priority_get();

    public static final native long save_resume_data_failed_alert_static_category_get();

    public static final native int save_resume_data_failed_alert_type(long j, save_resume_data_failed_alert save_resume_data_failed_alertVar);

    public static final native String save_resume_data_failed_alert_what(long j, save_resume_data_failed_alert save_resume_data_failed_alertVar);

    public static final native long save_state_flags_t_all();

    public static final native long save_state_flags_t_and_(long j, save_state_flags_t save_state_flags_tVar, long j2, save_state_flags_t save_state_flags_tVar2);

    public static final native boolean save_state_flags_t_eq(long j, save_state_flags_t save_state_flags_tVar, long j2, save_state_flags_t save_state_flags_tVar2);

    public static final native long save_state_flags_t_inv(long j, save_state_flags_t save_state_flags_tVar);

    public static final native boolean save_state_flags_t_ne(long j, save_state_flags_t save_state_flags_tVar, long j2, save_state_flags_t save_state_flags_tVar2);

    public static final native boolean save_state_flags_t_nonZero(long j, save_state_flags_t save_state_flags_tVar);

    public static final native long save_state_flags_t_or_(long j, save_state_flags_t save_state_flags_tVar, long j2, save_state_flags_t save_state_flags_tVar2);

    public static final native int save_state_flags_t_to_int(long j, save_state_flags_t save_state_flags_tVar);

    public static final native long save_state_flags_t_xor(long j, save_state_flags_t save_state_flags_tVar, long j2, save_state_flags_t save_state_flags_tVar2);

    public static final native long scrape_failed_alert_SWIGUpcast(long j);

    public static final native int scrape_failed_alert_alert_type_get();

    public static final native long scrape_failed_alert_category(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native long scrape_failed_alert_error_get(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native String scrape_failed_alert_error_message(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native String scrape_failed_alert_message(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native int scrape_failed_alert_priority_get();

    public static final native long scrape_failed_alert_static_category_get();

    public static final native int scrape_failed_alert_type(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native String scrape_failed_alert_what(long j, scrape_failed_alert scrape_failed_alertVar);

    public static final native int scrape_not_available_get();

    public static final native long scrape_reply_alert_SWIGUpcast(long j);

    public static final native int scrape_reply_alert_alert_type_get();

    public static final native long scrape_reply_alert_category(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native int scrape_reply_alert_complete_get(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native int scrape_reply_alert_incomplete_get(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native String scrape_reply_alert_message(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native int scrape_reply_alert_priority_get();

    public static final native long scrape_reply_alert_static_category_get();

    public static final native int scrape_reply_alert_type(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native String scrape_reply_alert_what(long j, scrape_reply_alert scrape_reply_alertVar);

    public static final native long seed_mode_get();

    public static final native long sequential_download_get();

    public static final native int service_unavailable_get();

    public static final native long session_SWIGUpcast(long j);

    public static final native long session_abort(long j, C2430session c2430session);

    public static final native long session_error_alert_SWIGUpcast(long j);

    public static final native int session_error_alert_alert_type_get();

    public static final native long session_error_alert_category(long j, session_error_alert session_error_alertVar);

    public static final native long session_error_alert_error_get(long j, session_error_alert session_error_alertVar);

    public static final native String session_error_alert_message(long j, session_error_alert session_error_alertVar);

    public static final native int session_error_alert_priority_get();

    public static final native long session_error_alert_static_category_get();

    public static final native int session_error_alert_type(long j, session_error_alert session_error_alertVar);

    public static final native String session_error_alert_what(long j, session_error_alert session_error_alertVar);

    public static final native long session_flags_t_all();

    public static final native long session_flags_t_and_(long j, session_flags_t session_flags_tVar, long j2, session_flags_t session_flags_tVar2);

    public static final native boolean session_flags_t_eq(long j, session_flags_t session_flags_tVar, long j2, session_flags_t session_flags_tVar2);

    public static final native long session_flags_t_inv(long j, session_flags_t session_flags_tVar);

    public static final native boolean session_flags_t_ne(long j, session_flags_t session_flags_tVar, long j2, session_flags_t session_flags_tVar2);

    public static final native boolean session_flags_t_nonZero(long j, session_flags_t session_flags_tVar);

    public static final native long session_flags_t_or_(long j, session_flags_t session_flags_tVar, long j2, session_flags_t session_flags_tVar2);

    public static final native int session_flags_t_to_int(long j, session_flags_t session_flags_tVar);

    public static final native long session_flags_t_xor(long j, session_flags_t session_flags_tVar, long j2, session_flags_t session_flags_tVar2);

    public static final native long session_handle_add_default_plugins_get();

    public static final native void session_handle_add_dht_node(long j, session_handle session_handleVar, long j2, string_int_pair string_int_pairVar);

    public static final native void session_handle_add_extension(long j, session_handle session_handleVar, long j2, swig_plugin swig_pluginVar);

    public static final native long session_handle_add_port_mapping(long j, session_handle session_handleVar, int i, int i2, int i3);

    public static final native long session_handle_add_torrent(long j, session_handle session_handleVar, long j2, add_torrent_params add_torrent_paramsVar, long j3, error_code error_codeVar);

    public static final native void session_handle_apply_settings(long j, session_handle session_handleVar, long j2, settings_pack settings_packVar);

    public static final native void session_handle_async_add_torrent(long j, session_handle session_handleVar, long j2, add_torrent_params add_torrent_paramsVar);

    public static final native int session_handle_create_peer_class(long j, session_handle session_handleVar, String str);

    public static final native long session_handle_delete_files_get();

    public static final native long session_handle_delete_partfile_get();

    public static final native void session_handle_delete_peer_class(long j, session_handle session_handleVar, int i);

    public static final native void session_handle_delete_port_mapping(long j, session_handle session_handleVar, int i);

    public static final native void session_handle_dht_announce__SWIG_0(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar, int i, int i2);

    public static final native void session_handle_dht_announce__SWIG_1(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar, int i);

    public static final native void session_handle_dht_announce__SWIG_2(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar);

    public static final native void session_handle_dht_direct_request__SWIG_0(long j, session_handle session_handleVar, long j2, udp_endpoint udp_endpointVar, long j3, entry entryVar);

    public static final native void session_handle_dht_direct_request__SWIG_1(long j, session_handle session_handleVar, long j2, udp_endpoint udp_endpointVar, long j3, entry entryVar, long j4);

    public static final native void session_handle_dht_get_item__SWIG_0(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar);

    public static final native void session_handle_dht_get_item__SWIG_1(long j, session_handle session_handleVar, long j2, byte_vector byte_vectorVar, long j3, byte_vector byte_vectorVar2);

    public static final native void session_handle_dht_get_peers(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar);

    public static final native void session_handle_dht_live_nodes(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar);

    public static final native long session_handle_dht_put_item__SWIG_0(long j, session_handle session_handleVar, long j2, entry entryVar);

    public static final native void session_handle_dht_put_item__SWIG_1(long j, session_handle session_handleVar, long j2, byte_vector byte_vectorVar, long j3, byte_vector byte_vectorVar2, long j4, entry entryVar, long j5, byte_vector byte_vectorVar3);

    public static final native void session_handle_dht_sample_infohashes(long j, session_handle session_handleVar, long j2, udp_endpoint udp_endpointVar, long j3, sha1_hash sha1_hashVar);

    public static final native int session_handle_disk_cache_no_pieces_get();

    public static final native long session_handle_find_torrent(long j, session_handle session_handleVar, long j2, sha1_hash sha1_hashVar);

    public static final native long session_handle_get_dht_settings(long j, session_handle session_handleVar);

    public static final native long session_handle_get_ip_filter(long j, session_handle session_handleVar);

    public static final native long session_handle_get_peer_class(long j, session_handle session_handleVar, int i);

    public static final native long session_handle_get_peer_class_filter(long j, session_handle session_handleVar);

    public static final native long session_handle_get_peer_class_type_filter(long j, session_handle session_handleVar);

    public static final native long session_handle_get_settings(long j, session_handle session_handleVar);

    public static final native long session_handle_get_torrents(long j, session_handle session_handleVar);

    public static final native int session_handle_global_peer_class_id_get();

    public static final native boolean session_handle_is_dht_running(long j, session_handle session_handleVar);

    public static final native boolean session_handle_is_listening(long j, session_handle session_handleVar);

    public static final native boolean session_handle_is_paused(long j, session_handle session_handleVar);

    public static final native boolean session_handle_is_valid(long j, session_handle session_handleVar);

    public static final native int session_handle_listen_port(long j, session_handle session_handleVar);

    public static final native void session_handle_load_state__SWIG_0(long j, session_handle session_handleVar, long j2, bdecode_node bdecode_nodeVar, long j3, save_state_flags_t save_state_flags_tVar);

    public static final native void session_handle_load_state__SWIG_1(long j, session_handle session_handleVar, long j2, bdecode_node bdecode_nodeVar);

    public static final native int session_handle_local_peer_class_id_get();

    public static final native void session_handle_pause(long j, session_handle session_handleVar);

    public static final native void session_handle_pop_alerts(long j, session_handle session_handleVar, long j2, alert_ptr_vector alert_ptr_vectorVar);

    public static final native void session_handle_post_dht_stats(long j, session_handle session_handleVar);

    public static final native void session_handle_post_session_stats(long j, session_handle session_handleVar);

    public static final native void session_handle_post_torrent_updates__SWIG_0(long j, session_handle session_handleVar, long j2, status_flags_t status_flags_tVar);

    public static final native void session_handle_post_torrent_updates__SWIG_1(long j, session_handle session_handleVar);

    public static final native void session_handle_refresh_torrent_status__SWIG_0(long j, session_handle session_handleVar, long j2, torrent_status_vector torrent_status_vectorVar, long j3, status_flags_t status_flags_tVar);

    public static final native void session_handle_refresh_torrent_status__SWIG_1(long j, session_handle session_handleVar, long j2, torrent_status_vector torrent_status_vectorVar);

    public static final native void session_handle_remove_torrent__SWIG_0(long j, session_handle session_handleVar, long j2, torrent_handle torrent_handleVar, long j3, remove_flags_t remove_flags_tVar);

    public static final native void session_handle_remove_torrent__SWIG_1(long j, session_handle session_handleVar, long j2, torrent_handle torrent_handleVar);

    public static final native long session_handle_reopen_map_ports_get();

    public static final native void session_handle_reopen_network_sockets__SWIG_0(long j, session_handle session_handleVar, long j2, reopen_network_flags_t reopen_network_flags_tVar);

    public static final native void session_handle_reopen_network_sockets__SWIG_1(long j, session_handle session_handleVar);

    public static final native void session_handle_resume(long j, session_handle session_handleVar);

    public static final native long session_handle_save_dht_settings_get();

    public static final native long session_handle_save_dht_state_get();

    public static final native long session_handle_save_settings_get();

    public static final native void session_handle_save_state__SWIG_0(long j, session_handle session_handleVar, long j2, entry entryVar, long j3, save_state_flags_t save_state_flags_tVar);

    public static final native void session_handle_save_state__SWIG_1(long j, session_handle session_handleVar, long j2, entry entryVar);

    public static final native void session_handle_set_alert_notify_callback(long j, session_handle session_handleVar, long j2, alert_notify_callback alert_notify_callbackVar);

    public static final native void session_handle_set_dht_settings(long j, session_handle session_handleVar, long j2, dht_settings dht_settingsVar);

    public static final native void session_handle_set_ip_filter(long j, session_handle session_handleVar, long j2, ip_filter ip_filterVar);

    public static final native void session_handle_set_peer_class(long j, session_handle session_handleVar, int i, long j2, peer_class_info peer_class_infoVar);

    public static final native void session_handle_set_peer_class_filter(long j, session_handle session_handleVar, long j2, ip_filter ip_filterVar);

    public static final native void session_handle_set_peer_class_type_filter(long j, session_handle session_handleVar, long j2, peer_class_type_filter peer_class_type_filterVar);

    public static final native void session_handle_set_port_filter(long j, session_handle session_handleVar, long j2, port_filter port_filterVar);

    public static final native int session_handle_ssl_listen_port(long j, session_handle session_handleVar);

    public static final native int session_handle_tcp_get();

    public static final native int session_handle_tcp_peer_class_id_get();

    public static final native int session_handle_udp_get();

    public static final native long session_handle_wait_for_alert_ms(long j, session_handle session_handleVar, long j2);

    public static final native long session_params_dht_settings_get(long j, session_params session_paramsVar);

    public static final native void session_params_dht_settings_set(long j, session_params session_paramsVar, long j2, dht_settings dht_settingsVar);

    public static final native long session_params_dht_state_get(long j, session_params session_paramsVar);

    public static final native void session_params_dht_state_set(long j, session_params session_paramsVar, long j2, dht_state dht_stateVar);

    public static final native long session_params_settings_get(long j, session_params session_paramsVar);

    public static final native void session_params_settings_set(long j, session_params session_paramsVar, long j2, settings_pack settings_packVar);

    public static final native long session_stats_alert_SWIGUpcast(long j);

    public static final native int session_stats_alert_alert_type_get();

    public static final native long session_stats_alert_category(long j, session_stats_alert session_stats_alertVar);

    public static final native long session_stats_alert_get_value(long j, session_stats_alert session_stats_alertVar, int i);

    public static final native String session_stats_alert_message(long j, session_stats_alert session_stats_alertVar);

    public static final native int session_stats_alert_priority_get();

    public static final native long session_stats_alert_static_category_get();

    public static final native int session_stats_alert_type(long j, session_stats_alert session_stats_alertVar);

    public static final native String session_stats_alert_what(long j, session_stats_alert session_stats_alertVar);

    public static final native long session_stats_header_alert_SWIGUpcast(long j);

    public static final native int session_stats_header_alert_alert_type_get();

    public static final native long session_stats_header_alert_category(long j, session_stats_header_alert session_stats_header_alertVar);

    public static final native String session_stats_header_alert_message(long j, session_stats_header_alert session_stats_header_alertVar);

    public static final native int session_stats_header_alert_priority_get();

    public static final native long session_stats_header_alert_static_category_get();

    public static final native int session_stats_header_alert_type(long j, session_stats_header_alert session_stats_header_alertVar);

    public static final native String session_stats_header_alert_what(long j, session_stats_header_alert session_stats_header_alertVar);

    public static final native long session_stats_metrics();

    public static final native void set_piece_hashes(long j, create_torrent create_torrentVar, String str, long j2, error_code error_codeVar);

    public static final native void set_piece_hashes_ex(long j, create_torrent create_torrentVar, String str, long j2, set_piece_hashes_listener set_piece_hashes_listenerVar, long j3, error_code error_codeVar);

    public static final native void set_piece_hashes_listener_change_ownership(set_piece_hashes_listener set_piece_hashes_listenerVar, long j, boolean z);

    public static final native void set_piece_hashes_listener_director_connect(set_piece_hashes_listener set_piece_hashes_listenerVar, long j, boolean z, boolean z2);

    public static final native void set_piece_hashes_listener_progress(long j, set_piece_hashes_listener set_piece_hashes_listenerVar, int i);

    /* renamed from: set_piece_hashes_listener_progressSwigExplicitset_piece_hashes_listener */
    public static final native void m6045x4f33fdd0(long j, set_piece_hashes_listener set_piece_hashes_listenerVar, int i);

    public static final native void set_posix_wrapper(long j, posix_wrapper posix_wrapperVar);

    public static final native int setting_by_name(long j, string_view string_viewVar);

    public static final native long settings_SWIGUpcast(long j);

    public static final native int settings_pack_allow_multiple_connections_per_ip_get();

    public static final native int settings_pack_announce_crypto_support_get();

    public static final native int settings_pack_auto_manage_interval_get();

    public static final native int settings_pack_ban_web_seeds_get();

    public static final native int settings_pack_bittyrant_choker_get();

    public static final native int settings_pack_bool_type_base_get();

    public static final native int settings_pack_cache_expiry_get();

    public static final native int settings_pack_checking_mem_usage_get();

    public static final native void settings_pack_clear__SWIG_0(long j, settings_pack settings_packVar);

    public static final native void settings_pack_clear__SWIG_1(long j, settings_pack settings_packVar, int i);

    public static final native int settings_pack_coalesce_reads_get();

    public static final native int settings_pack_connections_limit_get();

    public static final native int settings_pack_deprecated_disable_os_cache_for_aligned_files_get();

    public static final native int settings_pack_dht_upload_rate_limit_get();

    public static final native int settings_pack_disable_hash_checks_get();

    public static final native int settings_pack_disable_os_cache_get();

    public static final native int settings_pack_enable_os_cache_get();

    public static final native int settings_pack_enable_outgoing_utp_get();

    public static final native int settings_pack_fixed_slots_choker_get();

    public static final native boolean settings_pack_get_bool(long j, settings_pack settings_packVar, int i);

    public static final native int settings_pack_get_int(long j, settings_pack settings_packVar, int i);

    public static final native String settings_pack_get_str(long j, settings_pack settings_packVar, int i);

    public static final native int settings_pack_handshake_client_version_get();

    public static final native boolean settings_pack_has_val(long j, settings_pack settings_packVar, int i);

    public static final native int settings_pack_index_mask_get();

    public static final native int settings_pack_int_type_base_get();

    public static final native int settings_pack_no_atime_storage_get();

    public static final native int settings_pack_no_piece_suggestions_get();

    public static final native int settings_pack_no_recheck_incomplete_resume_get();

    public static final native int settings_pack_num_bool_settings_get();

    public static final native int settings_pack_num_int_settings_get();

    public static final native int settings_pack_num_optimistic_unchoke_slots_get();

    public static final native int settings_pack_num_string_settings_get();

    public static final native int settings_pack_pe_both_get();

    public static final native int settings_pack_pe_plaintext_get();

    public static final native int settings_pack_pe_rc4_get();

    public static final native int settings_pack_peer_proportional_get();

    public static final native int settings_pack_prefer_tcp_get();

    public static final native int settings_pack_rate_based_choker_get();

    public static final native int settings_pack_read_cache_line_size_get();

    public static final native int settings_pack_seeding_outgoing_connections_get();

    public static final native int settings_pack_send_redundant_have_get();

    public static final native void settings_pack_set_bool(long j, settings_pack settings_packVar, int i, boolean z);

    public static final native void settings_pack_set_int(long j, settings_pack settings_packVar, int i, int i2);

    public static final native void settings_pack_set_str(long j, settings_pack settings_packVar, int i, String str);

    public static final native int settings_pack_string_type_base_get();

    public static final native int settings_pack_suggest_read_cache_get();

    public static final native int settings_pack_support_share_mode_get();

    public static final native int settings_pack_tracker_backoff_get();

    public static final native int settings_pack_tracker_completion_timeout_get();

    public static final native int settings_pack_type_mask_get();

    public static final native int settings_pack_use_dht_as_fallback_get();

    public static final native int settings_pack_use_parole_mode_get();

    public static final native int settings_pack_user_agent_get();

    public static final native int settings_pack_utp_loss_multiplier_get();

    public static final native int settings_pack_volatile_read_cache_get();

    public static final native boolean settings_prefer_verified_node_ids_get(long j, C2431settings c2431settings);

    public static final native void settings_prefer_verified_node_ids_set(long j, C2431settings c2431settings, boolean z);

    public static final native void sha1_hash_clear(long j, sha1_hash sha1_hashVar);

    public static final native int sha1_hash_compare(long j, sha1_hash sha1_hashVar, long j2, sha1_hash sha1_hashVar2);

    public static final native int sha1_hash_count_leading_zeroes(long j, sha1_hash sha1_hashVar);

    public static final native int sha1_hash_hash_code(long j, sha1_hash sha1_hashVar);

    public static final native boolean sha1_hash_is_all_zeros(long j, sha1_hash sha1_hashVar);

    public static final native long sha1_hash_max();

    public static final native long sha1_hash_min();

    public static final native boolean sha1_hash_op_eq(long j, sha1_hash sha1_hashVar, long j2, sha1_hash sha1_hashVar2);

    public static final native boolean sha1_hash_op_lt(long j, sha1_hash sha1_hashVar, long j2, sha1_hash sha1_hashVar2);

    public static final native boolean sha1_hash_op_ne(long j, sha1_hash sha1_hashVar, long j2, sha1_hash sha1_hashVar2);

    public static final native long sha1_hash_size();

    public static final native long sha1_hash_to_bytes(long j, sha1_hash sha1_hashVar);

    public static final native String sha1_hash_to_hex(long j, sha1_hash sha1_hashVar);

    public static final native long sha1_hash_udp_endpoint_pair_first_get(long j, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar);

    public static final native void sha1_hash_udp_endpoint_pair_first_set(long j, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar, long j2, sha1_hash sha1_hashVar);

    public static final native long sha1_hash_udp_endpoint_pair_second_get(long j, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar);

    public static final native void sha1_hash_udp_endpoint_pair_second_set(long j, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar, long j2, udp_endpoint udp_endpointVar);

    public static final native long sha1_hash_udp_endpoint_pair_vector_capacity(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar);

    public static final native void sha1_hash_udp_endpoint_pair_vector_clear(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar);

    public static final native boolean sha1_hash_udp_endpoint_pair_vector_empty(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar);

    public static final native long sha1_hash_udp_endpoint_pair_vector_get(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar, int i);

    public static final native void sha1_hash_udp_endpoint_pair_vector_push_back(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar, long j2, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar);

    public static final native void sha1_hash_udp_endpoint_pair_vector_reserve(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar, long j2);

    public static final native void sha1_hash_udp_endpoint_pair_vector_set(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar, int i, long j2, sha1_hash_udp_endpoint_pair sha1_hash_udp_endpoint_pairVar);

    public static final native long sha1_hash_udp_endpoint_pair_vector_size(long j, sha1_hash_udp_endpoint_pair_vector sha1_hash_udp_endpoint_pair_vectorVar);

    public static final native long sha1_hash_vector_capacity(long j, sha1_hash_vector sha1_hash_vectorVar);

    public static final native void sha1_hash_vector_clear(long j, sha1_hash_vector sha1_hash_vectorVar);

    public static final native boolean sha1_hash_vector_empty(long j, sha1_hash_vector sha1_hash_vectorVar);

    public static final native long sha1_hash_vector_get(long j, sha1_hash_vector sha1_hash_vectorVar, int i);

    public static final native void sha1_hash_vector_push_back(long j, sha1_hash_vector sha1_hash_vectorVar, long j2, sha1_hash sha1_hashVar);

    public static final native void sha1_hash_vector_reserve(long j, sha1_hash_vector sha1_hash_vectorVar, long j2);

    public static final native void sha1_hash_vector_set(long j, sha1_hash_vector sha1_hash_vectorVar, int i, long j2, sha1_hash sha1_hashVar);

    public static final native long sha1_hash_vector_size(long j, sha1_hash_vector sha1_hash_vectorVar);

    public static final native long share_mode_get();

    public static final native long socks5_alert_SWIGUpcast(long j);

    public static final native int socks5_alert_alert_type_get();

    public static final native long socks5_alert_category(long j, socks5_alert socks5_alertVar);

    public static final native long socks5_alert_error_get(long j, socks5_alert socks5_alertVar);

    public static final native void socks5_alert_error_set(long j, socks5_alert socks5_alertVar, long j2, error_code error_codeVar);

    public static final native long socks5_alert_ip_get(long j, socks5_alert socks5_alertVar);

    public static final native void socks5_alert_ip_set(long j, socks5_alert socks5_alertVar, long j2);

    public static final native String socks5_alert_message(long j, socks5_alert socks5_alertVar);

    public static final native int socks5_alert_op_get(long j, socks5_alert socks5_alertVar);

    public static final native void socks5_alert_op_set(long j, socks5_alert socks5_alertVar, int i);

    public static final native int socks5_alert_priority_get();

    public static final native long socks5_alert_static_category_get();

    public static final native int socks5_alert_type(long j, socks5_alert socks5_alertVar);

    public static final native String socks5_alert_what(long j, socks5_alert socks5_alertVar);

    public static final native long state_changed_alert_SWIGUpcast(long j);

    public static final native int state_changed_alert_alert_type_get();

    public static final native long state_changed_alert_category(long j, state_changed_alert state_changed_alertVar);

    public static final native String state_changed_alert_message(long j, state_changed_alert state_changed_alertVar);

    public static final native int state_changed_alert_prev_state_get(long j, state_changed_alert state_changed_alertVar);

    public static final native int state_changed_alert_priority_get();

    public static final native int state_changed_alert_state_get(long j, state_changed_alert state_changed_alertVar);

    public static final native long state_changed_alert_static_category_get();

    public static final native int state_changed_alert_type(long j, state_changed_alert state_changed_alertVar);

    public static final native String state_changed_alert_what(long j, state_changed_alert state_changed_alertVar);

    public static final native int state_not_recoverable_get();

    public static final native long state_update_alert_SWIGUpcast(long j);

    public static final native int state_update_alert_alert_type_get();

    public static final native long state_update_alert_category(long j, state_update_alert state_update_alertVar);

    public static final native String state_update_alert_message(long j, state_update_alert state_update_alertVar);

    public static final native int state_update_alert_priority_get();

    public static final native long state_update_alert_static_category_get();

    public static final native long state_update_alert_status_get(long j, state_update_alert state_update_alertVar);

    public static final native void state_update_alert_status_set(long j, state_update_alert state_update_alertVar, long j2, torrent_status_vector torrent_status_vectorVar);

    public static final native int state_update_alert_type(long j, state_update_alert state_update_alertVar);

    public static final native String state_update_alert_what(long j, state_update_alert state_update_alertVar);

    public static final native long stats_alert_SWIGUpcast(long j);

    public static final native int stats_alert_alert_type_get();

    public static final native long stats_alert_category(long j, stats_alert stats_alertVar);

    public static final native int stats_alert_download_ip_protocol_get();

    public static final native int stats_alert_get_transferred(long j, stats_alert stats_alertVar, int i);

    public static final native int stats_alert_interval_get(long j, stats_alert stats_alertVar);

    public static final native String stats_alert_message(long j, stats_alert stats_alertVar);

    public static final native int stats_alert_num_channels_get();

    public static final native int stats_alert_priority_get();

    public static final native long stats_alert_static_category_get();

    public static final native int stats_alert_type(long j, stats_alert stats_alertVar);

    public static final native String stats_alert_what(long j, stats_alert stats_alertVar);

    public static final native String stats_metric_get_name(long j, stats_metric stats_metricVar);

    public static final native int stats_metric_type_get(long j, stats_metric stats_metricVar);

    public static final native void stats_metric_type_set(long j, stats_metric stats_metricVar, int i);

    public static final native int stats_metric_value_index_get(long j, stats_metric stats_metricVar);

    public static final native void stats_metric_value_index_set(long j, stats_metric stats_metricVar, int i);

    public static final native long stats_metric_vector_capacity(long j, stats_metric_vector stats_metric_vectorVar);

    public static final native void stats_metric_vector_clear(long j, stats_metric_vector stats_metric_vectorVar);

    public static final native boolean stats_metric_vector_empty(long j, stats_metric_vector stats_metric_vectorVar);

    public static final native long stats_metric_vector_get(long j, stats_metric_vector stats_metric_vectorVar, int i);

    public static final native void stats_metric_vector_push_back(long j, stats_metric_vector stats_metric_vectorVar, long j2, stats_metric stats_metricVar);

    public static final native void stats_metric_vector_reserve(long j, stats_metric_vector stats_metric_vectorVar, long j2);

    public static final native void stats_metric_vector_set(long j, stats_metric_vector stats_metric_vectorVar, int i, long j2, stats_metric stats_metricVar);

    public static final native long stats_metric_vector_size(long j, stats_metric_vector stats_metric_vectorVar);

    public static final native long status_flags_t_all();

    public static final native long status_flags_t_and_(long j, status_flags_t status_flags_tVar, long j2, status_flags_t status_flags_tVar2);

    public static final native boolean status_flags_t_eq(long j, status_flags_t status_flags_tVar, long j2, status_flags_t status_flags_tVar2);

    public static final native long status_flags_t_inv(long j, status_flags_t status_flags_tVar);

    public static final native boolean status_flags_t_ne(long j, status_flags_t status_flags_tVar, long j2, status_flags_t status_flags_tVar2);

    public static final native boolean status_flags_t_nonZero(long j, status_flags_t status_flags_tVar);

    public static final native long status_flags_t_or_(long j, status_flags_t status_flags_tVar, long j2, status_flags_t status_flags_tVar2);

    public static final native int status_flags_t_to_int(long j, status_flags_t status_flags_tVar);

    public static final native long status_flags_t_xor(long j, status_flags_t status_flags_tVar, long j2, status_flags_t status_flags_tVar2);

    public static final native long stop_when_ready_get();

    public static final native long storage_moved_alert_SWIGUpcast(long j);

    public static final native int storage_moved_alert_alert_type_get();

    public static final native long storage_moved_alert_category(long j, storage_moved_alert storage_moved_alertVar);

    public static final native String storage_moved_alert_message(long j, storage_moved_alert storage_moved_alertVar);

    public static final native int storage_moved_alert_priority_get();

    public static final native long storage_moved_alert_static_category_get();

    public static final native String storage_moved_alert_storage_path(long j, storage_moved_alert storage_moved_alertVar);

    public static final native int storage_moved_alert_type(long j, storage_moved_alert storage_moved_alertVar);

    public static final native String storage_moved_alert_what(long j, storage_moved_alert storage_moved_alertVar);

    public static final native long storage_moved_failed_alert_SWIGUpcast(long j);

    public static final native int storage_moved_failed_alert_alert_type_get();

    public static final native long storage_moved_failed_alert_category(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native long storage_moved_failed_alert_error_get(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native String storage_moved_failed_alert_file_path(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native String storage_moved_failed_alert_message(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native int storage_moved_failed_alert_op_get(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native void storage_moved_failed_alert_op_set(long j, storage_moved_failed_alert storage_moved_failed_alertVar, int i);

    public static final native int storage_moved_failed_alert_priority_get();

    public static final native long storage_moved_failed_alert_static_category_get();

    public static final native int storage_moved_failed_alert_type(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native String storage_moved_failed_alert_what(long j, storage_moved_failed_alert storage_moved_failed_alertVar);

    public static final native int stream_timeout_get();

    public static final native void string_entry_map_clear(long j, string_entry_map string_entry_mapVar);

    public static final native boolean string_entry_map_empty(long j, string_entry_map string_entry_mapVar);

    public static final native void string_entry_map_erase(long j, string_entry_map string_entry_mapVar, String str);

    public static final native long string_entry_map_get(long j, string_entry_map string_entry_mapVar, String str);

    public static final native boolean string_entry_map_has_key(long j, string_entry_map string_entry_mapVar, String str);

    public static final native long string_entry_map_keys(long j, string_entry_map string_entry_mapVar);

    public static final native void string_entry_map_set(long j, string_entry_map string_entry_mapVar, String str, long j2, entry entryVar);

    public static final native long string_entry_map_size(long j, string_entry_map string_entry_mapVar);

    public static final native String string_int_pair_first_get(long j, string_int_pair string_int_pairVar);

    public static final native void string_int_pair_first_set(long j, string_int_pair string_int_pairVar, String str);

    public static final native int string_int_pair_second_get(long j, string_int_pair string_int_pairVar);

    public static final native void string_int_pair_second_set(long j, string_int_pair string_int_pairVar, int i);

    public static final native long string_int_pair_vector_capacity(long j, string_int_pair_vector string_int_pair_vectorVar);

    public static final native void string_int_pair_vector_clear(long j, string_int_pair_vector string_int_pair_vectorVar);

    public static final native boolean string_int_pair_vector_empty(long j, string_int_pair_vector string_int_pair_vectorVar);

    public static final native long string_int_pair_vector_get(long j, string_int_pair_vector string_int_pair_vectorVar, int i);

    public static final native void string_int_pair_vector_push_back(long j, string_int_pair_vector string_int_pair_vectorVar, long j2, string_int_pair string_int_pairVar);

    public static final native void string_int_pair_vector_reserve(long j, string_int_pair_vector string_int_pair_vectorVar, long j2);

    public static final native void string_int_pair_vector_set(long j, string_int_pair_vector string_int_pair_vectorVar, int i, long j2, string_int_pair string_int_pairVar);

    public static final native long string_int_pair_vector_size(long j, string_int_pair_vector string_int_pair_vectorVar);

    public static final native void string_long_map_clear(long j, string_long_map string_long_mapVar);

    public static final native boolean string_long_map_empty(long j, string_long_map string_long_mapVar);

    public static final native void string_long_map_erase(long j, string_long_map string_long_mapVar, String str);

    public static final native int string_long_map_get(long j, string_long_map string_long_mapVar, String str);

    public static final native boolean string_long_map_has_key(long j, string_long_map string_long_mapVar, String str);

    public static final native long string_long_map_keys(long j, string_long_map string_long_mapVar);

    public static final native void string_long_map_set(long j, string_long_map string_long_mapVar, String str, int i);

    public static final native long string_long_map_size(long j, string_long_map string_long_mapVar);

    public static final native String string_string_pair_first_get(long j, string_string_pair string_string_pairVar);

    public static final native void string_string_pair_first_set(long j, string_string_pair string_string_pairVar, String str);

    public static final native String string_string_pair_second_get(long j, string_string_pair string_string_pairVar);

    public static final native void string_string_pair_second_set(long j, string_string_pair string_string_pairVar, String str);

    public static final native long string_string_pair_vector_capacity(long j, string_string_pair_vector string_string_pair_vectorVar);

    public static final native void string_string_pair_vector_clear(long j, string_string_pair_vector string_string_pair_vectorVar);

    public static final native boolean string_string_pair_vector_empty(long j, string_string_pair_vector string_string_pair_vectorVar);

    public static final native long string_string_pair_vector_get(long j, string_string_pair_vector string_string_pair_vectorVar, int i);

    public static final native void string_string_pair_vector_push_back(long j, string_string_pair_vector string_string_pair_vectorVar, long j2, string_string_pair string_string_pairVar);

    public static final native void string_string_pair_vector_reserve(long j, string_string_pair_vector string_string_pair_vectorVar, long j2);

    public static final native void string_string_pair_vector_set(long j, string_string_pair_vector string_string_pair_vectorVar, int i, long j2, string_string_pair string_string_pairVar);

    public static final native long string_string_pair_vector_size(long j, string_string_pair_vector string_string_pair_vectorVar);

    public static final native long string_vector_capacity(long j, string_vector string_vectorVar);

    public static final native void string_vector_clear(long j, string_vector string_vectorVar);

    public static final native boolean string_vector_empty(long j, string_vector string_vectorVar);

    public static final native String string_vector_get(long j, string_vector string_vectorVar, int i);

    public static final native void string_vector_push_back(long j, string_vector string_vectorVar, String str);

    public static final native void string_vector_reserve(long j, string_vector string_vectorVar, long j2);

    public static final native void string_vector_set(long j, string_vector string_vectorVar, int i, String str);

    public static final native long string_vector_size(long j, string_vector string_vectorVar);

    public static final native long string_view_bdecode_node_pair_first_get(long j, string_view_bdecode_node_pair string_view_bdecode_node_pairVar);

    public static final native void string_view_bdecode_node_pair_first_set(long j, string_view_bdecode_node_pair string_view_bdecode_node_pairVar, long j2, string_view string_viewVar);

    public static final native long string_view_bdecode_node_pair_second_get(long j, string_view_bdecode_node_pair string_view_bdecode_node_pairVar);

    public static final native void string_view_bdecode_node_pair_second_set(long j, string_view_bdecode_node_pair string_view_bdecode_node_pairVar, long j2, bdecode_node bdecode_nodeVar);

    public static final native long string_view_to_bytes(long j, string_view string_viewVar);

    public static final native int success_get();

    public static final native long super_seeding_get();

    private static final native void swig_module_init();

    public static final native void swig_plugin_change_ownership(swig_plugin swig_pluginVar, long j, boolean z);

    public static final native void swig_plugin_director_connect(swig_plugin swig_pluginVar, long j, boolean z, boolean z2);

    public static final native boolean swig_plugin_on_dht_request(long j, swig_plugin swig_pluginVar, long j2, string_view string_viewVar, long j3, udp_endpoint udp_endpointVar, long j4, bdecode_node bdecode_nodeVar, long j5, entry entryVar);

    public static final native boolean swig_plugin_on_dht_requestSwigExplicitswig_plugin(long j, swig_plugin swig_pluginVar, long j2, string_view string_viewVar, long j3, udp_endpoint udp_endpointVar, long j4, bdecode_node bdecode_nodeVar, long j5, entry entryVar);

    public static final native long system_error_category_default_error_condition(long j, system_error_category system_error_categoryVar, int i);

    public static final native String system_error_category_message__SWIG_0(long j, system_error_category system_error_categoryVar, int i);

    public static final native String system_error_category_message__SWIG_1(long j, system_error_category system_error_categoryVar, int i, String str, long j2);

    public static final native String system_error_category_name(long j, system_error_category system_error_categoryVar);

    public static final native long tcp_endpoint_address(long j, tcp_endpoint tcp_endpointVar);

    public static final native int tcp_endpoint_port(long j, tcp_endpoint tcp_endpointVar);

    public static final native long tcp_endpoint_vector_capacity(long j, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native void tcp_endpoint_vector_clear(long j, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native boolean tcp_endpoint_vector_empty(long j, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native long tcp_endpoint_vector_get(long j, tcp_endpoint_vector tcp_endpoint_vectorVar, int i);

    public static final native void tcp_endpoint_vector_push_back(long j, tcp_endpoint_vector tcp_endpoint_vectorVar, long j2, tcp_endpoint tcp_endpointVar);

    public static final native void tcp_endpoint_vector_reserve(long j, tcp_endpoint_vector tcp_endpoint_vectorVar, long j2);

    public static final native void tcp_endpoint_vector_set(long j, tcp_endpoint_vector tcp_endpoint_vectorVar, int i, long j2, tcp_endpoint tcp_endpointVar);

    public static final native long tcp_endpoint_vector_size(long j, tcp_endpoint_vector tcp_endpoint_vectorVar);

    public static final native int text_file_busy_get();

    public static final native int timed_out_get();

    public static final native int too_many_files_open_get();

    public static final native int too_many_files_open_in_system_get();

    public static final native int too_many_links_get();

    public static final native int too_many_symbolic_link_levels_get();

    public static final native long torrent_alert_SWIGUpcast(long j);

    public static final native long torrent_alert_handle_get(long j, torrent_alert torrent_alertVar);

    public static final native void torrent_alert_handle_set(long j, torrent_alert torrent_alertVar, long j2, torrent_handle torrent_handleVar);

    public static final native String torrent_alert_message(long j, torrent_alert torrent_alertVar);

    public static final native String torrent_alert_torrent_name(long j, torrent_alert torrent_alertVar);

    public static final native long torrent_checked_alert_SWIGUpcast(long j);

    public static final native int torrent_checked_alert_alert_type_get();

    public static final native long torrent_checked_alert_category(long j, torrent_checked_alert torrent_checked_alertVar);

    public static final native String torrent_checked_alert_message(long j, torrent_checked_alert torrent_checked_alertVar);

    public static final native int torrent_checked_alert_priority_get();

    public static final native long torrent_checked_alert_static_category_get();

    public static final native int torrent_checked_alert_type(long j, torrent_checked_alert torrent_checked_alertVar);

    public static final native String torrent_checked_alert_what(long j, torrent_checked_alert torrent_checked_alertVar);

    public static final native long torrent_delete_failed_alert_SWIGUpcast(long j);

    public static final native int torrent_delete_failed_alert_alert_type_get();

    public static final native long torrent_delete_failed_alert_category(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native long torrent_delete_failed_alert_error_get(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native long torrent_delete_failed_alert_info_hash_get(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native void torrent_delete_failed_alert_info_hash_set(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String torrent_delete_failed_alert_message(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native int torrent_delete_failed_alert_priority_get();

    public static final native long torrent_delete_failed_alert_static_category_get();

    public static final native int torrent_delete_failed_alert_type(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native String torrent_delete_failed_alert_what(long j, torrent_delete_failed_alert torrent_delete_failed_alertVar);

    public static final native long torrent_deleted_alert_SWIGUpcast(long j);

    public static final native int torrent_deleted_alert_alert_type_get();

    public static final native long torrent_deleted_alert_category(long j, torrent_deleted_alert torrent_deleted_alertVar);

    public static final native long torrent_deleted_alert_info_hash_get(long j, torrent_deleted_alert torrent_deleted_alertVar);

    public static final native void torrent_deleted_alert_info_hash_set(long j, torrent_deleted_alert torrent_deleted_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String torrent_deleted_alert_message(long j, torrent_deleted_alert torrent_deleted_alertVar);

    public static final native int torrent_deleted_alert_priority_get();

    public static final native long torrent_deleted_alert_static_category_get();

    public static final native int torrent_deleted_alert_type(long j, torrent_deleted_alert torrent_deleted_alertVar);

    public static final native String torrent_deleted_alert_what(long j, torrent_deleted_alert torrent_deleted_alertVar);

    public static final native long torrent_error_alert_SWIGUpcast(long j);

    public static final native int torrent_error_alert_alert_type_get();

    public static final native long torrent_error_alert_category(long j, torrent_error_alert torrent_error_alertVar);

    public static final native long torrent_error_alert_error_get(long j, torrent_error_alert torrent_error_alertVar);

    public static final native String torrent_error_alert_filename(long j, torrent_error_alert torrent_error_alertVar);

    public static final native String torrent_error_alert_message(long j, torrent_error_alert torrent_error_alertVar);

    public static final native int torrent_error_alert_priority_get();

    public static final native long torrent_error_alert_static_category_get();

    public static final native int torrent_error_alert_type(long j, torrent_error_alert torrent_error_alertVar);

    public static final native String torrent_error_alert_what(long j, torrent_error_alert torrent_error_alertVar);

    public static final native long torrent_finished_alert_SWIGUpcast(long j);

    public static final native int torrent_finished_alert_alert_type_get();

    public static final native long torrent_finished_alert_category(long j, torrent_finished_alert torrent_finished_alertVar);

    public static final native String torrent_finished_alert_message(long j, torrent_finished_alert torrent_finished_alertVar);

    public static final native int torrent_finished_alert_priority_get();

    public static final native long torrent_finished_alert_static_category_get();

    public static final native int torrent_finished_alert_type(long j, torrent_finished_alert torrent_finished_alertVar);

    public static final native String torrent_finished_alert_what(long j, torrent_finished_alert torrent_finished_alertVar);

    public static final native long torrent_flags_t_all();

    public static final native long torrent_flags_t_and_(long j, torrent_flags_t torrent_flags_tVar, long j2, torrent_flags_t torrent_flags_tVar2);

    public static final native boolean torrent_flags_t_eq(long j, torrent_flags_t torrent_flags_tVar, long j2, torrent_flags_t torrent_flags_tVar2);

    public static final native long torrent_flags_t_inv(long j, torrent_flags_t torrent_flags_tVar);

    public static final native boolean torrent_flags_t_ne(long j, torrent_flags_t torrent_flags_tVar, long j2, torrent_flags_t torrent_flags_tVar2);

    public static final native boolean torrent_flags_t_nonZero(long j, torrent_flags_t torrent_flags_tVar);

    public static final native long torrent_flags_t_or_(long j, torrent_flags_t torrent_flags_tVar, long j2, torrent_flags_t torrent_flags_tVar2);

    public static final native int torrent_flags_t_to_int(long j, torrent_flags_t torrent_flags_tVar);

    public static final native long torrent_flags_t_xor(long j, torrent_flags_t torrent_flags_tVar, long j2, torrent_flags_t torrent_flags_tVar2);

    public static final native void torrent_handle_add_http_seed(long j, torrent_handle torrent_handleVar, String str);

    public static final native void torrent_handle_add_piece_bytes__SWIG_0(long j, torrent_handle torrent_handleVar, int i, long j2, byte_vector byte_vectorVar, long j3, add_piece_flags_t add_piece_flags_tVar);

    public static final native void torrent_handle_add_piece_bytes__SWIG_1(long j, torrent_handle torrent_handleVar, int i, long j2, byte_vector byte_vectorVar);

    public static final native void torrent_handle_add_tracker(long j, torrent_handle torrent_handleVar, long j2, announce_entry announce_entryVar);

    public static final native void torrent_handle_add_url_seed(long j, torrent_handle torrent_handleVar, String str);

    public static final native long torrent_handle_alert_when_available_get();

    public static final native long torrent_handle_clear_disk_cache_get();

    public static final native void torrent_handle_clear_error(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_clear_piece_deadlines(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_connect_peer__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, tcp_endpoint tcp_endpointVar, long j3, peer_source_flags_t peer_source_flags_tVar, long j4, pex_flags_t pex_flags_tVar);

    public static final native void torrent_handle_connect_peer__SWIG_1(long j, torrent_handle torrent_handleVar, long j2, tcp_endpoint tcp_endpointVar, long j3, peer_source_flags_t peer_source_flags_tVar);

    public static final native void torrent_handle_connect_peer__SWIG_2(long j, torrent_handle torrent_handleVar, long j2, tcp_endpoint tcp_endpointVar);

    public static final native int torrent_handle_download_limit(long j, torrent_handle torrent_handleVar);

    public static final native int torrent_handle_file_priority2__SWIG_0(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_file_priority2__SWIG_1(long j, torrent_handle torrent_handleVar, int i, int i2);

    public static final native void torrent_handle_file_progress__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, int64_vector int64_vectorVar, int i);

    public static final native void torrent_handle_file_progress__SWIG_1(long j, torrent_handle torrent_handleVar, long j2, int64_vector int64_vectorVar);

    public static final native long torrent_handle_flags(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_flush_cache(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_flush_disk_cache_get();

    public static final native void torrent_handle_force_dht_announce(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_force_reannounce__SWIG_0(long j, torrent_handle torrent_handleVar, int i, int i2, long j2, reannounce_flags_t reannounce_flags_tVar);

    public static final native void torrent_handle_force_reannounce__SWIG_1(long j, torrent_handle torrent_handleVar, int i, int i2);

    public static final native void torrent_handle_force_reannounce__SWIG_2(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_force_reannounce__SWIG_3(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_force_recheck(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_get_download_queue(long j, torrent_handle torrent_handleVar, long j2, partial_piece_info_vector partial_piece_info_vectorVar);

    public static final native long torrent_handle_get_file_priorities2(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_get_http_seeds(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_get_peer_info(long j, torrent_handle torrent_handleVar, long j2, peer_info_vector peer_info_vectorVar);

    public static final native long torrent_handle_get_piece_priorities2(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_get_url_seeds(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_graceful_pause_get();

    public static final native boolean torrent_handle_have_piece(long j, torrent_handle torrent_handleVar, int i);

    public static final native long torrent_handle_id(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_ignore_min_interval_get();

    public static final native long torrent_handle_info_hash(long j, torrent_handle torrent_handleVar);

    public static final native boolean torrent_handle_is_valid(long j, torrent_handle torrent_handleVar);

    public static final native int torrent_handle_max_connections(long j, torrent_handle torrent_handleVar);

    public static final native int torrent_handle_max_uploads(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_move_storage__SWIG_0(long j, torrent_handle torrent_handleVar, String str, int i);

    public static final native void torrent_handle_move_storage__SWIG_1(long j, torrent_handle torrent_handleVar, String str);

    public static final native boolean torrent_handle_need_save_resume_data(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_only_if_modified_get();

    public static final native boolean torrent_handle_op_eq(long j, torrent_handle torrent_handleVar, long j2, torrent_handle torrent_handleVar2);

    public static final native boolean torrent_handle_op_lt(long j, torrent_handle torrent_handleVar, long j2, torrent_handle torrent_handleVar2);

    public static final native boolean torrent_handle_op_ne(long j, torrent_handle torrent_handleVar, long j2, torrent_handle torrent_handleVar2);

    public static final native long torrent_handle_overwrite_existing_get();

    public static final native void torrent_handle_pause__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, pause_flags_t pause_flags_tVar);

    public static final native void torrent_handle_pause__SWIG_1(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_piece_availability(long j, torrent_handle torrent_handleVar, long j2, int_vector int_vectorVar);

    public static final native int torrent_handle_piece_granularity_get();

    public static final native int torrent_handle_piece_priority2__SWIG_0(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_piece_priority2__SWIG_1(long j, torrent_handle torrent_handleVar, int i, int i2);

    public static final native void torrent_handle_prioritize_files2(long j, torrent_handle torrent_handleVar, long j2, int_vector int_vectorVar);

    public static final native void torrent_handle_prioritize_pieces2__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, int_vector int_vectorVar);

    public static final native void torrent_handle_prioritize_pieces2__SWIG_1(long j, torrent_handle torrent_handleVar, long j2, piece_index_int_pair_vector piece_index_int_pair_vectorVar);

    public static final native long torrent_handle_query_accurate_download_counters_get();

    public static final native long torrent_handle_query_distributed_copies_get();

    public static final native long torrent_handle_query_last_seen_complete_get();

    public static final native long torrent_handle_query_name_get();

    public static final native long torrent_handle_query_pieces_get();

    public static final native long torrent_handle_query_save_path_get();

    public static final native long torrent_handle_query_torrent_file_get();

    public static final native long torrent_handle_query_verified_pieces_get();

    public static final native int torrent_handle_queue_position2(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_queue_position_bottom(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_queue_position_down(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_queue_position_set2(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_queue_position_top(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_queue_position_up(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_read_piece(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_remove_http_seed(long j, torrent_handle torrent_handleVar, String str);

    public static final native void torrent_handle_remove_url_seed(long j, torrent_handle torrent_handleVar, String str);

    public static final native void torrent_handle_rename_file(long j, torrent_handle torrent_handleVar, int i, String str);

    public static final native void torrent_handle_replace_trackers(long j, torrent_handle torrent_handleVar, long j2, announce_entry_vector announce_entry_vectorVar);

    public static final native void torrent_handle_reset_piece_deadline(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_resume(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_save_info_dict_get();

    public static final native void torrent_handle_save_resume_data__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, resume_data_flags_t resume_data_flags_tVar);

    public static final native void torrent_handle_save_resume_data__SWIG_1(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_scrape_tracker__SWIG_0(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_scrape_tracker__SWIG_1(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_set_download_limit(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_set_flags__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, torrent_flags_t torrent_flags_tVar, long j3, torrent_flags_t torrent_flags_tVar2);

    public static final native void torrent_handle_set_flags__SWIG_1(long j, torrent_handle torrent_handleVar, long j2, torrent_flags_t torrent_flags_tVar);

    public static final native void torrent_handle_set_max_connections(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_set_max_uploads(long j, torrent_handle torrent_handleVar, int i);

    public static final native void torrent_handle_set_piece_deadline__SWIG_0(long j, torrent_handle torrent_handleVar, int i, int i2, long j2, deadline_flags_t deadline_flags_tVar);

    public static final native void torrent_handle_set_piece_deadline__SWIG_1(long j, torrent_handle torrent_handleVar, int i, int i2);

    public static final native void torrent_handle_set_ssl_certificate__SWIG_0(long j, torrent_handle torrent_handleVar, String str, String str2, String str3, String str4);

    public static final native void torrent_handle_set_ssl_certificate__SWIG_1(long j, torrent_handle torrent_handleVar, String str, String str2, String str3);

    public static final native void torrent_handle_set_ssl_certificate_buffer2(long j, torrent_handle torrent_handleVar, long j2, byte_vector byte_vectorVar, long j3, byte_vector byte_vectorVar2, long j4, byte_vector byte_vectorVar3);

    public static final native void torrent_handle_set_upload_limit(long j, torrent_handle torrent_handleVar, int i);

    public static final native long torrent_handle_status__SWIG_0(long j, torrent_handle torrent_handleVar, long j2, status_flags_t status_flags_tVar);

    public static final native long torrent_handle_status__SWIG_1(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_torrent_file_ptr(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_trackers(long j, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_unset_flags(long j, torrent_handle torrent_handleVar, long j2, torrent_flags_t torrent_flags_tVar);

    public static final native int torrent_handle_upload_limit(long j, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_vector_capacity(long j, torrent_handle_vector torrent_handle_vectorVar);

    public static final native void torrent_handle_vector_clear(long j, torrent_handle_vector torrent_handle_vectorVar);

    public static final native boolean torrent_handle_vector_empty(long j, torrent_handle_vector torrent_handle_vectorVar);

    public static final native long torrent_handle_vector_get(long j, torrent_handle_vector torrent_handle_vectorVar, int i);

    public static final native void torrent_handle_vector_push_back(long j, torrent_handle_vector torrent_handle_vectorVar, long j2, torrent_handle torrent_handleVar);

    public static final native void torrent_handle_vector_reserve(long j, torrent_handle_vector torrent_handle_vectorVar, long j2);

    public static final native void torrent_handle_vector_set(long j, torrent_handle_vector torrent_handle_vectorVar, int i, long j2, torrent_handle torrent_handleVar);

    public static final native long torrent_handle_vector_size(long j, torrent_handle_vector torrent_handle_vectorVar);

    public static final native void torrent_info_add_http_seed__SWIG_0(long j, torrent_info torrent_infoVar, String str, String str2, long j2, string_string_pair_vector string_string_pair_vectorVar);

    public static final native void torrent_info_add_http_seed__SWIG_1(long j, torrent_info torrent_infoVar, String str, String str2);

    public static final native void torrent_info_add_http_seed__SWIG_2(long j, torrent_info torrent_infoVar, String str);

    public static final native void torrent_info_add_node(long j, torrent_info torrent_infoVar, long j2, string_int_pair string_int_pairVar);

    public static final native void torrent_info_add_tracker__SWIG_0(long j, torrent_info torrent_infoVar, String str, int i);

    public static final native void torrent_info_add_tracker__SWIG_1(long j, torrent_info torrent_infoVar, String str);

    public static final native void torrent_info_add_tracker__SWIG_2(long j, torrent_info torrent_infoVar, String str, int i, int i2);

    public static final native void torrent_info_add_url_seed__SWIG_0(long j, torrent_info torrent_infoVar, String str, String str2, long j2, string_string_pair_vector string_string_pair_vectorVar);

    public static final native void torrent_info_add_url_seed__SWIG_1(long j, torrent_info torrent_infoVar, String str, String str2);

    public static final native void torrent_info_add_url_seed__SWIG_2(long j, torrent_info torrent_infoVar, String str);

    public static final native long torrent_info_collections(long j, torrent_info torrent_infoVar);

    public static final native String torrent_info_comment(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_creation_date(long j, torrent_info torrent_infoVar);

    public static final native String torrent_info_creator(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_end_piece(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_files(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_hash_for_piece(long j, torrent_info torrent_infoVar, int i);

    public static final native long torrent_info_info(long j, torrent_info torrent_infoVar, String str);

    public static final native long torrent_info_info_hash(long j, torrent_info torrent_infoVar);

    public static final native boolean torrent_info_is_i2p(long j, torrent_info torrent_infoVar);

    public static final native boolean torrent_info_is_loaded(long j, torrent_info torrent_infoVar);

    public static final native boolean torrent_info_is_merkle_torrent(long j, torrent_info torrent_infoVar);

    public static final native boolean torrent_info_is_valid(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_last_piece(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_map_block(long j, torrent_info torrent_infoVar, int i, long j2, int i2);

    public static final native long torrent_info_map_file(long j, torrent_info torrent_infoVar, int i, long j2, int i2);

    public static final native long torrent_info_merkle_tree(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_metadata_size(long j, torrent_info torrent_infoVar);

    public static final native String torrent_info_name(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_nodes(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_num_files(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_num_pieces(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_orig_files(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_piece_length(long j, torrent_info torrent_infoVar);

    public static final native int torrent_info_piece_size(long j, torrent_info torrent_infoVar, int i);

    public static final native boolean torrent_info_priv(long j, torrent_info torrent_infoVar);

    public static final native void torrent_info_remap_files(long j, torrent_info torrent_infoVar, long j2, file_storage file_storageVar);

    public static final native void torrent_info_rename_file(long j, torrent_info torrent_infoVar, int i, String str);

    public static final native void torrent_info_set_merkle_tree(long j, torrent_info torrent_infoVar, long j2, sha1_hash_vector sha1_hash_vectorVar);

    public static final native void torrent_info_set_web_seeds(long j, torrent_info torrent_infoVar, long j2, web_seed_entry_vector web_seed_entry_vectorVar);

    public static final native long torrent_info_similar_torrents(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_ssl_cert(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_total_size(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_trackers(long j, torrent_info torrent_infoVar);

    public static final native long torrent_info_web_seeds(long j, torrent_info torrent_infoVar);

    public static final native long torrent_log_alert_SWIGUpcast(long j);

    public static final native int torrent_log_alert_alert_type_get();

    public static final native long torrent_log_alert_category(long j, torrent_log_alert torrent_log_alertVar);

    public static final native String torrent_log_alert_log_message(long j, torrent_log_alert torrent_log_alertVar);

    public static final native String torrent_log_alert_message(long j, torrent_log_alert torrent_log_alertVar);

    public static final native int torrent_log_alert_priority_get();

    public static final native long torrent_log_alert_static_category_get();

    public static final native int torrent_log_alert_type(long j, torrent_log_alert torrent_log_alertVar);

    public static final native String torrent_log_alert_what(long j, torrent_log_alert torrent_log_alertVar);

    public static final native long torrent_need_cert_alert_SWIGUpcast(long j);

    public static final native int torrent_need_cert_alert_alert_type_get();

    public static final native long torrent_need_cert_alert_category(long j, torrent_need_cert_alert torrent_need_cert_alertVar);

    public static final native String torrent_need_cert_alert_message(long j, torrent_need_cert_alert torrent_need_cert_alertVar);

    public static final native int torrent_need_cert_alert_priority_get();

    public static final native long torrent_need_cert_alert_static_category_get();

    public static final native int torrent_need_cert_alert_type(long j, torrent_need_cert_alert torrent_need_cert_alertVar);

    public static final native String torrent_need_cert_alert_what(long j, torrent_need_cert_alert torrent_need_cert_alertVar);

    public static final native long torrent_paused_alert_SWIGUpcast(long j);

    public static final native int torrent_paused_alert_alert_type_get();

    public static final native long torrent_paused_alert_category(long j, torrent_paused_alert torrent_paused_alertVar);

    public static final native String torrent_paused_alert_message(long j, torrent_paused_alert torrent_paused_alertVar);

    public static final native int torrent_paused_alert_priority_get();

    public static final native long torrent_paused_alert_static_category_get();

    public static final native int torrent_paused_alert_type(long j, torrent_paused_alert torrent_paused_alertVar);

    public static final native String torrent_paused_alert_what(long j, torrent_paused_alert torrent_paused_alertVar);

    public static final native long torrent_removed_alert_SWIGUpcast(long j);

    public static final native int torrent_removed_alert_alert_type_get();

    public static final native long torrent_removed_alert_category(long j, torrent_removed_alert torrent_removed_alertVar);

    public static final native long torrent_removed_alert_info_hash_get(long j, torrent_removed_alert torrent_removed_alertVar);

    public static final native void torrent_removed_alert_info_hash_set(long j, torrent_removed_alert torrent_removed_alertVar, long j2, sha1_hash sha1_hashVar);

    public static final native String torrent_removed_alert_message(long j, torrent_removed_alert torrent_removed_alertVar);

    public static final native int torrent_removed_alert_priority_get();

    public static final native long torrent_removed_alert_static_category_get();

    public static final native int torrent_removed_alert_type(long j, torrent_removed_alert torrent_removed_alertVar);

    public static final native String torrent_removed_alert_what(long j, torrent_removed_alert torrent_removed_alertVar);

    public static final native long torrent_resumed_alert_SWIGUpcast(long j);

    public static final native int torrent_resumed_alert_alert_type_get();

    public static final native long torrent_resumed_alert_category(long j, torrent_resumed_alert torrent_resumed_alertVar);

    public static final native String torrent_resumed_alert_message(long j, torrent_resumed_alert torrent_resumed_alertVar);

    public static final native int torrent_resumed_alert_priority_get();

    public static final native long torrent_resumed_alert_static_category_get();

    public static final native int torrent_resumed_alert_type(long j, torrent_resumed_alert torrent_resumed_alertVar);

    public static final native String torrent_resumed_alert_what(long j, torrent_resumed_alert torrent_resumed_alertVar);

    public static final native long torrent_status_added_time_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_added_time_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_all_time_download_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_all_time_download_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_all_time_upload_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_all_time_upload_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native boolean torrent_status_announcing_to_dht_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_announcing_to_dht_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native boolean torrent_status_announcing_to_lsd_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_announcing_to_lsd_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native boolean torrent_status_announcing_to_trackers_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_announcing_to_trackers_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native int torrent_status_block_size_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_block_size_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_checking_files_get();

    public static final native long torrent_status_completed_time_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_completed_time_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native int torrent_status_connect_candidates_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_connect_candidates_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_connections_limit_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_connections_limit_set(long j, torrent_status torrent_statusVar, int i);

    public static final native String torrent_status_current_tracker_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_current_tracker_set(long j, torrent_status torrent_statusVar, String str);

    public static final native float torrent_status_distributed_copies_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_distributed_copies_set(long j, torrent_status torrent_statusVar, float f);

    public static final native int torrent_status_distributed_fraction_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_distributed_fraction_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_distributed_full_copies_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_distributed_full_copies_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_down_bandwidth_queue_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_down_bandwidth_queue_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_download_payload_rate_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_download_payload_rate_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_download_rate_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_download_rate_set(long j, torrent_status torrent_statusVar, int i);

    public static final native long torrent_status_errc_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_errc_set(long j, torrent_status torrent_statusVar, long j2, error_code error_codeVar);

    public static final native int torrent_status_error_file_exception_get();

    public static final native int torrent_status_error_file_get(long j, torrent_status torrent_statusVar);

    public static final native int torrent_status_error_file_metadata_get();

    public static final native int torrent_status_error_file_none_get();

    public static final native int torrent_status_error_file_partfile_get();

    public static final native void torrent_status_error_file_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_error_file_ssl_ctx_get();

    public static final native long torrent_status_flags_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_flags_set(long j, torrent_status torrent_statusVar, long j2, torrent_flags_t torrent_flags_tVar);

    public static final native long torrent_status_get_active_duration(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_get_finished_duration(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_get_last_download(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_get_last_upload(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_get_next_announce(long j, torrent_status torrent_statusVar);

    public static final native int torrent_status_get_queue_position(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_get_seeding_duration(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_handle_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_handle_set(long j, torrent_status torrent_statusVar, long j2, torrent_handle torrent_handleVar);

    public static final native boolean torrent_status_has_incoming_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_has_incoming_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native boolean torrent_status_has_metadata_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_has_metadata_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native long torrent_status_info_hash_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_info_hash_set(long j, torrent_status torrent_statusVar, long j2, sha1_hash sha1_hashVar);

    public static final native boolean torrent_status_is_finished_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_is_finished_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native boolean torrent_status_is_seeding_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_is_seeding_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native long torrent_status_last_seen_complete_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_last_seen_complete_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native int torrent_status_list_peers_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_list_peers_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_list_seeds_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_list_seeds_set(long j, torrent_status torrent_statusVar, int i);

    public static final native boolean torrent_status_moving_storage_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_moving_storage_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native String torrent_status_name_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_name_set(long j, torrent_status torrent_statusVar, String str);

    public static final native boolean torrent_status_need_save_resume_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_need_save_resume_set(long j, torrent_status torrent_statusVar, boolean z);

    public static final native int torrent_status_num_complete_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_complete_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_connections_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_connections_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_incomplete_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_incomplete_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_peers_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_peers_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_pieces_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_pieces_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_seeds_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_seeds_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_num_uploads_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_num_uploads_set(long j, torrent_status torrent_statusVar, int i);

    public static final native boolean torrent_status_op_eq(long j, torrent_status torrent_statusVar, long j2, torrent_status torrent_statusVar2);

    public static final native long torrent_status_pieces_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_pieces_set(long j, torrent_status torrent_statusVar, long j2, piece_index_bitfield piece_index_bitfieldVar);

    public static final native float torrent_status_progress_get(long j, torrent_status torrent_statusVar);

    public static final native int torrent_status_progress_ppm_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_progress_ppm_set(long j, torrent_status torrent_statusVar, int i);

    public static final native void torrent_status_progress_set(long j, torrent_status torrent_statusVar, float f);

    public static final native String torrent_status_save_path_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_save_path_set(long j, torrent_status torrent_statusVar, String str);

    public static final native int torrent_status_seed_rank_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_seed_rank_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_state_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_state_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_storage_mode_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_storage_mode_set(long j, torrent_status torrent_statusVar, int i);

    public static final native long torrent_status_torrent_file_ptr(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_total_done_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_done_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_download_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_download_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_failed_bytes_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_failed_bytes_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_get(long j, torrent_status torrent_statusVar);

    public static final native long torrent_status_total_payload_download_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_payload_download_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_payload_upload_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_payload_upload_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_redundant_bytes_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_redundant_bytes_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native void torrent_status_total_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_upload_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_upload_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_wanted_done_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_wanted_done_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native long torrent_status_total_wanted_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_total_wanted_set(long j, torrent_status torrent_statusVar, long j2);

    public static final native int torrent_status_up_bandwidth_queue_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_up_bandwidth_queue_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_upload_payload_rate_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_upload_payload_rate_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_upload_rate_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_upload_rate_set(long j, torrent_status torrent_statusVar, int i);

    public static final native int torrent_status_uploads_limit_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_uploads_limit_set(long j, torrent_status torrent_statusVar, int i);

    public static final native long torrent_status_vector_capacity(long j, torrent_status_vector torrent_status_vectorVar);

    public static final native void torrent_status_vector_clear(long j, torrent_status_vector torrent_status_vectorVar);

    public static final native boolean torrent_status_vector_empty(long j, torrent_status_vector torrent_status_vectorVar);

    public static final native long torrent_status_vector_get(long j, torrent_status_vector torrent_status_vectorVar, int i);

    public static final native void torrent_status_vector_push_back(long j, torrent_status_vector torrent_status_vectorVar, long j2, torrent_status torrent_statusVar);

    public static final native void torrent_status_vector_reserve(long j, torrent_status_vector torrent_status_vectorVar, long j2);

    public static final native void torrent_status_vector_set(long j, torrent_status_vector torrent_status_vectorVar, int i, long j2, torrent_status torrent_statusVar);

    public static final native long torrent_status_vector_size(long j, torrent_status_vector torrent_status_vectorVar);

    public static final native long torrent_status_verified_pieces_get(long j, torrent_status torrent_statusVar);

    public static final native void torrent_status_verified_pieces_set(long j, torrent_status torrent_statusVar, long j2, piece_index_bitfield piece_index_bitfieldVar);

    public static final native long tracker_alert_SWIGUpcast(long j);

    public static final native long tracker_alert_get_local_endpoint(long j, tracker_alert tracker_alertVar);

    public static final native String tracker_alert_message(long j, tracker_alert tracker_alertVar);

    public static final native String tracker_alert_tracker_url(long j, tracker_alert tracker_alertVar);

    public static final native long tracker_announce_alert_SWIGUpcast(long j);

    public static final native int tracker_announce_alert_alert_type_get();

    public static final native long tracker_announce_alert_category(long j, tracker_announce_alert tracker_announce_alertVar);

    public static final native int tracker_announce_alert_event_get(long j, tracker_announce_alert tracker_announce_alertVar);

    public static final native String tracker_announce_alert_message(long j, tracker_announce_alert tracker_announce_alertVar);

    public static final native int tracker_announce_alert_priority_get();

    public static final native long tracker_announce_alert_static_category_get();

    public static final native int tracker_announce_alert_type(long j, tracker_announce_alert tracker_announce_alertVar);

    public static final native String tracker_announce_alert_what(long j, tracker_announce_alert tracker_announce_alertVar);

    public static final native long tracker_error_alert_SWIGUpcast(long j);

    public static final native int tracker_error_alert_alert_type_get();

    public static final native long tracker_error_alert_category(long j, tracker_error_alert tracker_error_alertVar);

    public static final native long tracker_error_alert_error_get(long j, tracker_error_alert tracker_error_alertVar);

    public static final native String tracker_error_alert_error_message(long j, tracker_error_alert tracker_error_alertVar);

    public static final native String tracker_error_alert_message(long j, tracker_error_alert tracker_error_alertVar);

    public static final native int tracker_error_alert_priority_get();

    public static final native long tracker_error_alert_static_category_get();

    public static final native int tracker_error_alert_times_in_row_get(long j, tracker_error_alert tracker_error_alertVar);

    public static final native int tracker_error_alert_type(long j, tracker_error_alert tracker_error_alertVar);

    public static final native String tracker_error_alert_what(long j, tracker_error_alert tracker_error_alertVar);

    public static final native long tracker_reply_alert_SWIGUpcast(long j);

    public static final native int tracker_reply_alert_alert_type_get();

    public static final native long tracker_reply_alert_category(long j, tracker_reply_alert tracker_reply_alertVar);

    public static final native String tracker_reply_alert_message(long j, tracker_reply_alert tracker_reply_alertVar);

    public static final native int tracker_reply_alert_num_peers_get(long j, tracker_reply_alert tracker_reply_alertVar);

    public static final native int tracker_reply_alert_priority_get();

    public static final native long tracker_reply_alert_static_category_get();

    public static final native int tracker_reply_alert_type(long j, tracker_reply_alert tracker_reply_alertVar);

    public static final native String tracker_reply_alert_what(long j, tracker_reply_alert tracker_reply_alertVar);

    public static final native long tracker_warning_alert_SWIGUpcast(long j);

    public static final native int tracker_warning_alert_alert_type_get();

    public static final native long tracker_warning_alert_category(long j, tracker_warning_alert tracker_warning_alertVar);

    public static final native String tracker_warning_alert_message(long j, tracker_warning_alert tracker_warning_alertVar);

    public static final native int tracker_warning_alert_priority_get();

    public static final native long tracker_warning_alert_static_category_get();

    public static final native int tracker_warning_alert_type(long j, tracker_warning_alert tracker_warning_alertVar);

    public static final native String tracker_warning_alert_warning_message(long j, tracker_warning_alert tracker_warning_alertVar);

    public static final native String tracker_warning_alert_what(long j, tracker_warning_alert tracker_warning_alertVar);

    public static final native long trackerid_alert_SWIGUpcast(long j);

    public static final native int trackerid_alert_alert_type_get();

    public static final native long trackerid_alert_category(long j, trackerid_alert trackerid_alertVar);

    public static final native String trackerid_alert_message(long j, trackerid_alert trackerid_alertVar);

    public static final native int trackerid_alert_priority_get();

    public static final native long trackerid_alert_static_category_get();

    public static final native String trackerid_alert_tracker_id(long j, trackerid_alert trackerid_alertVar);

    public static final native int trackerid_alert_type(long j, trackerid_alert trackerid_alertVar);

    public static final native String trackerid_alert_what(long j, trackerid_alert trackerid_alertVar);

    public static final native long udp_endpoint_address(long j, udp_endpoint udp_endpointVar);

    public static final native int udp_endpoint_port(long j, udp_endpoint udp_endpointVar);

    public static final native long udp_endpoint_vector_capacity(long j, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native void udp_endpoint_vector_clear(long j, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native boolean udp_endpoint_vector_empty(long j, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native long udp_endpoint_vector_get(long j, udp_endpoint_vector udp_endpoint_vectorVar, int i);

    public static final native void udp_endpoint_vector_push_back(long j, udp_endpoint_vector udp_endpoint_vectorVar, long j2, udp_endpoint udp_endpointVar);

    public static final native void udp_endpoint_vector_reserve(long j, udp_endpoint_vector udp_endpoint_vectorVar, long j2);

    public static final native void udp_endpoint_vector_set(long j, udp_endpoint_vector udp_endpoint_vectorVar, int i, long j2, udp_endpoint udp_endpointVar);

    public static final native long udp_endpoint_vector_size(long j, udp_endpoint_vector udp_endpoint_vectorVar);

    public static final native long udp_error_alert_SWIGUpcast(long j);

    public static final native int udp_error_alert_alert_type_get();

    public static final native long udp_error_alert_category(long j, udp_error_alert udp_error_alertVar);

    public static final native long udp_error_alert_error_get(long j, udp_error_alert udp_error_alertVar);

    public static final native long udp_error_alert_get_endpoint(long j, udp_error_alert udp_error_alertVar);

    public static final native String udp_error_alert_message(long j, udp_error_alert udp_error_alertVar);

    public static final native int udp_error_alert_operation_get(long j, udp_error_alert udp_error_alertVar);

    public static final native void udp_error_alert_operation_set(long j, udp_error_alert udp_error_alertVar, int i);

    public static final native int udp_error_alert_priority_get();

    public static final native long udp_error_alert_static_category_get();

    public static final native int udp_error_alert_type(long j, udp_error_alert udp_error_alertVar);

    public static final native String udp_error_alert_what(long j, udp_error_alert udp_error_alertVar);

    public static final native int unauthorized_get();

    public static final native long unwanted_block_alert_SWIGUpcast(long j);

    public static final native int unwanted_block_alert_alert_type_get();

    public static final native int unwanted_block_alert_block_index_get(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native long unwanted_block_alert_category(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native String unwanted_block_alert_message(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native int unwanted_block_alert_piece_index_get(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native int unwanted_block_alert_priority_get();

    public static final native long unwanted_block_alert_static_category_get();

    public static final native int unwanted_block_alert_type(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native String unwanted_block_alert_what(long j, unwanted_block_alert unwanted_block_alertVar);

    public static final native long update_subscribe_get();

    public static final native long upload_mode_get();

    public static final native long url_seed_alert_SWIGUpcast(long j);

    public static final native int url_seed_alert_alert_type_get();

    public static final native long url_seed_alert_category(long j, url_seed_alert url_seed_alertVar);

    public static final native long url_seed_alert_error_get(long j, url_seed_alert url_seed_alertVar);

    public static final native String url_seed_alert_error_message(long j, url_seed_alert url_seed_alertVar);

    public static final native String url_seed_alert_message(long j, url_seed_alert url_seed_alertVar);

    public static final native int url_seed_alert_priority_get();

    public static final native String url_seed_alert_server_url(long j, url_seed_alert url_seed_alertVar);

    public static final native long url_seed_alert_static_category_get();

    public static final native int url_seed_alert_type(long j, url_seed_alert url_seed_alertVar);

    public static final native String url_seed_alert_what(long j, url_seed_alert url_seed_alertVar);

    public static final native int value_too_large_get();

    public static final native String version();

    public static final native String web_seed_entry_auth_get(long j, web_seed_entry web_seed_entryVar);

    public static final native void web_seed_entry_auth_set(long j, web_seed_entry web_seed_entryVar, String str);

    public static final native long web_seed_entry_extra_headers_get(long j, web_seed_entry web_seed_entryVar);

    public static final native void web_seed_entry_extra_headers_set(long j, web_seed_entry web_seed_entryVar, long j2, string_string_pair_vector string_string_pair_vectorVar);

    public static final native boolean web_seed_entry_op_eq(long j, web_seed_entry web_seed_entryVar, long j2, web_seed_entry web_seed_entryVar2);

    public static final native boolean web_seed_entry_op_lt(long j, web_seed_entry web_seed_entryVar, long j2, web_seed_entry web_seed_entryVar2);

    public static final native short web_seed_entry_type_get(long j, web_seed_entry web_seed_entryVar);

    public static final native void web_seed_entry_type_set(long j, web_seed_entry web_seed_entryVar, short s);

    public static final native String web_seed_entry_url_get(long j, web_seed_entry web_seed_entryVar);

    public static final native void web_seed_entry_url_set(long j, web_seed_entry web_seed_entryVar, String str);

    public static final native long web_seed_entry_vector_capacity(long j, web_seed_entry_vector web_seed_entry_vectorVar);

    public static final native void web_seed_entry_vector_clear(long j, web_seed_entry_vector web_seed_entry_vectorVar);

    public static final native boolean web_seed_entry_vector_empty(long j, web_seed_entry_vector web_seed_entry_vectorVar);

    public static final native long web_seed_entry_vector_get(long j, web_seed_entry_vector web_seed_entry_vectorVar, int i);

    public static final native void web_seed_entry_vector_push_back(long j, web_seed_entry_vector web_seed_entry_vectorVar, long j2, web_seed_entry web_seed_entryVar);

    public static final native void web_seed_entry_vector_reserve(long j, web_seed_entry_vector web_seed_entry_vectorVar, long j2);

    public static final native void web_seed_entry_vector_set(long j, web_seed_entry_vector web_seed_entry_vectorVar, int i, long j2, web_seed_entry web_seed_entryVar);

    public static final native long web_seed_entry_vector_size(long j, web_seed_entry_vector web_seed_entry_vectorVar);

    public static final native int wrong_protocol_type_get();

    static {
        try {
            String property = System.getProperty("jlibtorrent.jni.path", "");
            if ("".equals(property)) {
                try {
                    System.loadLibrary("jlibtorrent-" + jlibtorrentVersion());
                } catch (LinkageError unused) {
                    System.loadLibrary("jlibtorrent");
                }
            } else {
                System.load(property);
            }
            swig_module_init();
        } catch (LinkageError e) {
            throw new LinkageError("Look for your architecture binary instructions at: https://github.com/frostwire/frostwire-jlibtorrent", e);
        }
    }

    public static void SwigDirector_alert_notify_callback_on_alert(alert_notify_callback alert_notify_callbackVar) {
        alert_notify_callbackVar.on_alert();
    }

    public static boolean SwigDirector_add_files_listener_pred(add_files_listener add_files_listenerVar, String str) {
        return add_files_listenerVar.pred(str);
    }

    public static void SwigDirector_set_piece_hashes_listener_progress(set_piece_hashes_listener set_piece_hashes_listenerVar, int i) {
        set_piece_hashes_listenerVar.progress(i);
    }

    public static boolean SwigDirector_swig_plugin_on_dht_request(swig_plugin swig_pluginVar, long j, long j2, long j3, long j4) {
        return swig_pluginVar.on_dht_request(new string_view(j, true), new udp_endpoint(j2, false), new bdecode_node(j3, false), new entry(j4, false));
    }

    public static int SwigDirector_posix_wrapper_open(posix_wrapper posix_wrapperVar, String str, int i, int i2) {
        return posix_wrapperVar.open(str, i, i2);
    }

    public static int SwigDirector_posix_wrapper_stat(posix_wrapper posix_wrapperVar, String str, long j) {
        return posix_wrapperVar.stat(str, j == 0 ? null : new posix_stat_t(j, false));
    }

    public static int SwigDirector_posix_wrapper_mkdir(posix_wrapper posix_wrapperVar, String str, int i) {
        return posix_wrapperVar.mkdir(str, i);
    }

    public static int SwigDirector_posix_wrapper_rename(posix_wrapper posix_wrapperVar, String str, String str2) {
        return posix_wrapperVar.rename(str, str2);
    }

    public static int SwigDirector_posix_wrapper_remove(posix_wrapper posix_wrapperVar, String str) {
        return posix_wrapperVar.remove(str);
    }
}
