package com.applovin.impl.mediation.p013a;

import com.applovin.impl.sdk.C1662k;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.g */
/* loaded from: classes.dex */
public class C1341g extends C1338e {
    public C1341g(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        super(jSONObject, jSONObject2, c1662k);
    }

    /* renamed from: a */
    public boolean m7724a() {
        return m7740b("only_collect_signal_when_initialized", (Boolean) false).booleanValue();
    }

    @Override // com.applovin.impl.mediation.p013a.C1338e
    public String toString() {
        return "SignalProviderSpec{adObject=" + m7765I() + '}';
    }
}
