package com.google.ads.interactivemedia.p034v3.api;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdEvent */
/* loaded from: classes2.dex */
public interface AdEvent {

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener */
    /* loaded from: classes2.dex */
    public interface AdEventListener {
        void onAdEvent(AdEvent adEvent);
    }

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType */
    /* loaded from: classes2.dex */
    public enum AdEventType {
        ALL_ADS_COMPLETED,
        AD_BREAK_FETCH_ERROR,
        CLICKED,
        COMPLETED,
        CUEPOINTS_CHANGED,
        CONTENT_PAUSE_REQUESTED,
        CONTENT_RESUME_REQUESTED,
        FIRST_QUARTILE,
        LOG,
        AD_BREAK_READY,
        MIDPOINT,
        PAUSED,
        RESUMED,
        SKIPPABLE_STATE_CHANGED,
        SKIPPED,
        STARTED,
        TAPPED,
        ICON_TAPPED,
        ICON_FALLBACK_IMAGE_CLOSED,
        THIRD_QUARTILE,
        LOADED,
        AD_PROGRESS,
        AD_BUFFERING,
        AD_BREAK_STARTED,
        AD_BREAK_ENDED,
        AD_PERIOD_STARTED,
        AD_PERIOD_ENDED
    }

    IMASDK getAd();

    Map<String, String> getAdData();

    AdEventType getType();
}
