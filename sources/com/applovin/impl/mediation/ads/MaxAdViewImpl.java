package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1335b;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1573d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.C1775w;
import com.applovin.impl.sdk.C1776x;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1719b;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1763o;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class MaxAdViewImpl extends AbstractC1363a implements C1573d.InterfaceC1575a, C1776x.InterfaceC1779a {

    /* renamed from: a */
    private final Activity f843a;

    /* renamed from: b */
    private final MaxAdView f844b;

    /* renamed from: c */
    private final View f845c;

    /* renamed from: d */
    private long f846d;

    /* renamed from: e */
    private C1335b f847e;

    /* renamed from: f */
    private String f848f;

    /* renamed from: g */
    private final C1347a f849g;

    /* renamed from: h */
    private final C1349c f850h;

    /* renamed from: i */
    private final C1573d f851i;

    /* renamed from: j */
    private final C1775w f852j;

    /* renamed from: k */
    private final C1776x f853k;

    /* renamed from: l */
    private final Object f854l;

    /* renamed from: m */
    private C1335b f855m;

    /* renamed from: n */
    private boolean f856n;

    /* renamed from: o */
    private boolean f857o;

    /* renamed from: p */
    private boolean f858p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$2 */
    /* loaded from: classes.dex */
    public class RunnableC13432 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1335b f861a;

        RunnableC13432(C1335b c1335b) {
            this.f861a = c1335b;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaxErrorImpl maxErrorImpl;
            final View m7793s = this.f861a.m7793s();
            if (m7793s != null) {
                final MaxAdView maxAdView = MaxAdViewImpl.this.f844b;
                if (maxAdView != null) {
                    MaxAdViewImpl.this.m7721a(new AnimatorListenerAdapter() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl.2.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            MaxAdView maxAdView2;
                            int i;
                            super.onAnimationEnd(animator);
                            MaxAdViewImpl.this.m7723a();
                            MaxAdViewImpl.this.m7673a((AbstractC1334a) RunnableC13432.this.f861a);
                            MaxAdViewImpl.this.sdk.m6630aj().m6523a(RunnableC13432.this.f861a);
                            if (RunnableC13432.this.f861a.m7787y()) {
                                MaxAdViewImpl.this.f853k.m6121a(RunnableC13432.this.f861a);
                            }
                            if (RunnableC13432.this.f861a.m7800A()) {
                                maxAdView2 = maxAdView;
                                i = 393216;
                            } else {
                                maxAdView2 = maxAdView;
                                i = 131072;
                            }
                            maxAdView2.setDescendantFocusability(i);
                            MaxAdViewImpl.this.m7717a(RunnableC13432.this.f861a, m7793s, maxAdView);
                            synchronized (MaxAdViewImpl.this.f854l) {
                                MaxAdViewImpl.this.f855m = RunnableC13432.this.f861a;
                            }
                            MaxAdViewImpl.this.logger.m6319b(MaxAdViewImpl.this.tag, "Scheduling impression for ad manually...");
                            MaxAdViewImpl.this.sdk.m6684C().processRawAdImpressionPostback(RunnableC13432.this.f861a, MaxAdViewImpl.this.f849g);
                            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    long m6125a = MaxAdViewImpl.this.f852j.m6125a(RunnableC13432.this.f861a);
                                    if (!RunnableC13432.this.f861a.m7787y()) {
                                        MaxAdViewImpl.this.m7718a(RunnableC13432.this.f861a, m6125a);
                                    }
                                    MaxAdViewImpl.this.m7722a(m6125a);
                                }
                            }, RunnableC13432.this.f861a.m7792t());
                        }
                    });
                    return;
                } else {
                    MaxAdViewImpl.this.logger.m6314e(MaxAdViewImpl.this.tag, "MaxAdView does not have a parent view");
                    maxErrorImpl = new MaxErrorImpl(-1, "MaxAdView does not have a parent view");
                }
            } else {
                MaxAdViewImpl.this.logger.m6314e(MaxAdViewImpl.this.tag, "MaxAdView does not have a loaded ad view");
                maxErrorImpl = new MaxErrorImpl(-1, "MaxAdView does not have a loaded ad view");
            }
            C1728i.m6239a(MaxAdViewImpl.this.f849g, this.f861a, maxErrorImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$a */
    /* loaded from: classes.dex */
    public class C1347a extends AbstractC1348b {
        private C1347a() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            C1728i.m6233a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.m7705a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f858p) {
                C1710r c1710r = MaxAdViewImpl.this.logger;
                String str = MaxAdViewImpl.this.tag;
                c1710r.m6319b(str, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                MaxAdViewImpl.this.sdk.m6684C().destroyAd(maxAd);
                return;
            }
            C1335b c1335b = (C1335b) maxAd;
            c1335b.m7737c(MaxAdViewImpl.this.f848f);
            MaxAdViewImpl.this.m7719a(c1335b);
            if (c1335b.m7799B()) {
                long m7798C = c1335b.m7798C();
                C1710r m6588z = MaxAdViewImpl.this.sdk.m6588z();
                String str2 = MaxAdViewImpl.this.tag;
                m6588z.m6319b(str2, "Scheduling banner ad refresh " + m7798C + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                MaxAdViewImpl.this.f851i.m6974a(m7798C);
            }
            C1728i.m6235a(MaxAdViewImpl.this.adListener, maxAd, true);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$b */
    /* loaded from: classes.dex */
    private abstract class AbstractC1348b implements AbstractC1363a.InterfaceC1364a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {
        private AbstractC1348b() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                C1728i.m6209d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                if (MaxAdViewImpl.this.f855m.m7797D()) {
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                C1728i.m6201h(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                C1728i.m6238a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                C1728i.m6218b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                if (MaxAdViewImpl.this.f855m.m7797D()) {
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                C1728i.m6203g(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f855m)) {
                C1728i.m6212c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            C1728i.m6231a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$c */
    /* loaded from: classes.dex */
    private class C1349c extends AbstractC1348b {
        private C1349c() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            C1710r c1710r = MaxAdViewImpl.this.logger;
            String str2 = MaxAdViewImpl.this.tag;
            c1710r.m6319b(str2, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            MaxAdViewImpl.this.m7705a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (!MaxAdViewImpl.this.f858p) {
                MaxAdViewImpl.this.logger.m6319b(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
                MaxAdViewImpl.this.m7706a(maxAd);
                return;
            }
            C1710r c1710r = MaxAdViewImpl.this.logger;
            String str = MaxAdViewImpl.this.tag;
            c1710r.m6319b(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
            MaxAdViewImpl.this.sdk.m6684C().destroyAd(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, C1662k c1662k, Activity activity) {
        super(str, maxAdFormat, "MaxAdView", c1662k);
        this.f846d = Long.MAX_VALUE;
        this.f854l = new Object();
        this.f855m = null;
        this.f858p = false;
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f843a = activity;
        this.f844b = maxAdView;
        this.f845c = view;
        this.f849g = new C1347a();
        this.f850h = new C1349c();
        this.f851i = new C1573d(c1662k, this);
        this.f852j = new C1775w(maxAdView, c1662k);
        this.f853k = new C1776x(maxAdView, c1662k, this);
        C1710r c1710r = this.logger;
        String str2 = this.tag;
        c1710r.m6319b(str2, "Created new MaxAdView (" + this + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7723a() {
        C1335b c1335b;
        MaxAdView maxAdView = this.f844b;
        if (maxAdView != null) {
            C1719b.m6291a(maxAdView, this.f845c);
        }
        this.f853k.m6124a();
        synchronized (this.f854l) {
            c1335b = this.f855m;
        }
        if (c1335b != null) {
            this.sdk.m6630aj().m6520b(c1335b);
            this.sdk.m6684C().destroyAd(c1335b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7722a(long j) {
        if (!Utils.bitMaskContainsFlag(j, ((Long) this.sdk.m6656a(C1567a.f1648z)).longValue())) {
            this.logger.m6319b(this.tag, "No undesired viewability flags matched - scheduling viewability");
            this.f856n = false;
            m7704b();
            return;
        }
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
        this.logger.m6319b(this.tag, "Waiting for refresh timer to manually fire request");
        this.f856n = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7721a(AnimatorListenerAdapter animatorListenerAdapter) {
        C1335b c1335b = this.f855m;
        if (c1335b == null || c1335b.m7793s() == null) {
            animatorListenerAdapter.onAnimationEnd(null);
            return;
        }
        View m7793s = this.f855m.m7793s();
        m7793s.animate().alpha(0.0f).setDuration(((Long) this.sdk.m6656a(C1567a.f1644v)).longValue()).setListener(animatorListenerAdapter).start();
    }

    /* renamed from: a */
    private void m7720a(View view, C1335b c1335b) {
        int m7795q = c1335b.m7795q();
        int m7794r = c1335b.m7794r();
        int dpToPx = m7795q == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), m7795q);
        int dpToPx2 = m7794r != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), m7794r) : -1;
        int height = this.f844b.getHeight();
        int width = this.f844b.getWidth();
        if ((height > 0 && height < dpToPx2) || (width > 0 && width < dpToPx)) {
            int pxToDp = AppLovinSdkUtils.pxToDp(view.getContext(), height);
            C1710r.m6311h("AppLovinSdk", "\n**************************************************\n`MaxAdView` size " + AppLovinSdkUtils.pxToDp(view.getContext(), width) + "x" + pxToDp + " dp smaller than required size: " + m7795q + "x" + m7794r + " dp\n**************************************************\n");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx2);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = dpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            this.logger.m6319b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + dpToPx2 + ".");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i : C1763o.m6158a(this.f844b.getGravity(), 10, 14)) {
                layoutParams2.addRule(i);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7719a(C1335b c1335b) {
        AppLovinSdkUtils.runOnUiThread(new RunnableC13432(c1335b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7718a(C1335b c1335b, long j) {
        this.logger.m6319b(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.m6684C().processViewabilityAdImpressionPostback(c1335b, j, this.f849g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7717a(C1335b c1335b, View view, MaxAdView maxAdView) {
        view.setAlpha(0.0f);
        if (c1335b.m7796E() != Long.MAX_VALUE) {
            this.f845c.setBackgroundColor((int) c1335b.m7796E());
        } else {
            long j = this.f846d;
            if (j != Long.MAX_VALUE) {
                this.f845c.setBackgroundColor((int) j);
            } else {
                this.f845c.setBackgroundColor(0);
            }
        }
        maxAdView.addView(view);
        m7720a(view, c1335b);
        view.animate().alpha(1.0f).setDuration(((Long) this.sdk.m6656a(C1567a.f1643u)).longValue()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7707a(final AbstractC1363a.InterfaceC1364a interfaceC1364a) {
        if (!m7699d()) {
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MaxAdViewImpl.this.f855m != null) {
                        MaxAdViewImpl.this.loadRequestBuilder.m6361a("visible_ad_ad_unit_id", MaxAdViewImpl.this.f855m.getAdUnitId()).m6361a("viewability_flags", String.valueOf(MaxAdViewImpl.this.f852j.m6125a(MaxAdViewImpl.this.f855m)));
                    } else {
                        MaxAdViewImpl.this.loadRequestBuilder.m6362a("visible_ad_ad_unit_id").m6362a("viewability_flags");
                    }
                    MaxAdViewImpl.this.loadRequestBuilder.m6361a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f844b.getContext(), MaxAdViewImpl.this.f844b.getWidth()))).m6361a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f844b.getContext(), MaxAdViewImpl.this.f844b.getHeight())));
                    C1710r c1710r = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    c1710r.m6319b(str, "Loading banner ad for '" + MaxAdViewImpl.this.adUnitId + "' and notifying " + interfaceC1364a + "...");
                    MaxAdViewImpl.this.sdk.m6684C().loadAd(MaxAdViewImpl.this.adUnitId, MaxAdViewImpl.this.adFormat, MaxAdViewImpl.this.loadRequestBuilder.m6364a(), MaxAdViewImpl.this.f843a, interfaceC1364a);
                }
            });
            return;
        }
        C1710r.m6310i(this.tag, "Failed to load new ad - this instance is already destroyed");
        C1728i.m6234a(this.adListener, this.adUnitId, new MaxErrorImpl(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7706a(MaxAd maxAd) {
        this.sdk.m6630aj().m6523a(maxAd);
        if (!this.f857o) {
            this.f847e = (C1335b) maxAd;
            return;
        }
        this.f857o = false;
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
        this.f849g.onAdLoaded(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7705a(MaxError maxError) {
        if (this.sdk.m6625b(C1567a.f1637o).contains(String.valueOf(maxError.getCode()))) {
            C1710r m6588z = this.sdk.m6588z();
            String str = this.tag;
            m6588z.m6319b(str, "Ignoring banner ad refresh for error code " + maxError.getCode());
            return;
        }
        this.f856n = true;
        long longValue = ((Long) this.sdk.m6656a(C1567a.f1636n)).longValue();
        if (longValue >= 0) {
            C1710r m6588z2 = this.sdk.m6588z();
            String str2 = this.tag;
            m6588z2.m6319b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
            this.f851i.m6974a(longValue);
        }
    }

    /* renamed from: b */
    private void m7704b() {
        if (m7701c()) {
            long longValue = ((Long) this.sdk.m6656a(C1567a.f1602A)).longValue();
            C1710r c1710r = this.logger;
            String str = this.tag;
            c1710r.m6319b(str, "Scheduling refresh precache request in " + TimeUnit.MICROSECONDS.toSeconds(longValue) + " seconds...");
            this.sdk.m6670Q().m6792a(new C1642y(this.sdk, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.m7707a(maxAdViewImpl.f850h);
                }
            }), C1391c.m7598a(this.adFormat), longValue);
        }
    }

    /* renamed from: c */
    private boolean m7701c() {
        return ((Long) this.sdk.m6656a(C1567a.f1602A)).longValue() > 0;
    }

    /* renamed from: d */
    private boolean m7699d() {
        boolean z;
        synchronized (this.f854l) {
            z = this.f858p;
        }
        return z;
    }

    public void destroy() {
        m7723a();
        if (this.f847e != null) {
            this.sdk.m6630aj().m6520b(this.f847e);
            this.sdk.m6684C().destroyAd(this.f847e);
        }
        synchronized (this.f854l) {
            this.f858p = true;
        }
        this.f851i.m6970c();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f848f;
    }

    public void loadAd() {
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "" + this + " Loading ad for " + this.adUnitId + "...");
        if (!((Boolean) this.sdk.m6656a(C1567a.f1603B)).booleanValue() || !this.f851i.m6975a()) {
            m7707a(this.f849g);
            return;
        }
        String str2 = this.tag;
        C1710r.m6310i(str2, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f851i.m6972b()) + " seconds.");
    }

    @Override // com.applovin.impl.sdk.C1573d.InterfaceC1575a
    public void onAdRefresh() {
        C1710r c1710r;
        String str;
        String str2;
        this.f857o = false;
        if (this.f847e != null) {
            C1710r c1710r2 = this.logger;
            String str3 = this.tag;
            c1710r2.m6319b(str3, "Refreshing for cached ad: " + this.f847e.getAdUnitId() + "...");
            this.f849g.onAdLoaded(this.f847e);
            this.f847e = null;
            return;
        }
        if (!m7701c()) {
            c1710r = this.logger;
            str = this.tag;
            str2 = "Refreshing ad from network...";
        } else if (!this.f856n) {
            this.logger.m6314e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            this.f857o = true;
            return;
        } else {
            c1710r = this.logger;
            str = this.tag;
            str2 = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        }
        c1710r.m6319b(str, str2);
        loadAd();
    }

    @Override // com.applovin.impl.sdk.C1776x.InterfaceC1779a
    public void onLogVisibilityImpression() {
        m7718a(this.f855m, this.f852j.m6125a(this.f855m));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.m6656a(C1567a.f1641s)).booleanValue() && this.f851i.m6975a()) {
            if (C1763o.m6160a(i)) {
                this.logger.m6319b(this.tag, "Ad view visible");
                this.f851i.m6966g();
                return;
            }
            this.logger.m6319b(this.tag, "Ad view hidden");
            this.f851i.m6967f();
        }
    }

    public void setPlacement(String str) {
        if (this.f855m != null) {
            String str2 = this.tag;
            C1710r.m6310i(str2, "Placement for ad unit ID (" + this.adUnitId + ") was set after load was called. For the ads to be correctly attributed to this placement, please set the placement before loading the " + this.adFormat.getLabel() + ".");
        }
        this.f848f = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.f846d = i;
    }

    public void startAutoRefresh() {
        this.f851i.m6968e();
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Resumed auto-refresh with remaining time: " + this.f851i.m6972b());
    }

    public void stopAutoRefresh() {
        if (this.f855m == null) {
            C1710r.m6311h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
            return;
        }
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Pausing auto-refresh with remaining time: " + this.f851i.m6972b());
        this.f851i.m6969d();
    }

    public String toString() {
        return "MaxAdView{adUnitId='" + this.adUnitId + "', adListener=" + this.adListener + ", isDestroyed=" + m7699d() + '}';
    }
}
