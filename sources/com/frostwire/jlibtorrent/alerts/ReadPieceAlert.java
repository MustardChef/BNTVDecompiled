package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.read_piece_alert;

/* loaded from: classes2.dex */
public final class ReadPieceAlert extends TorrentAlert<read_piece_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadPieceAlert(read_piece_alert read_piece_alertVar) {
        super(read_piece_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((read_piece_alert) this.alert).getError());
    }

    public long bufferPtr() {
        return ((read_piece_alert) this.alert).buffer_ptr();
    }

    public int piece() {
        return ((read_piece_alert) this.alert).getPiece();
    }

    public int size() {
        return ((read_piece_alert) this.alert).getSize();
    }
}
