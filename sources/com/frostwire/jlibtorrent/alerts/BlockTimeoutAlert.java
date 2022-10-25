package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.block_timeout_alert;

/* loaded from: classes2.dex */
public final class BlockTimeoutAlert extends PeerAlert<block_timeout_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockTimeoutAlert(block_timeout_alert block_timeout_alertVar) {
        super(block_timeout_alertVar);
    }

    public int blockIndex() {
        return ((block_timeout_alert) this.alert).getBlock_index();
    }

    public int pieceIndex() {
        return ((block_timeout_alert) this.alert).getPiece_index();
    }
}
