package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.hash_failed_alert;

/* loaded from: classes2.dex */
public final class HashFailedAlert extends TorrentAlert<hash_failed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HashFailedAlert(hash_failed_alert hash_failed_alertVar) {
        super(hash_failed_alertVar);
    }

    public int pieceIndex() {
        return ((hash_failed_alert) this.alert).getPiece_index();
    }
}
