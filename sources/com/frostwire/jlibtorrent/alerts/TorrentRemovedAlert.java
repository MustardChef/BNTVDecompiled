package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.swig.torrent_removed_alert;

/* loaded from: classes2.dex */
public final class TorrentRemovedAlert extends TorrentAlert<torrent_removed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TorrentRemovedAlert(torrent_removed_alert torrent_removed_alertVar) {
        super(torrent_removed_alertVar);
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(((torrent_removed_alert) this.alert).getInfo_hash());
    }
}
