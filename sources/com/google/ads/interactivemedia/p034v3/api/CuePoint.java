package com.google.ads.interactivemedia.p034v3.api;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.CuePoint */
/* loaded from: classes2.dex */
public interface CuePoint {
    @Deprecated
    double getEndTime();

    long getEndTimeMs();

    @Deprecated
    double getStartTime();

    long getStartTimeMs();

    boolean isPlayed();
}
