package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.phimhd.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    private static final int COUNTRY_GROUP_INDEX_2G = 1;
    private static final int COUNTRY_GROUP_INDEX_3G = 2;
    private static final int COUNTRY_GROUP_INDEX_4G = 3;
    private static final int COUNTRY_GROUP_INDEX_5G_NSA = 4;
    private static final int COUNTRY_GROUP_INDEX_5G_SA = 5;
    private static final int COUNTRY_GROUP_INDEX_WIFI = 0;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private static DefaultBandwidthMeter singletonInstance;
    private long bitrateEstimate;
    private final Clock clock;
    private final BandwidthMeter.EventListener.EventDispatcher eventDispatcher;
    private final ImmutableMap<Integer, Long> initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private final boolean resetOnNetworkTypeChange;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.m290of(5400000L, 3300000L, 2000000L, 1300000L, 760000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.m290of(1700000L, 820000L, 450000L, 180000L, 130000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.m290of(2300000L, 1300000L, 1000000L, 820000L, 570000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.m290of(3400000L, 2000000L, 1400000L, 1000000L, 620000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.m290of(7500000L, 5200000L, 3700000L, (long) Long.valueOf((long) Constants.TIME_30MIN_TO_SHOW_ADS), 1100000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = ImmutableList.m290of(3300000L, 1900000L, 1700000L, 1500000L, 1200000L);

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public /* synthetic */ long getTimeToFirstByteEstimateUs() {
        long j;
        j = C3282C.TIME_UNSET;
        return j;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private Clock clock;
        private final Context context;
        private Map<Integer, Long> initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context) {
            this.context = context == null ? null : context.getApplicationContext();
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Util.getCountryCode(context));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            for (Integer num : this.initialBitrateEstimates.keySet()) {
                setInitialBitrateEstimate(num.intValue(), j);
            }
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.initialBitrateEstimates.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.initialBitrateEstimates = getInitialBitrateEstimatesForCountry(Ascii.toUpperCase(str));
            return this;
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange);
        }

        private static Map<Integer, Long> getInitialBitrateEstimatesForCountry(String str) {
            int[] initialBitrateCountryGroupAssignment = DefaultBandwidthMeter.getInitialBitrateCountryGroupAssignment(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            hashMap.put(2, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(initialBitrateCountryGroupAssignment[0]));
            hashMap.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(initialBitrateCountryGroupAssignment[1]));
            hashMap.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(initialBitrateCountryGroupAssignment[2]));
            hashMap.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(initialBitrateCountryGroupAssignment[3]));
            hashMap.put(10, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(initialBitrateCountryGroupAssignment[4]));
            hashMap.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(initialBitrateCountryGroupAssignment[5]));
            hashMap.put(7, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI.get(initialBitrateCountryGroupAssignment[0]));
            return hashMap;
        }
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (singletonInstance == null) {
                singletonInstance = new Builder(context).build();
            }
            defaultBandwidthMeter = singletonInstance;
        }
        return defaultBandwidthMeter;
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.m276of(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context, Map<Integer, Long> map, int i, Clock clock, boolean z) {
        this.initialBitrateEstimates = ImmutableMap.copyOf((Map) map);
        this.eventDispatcher = new BandwidthMeter.EventListener.EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock;
        this.resetOnNetworkTypeChange = z;
        if (context != null) {
            NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
            int networkType = networkTypeObserver.getNetworkType();
            this.networkType = networkType;
            this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(networkType);
            networkTypeObserver.register(new NetworkTypeObserver.Listener() { // from class: com.google.android.exoplayer2.upstream.-$$Lambda$DefaultBandwidthMeter$n4HgtxeYBFNUETYzdzpx6UkOs7c
                @Override // com.google.android.exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i2) {
                    DefaultBandwidthMeter.this.onNetworkTypeChanged(i2);
                }
            });
            return;
        }
        this.networkType = 0;
        this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(0);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.networkTypeOverride = i;
        this.networkTypeOverrideSet = true;
        onNetworkTypeChanged(i);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.eventDispatcher.addListener(handler, eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.eventDispatcher.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            this.sampleBytesTransferred += i;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (isTransferAtFullNetworkSpeed(dataSpec, z)) {
            Assertions.checkState(this.streamCount > 0);
            long elapsedRealtime = this.clock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += i;
            long j = this.totalBytesTransferred;
            long j2 = this.sampleBytesTransferred;
            this.totalBytesTransferred = j + j2;
            if (i > 0) {
                this.slidingPercentile.addSample((int) Math.sqrt(j2), (((float) j2) * 8000.0f) / i);
                if (this.totalElapsedTimeMs >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.bitrateEstimate = this.slidingPercentile.getPercentile(0.5f);
                }
                maybeNotifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0L;
            }
            this.streamCount--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onNetworkTypeChanged(int i) {
        int i2 = this.networkType;
        if (i2 == 0 || this.resetOnNetworkTypeChange) {
            if (this.networkTypeOverrideSet) {
                i = this.networkTypeOverride;
            }
            if (i2 == i) {
                return;
            }
            this.networkType = i;
            if (i != 1 && i != 0 && i != 8) {
                this.bitrateEstimate = getInitialBitrateEstimateForNetworkType(i);
                long elapsedRealtime = this.clock.elapsedRealtime();
                maybeNotifyBandwidthSample(this.streamCount > 0 ? (int) (elapsedRealtime - this.sampleStartTimeMs) : 0, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = elapsedRealtime;
                this.sampleBytesTransferred = 0L;
                this.totalBytesTransferred = 0L;
                this.totalElapsedTimeMs = 0L;
                this.slidingPercentile.reset();
            }
        }
    }

    private void maybeNotifyBandwidthSample(int i, long j, long j2) {
        if (i == 0 && j == 0 && j2 == this.lastReportedBitrateEstimate) {
            return;
        }
        this.lastReportedBitrateEstimate = j2;
        this.eventDispatcher.bandwidthSample(i, j, j2);
    }

    private long getInitialBitrateEstimateForNetworkType(int i) {
        Long l = this.initialBitrateEstimates.get(Integer.valueOf(i));
        if (l == null) {
            l = this.initialBitrateEstimates.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    private static boolean isTransferAtFullNetworkSpeed(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] getInitialBitrateCountryGroupAssignment(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    c = 0;
                    break;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    c = 1;
                    break;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    c = 2;
                    break;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    c = 3;
                    break;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 4;
                    break;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    c = 5;
                    break;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    c = 6;
                    break;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    c = 7;
                    break;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    c = '\b';
                    break;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    c = '\t';
                    break;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    c = '\n';
                    break;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    c = 11;
                    break;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    c = '\f';
                    break;
                }
                break;
            case RemoteMediaPlayer.STATUS_TIMED_OUT /* 2102 */:
                if (str.equals("AW")) {
                    c = '\r';
                    break;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    c = 14;
                    break;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    c = 15;
                    break;
                }
                break;
            case CastStatusCodes.ERROR_URL_INSEURE /* 2111 */:
                if (str.equals("BA")) {
                    c = 16;
                    break;
                }
                break;
            case CastStatusCodes.ERROR_HOST_NOT_ALLOWED /* 2112 */:
                if (str.equals("BB")) {
                    c = 17;
                    break;
                }
                break;
            case CastStatusCodes.ERROR_NO_CAST_CONFIGURATION /* 2114 */:
                if (str.equals("BD")) {
                    c = 18;
                    break;
                }
                break;
            case CastStatusCodes.ERROR_DEVICE_ID_FLAGS_NOT_SET /* 2115 */:
                if (str.equals("BE")) {
                    c = 19;
                    break;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    c = 20;
                    break;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    c = 21;
                    break;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    c = 22;
                    break;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    c = 23;
                    break;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    c = 24;
                    break;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    c = 25;
                    break;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    c = 26;
                    break;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    c = 27;
                    break;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    c = 28;
                    break;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    c = 29;
                    break;
                }
                break;
            case 2128:
                if (str.equals("BR")) {
                    c = 30;
                    break;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    c = 31;
                    break;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    c = ' ';
                    break;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    c = '!';
                    break;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    c = '\"';
                    break;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    c = '#';
                    break;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    c = '%';
                    break;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    c = '\'';
                    break;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    c = '(';
                    break;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    c = ')';
                    break;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    c = '*';
                    break;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    c = '+';
                    break;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    c = ',';
                    break;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    c = '-';
                    break;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    c = '.';
                    break;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    c = JsonPointer.SEPARATOR;
                    break;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    c = '0';
                    break;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    c = '1';
                    break;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    c = '2';
                    break;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    c = '3';
                    break;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    c = '4';
                    break;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    c = '5';
                    break;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    c = '6';
                    break;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    c = '7';
                    break;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    c = '8';
                    break;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    c = '9';
                    break;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    c = ':';
                    break;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    c = ';';
                    break;
                }
                break;
            case 2206:
                if (str.equals("EC")) {
                    c = Typography.less;
                    break;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    c = '=';
                    break;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    c = '?';
                    break;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    c = '@';
                    break;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    c = 'A';
                    break;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    c = 'B';
                    break;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    c = 'C';
                    break;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    c = 'D';
                    break;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    c = 'E';
                    break;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    c = 'F';
                    break;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    c = 'G';
                    break;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    c = 'H';
                    break;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    c = 'I';
                    break;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    c = 'J';
                    break;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    c = 'K';
                    break;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    c = 'L';
                    break;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    c = 'M';
                    break;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    c = 'N';
                    break;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    c = 'O';
                    break;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    c = 'P';
                    break;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    c = 'Q';
                    break;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    c = 'R';
                    break;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    c = 'S';
                    break;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    c = 'T';
                    break;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    c = 'U';
                    break;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    c = 'V';
                    break;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    c = 'W';
                    break;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    c = 'X';
                    break;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    c = 'Y';
                    break;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    c = 'Z';
                    break;
                }
                break;
            case 2310:
                if (str.equals("HN")) {
                    c = '[';
                    break;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    c = '\\';
                    break;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    c = ']';
                    break;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    c = '^';
                    break;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    c = '_';
                    break;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    c = '`';
                    break;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    c = 'a';
                    break;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    c = 'b';
                    break;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    c = 'c';
                    break;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    c = 'd';
                    break;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    c = 'e';
                    break;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    c = 'f';
                    break;
                }
                break;
            case 2346:
                if (str.equals("IS")) {
                    c = 'g';
                    break;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    c = 'h';
                    break;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    c = 'i';
                    break;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    c = 'j';
                    break;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    c = 'k';
                    break;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    c = 'l';
                    break;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    c = 'm';
                    break;
                }
                break;
            case 2396:
                if (str.equals(ExpandedProductParsedResult.KILOGRAM)) {
                    c = 'n';
                    break;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    c = 'o';
                    break;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    c = 'p';
                    break;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    c = 'q';
                    break;
                }
                break;
            case 2405:
                if (str.equals("KP")) {
                    c = 'r';
                    break;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    c = 's';
                    break;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    c = 't';
                    break;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    c = 'u';
                    break;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    c = 'v';
                    break;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    c = 'w';
                    break;
                }
                break;
            case 2422:
                if (str.equals(ExpandedProductParsedResult.POUND)) {
                    c = 'x';
                    break;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    c = 'y';
                    break;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    c = 'z';
                    break;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    c = '{';
                    break;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    c = '|';
                    break;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    c = '}';
                    break;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    c = '~';
                    break;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    c = Ascii.MAX;
                    break;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    c = 128;
                    break;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    c = 129;
                    break;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    c = 130;
                    break;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    c = 131;
                    break;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    c = 132;
                    break;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    c = 133;
                    break;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    c = 134;
                    break;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    c = 135;
                    break;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    c = 136;
                    break;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    c = 137;
                    break;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    c = 138;
                    break;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    c = 139;
                    break;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    c = 140;
                    break;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    c = 141;
                    break;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    c = 142;
                    break;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    c = 143;
                    break;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    c = 144;
                    break;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    c = 145;
                    break;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    c = 146;
                    break;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    c = 147;
                    break;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    c = 148;
                    break;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    c = 149;
                    break;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    c = 150;
                    break;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    c = 151;
                    break;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    c = 152;
                    break;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    c = 153;
                    break;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    c = 154;
                    break;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    c = 155;
                    break;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    c = 156;
                    break;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    c = 157;
                    break;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    c = 158;
                    break;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    c = 159;
                    break;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    c = Typography.nbsp;
                    break;
                }
                break;
            case DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS /* 2500 */:
                if (str.equals("NR")) {
                    c = 161;
                    break;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    c = Typography.cent;
                    break;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    c = Typography.pound;
                    break;
                }
                break;
            case 2526:
                if (str.equals("OM")) {
                    c = 164;
                    break;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    c = 165;
                    break;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    c = 166;
                    break;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    c = Typography.section;
                    break;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    c = 168;
                    break;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    c = Typography.copyright;
                    break;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    c = 170;
                    break;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    c = 171;
                    break;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    c = 172;
                    break;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    c = 173;
                    break;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    c = Typography.registered;
                    break;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    c = 175;
                    break;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    c = Typography.degree;
                    break;
                }
                break;
            case 2569:
                if (str.equals("PY")) {
                    c = Typography.plusMinus;
                    break;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    c = 178;
                    break;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    c = 179;
                    break;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    c = 180;
                    break;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    c = 181;
                    break;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    c = Typography.paragraph;
                    break;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    c = Typography.middleDot;
                    break;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    c = 184;
                    break;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    c = 185;
                    break;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    c = 186;
                    break;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    c = 187;
                    break;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    c = 188;
                    break;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    c = Typography.half;
                    break;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    c = 190;
                    break;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    c = 191;
                    break;
                }
                break;
            case 2647:
                if (str.equals("SJ")) {
                    c = 192;
                    break;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    c = 193;
                    break;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    c = 194;
                    break;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    c = 195;
                    break;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    c = 196;
                    break;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    c = 197;
                    break;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    c = 198;
                    break;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    c = 199;
                    break;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    c = 200;
                    break;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    c = 201;
                    break;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    c = 202;
                    break;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    c = 203;
                    break;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    c = 204;
                    break;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    c = 205;
                    break;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    c = 206;
                    break;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    c = 207;
                    break;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    c = 208;
                    break;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    c = 209;
                    break;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    c = 210;
                    break;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    c = 211;
                    break;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    c = 212;
                    break;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    c = 213;
                    break;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    c = 214;
                    break;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    c = Typography.times;
                    break;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    c = 216;
                    break;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    c = 217;
                    break;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    c = 218;
                    break;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    c = 219;
                    break;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    c = 220;
                    break;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    c = 221;
                    break;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    c = 222;
                    break;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    c = 223;
                    break;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    c = 224;
                    break;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    c = 225;
                    break;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    c = 226;
                    break;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    c = 227;
                    break;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    c = 228;
                    break;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    c = 229;
                    break;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    c = 230;
                    break;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    c = 231;
                    break;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    c = 232;
                    break;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    c = 233;
                    break;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    c = 234;
                    break;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    c = 235;
                    break;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    c = 236;
                    break;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    c = 237;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 26:
            case 'P':
            case 'y':
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 4, 4, 3, 2};
            case 2:
            case ']':
            case 155:
            case 187:
            case 196:
            case 206:
            case bqk.f6560bT /* 225 */:
            case bqk.f6598ce /* 233 */:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 3:
                return new int[]{2, 3, 1, 2, 2, 2};
            case 4:
            case 25:
            case '3':
            case '9':
            case 'J':
            case 145:
            case 224:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 5:
            case 16:
            case 'u':
                return new int[]{1, 2, 0, 1, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 4, 2, 2};
            case 7:
            case ',':
                return new int[]{3, 4, 3, 2, 2, 2};
            case '\b':
            case '?':
            case 'd':
            case 162:
            case 190:
            case 199:
            case bqk.f6555bO /* 216 */:
                return new int[]{4, 2, 2, 2, 2, 2};
            case '\t':
                return new int[]{2, 4, 1, 1, 2, 2};
            case '\n':
                return new int[]{2, 2, 2, 3, 2, 2};
            case 11:
            case '(':
            case 'g':
            case 188:
            case 193:
                return new int[]{0, 0, 0, 0, 0, 2};
            case '\f':
                return new int[]{0, 1, 0, 1, 2, 2};
            case '\r':
            case 'W':
                return new int[]{1, 2, 4, 4, 2, 2};
            case 14:
            case 'O':
            case 'z':
            case 142:
            case 172:
            case 192:
            case 195:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 154:
                return new int[]{3, 2, 4, 4, 2, 2};
            case 17:
            case 'F':
            case 'M':
                return new int[]{0, 2, 0, 0, 2, 2};
            case 18:
            case 151:
                return new int[]{2, 1, 3, 3, 2, 2};
            case 19:
                return new int[]{0, 0, 3, 3, 2, 2};
            case 20:
                return new int[]{4, 3, 4, 3, 2, 2};
            case 21:
            case '5':
            case 191:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 2, 2, 4, 4, 2};
            case 23:
            case ';':
            case 203:
            case bqk.f6549bI /* 210 */:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 3, 4, 2, 2};
            case 27:
                return new int[]{3, 2, 1, 1, 2, 2};
            case 28:
                return new int[]{1, 3, 3, 2, 2, 2};
            case 29:
                return new int[]{1, 2, 2, 0, 2, 2};
            case 30:
            case 198:
                return new int[]{2, 3, 2, 2, 2, 2};
            case 31:
                return new int[]{4, 2, 2, 3, 2, 2};
            case ' ':
                return new int[]{3, 1, 3, 2, 2, 2};
            case '!':
            case 'Y':
                return new int[]{3, 4, 1, 0, 2, 2};
            case '\"':
                return new int[]{0, 1, 1, 3, 2, 2};
            case '#':
                return new int[]{2, 4, 2, 2, 2, 2};
            case '$':
                return new int[]{0, 2, 1, 2, 4, 1};
            case '%':
                return new int[]{4, 2, 3, 1, 2, 2};
            case '&':
                return new int[]{4, 2, 3, 2, 2, 2};
            case '\'':
            case 150:
                return new int[]{2, 4, 3, 4, 2, 2};
            case ')':
                return new int[]{3, 3, 3, 4, 2, 2};
            case '*':
                return new int[]{2, 2, 2, 1, 2, 2};
            case '+':
            case 171:
            case bqk.f6559bS /* 221 */:
                return new int[]{1, 1, 2, 2, 3, 2};
            case '-':
                return new int[]{2, 0, 2, 2, 3, 1};
            case '.':
                return new int[]{2, 2, 4, 2, 2, 2};
            case '/':
                return new int[]{2, 2, 4, 4, 2, 2};
            case '0':
            case 168:
                return new int[]{4, 4, 3, 2, 2, 2};
            case '1':
                return new int[]{2, 3, 1, 0, 2, 2};
            case '2':
                return new int[]{2, 2, 0, 0, 2, 2};
            case '4':
                return new int[]{1, 0, 0, 0, 1, 2};
            case '6':
                return new int[]{0, 0, 2, 2, 1, 2};
            case '7':
                return new int[]{4, 1, 4, 4, 2, 2};
            case '8':
                return new int[]{0, 0, 1, 0, 0, 2};
            case ':':
            case 'j':
                return new int[]{3, 4, 4, 4, 2, 2};
            case '<':
                return new int[]{2, 4, 2, 1, 2, 2};
            case '=':
            case '~':
            case 128:
            case 146:
                return new int[]{0, 0, 0, 0, 2, 2};
            case '>':
                return new int[]{3, 4, 2, 3, 2, 2};
            case '@':
            case '`':
                return new int[]{0, 1, 1, 1, 2, 2};
            case 'A':
                return new int[]{4, 4, 3, 1, 2, 2};
            case 'B':
                return new int[]{0, 0, 0, 1, 0, 2};
            case 'C':
                return new int[]{3, 1, 3, 3, 2, 2};
            case 'D':
            case 'r':
            case 130:
            case 152:
            case 200:
                return new int[]{3, 2, 2, 2, 2, 2};
            case 'E':
                return new int[]{3, 2, 4, 2, 2, 2};
            case 'G':
                return new int[]{1, 1, 2, 1, 1, 1};
            case 'H':
                return new int[]{2, 3, 1, 1, 2, 2};
            case 'I':
                return new int[]{0, 0, 1, 1, 2, 3};
            case 'K':
                return new int[]{1, 1, 1, 3, 2, 2};
            case 'L':
            case 'S':
            case 143:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 'N':
                return new int[]{3, 2, 3, 2, 2, 2};
            case 'Q':
            case bqk.f6596cc /* 230 */:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 'R':
                return new int[]{4, 3, 4, 2, 2, 2};
            case 'T':
                return new int[]{4, 2, 3, 4, 2, 2};
            case 'U':
            case '\\':
            case 132:
            case 137:
            case 181:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 'V':
                return new int[]{2, 3, 2, 1, 2, 2};
            case 'X':
            case bqk.f6576bj /* 218 */:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 'Z':
                return new int[]{0, 1, 2, 3, 2, 0};
            case '[':
            case 170:
            case 197:
                return new int[]{3, 2, 3, 3, 2, 2};
            case '^':
                return new int[]{0, 0, 0, 1, 3, 2};
            case '_':
                return new int[]{3, 2, 3, 3, 3, 2};
            case 'a':
                return new int[]{1, 1, 2, 3, 4, 2};
            case 'b':
                return new int[]{0, 2, 0, 1, 2, 2};
            case 'c':
                return new int[]{1, 1, 3, 2, 4, 3};
            case 'e':
            case bqk.f6558bR /* 220 */:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 'f':
                return new int[]{3, 0, 1, 1, 3, 0};
            case 'h':
                return new int[]{0, 1, 0, 1, 1, 2};
            case 'i':
                return new int[]{3, 2, 1, 2, 2, 2};
            case 'k':
            case 133:
                return new int[]{1, 0, 0, 1, 2, 2};
            case 'l':
                return new int[]{0, 1, 0, 1, 1, 1};
            case 'm':
                return new int[]{3, 3, 2, 2, 2, 2};
            case 'n':
                return new int[]{2, 1, 1, 1, 2, 2};
            case 'o':
                return new int[]{1, 1, 4, 2, 2, 2};
            case 'p':
            case 'q':
            case 129:
            case 185:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 's':
                return new int[]{0, 0, 1, 3, 4, 4};
            case 't':
                return new int[]{1, 1, 0, 0, 0, 2};
            case 'v':
                return new int[]{1, 1, 2, 2, 2, 2};
            case 'w':
            case 222:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 'x':
                return new int[]{3, 2, 1, 4, 2, 2};
            case '{':
                return new int[]{3, 1, 3, 4, 4, 2};
            case '|':
                return new int[]{3, 4, 4, 3, 2, 2};
            case '}':
                return new int[]{3, 3, 4, 3, 2, 2};
            case 127:
                return new int[]{1, 0, 2, 2, 2, 2};
            case 131:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 134:
                return new int[]{1, 2, 1, 0, 2, 2};
            case 135:
                return new int[]{3, 4, 2, 2, 2, 2};
            case 136:
                return new int[]{3, 2, 2, 4, 2, 2};
            case 138:
                return new int[]{4, 3, 3, 1, 2, 2};
            case 139:
                return new int[]{2, 4, 3, 3, 2, 2};
            case 140:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 141:
                return new int[]{0, 2, 4, 4, 2, 2};
            case 144:
                return new int[]{4, 1, 3, 4, 2, 2};
            case 147:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 148:
                return new int[]{3, 4, 1, 4, 2, 2};
            case 149:
                return new int[]{4, 2, 1, 0, 2, 2};
            case 153:
                return new int[]{4, 3, 2, 2, 2, 2};
            case 156:
                return new int[]{3, 4, 1, 1, 2, 2};
            case 157:
                return new int[]{2, 3, 4, 3, 2, 2};
            case 158:
                return new int[]{0, 0, 3, 2, 0, 4};
            case 159:
                return new int[]{0, 0, 2, 0, 0, 2};
            case 160:
                return new int[]{2, 1, 4, 3, 2, 2};
            case 161:
                return new int[]{3, 2, 2, 0, 2, 2};
            case 163:
                return new int[]{1, 0, 1, 2, 4, 2};
            case 164:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 165:
                return new int[]{1, 3, 3, 3, 2, 2};
            case 166:
                return new int[]{2, 3, 4, 4, 4, 2};
            case 167:
                return new int[]{2, 3, 3, 1, 2, 2};
            case 169:
                return new int[]{2, 2, 3, 3, 3, 2};
            case 173:
                return new int[]{2, 3, 2, 2, 3, 3};
            case 174:
                return new int[]{3, 4, 1, 2, 2, 2};
            case 175:
                return new int[]{0, 1, 0, 0, 2, 2};
            case 176:
                return new int[]{2, 2, 4, 1, 2, 2};
            case 177:
                return new int[]{2, 2, 3, 2, 2, 2};
            case 178:
                return new int[]{2, 4, 2, 4, 4, 2};
            case 179:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 180:
                return new int[]{0, 0, 1, 1, 1, 2};
            case 182:
                return new int[]{0, 0, 0, 1, 2, 2};
            case 183:
                return new int[]{3, 4, 3, 0, 2, 2};
            case 184:
            case bqk.f6551bK /* 212 */:
            case 226:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 186:
                return new int[]{4, 3, 0, 2, 2, 2};
            case 189:
                return new int[]{1, 1, 2, 3, 1, 4};
            case 194:
                return new int[]{4, 3, 4, 1, 2, 2};
            case 201:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 202:
            case 205:
                return new int[]{2, 2, 1, 0, 2, 2};
            case 204:
                return new int[]{4, 3, 2, 4, 2, 2};
            case 207:
                return new int[]{3, 3, 2, 0, 2, 2};
            case 208:
                return new int[]{0, 3, 2, 3, 3, 0};
            case bqk.f6548bH /* 209 */:
                return new int[]{4, 2, 4, 4, 2, 2};
            case bqk.f6550bJ /* 211 */:
                return new int[]{4, 2, 4, 2, 2, 2};
            case bqk.f6552bL /* 213 */:
                return new int[]{4, 2, 3, 3, 2, 2};
            case bqk.f6553bM /* 214 */:
                return new int[]{1, 1, 0, 1, 2, 2};
            case bqk.f6554bN /* 215 */:
                return new int[]{1, 4, 1, 1, 2, 2};
            case bqk.f6556bP /* 217 */:
                return new int[]{0, 0, 0, 0, 0, 0};
            case bqk.f6557bQ /* 219 */:
                return new int[]{0, 3, 1, 1, 2, 2};
            case bqk.f6587bu /* 223 */:
                return new int[]{2, 2, 3, 4, 2, 2};
            case bqk.f6543bC /* 227 */:
                return new int[]{1, 2, 1, 3, 2, 2};
            case bqk.f6562bV /* 228 */:
                return new int[]{0, 3, 3, 4, 2, 2};
            case bqk.f6565bY /* 229 */:
                return new int[]{4, 2, 2, 1, 2, 2};
            case bqk.f6597cd /* 231 */:
                return new int[]{3, 1, 2, 1, 2, 2};
            case bqk.f6526am /* 232 */:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 234:
                return new int[]{4, 1, 1, 1, 2, 2};
            case 235:
                return new int[]{3, 3, 1, 1, 1, 2};
            case bqk.f6567ba /* 236 */:
                return new int[]{3, 3, 4, 2, 2, 2};
            case 237:
                return new int[]{3, 2, 4, 3, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }
}
