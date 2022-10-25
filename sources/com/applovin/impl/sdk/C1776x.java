package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.p013a.C1335b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.sdk.x */
/* loaded from: classes.dex */
public class C1776x {

    /* renamed from: a */
    private final C1662k f2615a;

    /* renamed from: b */
    private final C1710r f2616b;

    /* renamed from: f */
    private final Runnable f2620f;

    /* renamed from: g */
    private final ViewTreeObserver.OnPreDrawListener f2621g;

    /* renamed from: h */
    private final WeakReference<MaxAdView> f2622h;

    /* renamed from: k */
    private int f2625k;

    /* renamed from: l */
    private long f2626l;

    /* renamed from: c */
    private final Object f2617c = new Object();

    /* renamed from: d */
    private final Rect f2618d = new Rect();

    /* renamed from: i */
    private WeakReference<ViewTreeObserver> f2623i = new WeakReference<>(null);

    /* renamed from: j */
    private WeakReference<View> f2624j = new WeakReference<>(null);

    /* renamed from: m */
    private long f2627m = Long.MIN_VALUE;

    /* renamed from: e */
    private final Handler f2619e = new Handler(Looper.getMainLooper());

    /* renamed from: com.applovin.impl.sdk.x$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1779a {
        void onLogVisibilityImpression();
    }

    public C1776x(MaxAdView maxAdView, C1662k c1662k, InterfaceC1779a interfaceC1779a) {
        this.f2615a = c1662k;
        this.f2616b = c1662k.m6588z();
        this.f2622h = new WeakReference<>(maxAdView);
        final WeakReference weakReference = new WeakReference(interfaceC1779a);
        this.f2620f = new Runnable() { // from class: com.applovin.impl.sdk.x.1
            @Override // java.lang.Runnable
            public void run() {
                MaxAdView maxAdView2 = (MaxAdView) C1776x.this.f2622h.get();
                View view = (View) C1776x.this.f2624j.get();
                if (maxAdView2 == null || view == null) {
                    return;
                }
                if (!C1776x.this.m6117b(maxAdView2, view)) {
                    C1776x.this.m6118b();
                    return;
                }
                C1776x.this.f2616b.m6319b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                C1776x.this.m6124a();
                InterfaceC1779a interfaceC1779a2 = (InterfaceC1779a) weakReference.get();
                if (interfaceC1779a2 != null) {
                    interfaceC1779a2.onLogVisibilityImpression();
                }
            }
        };
        this.f2621g = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.sdk.x.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                C1776x.this.m6118b();
                C1776x.this.m6115c();
                return true;
            }
        };
    }

    /* renamed from: a */
    private void m6123a(View view) {
        View rootView = Utils.getRootView(this.f2622h.get());
        if (rootView == null) {
            rootView = Utils.getRootView(view);
        }
        if (rootView == null) {
            this.f2616b.m6319b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f2616b.m6315d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.f2623i = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f2621g);
    }

    /* renamed from: a */
    private boolean m6122a(View view, View view2) {
        return view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0 && view2.getGlobalVisibleRect(this.f2618d) && ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f2618d.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f2618d.height()))) >= ((long) this.f2625k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6118b() {
        this.f2619e.postDelayed(this.f2620f, ((Long) this.f2615a.m6656a(C1568b.f1720bM)).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m6117b(View view, View view2) {
        if (m6122a(view, view2)) {
            if (this.f2627m == Long.MIN_VALUE) {
                this.f2627m = SystemClock.uptimeMillis();
            }
            return SystemClock.uptimeMillis() - this.f2627m >= this.f2626l;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6115c() {
        ViewTreeObserver viewTreeObserver = this.f2623i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f2621g);
        }
        this.f2623i.clear();
    }

    /* renamed from: a */
    public void m6124a() {
        synchronized (this.f2617c) {
            this.f2619e.removeMessages(0);
            m6115c();
            this.f2627m = Long.MIN_VALUE;
            this.f2624j.clear();
        }
    }

    /* renamed from: a */
    public void m6121a(C1335b c1335b) {
        synchronized (this.f2617c) {
            this.f2616b.m6319b("VisibilityTracker", "Tracking Visibility...");
            m6124a();
            this.f2624j = new WeakReference<>(c1335b.m7793s());
            this.f2625k = c1335b.m7788x();
            this.f2626l = c1335b.m7786z();
            m6123a(this.f2624j.get());
        }
    }
}
