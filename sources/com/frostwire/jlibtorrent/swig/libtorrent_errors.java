package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class libtorrent_errors {
    private final String swigName;
    private final int swigValue;
    public static final libtorrent_errors libtorrent_no_error = new libtorrent_errors("libtorrent_no_error", libtorrent_jni.libtorrent_no_error_get());
    public static final libtorrent_errors file_collision = new libtorrent_errors("file_collision");
    public static final libtorrent_errors failed_hash_check = new libtorrent_errors("failed_hash_check");
    public static final libtorrent_errors torrent_is_no_dict = new libtorrent_errors("torrent_is_no_dict");
    public static final libtorrent_errors torrent_missing_info = new libtorrent_errors("torrent_missing_info");
    public static final libtorrent_errors torrent_info_no_dict = new libtorrent_errors("torrent_info_no_dict");
    public static final libtorrent_errors torrent_missing_piece_length = new libtorrent_errors("torrent_missing_piece_length");
    public static final libtorrent_errors torrent_missing_name = new libtorrent_errors("torrent_missing_name");
    public static final libtorrent_errors torrent_invalid_name = new libtorrent_errors("torrent_invalid_name");
    public static final libtorrent_errors torrent_invalid_length = new libtorrent_errors("torrent_invalid_length");
    public static final libtorrent_errors torrent_file_parse_failed = new libtorrent_errors("torrent_file_parse_failed");
    public static final libtorrent_errors torrent_missing_pieces = new libtorrent_errors("torrent_missing_pieces");
    public static final libtorrent_errors torrent_invalid_hashes = new libtorrent_errors("torrent_invalid_hashes");
    public static final libtorrent_errors too_many_pieces_in_torrent = new libtorrent_errors("too_many_pieces_in_torrent");
    public static final libtorrent_errors invalid_swarm_metadata = new libtorrent_errors("invalid_swarm_metadata");
    public static final libtorrent_errors invalid_bencoding = new libtorrent_errors("invalid_bencoding");
    public static final libtorrent_errors no_files_in_torrent = new libtorrent_errors("no_files_in_torrent");
    public static final libtorrent_errors invalid_escaped_string = new libtorrent_errors("invalid_escaped_string");
    public static final libtorrent_errors session_is_closing = new libtorrent_errors("session_is_closing");
    public static final libtorrent_errors duplicate_torrent = new libtorrent_errors("duplicate_torrent");
    public static final libtorrent_errors invalid_torrent_handle = new libtorrent_errors("invalid_torrent_handle");
    public static final libtorrent_errors invalid_entry_type = new libtorrent_errors("invalid_entry_type");
    public static final libtorrent_errors missing_info_hash_in_uri = new libtorrent_errors("missing_info_hash_in_uri");
    public static final libtorrent_errors file_too_short = new libtorrent_errors("file_too_short");
    public static final libtorrent_errors unsupported_url_protocol = new libtorrent_errors("unsupported_url_protocol");
    public static final libtorrent_errors url_parse_error = new libtorrent_errors("url_parse_error");
    public static final libtorrent_errors peer_sent_empty_piece = new libtorrent_errors("peer_sent_empty_piece");
    public static final libtorrent_errors parse_failed = new libtorrent_errors("parse_failed");
    public static final libtorrent_errors invalid_file_tag = new libtorrent_errors("invalid_file_tag");
    public static final libtorrent_errors missing_info_hash = new libtorrent_errors("missing_info_hash");
    public static final libtorrent_errors mismatching_info_hash = new libtorrent_errors("mismatching_info_hash");
    public static final libtorrent_errors invalid_hostname = new libtorrent_errors("invalid_hostname");
    public static final libtorrent_errors invalid_port = new libtorrent_errors("invalid_port");
    public static final libtorrent_errors port_blocked = new libtorrent_errors("port_blocked");
    public static final libtorrent_errors expected_close_bracket_in_address = new libtorrent_errors("expected_close_bracket_in_address");
    public static final libtorrent_errors destructing_torrent = new libtorrent_errors("destructing_torrent");
    public static final libtorrent_errors timed_out = new libtorrent_errors("timed_out");
    public static final libtorrent_errors upload_upload_connection = new libtorrent_errors("upload_upload_connection");
    public static final libtorrent_errors uninteresting_upload_peer = new libtorrent_errors("uninteresting_upload_peer");
    public static final libtorrent_errors invalid_info_hash = new libtorrent_errors("invalid_info_hash");
    public static final libtorrent_errors torrent_paused = new libtorrent_errors("torrent_paused");
    public static final libtorrent_errors invalid_have = new libtorrent_errors("invalid_have");
    public static final libtorrent_errors invalid_bitfield_size = new libtorrent_errors("invalid_bitfield_size");
    public static final libtorrent_errors too_many_requests_when_choked = new libtorrent_errors("too_many_requests_when_choked");
    public static final libtorrent_errors invalid_piece = new libtorrent_errors("invalid_piece");
    public static final libtorrent_errors no_memory = new libtorrent_errors("no_memory");
    public static final libtorrent_errors torrent_aborted = new libtorrent_errors("torrent_aborted");
    public static final libtorrent_errors self_connection = new libtorrent_errors("self_connection");
    public static final libtorrent_errors invalid_piece_size = new libtorrent_errors("invalid_piece_size");
    public static final libtorrent_errors timed_out_no_interest = new libtorrent_errors("timed_out_no_interest");
    public static final libtorrent_errors timed_out_inactivity = new libtorrent_errors("timed_out_inactivity");
    public static final libtorrent_errors timed_out_no_handshake = new libtorrent_errors("timed_out_no_handshake");
    public static final libtorrent_errors timed_out_no_request = new libtorrent_errors("timed_out_no_request");
    public static final libtorrent_errors invalid_choke = new libtorrent_errors("invalid_choke");
    public static final libtorrent_errors invalid_unchoke = new libtorrent_errors("invalid_unchoke");
    public static final libtorrent_errors invalid_interested = new libtorrent_errors("invalid_interested");
    public static final libtorrent_errors invalid_not_interested = new libtorrent_errors("invalid_not_interested");
    public static final libtorrent_errors invalid_request = new libtorrent_errors("invalid_request");
    public static final libtorrent_errors invalid_hash_list = new libtorrent_errors("invalid_hash_list");
    public static final libtorrent_errors invalid_hash_piece = new libtorrent_errors("invalid_hash_piece");
    public static final libtorrent_errors invalid_cancel = new libtorrent_errors("invalid_cancel");
    public static final libtorrent_errors invalid_dht_port = new libtorrent_errors("invalid_dht_port");
    public static final libtorrent_errors invalid_suggest = new libtorrent_errors("invalid_suggest");
    public static final libtorrent_errors invalid_have_all = new libtorrent_errors("invalid_have_all");
    public static final libtorrent_errors invalid_have_none = new libtorrent_errors("invalid_have_none");
    public static final libtorrent_errors invalid_reject = new libtorrent_errors("invalid_reject");
    public static final libtorrent_errors invalid_allow_fast = new libtorrent_errors("invalid_allow_fast");
    public static final libtorrent_errors invalid_extended = new libtorrent_errors("invalid_extended");
    public static final libtorrent_errors invalid_message = new libtorrent_errors("invalid_message");
    public static final libtorrent_errors sync_hash_not_found = new libtorrent_errors("sync_hash_not_found");
    public static final libtorrent_errors invalid_encryption_constant = new libtorrent_errors("invalid_encryption_constant");
    public static final libtorrent_errors no_plaintext_mode = new libtorrent_errors("no_plaintext_mode");
    public static final libtorrent_errors no_rc4_mode = new libtorrent_errors("no_rc4_mode");
    public static final libtorrent_errors unsupported_encryption_mode = new libtorrent_errors("unsupported_encryption_mode");
    public static final libtorrent_errors unsupported_encryption_mode_selected = new libtorrent_errors("unsupported_encryption_mode_selected");
    public static final libtorrent_errors invalid_pad_size = new libtorrent_errors("invalid_pad_size");
    public static final libtorrent_errors invalid_encrypt_handshake = new libtorrent_errors("invalid_encrypt_handshake");
    public static final libtorrent_errors no_incoming_encrypted = new libtorrent_errors("no_incoming_encrypted");
    public static final libtorrent_errors no_incoming_regular = new libtorrent_errors("no_incoming_regular");
    public static final libtorrent_errors duplicate_peer_id = new libtorrent_errors("duplicate_peer_id");
    public static final libtorrent_errors torrent_removed = new libtorrent_errors("torrent_removed");
    public static final libtorrent_errors packet_too_large = new libtorrent_errors("packet_too_large");
    public static final libtorrent_errors reserved = new libtorrent_errors("reserved");
    public static final libtorrent_errors http_error = new libtorrent_errors("http_error");
    public static final libtorrent_errors missing_location = new libtorrent_errors("missing_location");
    public static final libtorrent_errors invalid_redirection = new libtorrent_errors("invalid_redirection");
    public static final libtorrent_errors redirecting = new libtorrent_errors("redirecting");
    public static final libtorrent_errors invalid_range = new libtorrent_errors("invalid_range");
    public static final libtorrent_errors no_content_length = new libtorrent_errors("no_content_length");
    public static final libtorrent_errors banned_by_ip_filter = new libtorrent_errors("banned_by_ip_filter");
    public static final libtorrent_errors too_many_connections = new libtorrent_errors("too_many_connections");
    public static final libtorrent_errors peer_banned = new libtorrent_errors("peer_banned");
    public static final libtorrent_errors stopping_torrent = new libtorrent_errors("stopping_torrent");
    public static final libtorrent_errors too_many_corrupt_pieces = new libtorrent_errors("too_many_corrupt_pieces");
    public static final libtorrent_errors torrent_not_ready = new libtorrent_errors("torrent_not_ready");
    public static final libtorrent_errors peer_not_constructed = new libtorrent_errors("peer_not_constructed");
    public static final libtorrent_errors session_closing = new libtorrent_errors("session_closing");
    public static final libtorrent_errors optimistic_disconnect = new libtorrent_errors("optimistic_disconnect");
    public static final libtorrent_errors torrent_finished = new libtorrent_errors("torrent_finished");
    public static final libtorrent_errors no_router = new libtorrent_errors("no_router");
    public static final libtorrent_errors metadata_too_large = new libtorrent_errors("metadata_too_large");
    public static final libtorrent_errors invalid_metadata_request = new libtorrent_errors("invalid_metadata_request");
    public static final libtorrent_errors invalid_metadata_size = new libtorrent_errors("invalid_metadata_size");
    public static final libtorrent_errors invalid_metadata_offset = new libtorrent_errors("invalid_metadata_offset");
    public static final libtorrent_errors invalid_metadata_message = new libtorrent_errors("invalid_metadata_message");
    public static final libtorrent_errors pex_message_too_large = new libtorrent_errors("pex_message_too_large");
    public static final libtorrent_errors invalid_pex_message = new libtorrent_errors("invalid_pex_message");
    public static final libtorrent_errors invalid_lt_tracker_message = new libtorrent_errors("invalid_lt_tracker_message");
    public static final libtorrent_errors too_frequent_pex = new libtorrent_errors("too_frequent_pex");
    public static final libtorrent_errors no_metadata = new libtorrent_errors("no_metadata");
    public static final libtorrent_errors invalid_dont_have = new libtorrent_errors("invalid_dont_have");
    public static final libtorrent_errors requires_ssl_connection = new libtorrent_errors("requires_ssl_connection");
    public static final libtorrent_errors invalid_ssl_cert = new libtorrent_errors("invalid_ssl_cert");
    public static final libtorrent_errors not_an_ssl_torrent = new libtorrent_errors("not_an_ssl_torrent");
    public static final libtorrent_errors banned_by_port_filter = new libtorrent_errors("banned_by_port_filter");
    public static final libtorrent_errors invalid_session_handle = new libtorrent_errors("invalid_session_handle");
    public static final libtorrent_errors invalid_listen_socket = new libtorrent_errors("invalid_listen_socket");
    public static final libtorrent_errors missing_file_sizes = new libtorrent_errors("missing_file_sizes", libtorrent_jni.missing_file_sizes_get());
    public static final libtorrent_errors no_files_in_resume_data = new libtorrent_errors("no_files_in_resume_data");
    public static final libtorrent_errors missing_pieces = new libtorrent_errors("missing_pieces");
    public static final libtorrent_errors mismatching_number_of_files = new libtorrent_errors("mismatching_number_of_files");
    public static final libtorrent_errors mismatching_file_size = new libtorrent_errors("mismatching_file_size");
    public static final libtorrent_errors mismatching_file_timestamp = new libtorrent_errors("mismatching_file_timestamp");
    public static final libtorrent_errors not_a_dictionary = new libtorrent_errors("not_a_dictionary");
    public static final libtorrent_errors invalid_blocks_per_piece = new libtorrent_errors("invalid_blocks_per_piece");
    public static final libtorrent_errors missing_slots = new libtorrent_errors("missing_slots");
    public static final libtorrent_errors too_many_slots = new libtorrent_errors("too_many_slots");
    public static final libtorrent_errors invalid_slot_list = new libtorrent_errors("invalid_slot_list");
    public static final libtorrent_errors invalid_piece_index = new libtorrent_errors("invalid_piece_index");
    public static final libtorrent_errors pieces_need_reorder = new libtorrent_errors("pieces_need_reorder");
    public static final libtorrent_errors resume_data_not_modified = new libtorrent_errors("resume_data_not_modified");
    public static final libtorrent_errors http_parse_error = new libtorrent_errors("http_parse_error", libtorrent_jni.http_parse_error_get());
    public static final libtorrent_errors http_missing_location = new libtorrent_errors("http_missing_location");
    public static final libtorrent_errors http_failed_decompress = new libtorrent_errors("http_failed_decompress");
    public static final libtorrent_errors no_i2p_router = new libtorrent_errors("no_i2p_router", libtorrent_jni.no_i2p_router_get());
    public static final libtorrent_errors no_i2p_endpoint = new libtorrent_errors("no_i2p_endpoint", libtorrent_jni.no_i2p_endpoint_get());
    public static final libtorrent_errors scrape_not_available = new libtorrent_errors("scrape_not_available", libtorrent_jni.scrape_not_available_get());
    public static final libtorrent_errors invalid_tracker_response = new libtorrent_errors("invalid_tracker_response");
    public static final libtorrent_errors invalid_peer_dict = new libtorrent_errors("invalid_peer_dict");
    public static final libtorrent_errors tracker_failure = new libtorrent_errors("tracker_failure");
    public static final libtorrent_errors invalid_files_entry = new libtorrent_errors("invalid_files_entry");
    public static final libtorrent_errors invalid_hash_entry = new libtorrent_errors("invalid_hash_entry");
    public static final libtorrent_errors invalid_peers_entry = new libtorrent_errors("invalid_peers_entry");
    public static final libtorrent_errors invalid_tracker_response_length = new libtorrent_errors("invalid_tracker_response_length");
    public static final libtorrent_errors invalid_tracker_transaction_id = new libtorrent_errors("invalid_tracker_transaction_id");
    public static final libtorrent_errors invalid_tracker_action = new libtorrent_errors("invalid_tracker_action");
    public static final libtorrent_errors no_entropy = new libtorrent_errors("no_entropy", libtorrent_jni.no_entropy_get());
    public static final libtorrent_errors error_code_max = new libtorrent_errors("error_code_max");
    private static libtorrent_errors[] swigValues = {libtorrent_no_error, file_collision, failed_hash_check, torrent_is_no_dict, torrent_missing_info, torrent_info_no_dict, torrent_missing_piece_length, torrent_missing_name, torrent_invalid_name, torrent_invalid_length, torrent_file_parse_failed, torrent_missing_pieces, torrent_invalid_hashes, too_many_pieces_in_torrent, invalid_swarm_metadata, invalid_bencoding, no_files_in_torrent, invalid_escaped_string, session_is_closing, duplicate_torrent, invalid_torrent_handle, invalid_entry_type, missing_info_hash_in_uri, file_too_short, unsupported_url_protocol, url_parse_error, peer_sent_empty_piece, parse_failed, invalid_file_tag, missing_info_hash, mismatching_info_hash, invalid_hostname, invalid_port, port_blocked, expected_close_bracket_in_address, destructing_torrent, timed_out, upload_upload_connection, uninteresting_upload_peer, invalid_info_hash, torrent_paused, invalid_have, invalid_bitfield_size, too_many_requests_when_choked, invalid_piece, no_memory, torrent_aborted, self_connection, invalid_piece_size, timed_out_no_interest, timed_out_inactivity, timed_out_no_handshake, timed_out_no_request, invalid_choke, invalid_unchoke, invalid_interested, invalid_not_interested, invalid_request, invalid_hash_list, invalid_hash_piece, invalid_cancel, invalid_dht_port, invalid_suggest, invalid_have_all, invalid_have_none, invalid_reject, invalid_allow_fast, invalid_extended, invalid_message, sync_hash_not_found, invalid_encryption_constant, no_plaintext_mode, no_rc4_mode, unsupported_encryption_mode, unsupported_encryption_mode_selected, invalid_pad_size, invalid_encrypt_handshake, no_incoming_encrypted, no_incoming_regular, duplicate_peer_id, torrent_removed, packet_too_large, reserved, http_error, missing_location, invalid_redirection, redirecting, invalid_range, no_content_length, banned_by_ip_filter, too_many_connections, peer_banned, stopping_torrent, too_many_corrupt_pieces, torrent_not_ready, peer_not_constructed, session_closing, optimistic_disconnect, torrent_finished, no_router, metadata_too_large, invalid_metadata_request, invalid_metadata_size, invalid_metadata_offset, invalid_metadata_message, pex_message_too_large, invalid_pex_message, invalid_lt_tracker_message, too_frequent_pex, no_metadata, invalid_dont_have, requires_ssl_connection, invalid_ssl_cert, not_an_ssl_torrent, banned_by_port_filter, invalid_session_handle, invalid_listen_socket, missing_file_sizes, no_files_in_resume_data, missing_pieces, mismatching_number_of_files, mismatching_file_size, mismatching_file_timestamp, not_a_dictionary, invalid_blocks_per_piece, missing_slots, too_many_slots, invalid_slot_list, invalid_piece_index, pieces_need_reorder, resume_data_not_modified, http_parse_error, http_missing_location, http_failed_decompress, no_i2p_router, no_i2p_endpoint, scrape_not_available, invalid_tracker_response, invalid_peer_dict, tracker_failure, invalid_files_entry, invalid_hash_entry, invalid_peers_entry, invalid_tracker_response_length, invalid_tracker_transaction_id, invalid_tracker_action, no_entropy, error_code_max};
    private static int swigNext = 0;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static libtorrent_errors swigToEnum(int i) {
        libtorrent_errors[] libtorrent_errorsVarArr = swigValues;
        if (i < libtorrent_errorsVarArr.length && i >= 0 && libtorrent_errorsVarArr[i].swigValue == i) {
            return libtorrent_errorsVarArr[i];
        }
        int i2 = 0;
        while (true) {
            libtorrent_errors[] libtorrent_errorsVarArr2 = swigValues;
            if (i2 < libtorrent_errorsVarArr2.length) {
                if (libtorrent_errorsVarArr2[i2].swigValue == i) {
                    return libtorrent_errorsVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + libtorrent_errors.class + " with value " + i);
            }
        }
    }

    private libtorrent_errors(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private libtorrent_errors(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private libtorrent_errors(String str, libtorrent_errors libtorrent_errorsVar) {
        this.swigName = str;
        int i = libtorrent_errorsVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
