package com.frostwire.jlibtorrent.swig;

import com.frostwire.jlibtorrent.swig.announce_entry;

/* loaded from: classes2.dex */
public class torrent_info {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public torrent_info(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(torrent_info torrent_infoVar) {
        if (torrent_infoVar == null) {
            return 0L;
        }
        return torrent_infoVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_torrent_info(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public torrent_info(torrent_info torrent_infoVar) {
        this(libtorrent_jni.new_torrent_info__SWIG_0(getCPtr(torrent_infoVar), torrent_infoVar), true);
    }

    public torrent_info(sha1_hash sha1_hashVar) {
        this(libtorrent_jni.new_torrent_info__SWIG_1(sha1_hash.getCPtr(sha1_hashVar), sha1_hashVar), true);
    }

    public torrent_info(bdecode_node bdecode_nodeVar, error_code error_codeVar) {
        this(libtorrent_jni.new_torrent_info__SWIG_2(bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }

    public torrent_info(String str, error_code error_codeVar) {
        this(libtorrent_jni.new_torrent_info__SWIG_3(str, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }

    public file_storage files() {
        return new file_storage(libtorrent_jni.torrent_info_files(this.swigCPtr, this), false);
    }

    public file_storage orig_files() {
        return new file_storage(libtorrent_jni.torrent_info_orig_files(this.swigCPtr, this), false);
    }

    public void rename_file(int i, String str) {
        libtorrent_jni.torrent_info_rename_file(this.swigCPtr, this, i, str);
    }

    public void remap_files(file_storage file_storageVar) {
        libtorrent_jni.torrent_info_remap_files(this.swigCPtr, this, file_storage.getCPtr(file_storageVar), file_storageVar);
    }

    public void add_tracker(String str, int i) {
        libtorrent_jni.torrent_info_add_tracker__SWIG_0(this.swigCPtr, this, str, i);
    }

    public void add_tracker(String str) {
        libtorrent_jni.torrent_info_add_tracker__SWIG_1(this.swigCPtr, this, str);
    }

    public void add_tracker(String str, int i, announce_entry.tracker_source tracker_sourceVar) {
        libtorrent_jni.torrent_info_add_tracker__SWIG_2(this.swigCPtr, this, str, i, tracker_sourceVar.swigValue());
    }

    public announce_entry_vector trackers() {
        return new announce_entry_vector(libtorrent_jni.torrent_info_trackers(this.swigCPtr, this), false);
    }

    public sha1_hash_vector similar_torrents() {
        return new sha1_hash_vector(libtorrent_jni.torrent_info_similar_torrents(this.swigCPtr, this), true);
    }

    public string_vector collections() {
        return new string_vector(libtorrent_jni.torrent_info_collections(this.swigCPtr, this), true);
    }

    public void add_url_seed(String str, String str2, string_string_pair_vector string_string_pair_vectorVar) {
        libtorrent_jni.torrent_info_add_url_seed__SWIG_0(this.swigCPtr, this, str, str2, string_string_pair_vector.getCPtr(string_string_pair_vectorVar), string_string_pair_vectorVar);
    }

    public void add_url_seed(String str, String str2) {
        libtorrent_jni.torrent_info_add_url_seed__SWIG_1(this.swigCPtr, this, str, str2);
    }

    public void add_url_seed(String str) {
        libtorrent_jni.torrent_info_add_url_seed__SWIG_2(this.swigCPtr, this, str);
    }

    public void add_http_seed(String str, String str2, string_string_pair_vector string_string_pair_vectorVar) {
        libtorrent_jni.torrent_info_add_http_seed__SWIG_0(this.swigCPtr, this, str, str2, string_string_pair_vector.getCPtr(string_string_pair_vectorVar), string_string_pair_vectorVar);
    }

    public void add_http_seed(String str, String str2) {
        libtorrent_jni.torrent_info_add_http_seed__SWIG_1(this.swigCPtr, this, str, str2);
    }

    public void add_http_seed(String str) {
        libtorrent_jni.torrent_info_add_http_seed__SWIG_2(this.swigCPtr, this, str);
    }

    public web_seed_entry_vector web_seeds() {
        return new web_seed_entry_vector(libtorrent_jni.torrent_info_web_seeds(this.swigCPtr, this), false);
    }

    public void set_web_seeds(web_seed_entry_vector web_seed_entry_vectorVar) {
        libtorrent_jni.torrent_info_set_web_seeds(this.swigCPtr, this, web_seed_entry_vector.getCPtr(web_seed_entry_vectorVar), web_seed_entry_vectorVar);
    }

    public long total_size() {
        return libtorrent_jni.torrent_info_total_size(this.swigCPtr, this);
    }

    public int piece_length() {
        return libtorrent_jni.torrent_info_piece_length(this.swigCPtr, this);
    }

    public int num_pieces() {
        return libtorrent_jni.torrent_info_num_pieces(this.swigCPtr, this);
    }

    public int last_piece() {
        return libtorrent_jni.torrent_info_last_piece(this.swigCPtr, this);
    }

    public int end_piece() {
        return libtorrent_jni.torrent_info_end_piece(this.swigCPtr, this);
    }

    public sha1_hash info_hash() {
        return new sha1_hash(libtorrent_jni.torrent_info_info_hash(this.swigCPtr, this), false);
    }

    public int num_files() {
        return libtorrent_jni.torrent_info_num_files(this.swigCPtr, this);
    }

    public file_slice_vector map_block(int i, long j, int i2) {
        return new file_slice_vector(libtorrent_jni.torrent_info_map_block(this.swigCPtr, this, i, j, i2), true);
    }

    public peer_request map_file(int i, long j, int i2) {
        return new peer_request(libtorrent_jni.torrent_info_map_file(this.swigCPtr, this, i, j, i2), true);
    }

    public string_view ssl_cert() {
        return new string_view(libtorrent_jni.torrent_info_ssl_cert(this.swigCPtr, this), true);
    }

    public boolean is_valid() {
        return libtorrent_jni.torrent_info_is_valid(this.swigCPtr, this);
    }

    public boolean priv() {
        return libtorrent_jni.torrent_info_priv(this.swigCPtr, this);
    }

    public boolean is_i2p() {
        return libtorrent_jni.torrent_info_is_i2p(this.swigCPtr, this);
    }

    public int piece_size(int i) {
        return libtorrent_jni.torrent_info_piece_size(this.swigCPtr, this, i);
    }

    public sha1_hash hash_for_piece(int i) {
        return new sha1_hash(libtorrent_jni.torrent_info_hash_for_piece(this.swigCPtr, this, i), true);
    }

    public boolean is_loaded() {
        return libtorrent_jni.torrent_info_is_loaded(this.swigCPtr, this);
    }

    public sha1_hash_vector merkle_tree() {
        return new sha1_hash_vector(libtorrent_jni.torrent_info_merkle_tree(this.swigCPtr, this), false);
    }

    public void set_merkle_tree(sha1_hash_vector sha1_hash_vectorVar) {
        libtorrent_jni.torrent_info_set_merkle_tree(this.swigCPtr, this, sha1_hash_vector.getCPtr(sha1_hash_vectorVar), sha1_hash_vectorVar);
    }

    public String name() {
        return libtorrent_jni.torrent_info_name(this.swigCPtr, this);
    }

    public long creation_date() {
        return libtorrent_jni.torrent_info_creation_date(this.swigCPtr, this);
    }

    public String creator() {
        return libtorrent_jni.torrent_info_creator(this.swigCPtr, this);
    }

    public String comment() {
        return libtorrent_jni.torrent_info_comment(this.swigCPtr, this);
    }

    public string_int_pair_vector nodes() {
        return new string_int_pair_vector(libtorrent_jni.torrent_info_nodes(this.swigCPtr, this), false);
    }

    public void add_node(string_int_pair string_int_pairVar) {
        libtorrent_jni.torrent_info_add_node(this.swigCPtr, this, string_int_pair.getCPtr(string_int_pairVar), string_int_pairVar);
    }

    public bdecode_node info(String str) {
        return new bdecode_node(libtorrent_jni.torrent_info_info(this.swigCPtr, this, str), true);
    }

    public int metadata_size() {
        return libtorrent_jni.torrent_info_metadata_size(this.swigCPtr, this);
    }

    public boolean is_merkle_torrent() {
        return libtorrent_jni.torrent_info_is_merkle_torrent(this.swigCPtr, this);
    }

    public torrent_info(long j, int i, error_code error_codeVar) {
        this(libtorrent_jni.new_torrent_info__SWIG_4(j, i, error_code.getCPtr(error_codeVar), error_codeVar), true);
    }
}
