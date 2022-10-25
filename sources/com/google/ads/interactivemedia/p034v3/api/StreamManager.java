package com.google.ads.interactivemedia.p034v3.api;

import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.StreamManager */
/* loaded from: classes2.dex */
public interface StreamManager extends BaseManager {
    @Deprecated
    double getContentTimeForStreamTime(double d);

    long getContentTimeMsForStreamTimeMs(long j);

    List<CuePoint> getCuePoints();

    @Deprecated
    CuePoint getPreviousCuePointForStreamTime(double d);

    CuePoint getPreviousCuePointForStreamTimeMs(long j);

    String getStreamId();

    @Deprecated
    double getStreamTimeForContentTime(double d);

    long getStreamTimeMsForContentTimeMs(long j);

    void replaceAdTagParameters(Map<String, String> map);
}
