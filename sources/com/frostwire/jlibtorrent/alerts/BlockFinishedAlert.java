package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.block_finished_alert;

/* loaded from: classes2.dex */
public final class BlockFinishedAlert extends PeerAlert<block_finished_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockFinishedAlert(block_finished_alert block_finished_alertVar) {
        super(block_finished_alertVar);
    }

    public int blockIndex() {
        return ((block_finished_alert) this.alert).getBlock_index();
    }

    public int pieceIndex() {
        return ((block_finished_alert) this.alert).getPiece_index();
    }
}
