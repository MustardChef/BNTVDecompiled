package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdh */
/* loaded from: classes2.dex */
public final class bdh extends bnd implements bok {

    /* renamed from: a */
    private static final bdh f5464a;

    /* renamed from: e */
    private int f5465e;

    /* renamed from: f */
    private int f5466f;

    static {
        bdh bdhVar = new bdh();
        f5464a = bdhVar;
        bnd.m3290aD(bdh.class, bdhVar);
    }

    private bdh() {
    }

    /* renamed from: c */
    public static bdh m4067c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdh) bnd.m3280aw(f5464a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static bep m4065e() {
        return (bep) f5464a.m3283at();
    }

    /* renamed from: a */
    public final int m4069a() {
        return this.f5465e;
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
                        return f5464a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (short[]) null);
                }
                return new bdh();
            }
            return m3291aC(f5464a, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
