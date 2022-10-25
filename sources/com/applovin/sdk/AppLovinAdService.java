package com.applovin.sdk;

import java.util.List;

/* loaded from: classes.dex */
public interface AppLovinAdService {
    String getBidToken();

    @Deprecated
    boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize);

    @Deprecated
    boolean hasPreloadedAdForZoneId(String str);

    void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener);

    void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener);

    @Deprecated
    void preloadAd(AppLovinAdSize appLovinAdSize);

    @Deprecated
    void preloadAdForZoneId(String str);
}
