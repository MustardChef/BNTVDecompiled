package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.TorrentStatus;
import com.frostwire.jlibtorrent.swig.state_update_alert;
import com.frostwire.jlibtorrent.swig.torrent_status_vector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class StateUpdateAlert extends AbstractAlert<state_update_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StateUpdateAlert(state_update_alert state_update_alertVar) {
        super(state_update_alertVar);
    }

    public List<TorrentStatus> status() {
        torrent_status_vector status = ((state_update_alert) this.alert).getStatus();
        int size = (int) status.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new TorrentStatus(status.get(i)));
        }
        return arrayList;
    }
}
