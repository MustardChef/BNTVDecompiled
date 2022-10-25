package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.block_downloading_alert;

/* loaded from: classes2.dex */
public final class BlockDownloadingAlert extends PeerAlert<block_downloading_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockDownloadingAlert(block_downloading_alert block_downloading_alertVar) {
        super(block_downloading_alertVar);
    }

    public int blockIndex() {
        return ((block_downloading_alert) this.alert).getBlock_index();
    }

    public int pieceIndex() {
        return ((block_downloading_alert) this.alert).getPiece_index();
    }
}
