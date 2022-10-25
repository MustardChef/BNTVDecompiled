package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.swig.torrent_delete_failed_alert;

/* loaded from: classes2.dex */
public final class TorrentDeleteFailedAlert extends TorrentAlert<torrent_delete_failed_alert> {
    public TorrentDeleteFailedAlert(torrent_delete_failed_alert torrent_delete_failed_alertVar) {
        super(torrent_delete_failed_alertVar);
    }

    public ErrorCode getError() {
        return new ErrorCode(((torrent_delete_failed_alert) this.alert).getError());
    }

    public Sha1Hash getInfoHash() {
        return new Sha1Hash(((torrent_delete_failed_alert) this.alert).getInfo_hash());
    }
}
