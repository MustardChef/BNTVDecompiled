package com.applovin.impl.sdk.p030d;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.a */
/* loaded from: classes.dex */
public class C1576a {

    /* renamed from: a */
    private final String f1968a;

    /* renamed from: b */
    private final String f1969b;

    /* renamed from: c */
    private final Map<String, String> f1970c;

    /* renamed from: d */
    private final boolean f1971d;

    public C1576a(String str, String str2) {
        this(str, str2, null, false);
    }

    public C1576a(String str, String str2, Map<String, String> map, boolean z) {
        this.f1968a = str;
        this.f1969b = str2;
        this.f1970c = map;
        this.f1971d = z;
    }

    /* renamed from: a */
    public String m6962a() {
        return this.f1968a;
    }

    /* renamed from: b */
    public String m6961b() {
        return this.f1969b;
    }

    /* renamed from: c */
    public Map<String, String> m6960c() {
        return this.f1970c;
    }

    /* renamed from: d */
    public boolean m6959d() {
        return this.f1971d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f1968a + "', backupUrl='" + this.f1969b + "', headers='" + this.f1970c + "', shouldFireInWebView='" + this.f1971d + "'}";
    }
}
