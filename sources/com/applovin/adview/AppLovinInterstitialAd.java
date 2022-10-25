package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.C1304q;
import com.applovin.impl.sdk.C1710r;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AppLovinInterstitialAd {

    /* renamed from: b */
    private static C1304q f171b;

    /* renamed from: a */
    private static final Object f170a = new Object();

    /* renamed from: c */
    private static WeakReference<Context> f172c = new WeakReference<>(null);

    /* renamed from: a */
    private static C1304q m8435a(AppLovinSdk appLovinSdk, Context context) {
        synchronized (f170a) {
            f171b = new C1304q(appLovinSdk, context);
            f172c = new WeakReference<>(context);
        }
        return f171b;
    }

    /* renamed from: b */
    private static C1304q m8434b(AppLovinSdk appLovinSdk, Context context) {
        synchronized (f170a) {
            if (f171b == null || f172c.get() != context) {
                C1710r.m6311h("AppLovinInterstitialAd", "No interstitial dialog was previously created or was created with a different context. Creating new interstitial dialog");
                f171b = new C1304q(appLovinSdk, context);
                f172c = new WeakReference<>(context);
            }
        }
        return f171b;
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk != null) {
            if (context != null) {
                return m8435a(appLovinSdk, context);
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    @Deprecated
    public static boolean isAdReadyToDisplay(Context context) {
        return AppLovinSdk.getInstance(context).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    @Deprecated
    public static void show(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        m8434b(AppLovinSdk.getInstance(context), context).show();
    }

    public String toString() {
        return "AppLovinInterstitialAd{}";
    }
}
