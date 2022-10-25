package com.applovin.impl.adview.activity.p011a;

import android.graphics.Color;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.adview.C1316u;
import com.applovin.impl.adview.C1317v;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1719b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1763o;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.a.c */
/* loaded from: classes.dex */
public class C1167c extends AbstractC1165a {
    public C1167c(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k);
    }

    /* renamed from: a */
    public void m8275a(ImageView imageView, C1267n c1267n, final C1317v c1317v, C1157a c1157a, ProgressBar progressBar, View view, AppLovinAdView appLovinAdView) {
        if (this.f352c.m7129aK()) {
            appLovinAdView.setLayoutParams(this.f354e);
            this.f353d.addView(appLovinAdView);
            View view2 = new View(this.f351b);
            view2.setLayoutParams(this.f354e);
            view2.setBackgroundColor(Color.argb(254, 0, 0, 0));
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.activity.a.c.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    return true;
                }
            });
            this.f353d.addView(view2);
            view.setLayoutParams(this.f354e);
            this.f353d.addView(view);
        } else {
            view.setLayoutParams(this.f354e);
            this.f353d.addView(view);
            appLovinAdView.setLayoutParams(this.f354e);
            this.f353d.addView(appLovinAdView);
            appLovinAdView.setVisibility(4);
        }
        if (c1317v != null) {
            C1316u m7170C = this.f352c.m7170C();
            Point m6279a = C1724f.m6279a(this.f351b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (m6279a.x * (m7170C.m7889a() / 100.0d)), (int) (m6279a.y * (m7170C.m7888b() / 100.0d)), m7170C.m7886d());
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f351b, m7170C.m7887c());
            layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
            this.f353d.addView(c1317v, layoutParams);
            if (m7170C.m7881i() > 0.0f) {
                c1317v.setVisibility(4);
                long secondsToMillisLong = Utils.secondsToMillisLong(m7170C.m7881i());
                final long m7883g = m7170C.m7883g();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1763o.m6157a(c1317v, m7883g, (Runnable) null);
                    }
                }, secondsToMillisLong);
            }
            if (m7170C.m7880j() > 0.0f) {
                long secondsToMillisLong2 = Utils.secondsToMillisLong(m7170C.m7880j());
                final long m7882h = m7170C.m7882h();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.activity.a.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C1763o.m6155b(c1317v, m7882h, null);
                    }
                }, secondsToMillisLong2);
            }
        }
        if (c1267n != null) {
            m8277a(this.f352c.m7150W(), (this.f352c.m7124ab() ? 3 : 5) | 48, c1267n);
        }
        if (imageView != null) {
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f351b, ((Integer) this.f350a.m6656a(C1568b.f1808cw)).intValue());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx2, dpToPx2, ((Integer) this.f350a.m6656a(C1568b.f1810cy)).intValue());
            int dpToPx3 = AppLovinSdkUtils.dpToPx(this.f351b, ((Integer) this.f350a.m6656a(C1568b.f1809cx)).intValue());
            layoutParams2.setMargins(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
            this.f353d.addView(imageView, layoutParams2);
        }
        if (c1157a != null) {
            this.f353d.addView(c1157a, this.f354e);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams3.setMargins(0, 0, 0, ((Integer) this.f350a.m6656a(C1568b.f1762cC)).intValue());
            this.f353d.addView(progressBar, layoutParams3);
        }
        this.f351b.setContentView(this.f353d);
    }

    /* renamed from: a */
    public void m8274a(C1267n c1267n, View view) {
        view.setVisibility(0);
        C1719b.m6291a(this.f353d, view);
        if (c1267n != null) {
            m8277a(this.f352c.m7150W(), (this.f352c.m7125aa() ? 3 : 5) | 48, c1267n);
        }
    }
}
