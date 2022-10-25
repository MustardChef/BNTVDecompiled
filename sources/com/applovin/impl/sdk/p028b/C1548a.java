package com.applovin.impl.sdk.p028b;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1543h;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1635u;
import com.applovin.impl.sdk.p031e.C1643z;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.a */
/* loaded from: classes.dex */
public class C1548a {

    /* renamed from: a */
    protected final C1662k f1560a;

    /* renamed from: b */
    protected final AppLovinAdServiceImpl f1561b;

    /* renamed from: c */
    private AppLovinAd f1562c;

    /* renamed from: d */
    private String f1563d;

    /* renamed from: e */
    private SoftReference<AppLovinAdLoadListener> f1564e;

    /* renamed from: g */
    private volatile String f1566g;

    /* renamed from: f */
    private final Object f1565f = new Object();

    /* renamed from: h */
    private volatile boolean f1567h = false;

    /* renamed from: com.applovin.impl.sdk.b.a$a */
    /* loaded from: classes.dex */
    private class C1550a implements AppLovinAdLoadListener {

        /* renamed from: b */
        private final AppLovinAdLoadListener f1570b;

        C1550a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f1570b = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            C1548a.this.f1562c = appLovinAd;
            if (this.f1570b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1550a.this.f1570b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            C1710r.m6316c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                        }
                    }
                });
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(final int i) {
            if (this.f1570b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1550a.this.f1570b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            C1710r.m6316c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.b.a$b */
    /* loaded from: classes.dex */
    public class C1553b implements InterfaceC1544i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b */
        private final AppLovinAdDisplayListener f1576b;

        /* renamed from: c */
        private final AppLovinAdClickListener f1577c;

        /* renamed from: d */
        private final AppLovinAdVideoPlaybackListener f1578d;

        /* renamed from: e */
        private final AppLovinAdRewardListener f1579e;

        private C1553b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f1576b = appLovinAdDisplayListener;
            this.f1577c = appLovinAdClickListener;
            this.f1578d = appLovinAdVideoPlaybackListener;
            this.f1579e = appLovinAdRewardListener;
        }

        /* renamed from: a */
        private void m7035a(AbstractC1537g abstractC1537g) {
            int i;
            String str;
            String m7038e = C1548a.this.m7038e();
            if (!StringUtils.isValidString(m7038e) || !C1548a.this.f1567h) {
                C1710r m6588z = C1548a.this.f1560a.m6588z();
                m6588z.m6314e("IncentivizedAdController", "Invalid reward state - result: " + m7038e + " and wasFullyEngaged: " + C1548a.this.f1567h);
                C1548a.this.f1560a.m6588z().m6319b("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                abstractC1537g.m7132aH();
                if (C1548a.this.f1567h) {
                    C1548a.this.f1560a.m6588z().m6314e("IncentivizedAdController", "User close the ad after fully watching but reward validation task did not return on time");
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    C1548a.this.f1560a.m6588z().m6314e("IncentivizedAdController", "User close the ad prematurely");
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                abstractC1537g.m7141a(C1565c.m7020a(str));
                C1548a.this.f1560a.m6588z().m6319b("IncentivizedAdController", "Notifying listener of reward validation failure");
                C1728i.m6226a(this.f1579e, abstractC1537g, i);
            }
            C1548a.this.m7050a(abstractC1537g);
            C1548a.this.f1560a.m6588z().m6319b("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            C1728i.m6216b(this.f1576b, abstractC1537g);
            if (abstractC1537g.m7120af().getAndSet(true)) {
                return;
            }
            C1548a.this.f1560a.m6588z().m6319b("IncentivizedAdController", "Scheduling report rewarded ad...");
            C1548a.this.f1560a.m6670Q().m6793a(new C1635u(abstractC1537g, C1548a.this.f1560a), C1620o.EnumC1622a.REWARD);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            C1728i.m6229a(this.f1577c, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            C1728i.m6228a(this.f1576b, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof C1543h) {
                appLovinAd = ((C1543h) appLovinAd).m7068a();
            }
            if (appLovinAd instanceof AbstractC1537g) {
                m7035a((AbstractC1537g) appLovinAd);
                return;
            }
            C1710r m6588z = C1548a.this.f1560a.m6588z();
            m6588z.m6314e("IncentivizedAdController", "Something is terribly wrong. Received `adHidden` callback for invalid ad of type: " + appLovinAd);
        }

        @Override // com.applovin.impl.sdk.p027a.InterfaceC1544i
        public void onAdDisplayFailed(String str) {
            C1728i.m6227a(this.f1576b, str);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            C1548a.this.m7045a("quota_exceeded");
            C1728i.m6215b(this.f1579e, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            C1548a.this.m7045a("rejected");
            C1728i.m6211c(this.f1579e, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            C1548a.this.m7045a("accepted");
            C1728i.m6225a(this.f1579e, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            C1548a.this.m7045a("network_timeout");
            C1728i.m6226a(this.f1579e, appLovinAd, i);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            C1728i.m6224a(this.f1578d, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            C1728i.m6223a(this.f1578d, appLovinAd, d, z);
            C1548a.this.f1567h = z;
        }
    }

    public C1548a(String str, AppLovinSdk appLovinSdk) {
        this.f1560a = appLovinSdk.coreSdk;
        this.f1561b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f1563d = str;
    }

    /* renamed from: a */
    private void m7056a(AppLovinAdBase appLovinAdBase, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdBase.getType() != AppLovinAdType.INCENTIVIZED && appLovinAdBase.getType() != AppLovinAdType.AUTO_INCENTIVIZED) {
            C1710r m6588z = this.f1560a.m6588z();
            m6588z.m6314e("IncentivizedAdController", "Failed to render an ad of type " + appLovinAdBase.getType() + " in an Incentivized Ad interstitial.");
            m7047a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAdBase, this.f1560a);
        if (maybeRetrieveNonDummyAd == null) {
            m7047a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f1560a.m6664W(), context);
        C1553b c1553b = new C1553b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        create.setAdDisplayListener(c1553b);
        create.setAdVideoPlaybackListener(c1553b);
        create.setAdClickListener(c1553b);
        create.showAndRender(maybeRetrieveNonDummyAd);
        if (maybeRetrieveNonDummyAd instanceof AbstractC1537g) {
            m7055a((AbstractC1537g) maybeRetrieveNonDummyAd, c1553b);
        }
    }

    /* renamed from: a */
    private void m7055a(AbstractC1537g abstractC1537g, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f1560a.m6670Q().m6793a(new C1643z(abstractC1537g, appLovinAdRewardListener, this.f1560a), C1620o.EnumC1622a.REWARD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7050a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f1562c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof C1543h) {
                if (appLovinAd != ((C1543h) appLovinAd2).m7068a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f1562c = null;
        }
    }

    /* renamed from: a */
    private void m7049a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f1562c;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        if (appLovinAdBase != null) {
            m7056a(appLovinAdBase, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1710r.m6310i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m7039d();
    }

    /* renamed from: a */
    private void m7047a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f1560a.m6669R().m6893a(C1586f.f2041j);
        C1728i.m6223a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        C1728i.m6216b(appLovinAdDisplayListener, appLovinAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7045a(String str) {
        synchronized (this.f1565f) {
            this.f1566g = str;
        }
    }

    /* renamed from: b */
    private void m7041b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1561b.loadNextIncentivizedAd(this.f1563d, appLovinAdLoadListener);
    }

    /* renamed from: d */
    private void m7039d() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference<AppLovinAdLoadListener> softReference = this.f1564e;
        if (softReference == null || (appLovinAdLoadListener = softReference.get()) == null) {
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m7038e() {
        String str;
        synchronized (this.f1565f) {
            str = this.f1566g;
        }
        return str;
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m7037f() {
        return new AppLovinAdRewardListener() { // from class: com.applovin.impl.sdk.b.a.1
            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                C1548a.this.f1560a.m6588z().m6314e("IncentivizedAdController", "User declined to view");
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                C1710r m6588z = C1548a.this.f1560a.m6588z();
                m6588z.m6314e("IncentivizedAdController", "User over quota: " + map);
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                C1710r m6588z = C1548a.this.f1560a.m6588z();
                m6588z.m6314e("IncentivizedAdController", "Reward rejected: " + map);
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                C1710r m6588z = C1548a.this.f1560a.m6588z();
                m6588z.m6319b("IncentivizedAdController", "Reward validated: " + map);
            }

            @Override // com.applovin.sdk.AppLovinAdRewardListener
            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                C1710r m6588z = C1548a.this.f1560a.m6588z();
                m6588z.m6314e("IncentivizedAdController", "Reward validation failed: " + i);
            }
        };
    }

    /* renamed from: a */
    public void m7048a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = m7037f();
        }
        m7049a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void m7046a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1560a.m6588z().m6319b("IncentivizedAdController", "User requested preload of incentivized ad...");
        this.f1564e = new SoftReference<>(appLovinAdLoadListener);
        if (!m7057a()) {
            m7041b(new C1550a(appLovinAdLoadListener));
            return;
        }
        C1710r.m6310i("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.f1562c);
        }
    }

    /* renamed from: a */
    public boolean m7057a() {
        return this.f1562c != null;
    }

    /* renamed from: b */
    public String m7044b() {
        return this.f1563d;
    }

    /* renamed from: c */
    public void m7040c() {
    }
}
