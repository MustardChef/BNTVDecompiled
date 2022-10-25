package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.AddTorrentParams;
import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.add_torrent_alert;

/* loaded from: classes2.dex */
public final class AddTorrentAlert extends TorrentAlert<add_torrent_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AddTorrentAlert(add_torrent_alert add_torrent_alertVar) {
        super(add_torrent_alertVar);
    }

    public AddTorrentParams params() {
        return new AddTorrentParams(((add_torrent_alert) this.alert).getParams());
    }

    public ErrorCode error() {
        return new ErrorCode(((add_torrent_alert) this.alert).getError());
    }
}
