package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.alerts.SessionStatsAlert;

/* loaded from: classes2.dex */
public final class SessionStats {
    private static final int DOWNLOAD_IP_PROTOCOL = 5;
    private static final int DOWNLOAD_PAYLOAD = 3;
    private static final int DOWNLOAD_PROTOCOL = 4;
    private static final int NUM_AVERAGES = 6;
    private static final int UPLOAD_IP_PROTOCOL = 2;
    private static final int UPLOAD_PAYLOAD = 0;
    private static final int UPLOAD_PROTOCOL = 1;
    private long dhtNodes;
    private long lastTickTime;
    private final Average[] stat = new Average[6];

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionStats() {
        int i = 0;
        while (true) {
            Average[] averageArr = this.stat;
            if (i >= averageArr.length) {
                return;
            }
            averageArr[i] = new Average();
            i++;
        }
    }

    public long totalDownload() {
        return this.stat[3].total() + this.stat[4].total() + this.stat[5].total();
    }

    public long totalUpload() {
        return this.stat[0].total() + this.stat[1].total() + this.stat[2].total();
    }

    public long downloadRate() {
        return this.stat[3].rate() + this.stat[4].rate() + this.stat[5].rate();
    }

    public long uploadRate() {
        return this.stat[0].rate() + this.stat[1].rate() + this.stat[2].rate();
    }

    public long dhtNodes() {
        return this.dhtNodes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(SessionStatsAlert sessionStatsAlert) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastTickTime;
        this.lastTickTime = currentTimeMillis;
        long value = sessionStatsAlert.value(StatsMetric.NET_RECV_BYTES_COUNTER_INDEX);
        long value2 = sessionStatsAlert.value(StatsMetric.NET_RECV_PAYLOAD_BYTES_COUNTER_INDEX);
        long j2 = value - value2;
        long value3 = sessionStatsAlert.value(StatsMetric.NET_RECV_IP_OVERHEAD_BYTES_COUNTER_INDEX);
        this.stat[3].add(value2 - this.stat[3].total());
        this.stat[4].add(j2 - this.stat[4].total());
        this.stat[5].add(value3 - this.stat[5].total());
        long value4 = sessionStatsAlert.value(StatsMetric.NET_SENT_BYTES_COUNTER_INDEX);
        long value5 = sessionStatsAlert.value(StatsMetric.NET_SENT_PAYLOAD_BYTES_COUNTER_INDEX);
        long j3 = value4 - value5;
        long value6 = sessionStatsAlert.value(StatsMetric.NET_SENT_IP_OVERHEAD_BYTES_COUNTER_INDEX);
        this.stat[0].add(value5 - this.stat[0].total());
        this.stat[1].add(j3 - this.stat[1].total());
        this.stat[2].add(value6 - this.stat[2].total());
        tick(j);
        this.dhtNodes = sessionStatsAlert.value(StatsMetric.DHT_NODES_GAUGE_INDEX);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        for (int i = 0; i < 6; i++) {
            this.stat[i].clear();
        }
        this.dhtNodes = 0L;
    }

    private void tick(long j) {
        for (int i = 0; i < 6; i++) {
            this.stat[i].tick(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Average {
        private long averageSec5;
        private long counter;
        private long totalCounter;

        public void add(long j) {
            this.counter += j;
            this.totalCounter += j;
        }

        public void tick(long j) {
            if (j >= 1) {
                this.averageSec5 = ((this.averageSec5 * 4) / 5) + (((this.counter * 1000) / j) / 5);
                this.counter = 0L;
            }
        }

        public long rate() {
            return this.averageSec5;
        }

        public long total() {
            return this.totalCounter;
        }

        public void clear() {
            this.counter = 0L;
            this.averageSec5 = 0L;
            this.totalCounter = 0L;
        }
    }
}
