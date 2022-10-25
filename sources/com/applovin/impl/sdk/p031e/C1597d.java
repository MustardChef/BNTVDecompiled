package com.applovin.impl.sdk.p031e;

import android.net.Uri;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.e.d */
/* loaded from: classes.dex */
public class C1597d extends AbstractC1594c {

    /* renamed from: c */
    private final C1527a f2074c;

    /* renamed from: d */
    private boolean f2075d;

    /* renamed from: e */
    private boolean f2076e;

    public C1597d(C1527a c1527a, C1662k c1662k, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", c1527a, c1662k, appLovinAdLoadListener);
        this.f2074c = c1527a;
    }

    /* renamed from: j */
    private void m6840j() {
        m6884a("Caching HTML resources...");
        this.f2074c.m7235a(m6856a(this.f2074c.m7233c(), this.f2074c.m7163J(), this.f2074c));
        this.f2074c.m7140a(true);
        m6884a("Finish caching non-video resources for ad #" + this.f2074c.getAdIdNumber());
        C1710r m6588z = this.f2058b.m6588z();
        String e = m6878e();
        m6588z.m6322a(e, "Ad updated with cachedHTML = " + this.f2074c.m7233c());
    }

    /* renamed from: k */
    private void m6839k() {
        Uri e;
        if (m6854b() || (e = m6851e(this.f2074c.m7230i())) == null) {
            return;
        }
        if (this.f2074c.m7126aN()) {
            this.f2074c.m7235a(this.f2074c.m7233c().replaceFirst(this.f2074c.m7232e(), e.toString()));
            m6884a("Replaced video URL with cached video URI in HTML for web video ad");
        }
        this.f2074c.m7231g();
        this.f2074c.m7236a(e);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1594c, com.applovin.impl.mediation.C1514h.InterfaceC1515a
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo6843a(AbstractC1334a abstractC1334a) {
        super.mo6843a(abstractC1334a);
    }

    /* renamed from: a */
    public void m6842a(boolean z) {
        this.f2075d = z;
    }

    /* renamed from: b */
    public void m6841b(boolean z) {
        this.f2076e = z;
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1594c, java.lang.Runnable
    public void run() {
        super.run();
        boolean mo7085f = this.f2074c.mo7085f();
        boolean z = this.f2076e;
        if (mo7085f || z) {
            m6884a("Begin caching for streaming ad #" + this.f2074c.getAdIdNumber() + "...");
            m6852c();
            if (mo7085f) {
                if (this.f2075d) {
                    m6847i();
                }
                m6840j();
                if (!this.f2075d) {
                    m6847i();
                }
                m6839k();
            } else {
                m6847i();
                m6840j();
            }
        } else {
            m6884a("Begin processing for non-streaming ad #" + this.f2074c.getAdIdNumber() + "...");
            m6852c();
            m6840j();
            m6839k();
            m6847i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f2074c.getCreatedAtMillis();
        C1584d.m6924a(this.f2074c, this.f2058b);
        C1584d.m6925a(currentTimeMillis, this.f2074c, this.f2058b);
        m6861a(this.f2074c);
        m6863a();
    }
}
