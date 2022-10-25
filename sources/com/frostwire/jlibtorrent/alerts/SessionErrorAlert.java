package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.session_error_alert;

/* loaded from: classes2.dex */
public final class SessionErrorAlert extends AbstractAlert<session_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionErrorAlert(session_error_alert session_error_alertVar) {
        super(session_error_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((session_error_alert) this.alert).getError());
    }
}
