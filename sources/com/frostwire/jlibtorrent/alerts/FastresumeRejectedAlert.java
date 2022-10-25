package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.swig.fastresume_rejected_alert;

/* loaded from: classes2.dex */
public final class FastresumeRejectedAlert extends TorrentAlert<fastresume_rejected_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FastresumeRejectedAlert(fastresume_rejected_alert fastresume_rejected_alertVar) {
        super(fastresume_rejected_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((fastresume_rejected_alert) this.alert).getError());
    }

    public String filePath() {
        return ((fastresume_rejected_alert) this.alert).file_path();
    }

    public Operation operation() {
        return Operation.fromSwig(((fastresume_rejected_alert) this.alert).getOp());
    }
}
