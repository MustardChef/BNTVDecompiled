package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.partial_piece_info;

/* loaded from: classes2.dex */
public final class PartialPieceInfo {

    /* renamed from: p */
    private final partial_piece_info f2819p;

    public PartialPieceInfo(partial_piece_info partial_piece_infoVar) {
        this.f2819p = partial_piece_infoVar;
    }

    public partial_piece_info swig() {
        return this.f2819p;
    }

    public int pieceIndex() {
        return this.f2819p.getPiece_index();
    }

    public int blocksInPiece() {
        return this.f2819p.getBlocks_in_piece();
    }

    public int finished() {
        return this.f2819p.getFinished();
    }

    public int writing() {
        return this.f2819p.getWriting();
    }

    public int requested() {
        return this.f2819p.getRequested();
    }
}
