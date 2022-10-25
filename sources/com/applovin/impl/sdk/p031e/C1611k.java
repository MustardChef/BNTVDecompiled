package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.C1529c;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.k */
/* loaded from: classes.dex */
public class C1611k extends C1609j {

    /* renamed from: a */
    private final C1529c f2096a;

    public C1611k(C1529c c1529c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super(C1531d.m7215a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", c1662k);
        this.f2096a = c1529c;
    }

    @Override // com.applovin.impl.sdk.p031e.C1609j
    /* renamed from: a */
    Map<String, String> mo6809a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f2096a.m7223a());
        hashMap.put("adtoken_prefix", this.f2096a.m7220c());
        return hashMap;
    }

    @Override // com.applovin.impl.sdk.p031e.C1609j
    /* renamed from: b */
    protected EnumC1528b mo6808b() {
        return EnumC1528b.REGULAR_AD_TOKEN;
    }
}
