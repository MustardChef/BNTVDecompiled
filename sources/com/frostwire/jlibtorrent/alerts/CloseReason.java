package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.close_reason_t;

/* loaded from: classes2.dex */
public enum CloseReason {
    NONE(close_reason_t.none.swigValue()),
    DUPLICATE_PEER_ID(close_reason_t.duplicate_peer_id.swigValue()),
    TORRENT_REMOVED(close_reason_t.torrent_removed.swigValue()),
    NO_MEMORY(close_reason_t.no_memory.swigValue()),
    PORT_BLOCKED(close_reason_t.port_blocked.swigValue()),
    BLOCKED(close_reason_t.blocked.swigValue()),
    UPLOAD_TO_UPLOAD(close_reason_t.upload_to_upload.swigValue()),
    NOT_INTERESTED_UPLOAD_ONLY(close_reason_t.not_interested_upload_only.swigValue()),
    TIMEOUT(close_reason_t.timeout.swigValue()),
    TIMED_OUT_INTEREST(close_reason_t.timed_out_interest.swigValue()),
    TIMED_OUT_ACTIVITY(close_reason_t.timed_out_activity.swigValue()),
    TIMED_OUT_HANDSHAKE(close_reason_t.timed_out_handshake.swigValue()),
    TIMED_OUT_REQUEST(close_reason_t.timed_out_request.swigValue()),
    PROTOCOL_BLOCKED(close_reason_t.protocol_blocked.swigValue()),
    PEER_CHURN(close_reason_t.peer_churn.swigValue()),
    TOO_MANY_CONNECTIONS(close_reason_t.too_many_connections.swigValue()),
    TOO_MANY_FILES(close_reason_t.too_many_files.swigValue()),
    ENCRYPTION_ERROR(close_reason_t.encryption_error.swigValue()),
    INVALID_INFO_HASH(close_reason_t.invalid_info_hash.swigValue()),
    SELF_CONNECTION(close_reason_t.self_connection.swigValue()),
    INVALID_METADATA(close_reason_t.invalid_metadata.swigValue()),
    METADATA_TOO_BIG(close_reason_t.metadata_too_big.swigValue()),
    MESSAGE_TOO_BIG(close_reason_t.message_too_big.swigValue()),
    INVALID_MESSAGE_ID(close_reason_t.invalid_message_id.swigValue()),
    INVALID_MESSAGE(close_reason_t.invalid_message.swigValue()),
    INVALID_PIECE_MESSAGE(close_reason_t.invalid_piece_message.swigValue()),
    INVALID_HAVE_MESSAGE(close_reason_t.invalid_have_message.swigValue()),
    INVALID_BITFIELD_MESSAGE(close_reason_t.invalid_bitfield_message.swigValue()),
    INVALID_CHOKE_MESSAGE(close_reason_t.invalid_choke_message.swigValue()),
    INVALID_UNCHOKE_MESSAGE(close_reason_t.invalid_unchoke_message.swigValue()),
    INVALID_INTERESTED_MESSAGE(close_reason_t.invalid_interested_message.swigValue()),
    INVALID_NOT_INTERESTED_MESSAGE(close_reason_t.invalid_not_interested_message.swigValue()),
    INVALID_REQUEST_MESSAGE(close_reason_t.invalid_request_message.swigValue()),
    INVALID_REJECT_MESSAGE(close_reason_t.invalid_reject_message.swigValue()),
    INVALID_ALLOW_FAST_MESSAGE(close_reason_t.invalid_allow_fast_message.swigValue()),
    NVALID_EXTENDED_MESSAGE(close_reason_t.invalid_extended_message.swigValue()),
    INVALID_CANCEL_MESSAGE(close_reason_t.invalid_cancel_message.swigValue()),
    INVALID_DHT_PORT_MESSAGE(close_reason_t.invalid_dht_port_message.swigValue()),
    INVALID_SUGGEST_MESSAGE(close_reason_t.invalid_suggest_message.swigValue()),
    INVALID_HAVE_ALL_MESSAGE(close_reason_t.invalid_have_all_message.swigValue()),
    INVALID_DONT_HAVE_MESSAGE(close_reason_t.invalid_dont_have_message.swigValue()),
    INVALID_HAVE_NONE_MESSAGE(close_reason_t.invalid_have_none_message.swigValue()),
    INVALID_PEX_MESSAGE(close_reason_t.invalid_pex_message.swigValue()),
    INVALID_METADATA_REQUEST_MESSAGE(close_reason_t.invalid_metadata_request_message.swigValue()),
    INVALID_METADATA_MESSAGE(close_reason_t.invalid_metadata_message.swigValue()),
    INVALID_METADATA_OFFSET(close_reason_t.invalid_metadata_offset.swigValue()),
    REQUEST_WHEN_CHOKED(close_reason_t.request_when_choked.swigValue()),
    CORRUPT_PIECES(close_reason_t.corrupt_pieces.swigValue()),
    PEX_MESSAGE_TOO_BIG(close_reason_t.pex_message_too_big.swigValue()),
    PEX_TOO_FREQUENT(close_reason_t.pex_too_frequent.swigValue()),
    UNKNOWN(-1);
    
    private final int swigValue;

    CloseReason(int i) {
        this.swigValue = i;
    }

    public int swig() {
        return this.swigValue;
    }

    public static CloseReason fromSwig(int i) {
        CloseReason[] closeReasonArr;
        for (CloseReason closeReason : (CloseReason[]) CloseReason.class.getEnumConstants()) {
            if (closeReason.swig() == i) {
                return closeReason;
            }
        }
        return UNKNOWN;
    }
}
