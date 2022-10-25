package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.InterfaceC1356a {

    /* renamed from: a */
    private static final Map<String, MaxRewardedAd> f2646a = new HashMap();

    /* renamed from: b */
    private static final Object f2647b = new Object();

    /* renamed from: c */
    private static WeakReference<Activity> f2648c = new WeakReference<>(null);

    /* renamed from: d */
    private final MaxFullscreenAdImpl f2649d;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.f2649d = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.coreSdk);
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        AbstractC1363a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (activity != null) {
                if (appLovinSdk != null) {
                    updateActivity(activity);
                    synchronized (f2647b) {
                        Map<String, MaxRewardedAd> map = f2646a;
                        MaxRewardedAd maxRewardedAd = map.get(str);
                        if (maxRewardedAd != null) {
                            return maxRewardedAd;
                        }
                        MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                        map.put(str, maxRewardedAd2);
                        return maxRewardedAd2;
                    }
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No activity specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public static void updateActivity(Activity activity) {
        AbstractC1363a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            f2648c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        this.f2649d.logApiCall("destroy()");
        synchronized (f2647b) {
            f2646a.remove(this.f2649d.getAdUnitId());
        }
        this.f2649d.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.InterfaceC1356a
    public Activity getActivity() {
        this.f2649d.logApiCall("getActivity()");
        return f2648c.get();
    }

    public String getAdUnitId() {
        return this.f2649d.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f2649d.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2649d;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f2649d.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f2649d.logApiCall("loadAd()");
        this.f2649d.loadAd(getActivity());
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2649d;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2649d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2649d;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f2649d.setListener(maxRewardedAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2649d;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2649d.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2649d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f2649d.showAd(str, getActivity());
    }

    public String toString() {
        return "" + this.f2649d;
    }
}
