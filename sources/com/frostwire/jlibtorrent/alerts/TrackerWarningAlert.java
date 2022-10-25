package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.tracker_warning_alert;

/* loaded from: classes2.dex */
public final class TrackerWarningAlert extends TrackerAlert<tracker_warning_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackerWarningAlert(tracker_warning_alert tracker_warning_alertVar) {
        super(tracker_warning_alertVar);
    }

    public String warningMessage() {
        return ((tracker_warning_alert) this.alert).warning_message();
    }
}
