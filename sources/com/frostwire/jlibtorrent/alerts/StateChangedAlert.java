package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.TorrentStatus;
import com.frostwire.jlibtorrent.swig.state_changed_alert;

/* loaded from: classes2.dex */
public final class StateChangedAlert extends TorrentAlert<state_changed_alert> {
    public StateChangedAlert(state_changed_alert state_changed_alertVar) {
        super(state_changed_alertVar);
    }

    public TorrentStatus.State getState() {
        return TorrentStatus.State.fromSwig(((state_changed_alert) this.alert).getState().swigValue());
    }

    public TorrentStatus.State getPrevState() {
        return TorrentStatus.State.fromSwig(((state_changed_alert) this.alert).getPrev_state().swigValue());
    }
}
