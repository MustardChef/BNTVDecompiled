package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.session_stats_alert;

/* loaded from: classes2.dex */
public final class SessionStatsAlert extends AbstractAlert<session_stats_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionStatsAlert(session_stats_alert session_stats_alertVar) {
        super(session_stats_alertVar);
    }

    public long value(int i) {
        return ((session_stats_alert) this.alert).get_value(i);
    }
}
