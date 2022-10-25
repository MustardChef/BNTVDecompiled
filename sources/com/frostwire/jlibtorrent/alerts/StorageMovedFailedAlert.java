package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.swig.storage_moved_failed_alert;

/* loaded from: classes2.dex */
public final class StorageMovedFailedAlert extends TorrentAlert<storage_moved_failed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageMovedFailedAlert(storage_moved_failed_alert storage_moved_failed_alertVar) {
        super(storage_moved_failed_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((storage_moved_failed_alert) this.alert).getError());
    }

    public String filePath() {
        return ((storage_moved_failed_alert) this.alert).file_path();
    }

    public Operation operation() {
        return Operation.fromSwig(((storage_moved_failed_alert) this.alert).getOp());
    }
}
