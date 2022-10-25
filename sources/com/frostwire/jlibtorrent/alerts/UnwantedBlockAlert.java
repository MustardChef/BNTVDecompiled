package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.unwanted_block_alert;

/* loaded from: classes2.dex */
public final class UnwantedBlockAlert extends PeerAlert<unwanted_block_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UnwantedBlockAlert(unwanted_block_alert unwanted_block_alertVar) {
        super(unwanted_block_alertVar);
    }

    public int blockIndex() {
        return ((unwanted_block_alert) this.alert).getBlock_index();
    }

    public int pieceIndex() {
        return ((unwanted_block_alert) this.alert).getPiece_index();
    }
}
