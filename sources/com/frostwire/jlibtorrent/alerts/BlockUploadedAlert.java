package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.block_uploaded_alert;

/* loaded from: classes2.dex */
public final class BlockUploadedAlert extends PeerAlert<block_uploaded_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockUploadedAlert(block_uploaded_alert block_uploaded_alertVar) {
        super(block_uploaded_alertVar);
    }

    public int blockIndex() {
        return ((block_uploaded_alert) this.alert).getBlock_index();
    }

    public int pieceIndex() {
        return ((block_uploaded_alert) this.alert).getPiece_index();
    }
}
