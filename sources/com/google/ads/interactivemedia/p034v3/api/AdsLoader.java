package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdsLoader */
/* loaded from: classes2.dex */
public interface AdsLoader {

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.AdsLoader$AdsLoadedListener */
    /* loaded from: classes2.dex */
    public interface AdsLoadedListener {
        void onAdsManagerLoaded(AdsManagerLoadedEvent adsManagerLoadedEvent);
    }

    void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void addAdsLoadedListener(AdsLoadedListener adsLoadedListener);

    @Deprecated
    void contentComplete();

    ImaSdkSettings getSettings();

    void release();

    void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdsLoadedListener(AdsLoadedListener adsLoadedListener);

    void requestAds(AdsRequest adsRequest);

    String requestStream(StreamRequest streamRequest);
}
