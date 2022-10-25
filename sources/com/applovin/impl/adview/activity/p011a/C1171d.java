package com.applovin.impl.adview.activity.p011a;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.a.d */
/* loaded from: classes.dex */
public class C1171d extends AbstractC1165a {
    public C1171d(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k);
    }

    /* renamed from: a */
    public void m8273a(ImageView imageView, C1267n c1267n, C1267n c1267n2, C1157a c1157a, AppLovinAdView appLovinAdView) {
        this.f353d.addView(appLovinAdView);
        if (c1267n != null) {
            m8277a(this.f352c.m7150W(), (this.f352c.m7124ab() ? 3 : 5) | 48, c1267n);
        }
        if (c1267n2 != null) {
            m8277a(this.f352c.m7150W(), (this.f352c.m7125aa() ? 3 : 5) | 48, c1267n2);
        }
        if (imageView != null) {
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f351b, ((Integer) this.f350a.m6656a(C1568b.f1808cw)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, ((Integer) this.f350a.m6656a(C1568b.f1810cy)).intValue());
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f351b, ((Integer) this.f350a.m6656a(C1568b.f1809cx)).intValue());
            layoutParams.setMargins(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            this.f353d.addView(imageView, layoutParams);
        }
        if (c1157a != null) {
            this.f353d.addView(c1157a, this.f354e);
        }
        this.f351b.setContentView(this.f353d);
    }
}
