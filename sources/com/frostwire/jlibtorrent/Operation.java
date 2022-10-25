package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.libtorrent;
import com.frostwire.jlibtorrent.swig.operation_t;

/* loaded from: classes2.dex */
public enum Operation {
    UNKNOWN(operation_t.unknown.swigValue()),
    BITTORRENT(operation_t.bittorrent.swigValue()),
    IOCONTROL(operation_t.iocontrol.swigValue()),
    GETPEERNAME(operation_t.getpeername.swigValue()),
    GETNAME(operation_t.getname.swigValue()),
    ALLOC_RECVBUF(operation_t.alloc_recvbuf.swigValue()),
    ALLOC_SNDBUF(operation_t.alloc_sndbuf.swigValue()),
    FILE_WRITE(operation_t.file_write.swigValue()),
    FILE_READ(operation_t.file_read.swigValue()),
    FILE(operation_t.file.swigValue()),
    SOCK_WRITE(operation_t.sock_write.swigValue()),
    SOCK_READ(operation_t.sock_read.swigValue()),
    SOCK_OPEN(operation_t.sock_open.swigValue()),
    SOCK_BIND(operation_t.sock_bind.swigValue()),
    AVAILABLE(operation_t.available.swigValue()),
    ENCRYPTION(operation_t.encryption.swigValue()),
    CONNECT(operation_t.connect.swigValue()),
    SSL_HANDSHAKE(operation_t.ssl_handshake.swigValue()),
    GET_INTERFACE(operation_t.get_interface.swigValue()),
    SOCK_LISTEN(operation_t.sock_listen.swigValue()),
    SOCK_BIND_TO_DEVICE(operation_t.sock_bind_to_device.swigValue()),
    SOCK_ACCEPT(operation_t.sock_accept.swigValue()),
    PARSE_ADDRESS(operation_t.parse_address.swigValue()),
    ENUM_IF(operation_t.enum_if.swigValue()),
    FILE_STAT(operation_t.file_stat.swigValue()),
    FILE_COPY(operation_t.file_copy.swigValue()),
    FILE_FALLOCATE(operation_t.file_fallocate.swigValue()),
    FILE_HARD_LINK(operation_t.file_hard_link.swigValue()),
    FILE_REMOVE(operation_t.file_remove.swigValue()),
    FILE_RENAME(operation_t.file_rename.swigValue()),
    FILE_OPEN(operation_t.file_open.swigValue()),
    MKDIR(operation_t.mkdir.swigValue()),
    CHECK_RESUME(operation_t.check_resume.swigValue()),
    EXCEPTION(operation_t.exception.swigValue()),
    ALLOC_CACHE_PIECE(operation_t.alloc_cache_piece.swigValue()),
    PARTFILE_MOVE(operation_t.partfile_move.swigValue()),
    PARTFILE_READ(operation_t.partfile_read.swigValue()),
    PARTFILE_WRITE(operation_t.partfile_write.swigValue()),
    HOSTNAME_LOOKUP(operation_t.hostname_lookup.swigValue());
    
    private final int swigValue;

    Operation(int i) {
        this.swigValue = i;
    }

    public int swig() {
        return this.swigValue;
    }

    public String nativeName() {
        try {
            return libtorrent.operation_name(operation_t.swigToEnum(this.swigValue));
        } catch (Throwable unused) {
            return "invalid enum value";
        }
    }

    public static Operation fromSwig(int i) {
        Operation[] operationArr;
        for (Operation operation : (Operation[]) Operation.class.getEnumConstants()) {
            if (operation.swig() == i) {
                return operation;
            }
        }
        return UNKNOWN;
    }

    public static Operation fromSwig(operation_t operation_tVar) {
        return fromSwig(operation_tVar.swigValue());
    }
}
