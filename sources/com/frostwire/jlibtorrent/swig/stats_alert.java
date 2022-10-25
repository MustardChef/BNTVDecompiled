package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class stats_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.stats_alert_priority_get();
    public static final int alert_type = libtorrent_jni.stats_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.stats_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public stats_alert(long j, boolean z) {
        super(libtorrent_jni.stats_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(stats_alert stats_alertVar) {
        if (stats_alertVar == null) {
            return 0L;
        }
        return stats_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_stats_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.stats_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.stats_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.stats_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.stats_alert_message(this.swigCPtr, this);
    }

    public int getInterval() {
        return libtorrent_jni.stats_alert_interval_get(this.swigCPtr, this);
    }

    public int get_transferred(int i) {
        return libtorrent_jni.stats_alert_get_transferred(this.swigCPtr, this, i);
    }

    /* loaded from: classes2.dex */
    public static final class stats_channel {
        public static final stats_channel download_ip_protocol;
        public static final stats_channel download_payload;
        public static final stats_channel download_protocol;
        public static final stats_channel num_channels;
        private static int swigNext;
        private static stats_channel[] swigValues;
        public static final stats_channel upload_ip_protocol;
        public static final stats_channel upload_payload;
        public static final stats_channel upload_protocol;
        private final String swigName;
        private final int swigValue;

        static {
            stats_channel stats_channelVar = new stats_channel("upload_payload");
            upload_payload = stats_channelVar;
            stats_channel stats_channelVar2 = new stats_channel("upload_protocol");
            upload_protocol = stats_channelVar2;
            stats_channel stats_channelVar3 = new stats_channel("download_payload");
            download_payload = stats_channelVar3;
            stats_channel stats_channelVar4 = new stats_channel("download_protocol");
            download_protocol = stats_channelVar4;
            stats_channel stats_channelVar5 = new stats_channel("upload_ip_protocol");
            upload_ip_protocol = stats_channelVar5;
            stats_channel stats_channelVar6 = new stats_channel("download_ip_protocol", libtorrent_jni.stats_alert_download_ip_protocol_get());
            download_ip_protocol = stats_channelVar6;
            stats_channel stats_channelVar7 = new stats_channel("num_channels", libtorrent_jni.stats_alert_num_channels_get());
            num_channels = stats_channelVar7;
            swigValues = new stats_channel[]{stats_channelVar, stats_channelVar2, stats_channelVar3, stats_channelVar4, stats_channelVar5, stats_channelVar6, stats_channelVar7};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static stats_channel swigToEnum(int i) {
            stats_channel[] stats_channelVarArr = swigValues;
            if (i < stats_channelVarArr.length && i >= 0 && stats_channelVarArr[i].swigValue == i) {
                return stats_channelVarArr[i];
            }
            int i2 = 0;
            while (true) {
                stats_channel[] stats_channelVarArr2 = swigValues;
                if (i2 < stats_channelVarArr2.length) {
                    if (stats_channelVarArr2[i2].swigValue == i) {
                        return stats_channelVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + stats_channel.class + " with value " + i);
                }
            }
        }

        private stats_channel(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private stats_channel(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private stats_channel(String str, stats_channel stats_channelVar) {
            this.swigName = str;
            int i = stats_channelVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
