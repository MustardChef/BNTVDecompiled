package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.torrent_error_alert;

/* loaded from: classes2.dex */
public final class TorrentErrorAlert extends TorrentAlert<torrent_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TorrentErrorAlert(torrent_error_alert torrent_error_alertVar) {
        super(torrent_error_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((torrent_error_alert) this.alert).getError());
    }

    public String filename() {
        return ((torrent_error_alert) this.alert).filename();
    }
}
