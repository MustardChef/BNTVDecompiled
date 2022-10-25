package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.lsd_error_alert;

/* loaded from: classes2.dex */
public final class LsdErrorAlert extends AbstractAlert<lsd_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LsdErrorAlert(lsd_error_alert lsd_error_alertVar) {
        super(lsd_error_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((lsd_error_alert) this.alert).getError());
    }
}
