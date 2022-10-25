package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class libtorrent implements libtorrentConstants {
    public static boolean failed_impl(int i, SWIGTYPE_p_boost__system__error_category sWIGTYPE_p_boost__system__error_category) {
        return libtorrent_jni.failed_impl(i, SWIGTYPE_p_boost__system__error_category.getCPtr(sWIGTYPE_p_boost__system__error_category));
    }

    public static boolean op_eq(error_code error_codeVar, error_code error_codeVar2) {
        return libtorrent_jni.op_eq__SWIG_1(error_code.getCPtr(error_codeVar), error_codeVar, error_code.getCPtr(error_codeVar2), error_codeVar2);
    }

    public static boolean op_lt(error_code error_codeVar, error_code error_codeVar2) {
        return libtorrent_jni.op_lt__SWIG_1(error_code.getCPtr(error_codeVar), error_codeVar, error_code.getCPtr(error_codeVar2), error_codeVar2);
    }

    public static boolean op_ne(error_code error_codeVar, error_code error_codeVar2) {
        return libtorrent_jni.op_ne(error_code.getCPtr(error_codeVar), error_codeVar, error_code.getCPtr(error_codeVar2), error_codeVar2);
    }

    public static error_code make_error_code(errc_t errc_tVar) {
        return new error_code(libtorrent_jni.make_error_code(errc_tVar.swigValue()), true);
    }

    public static String version() {
        return libtorrent_jni.version();
    }

    public static String print_error(error_code error_codeVar) {
        return libtorrent_jni.print_error(error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public static torrent_flags_t getSeed_mode() {
        long seed_mode_get = libtorrent_jni.seed_mode_get();
        if (seed_mode_get == 0) {
            return null;
        }
        return new torrent_flags_t(seed_mode_get, false);
    }

    public static torrent_flags_t getUpload_mode() {
        long upload_mode_get = libtorrent_jni.upload_mode_get();
        if (upload_mode_get == 0) {
            return null;
        }
        return new torrent_flags_t(upload_mode_get, false);
    }

    public static torrent_flags_t getShare_mode() {
        long share_mode_get = libtorrent_jni.share_mode_get();
        if (share_mode_get == 0) {
            return null;
        }
        return new torrent_flags_t(share_mode_get, false);
    }

    public static torrent_flags_t getApply_ip_filter() {
        long apply_ip_filter_get = libtorrent_jni.apply_ip_filter_get();
        if (apply_ip_filter_get == 0) {
            return null;
        }
        return new torrent_flags_t(apply_ip_filter_get, false);
    }

    public static torrent_flags_t getPaused() {
        long paused_get = libtorrent_jni.paused_get();
        if (paused_get == 0) {
            return null;
        }
        return new torrent_flags_t(paused_get, false);
    }

    public static torrent_flags_t getAuto_managed() {
        long auto_managed_get = libtorrent_jni.auto_managed_get();
        if (auto_managed_get == 0) {
            return null;
        }
        return new torrent_flags_t(auto_managed_get, false);
    }

    public static torrent_flags_t getDuplicate_is_error() {
        long duplicate_is_error_get = libtorrent_jni.duplicate_is_error_get();
        if (duplicate_is_error_get == 0) {
            return null;
        }
        return new torrent_flags_t(duplicate_is_error_get, false);
    }

    public static torrent_flags_t getUpdate_subscribe() {
        long update_subscribe_get = libtorrent_jni.update_subscribe_get();
        if (update_subscribe_get == 0) {
            return null;
        }
        return new torrent_flags_t(update_subscribe_get, false);
    }

    public static torrent_flags_t getSuper_seeding() {
        long super_seeding_get = libtorrent_jni.super_seeding_get();
        if (super_seeding_get == 0) {
            return null;
        }
        return new torrent_flags_t(super_seeding_get, false);
    }

    public static torrent_flags_t getSequential_download() {
        long sequential_download_get = libtorrent_jni.sequential_download_get();
        if (sequential_download_get == 0) {
            return null;
        }
        return new torrent_flags_t(sequential_download_get, false);
    }

    public static torrent_flags_t getStop_when_ready() {
        long stop_when_ready_get = libtorrent_jni.stop_when_ready_get();
        if (stop_when_ready_get == 0) {
            return null;
        }
        return new torrent_flags_t(stop_when_ready_get, false);
    }

    public static torrent_flags_t getOverride_trackers() {
        long override_trackers_get = libtorrent_jni.override_trackers_get();
        if (override_trackers_get == 0) {
            return null;
        }
        return new torrent_flags_t(override_trackers_get, false);
    }

    public static torrent_flags_t getOverride_web_seeds() {
        long override_web_seeds_get = libtorrent_jni.override_web_seeds_get();
        if (override_web_seeds_get == 0) {
            return null;
        }
        return new torrent_flags_t(override_web_seeds_get, false);
    }

    public static torrent_flags_t getNeed_save_resume() {
        long need_save_resume_get = libtorrent_jni.need_save_resume_get();
        if (need_save_resume_get == 0) {
            return null;
        }
        return new torrent_flags_t(need_save_resume_get, false);
    }

    public static torrent_flags_t getDisable_dht() {
        long disable_dht_get = libtorrent_jni.disable_dht_get();
        if (disable_dht_get == 0) {
            return null;
        }
        return new torrent_flags_t(disable_dht_get, false);
    }

    public static torrent_flags_t getDisable_lsd() {
        long disable_lsd_get = libtorrent_jni.disable_lsd_get();
        if (disable_lsd_get == 0) {
            return null;
        }
        return new torrent_flags_t(disable_lsd_get, false);
    }

    public static torrent_flags_t getDisable_pex() {
        long disable_pex_get = libtorrent_jni.disable_pex_get();
        if (disable_pex_get == 0) {
            return null;
        }
        return new torrent_flags_t(disable_pex_get, false);
    }

    public static torrent_flags_t getAll() {
        long all_get = libtorrent_jni.all_get();
        if (all_get == 0) {
            return null;
        }
        return new torrent_flags_t(all_get, false);
    }

    public static torrent_flags_t getDefault_flags() {
        long default_flags_get = libtorrent_jni.default_flags_get();
        if (default_flags_get == 0) {
            return null;
        }
        return new torrent_flags_t(default_flags_get, false);
    }

    public static pex_flags_t getPex_encryption() {
        long pex_encryption_get = libtorrent_jni.pex_encryption_get();
        if (pex_encryption_get == 0) {
            return null;
        }
        return new pex_flags_t(pex_encryption_get, false);
    }

    public static pex_flags_t getPex_seed() {
        long pex_seed_get = libtorrent_jni.pex_seed_get();
        if (pex_seed_get == 0) {
            return null;
        }
        return new pex_flags_t(pex_seed_get, false);
    }

    public static pex_flags_t getPex_utp() {
        long pex_utp_get = libtorrent_jni.pex_utp_get();
        if (pex_utp_get == 0) {
            return null;
        }
        return new pex_flags_t(pex_utp_get, false);
    }

    public static pex_flags_t getPex_holepunch() {
        long pex_holepunch_get = libtorrent_jni.pex_holepunch_get();
        if (pex_holepunch_get == 0) {
            return null;
        }
        return new pex_flags_t(pex_holepunch_get, false);
    }

    public static String operation_name(operation_t operation_tVar) {
        return libtorrent_jni.operation_name(operation_tVar.swigValue());
    }

    public static stats_metric_vector session_stats_metrics() {
        return new stats_metric_vector(libtorrent_jni.session_stats_metrics(), true);
    }

    public static String alert_name(int i) {
        return libtorrent_jni.alert_name(i);
    }

    public static int getNum_alert_types() {
        return libtorrent_jni.num_alert_types_get();
    }

    public static int setting_by_name(string_view string_viewVar) {
        return libtorrent_jni.setting_by_name(string_view.getCPtr(string_viewVar), string_viewVar);
    }

    public static String name_for_setting(int i) {
        return libtorrent_jni.name_for_setting(i);
    }

    public static settings_pack default_settings() {
        return new settings_pack(libtorrent_jni.default_settings(), true);
    }

    public static boolean op_eq(peer_class_type_filter peer_class_type_filterVar, peer_class_type_filter peer_class_type_filterVar2) {
        return libtorrent_jni.op_eq__SWIG_0(peer_class_type_filter.getCPtr(peer_class_type_filterVar), peer_class_type_filterVar, peer_class_type_filter.getCPtr(peer_class_type_filterVar2), peer_class_type_filterVar2);
    }

    public static boolean op_lte(address addressVar, address addressVar2) {
        return libtorrent_jni.op_lte(address.getCPtr(addressVar), addressVar, address.getCPtr(addressVar2), addressVar2);
    }

    public static settings_pack min_memory_usage() {
        return new settings_pack(libtorrent_jni.min_memory_usage(), true);
    }

    public static settings_pack high_performance_seed() {
        return new settings_pack(libtorrent_jni.high_performance_seed(), true);
    }

    public static session_params read_session_params(bdecode_node bdecode_nodeVar, save_state_flags_t save_state_flags_tVar) {
        return new session_params(libtorrent_jni.read_session_params__SWIG_0(bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, save_state_flags_t.getCPtr(save_state_flags_tVar), save_state_flags_tVar), true);
    }

    public static session_params read_session_params(bdecode_node bdecode_nodeVar) {
        return new session_params(libtorrent_jni.read_session_params__SWIG_1(bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar), true);
    }

    public static String make_magnet_uri(torrent_handle torrent_handleVar) {
        return libtorrent_jni.make_magnet_uri__SWIG_0(torrent_handle.getCPtr(torrent_handleVar), torrent_handleVar);
    }

    public static String make_magnet_uri(torrent_info torrent_infoVar) {
        return libtorrent_jni.make_magnet_uri__SWIG_1(torrent_info.getCPtr(torrent_infoVar), torrent_infoVar);
    }

    public static void add_files(file_storage file_storageVar, String str, create_flags_t create_flags_tVar) {
        libtorrent_jni.add_files__SWIG_0(file_storage.getCPtr(file_storageVar), file_storageVar, str, create_flags_t.getCPtr(create_flags_tVar), create_flags_tVar);
    }

    public static void add_files(file_storage file_storageVar, String str) {
        libtorrent_jni.add_files__SWIG_1(file_storage.getCPtr(file_storageVar), file_storageVar, str);
    }

    public static void set_piece_hashes(create_torrent create_torrentVar, String str, error_code error_codeVar) {
        libtorrent_jni.set_piece_hashes(create_torrent.getCPtr(create_torrentVar), create_torrentVar, str, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public static String generate_fingerprint(String str, int i, int i2, int i3, int i4) {
        return libtorrent_jni.generate_fingerprint(str, i, i2, i3, i4);
    }

    public static byte_vector ed25519_create_seed() {
        return new byte_vector(libtorrent_jni.ed25519_create_seed(), true);
    }

    public static byte_vectors_pair ed25519_create_keypair(byte_vector byte_vectorVar) {
        return new byte_vectors_pair(libtorrent_jni.ed25519_create_keypair(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar), true);
    }

    public static byte_vector ed25519_sign(byte_vector byte_vectorVar, byte_vector byte_vectorVar2, byte_vector byte_vectorVar3) {
        return new byte_vector(libtorrent_jni.ed25519_sign(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2, byte_vector.getCPtr(byte_vectorVar3), byte_vectorVar3), true);
    }

    public static boolean ed25519_verify(byte_vector byte_vectorVar, byte_vector byte_vectorVar2, byte_vector byte_vectorVar3) {
        return libtorrent_jni.ed25519_verify(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2, byte_vector.getCPtr(byte_vectorVar3), byte_vectorVar3);
    }

    public static byte_vector ed25519_add_scalar_public(byte_vector byte_vectorVar, byte_vector byte_vectorVar2) {
        return new byte_vector(libtorrent_jni.ed25519_add_scalar_public(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2), true);
    }

    public static byte_vector ed25519_add_scalar_secret(byte_vector byte_vectorVar, byte_vector byte_vectorVar2) {
        return new byte_vector(libtorrent_jni.ed25519_add_scalar_secret(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2), true);
    }

    public static byte_vector ed25519_key_exchange(byte_vector byte_vectorVar, byte_vector byte_vectorVar2) {
        return new byte_vector(libtorrent_jni.ed25519_key_exchange(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, byte_vector.getCPtr(byte_vectorVar2), byte_vectorVar2), true);
    }

    public static void add_files_ex(file_storage file_storageVar, String str, add_files_listener add_files_listenerVar, create_flags_t create_flags_tVar) {
        libtorrent_jni.add_files_ex(file_storage.getCPtr(file_storageVar), file_storageVar, str, add_files_listener.getCPtr(add_files_listenerVar), add_files_listenerVar, create_flags_t.getCPtr(create_flags_tVar), create_flags_tVar);
    }

    public static void set_piece_hashes_ex(create_torrent create_torrentVar, String str, set_piece_hashes_listener set_piece_hashes_listenerVar, error_code error_codeVar) {
        libtorrent_jni.set_piece_hashes_ex(create_torrent.getCPtr(create_torrentVar), create_torrentVar, str, set_piece_hashes_listener.getCPtr(set_piece_hashes_listenerVar), set_piece_hashes_listenerVar, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public static int boost_version() {
        return libtorrent_jni.boost_version();
    }

    public static String boost_lib_version() {
        return libtorrent_jni.boost_lib_version();
    }

    public static int openssl_version_number() {
        return libtorrent_jni.openssl_version_number();
    }

    public static String openssl_version_text() {
        return libtorrent_jni.openssl_version_text();
    }

    public static int find_metric_idx_s(String str) {
        return libtorrent_jni.find_metric_idx_s(str);
    }

    public static ip_interface_vector enum_net_interfaces(C2430session c2430session) {
        return new ip_interface_vector(libtorrent_jni.enum_net_interfaces(C2430session.getCPtr(c2430session), c2430session), true);
    }

    public static ip_route_vector enum_routes(C2430session c2430session) {
        return new ip_route_vector(libtorrent_jni.enum_routes(C2430session.getCPtr(c2430session), c2430session), true);
    }

    public static void copy_byte_vector_to_char_array(byte_vector byte_vectorVar, String str, long j) {
        libtorrent_jni.copy_byte_vector_to_char_array(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, str, j);
    }

    public static address get_gateway(C2430session c2430session, ip_interface ip_interfaceVar, ip_route_vector ip_route_vectorVar) {
        return new address(libtorrent_jni.get_gateway(C2430session.getCPtr(c2430session), c2430session, ip_interface.getCPtr(ip_interfaceVar), ip_interfaceVar, ip_route_vector.getCPtr(ip_route_vectorVar), ip_route_vectorVar), true);
    }

    public static boolean arm_neon_support() {
        return libtorrent_jni.arm_neon_support();
    }

    public static void set_posix_wrapper(posix_wrapper posix_wrapperVar) {
        libtorrent_jni.set_posix_wrapper(posix_wrapper.getCPtr(posix_wrapperVar), posix_wrapperVar);
    }
}
