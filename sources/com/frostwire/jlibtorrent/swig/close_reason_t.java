package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class close_reason_t {
    public static final close_reason_t blocked;
    public static final close_reason_t corrupt_pieces;
    public static final close_reason_t duplicate_peer_id;
    public static final close_reason_t encryption_error;
    public static final close_reason_t invalid_allow_fast_message;
    public static final close_reason_t invalid_bitfield_message;
    public static final close_reason_t invalid_cancel_message;
    public static final close_reason_t invalid_choke_message;
    public static final close_reason_t invalid_dht_port_message;
    public static final close_reason_t invalid_dont_have_message;
    public static final close_reason_t invalid_extended_message;
    public static final close_reason_t invalid_have_all_message;
    public static final close_reason_t invalid_have_message;
    public static final close_reason_t invalid_have_none_message;
    public static final close_reason_t invalid_info_hash;
    public static final close_reason_t invalid_interested_message;
    public static final close_reason_t invalid_message;
    public static final close_reason_t invalid_message_id;
    public static final close_reason_t invalid_metadata;
    public static final close_reason_t invalid_metadata_message;
    public static final close_reason_t invalid_metadata_offset;
    public static final close_reason_t invalid_metadata_request_message;
    public static final close_reason_t invalid_not_interested_message;
    public static final close_reason_t invalid_pex_message;
    public static final close_reason_t invalid_piece_message;
    public static final close_reason_t invalid_reject_message;
    public static final close_reason_t invalid_request_message;
    public static final close_reason_t invalid_suggest_message;
    public static final close_reason_t invalid_unchoke_message;
    public static final close_reason_t message_too_big;
    public static final close_reason_t metadata_too_big;
    public static final close_reason_t no_memory;
    public static final close_reason_t none;
    public static final close_reason_t not_interested_upload_only;
    public static final close_reason_t peer_churn;
    public static final close_reason_t pex_message_too_big;
    public static final close_reason_t pex_too_frequent;
    public static final close_reason_t port_blocked;
    public static final close_reason_t protocol_blocked;
    public static final close_reason_t request_when_choked;
    public static final close_reason_t self_connection;
    private static int swigNext;
    private static close_reason_t[] swigValues;
    public static final close_reason_t timed_out_activity;
    public static final close_reason_t timed_out_handshake;
    public static final close_reason_t timed_out_interest;
    public static final close_reason_t timed_out_request;
    public static final close_reason_t timeout;
    public static final close_reason_t too_many_connections;
    public static final close_reason_t too_many_files;
    public static final close_reason_t torrent_removed;
    public static final close_reason_t upload_to_upload;
    private final String swigName;
    private final int swigValue;

    static {
        close_reason_t close_reason_tVar = new close_reason_t("none", libtorrent_jni.close_reason_t_none_get());
        none = close_reason_tVar;
        close_reason_t close_reason_tVar2 = new close_reason_t("duplicate_peer_id");
        duplicate_peer_id = close_reason_tVar2;
        close_reason_t close_reason_tVar3 = new close_reason_t("torrent_removed");
        torrent_removed = close_reason_tVar3;
        close_reason_t close_reason_tVar4 = new close_reason_t("no_memory");
        no_memory = close_reason_tVar4;
        close_reason_t close_reason_tVar5 = new close_reason_t("port_blocked");
        port_blocked = close_reason_tVar5;
        close_reason_t close_reason_tVar6 = new close_reason_t("blocked");
        blocked = close_reason_tVar6;
        close_reason_t close_reason_tVar7 = new close_reason_t("upload_to_upload");
        upload_to_upload = close_reason_tVar7;
        close_reason_t close_reason_tVar8 = new close_reason_t("not_interested_upload_only");
        not_interested_upload_only = close_reason_tVar8;
        close_reason_t close_reason_tVar9 = new close_reason_t("timeout");
        timeout = close_reason_tVar9;
        close_reason_t close_reason_tVar10 = new close_reason_t("timed_out_interest");
        timed_out_interest = close_reason_tVar10;
        close_reason_t close_reason_tVar11 = new close_reason_t("timed_out_activity");
        timed_out_activity = close_reason_tVar11;
        close_reason_t close_reason_tVar12 = new close_reason_t("timed_out_handshake");
        timed_out_handshake = close_reason_tVar12;
        close_reason_t close_reason_tVar13 = new close_reason_t("timed_out_request");
        timed_out_request = close_reason_tVar13;
        close_reason_t close_reason_tVar14 = new close_reason_t("protocol_blocked");
        protocol_blocked = close_reason_tVar14;
        close_reason_t close_reason_tVar15 = new close_reason_t("peer_churn");
        peer_churn = close_reason_tVar15;
        close_reason_t close_reason_tVar16 = new close_reason_t("too_many_connections");
        too_many_connections = close_reason_tVar16;
        close_reason_t close_reason_tVar17 = new close_reason_t("too_many_files");
        too_many_files = close_reason_tVar17;
        close_reason_t close_reason_tVar18 = new close_reason_t("encryption_error", libtorrent_jni.close_reason_t_encryption_error_get());
        encryption_error = close_reason_tVar18;
        close_reason_t close_reason_tVar19 = new close_reason_t("invalid_info_hash");
        invalid_info_hash = close_reason_tVar19;
        close_reason_t close_reason_tVar20 = new close_reason_t("self_connection");
        self_connection = close_reason_tVar20;
        close_reason_t close_reason_tVar21 = new close_reason_t("invalid_metadata");
        invalid_metadata = close_reason_tVar21;
        close_reason_t close_reason_tVar22 = new close_reason_t("metadata_too_big");
        metadata_too_big = close_reason_tVar22;
        close_reason_t close_reason_tVar23 = new close_reason_t("message_too_big");
        message_too_big = close_reason_tVar23;
        close_reason_t close_reason_tVar24 = new close_reason_t("invalid_message_id");
        invalid_message_id = close_reason_tVar24;
        close_reason_t close_reason_tVar25 = new close_reason_t("invalid_message");
        invalid_message = close_reason_tVar25;
        close_reason_t close_reason_tVar26 = new close_reason_t("invalid_piece_message");
        invalid_piece_message = close_reason_tVar26;
        close_reason_t close_reason_tVar27 = new close_reason_t("invalid_have_message");
        invalid_have_message = close_reason_tVar27;
        close_reason_t close_reason_tVar28 = new close_reason_t("invalid_bitfield_message");
        invalid_bitfield_message = close_reason_tVar28;
        close_reason_t close_reason_tVar29 = new close_reason_t("invalid_choke_message");
        invalid_choke_message = close_reason_tVar29;
        close_reason_t close_reason_tVar30 = new close_reason_t("invalid_unchoke_message");
        invalid_unchoke_message = close_reason_tVar30;
        close_reason_t close_reason_tVar31 = new close_reason_t("invalid_interested_message");
        invalid_interested_message = close_reason_tVar31;
        close_reason_t close_reason_tVar32 = new close_reason_t("invalid_not_interested_message");
        invalid_not_interested_message = close_reason_tVar32;
        close_reason_t close_reason_tVar33 = new close_reason_t("invalid_request_message");
        invalid_request_message = close_reason_tVar33;
        close_reason_t close_reason_tVar34 = new close_reason_t("invalid_reject_message");
        invalid_reject_message = close_reason_tVar34;
        close_reason_t close_reason_tVar35 = new close_reason_t("invalid_allow_fast_message");
        invalid_allow_fast_message = close_reason_tVar35;
        close_reason_t close_reason_tVar36 = new close_reason_t("invalid_extended_message");
        invalid_extended_message = close_reason_tVar36;
        close_reason_t close_reason_tVar37 = new close_reason_t("invalid_cancel_message");
        invalid_cancel_message = close_reason_tVar37;
        close_reason_t close_reason_tVar38 = new close_reason_t("invalid_dht_port_message");
        invalid_dht_port_message = close_reason_tVar38;
        close_reason_t close_reason_tVar39 = new close_reason_t("invalid_suggest_message");
        invalid_suggest_message = close_reason_tVar39;
        close_reason_t close_reason_tVar40 = new close_reason_t("invalid_have_all_message");
        invalid_have_all_message = close_reason_tVar40;
        close_reason_t close_reason_tVar41 = new close_reason_t("invalid_dont_have_message");
        invalid_dont_have_message = close_reason_tVar41;
        close_reason_t close_reason_tVar42 = new close_reason_t("invalid_have_none_message");
        invalid_have_none_message = close_reason_tVar42;
        close_reason_t close_reason_tVar43 = new close_reason_t("invalid_pex_message");
        invalid_pex_message = close_reason_tVar43;
        close_reason_t close_reason_tVar44 = new close_reason_t("invalid_metadata_request_message");
        invalid_metadata_request_message = close_reason_tVar44;
        close_reason_t close_reason_tVar45 = new close_reason_t("invalid_metadata_message");
        invalid_metadata_message = close_reason_tVar45;
        close_reason_t close_reason_tVar46 = new close_reason_t("invalid_metadata_offset");
        invalid_metadata_offset = close_reason_tVar46;
        close_reason_t close_reason_tVar47 = new close_reason_t("request_when_choked");
        request_when_choked = close_reason_tVar47;
        close_reason_t close_reason_tVar48 = new close_reason_t("corrupt_pieces");
        corrupt_pieces = close_reason_tVar48;
        close_reason_t close_reason_tVar49 = new close_reason_t("pex_message_too_big");
        pex_message_too_big = close_reason_tVar49;
        close_reason_t close_reason_tVar50 = new close_reason_t("pex_too_frequent");
        pex_too_frequent = close_reason_tVar50;
        swigValues = new close_reason_t[]{close_reason_tVar, close_reason_tVar2, close_reason_tVar3, close_reason_tVar4, close_reason_tVar5, close_reason_tVar6, close_reason_tVar7, close_reason_tVar8, close_reason_tVar9, close_reason_tVar10, close_reason_tVar11, close_reason_tVar12, close_reason_tVar13, close_reason_tVar14, close_reason_tVar15, close_reason_tVar16, close_reason_tVar17, close_reason_tVar18, close_reason_tVar19, close_reason_tVar20, close_reason_tVar21, close_reason_tVar22, close_reason_tVar23, close_reason_tVar24, close_reason_tVar25, close_reason_tVar26, close_reason_tVar27, close_reason_tVar28, close_reason_tVar29, close_reason_tVar30, close_reason_tVar31, close_reason_tVar32, close_reason_tVar33, close_reason_tVar34, close_reason_tVar35, close_reason_tVar36, close_reason_tVar37, close_reason_tVar38, close_reason_tVar39, close_reason_tVar40, close_reason_tVar41, close_reason_tVar42, close_reason_tVar43, close_reason_tVar44, close_reason_tVar45, close_reason_tVar46, close_reason_tVar47, close_reason_tVar48, close_reason_tVar49, close_reason_tVar50};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static close_reason_t swigToEnum(int i) {
        close_reason_t[] close_reason_tVarArr = swigValues;
        if (i < close_reason_tVarArr.length && i >= 0 && close_reason_tVarArr[i].swigValue == i) {
            return close_reason_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            close_reason_t[] close_reason_tVarArr2 = swigValues;
            if (i2 < close_reason_tVarArr2.length) {
                if (close_reason_tVarArr2[i2].swigValue == i) {
                    return close_reason_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + close_reason_t.class + " with value " + i);
            }
        }
    }

    private close_reason_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private close_reason_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private close_reason_t(String str, close_reason_t close_reason_tVar) {
        this.swigName = str;
        int i = close_reason_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
