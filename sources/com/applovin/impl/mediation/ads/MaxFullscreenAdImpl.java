package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import com.applovin.impl.mediation.C1365b;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.AbstractC1363a;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1545b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class MaxFullscreenAdImpl extends AbstractC1363a implements C1545b.InterfaceC1547a {

    /* renamed from: a */
    private final InterfaceC1356a f871a;

    /* renamed from: b */
    private final C1545b f872b;

    /* renamed from: c */
    private final C1365b f873c;

    /* renamed from: d */
    private C1760m f874d;

    /* renamed from: e */
    private final Object f875e;

    /* renamed from: f */
    private C1336c f876f;

    /* renamed from: g */
    private EnumC1362c f877g;

    /* renamed from: h */
    private final AtomicBoolean f878h;
    protected final C1357b listenerWrapper;

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1356a {
        Activity getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b */
    /* loaded from: classes.dex */
    public class C1357b implements AbstractC1363a.InterfaceC1364a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        private C1357b() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            C1728i.m6209d(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            MaxFullscreenAdImpl.this.m7686a(EnumC1362c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b.4
                @Override // java.lang.Runnable
                public void run() {
                    MaxFullscreenAdImpl.this.f872b.m7063a();
                    MaxFullscreenAdImpl.this.m7689a();
                    MaxFullscreenAdImpl.this.sdk.m6683D().m6306b((AbstractC1334a) maxAd);
                    MaxFullscreenAdImpl.this.m7681a("ad failed to display");
                    C1728i.m6238a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f872b.m7063a();
            C1728i.m6218b(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f873c.m7670a(maxAd);
            MaxFullscreenAdImpl.this.m7686a(EnumC1362c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b.3
                @Override // java.lang.Runnable
                public void run() {
                    MaxFullscreenAdImpl.this.m7689a();
                    MaxFullscreenAdImpl.this.sdk.m6683D().m6306b((AbstractC1334a) maxAd);
                    MaxFullscreenAdImpl.this.m7681a("ad was hidden");
                    C1728i.m6212c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.m7680b();
            MaxFullscreenAdImpl.this.m7686a(EnumC1362c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b.2
                @Override // java.lang.Runnable
                public void run() {
                    C1728i.m6233a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.m7688a((C1336c) maxAd);
            if (MaxFullscreenAdImpl.this.f878h.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.loadRequestBuilder.m6362a("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.m7686a(EnumC1362c.READY, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1728i.m6235a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                    }
                });
            }
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            C1728i.m6232a(MaxFullscreenAdImpl.this.revenueListener, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1728i.m6205f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1728i.m6207e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1728i.m6236a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c */
    /* loaded from: classes.dex */
    public enum EnumC1362c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, InterfaceC1356a interfaceC1356a, String str2, C1662k c1662k) {
        super(str, maxAdFormat, str2, c1662k);
        this.f875e = new Object();
        this.f876f = null;
        this.f877g = EnumC1362c.IDLE;
        this.f878h = new AtomicBoolean();
        this.f871a = interfaceC1356a;
        C1357b c1357b = new C1357b();
        this.listenerWrapper = c1357b;
        this.f872b = new C1545b(c1662k, this);
        this.f873c = new C1365b(c1662k, c1357b);
        C1710r.m6313f(str2, "Created new " + str2 + " (" + this + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7689a() {
        C1336c c1336c;
        synchronized (this.f875e) {
            c1336c = this.f876f;
            this.f876f = null;
        }
        this.sdk.m6684C().destroyAd(c1336c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7688a(C1336c c1336c) {
        long m7777q = c1336c.m7777q() - (SystemClock.elapsedRealtime() - c1336c.m7805m());
        if (m7777q <= TimeUnit.SECONDS.toMillis(2L)) {
            this.logger.m6319b(this.tag, "Loaded an expired ad, running expire logic...");
            onAdExpired();
            return;
        }
        this.f876f = c1336c;
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Handle ad loaded for regular ad: " + c1336c);
        C1710r c1710r2 = this.logger;
        String str2 = this.tag;
        c1710r2.m6319b(str2, "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(m7777q) + " seconds from now for " + getAdUnitId() + "...");
        this.f872b.m7062a(m7777q);
    }

    /* renamed from: a */
    private void m7687a(C1336c c1336c, Context context, final Runnable runnable) {
        if (!c1336c.m7783C() || C1725g.m6267a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(c1336c.m7782D()).setMessage(c1336c.m7781E()).setPositiveButton(c1336c.m7780F(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7686a(EnumC1362c enumC1362c, Runnable runnable) {
        boolean z;
        C1710r c1710r;
        String str;
        String str2;
        String str3;
        String str4;
        EnumC1362c enumC1362c2 = this.f877g;
        synchronized (this.f875e) {
            z = true;
            if (enumC1362c2 == EnumC1362c.IDLE) {
                if (enumC1362c != EnumC1362c.LOADING && enumC1362c != EnumC1362c.DESTROYED) {
                    if (enumC1362c == EnumC1362c.SHOWING) {
                        str3 = this.tag;
                        str4 = "No ad is loading or loaded";
                        C1710r.m6310i(str3, str4);
                        z = false;
                    } else {
                        c1710r = this.logger;
                        str = this.tag;
                        str2 = "Unable to transition to: " + enumC1362c;
                        c1710r.m6314e(str, str2);
                        z = false;
                    }
                }
            } else if (enumC1362c2 == EnumC1362c.LOADING) {
                if (enumC1362c != EnumC1362c.IDLE) {
                    if (enumC1362c == EnumC1362c.LOADING) {
                        str3 = this.tag;
                        str4 = "An ad is already loading";
                    } else if (enumC1362c != EnumC1362c.READY) {
                        if (enumC1362c == EnumC1362c.SHOWING) {
                            str3 = this.tag;
                            str4 = "An ad is not ready to be shown yet";
                        } else if (enumC1362c != EnumC1362c.DESTROYED) {
                            c1710r = this.logger;
                            str = this.tag;
                            str2 = "Unable to transition to: " + enumC1362c;
                            c1710r.m6314e(str, str2);
                            z = false;
                        }
                    }
                    C1710r.m6310i(str3, str4);
                    z = false;
                }
            } else if (enumC1362c2 != EnumC1362c.READY) {
                if (enumC1362c2 == EnumC1362c.SHOWING) {
                    if (enumC1362c != EnumC1362c.IDLE) {
                        if (enumC1362c == EnumC1362c.LOADING) {
                            str3 = this.tag;
                            str4 = "Can not load another ad while the ad is showing";
                        } else {
                            if (enumC1362c == EnumC1362c.READY) {
                                c1710r = this.logger;
                                str = this.tag;
                                str2 = "An ad is already showing, ignoring";
                            } else if (enumC1362c == EnumC1362c.SHOWING) {
                                str3 = this.tag;
                                str4 = "The ad is already showing, not showing another one";
                            } else if (enumC1362c != EnumC1362c.DESTROYED) {
                                c1710r = this.logger;
                                str = this.tag;
                                str2 = "Unable to transition to: " + enumC1362c;
                            }
                            c1710r.m6314e(str, str2);
                        }
                        C1710r.m6310i(str3, str4);
                    }
                } else if (enumC1362c2 == EnumC1362c.DESTROYED) {
                    str3 = this.tag;
                    str4 = "No operations are allowed on a destroyed instance";
                    C1710r.m6310i(str3, str4);
                } else {
                    c1710r = this.logger;
                    str = this.tag;
                    str2 = "Unknown state: " + this.f877g;
                    c1710r.m6314e(str, str2);
                }
                z = false;
            } else if (enumC1362c != EnumC1362c.IDLE) {
                if (enumC1362c == EnumC1362c.LOADING) {
                    str3 = this.tag;
                    str4 = "An ad is already loaded";
                    C1710r.m6310i(str3, str4);
                    z = false;
                } else {
                    if (enumC1362c == EnumC1362c.READY) {
                        c1710r = this.logger;
                        str = this.tag;
                        str2 = "An ad is already marked as ready";
                    } else if (enumC1362c != EnumC1362c.SHOWING && enumC1362c != EnumC1362c.DESTROYED) {
                        c1710r = this.logger;
                        str = this.tag;
                        str2 = "Unable to transition to: " + enumC1362c;
                    }
                    c1710r.m6314e(str, str2);
                    z = false;
                }
            }
            if (z) {
                this.logger.m6319b(this.tag, "Transitioning from " + this.f877g + " to " + enumC1362c + "...");
                this.f877g = enumC1362c;
            } else {
                this.logger.m6315d(this.tag, "Not allowed transition from " + this.f877g + " to " + enumC1362c);
            }
        }
        if (!z || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7681a(final String str) {
        final long intValue = ((Integer) this.sdk.m6656a(C1567a.f1647y)).intValue();
        if (intValue > 0) {
            this.f874d = C1760m.m6176a(TimeUnit.SECONDS.toMillis(intValue), this.sdk, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = MaxFullscreenAdImpl.this.tag;
                    C1710r.m6311h(str2, intValue + " second(s) elapsed without an ad load attempt after " + MaxFullscreenAdImpl.this.adFormat.getDisplayName().toLowerCase() + " " + str + ". Please ensure that you are re-loading ads correctly! (Ad Unit ID: " + MaxFullscreenAdImpl.this.adUnitId + ")");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7680b() {
        C1336c c1336c;
        if (this.f878h.compareAndSet(true, false)) {
            synchronized (this.f875e) {
                c1336c = this.f876f;
                this.f876f = null;
            }
            this.sdk.m6684C().destroyAd(c1336c);
            this.loadRequestBuilder.m6362a("expired_ad_ad_unit_id");
        }
    }

    public void destroy() {
        m7686a(EnumC1362c.DESTROYED, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f875e) {
                    if (MaxFullscreenAdImpl.this.f876f != null) {
                        C1710r c1710r = MaxFullscreenAdImpl.this.logger;
                        String str = MaxFullscreenAdImpl.this.tag;
                        c1710r.m6319b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.f876f + "...");
                        MaxFullscreenAdImpl.this.sdk.m6684C().destroyAd(MaxFullscreenAdImpl.this.f876f);
                    }
                }
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.f875e) {
            C1336c c1336c = this.f876f;
            z = c1336c != null && c1336c.m7814d() && this.f877g == EnumC1362c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Loading ad for '" + this.adUnitId + "'...");
        C1760m c1760m = this.f874d;
        if (c1760m != null) {
            c1760m.m6169d();
        }
        if (!isReady()) {
            m7686a(EnumC1362c.LOADING, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    if (activity2 == null) {
                        activity2 = MaxFullscreenAdImpl.this.sdk.m6628al();
                    }
                    MaxFullscreenAdImpl.this.sdk.m6684C().loadAd(MaxFullscreenAdImpl.this.adUnitId, MaxFullscreenAdImpl.this.adFormat, MaxFullscreenAdImpl.this.loadRequestBuilder.m6364a(), activity2, MaxFullscreenAdImpl.this.listenerWrapper);
                }
            });
            return;
        }
        C1710r c1710r2 = this.logger;
        String str2 = this.tag;
        c1710r2.m6319b(str2, "An ad is already loaded for '" + this.adUnitId + "'");
        C1728i.m6235a(this.adListener, (MaxAd) this.f876f, true);
    }

    @Override // com.applovin.impl.sdk.C1545b.InterfaceC1547a
    public void onAdExpired() {
        C1710r c1710r = this.logger;
        String str = this.tag;
        c1710r.m6319b(str, "Ad expired " + getAdUnitId());
        this.f878h.set(true);
        Activity activity = this.f871a.getActivity();
        if (activity == null && (activity = this.sdk.m6636ad().m7240a()) == null) {
            m7680b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, new MaxErrorImpl(-5601, "No Activity found"));
            return;
        }
        this.loadRequestBuilder.m6361a("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.m6684C().loadAd(this.adUnitId, this.adFormat, this.loadRequestBuilder.m6364a(), activity, this.listenerWrapper);
    }

    public void showAd(final String str, final Activity activity) {
        if (!isReady()) {
            String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            C1710r.m6310i(this.tag, str2);
            C1728i.m6238a(this.adListener, (MaxAd) this.f876f, (MaxError) new MaxErrorImpl(-24, str2), true);
            return;
        }
        if (activity == null) {
            activity = this.sdk.m6628al();
        }
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
        if (Utils.getAlwaysFinishActivitiesSetting(activity) != 0) {
            if (Utils.isPubInDebugMode(activity)) {
                throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            }
            C1710r.m6310i(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            C1728i.m6238a(this.adListener, (MaxAd) this.f876f, (MaxError) new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!"), true);
        } else if (((Boolean) this.sdk.m6656a(C1567a.f1604C)).booleanValue() && (this.sdk.m6637ac().m6336a() || this.sdk.m6637ac().m6332b())) {
            C1710r.m6310i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
            C1728i.m6238a(this.adListener, (MaxAd) this.f876f, (MaxError) new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing"), true);
        } else if (!((Boolean) this.sdk.m6656a(C1567a.f1605D)).booleanValue() || C1725g.m6267a(activity)) {
            m7687a(this.f876f, activity, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    MaxFullscreenAdImpl.this.m7686a(EnumC1362c.SHOWING, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaxFullscreenAdImpl.this.f873c.m7669b(MaxFullscreenAdImpl.this.f876f);
                            C1710r c1710r = MaxFullscreenAdImpl.this.logger;
                            String str3 = MaxFullscreenAdImpl.this.tag;
                            c1710r.m6319b(str3, "Showing ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; loaded ad: " + MaxFullscreenAdImpl.this.f876f + "...");
                            MaxFullscreenAdImpl.this.m7673a((AbstractC1334a) MaxFullscreenAdImpl.this.f876f);
                            MaxFullscreenAdImpl.this.sdk.m6684C().showFullscreenAd(MaxFullscreenAdImpl.this.f876f, str, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                        }
                    });
                }
            });
        } else {
            C1710r.m6310i(this.tag, "Attempting to show ad with no internet connection");
            C1728i.m6238a(this.adListener, (MaxAd) this.f876f, (MaxError) new MaxErrorImpl(-1009), true);
        }
    }

    public String toString() {
        return this.tag + "{adUnitId='" + this.adUnitId + "', adListener=" + this.adListener + ", revenueListener=" + this.revenueListener + ", isReady=" + isReady() + '}';
    }
}
