package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.piece_finished_alert;

/* loaded from: classes2.dex */
public final class PieceFinishedAlert extends TorrentAlert<piece_finished_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PieceFinishedAlert(piece_finished_alert piece_finished_alertVar) {
        super(piece_finished_alertVar);
    }

    public int pieceIndex() {
        return ((piece_finished_alert) this.alert).getPiece_index();
    }
}
