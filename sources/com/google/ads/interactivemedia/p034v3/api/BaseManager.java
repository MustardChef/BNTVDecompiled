package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.BaseManager */
/* loaded from: classes2.dex */
public interface BaseManager extends AdProgressProvider {
    void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void addAdEventListener(AdEvent.AdEventListener adEventListener);

    void destroy();

    void focus();

    AdProgressInfo getAdProgressInfo();

    IMASDK getCurrentAd();

    void init();

    void init(AdsRenderingSettings adsRenderingSettings);

    @Deprecated
    boolean isCustomPlaybackUsed();

    void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener);

    void removeAdEventListener(AdEvent.AdEventListener adEventListener);
}
