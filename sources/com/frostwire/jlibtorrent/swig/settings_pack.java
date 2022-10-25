package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class settings_pack {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public settings_pack(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(settings_pack settings_packVar) {
        if (settings_packVar == null) {
            return 0L;
        }
        return settings_packVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_settings_pack(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public settings_pack() {
        this(libtorrent_jni.new_settings_pack__SWIG_0(), true);
    }

    public settings_pack(settings_pack settings_packVar) {
        this(libtorrent_jni.new_settings_pack__SWIG_1(getCPtr(settings_packVar), settings_packVar), true);
    }

    public void set_str(int i, String str) {
        libtorrent_jni.settings_pack_set_str(this.swigCPtr, this, i, str);
    }

    public void set_int(int i, int i2) {
        libtorrent_jni.settings_pack_set_int(this.swigCPtr, this, i, i2);
    }

    public void set_bool(int i, boolean z) {
        libtorrent_jni.settings_pack_set_bool(this.swigCPtr, this, i, z);
    }

    public boolean has_val(int i) {
        return libtorrent_jni.settings_pack_has_val(this.swigCPtr, this, i);
    }

    public void clear() {
        libtorrent_jni.settings_pack_clear__SWIG_0(this.swigCPtr, this);
    }

    public void clear(int i) {
        libtorrent_jni.settings_pack_clear__SWIG_1(this.swigCPtr, this, i);
    }

    public String get_str(int i) {
        return libtorrent_jni.settings_pack_get_str(this.swigCPtr, this, i);
    }

    public int get_int(int i) {
        return libtorrent_jni.settings_pack_get_int(this.swigCPtr, this, i);
    }

    public boolean get_bool(int i) {
        return libtorrent_jni.settings_pack_get_bool(this.swigCPtr, this, i);
    }

    /* loaded from: classes2.dex */
    public static final class type_bases {
        public static final type_bases bool_type_base;
        public static final type_bases index_mask;
        public static final type_bases int_type_base;
        public static final type_bases string_type_base;
        private static int swigNext;
        private static type_bases[] swigValues;
        public static final type_bases type_mask;
        private final String swigName;
        private final int swigValue;

        static {
            type_bases type_basesVar = new type_bases("string_type_base", libtorrent_jni.settings_pack_string_type_base_get());
            string_type_base = type_basesVar;
            type_bases type_basesVar2 = new type_bases("int_type_base", libtorrent_jni.settings_pack_int_type_base_get());
            int_type_base = type_basesVar2;
            type_bases type_basesVar3 = new type_bases("bool_type_base", libtorrent_jni.settings_pack_bool_type_base_get());
            bool_type_base = type_basesVar3;
            type_bases type_basesVar4 = new type_bases("type_mask", libtorrent_jni.settings_pack_type_mask_get());
            type_mask = type_basesVar4;
            type_bases type_basesVar5 = new type_bases("index_mask", libtorrent_jni.settings_pack_index_mask_get());
            index_mask = type_basesVar5;
            swigValues = new type_bases[]{type_basesVar, type_basesVar2, type_basesVar3, type_basesVar4, type_basesVar5};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static type_bases swigToEnum(int i) {
            type_bases[] type_basesVarArr = swigValues;
            if (i < type_basesVarArr.length && i >= 0 && type_basesVarArr[i].swigValue == i) {
                return type_basesVarArr[i];
            }
            int i2 = 0;
            while (true) {
                type_bases[] type_basesVarArr2 = swigValues;
                if (i2 < type_basesVarArr2.length) {
                    if (type_basesVarArr2[i2].swigValue == i) {
                        return type_basesVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + type_bases.class + " with value " + i);
                }
            }
        }

        private type_bases(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private type_bases(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private type_bases(String str, type_bases type_basesVar) {
            this.swigName = str;
            int i = type_basesVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class string_types {
        public static final string_types announce_ip;
        public static final string_types dht_bootstrap_nodes;
        public static final string_types handshake_client_version;
        public static final string_types i2p_hostname;
        public static final string_types listen_interfaces;
        public static final string_types max_string_setting_internal;
        public static final string_types outgoing_interfaces;
        public static final string_types peer_fingerprint;
        public static final string_types proxy_hostname;
        public static final string_types proxy_password;
        public static final string_types proxy_username;
        private static int swigNext;
        private static string_types[] swigValues;
        public static final string_types user_agent;
        private final String swigName;
        private final int swigValue;

        static {
            string_types string_typesVar = new string_types("user_agent", libtorrent_jni.settings_pack_user_agent_get());
            user_agent = string_typesVar;
            string_types string_typesVar2 = new string_types("announce_ip");
            announce_ip = string_typesVar2;
            string_types string_typesVar3 = new string_types("handshake_client_version", libtorrent_jni.settings_pack_handshake_client_version_get());
            handshake_client_version = string_typesVar3;
            string_types string_typesVar4 = new string_types("outgoing_interfaces");
            outgoing_interfaces = string_typesVar4;
            string_types string_typesVar5 = new string_types("listen_interfaces");
            listen_interfaces = string_typesVar5;
            string_types string_typesVar6 = new string_types("proxy_hostname");
            proxy_hostname = string_typesVar6;
            string_types string_typesVar7 = new string_types("proxy_username");
            proxy_username = string_typesVar7;
            string_types string_typesVar8 = new string_types("proxy_password");
            proxy_password = string_typesVar8;
            string_types string_typesVar9 = new string_types("i2p_hostname");
            i2p_hostname = string_typesVar9;
            string_types string_typesVar10 = new string_types("peer_fingerprint");
            peer_fingerprint = string_typesVar10;
            string_types string_typesVar11 = new string_types("dht_bootstrap_nodes");
            dht_bootstrap_nodes = string_typesVar11;
            string_types string_typesVar12 = new string_types("max_string_setting_internal");
            max_string_setting_internal = string_typesVar12;
            swigValues = new string_types[]{string_typesVar, string_typesVar2, string_typesVar3, string_typesVar4, string_typesVar5, string_typesVar6, string_typesVar7, string_typesVar8, string_typesVar9, string_typesVar10, string_typesVar11, string_typesVar12};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static string_types swigToEnum(int i) {
            string_types[] string_typesVarArr = swigValues;
            if (i < string_typesVarArr.length && i >= 0 && string_typesVarArr[i].swigValue == i) {
                return string_typesVarArr[i];
            }
            int i2 = 0;
            while (true) {
                string_types[] string_typesVarArr2 = swigValues;
                if (i2 < string_typesVarArr2.length) {
                    if (string_typesVarArr2[i2].swigValue == i) {
                        return string_typesVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + string_types.class + " with value " + i);
                }
            }
        }

        private string_types(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private string_types(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private string_types(String str, string_types string_typesVar) {
            this.swigName = str;
            int i = string_typesVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class bool_types {
        private final String swigName;
        private final int swigValue;
        public static final bool_types allow_multiple_connections_per_ip = new bool_types("allow_multiple_connections_per_ip", libtorrent_jni.settings_pack_allow_multiple_connections_per_ip_get());
        public static final bool_types send_redundant_have = new bool_types("send_redundant_have", libtorrent_jni.settings_pack_send_redundant_have_get());
        public static final bool_types use_dht_as_fallback = new bool_types("use_dht_as_fallback", libtorrent_jni.settings_pack_use_dht_as_fallback_get());
        public static final bool_types use_parole_mode = new bool_types("use_parole_mode", libtorrent_jni.settings_pack_use_parole_mode_get());
        public static final bool_types use_read_cache = new bool_types("use_read_cache");
        public static final bool_types coalesce_reads = new bool_types("coalesce_reads", libtorrent_jni.settings_pack_coalesce_reads_get());
        public static final bool_types coalesce_writes = new bool_types("coalesce_writes");
        public static final bool_types auto_manage_prefer_seeds = new bool_types("auto_manage_prefer_seeds");
        public static final bool_types dont_count_slow_torrents = new bool_types("dont_count_slow_torrents");
        public static final bool_types close_redundant_connections = new bool_types("close_redundant_connections");
        public static final bool_types prioritize_partial_pieces = new bool_types("prioritize_partial_pieces");
        public static final bool_types rate_limit_ip_overhead = new bool_types("rate_limit_ip_overhead");
        public static final bool_types announce_to_all_tiers = new bool_types("announce_to_all_tiers");
        public static final bool_types announce_to_all_trackers = new bool_types("announce_to_all_trackers");
        public static final bool_types prefer_udp_trackers = new bool_types("prefer_udp_trackers");
        public static final bool_types strict_super_seeding = new bool_types("strict_super_seeding");
        public static final bool_types disable_hash_checks = new bool_types("disable_hash_checks", libtorrent_jni.settings_pack_disable_hash_checks_get());
        public static final bool_types allow_i2p_mixed = new bool_types("allow_i2p_mixed");
        public static final bool_types volatile_read_cache = new bool_types("volatile_read_cache", libtorrent_jni.settings_pack_volatile_read_cache_get());
        public static final bool_types no_atime_storage = new bool_types("no_atime_storage", libtorrent_jni.settings_pack_no_atime_storage_get());
        public static final bool_types incoming_starts_queued_torrents = new bool_types("incoming_starts_queued_torrents");
        public static final bool_types report_true_downloaded = new bool_types("report_true_downloaded");
        public static final bool_types strict_end_game_mode = new bool_types("strict_end_game_mode");
        public static final bool_types enable_outgoing_utp = new bool_types("enable_outgoing_utp", libtorrent_jni.settings_pack_enable_outgoing_utp_get());
        public static final bool_types enable_incoming_utp = new bool_types("enable_incoming_utp");
        public static final bool_types enable_outgoing_tcp = new bool_types("enable_outgoing_tcp");
        public static final bool_types enable_incoming_tcp = new bool_types("enable_incoming_tcp");
        public static final bool_types no_recheck_incomplete_resume = new bool_types("no_recheck_incomplete_resume", libtorrent_jni.settings_pack_no_recheck_incomplete_resume_get());
        public static final bool_types anonymous_mode = new bool_types("anonymous_mode");
        public static final bool_types report_web_seed_downloads = new bool_types("report_web_seed_downloads");
        public static final bool_types seeding_outgoing_connections = new bool_types("seeding_outgoing_connections", libtorrent_jni.settings_pack_seeding_outgoing_connections_get());
        public static final bool_types no_connect_privileged_ports = new bool_types("no_connect_privileged_ports");
        public static final bool_types smooth_connects = new bool_types("smooth_connects");
        public static final bool_types always_send_user_agent = new bool_types("always_send_user_agent");
        public static final bool_types apply_ip_filter_to_trackers = new bool_types("apply_ip_filter_to_trackers");
        public static final bool_types ban_web_seeds = new bool_types("ban_web_seeds", libtorrent_jni.settings_pack_ban_web_seeds_get());
        public static final bool_types allow_partial_disk_writes = new bool_types("allow_partial_disk_writes");
        public static final bool_types support_share_mode = new bool_types("support_share_mode", libtorrent_jni.settings_pack_support_share_mode_get());
        public static final bool_types support_merkle_torrents = new bool_types("support_merkle_torrents");
        public static final bool_types report_redundant_bytes = new bool_types("report_redundant_bytes");
        public static final bool_types listen_system_port_fallback = new bool_types("listen_system_port_fallback");
        public static final bool_types announce_crypto_support = new bool_types("announce_crypto_support", libtorrent_jni.settings_pack_announce_crypto_support_get());
        public static final bool_types enable_upnp = new bool_types("enable_upnp");
        public static final bool_types enable_natpmp = new bool_types("enable_natpmp");
        public static final bool_types enable_lsd = new bool_types("enable_lsd");
        public static final bool_types enable_dht = new bool_types("enable_dht");
        public static final bool_types prefer_rc4 = new bool_types("prefer_rc4");
        public static final bool_types proxy_hostnames = new bool_types("proxy_hostnames");
        public static final bool_types proxy_peer_connections = new bool_types("proxy_peer_connections");
        public static final bool_types auto_sequential = new bool_types("auto_sequential");
        public static final bool_types proxy_tracker_connections = new bool_types("proxy_tracker_connections");
        public static final bool_types enable_ip_notifier = new bool_types("enable_ip_notifier");
        public static final bool_types dht_prefer_verified_node_ids = new bool_types("dht_prefer_verified_node_ids");
        public static final bool_types piece_extent_affinity = new bool_types("piece_extent_affinity");
        public static final bool_types max_bool_setting_internal = new bool_types("max_bool_setting_internal");
        private static bool_types[] swigValues = {allow_multiple_connections_per_ip, send_redundant_have, use_dht_as_fallback, use_parole_mode, use_read_cache, coalesce_reads, coalesce_writes, auto_manage_prefer_seeds, dont_count_slow_torrents, close_redundant_connections, prioritize_partial_pieces, rate_limit_ip_overhead, announce_to_all_tiers, announce_to_all_trackers, prefer_udp_trackers, strict_super_seeding, disable_hash_checks, allow_i2p_mixed, volatile_read_cache, no_atime_storage, incoming_starts_queued_torrents, report_true_downloaded, strict_end_game_mode, enable_outgoing_utp, enable_incoming_utp, enable_outgoing_tcp, enable_incoming_tcp, no_recheck_incomplete_resume, anonymous_mode, report_web_seed_downloads, seeding_outgoing_connections, no_connect_privileged_ports, smooth_connects, always_send_user_agent, apply_ip_filter_to_trackers, ban_web_seeds, allow_partial_disk_writes, support_share_mode, support_merkle_torrents, report_redundant_bytes, listen_system_port_fallback, announce_crypto_support, enable_upnp, enable_natpmp, enable_lsd, enable_dht, prefer_rc4, proxy_hostnames, proxy_peer_connections, auto_sequential, proxy_tracker_connections, enable_ip_notifier, dht_prefer_verified_node_ids, piece_extent_affinity, max_bool_setting_internal};
        private static int swigNext = 0;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static bool_types swigToEnum(int i) {
            bool_types[] bool_typesVarArr = swigValues;
            if (i < bool_typesVarArr.length && i >= 0 && bool_typesVarArr[i].swigValue == i) {
                return bool_typesVarArr[i];
            }
            int i2 = 0;
            while (true) {
                bool_types[] bool_typesVarArr2 = swigValues;
                if (i2 < bool_typesVarArr2.length) {
                    if (bool_typesVarArr2[i2].swigValue == i) {
                        return bool_typesVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + bool_types.class + " with value " + i);
                }
            }
        }

        private bool_types(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private bool_types(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private bool_types(String str, bool_types bool_typesVar) {
            this.swigName = str;
            int i = bool_typesVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class int_types {
        private final String swigName;
        private final int swigValue;
        public static final int_types tracker_completion_timeout = new int_types("tracker_completion_timeout", libtorrent_jni.settings_pack_tracker_completion_timeout_get());
        public static final int_types tracker_receive_timeout = new int_types("tracker_receive_timeout");
        public static final int_types stop_tracker_timeout = new int_types("stop_tracker_timeout");
        public static final int_types tracker_maximum_response_length = new int_types("tracker_maximum_response_length");
        public static final int_types piece_timeout = new int_types("piece_timeout");
        public static final int_types request_timeout = new int_types("request_timeout");
        public static final int_types request_queue_time = new int_types("request_queue_time");
        public static final int_types max_allowed_in_request_queue = new int_types("max_allowed_in_request_queue");
        public static final int_types max_out_request_queue = new int_types("max_out_request_queue");
        public static final int_types whole_pieces_threshold = new int_types("whole_pieces_threshold");
        public static final int_types peer_timeout = new int_types("peer_timeout");
        public static final int_types urlseed_timeout = new int_types("urlseed_timeout");
        public static final int_types urlseed_pipeline_size = new int_types("urlseed_pipeline_size");
        public static final int_types urlseed_wait_retry = new int_types("urlseed_wait_retry");
        public static final int_types file_pool_size = new int_types("file_pool_size");
        public static final int_types max_failcount = new int_types("max_failcount");
        public static final int_types min_reconnect_time = new int_types("min_reconnect_time");
        public static final int_types peer_connect_timeout = new int_types("peer_connect_timeout");
        public static final int_types connection_speed = new int_types("connection_speed");
        public static final int_types inactivity_timeout = new int_types("inactivity_timeout");
        public static final int_types unchoke_interval = new int_types("unchoke_interval");
        public static final int_types optimistic_unchoke_interval = new int_types("optimistic_unchoke_interval");
        public static final int_types num_want = new int_types("num_want");
        public static final int_types initial_picker_threshold = new int_types("initial_picker_threshold");
        public static final int_types allowed_fast_set_size = new int_types("allowed_fast_set_size");
        public static final int_types suggest_mode = new int_types("suggest_mode");
        public static final int_types max_queued_disk_bytes = new int_types("max_queued_disk_bytes");
        public static final int_types handshake_timeout = new int_types("handshake_timeout");
        public static final int_types send_buffer_low_watermark = new int_types("send_buffer_low_watermark");
        public static final int_types send_buffer_watermark = new int_types("send_buffer_watermark");
        public static final int_types send_buffer_watermark_factor = new int_types("send_buffer_watermark_factor");
        public static final int_types choking_algorithm = new int_types("choking_algorithm");
        public static final int_types seed_choking_algorithm = new int_types("seed_choking_algorithm");
        public static final int_types cache_size = new int_types("cache_size");
        public static final int_types cache_expiry = new int_types("cache_expiry", libtorrent_jni.settings_pack_cache_expiry_get());
        public static final int_types disk_io_write_mode = new int_types("disk_io_write_mode");
        public static final int_types disk_io_read_mode = new int_types("disk_io_read_mode");
        public static final int_types outgoing_port = new int_types("outgoing_port");
        public static final int_types num_outgoing_ports = new int_types("num_outgoing_ports");
        public static final int_types peer_tos = new int_types("peer_tos");
        public static final int_types active_downloads = new int_types("active_downloads");
        public static final int_types active_seeds = new int_types("active_seeds");
        public static final int_types active_checking = new int_types("active_checking");
        public static final int_types active_dht_limit = new int_types("active_dht_limit");
        public static final int_types active_tracker_limit = new int_types("active_tracker_limit");
        public static final int_types active_lsd_limit = new int_types("active_lsd_limit");
        public static final int_types active_limit = new int_types("active_limit");
        public static final int_types auto_manage_interval = new int_types("auto_manage_interval", libtorrent_jni.settings_pack_auto_manage_interval_get());
        public static final int_types seed_time_limit = new int_types("seed_time_limit");
        public static final int_types auto_scrape_interval = new int_types("auto_scrape_interval");
        public static final int_types auto_scrape_min_interval = new int_types("auto_scrape_min_interval");
        public static final int_types max_peerlist_size = new int_types("max_peerlist_size");
        public static final int_types max_paused_peerlist_size = new int_types("max_paused_peerlist_size");
        public static final int_types min_announce_interval = new int_types("min_announce_interval");
        public static final int_types auto_manage_startup = new int_types("auto_manage_startup");
        public static final int_types seeding_piece_quota = new int_types("seeding_piece_quota");
        public static final int_types max_rejects = new int_types("max_rejects");
        public static final int_types recv_socket_buffer_size = new int_types("recv_socket_buffer_size");
        public static final int_types send_socket_buffer_size = new int_types("send_socket_buffer_size");
        public static final int_types max_peer_recv_buffer_size = new int_types("max_peer_recv_buffer_size");
        public static final int_types read_cache_line_size = new int_types("read_cache_line_size", libtorrent_jni.settings_pack_read_cache_line_size_get());
        public static final int_types write_cache_line_size = new int_types("write_cache_line_size");
        public static final int_types optimistic_disk_retry = new int_types("optimistic_disk_retry");
        public static final int_types max_suggest_pieces = new int_types("max_suggest_pieces");
        public static final int_types local_service_announce_interval = new int_types("local_service_announce_interval");
        public static final int_types dht_announce_interval = new int_types("dht_announce_interval");
        public static final int_types udp_tracker_token_expiry = new int_types("udp_tracker_token_expiry");
        public static final int_types num_optimistic_unchoke_slots = new int_types("num_optimistic_unchoke_slots", libtorrent_jni.settings_pack_num_optimistic_unchoke_slots_get());
        public static final int_types default_est_reciprocation_rate = new int_types("default_est_reciprocation_rate");
        public static final int_types increase_est_reciprocation_rate = new int_types("increase_est_reciprocation_rate");
        public static final int_types decrease_est_reciprocation_rate = new int_types("decrease_est_reciprocation_rate");
        public static final int_types max_pex_peers = new int_types("max_pex_peers");
        public static final int_types tick_interval = new int_types("tick_interval");
        public static final int_types share_mode_target = new int_types("share_mode_target");
        public static final int_types upload_rate_limit = new int_types("upload_rate_limit");
        public static final int_types download_rate_limit = new int_types("download_rate_limit");
        public static final int_types dht_upload_rate_limit = new int_types("dht_upload_rate_limit", libtorrent_jni.settings_pack_dht_upload_rate_limit_get());
        public static final int_types unchoke_slots_limit = new int_types("unchoke_slots_limit");
        public static final int_types connections_limit = new int_types("connections_limit", libtorrent_jni.settings_pack_connections_limit_get());
        public static final int_types connections_slack = new int_types("connections_slack");
        public static final int_types utp_target_delay = new int_types("utp_target_delay");
        public static final int_types utp_gain_factor = new int_types("utp_gain_factor");
        public static final int_types utp_min_timeout = new int_types("utp_min_timeout");
        public static final int_types utp_syn_resends = new int_types("utp_syn_resends");
        public static final int_types utp_fin_resends = new int_types("utp_fin_resends");
        public static final int_types utp_num_resends = new int_types("utp_num_resends");
        public static final int_types utp_connect_timeout = new int_types("utp_connect_timeout");
        public static final int_types utp_loss_multiplier = new int_types("utp_loss_multiplier", libtorrent_jni.settings_pack_utp_loss_multiplier_get());
        public static final int_types mixed_mode_algorithm = new int_types("mixed_mode_algorithm");
        public static final int_types listen_queue_size = new int_types("listen_queue_size");
        public static final int_types torrent_connect_boost = new int_types("torrent_connect_boost");
        public static final int_types alert_queue_size = new int_types("alert_queue_size");
        public static final int_types max_metadata_size = new int_types("max_metadata_size");
        public static final int_types checking_mem_usage = new int_types("checking_mem_usage", libtorrent_jni.settings_pack_checking_mem_usage_get());
        public static final int_types predictive_piece_announce = new int_types("predictive_piece_announce");
        public static final int_types aio_threads = new int_types("aio_threads");
        public static final int_types deprecated_aio_max = new int_types("deprecated_aio_max");
        public static final int_types tracker_backoff = new int_types("tracker_backoff", libtorrent_jni.settings_pack_tracker_backoff_get());
        public static final int_types share_ratio_limit = new int_types("share_ratio_limit");
        public static final int_types seed_time_ratio_limit = new int_types("seed_time_ratio_limit");
        public static final int_types peer_turnover = new int_types("peer_turnover");
        public static final int_types peer_turnover_cutoff = new int_types("peer_turnover_cutoff");
        public static final int_types peer_turnover_interval = new int_types("peer_turnover_interval");
        public static final int_types connect_seed_every_n_download = new int_types("connect_seed_every_n_download");
        public static final int_types max_http_recv_buffer_size = new int_types("max_http_recv_buffer_size");
        public static final int_types max_retry_port_bind = new int_types("max_retry_port_bind");
        public static final int_types alert_mask = new int_types("alert_mask");
        public static final int_types out_enc_policy = new int_types("out_enc_policy");
        public static final int_types in_enc_policy = new int_types("in_enc_policy");
        public static final int_types allowed_enc_level = new int_types("allowed_enc_level");
        public static final int_types inactive_down_rate = new int_types("inactive_down_rate");
        public static final int_types inactive_up_rate = new int_types("inactive_up_rate");
        public static final int_types proxy_type = new int_types("proxy_type");
        public static final int_types proxy_port = new int_types("proxy_port");
        public static final int_types i2p_port = new int_types("i2p_port");
        public static final int_types cache_size_volatile = new int_types("cache_size_volatile");
        public static final int_types urlseed_max_request_bytes = new int_types("urlseed_max_request_bytes");
        public static final int_types web_seed_name_lookup_retry = new int_types("web_seed_name_lookup_retry");
        public static final int_types close_file_interval = new int_types("close_file_interval");
        public static final int_types utp_cwnd_reduce_timer = new int_types("utp_cwnd_reduce_timer");
        public static final int_types max_web_seed_connections = new int_types("max_web_seed_connections");
        public static final int_types resolver_cache_timeout = new int_types("resolver_cache_timeout");
        public static final int_types send_not_sent_low_watermark = new int_types("send_not_sent_low_watermark");
        public static final int_types max_int_setting_internal = new int_types("max_int_setting_internal");
        private static int_types[] swigValues = {tracker_completion_timeout, tracker_receive_timeout, stop_tracker_timeout, tracker_maximum_response_length, piece_timeout, request_timeout, request_queue_time, max_allowed_in_request_queue, max_out_request_queue, whole_pieces_threshold, peer_timeout, urlseed_timeout, urlseed_pipeline_size, urlseed_wait_retry, file_pool_size, max_failcount, min_reconnect_time, peer_connect_timeout, connection_speed, inactivity_timeout, unchoke_interval, optimistic_unchoke_interval, num_want, initial_picker_threshold, allowed_fast_set_size, suggest_mode, max_queued_disk_bytes, handshake_timeout, send_buffer_low_watermark, send_buffer_watermark, send_buffer_watermark_factor, choking_algorithm, seed_choking_algorithm, cache_size, cache_expiry, disk_io_write_mode, disk_io_read_mode, outgoing_port, num_outgoing_ports, peer_tos, active_downloads, active_seeds, active_checking, active_dht_limit, active_tracker_limit, active_lsd_limit, active_limit, auto_manage_interval, seed_time_limit, auto_scrape_interval, auto_scrape_min_interval, max_peerlist_size, max_paused_peerlist_size, min_announce_interval, auto_manage_startup, seeding_piece_quota, max_rejects, recv_socket_buffer_size, send_socket_buffer_size, max_peer_recv_buffer_size, read_cache_line_size, write_cache_line_size, optimistic_disk_retry, max_suggest_pieces, local_service_announce_interval, dht_announce_interval, udp_tracker_token_expiry, num_optimistic_unchoke_slots, default_est_reciprocation_rate, increase_est_reciprocation_rate, decrease_est_reciprocation_rate, max_pex_peers, tick_interval, share_mode_target, upload_rate_limit, download_rate_limit, dht_upload_rate_limit, unchoke_slots_limit, connections_limit, connections_slack, utp_target_delay, utp_gain_factor, utp_min_timeout, utp_syn_resends, utp_fin_resends, utp_num_resends, utp_connect_timeout, utp_loss_multiplier, mixed_mode_algorithm, listen_queue_size, torrent_connect_boost, alert_queue_size, max_metadata_size, checking_mem_usage, predictive_piece_announce, aio_threads, deprecated_aio_max, tracker_backoff, share_ratio_limit, seed_time_ratio_limit, peer_turnover, peer_turnover_cutoff, peer_turnover_interval, connect_seed_every_n_download, max_http_recv_buffer_size, max_retry_port_bind, alert_mask, out_enc_policy, in_enc_policy, allowed_enc_level, inactive_down_rate, inactive_up_rate, proxy_type, proxy_port, i2p_port, cache_size_volatile, urlseed_max_request_bytes, web_seed_name_lookup_retry, close_file_interval, utp_cwnd_reduce_timer, max_web_seed_connections, resolver_cache_timeout, send_not_sent_low_watermark, max_int_setting_internal};
        private static int swigNext = 0;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static int_types swigToEnum(int i) {
            int_types[] int_typesVarArr = swigValues;
            if (i < int_typesVarArr.length && i >= 0 && int_typesVarArr[i].swigValue == i) {
                return int_typesVarArr[i];
            }
            int i2 = 0;
            while (true) {
                int_types[] int_typesVarArr2 = swigValues;
                if (i2 < int_typesVarArr2.length) {
                    if (int_typesVarArr2[i2].swigValue == i) {
                        return int_typesVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + int_types.class + " with value " + i);
                }
            }
        }

        private int_types(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private int_types(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private int_types(String str, int_types int_typesVar) {
            this.swigName = str;
            int i = int_typesVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class settings_counts_t {
        public static final settings_counts_t num_bool_settings;
        public static final settings_counts_t num_int_settings;
        public static final settings_counts_t num_string_settings;
        private static int swigNext;
        private static settings_counts_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            settings_counts_t settings_counts_tVar = new settings_counts_t("num_string_settings", libtorrent_jni.settings_pack_num_string_settings_get());
            num_string_settings = settings_counts_tVar;
            settings_counts_t settings_counts_tVar2 = new settings_counts_t("num_bool_settings", libtorrent_jni.settings_pack_num_bool_settings_get());
            num_bool_settings = settings_counts_tVar2;
            settings_counts_t settings_counts_tVar3 = new settings_counts_t("num_int_settings", libtorrent_jni.settings_pack_num_int_settings_get());
            num_int_settings = settings_counts_tVar3;
            swigValues = new settings_counts_t[]{settings_counts_tVar, settings_counts_tVar2, settings_counts_tVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static settings_counts_t swigToEnum(int i) {
            settings_counts_t[] settings_counts_tVarArr = swigValues;
            if (i < settings_counts_tVarArr.length && i >= 0 && settings_counts_tVarArr[i].swigValue == i) {
                return settings_counts_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                settings_counts_t[] settings_counts_tVarArr2 = swigValues;
                if (i2 < settings_counts_tVarArr2.length) {
                    if (settings_counts_tVarArr2[i2].swigValue == i) {
                        return settings_counts_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + settings_counts_t.class + " with value " + i);
                }
            }
        }

        private settings_counts_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private settings_counts_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private settings_counts_t(String str, settings_counts_t settings_counts_tVar) {
            this.swigName = str;
            int i = settings_counts_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class suggest_mode_t {
        public static final suggest_mode_t no_piece_suggestions;
        public static final suggest_mode_t suggest_read_cache;
        private static int swigNext;
        private static suggest_mode_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            suggest_mode_t suggest_mode_tVar = new suggest_mode_t("no_piece_suggestions", libtorrent_jni.settings_pack_no_piece_suggestions_get());
            no_piece_suggestions = suggest_mode_tVar;
            suggest_mode_t suggest_mode_tVar2 = new suggest_mode_t("suggest_read_cache", libtorrent_jni.settings_pack_suggest_read_cache_get());
            suggest_read_cache = suggest_mode_tVar2;
            swigValues = new suggest_mode_t[]{suggest_mode_tVar, suggest_mode_tVar2};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static suggest_mode_t swigToEnum(int i) {
            suggest_mode_t[] suggest_mode_tVarArr = swigValues;
            if (i < suggest_mode_tVarArr.length && i >= 0 && suggest_mode_tVarArr[i].swigValue == i) {
                return suggest_mode_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                suggest_mode_t[] suggest_mode_tVarArr2 = swigValues;
                if (i2 < suggest_mode_tVarArr2.length) {
                    if (suggest_mode_tVarArr2[i2].swigValue == i) {
                        return suggest_mode_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + suggest_mode_t.class + " with value " + i);
                }
            }
        }

        private suggest_mode_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private suggest_mode_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private suggest_mode_t(String str, suggest_mode_t suggest_mode_tVar) {
            this.swigName = str;
            int i = suggest_mode_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class choking_algorithm_t {
        public static final choking_algorithm_t bittyrant_choker;
        public static final choking_algorithm_t fixed_slots_choker;
        public static final choking_algorithm_t rate_based_choker;
        private static int swigNext;
        private static choking_algorithm_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            choking_algorithm_t choking_algorithm_tVar = new choking_algorithm_t("fixed_slots_choker", libtorrent_jni.settings_pack_fixed_slots_choker_get());
            fixed_slots_choker = choking_algorithm_tVar;
            choking_algorithm_t choking_algorithm_tVar2 = new choking_algorithm_t("rate_based_choker", libtorrent_jni.settings_pack_rate_based_choker_get());
            rate_based_choker = choking_algorithm_tVar2;
            choking_algorithm_t choking_algorithm_tVar3 = new choking_algorithm_t("bittyrant_choker", libtorrent_jni.settings_pack_bittyrant_choker_get());
            bittyrant_choker = choking_algorithm_tVar3;
            swigValues = new choking_algorithm_t[]{choking_algorithm_tVar, choking_algorithm_tVar2, choking_algorithm_tVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static choking_algorithm_t swigToEnum(int i) {
            choking_algorithm_t[] choking_algorithm_tVarArr = swigValues;
            if (i < choking_algorithm_tVarArr.length && i >= 0 && choking_algorithm_tVarArr[i].swigValue == i) {
                return choking_algorithm_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                choking_algorithm_t[] choking_algorithm_tVarArr2 = swigValues;
                if (i2 < choking_algorithm_tVarArr2.length) {
                    if (choking_algorithm_tVarArr2[i2].swigValue == i) {
                        return choking_algorithm_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + choking_algorithm_t.class + " with value " + i);
                }
            }
        }

        private choking_algorithm_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private choking_algorithm_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private choking_algorithm_t(String str, choking_algorithm_t choking_algorithm_tVar) {
            this.swigName = str;
            int i = choking_algorithm_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class seed_choking_algorithm_t {
        public static final seed_choking_algorithm_t anti_leech;
        public static final seed_choking_algorithm_t fastest_upload;
        public static final seed_choking_algorithm_t round_robin;
        private static int swigNext;
        private static seed_choking_algorithm_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            seed_choking_algorithm_t seed_choking_algorithm_tVar = new seed_choking_algorithm_t("round_robin");
            round_robin = seed_choking_algorithm_tVar;
            seed_choking_algorithm_t seed_choking_algorithm_tVar2 = new seed_choking_algorithm_t("fastest_upload");
            fastest_upload = seed_choking_algorithm_tVar2;
            seed_choking_algorithm_t seed_choking_algorithm_tVar3 = new seed_choking_algorithm_t("anti_leech");
            anti_leech = seed_choking_algorithm_tVar3;
            swigValues = new seed_choking_algorithm_t[]{seed_choking_algorithm_tVar, seed_choking_algorithm_tVar2, seed_choking_algorithm_tVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static seed_choking_algorithm_t swigToEnum(int i) {
            seed_choking_algorithm_t[] seed_choking_algorithm_tVarArr = swigValues;
            if (i < seed_choking_algorithm_tVarArr.length && i >= 0 && seed_choking_algorithm_tVarArr[i].swigValue == i) {
                return seed_choking_algorithm_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                seed_choking_algorithm_t[] seed_choking_algorithm_tVarArr2 = swigValues;
                if (i2 < seed_choking_algorithm_tVarArr2.length) {
                    if (seed_choking_algorithm_tVarArr2[i2].swigValue == i) {
                        return seed_choking_algorithm_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + seed_choking_algorithm_t.class + " with value " + i);
                }
            }
        }

        private seed_choking_algorithm_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private seed_choking_algorithm_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private seed_choking_algorithm_t(String str, seed_choking_algorithm_t seed_choking_algorithm_tVar) {
            this.swigName = str;
            int i = seed_choking_algorithm_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class io_buffer_mode_t {
        public static final io_buffer_mode_t deprecated_disable_os_cache_for_aligned_files;
        public static final io_buffer_mode_t disable_os_cache;
        public static final io_buffer_mode_t enable_os_cache;
        private static int swigNext;
        private static io_buffer_mode_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            io_buffer_mode_t io_buffer_mode_tVar = new io_buffer_mode_t("enable_os_cache", libtorrent_jni.settings_pack_enable_os_cache_get());
            enable_os_cache = io_buffer_mode_tVar;
            io_buffer_mode_t io_buffer_mode_tVar2 = new io_buffer_mode_t("deprecated_disable_os_cache_for_aligned_files", libtorrent_jni.settings_pack_deprecated_disable_os_cache_for_aligned_files_get());
            deprecated_disable_os_cache_for_aligned_files = io_buffer_mode_tVar2;
            io_buffer_mode_t io_buffer_mode_tVar3 = new io_buffer_mode_t("disable_os_cache", libtorrent_jni.settings_pack_disable_os_cache_get());
            disable_os_cache = io_buffer_mode_tVar3;
            swigValues = new io_buffer_mode_t[]{io_buffer_mode_tVar, io_buffer_mode_tVar2, io_buffer_mode_tVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static io_buffer_mode_t swigToEnum(int i) {
            io_buffer_mode_t[] io_buffer_mode_tVarArr = swigValues;
            if (i < io_buffer_mode_tVarArr.length && i >= 0 && io_buffer_mode_tVarArr[i].swigValue == i) {
                return io_buffer_mode_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                io_buffer_mode_t[] io_buffer_mode_tVarArr2 = swigValues;
                if (i2 < io_buffer_mode_tVarArr2.length) {
                    if (io_buffer_mode_tVarArr2[i2].swigValue == i) {
                        return io_buffer_mode_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + io_buffer_mode_t.class + " with value " + i);
                }
            }
        }

        private io_buffer_mode_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private io_buffer_mode_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private io_buffer_mode_t(String str, io_buffer_mode_t io_buffer_mode_tVar) {
            this.swigName = str;
            int i = io_buffer_mode_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class bandwidth_mixed_algo_t {
        public static final bandwidth_mixed_algo_t peer_proportional;
        public static final bandwidth_mixed_algo_t prefer_tcp;
        private static int swigNext;
        private static bandwidth_mixed_algo_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            bandwidth_mixed_algo_t bandwidth_mixed_algo_tVar = new bandwidth_mixed_algo_t("prefer_tcp", libtorrent_jni.settings_pack_prefer_tcp_get());
            prefer_tcp = bandwidth_mixed_algo_tVar;
            bandwidth_mixed_algo_t bandwidth_mixed_algo_tVar2 = new bandwidth_mixed_algo_t("peer_proportional", libtorrent_jni.settings_pack_peer_proportional_get());
            peer_proportional = bandwidth_mixed_algo_tVar2;
            swigValues = new bandwidth_mixed_algo_t[]{bandwidth_mixed_algo_tVar, bandwidth_mixed_algo_tVar2};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static bandwidth_mixed_algo_t swigToEnum(int i) {
            bandwidth_mixed_algo_t[] bandwidth_mixed_algo_tVarArr = swigValues;
            if (i < bandwidth_mixed_algo_tVarArr.length && i >= 0 && bandwidth_mixed_algo_tVarArr[i].swigValue == i) {
                return bandwidth_mixed_algo_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                bandwidth_mixed_algo_t[] bandwidth_mixed_algo_tVarArr2 = swigValues;
                if (i2 < bandwidth_mixed_algo_tVarArr2.length) {
                    if (bandwidth_mixed_algo_tVarArr2[i2].swigValue == i) {
                        return bandwidth_mixed_algo_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + bandwidth_mixed_algo_t.class + " with value " + i);
                }
            }
        }

        private bandwidth_mixed_algo_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private bandwidth_mixed_algo_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private bandwidth_mixed_algo_t(String str, bandwidth_mixed_algo_t bandwidth_mixed_algo_tVar) {
            this.swigName = str;
            int i = bandwidth_mixed_algo_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class enc_policy {
        public static final enc_policy pe_disabled;
        public static final enc_policy pe_enabled;
        public static final enc_policy pe_forced;
        private static int swigNext;
        private static enc_policy[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            enc_policy enc_policyVar = new enc_policy("pe_forced");
            pe_forced = enc_policyVar;
            enc_policy enc_policyVar2 = new enc_policy("pe_enabled");
            pe_enabled = enc_policyVar2;
            enc_policy enc_policyVar3 = new enc_policy("pe_disabled");
            pe_disabled = enc_policyVar3;
            swigValues = new enc_policy[]{enc_policyVar, enc_policyVar2, enc_policyVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static enc_policy swigToEnum(int i) {
            enc_policy[] enc_policyVarArr = swigValues;
            if (i < enc_policyVarArr.length && i >= 0 && enc_policyVarArr[i].swigValue == i) {
                return enc_policyVarArr[i];
            }
            int i2 = 0;
            while (true) {
                enc_policy[] enc_policyVarArr2 = swigValues;
                if (i2 < enc_policyVarArr2.length) {
                    if (enc_policyVarArr2[i2].swigValue == i) {
                        return enc_policyVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + enc_policy.class + " with value " + i);
                }
            }
        }

        private enc_policy(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private enc_policy(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private enc_policy(String str, enc_policy enc_policyVar) {
            this.swigName = str;
            int i = enc_policyVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class enc_level {
        public static final enc_level pe_both;
        public static final enc_level pe_plaintext;
        public static final enc_level pe_rc4;
        private static int swigNext;
        private static enc_level[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            enc_level enc_levelVar = new enc_level("pe_plaintext", libtorrent_jni.settings_pack_pe_plaintext_get());
            pe_plaintext = enc_levelVar;
            enc_level enc_levelVar2 = new enc_level("pe_rc4", libtorrent_jni.settings_pack_pe_rc4_get());
            pe_rc4 = enc_levelVar2;
            enc_level enc_levelVar3 = new enc_level("pe_both", libtorrent_jni.settings_pack_pe_both_get());
            pe_both = enc_levelVar3;
            swigValues = new enc_level[]{enc_levelVar, enc_levelVar2, enc_levelVar3};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static enc_level swigToEnum(int i) {
            enc_level[] enc_levelVarArr = swigValues;
            if (i < enc_levelVarArr.length && i >= 0 && enc_levelVarArr[i].swigValue == i) {
                return enc_levelVarArr[i];
            }
            int i2 = 0;
            while (true) {
                enc_level[] enc_levelVarArr2 = swigValues;
                if (i2 < enc_levelVarArr2.length) {
                    if (enc_levelVarArr2[i2].swigValue == i) {
                        return enc_levelVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + enc_level.class + " with value " + i);
                }
            }
        }

        private enc_level(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private enc_level(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private enc_level(String str, enc_level enc_levelVar) {
            this.swigName = str;
            int i = enc_levelVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }

    /* loaded from: classes2.dex */
    public static final class proxy_type_t {
        public static final proxy_type_t http;
        public static final proxy_type_t http_pw;
        public static final proxy_type_t i2p_proxy;
        public static final proxy_type_t none;
        public static final proxy_type_t socks4;
        public static final proxy_type_t socks5;
        public static final proxy_type_t socks5_pw;
        private static int swigNext;
        private static proxy_type_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            proxy_type_t proxy_type_tVar = new proxy_type_t("none");
            none = proxy_type_tVar;
            proxy_type_t proxy_type_tVar2 = new proxy_type_t("socks4");
            socks4 = proxy_type_tVar2;
            proxy_type_t proxy_type_tVar3 = new proxy_type_t("socks5");
            socks5 = proxy_type_tVar3;
            proxy_type_t proxy_type_tVar4 = new proxy_type_t("socks5_pw");
            socks5_pw = proxy_type_tVar4;
            proxy_type_t proxy_type_tVar5 = new proxy_type_t("http");
            http = proxy_type_tVar5;
            proxy_type_t proxy_type_tVar6 = new proxy_type_t("http_pw");
            http_pw = proxy_type_tVar6;
            proxy_type_t proxy_type_tVar7 = new proxy_type_t("i2p_proxy");
            i2p_proxy = proxy_type_tVar7;
            swigValues = new proxy_type_t[]{proxy_type_tVar, proxy_type_tVar2, proxy_type_tVar3, proxy_type_tVar4, proxy_type_tVar5, proxy_type_tVar6, proxy_type_tVar7};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static proxy_type_t swigToEnum(int i) {
            proxy_type_t[] proxy_type_tVarArr = swigValues;
            if (i < proxy_type_tVarArr.length && i >= 0 && proxy_type_tVarArr[i].swigValue == i) {
                return proxy_type_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                proxy_type_t[] proxy_type_tVarArr2 = swigValues;
                if (i2 < proxy_type_tVarArr2.length) {
                    if (proxy_type_tVarArr2[i2].swigValue == i) {
                        return proxy_type_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + proxy_type_t.class + " with value " + i);
                }
            }
        }

        private proxy_type_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private proxy_type_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private proxy_type_t(String str, proxy_type_t proxy_type_tVar) {
            this.swigName = str;
            int i = proxy_type_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
