package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afy */
/* loaded from: classes2.dex */
public final class afy extends bnd implements bok {

    /* renamed from: a */
    private static final afy f3918a;

    /* renamed from: e */
    private int f3919e;

    /* renamed from: f */
    private long f3920f;

    /* renamed from: g */
    private String f3921g = "";

    /* renamed from: h */
    private bls f3922h = bls.f6015b;

    static {
        afy afyVar = new afy();
        f3918a = afyVar;
        bnd.m3290aD(afy.class, afyVar);
    }

    private afy() {
    }

    /* renamed from: c */
    public static afy m5506c() {
        return f3918a;
    }

    /* renamed from: a */
    public final long m5508a() {
        return this.f3920f;
    }

    /* renamed from: d */
    public final boolean m5505d() {
        return (this.f3919e & 1) != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnd
    /* renamed from: i */
    protected final Object mo2732i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return f3918a;
                    }
                    return new aga((byte[]) null, (int[]) null);
                }
                return new afy();
            }
            return m3291aC(f3918a, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"e", "f", "g", "h"});
        }
        return (byte) 1;
    }
}
