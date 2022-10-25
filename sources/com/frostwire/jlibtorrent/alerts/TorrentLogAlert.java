package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.torrent_log_alert;

/* loaded from: classes2.dex */
public final class TorrentLogAlert extends TorrentAlert<torrent_log_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TorrentLogAlert(torrent_log_alert torrent_log_alertVar) {
        super(torrent_log_alertVar);
    }

    public String logMessage() {
        return ((torrent_log_alert) this.alert).log_message();
    }
}
