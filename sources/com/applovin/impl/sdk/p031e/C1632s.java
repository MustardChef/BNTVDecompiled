package com.applovin.impl.sdk.p031e;

import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1134b;
import com.applovin.impl.p010a.C1135c;
import com.applovin.impl.p010a.C1139f;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.p010a.C1143j;
import com.applovin.impl.p010a.EnumC1136d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.e.s */
/* loaded from: classes.dex */
class C1632s extends AbstractRunnableC1589a {

    /* renamed from: a */
    private C1135c f2175a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f2176c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1632s(C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super("TaskRenderVastAd", c1662k);
        this.f2176c = appLovinAdLoadListener;
        this.f2175a = c1135c;
    }

    @Override // java.lang.Runnable
    public void run() {
        m6884a("Rendering VAST ad...");
        int size = this.f2175a.m8379b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        C1139f c1139f = null;
        C1143j c1143j = null;
        C1134b c1134b = null;
        String str2 = "";
        for (C1766p c1766p : this.f2175a.m8379b()) {
            C1766p m6149c = c1766p.m6149c(C1142i.m8351a(c1766p) ? "Wrapper" : "InLine");
            if (m6149c != null) {
                C1766p m6149c2 = m6149c.m6149c("AdSystem");
                if (m6149c2 != null) {
                    c1139f = C1139f.m8363a(m6149c2, c1139f, this.f2058b);
                }
                str = C1142i.m8350a(m6149c, "AdTitle", str);
                str2 = C1142i.m8350a(m6149c, "Description", str2);
                C1142i.m8347a(m6149c.m6153a("Impression"), hashSet, this.f2175a, this.f2058b);
                C1766p m6151b = m6149c.m6151b("ViewableImpression");
                if (m6151b != null) {
                    C1142i.m8347a(m6151b.m6153a("Viewable"), hashSet, this.f2175a, this.f2058b);
                }
                C1142i.m8347a(m6149c.m6153a("Error"), hashSet2, this.f2175a, this.f2058b);
                C1766p m6151b2 = m6149c.m6151b("Creatives");
                if (m6151b2 != null) {
                    for (C1766p c1766p2 : m6151b2.m6148d()) {
                        C1766p m6151b3 = c1766p2.m6151b("Linear");
                        if (m6151b3 != null) {
                            c1143j = C1143j.m8336a(m6151b3, c1143j, this.f2175a, this.f2058b);
                        } else {
                            C1766p m6149c3 = c1766p2.m6149c("CompanionAds");
                            if (m6149c3 != null) {
                                C1766p m6149c4 = m6149c3.m6149c("Companion");
                                if (m6149c4 != null) {
                                    c1134b = C1134b.m8384a(m6149c4, c1134b, this.f2175a, this.f2058b);
                                }
                            } else {
                                m6879d("Received and will skip rendering for an unidentified creative: " + c1766p2);
                            }
                        }
                    }
                }
            } else {
                m6879d("Did not find wrapper or inline response for node: " + c1766p);
            }
        }
        C1129a m8410a = C1129a.m8423aS().m8403a(this.f2058b).m8400a(this.f2175a.m8378c()).m8396b(this.f2175a.m8377d()).m8404a(this.f2175a.m8376e()).m8409a(this.f2175a.m8375f()).m8402a(str).m8398b(str2).m8406a(c1139f).m8405a(c1143j).m8407a(c1134b).m8401a(hashSet).m8397b(hashSet2).m8410a();
        EnumC1136d m8355a = C1142i.m8355a(m8410a);
        if (m8355a != null) {
            C1142i.m8352a(this.f2175a, this.f2176c, m8355a, -6, this.f2058b);
            return;
        }
        C1598e c1598e = new C1598e(m8410a, this.f2058b, this.f2176c);
        C1620o.EnumC1622a enumC1622a = C1620o.EnumC1622a.CACHING_OTHER;
        if (((Boolean) this.f2058b.m6656a(C1568b.f1738be)).booleanValue()) {
            if (m8410a.getType() == AppLovinAdType.REGULAR) {
                enumC1622a = C1620o.EnumC1622a.CACHING_INTERSTITIAL;
            } else if (m8410a.getType() == AppLovinAdType.INCENTIVIZED) {
                enumC1622a = C1620o.EnumC1622a.CACHING_INCENTIVIZED;
            }
        }
        this.f2058b.m6670Q().m6793a(c1598e, enumC1622a);
    }
}
