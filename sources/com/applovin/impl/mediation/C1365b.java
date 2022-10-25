package com.applovin.impl.mediation;

import com.applovin.impl.mediation.C1332a;
import com.applovin.impl.mediation.C1386c;
import com.applovin.impl.mediation.p013a.C1336c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.mediation.b */
/* loaded from: classes.dex */
public class C1365b implements C1332a.InterfaceC1333a, C1386c.InterfaceC1388a {

    /* renamed from: a */
    private final C1332a f909a;

    /* renamed from: b */
    private final C1386c f910b;

    /* renamed from: c */
    private final MaxAdListener f911c;

    public C1365b(C1662k c1662k, MaxAdListener maxAdListener) {
        this.f911c = maxAdListener;
        this.f909a = new C1332a(c1662k);
        this.f910b = new C1386c(c1662k, this);
    }

    @Override // com.applovin.impl.mediation.C1332a.InterfaceC1333a
    /* renamed from: a */
    public void mo7672a(final C1336c c1336c) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.b.1
            @Override // java.lang.Runnable
            public void run() {
                C1365b.this.f911c.onAdHidden(c1336c);
            }
        }, c1336c.m7774t());
    }

    /* renamed from: a */
    public void m7670a(MaxAd maxAd) {
        this.f910b.m7611a();
        this.f909a.m7821a();
    }

    /* renamed from: b */
    public void m7669b(C1336c c1336c) {
        long m7776r = c1336c.m7776r();
        if (m7776r >= 0) {
            this.f910b.m7610a(c1336c, m7776r);
        }
        if (c1336c.m7775s()) {
            this.f909a.m7820a(c1336c, this);
        }
    }

    @Override // com.applovin.impl.mediation.C1386c.InterfaceC1388a
    /* renamed from: c */
    public void mo7607c(C1336c c1336c) {
        this.f911c.onAdHidden(c1336c);
    }
}
