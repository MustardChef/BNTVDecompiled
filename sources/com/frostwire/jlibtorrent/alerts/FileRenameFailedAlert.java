package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.file_rename_failed_alert;

/* loaded from: classes2.dex */
public final class FileRenameFailedAlert extends TorrentAlert<file_rename_failed_alert> {
    public FileRenameFailedAlert(file_rename_failed_alert file_rename_failed_alertVar) {
        super(file_rename_failed_alertVar);
    }

    public int getIndex() {
        return ((file_rename_failed_alert) this.alert).getIndex();
    }

    public ErrorCode getError() {
        return new ErrorCode(((file_rename_failed_alert) this.alert).getError());
    }
}
