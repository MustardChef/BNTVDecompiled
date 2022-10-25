package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.DhtLookup;
import com.frostwire.jlibtorrent.DhtRoutingBucket;
import com.frostwire.jlibtorrent.swig.dht_lookup_vector;
import com.frostwire.jlibtorrent.swig.dht_routing_bucket_vector;
import com.frostwire.jlibtorrent.swig.dht_stats_alert;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class DhtStatsAlert extends AbstractAlert<dht_stats_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtStatsAlert(dht_stats_alert dht_stats_alertVar) {
        super(dht_stats_alertVar);
    }

    public ArrayList<DhtLookup> activeRequests() {
        dht_lookup_vector active_requests = ((dht_stats_alert) this.alert).getActive_requests();
        int size = (int) active_requests.size();
        ArrayList<DhtLookup> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new DhtLookup(active_requests.get(i)));
        }
        return arrayList;
    }

    public ArrayList<DhtRoutingBucket> routingTable() {
        dht_routing_bucket_vector routing_table = ((dht_stats_alert) this.alert).getRouting_table();
        int size = (int) routing_table.size();
        ArrayList<DhtRoutingBucket> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new DhtRoutingBucket(routing_table.get(i)));
        }
        return arrayList;
    }
}
