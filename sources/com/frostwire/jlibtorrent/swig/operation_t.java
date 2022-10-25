package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class operation_t {
    public static final operation_t alloc_cache_piece;
    public static final operation_t alloc_recvbuf;
    public static final operation_t alloc_sndbuf;
    public static final operation_t available;
    public static final operation_t bittorrent;
    public static final operation_t check_resume;
    public static final operation_t connect;
    public static final operation_t encryption;
    public static final operation_t enum_if;
    public static final operation_t enum_route;
    public static final operation_t exception;
    public static final operation_t file;
    public static final operation_t file_copy;
    public static final operation_t file_fallocate;
    public static final operation_t file_hard_link;
    public static final operation_t file_open;
    public static final operation_t file_read;
    public static final operation_t file_remove;
    public static final operation_t file_rename;
    public static final operation_t file_stat;
    public static final operation_t file_write;
    public static final operation_t get_interface;
    public static final operation_t getname;
    public static final operation_t getpeername;
    public static final operation_t handshake;
    public static final operation_t hostname_lookup;
    public static final operation_t iocontrol;
    public static final operation_t mkdir;
    public static final operation_t parse_address;
    public static final operation_t partfile_move;
    public static final operation_t partfile_read;
    public static final operation_t partfile_write;
    public static final operation_t sock_accept;
    public static final operation_t sock_bind;
    public static final operation_t sock_bind_to_device;
    public static final operation_t sock_listen;
    public static final operation_t sock_open;
    public static final operation_t sock_option;
    public static final operation_t sock_read;
    public static final operation_t sock_write;
    public static final operation_t ssl_handshake;
    private static int swigNext;
    private static operation_t[] swigValues;
    public static final operation_t symlink;
    public static final operation_t unknown;
    private final String swigName;
    private final int swigValue;

    static {
        operation_t operation_tVar = new operation_t("unknown");
        unknown = operation_tVar;
        operation_t operation_tVar2 = new operation_t("bittorrent");
        bittorrent = operation_tVar2;
        operation_t operation_tVar3 = new operation_t("iocontrol");
        iocontrol = operation_tVar3;
        operation_t operation_tVar4 = new operation_t("getpeername");
        getpeername = operation_tVar4;
        operation_t operation_tVar5 = new operation_t("getname");
        getname = operation_tVar5;
        operation_t operation_tVar6 = new operation_t("alloc_recvbuf");
        alloc_recvbuf = operation_tVar6;
        operation_t operation_tVar7 = new operation_t("alloc_sndbuf");
        alloc_sndbuf = operation_tVar7;
        operation_t operation_tVar8 = new operation_t("file_write");
        file_write = operation_tVar8;
        operation_t operation_tVar9 = new operation_t("file_read");
        file_read = operation_tVar9;
        operation_t operation_tVar10 = new operation_t("file");
        file = operation_tVar10;
        operation_t operation_tVar11 = new operation_t("sock_write");
        sock_write = operation_tVar11;
        operation_t operation_tVar12 = new operation_t("sock_read");
        sock_read = operation_tVar12;
        operation_t operation_tVar13 = new operation_t("sock_open");
        sock_open = operation_tVar13;
        operation_t operation_tVar14 = new operation_t("sock_bind");
        sock_bind = operation_tVar14;
        operation_t operation_tVar15 = new operation_t("available");
        available = operation_tVar15;
        operation_t operation_tVar16 = new operation_t("encryption");
        encryption = operation_tVar16;
        operation_t operation_tVar17 = new operation_t("connect");
        connect = operation_tVar17;
        operation_t operation_tVar18 = new operation_t("ssl_handshake");
        ssl_handshake = operation_tVar18;
        operation_t operation_tVar19 = new operation_t("get_interface");
        get_interface = operation_tVar19;
        operation_t operation_tVar20 = new operation_t("sock_listen");
        sock_listen = operation_tVar20;
        operation_t operation_tVar21 = new operation_t("sock_bind_to_device");
        sock_bind_to_device = operation_tVar21;
        operation_t operation_tVar22 = new operation_t("sock_accept");
        sock_accept = operation_tVar22;
        operation_t operation_tVar23 = new operation_t("parse_address");
        parse_address = operation_tVar23;
        operation_t operation_tVar24 = new operation_t("enum_if");
        enum_if = operation_tVar24;
        operation_t operation_tVar25 = new operation_t("file_stat");
        file_stat = operation_tVar25;
        operation_t operation_tVar26 = new operation_t("file_copy");
        file_copy = operation_tVar26;
        operation_t operation_tVar27 = new operation_t("file_fallocate");
        file_fallocate = operation_tVar27;
        operation_t operation_tVar28 = new operation_t("file_hard_link");
        file_hard_link = operation_tVar28;
        operation_t operation_tVar29 = new operation_t("file_remove");
        file_remove = operation_tVar29;
        operation_t operation_tVar30 = new operation_t("file_rename");
        file_rename = operation_tVar30;
        operation_t operation_tVar31 = new operation_t("file_open");
        file_open = operation_tVar31;
        operation_t operation_tVar32 = new operation_t("mkdir");
        mkdir = operation_tVar32;
        operation_t operation_tVar33 = new operation_t("check_resume");
        check_resume = operation_tVar33;
        operation_t operation_tVar34 = new operation_t("exception");
        exception = operation_tVar34;
        operation_t operation_tVar35 = new operation_t("alloc_cache_piece");
        alloc_cache_piece = operation_tVar35;
        operation_t operation_tVar36 = new operation_t("partfile_move");
        partfile_move = operation_tVar36;
        operation_t operation_tVar37 = new operation_t("partfile_read");
        partfile_read = operation_tVar37;
        operation_t operation_tVar38 = new operation_t("partfile_write");
        partfile_write = operation_tVar38;
        operation_t operation_tVar39 = new operation_t("hostname_lookup");
        hostname_lookup = operation_tVar39;
        operation_t operation_tVar40 = new operation_t("symlink");
        symlink = operation_tVar40;
        operation_t operation_tVar41 = new operation_t("handshake");
        handshake = operation_tVar41;
        operation_t operation_tVar42 = new operation_t("sock_option");
        sock_option = operation_tVar42;
        operation_t operation_tVar43 = new operation_t("enum_route");
        enum_route = operation_tVar43;
        swigValues = new operation_t[]{operation_tVar, operation_tVar2, operation_tVar3, operation_tVar4, operation_tVar5, operation_tVar6, operation_tVar7, operation_tVar8, operation_tVar9, operation_tVar10, operation_tVar11, operation_tVar12, operation_tVar13, operation_tVar14, operation_tVar15, operation_tVar16, operation_tVar17, operation_tVar18, operation_tVar19, operation_tVar20, operation_tVar21, operation_tVar22, operation_tVar23, operation_tVar24, operation_tVar25, operation_tVar26, operation_tVar27, operation_tVar28, operation_tVar29, operation_tVar30, operation_tVar31, operation_tVar32, operation_tVar33, operation_tVar34, operation_tVar35, operation_tVar36, operation_tVar37, operation_tVar38, operation_tVar39, operation_tVar40, operation_tVar41, operation_tVar42, operation_tVar43};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static operation_t swigToEnum(int i) {
        operation_t[] operation_tVarArr = swigValues;
        if (i < operation_tVarArr.length && i >= 0 && operation_tVarArr[i].swigValue == i) {
            return operation_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            operation_t[] operation_tVarArr2 = swigValues;
            if (i2 < operation_tVarArr2.length) {
                if (operation_tVarArr2[i2].swigValue == i) {
                    return operation_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + operation_t.class + " with value " + i);
            }
        }
    }

    private operation_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private operation_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private operation_t(String str, operation_t operation_tVar) {
        this.swigName = str;
        int i = operation_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
