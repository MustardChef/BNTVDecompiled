package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.swig.file_error_alert;

/* loaded from: classes2.dex */
public final class FileErrorAlert extends TorrentAlert<file_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FileErrorAlert(file_error_alert file_error_alertVar) {
        super(file_error_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((file_error_alert) this.alert).getError());
    }

    public String filename() {
        return ((file_error_alert) this.alert).filename();
    }

    public Operation operation() {
        return Operation.fromSwig(((file_error_alert) this.alert).getOp());
    }
}
