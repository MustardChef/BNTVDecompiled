package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.bdecode_node;
import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.error_code;

/* loaded from: classes2.dex */
public final class BDecodeNode {
    private final byte_vector buffer;

    /* renamed from: n */
    private final bdecode_node f2807n;

    public BDecodeNode(bdecode_node bdecode_nodeVar) {
        this(bdecode_nodeVar, null);
    }

    public BDecodeNode(bdecode_node bdecode_nodeVar, byte_vector byte_vectorVar) {
        this.f2807n = bdecode_nodeVar;
        this.buffer = byte_vectorVar;
    }

    public bdecode_node swig() {
        return this.f2807n;
    }

    public byte_vector buffer() {
        return this.buffer;
    }

    public String toString() {
        return bdecode_node.to_string(this.f2807n, false, 2);
    }

    public static BDecodeNode bdecode(byte[] bArr) {
        byte_vector bytes2byte_vector = Vectors.bytes2byte_vector(bArr);
        bdecode_node bdecode_nodeVar = new bdecode_node();
        error_code error_codeVar = new error_code();
        if (bdecode_node.bdecode(bytes2byte_vector, bdecode_nodeVar, error_codeVar) == 0) {
            return new BDecodeNode(bdecode_nodeVar, bytes2byte_vector);
        }
        throw new IllegalArgumentException("Can't decode data: " + error_codeVar.message());
    }
}
