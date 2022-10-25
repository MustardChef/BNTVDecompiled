package com.applovin.impl.adview.activity.p011a;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;

/* renamed from: com.applovin.impl.adview.activity.a.b */
/* loaded from: classes.dex */
public class C1166b extends AbstractC1165a {
    public C1166b(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k);
    }

    /* renamed from: a */
    public void m8276a(C1267n c1267n, AppLovinAdView appLovinAdView) {
        this.f353d.addView(appLovinAdView);
        if (c1267n != null) {
            m8277a(this.f352c.m7150W(), (this.f352c.m7125aa() ? 3 : 5) | 48, c1267n);
        }
        this.f351b.setContentView(this.f353d);
    }
}
