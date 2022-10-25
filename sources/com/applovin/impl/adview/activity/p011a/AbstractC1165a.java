package com.applovin.impl.adview.activity.p011a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.adview.activity.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1165a {

    /* renamed from: a */
    final C1662k f350a;

    /* renamed from: b */
    final AppLovinFullscreenActivity f351b;

    /* renamed from: c */
    final AbstractC1537g f352c;

    /* renamed from: d */
    final ViewGroup f353d;

    /* renamed from: e */
    final FrameLayout.LayoutParams f354e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC1165a(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f354e = layoutParams;
        this.f352c = abstractC1537g;
        this.f350a = c1662k;
        this.f351b = appLovinFullscreenActivity;
        FrameLayout frameLayout = new FrameLayout(appLovinFullscreenActivity);
        this.f353d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m8277a(AbstractC1537g.C1541c c1541c, int i, C1267n c1267n) {
        c1267n.m8028a(c1541c.f1542a, c1541c.f1546e, c1541c.f1545d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c1267n.getLayoutParams());
        layoutParams.setMargins(c1541c.f1544c, c1541c.f1543b, c1541c.f1544c, 0);
        layoutParams.gravity = i;
        this.f353d.addView(c1267n, layoutParams);
    }
}
