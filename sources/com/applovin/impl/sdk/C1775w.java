package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.animation.Animation;
import com.applovin.impl.mediation.p013a.C1335b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.w */
/* loaded from: classes.dex */
public class C1775w {

    /* renamed from: a */
    private final C1662k f2612a;

    /* renamed from: b */
    private final C1710r f2613b;

    /* renamed from: c */
    private final MaxAdView f2614c;

    public C1775w(MaxAdView maxAdView, C1662k c1662k) {
        this.f2612a = c1662k;
        this.f2613b = c1662k.m6588z();
        this.f2614c = maxAdView;
    }

    /* renamed from: a */
    public long m6125a(C1335b c1335b) {
        long j;
        this.f2613b.m6319b("ViewabilityTracker", "Checking visibility...");
        if (this.f2614c.isShown()) {
            j = 0;
        } else {
            this.f2613b.m6314e("ViewabilityTracker", "View is hidden");
            j = 2;
        }
        if (this.f2614c.getAlpha() < c1335b.m7789w()) {
            this.f2613b.m6314e("ViewabilityTracker", "View is transparent");
            j |= 4;
        }
        Animation animation = this.f2614c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            this.f2613b.m6314e("ViewabilityTracker", "View is animating");
            j |= 8;
        }
        if (this.f2614c.getParent() == null) {
            this.f2613b.m6314e("ViewabilityTracker", "No parent view found");
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f2614c.getContext(), this.f2614c.getWidth());
        if (pxToDp < c1335b.m7791u()) {
            C1710r c1710r = this.f2613b;
            c1710r.m6314e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f2614c.getContext(), this.f2614c.getHeight());
        if (pxToDp2 < c1335b.m7790v()) {
            C1710r c1710r2 = this.f2613b;
            c1710r2.m6314e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            j |= 64;
        }
        Point m6279a = C1724f.m6279a(this.f2614c.getContext());
        Rect rect = new Rect(0, 0, m6279a.x, m6279a.y);
        int[] iArr = {-1, -1};
        this.f2614c.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.f2614c.getWidth(), iArr[1] + this.f2614c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            C1710r c1710r3 = this.f2613b;
            c1710r3.m6314e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            j |= 128;
        }
        Activity m7240a = this.f2612a.m6636ad().m7240a();
        if (m7240a != null && !Utils.isViewInTopActivity(this.f2614c, m7240a)) {
            this.f2613b.m6314e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            j |= 256;
        }
        C1710r c1710r4 = this.f2613b;
        c1710r4.m6319b("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        return j;
    }
}
