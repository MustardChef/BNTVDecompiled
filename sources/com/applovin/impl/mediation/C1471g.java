package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.mediation.p013a.C1341g;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.g */
/* loaded from: classes.dex */
public class C1471g {

    /* renamed from: b */
    private final C1662k f1305b;

    /* renamed from: c */
    private final C1710r f1306c;

    /* renamed from: d */
    private final String f1307d;

    /* renamed from: e */
    private final C1338e f1308e;

    /* renamed from: f */
    private final String f1309f;

    /* renamed from: g */
    private MaxAdapter f1310g;

    /* renamed from: h */
    private String f1311h;

    /* renamed from: i */
    private AbstractC1334a f1312i;

    /* renamed from: j */
    private View f1313j;

    /* renamed from: k */
    private MaxNativeAd f1314k;

    /* renamed from: l */
    private View f1315l;

    /* renamed from: n */
    private MaxAdapterResponseParameters f1317n;

    /* renamed from: a */
    private final Handler f1304a = new Handler(Looper.getMainLooper());

    /* renamed from: m */
    private final C1489a f1316m = new C1489a(this, null);

    /* renamed from: o */
    private final AtomicBoolean f1318o = new AtomicBoolean(true);

    /* renamed from: p */
    private final AtomicBoolean f1319p = new AtomicBoolean(false);

    /* renamed from: q */
    private final AtomicBoolean f1320q = new AtomicBoolean(false);

    /* renamed from: com.applovin.impl.mediation.g$1 */
    /* loaded from: classes.dex */
    class RunnableC14721 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ MaxAdapterInitializationParameters f1321a;

        /* renamed from: b */
        final /* synthetic */ Activity f1322b;

        RunnableC14721(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
            this.f1321a = maxAdapterInitializationParameters;
            this.f1322b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6319b("MediationAdapterWrapper", "Initializing " + C1471g.this.f1309f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + C1471g.this.f1308e.m7757Q());
            C1471g.this.f1310g.initialize(this.f1321a, this.f1322b, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.g.1.1
                @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.g.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C1471g.this.f1305b.m6685B().m7340a(C1471g.this.f1308e, SystemClock.elapsedRealtime() - elapsedRealtime, initializationStatus, str);
                        }
                    }, C1471g.this.f1308e.m7754T());
                }
            });
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$a */
    /* loaded from: classes.dex */
    private class C1489a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxNativeAdAdapterListener, MaxRewardedAdapterListener, MaxRewardedInterstitialAdapterListener {

        /* renamed from: b */
        private MediationServiceImpl.C1330a f1369b;

        private C1489a() {
        }

        /* synthetic */ C1489a(C1471g c1471g, RunnableC14721 runnableC14721) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m7290a(MediationServiceImpl.C1330a c1330a) {
            if (c1330a == null) {
                throw new IllegalArgumentException("No listener specified");
            }
            this.f1369b = c1330a;
        }

        /* renamed from: a */
        private void m7286a(String str, final Bundle bundle) {
            C1471g.this.f1320q.set(true);
            m7285a(str, this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C1471g.this.f1319p.compareAndSet(false, true)) {
                        C1489a.this.f1369b.m7823a(C1471g.this.f1312i, bundle);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m7285a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            C1471g.this.f1304a.post(new Runnable() { // from class: com.applovin.impl.mediation.g.a.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener2 = maxAdListener;
                        String name = maxAdListener2 != null ? maxAdListener2.getClass().getName() : null;
                        C1710r.m6316c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, e);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m7284a(String str, final MaxError maxError) {
            m7285a(str, this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (C1471g.this.f1319p.compareAndSet(false, true)) {
                        C1489a.this.f1369b.onAdLoadFailed(C1471g.this.f1311h, maxError);
                    }
                }
            });
        }

        /* renamed from: b */
        private void m7282b(String str, final Bundle bundle) {
            if (C1471g.this.f1312i.m7803o().compareAndSet(false, true)) {
                m7285a(str, this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.15
                    @Override // java.lang.Runnable
                    public void run() {
                        C1489a.this.f1369b.m7822b(C1471g.this.f1312i, bundle);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m7281b(String str, final MaxError maxError) {
            m7285a(str, this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.16
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdDisplayFailed(C1471g.this.f1312i, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad clicked");
            m7285a("onAdViewAdClicked", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.8
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdClicked(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad collapsed");
            m7285a("onAdViewAdCollapsed", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.11
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdCollapsed(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad failed to display with error: " + maxAdapterError);
            m7281b("onAdViewAdDisplayFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad displayed with extra info: " + bundle);
            m7282b("onAdViewAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad expanded");
            m7285a("onAdViewAdExpanded", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.10
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdExpanded(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad hidden");
            m7285a("onAdViewAdHidden", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.9
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdHidden(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad ad failed to load with error: " + maxAdapterError);
            m7284a("onAdViewAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view, Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": adview ad loaded with extra info: " + bundle);
            C1471g.this.f1313j = view;
            m7286a("onAdViewAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad clicked");
            m7285a("onInterstitialAdClicked", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.17
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdClicked(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad failed to display with error " + maxAdapterError);
            m7281b("onInterstitialAdDisplayFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad displayed with extra info: " + bundle);
            m7282b("onInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad hidden");
            m7285a("onInterstitialAdHidden", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.18
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdHidden(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad failed to load with error " + maxAdapterError);
            m7284a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": interstitial ad loaded with extra info: " + bundle);
            m7286a("onInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": native ad clicked");
            m7285a("onNativeAdClicked", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.13
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdClicked(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": native ad failed to display with error: " + maxAdapterError);
            m7281b("onNativeAdDisplayFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayed(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": native ad displayed with extra info: " + bundle);
            m7282b("onNativeAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": native ad ad failed to load with error: " + maxAdapterError);
            m7284a("onNativeAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, View view, Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": native ad loaded with extra info: " + bundle);
            C1471g.this.f1314k = maxNativeAd;
            C1471g.this.f1315l = view;
            m7286a("onNativeAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad clicked");
            m7285a("onRewardedAdClicked", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.19
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdClicked(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad display failed with error: " + maxAdapterError);
            m7281b("onRewardedAdDisplayFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad displayed with extra info: " + bundle);
            m7282b("onRewardedAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad hidden");
            m7285a("onRewardedAdHidden", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.20
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdHidden(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m7284a("onRewardedAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded() {
            onRewardedAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad loaded with extra info: " + bundle);
            m7286a("onRewardedAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoCompleted() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded video completed");
            m7285a("onRewardedAdVideoCompleted", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.3
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onRewardedVideoCompleted(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdVideoStarted() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded video started");
            m7285a("onRewardedAdVideoStarted", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.2
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onRewardedVideoStarted(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdClicked() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial ad clicked");
            m7285a("onRewardedInterstitialAdClicked", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.4
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdClicked(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial ad display failed with error: " + maxAdapterError);
            m7281b("onRewardedInterstitialAdDisplayFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed() {
            onRewardedInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdDisplayed(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial ad displayed with extra info: " + bundle);
            m7282b("onRewardedInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdHidden() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial ad hidden");
            m7285a("onRewardedInterstitialAdHidden", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.5
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onAdHidden(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6315d("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded ad failed to load with error: " + maxAdapterError);
            m7284a("onRewardedInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded() {
            onRewardedInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdLoaded(Bundle bundle) {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial ad loaded with extra info: " + bundle);
            m7286a("onRewardedInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoCompleted() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial completed");
            m7285a("onRewardedInterstitialAdVideoCompleted", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.7
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onRewardedVideoCompleted(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onRewardedInterstitialAdVideoStarted() {
            C1710r c1710r = C1471g.this.f1306c;
            c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": rewarded interstitial started");
            m7285a("onRewardedInterstitialAdVideoStarted", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.6
                @Override // java.lang.Runnable
                public void run() {
                    C1489a.this.f1369b.onRewardedVideoStarted(C1471g.this.f1312i);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener, com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener
        public void onUserRewarded(final MaxReward maxReward) {
            if (C1471g.this.f1312i instanceof C1336c) {
                final C1336c c1336c = (C1336c) C1471g.this.f1312i;
                if (c1336c.m7779G().compareAndSet(false, true)) {
                    C1710r c1710r = C1471g.this.f1306c;
                    c1710r.m6317c("MediationAdapterWrapper", C1471g.this.f1309f + ": user was rewarded: " + maxReward);
                    m7285a("onUserRewarded", this.f1369b, new Runnable() { // from class: com.applovin.impl.mediation.g.a.21
                        @Override // java.lang.Runnable
                        public void run() {
                            C1489a.this.f1369b.onUserRewarded(c1336c, maxReward);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.g$b */
    /* loaded from: classes.dex */
    public static class C1511b {

        /* renamed from: a */
        private final C1341g f1400a;

        /* renamed from: b */
        private final MaxSignalCollectionListener f1401b;

        /* renamed from: c */
        private final AtomicBoolean f1402c = new AtomicBoolean();

        C1511b(C1341g c1341g, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f1400a = c1341g;
            this.f1401b = maxSignalCollectionListener;
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$c */
    /* loaded from: classes.dex */
    private class C1512c extends AbstractRunnableC1589a {
        private C1512c() {
            super("TaskTimeoutMediatedAd", C1471g.this.f1305b);
        }

        /* synthetic */ C1512c(C1471g c1471g, RunnableC14721 runnableC14721) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1471g.this.f1319p.get()) {
                return;
            }
            m6879d(C1471g.this.f1309f + " is timing out " + C1471g.this.f1312i + "...");
            this.f2058b.m6681F().m7277a(C1471g.this.f1312i);
            C1471g.this.f1316m.m7284a(m6878e(), new MaxErrorImpl(-5101, "Adapter timed out"));
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$d */
    /* loaded from: classes.dex */
    private class C1513d extends AbstractRunnableC1589a {

        /* renamed from: c */
        private final C1511b f1405c;

        private C1513d(C1511b c1511b) {
            super("TaskTimeoutSignalCollection", C1471g.this.f1305b);
            this.f1405c = c1511b;
        }

        /* synthetic */ C1513d(C1471g c1471g, C1511b c1511b, RunnableC14721 runnableC14721) {
            this(c1511b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1405c.f1402c.get()) {
                return;
            }
            m6879d(C1471g.this.f1309f + " is timing out " + this.f1405c.f1400a + "...");
            C1471g c1471g = C1471g.this;
            c1471g.m7308b("The adapter (" + C1471g.this.f1309f + ") timed out", this.f1405c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1471g(C1338e c1338e, MaxAdapter maxAdapter, C1662k c1662k) {
        if (c1338e == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f1307d = c1338e.m7763K();
        this.f1310g = maxAdapter;
        this.f1305b = c1662k;
        this.f1306c = c1662k.m6588z();
        this.f1308e = c1338e;
        this.f1309f = maxAdapter.getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7317a(String str) {
        C1710r c1710r = this.f1306c;
        c1710r.m6317c("MediationAdapterWrapper", "Marking " + this.f1309f + " as disabled due to: " + str);
        this.f1318o.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7315a(String str, C1511b c1511b) {
        if (!c1511b.f1402c.compareAndSet(false, true) || c1511b.f1401b == null) {
            return;
        }
        c1511b.f1401b.onSignalCollected(str);
    }

    /* renamed from: a */
    private void m7313a(final String str, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.mediation.g.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1710r c1710r = C1471g.this.f1306c;
                    c1710r.m6319b("MediationAdapterWrapper", C1471g.this.f1309f + ": running " + str + "...");
                    runnable.run();
                    C1710r c1710r2 = C1471g.this.f1306c;
                    c1710r2.m6319b("MediationAdapterWrapper", C1471g.this.f1309f + ": finished " + str + "");
                } catch (Throwable th) {
                    C1710r.m6316c("MediationAdapterWrapper", "Unable to run adapter operation " + str + ", marking " + C1471g.this.f1309f + " as disabled", th);
                    C1471g c1471g = C1471g.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fail_");
                    sb.append(str);
                    c1471g.m7317a(sb.toString());
                    if (str.equals("destroy")) {
                        return;
                    }
                    C1471g.this.f1305b.m6686A().m7331a(C1471g.this.f1308e.m7764J(), str, C1471g.this.f1312i);
                }
            }
        };
        if (this.f1308e.m7757Q()) {
            this.f1304a.post(runnable2);
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7308b(String str, C1511b c1511b) {
        if (!c1511b.f1402c.compareAndSet(false, true) || c1511b.f1401b == null) {
            return;
        }
        c1511b.f1401b.onSignalCollectionFailed(str);
    }

    /* renamed from: a */
    public View m7327a() {
        return this.f1313j;
    }

    /* renamed from: a */
    public void m7326a(final AbstractC1334a abstractC1334a, final Activity activity) {
        final Runnable runnable;
        if (abstractC1334a == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (abstractC1334a.m7812f() == null) {
            C1710r.m6310i("MediationAdapterWrapper", "Adapter has been garbage collected");
            this.f1316m.m7281b("ad_show", new MaxErrorImpl(-1, "Adapter has been garbage collected"));
        } else if (abstractC1334a.m7812f() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else {
            if (activity == null) {
                throw new IllegalArgumentException("No activity specified");
            }
            if (!this.f1318o.get()) {
                String str = "Mediation adapter '" + this.f1309f + "' is disabled. Showing ads with this adapter is disabled.";
                C1710r.m6310i("MediationAdapterWrapper", str);
                this.f1316m.m7281b("ad_show", new MaxErrorImpl(-1, str));
            } else if (!m7303e()) {
                throw new IllegalStateException("Mediation adapter '" + this.f1309f + "' does not have an ad loaded. Please load an ad first");
            } else {
                if (abstractC1334a.getFormat() == MaxAdFormat.INTERSTITIAL) {
                    runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.13
                        @Override // java.lang.Runnable
                        public void run() {
                            ((MaxInterstitialAdapter) C1471g.this.f1310g).showInterstitialAd(C1471g.this.f1317n, activity, C1471g.this.f1316m);
                        }
                    };
                } else if (abstractC1334a.getFormat() == MaxAdFormat.REWARDED) {
                    runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.14
                        @Override // java.lang.Runnable
                        public void run() {
                            ((MaxRewardedAdapter) C1471g.this.f1310g).showRewardedAd(C1471g.this.f1317n, activity, C1471g.this.f1316m);
                        }
                    };
                } else if (abstractC1334a.getFormat() != MaxAdFormat.REWARDED_INTERSTITIAL) {
                    throw new IllegalStateException("Failed to show " + abstractC1334a + ": " + abstractC1334a.getFormat() + " is not a supported ad format");
                } else {
                    runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ((MaxRewardedInterstitialAdapter) C1471g.this.f1310g).showRewardedInterstitialAd(C1471g.this.f1317n, activity, C1471g.this.f1316m);
                        }
                    };
                }
                m7313a("show_ad", new Runnable() { // from class: com.applovin.impl.mediation.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            String str2 = "Failed to start displaying ad" + abstractC1334a + " : " + th;
                            C1710r.m6310i("MediationAdapterWrapper", str2);
                            C1471g.this.f1316m.m7281b("show_ad", new MaxErrorImpl(MaxAdapterError.ERROR_CODE_UNSPECIFIED, str2));
                            C1471g.this.m7317a("show_ad");
                            C1471g.this.f1305b.m6686A().m7331a(C1471g.this.f1308e.m7764J(), "show_ad", C1471g.this.f1312i);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7319a(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        m7313a("initialize", new RunnableC14721(maxAdapterInitializationParameters, activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7318a(final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final C1341g c1341g, final Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!this.f1318o.get()) {
            C1710r.m6310i("MediationAdapterWrapper", "Mediation adapter '" + this.f1309f + "' is disabled. Signal collection ads with this adapter is disabled.");
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f1309f + ") is disabled");
            return;
        }
        final C1511b c1511b = new C1511b(c1341g, maxSignalCollectionListener);
        MaxAdapter maxAdapter = this.f1310g;
        if (maxAdapter instanceof MaxSignalProvider) {
            final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
            m7313a("collect_signal", new Runnable() { // from class: com.applovin.impl.mediation.g.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new MaxSignalCollectionListener() { // from class: com.applovin.impl.mediation.g.4.1
                            @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                            public void onSignalCollected(String str) {
                                C1471g.this.m7315a(str, c1511b);
                            }

                            @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                            public void onSignalCollectionFailed(String str) {
                                C1471g.this.m7308b(str, c1511b);
                            }
                        });
                    } catch (Throwable th) {
                        C1471g c1471g = C1471g.this;
                        c1471g.m7308b("Failed signal collection for " + C1471g.this.f1307d + " due to exception: " + th, c1511b);
                        C1471g.this.m7317a("collect_signal");
                        C1471g.this.f1305b.m6686A().m7331a(C1471g.this.f1308e.m7764J(), "collect_signal", C1471g.this.f1312i);
                    }
                    if (c1511b.f1402c.get()) {
                        return;
                    }
                    if (c1341g.m7755S() == 0) {
                        C1710r c1710r = C1471g.this.f1306c;
                        c1710r.m6319b("MediationAdapterWrapper", "Failing signal collection " + c1341g + " since it has 0 timeout");
                        C1471g c1471g2 = C1471g.this;
                        c1471g2.m7308b("The adapter (" + C1471g.this.f1309f + ") has 0 timeout", c1511b);
                        return;
                    }
                    int i = (c1341g.m7755S() > 0L ? 1 : (c1341g.m7755S() == 0L ? 0 : -1));
                    C1710r c1710r2 = C1471g.this.f1306c;
                    if (i <= 0) {
                        c1710r2.m6319b("MediationAdapterWrapper", "Negative timeout set for " + c1341g + ", not scheduling a timeout");
                        return;
                    }
                    c1710r2.m6319b("MediationAdapterWrapper", "Setting timeout " + c1341g.m7755S() + "ms. for " + c1341g);
                    C1471g.this.f1305b.m6670Q().m6792a(new C1513d(C1471g.this, c1511b, null), C1620o.EnumC1622a.MEDIATION_TIMEOUT, c1341g.m7755S());
                }
            });
            return;
        }
        m7308b("The adapter (" + this.f1309f + ") does not support signal collection", c1511b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7316a(String str, AbstractC1334a abstractC1334a) {
        this.f1311h = str;
        this.f1312i = abstractC1334a;
    }

    /* renamed from: a */
    public void m7314a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final AbstractC1334a abstractC1334a, final Activity activity, MediationServiceImpl.C1330a c1330a) {
        final Runnable runnable;
        if (abstractC1334a == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (!this.f1318o.get()) {
            String str2 = "Mediation adapter '" + this.f1309f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
            C1710r.m6310i("MediationAdapterWrapper", str2);
            c1330a.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
            return;
        }
        this.f1317n = maxAdapterResponseParameters;
        this.f1316m.m7290a(c1330a);
        if (abstractC1334a.getFormat() == MaxAdFormat.INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.7
                @Override // java.lang.Runnable
                public void run() {
                    ((MaxInterstitialAdapter) C1471g.this.f1310g).loadInterstitialAd(maxAdapterResponseParameters, activity, C1471g.this.f1316m);
                }
            };
        } else if (abstractC1334a.getFormat() == MaxAdFormat.REWARDED) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.8
                @Override // java.lang.Runnable
                public void run() {
                    ((MaxRewardedAdapter) C1471g.this.f1310g).loadRewardedAd(maxAdapterResponseParameters, activity, C1471g.this.f1316m);
                }
            };
        } else if (abstractC1334a.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.9
                @Override // java.lang.Runnable
                public void run() {
                    ((MaxRewardedInterstitialAdapter) C1471g.this.f1310g).loadRewardedInterstitialAd(maxAdapterResponseParameters, activity, C1471g.this.f1316m);
                }
            };
        } else if (abstractC1334a.getFormat() == MaxAdFormat.NATIVE) {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.10
                @Override // java.lang.Runnable
                public void run() {
                    ((MaxNativeAdAdapter) C1471g.this.f1310g).loadNativeAd(maxAdapterResponseParameters, activity, C1471g.this.f1316m);
                }
            };
        } else if (!abstractC1334a.getFormat().isAdViewAd()) {
            throw new IllegalStateException("Failed to load " + abstractC1334a + ": " + abstractC1334a.getFormat() + " is not a supported ad format");
        } else {
            runnable = new Runnable() { // from class: com.applovin.impl.mediation.g.11
                @Override // java.lang.Runnable
                public void run() {
                    ((MaxAdViewAdapter) C1471g.this.f1310g).loadAdViewAd(maxAdapterResponseParameters, abstractC1334a.getFormat(), activity, C1471g.this.f1316m);
                }
            };
        }
        m7313a("load_ad", new Runnable() { // from class: com.applovin.impl.mediation.g.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    String str3 = "Failed start loading " + abstractC1334a + " : " + th;
                    C1710r.m6310i("MediationAdapterWrapper", str3);
                    C1471g.this.f1316m.m7284a("load_ad", new MaxErrorImpl(-1, str3));
                    C1471g.this.m7317a("load_ad");
                    C1471g.this.f1305b.m6686A().m7331a(C1471g.this.f1308e.m7764J(), "load_ad", C1471g.this.f1312i);
                }
                if (C1471g.this.f1319p.get()) {
                    return;
                }
                long m7755S = C1471g.this.f1308e.m7755S();
                if (m7755S <= 0) {
                    C1471g.this.f1306c.m6319b("MediationAdapterWrapper", "Negative timeout set for " + abstractC1334a + ", not scheduling a timeout");
                    return;
                }
                C1471g.this.f1306c.m6319b("MediationAdapterWrapper", "Setting timeout " + m7755S + "ms. for " + abstractC1334a);
                C1471g.this.f1305b.m6670Q().m6792a(new C1512c(C1471g.this, null), C1620o.EnumC1622a.MEDIATION_TIMEOUT, m7755S);
            }
        });
    }

    /* renamed from: b */
    public String m7312b() {
        return this.f1307d;
    }

    /* renamed from: c */
    public MediationServiceImpl.C1330a m7307c() {
        return this.f1316m.f1369b;
    }

    /* renamed from: d */
    public boolean m7305d() {
        return this.f1318o.get();
    }

    /* renamed from: e */
    public boolean m7303e() {
        return this.f1319p.get() && this.f1320q.get();
    }

    /* renamed from: f */
    public String m7301f() {
        MaxAdapter maxAdapter = this.f1310g;
        if (maxAdapter != null) {
            try {
                return maxAdapter.getSdkVersion();
            } catch (Throwable th) {
                C1710r.m6316c("MediationAdapterWrapper", "Unable to get adapter's SDK version, marking " + this + " as disabled", th);
                m7317a("sdk_version");
                this.f1305b.m6686A().m7331a(this.f1308e.m7764J(), "sdk_version", this.f1312i);
                return null;
            }
        }
        return null;
    }

    /* renamed from: g */
    public String m7299g() {
        MaxAdapter maxAdapter = this.f1310g;
        if (maxAdapter != null) {
            try {
                return maxAdapter.getAdapterVersion();
            } catch (Throwable th) {
                C1710r.m6316c("MediationAdapterWrapper", "Unable to get adapter version, marking " + this + " as disabled", th);
                m7317a("adapter_version");
                this.f1305b.m6686A().m7331a(this.f1308e.m7764J(), "adapter_version", this.f1312i);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m7297h() {
        m7313a("destroy", new Runnable() { // from class: com.applovin.impl.mediation.g.5
            @Override // java.lang.Runnable
            public void run() {
                C1471g.this.m7317a("destroy");
                C1471g.this.f1310g.onDestroy();
                C1471g.this.f1310g = null;
            }
        });
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f1309f + "'}";
    }
}
