package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.tracker_error_alert;

/* loaded from: classes2.dex */
public final class TrackerErrorAlert extends TrackerAlert<tracker_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackerErrorAlert(tracker_error_alert tracker_error_alertVar) {
        super(tracker_error_alertVar);
    }

    public int timesInRow() {
        return ((tracker_error_alert) this.alert).getTimes_in_row();
    }

    public ErrorCode error() {
        return new ErrorCode(((tracker_error_alert) this.alert).getError());
    }

    public String errorMessage() {
        return ((tracker_error_alert) this.alert).error_message();
    }
}
