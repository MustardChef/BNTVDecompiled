package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.u */
/* loaded from: classes.dex */
public class C1714u {

    /* renamed from: a */
    private final C1662k f2467a;

    /* renamed from: b */
    private final JSONObject f2468b;

    /* renamed from: c */
    private final Object f2469c = new Object();

    public C1714u(C1662k c1662k) {
        this.f2467a = c1662k;
        this.f2468b = JsonUtils.jsonObjectFromJsonString((String) c1662k.m6623b((C1570d<C1570d<String>>) C1570d.f1947s, (C1570d<String>) JsonUtils.EMPTY_JSON), new JSONObject());
    }

    /* renamed from: a */
    public Integer m6300a(String str) {
        Integer valueOf;
        synchronized (this.f2469c) {
            if (this.f2468b.has(str)) {
                JsonUtils.putInt(this.f2468b, str, JsonUtils.getInt(this.f2468b, str, 0) + 1);
            } else {
                JsonUtils.putInt(this.f2468b, str, 1);
            }
            this.f2467a.m6653a((C1570d<C1570d<String>>) C1570d.f1947s, (C1570d<String>) this.f2468b.toString());
            valueOf = Integer.valueOf(JsonUtils.getInt(this.f2468b, str, 0));
        }
        return valueOf;
    }
}
