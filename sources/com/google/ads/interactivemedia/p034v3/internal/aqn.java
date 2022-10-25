package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aqn */
/* loaded from: classes2.dex */
public final class aqn {

    /* renamed from: a */
    private final String f4911a;

    /* renamed from: b */
    private final Object f4912b;

    /* renamed from: c */
    private final int f4913c = 1;

    protected aqn(String str, Object obj, int i) {
        this.f4911a = str;
        this.f4912b = obj;
    }

    /* renamed from: a */
    public static aqn m4753a(String str, boolean z) {
        return new aqn(str, Boolean.valueOf(z), 1);
    }

    /* renamed from: b */
    public final Object m4752b() {
        aqq m4749a = aqs.m4749a();
        if (m4749a == null) {
            if (aqs.m4748b() != null) {
                aqs.m4748b().m4750a();
            }
            return this.f4912b;
        }
        return m4749a.mo4751a(this.f4911a, ((Boolean) this.f4912b).booleanValue());
    }
}
