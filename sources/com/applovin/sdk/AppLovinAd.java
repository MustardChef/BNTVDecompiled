package com.applovin.sdk;

/* loaded from: classes.dex */
public interface AppLovinAd {
    long getAdIdNumber();

    String getAdValue(String str);

    String getAdValue(String str, String str2);

    AppLovinAdSize getSize();

    AppLovinAdType getType();

    String getZoneId();

    boolean isVideoAd();
}
