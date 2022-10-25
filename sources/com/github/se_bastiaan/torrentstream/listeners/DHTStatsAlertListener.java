package com.github.se_bastiaan.torrentstream.listeners;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.DhtRoutingBucket;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.DhtStatsAlert;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class DHTStatsAlertListener implements AlertListener {
    public abstract void stats(int i);

    @Override // com.frostwire.jlibtorrent.AlertListener
    public int[] types() {
        return new int[]{AlertType.DHT_STATS.swig()};
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public void alert(Alert<?> alert) {
        if (alert instanceof DhtStatsAlert) {
            stats(countTotalDHTNodes((DhtStatsAlert) alert));
        }
    }

    private int countTotalDHTNodes(DhtStatsAlert dhtStatsAlert) {
        ArrayList<DhtRoutingBucket> routingTable = dhtStatsAlert.routingTable();
        int i = 0;
        if (routingTable != null) {
            Iterator<DhtRoutingBucket> it = routingTable.iterator();
            while (it.hasNext()) {
                i += it.next().numNodes();
            }
        }
        return i;
    }
}
