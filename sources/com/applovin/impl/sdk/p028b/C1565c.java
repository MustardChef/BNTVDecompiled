package com.applovin.impl.sdk.p028b;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.c */
/* loaded from: classes.dex */
public class C1565c {

    /* renamed from: a */
    private final String f1595a;

    /* renamed from: b */
    private Map<String, String> f1596b;

    private C1565c(String str, Map<String, String> map) {
        this.f1595a = str;
        this.f1596b = map;
    }

    /* renamed from: a */
    public static C1565c m7020a(String str) {
        return m7019a(str, null);
    }

    /* renamed from: a */
    public static C1565c m7019a(String str, Map<String, String> map) {
        return new C1565c(str, map);
    }

    /* renamed from: a */
    public Map<String, String> m7021a() {
        return this.f1596b;
    }

    /* renamed from: b */
    public String m7018b() {
        return this.f1595a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f1595a + "'params='" + this.f1596b + "'}";
    }
}
