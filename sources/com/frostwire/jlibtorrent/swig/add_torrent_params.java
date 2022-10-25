package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class add_torrent_params {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public add_torrent_params(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(add_torrent_params add_torrent_paramsVar) {
        if (add_torrent_paramsVar == null) {
            return 0L;
        }
        return add_torrent_paramsVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_add_torrent_params(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setVersion(int i) {
        libtorrent_jni.add_torrent_params_version_set(this.swigCPtr, this, i);
    }

    public int getVersion() {
        return libtorrent_jni.add_torrent_params_version_get(this.swigCPtr, this);
    }

    public void setName(String str) {
        libtorrent_jni.add_torrent_params_name_set(this.swigCPtr, this, str);
    }

    public String getName() {
        return libtorrent_jni.add_torrent_params_name_get(this.swigCPtr, this);
    }

    public void setSave_path(String str) {
        libtorrent_jni.add_torrent_params_save_path_set(this.swigCPtr, this, str);
    }

    public String getSave_path() {
        return libtorrent_jni.add_torrent_params_save_path_get(this.swigCPtr, this);
    }

    public void setStorage_mode(storage_mode_t storage_mode_tVar) {
        libtorrent_jni.add_torrent_params_storage_mode_set(this.swigCPtr, this, storage_mode_tVar.swigValue());
    }

    public storage_mode_t getStorage_mode() {
        return storage_mode_t.swigToEnum(libtorrent_jni.add_torrent_params_storage_mode_get(this.swigCPtr, this));
    }

    public void setTrackerid(String str) {
        libtorrent_jni.add_torrent_params_trackerid_set(this.swigCPtr, this, str);
    }

    public String getTrackerid() {
        return libtorrent_jni.add_torrent_params_trackerid_get(this.swigCPtr, this);
    }

    public void setFlags(torrent_flags_t torrent_flags_tVar) {
        libtorrent_jni.add_torrent_params_flags_set(this.swigCPtr, this, torrent_flags_t.getCPtr(torrent_flags_tVar), torrent_flags_tVar);
    }

    public torrent_flags_t getFlags() {
        long add_torrent_params_flags_get = libtorrent_jni.add_torrent_params_flags_get(this.swigCPtr, this);
        if (add_torrent_params_flags_get == 0) {
            return null;
        }
        return new torrent_flags_t(add_torrent_params_flags_get, false);
    }

    public void setInfo_hash(sha1_hash sha1_hashVar) {
        libtorrent_jni.add_torrent_params_info_hash_set(this.swigCPtr, this, sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar);
    }

    public sha1_hash getInfo_hash() {
        long add_torrent_params_info_hash_get = libtorrent_jni.add_torrent_params_info_hash_get(this.swigCPtr, this);
        if (add_torrent_params_info_hash_get == 0) {
            return null;
        }
        return new sha1_hash(add_torrent_params_info_hash_get, false);
    }

    public void setMax_uploads(int i) {
        libtorrent_jni.add_torrent_params_max_uploads_set(this.swigCPtr, this, i);
    }

    public int getMax_uploads() {
        return libtorrent_jni.add_torrent_params_max_uploads_get(this.swigCPtr, this);
    }

    public void setMax_connections(int i) {
        libtorrent_jni.add_torrent_params_max_connections_set(this.swigCPtr, this, i);
    }

    public int getMax_connections() {
        return libtorrent_jni.add_torrent_params_max_connections_get(this.swigCPtr, this);
    }

    public void setUpload_limit(int i) {
        libtorrent_jni.add_torrent_params_upload_limit_set(this.swigCPtr, this, i);
    }

    public int getUpload_limit() {
        return libtorrent_jni.add_torrent_params_upload_limit_get(this.swigCPtr, this);
    }

    public void setDownload_limit(int i) {
        libtorrent_jni.add_torrent_params_download_limit_set(this.swigCPtr, this, i);
    }

    public int getDownload_limit() {
        return libtorrent_jni.add_torrent_params_download_limit_get(this.swigCPtr, this);
    }

    public void setTotal_uploaded(long j) {
        libtorrent_jni.add_torrent_params_total_uploaded_set(this.swigCPtr, this, j);
    }

    public long getTotal_uploaded() {
        return libtorrent_jni.add_torrent_params_total_uploaded_get(this.swigCPtr, this);
    }

    public void setTotal_downloaded(long j) {
        libtorrent_jni.add_torrent_params_total_downloaded_set(this.swigCPtr, this, j);
    }

    public long getTotal_downloaded() {
        return libtorrent_jni.add_torrent_params_total_downloaded_get(this.swigCPtr, this);
    }

    public void setActive_time(int i) {
        libtorrent_jni.add_torrent_params_active_time_set(this.swigCPtr, this, i);
    }

    public int getActive_time() {
        return libtorrent_jni.add_torrent_params_active_time_get(this.swigCPtr, this);
    }

    public void setFinished_time(int i) {
        libtorrent_jni.add_torrent_params_finished_time_set(this.swigCPtr, this, i);
    }

    public int getFinished_time() {
        return libtorrent_jni.add_torrent_params_finished_time_get(this.swigCPtr, this);
    }

    public void setSeeding_time(int i) {
        libtorrent_jni.add_torrent_params_seeding_time_set(this.swigCPtr, this, i);
    }

    public int getSeeding_time() {
        return libtorrent_jni.add_torrent_params_seeding_time_get(this.swigCPtr, this);
    }

    public void setAdded_time(long j) {
        libtorrent_jni.add_torrent_params_added_time_set(this.swigCPtr, this, j);
    }

    public long getAdded_time() {
        return libtorrent_jni.add_torrent_params_added_time_get(this.swigCPtr, this);
    }

    public void setCompleted_time(long j) {
        libtorrent_jni.add_torrent_params_completed_time_set(this.swigCPtr, this, j);
    }

    public long getCompleted_time() {
        return libtorrent_jni.add_torrent_params_completed_time_get(this.swigCPtr, this);
    }

    public void setLast_seen_complete(long j) {
        libtorrent_jni.add_torrent_params_last_seen_complete_set(this.swigCPtr, this, j);
    }

    public long getLast_seen_complete() {
        return libtorrent_jni.add_torrent_params_last_seen_complete_get(this.swigCPtr, this);
    }

    public void setNum_complete(int i) {
        libtorrent_jni.add_torrent_params_num_complete_set(this.swigCPtr, this, i);
    }

    public int getNum_complete() {
        return libtorrent_jni.add_torrent_params_num_complete_get(this.swigCPtr, this);
    }

    public void setNum_incomplete(int i) {
        libtorrent_jni.add_torrent_params_num_incomplete_set(this.swigCPtr, this, i);
    }

    public int getNum_incomplete() {
        return libtorrent_jni.add_torrent_params_num_incomplete_get(this.swigCPtr, this);
    }

    public void setNum_downloaded(int i) {
        libtorrent_jni.add_torrent_params_num_downloaded_set(this.swigCPtr, this, i);
    }

    public int getNum_downloaded() {
        return libtorrent_jni.add_torrent_params_num_downloaded_get(this.swigCPtr, this);
    }

    public void setHave_pieces(piece_index_bitfield piece_index_bitfieldVar) {
        libtorrent_jni.add_torrent_params_have_pieces_set(this.swigCPtr, this, piece_index_bitfield.getCPtr(piece_index_bitfieldVar), piece_index_bitfieldVar);
    }

    public piece_index_bitfield getHave_pieces() {
        long add_torrent_params_have_pieces_get = libtorrent_jni.add_torrent_params_have_pieces_get(this.swigCPtr, this);
        if (add_torrent_params_have_pieces_get == 0) {
            return null;
        }
        return new piece_index_bitfield(add_torrent_params_have_pieces_get, false);
    }

    public void setVerified_pieces(piece_index_bitfield piece_index_bitfieldVar) {
        libtorrent_jni.add_torrent_params_verified_pieces_set(this.swigCPtr, this, piece_index_bitfield.getCPtr(piece_index_bitfieldVar), piece_index_bitfieldVar);
    }

    public piece_index_bitfield getVerified_pieces() {
        long add_torrent_params_verified_pieces_get = libtorrent_jni.add_torrent_params_verified_pieces_get(this.swigCPtr, this);
        if (add_torrent_params_verified_pieces_get == 0) {
            return null;
        }
        return new piece_index_bitfield(add_torrent_params_verified_pieces_get, false);
    }

    public void setLast_download(long j) {
        libtorrent_jni.add_torrent_params_last_download_set(this.swigCPtr, this, j);
    }

    public long getLast_download() {
        return libtorrent_jni.add_torrent_params_last_download_get(this.swigCPtr, this);
    }

    public void setLast_upload(long j) {
        libtorrent_jni.add_torrent_params_last_upload_set(this.swigCPtr, this, j);
    }

    public long getLast_upload() {
        return libtorrent_jni.add_torrent_params_last_upload_get(this.swigCPtr, this);
    }

    public torrent_info ti_ptr() {
        long add_torrent_params_ti_ptr = libtorrent_jni.add_torrent_params_ti_ptr(this.swigCPtr, this);
        if (add_torrent_params_ti_ptr == 0) {
            return null;
        }
        return new torrent_info(add_torrent_params_ti_ptr, false);
    }

    public void set_ti(torrent_info torrent_infoVar) {
        libtorrent_jni.add_torrent_params_set_ti(this.swigCPtr, this, torrent_info.getCPtr(torrent_infoVar), torrent_infoVar);
    }

    public void set_renamed_files(file_index_string_map file_index_string_mapVar) {
        libtorrent_jni.add_torrent_params_set_renamed_files(this.swigCPtr, this, file_index_string_map.getCPtr(file_index_string_mapVar), file_index_string_mapVar);
    }

    public int_vector get_tracker_tiers() {
        return new int_vector(libtorrent_jni.add_torrent_params_get_tracker_tiers(this.swigCPtr, this), true);
    }

    public void set_tracker_tiers(int_vector int_vectorVar) {
        libtorrent_jni.add_torrent_params_set_tracker_tiers(this.swigCPtr, this, int_vector.getCPtr(int_vectorVar), int_vectorVar);
    }

    public void set_merkle_tree(sha1_hash_vector sha1_hash_vectorVar) {
        libtorrent_jni.add_torrent_params_set_merkle_tree(this.swigCPtr, this, sha1_hash_vector.getCPtr(sha1_hash_vectorVar), sha1_hash_vectorVar);
    }

    public tcp_endpoint_vector get_banned_peers() {
        return new tcp_endpoint_vector(libtorrent_jni.add_torrent_params_get_banned_peers(this.swigCPtr, this), true);
    }

    public void set_banned_peers(tcp_endpoint_vector tcp_endpoint_vectorVar) {
        libtorrent_jni.add_torrent_params_set_banned_peers(this.swigCPtr, this, tcp_endpoint_vector.getCPtr(tcp_endpoint_vectorVar), tcp_endpoint_vectorVar);
    }

    public tcp_endpoint_vector get_peers() {
        return new tcp_endpoint_vector(libtorrent_jni.add_torrent_params_get_peers(this.swigCPtr, this), true);
    }

    public void set_peers(tcp_endpoint_vector tcp_endpoint_vectorVar) {
        libtorrent_jni.add_torrent_params_set_peers(this.swigCPtr, this, tcp_endpoint_vector.getCPtr(tcp_endpoint_vectorVar), tcp_endpoint_vectorVar);
    }

    public void set_file_priorities2(byte_vector byte_vectorVar) {
        libtorrent_jni.add_torrent_params_set_file_priorities2(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public string_int_pair_vector get_dht_nodes() {
        return new string_int_pair_vector(libtorrent_jni.add_torrent_params_get_dht_nodes(this.swigCPtr, this), true);
    }

    public void set_dht_nodes(string_int_pair_vector string_int_pair_vectorVar) {
        libtorrent_jni.add_torrent_params_set_dht_nodes(this.swigCPtr, this, string_int_pair_vector.getCPtr(string_int_pair_vectorVar), string_int_pair_vectorVar);
    }

    public void set_http_seeds(string_vector string_vectorVar) {
        libtorrent_jni.add_torrent_params_set_http_seeds(this.swigCPtr, this, string_vector.getCPtr(string_vectorVar), string_vectorVar);
    }

    public string_vector get_url_seeds() {
        return new string_vector(libtorrent_jni.add_torrent_params_get_url_seeds(this.swigCPtr, this), true);
    }

    public void set_url_seeds(string_vector string_vectorVar) {
        libtorrent_jni.add_torrent_params_set_url_seeds(this.swigCPtr, this, string_vector.getCPtr(string_vectorVar), string_vectorVar);
    }

    public string_vector get_trackers() {
        return new string_vector(libtorrent_jni.add_torrent_params_get_trackers(this.swigCPtr, this), true);
    }

    public void set_trackers(string_vector string_vectorVar) {
        libtorrent_jni.add_torrent_params_set_trackers(this.swigCPtr, this, string_vector.getCPtr(string_vectorVar), string_vectorVar);
    }

    public void set_piece_priorities2(byte_vector byte_vectorVar) {
        libtorrent_jni.add_torrent_params_set_piece_priorities2(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public static add_torrent_params create_instance() {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_create_instance(), true);
    }

    public static add_torrent_params create_instance_disabled_storage() {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_create_instance_disabled_storage(), true);
    }

    public static add_torrent_params create_instance_zero_storage() {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_create_instance_zero_storage(), true);
    }

    public void set_default_storage() {
        libtorrent_jni.add_torrent_params_set_default_storage(this.swigCPtr, this);
    }

    public void set_disabled_storage() {
        libtorrent_jni.add_torrent_params_set_disabled_storage(this.swigCPtr, this);
    }

    public void set_zero_storage() {
        libtorrent_jni.add_torrent_params_set_zero_storage(this.swigCPtr, this);
    }

    public static add_torrent_params read_resume_data(bdecode_node bdecode_nodeVar, error_code error_codeVar) {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_read_resume_data__SWIG_0(bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }

    public static add_torrent_params read_resume_data(byte_vector byte_vectorVar, error_code error_codeVar) {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_read_resume_data__SWIG_1(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }

    public static entry write_resume_data(add_torrent_params add_torrent_paramsVar) {
        return new entry(libtorrent_jni.add_torrent_params_write_resume_data(getCPtr(add_torrent_paramsVar), add_torrent_paramsVar), true);
    }

    public static byte_vector write_resume_data_buf(add_torrent_params add_torrent_paramsVar) {
        return new byte_vector(libtorrent_jni.add_torrent_params_write_resume_data_buf(getCPtr(add_torrent_paramsVar), add_torrent_paramsVar), true);
    }

    public static add_torrent_params parse_magnet_uri(String str, error_code error_codeVar) {
        return new add_torrent_params(libtorrent_jni.add_torrent_params_parse_magnet_uri(str, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }
}
