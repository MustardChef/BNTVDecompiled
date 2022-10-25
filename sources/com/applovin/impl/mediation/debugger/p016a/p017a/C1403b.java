package com.applovin.impl.mediation.debugger.p016a.p017a;

import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.b */
/* loaded from: classes.dex */
public class C1403b {

    /* renamed from: a */
    private final C1407b f1018a;

    /* renamed from: b */
    private final String f1019b;

    /* renamed from: c */
    private final String f1020c;

    /* renamed from: d */
    private final C1405d f1021d;

    /* renamed from: e */
    private final List<C1405d> f1022e;

    public C1403b(JSONObject jSONObject, C1407b c1407b, C1662k c1662k) {
        this.f1018a = c1407b;
        this.f1019b = JsonUtils.getString(jSONObject, "name", "");
        this.f1020c = JsonUtils.getString(jSONObject, "display_name", "");
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f1021d = new C1405d(jSONObject2, c1662k);
        } else {
            this.f1021d = null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.f1022e = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f1022e.add(new C1405d(jSONObject3, c1662k));
            }
        }
    }

    /* renamed from: a */
    public C1407b m7548a() {
        return this.f1018a;
    }

    /* renamed from: b */
    public String m7547b() {
        return this.f1019b;
    }

    /* renamed from: c */
    public String m7546c() {
        return this.f1020c;
    }

    /* renamed from: d */
    public C1405d m7545d() {
        return this.f1021d;
    }

    /* renamed from: e */
    public boolean m7544e() {
        return this.f1021d != null;
    }

    /* renamed from: f */
    public List<C1405d> m7543f() {
        return this.f1022e;
    }
}
