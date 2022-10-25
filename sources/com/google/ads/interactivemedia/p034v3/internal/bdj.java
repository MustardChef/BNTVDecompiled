package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdj */
/* loaded from: classes2.dex */
public final class bdj extends bnd implements bok {

    /* renamed from: a */
    private static final bdj f5470a;

    /* renamed from: e */
    private int f5471e;

    /* renamed from: f */
    private int f5472f;

    static {
        bdj bdjVar = new bdj();
        f5470a = bdjVar;
        bnd.m3290aD(bdj.class, bdjVar);
    }

    private bdj() {
    }

    /* renamed from: c */
    public static bdj m4055c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdj) bnd.m3280aw(f5470a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static bep m4053e() {
        return (bep) f5470a.m3283at();
    }

    /* renamed from: a */
    public final int m4057a() {
        return this.f5471e;
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
                        return f5470a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (int[]) null);
                }
                return new bdj();
            }
            return m3291aC(f5470a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"f", "e"});
        }
        return (byte) 1;
    }
}
