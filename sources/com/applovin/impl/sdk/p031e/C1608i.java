package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.i */
/* loaded from: classes.dex */
public class C1608i extends C1609j {

    /* renamed from: a */
    private final List<String> f2091a;

    public C1608i(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super(C1531d.m7215a(m6821a(list)), appLovinAdLoadListener, "TaskFetchMultizoneAd", c1662k);
        this.f2091a = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    private static String m6821a(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("No zone identifiers specified");
        }
        return list.get(0);
    }

    @Override // com.applovin.impl.sdk.p031e.C1609j
    /* renamed from: a */
    Map<String, String> mo6809a() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f2091a;
        hashMap.put("zone_ids", CollectionUtils.implode(list, list.size()));
        return hashMap;
    }

    @Override // com.applovin.impl.sdk.p031e.C1609j
    /* renamed from: b */
    protected EnumC1528b mo6808b() {
        return EnumC1528b.APPLOVIN_MULTIZONE;
    }
}
