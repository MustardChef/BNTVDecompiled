package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.tracker_reply_alert;

/* loaded from: classes2.dex */
public final class TrackerReplyAlert extends TrackerAlert<tracker_reply_alert> {
    public TrackerReplyAlert(tracker_reply_alert tracker_reply_alertVar) {
        super(tracker_reply_alertVar);
    }

    public int numPeers() {
        return ((tracker_reply_alert) this.alert).getNum_peers();
    }
}
