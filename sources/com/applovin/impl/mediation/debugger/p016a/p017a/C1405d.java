package com.applovin.impl.mediation.debugger.p016a.p017a;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.d */
/* loaded from: classes.dex */
public class C1405d {

    /* renamed from: a */
    private final String f1027a;

    /* renamed from: b */
    private final String f1028b;

    public C1405d(JSONObject jSONObject, C1662k c1662k) {
        this.f1027a = JsonUtils.getString(jSONObject, "id", "");
        this.f1028b = JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.PRICE, null);
    }

    /* renamed from: a */
    public String m7538a() {
        return this.f1027a;
    }

    /* renamed from: b */
    public String m7537b() {
        return this.f1028b;
    }
}
