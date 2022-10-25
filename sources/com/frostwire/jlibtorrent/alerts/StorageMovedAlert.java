package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.storage_moved_alert;

/* loaded from: classes2.dex */
public final class StorageMovedAlert extends TorrentAlert<storage_moved_alert> {
    public StorageMovedAlert(storage_moved_alert storage_moved_alertVar) {
        super(storage_moved_alertVar);
    }

    public String storagePath() {
        return ((storage_moved_alert) this.alert).storage_path();
    }
}
