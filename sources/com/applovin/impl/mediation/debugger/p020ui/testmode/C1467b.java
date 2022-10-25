package com.applovin.impl.mediation.debugger.p020ui.testmode;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.b */
/* loaded from: classes.dex */
public class C1467b {

    /* renamed from: a */
    private final C1662k f1282a;

    /* renamed from: b */
    private boolean f1283b;

    /* renamed from: c */
    private boolean f1284c;

    /* renamed from: d */
    private String f1285d;

    public C1467b(C1662k c1662k) {
        this.f1282a = c1662k;
        this.f1285d = (String) c1662k.m6623b((C1570d<C1570d<String>>) C1570d.f1927A, (C1570d<String>) null);
        c1662k.m6624b(C1570d.f1927A);
        if (StringUtils.isValidString(this.f1285d)) {
            this.f1284c = true;
        }
        this.f1283b = ((Boolean) c1662k.m6623b((C1570d<C1570d<Boolean>>) C1570d.f1928B, (C1570d<Boolean>) false)).booleanValue();
        c1662k.m6624b(C1570d.f1928B);
    }

    /* renamed from: a */
    public void m7350a(String str) {
        this.f1285d = str;
    }

    /* renamed from: a */
    public void m7349a(JSONObject jSONObject) {
        if (this.f1283b) {
            return;
        }
        this.f1283b = JsonUtils.containsCaseInsensitiveString(this.f1282a.m6667T().m6543j().f2334b, JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray())) || this.f1282a.m6667T().m6547f() || this.f1282a.m6667T().m6542k();
    }

    /* renamed from: a */
    public void m7348a(boolean z) {
        this.f1284c = z;
    }

    /* renamed from: a */
    public boolean m7351a() {
        return this.f1283b;
    }

    /* renamed from: b */
    public void m7346b(String str) {
        this.f1282a.m6653a((C1570d<C1570d<String>>) C1570d.f1927A, (C1570d<String>) str);
    }

    /* renamed from: b */
    public boolean m7347b() {
        return this.f1284c;
    }

    /* renamed from: c */
    public String m7345c() {
        return this.f1285d;
    }

    /* renamed from: d */
    public void m7344d() {
        this.f1282a.m6653a((C1570d<C1570d<Boolean>>) C1570d.f1928B, (C1570d<Boolean>) true);
    }
}
