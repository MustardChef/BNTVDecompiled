package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1702i;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.utils.C1719b;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1757j;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.applovin.impl.adview.b */
/* loaded from: classes.dex */
public class C1223b implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    private volatile AppLovinAdViewEventListener f508A;

    /* renamed from: B */
    private volatile AppLovinAdClickListener f509B;

    /* renamed from: a */
    private Context f511a;

    /* renamed from: b */
    private ViewGroup f512b;

    /* renamed from: c */
    private C1662k f513c;

    /* renamed from: d */
    private AppLovinAdServiceImpl f514d;

    /* renamed from: e */
    private C1710r f515e;

    /* renamed from: f */
    private AppLovinCommunicator f516f;

    /* renamed from: g */
    private AppLovinAdSize f517g;

    /* renamed from: h */
    private String f518h;

    /* renamed from: i */
    private C1584d f519i;

    /* renamed from: j */
    private C1244e f520j;

    /* renamed from: k */
    private C1236c f521k;

    /* renamed from: l */
    private C1238d f522l;

    /* renamed from: m */
    private Runnable f523m;

    /* renamed from: n */
    private Runnable f524n;

    /* renamed from: o */
    private C1702i.C1704a f525o;

    /* renamed from: y */
    private volatile AppLovinAdLoadListener f535y;

    /* renamed from: z */
    private volatile AppLovinAdDisplayListener f536z;

    /* renamed from: p */
    private volatile AbstractC1537g f526p = null;

    /* renamed from: q */
    private volatile AppLovinAd f527q = null;

    /* renamed from: r */
    private DialogC1259m f528r = null;

    /* renamed from: s */
    private DialogC1259m f529s = null;

    /* renamed from: t */
    private final AtomicReference<AppLovinAd> f530t = new AtomicReference<>();

    /* renamed from: u */
    private final AtomicBoolean f531u = new AtomicBoolean();

    /* renamed from: v */
    private volatile boolean f532v = false;

    /* renamed from: w */
    private volatile boolean f533w = false;

    /* renamed from: x */
    private volatile boolean f534x = false;

    /* renamed from: C */
    private volatile InterfaceC1248g f510C = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.adview.b$a */
    /* loaded from: classes.dex */
    public class RunnableC1234a implements Runnable {
        private RunnableC1234a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1223b.this.f522l != null) {
                C1223b.this.f522l.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.adview.b$b */
    /* loaded from: classes.dex */
    public class RunnableC1235b implements Runnable {
        private RunnableC1235b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1223b.this.f526p != null) {
                if (C1223b.this.f522l == null) {
                    C1710r.m6310i("AppLovinAdView", "Unable to render advertisement for ad #" + C1223b.this.f526p.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                    C1728i.m6241a(C1223b.this.f508A, C1223b.this.f526p, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
                    return;
                }
                C1223b.this.m8093x();
                C1710r c1710r = C1223b.this.f515e;
                c1710r.m6319b("AppLovinAdView", "Rendering advertisement ad for #" + C1223b.this.f526p.getAdIdNumber() + "...");
                C1223b.m8134b(C1223b.this.f522l, C1223b.this.f526p.getSize());
                C1223b.this.f522l.m8088a(C1223b.this.f526p);
                if (C1223b.this.f526p.getSize() != AppLovinAdSize.INTERSTITIAL && !C1223b.this.f533w) {
                    C1223b c1223b = C1223b.this;
                    c1223b.f519i = new C1584d(c1223b.f526p, C1223b.this.f513c);
                    C1223b.this.f519i.m6927a();
                    C1223b.this.f522l.setStatsManagerHelper(C1223b.this.f519i);
                    C1223b.this.f526p.setHasShown(true);
                }
                if (C1223b.this.f522l.getStatsManagerHelper() != null) {
                    C1223b.this.f522l.getStatsManagerHelper().m6926a(C1223b.this.f526p.m7069z() ? 0L : 1L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.applovin.impl.adview.b$c */
    /* loaded from: classes.dex */
    public static class C1236c implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final C1223b f553a;

        C1236c(C1223b c1223b, C1662k c1662k) {
            if (c1223b == null) {
                throw new IllegalArgumentException("No view specified");
            }
            if (c1662k == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f553a = c1223b;
        }

        /* renamed from: a */
        private C1223b m8092a() {
            return this.f553a;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            C1223b m8092a = m8092a();
            if (m8092a != null) {
                m8092a.m8131b(appLovinAd);
            } else {
                C1710r.m6310i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            C1223b m8092a = m8092a();
            if (m8092a != null) {
                m8092a.m8155a(i);
            }
        }
    }

    /* renamed from: a */
    private void m8150a(AppLovinAdView appLovinAdView, C1662k c1662k, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        }
        this.f513c = c1662k;
        this.f514d = c1662k.m6594t();
        this.f515e = c1662k.m6588z();
        this.f516f = AppLovinCommunicator.getInstance(context);
        this.f517g = appLovinAdSize;
        this.f518h = str;
        this.f511a = context;
        this.f512b = appLovinAdView;
        this.f520j = new C1244e(this, c1662k);
        this.f524n = new RunnableC1234a();
        this.f523m = new RunnableC1235b();
        this.f521k = new C1236c(this, c1662k);
        this.f525o = new C1702i.C1704a();
        m8137a(appLovinAdSize);
    }

    /* renamed from: a */
    private void m8136a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m8134b(View view, AppLovinAdSize appLovinAdSize) {
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        int applyDimension = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getWidth(), displayMetrics);
        int applyDimension2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getHeight(), displayMetrics);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = applyDimension;
        layoutParams.height = applyDimension2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: t */
    private void m8097t() {
        C1710r c1710r = this.f515e;
        if (c1710r != null) {
            c1710r.m6319b("AppLovinAdView", "Destroying...");
        }
        C1238d c1238d = this.f522l;
        if (c1238d != null) {
            ViewParent parent = c1238d.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f522l);
            }
            this.f522l.removeAllViews();
            this.f522l.loadUrl("about:blank");
            this.f522l.onPause();
            this.f522l.destroyDrawingCache();
            this.f522l.destroy();
            this.f522l = null;
            this.f513c.m6630aj().m6520b(this.f526p);
        }
        this.f533w = true;
    }

    /* renamed from: u */
    private void m8096u() {
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (C1223b.this.f528r != null) {
                    C1710r c1710r = C1223b.this.f515e;
                    c1710r.m6319b("AppLovinAdView", "Detaching expanded ad: " + C1223b.this.f528r.m8040a());
                    C1223b c1223b = C1223b.this;
                    c1223b.f529s = c1223b.f528r;
                    C1223b.this.f528r = null;
                    C1223b c1223b2 = C1223b.this;
                    c1223b2.m8137a(c1223b2.f517g);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m8095v() {
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.8
            @Override // java.lang.Runnable
            public void run() {
                C1527a m8040a;
                if (C1223b.this.f529s == null && C1223b.this.f528r == null) {
                    return;
                }
                if (C1223b.this.f529s != null) {
                    m8040a = C1223b.this.f529s.m8040a();
                    C1223b.this.f529s.dismiss();
                    C1223b.this.f529s = null;
                } else {
                    m8040a = C1223b.this.f528r.m8040a();
                    C1223b.this.f528r.dismiss();
                    C1223b.this.f528r = null;
                }
                C1728i.m6220b(C1223b.this.f508A, m8040a, (AppLovinAdView) C1223b.this.f512b);
            }
        });
    }

    /* renamed from: w */
    private void m8094w() {
        C1584d c1584d = this.f519i;
        if (c1584d != null) {
            c1584d.m6919c();
            this.f519i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m8093x() {
        AbstractC1537g abstractC1537g = this.f526p;
        C1757j c1757j = new C1757j();
        c1757j.m6200a().m6197a(abstractC1537g).m6199a(m8100r());
        if (!Utils.isBML(abstractC1537g.getSize())) {
            c1757j.m6200a().m6195a("Fullscreen Ad Properties").m6192b(abstractC1537g);
        }
        c1757j.m6196a(this.f513c);
        c1757j.m6200a();
        C1710r.m6313f("AppLovinAdView", c1757j.toString());
    }

    /* renamed from: a */
    public void m8156a() {
        if (this.f513c == null || this.f521k == null || this.f511a == null || !this.f532v) {
            C1710r.m6312g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
            return;
        }
        C1238d c1238d = this.f522l;
        if (c1238d != null) {
            this.f525o.m6361a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(this.f511a, c1238d.getWidth()))).m6361a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(this.f511a, this.f522l.getHeight())));
        }
        this.f514d.loadNextAd(this.f518h, this.f517g, this.f525o.m6364a(), this.f521k);
    }

    /* renamed from: a */
    void m8155a(final int i) {
        if (!this.f533w) {
            m8136a(this.f524n);
        }
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (C1223b.this.f535y != null) {
                        C1223b.this.f535y.failedToReceiveAd(i);
                    }
                } catch (Throwable th) {
                    C1710r.m6316c("AppLovinAdView", "Exception while running app load  callback", th);
                }
            }
        });
    }

    /* renamed from: a */
    public void m8154a(final PointF pointF) {
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (C1223b.this.f528r == null && (C1223b.this.f526p instanceof C1527a) && C1223b.this.f522l != null) {
                    C1527a c1527a = (C1527a) C1223b.this.f526p;
                    Activity retrieveParentActivity = C1223b.this.f511a instanceof Activity ? (Activity) C1223b.this.f511a : Utils.retrieveParentActivity(C1223b.this.f522l, C1223b.this.f513c);
                    if (retrieveParentActivity != null) {
                        if (C1223b.this.f512b != null) {
                            C1223b.this.f512b.removeView(C1223b.this.f522l);
                        }
                        C1223b.this.f528r = new DialogC1259m(c1527a, C1223b.this.f522l, retrieveParentActivity, C1223b.this.f513c);
                        C1223b.this.f528r.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.b.4.1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                C1223b.this.m8114k();
                            }
                        });
                        C1223b.this.f528r.show();
                        C1728i.m6242a(C1223b.this.f508A, C1223b.this.f526p, (AppLovinAdView) C1223b.this.f512b);
                        if (C1223b.this.f519i != null) {
                            C1223b.this.f519i.m6917d();
                            return;
                        }
                        return;
                    }
                    C1710r.m6310i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    Uri mo7081j = c1527a.mo7081j();
                    if (mo7081j != null) {
                        AppLovinAdServiceImpl appLovinAdServiceImpl = C1223b.this.f514d;
                        AppLovinAdView m8100r = C1223b.this.m8100r();
                        C1223b c1223b = C1223b.this;
                        appLovinAdServiceImpl.trackAndLaunchClick(c1527a, m8100r, c1223b, mo7081j, pointF, c1223b.f534x);
                        if (C1223b.this.f519i != null) {
                            C1223b.this.f519i.m6921b();
                        }
                    }
                    C1223b.this.f522l.m8086a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    /* renamed from: a */
    public void m8152a(final WebView webView) {
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.3
            @Override // java.lang.Runnable
            public void run() {
                webView.setVisibility(0);
            }
        });
        try {
            if (this.f526p == this.f527q || this.f536z == null) {
                return;
            }
            this.f527q = this.f526p;
            C1728i.m6228a(this.f536z, this.f526p);
            this.f513c.m6630aj().m6523a(this.f526p);
            this.f522l.m8086a("javascript:al_onAdViewRendered();");
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinAdView", "Exception while notifying ad display listener", th);
        }
    }

    /* renamed from: a */
    public void m8151a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null) {
            C1710r.m6310i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
            return;
        }
        if (appLovinAdSize == null && (appLovinAdSize = C1719b.m6293a(attributeSet)) == null) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        }
        AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        if (appLovinSdk == null || appLovinSdk.hasCriticalErrors()) {
            return;
        }
        m8150a(appLovinAdView, appLovinSdk.coreSdk, appLovinAdSize2, str, context);
        if (C1719b.m6290b(attributeSet)) {
            m8156a();
        }
    }

    /* renamed from: a */
    public void m8149a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f508A = appLovinAdViewEventListener;
    }

    /* renamed from: a */
    public void m8145a(InterfaceC1248g interfaceC1248g) {
        this.f510C = interfaceC1248g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m8144a(AbstractC1537g abstractC1537g, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        C1728i.m6229a(this.f509B, abstractC1537g);
        if (appLovinAdView != null) {
            this.f514d.trackAndLaunchClick(abstractC1537g, appLovinAdView, this, uri, pointF, this.f534x);
        } else {
            this.f515e.m6314e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
    }

    /* renamed from: a */
    public void m8143a(C1584d c1584d) {
        C1238d c1238d = this.f522l;
        if (c1238d != null) {
            c1238d.setStatsManagerHelper(c1584d);
        }
    }

    /* renamed from: a */
    public void m8142a(AppLovinAd appLovinAd) {
        m8141a(appLovinAd, (String) null);
    }

    /* renamed from: a */
    public void m8141a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        Utils.validateAdSdkKey(appLovinAd, this.f513c);
        if (!this.f532v) {
            C1710r.m6312g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        AbstractC1537g abstractC1537g = (AbstractC1537g) Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f513c);
        if (abstractC1537g == null || abstractC1537g == this.f526p) {
            if (abstractC1537g == null) {
                this.f515e.m6315d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                return;
            }
            C1710r c1710r = this.f515e;
            c1710r.m6315d("AppLovinAdView", "Ad #" + abstractC1537g.getAdIdNumber() + " is already showing, ignoring");
            if (((Boolean) this.f513c.m6656a(C1568b.f1726bS)).booleanValue()) {
                throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
            }
            return;
        }
        C1710r c1710r2 = this.f515e;
        c1710r2.m6319b("AppLovinAdView", "Rendering ad #" + abstractC1537g.getAdIdNumber() + " (" + abstractC1537g.getSize() + ")");
        C1728i.m6216b(this.f536z, this.f526p);
        this.f513c.m6630aj().m6520b(this.f526p);
        if (abstractC1537g.getSize() != AppLovinAdSize.INTERSTITIAL) {
            m8094w();
        }
        this.f530t.set(null);
        this.f527q = null;
        this.f526p = abstractC1537g;
        if (!this.f533w && Utils.isBML(this.f517g)) {
            this.f513c.m6594t().trackImpression(abstractC1537g);
        }
        if (this.f528r != null) {
            m8096u();
        }
        m8136a(this.f523m);
    }

    /* renamed from: a */
    public void m8140a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f509B = appLovinAdClickListener;
    }

    /* renamed from: a */
    public void m8139a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f536z = appLovinAdDisplayListener;
    }

    /* renamed from: a */
    public void m8138a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f535y = appLovinAdLoadListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m8137a(AppLovinAdSize appLovinAdSize) {
        try {
            C1238d c1238d = new C1238d(this.f520j, this.f513c, this.f511a);
            this.f522l = c1238d;
            c1238d.setBackgroundColor(0);
            this.f522l.setWillNotCacheDrawing(false);
            this.f512b.setBackgroundColor(0);
            this.f512b.addView(this.f522l);
            m8134b(this.f522l, appLovinAdSize);
            if (!this.f532v) {
                m8136a(this.f524n);
            }
            m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.1
                @Override // java.lang.Runnable
                public void run() {
                    C1223b.this.f522l.loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
                }
            });
            this.f532v = true;
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.f531u.set(true);
        }
    }

    /* renamed from: b */
    public AppLovinAdSize m8135b() {
        return this.f517g;
    }

    /* renamed from: b */
    void m8131b(final AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            this.f515e.m6314e("AppLovinAdView", "No provided when to the view controller");
            m8155a(-1);
            return;
        }
        if (this.f533w) {
            this.f530t.set(appLovinAd);
            this.f515e.m6319b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
        } else {
            m8142a(appLovinAd);
        }
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (C1223b.this.f531u.compareAndSet(true, false)) {
                    C1223b c1223b = C1223b.this;
                    c1223b.m8137a(c1223b.f517g);
                }
                try {
                    if (C1223b.this.f535y != null) {
                        C1223b.this.f535y.adReceived(appLovinAd);
                    }
                } catch (Throwable th) {
                    C1710r.m6310i("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
                }
            }
        });
    }

    /* renamed from: c */
    public String m8130c() {
        return this.f518h;
    }

    /* renamed from: d */
    public void m8128d() {
        if (!this.f532v || this.f533w) {
            return;
        }
        this.f533w = true;
    }

    /* renamed from: e */
    public void m8126e() {
        if (this.f532v) {
            AppLovinAd andSet = this.f530t.getAndSet(null);
            if (andSet != null) {
                m8142a(andSet);
            }
            this.f533w = false;
        }
    }

    /* renamed from: f */
    public void m8124f() {
        if (this.f522l != null && this.f528r != null) {
            m8114k();
        }
        m8097t();
    }

    /* renamed from: g */
    public AppLovinAdViewEventListener m8122g() {
        return this.f508A;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return C1223b.class.getSimpleName();
    }

    /* renamed from: h */
    public InterfaceC1248g m8120h() {
        return this.f510C;
    }

    /* renamed from: i */
    public void m8118i() {
        if (C1719b.m6292a(this.f522l)) {
            this.f513c.m6669R().m6893a(C1586f.f2044m);
        }
    }

    /* renamed from: j */
    public void m8116j() {
        if (this.f532v) {
            C1728i.m6216b(this.f536z, this.f526p);
            this.f513c.m6630aj().m6520b(this.f526p);
            if (this.f522l == null || this.f528r == null) {
                this.f515e.m6319b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                return;
            }
            this.f515e.m6319b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
            m8096u();
        }
    }

    /* renamed from: k */
    public void m8114k() {
        m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.5
            @Override // java.lang.Runnable
            public void run() {
                C1223b.this.m8095v();
                if (C1223b.this.f512b == null || C1223b.this.f522l == null || C1223b.this.f522l.getParent() != null) {
                    return;
                }
                C1223b.this.f512b.addView(C1223b.this.f522l);
                C1223b.m8134b(C1223b.this.f522l, C1223b.this.f526p.getSize());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m8112l() {
        if (this.f528r != null || this.f529s != null) {
            m8114k();
            return;
        }
        C1710r c1710r = this.f515e;
        c1710r.m6319b("AppLovinAdView", "Ad: " + this.f526p + " closed.");
        m8136a(this.f524n);
        C1728i.m6216b(this.f536z, this.f526p);
        this.f513c.m6630aj().m6520b(this.f526p);
        this.f526p = null;
    }

    /* renamed from: m */
    public void m8110m() {
        this.f534x = true;
    }

    /* renamed from: n */
    public void m8108n() {
        this.f534x = false;
    }

    /* renamed from: o */
    public void m8106o() {
        if (!(this.f511a instanceof InterfaceC1258l) || this.f526p == null) {
            return;
        }
        if (this.f526p.m7164I() == AbstractC1537g.EnumC1539a.DISMISS) {
            ((InterfaceC1258l) this.f511a).dismiss();
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            m8136a(new Runnable() { // from class: com.applovin.impl.adview.b.9
                @Override // java.lang.Runnable
                public void run() {
                    C1223b.this.m8098s().loadUrl("chrome://crash");
                }
            });
        }
    }

    /* renamed from: p */
    public AbstractC1537g m8104p() {
        return this.f526p;
    }

    /* renamed from: q */
    public C1662k m8102q() {
        return this.f513c;
    }

    /* renamed from: r */
    public AppLovinAdView m8100r() {
        return (AppLovinAdView) this.f512b;
    }

    /* renamed from: s */
    public C1238d m8098s() {
        return this.f522l;
    }
}
