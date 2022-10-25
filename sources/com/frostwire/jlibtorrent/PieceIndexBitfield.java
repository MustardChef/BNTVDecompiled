package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.piece_index_bitfield;
import com.frostwire.jlibtorrent.swig.torrent_status;

/* loaded from: classes2.dex */
public final class PieceIndexBitfield {

    /* renamed from: f */
    private final piece_index_bitfield f2822f;

    /* renamed from: ts */
    private final torrent_status f2823ts;

    public PieceIndexBitfield(piece_index_bitfield piece_index_bitfieldVar) {
        this(piece_index_bitfieldVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PieceIndexBitfield(piece_index_bitfield piece_index_bitfieldVar, torrent_status torrent_statusVar) {
        this.f2822f = piece_index_bitfieldVar;
        this.f2823ts = torrent_statusVar;
    }

    public piece_index_bitfield swig() {
        return this.f2822f;
    }

    /* renamed from: ts */
    public torrent_status m6059ts() {
        return this.f2823ts;
    }

    public boolean getBit(int i) {
        return this.f2822f.get_bit(i);
    }

    public void clearBit(int i) {
        this.f2822f.clear_bit(i);
    }

    public void setBit(int i) {
        this.f2822f.set_bit(i);
    }

    public int endIndex() {
        return this.f2822f.end_index();
    }

    public boolean isAllSet() {
        return this.f2822f.all_set();
    }

    public boolean isNoneSet() {
        return this.f2822f.none_set();
    }

    public int size() {
        return this.f2822f.size();
    }

    public boolean isEmpty() {
        return this.f2822f.empty();
    }

    public int count() {
        return this.f2822f.count();
    }

    public int findFirstSet() {
        return this.f2822f.find_first_set();
    }

    public int findLastClear() {
        return this.f2822f.find_last_clear();
    }

    public void resize(int i, boolean z) {
        this.f2822f.resize(i, z);
    }

    public void resize(int i) {
        this.f2822f.resize(i);
    }

    public void setAll() {
        this.f2822f.set_all();
    }

    public void clearAll() {
        this.f2822f.clear_all();
    }

    public void clear() {
        this.f2822f.clear();
    }
}
