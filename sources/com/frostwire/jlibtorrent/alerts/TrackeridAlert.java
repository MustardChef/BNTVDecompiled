package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.trackerid_alert;

/* loaded from: classes2.dex */
public final class TrackeridAlert extends TorrentAlert<trackerid_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackeridAlert(trackerid_alert trackerid_alertVar) {
        super(trackerid_alertVar);
    }

    public String trackerId() {
        return ((trackerid_alert) this.alert).tracker_id();
    }
}
