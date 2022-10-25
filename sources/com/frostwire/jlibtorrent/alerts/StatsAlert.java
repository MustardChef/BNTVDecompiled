package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.stats_alert;

/* loaded from: classes2.dex */
public final class StatsAlert extends TorrentAlert<stats_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StatsAlert(stats_alert stats_alertVar) {
        super(stats_alertVar);
    }

    public int transferred(int i) {
        return ((stats_alert) this.alert).get_transferred(i);
    }

    public int interval() {
        return ((stats_alert) this.alert).getInterval();
    }

    /* loaded from: classes2.dex */
    public enum StatsChannel {
        UPLOAD_PAYLOAD(stats_alert.stats_channel.upload_payload.swigValue()),
        UPlOAD_PROTOCOL(stats_alert.stats_channel.upload_protocol.swigValue()),
        DOWNLOAD_PAYLOAD(stats_alert.stats_channel.download_payload.swigValue()),
        DOWNLOAD_PROTOCOL(stats_alert.stats_channel.download_protocol.swigValue()),
        UPLOAD_IP_PROTOCOL(stats_alert.stats_channel.upload_ip_protocol.swigValue()),
        DOWNLOAD_IP_PROTOCOL(stats_alert.stats_channel.download_ip_protocol.swigValue()),
        NUM_CHANNELS(stats_alert.stats_channel.num_channels.swigValue());
        
        private final int swigValue;

        StatsChannel(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public int getIndex() {
            return this.swigValue;
        }
    }
}
