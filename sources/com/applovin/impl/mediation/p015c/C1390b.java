package com.applovin.impl.mediation.p015c;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.b */
/* loaded from: classes.dex */
public class C1390b extends C1725g {

    /* renamed from: a */
    private static final String[] f972a = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};

    /* renamed from: b */
    private static final String[] f973b = {"ads", "settings", "signal_providers"};

    /* renamed from: a */
    public static String m7606a(C1662k c1662k) {
        return C1725g.m6263a((String) c1662k.m6656a(C1567a.f1625c), "1.0/mediate", c1662k);
    }

    /* renamed from: a */
    public static void m7605a(JSONObject jSONObject, C1662k c1662k) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(shallowCopy, f972a);
            c1662k.m6653a((C1570d<C1570d<String>>) C1570d.f1951w, (C1570d<String>) shallowCopy.toString());
        }
    }

    /* renamed from: b */
    public static String m7604b(C1662k c1662k) {
        return C1725g.m6263a((String) c1662k.m6656a(C1567a.f1626d), "1.0/mediate", c1662k);
    }

    /* renamed from: b */
    public static void m7603b(JSONObject jSONObject, C1662k c1662k) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (!JsonUtils.valueExists(jSONObject, "auto_init_adapters") && !JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            c1662k.m6624b(C1570d.f1952x);
            return;
        }
        JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
        JsonUtils.removeObjectsForKeys(shallowCopy, f973b);
        c1662k.m6653a((C1570d<C1570d<String>>) C1570d.f1952x, (C1570d<String>) shallowCopy.toString());
    }

    /* renamed from: c */
    public static String m7602c(C1662k c1662k) {
        return C1725g.m6263a((String) c1662k.m6656a(C1567a.f1625c), "1.0/mediate_debug", c1662k);
    }

    /* renamed from: d */
    public static String m7601d(C1662k c1662k) {
        return C1725g.m6263a((String) c1662k.m6656a(C1567a.f1626d), "1.0/mediate_debug", c1662k);
    }
}
