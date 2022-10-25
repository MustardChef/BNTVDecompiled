package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.log_alert;

/* loaded from: classes2.dex */
public final class LogAlert extends AbstractAlert<log_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LogAlert(log_alert log_alertVar) {
        super(log_alertVar);
    }

    public String logMessage() {
        return ((log_alert) this.alert).log_message();
    }
}
