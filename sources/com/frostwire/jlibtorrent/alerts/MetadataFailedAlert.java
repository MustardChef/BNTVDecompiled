package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.metadata_failed_alert;

/* loaded from: classes2.dex */
public final class MetadataFailedAlert extends TorrentAlert<metadata_failed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataFailedAlert(metadata_failed_alert metadata_failed_alertVar) {
        super(metadata_failed_alertVar);
    }

    public ErrorCode getError() {
        return new ErrorCode(((metadata_failed_alert) this.alert).getError());
    }
}
