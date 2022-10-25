package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e.r */
/* loaded from: classes.dex */
public class C1631r extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final JSONObject f2171a;

    /* renamed from: c */
    private final JSONObject f2172c;

    /* renamed from: d */
    private final AppLovinAdLoadListener f2173d;

    /* renamed from: e */
    private final EnumC1528b f2174e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1631r(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super("TaskRenderAppLovinAd", c1662k);
        this.f2171a = jSONObject;
        this.f2172c = jSONObject2;
        this.f2174e = enumC1528b;
        this.f2173d = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        m6884a("Rendering ad...");
        C1527a c1527a = new C1527a(this.f2171a, this.f2172c, this.f2174e, this.f2058b);
        boolean booleanValue = JsonUtils.getBoolean(this.f2171a, "gs_load_immediately", false).booleanValue();
        boolean booleanValue2 = JsonUtils.getBoolean(this.f2171a, "vs_load_immediately", true).booleanValue();
        C1597d c1597d = new C1597d(c1527a, this.f2058b, this.f2173d);
        c1597d.m6842a(booleanValue2);
        c1597d.m6841b(booleanValue);
        C1620o.EnumC1622a enumC1622a = C1620o.EnumC1622a.CACHING_OTHER;
        if (((Boolean) this.f2058b.m6656a(C1568b.f1738be)).booleanValue()) {
            if (c1527a.getSize() == AppLovinAdSize.INTERSTITIAL && c1527a.getType() == AppLovinAdType.REGULAR) {
                enumC1622a = C1620o.EnumC1622a.CACHING_INTERSTITIAL;
            } else if (c1527a.getSize() == AppLovinAdSize.INTERSTITIAL && c1527a.getType() == AppLovinAdType.INCENTIVIZED) {
                enumC1622a = C1620o.EnumC1622a.CACHING_INCENTIVIZED;
            }
        }
        this.f2058b.m6670Q().m6793a(c1597d, enumC1622a);
    }
}
