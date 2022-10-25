package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.TcpEndpoint;
import com.frostwire.jlibtorrent.swig.tracker_alert;

/* loaded from: classes2.dex */
public class TrackerAlert<T extends tracker_alert> extends TorrentAlert<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TrackerAlert(T t) {
        super(t);
    }

    public TcpEndpoint localEndpoint() {
        return new TcpEndpoint(((tracker_alert) this.alert).get_local_endpoint());
    }

    public String trackerUrl() {
        return ((tracker_alert) this.alert).tracker_url();
    }
}
