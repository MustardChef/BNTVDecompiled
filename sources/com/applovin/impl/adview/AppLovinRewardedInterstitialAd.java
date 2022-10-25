package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

/* loaded from: classes.dex */
public class AppLovinRewardedInterstitialAd {

    /* renamed from: a */
    private final AppLovinIncentivizedInterstitial f278a;

    /* renamed from: b */
    private AppLovinAdDisplayListener f279b;

    /* renamed from: c */
    private AppLovinAdClickListener f280c;

    /* renamed from: d */
    private AppLovinAdVideoPlaybackListener f281d;

    public AppLovinRewardedInterstitialAd(AppLovinSdk appLovinSdk) {
        this.f278a = new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f280c = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f279b = appLovinAdDisplayListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f281d = appLovinAdVideoPlaybackListener;
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f278a.show(appLovinAd, context, appLovinAdRewardListener, this.f281d, this.f279b, this.f280c);
    }

    public String toString() {
        return "AppLovinRewardedInterstitialAd{}";
    }
}
