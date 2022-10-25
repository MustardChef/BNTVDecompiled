package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdl */
/* loaded from: classes2.dex */
public final class bdl extends bnd implements bok {

    /* renamed from: a */
    private static final bdl f5476a;

    /* renamed from: e */
    private int f5477e;

    /* renamed from: f */
    private int f5478f;

    static {
        bdl bdlVar = new bdl();
        f5476a = bdlVar;
        bnd.m3290aD(bdl.class, bdlVar);
    }

    private bdl() {
    }

    /* renamed from: c */
    public static bdl m4043c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdl) bnd.m3280aw(f5476a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static bep m4041e() {
        return (bep) f5476a.m3283at();
    }

    /* renamed from: a */
    public final int m4045a() {
        return this.f5477e;
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
                        return f5476a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new bdl();
            }
            return m3291aC(f5476a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
