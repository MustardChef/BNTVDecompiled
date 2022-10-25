package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bek */
/* loaded from: classes2.dex */
public final class bek extends bnd implements bok {

    /* renamed from: a */
    private static final bek f5582a;

    /* renamed from: e */
    private String f5583e = "";

    static {
        bek bekVar = new bek();
        f5582a = bekVar;
        bnd.m3290aD(bek.class, bekVar);
    }

    private bek() {
    }

    /* renamed from: b */
    public static bek m3892b() {
        return f5582a;
    }

    /* renamed from: c */
    public static bek m3891c(bls blsVar, bmr bmrVar) throws bnm {
        return (bek) bnd.m3280aw(f5582a, blsVar, bmrVar);
    }

    /* renamed from: d */
    public final String m3890d() {
        return this.f5583e;
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
                        return f5582a;
                    }
                    return new bep((byte[]) null, (int[]) null);
                }
                return new bek();
            }
            return m3291aC(f5582a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"e"});
        }
        return (byte) 1;
    }
}
