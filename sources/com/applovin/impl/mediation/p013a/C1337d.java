package com.applovin.impl.mediation.p013a;

import com.applovin.impl.mediation.C1471g;
import com.applovin.impl.sdk.C1662k;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.d */
/* loaded from: classes.dex */
public class C1337d extends AbstractC1334a {
    private C1337d(C1337d c1337d, C1471g c1471g) {
        super(c1337d.m7765I(), c1337d.m7766H(), c1471g, c1337d.f833b);
    }

    public C1337d(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        super(jSONObject, jSONObject2, null, c1662k);
    }

    @Override // com.applovin.impl.mediation.p013a.AbstractC1334a
    /* renamed from: a */
    public AbstractC1334a mo7767a(C1471g c1471g) {
        return new C1337d(this, c1471g);
    }
}
