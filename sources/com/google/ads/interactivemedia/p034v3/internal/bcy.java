package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcy */
/* loaded from: classes2.dex */
public final class bcy extends bnd implements bok {

    /* renamed from: a */
    private static final bcy f5432a;

    /* renamed from: e */
    private int f5433e;

    /* renamed from: f */
    private bda f5434f;

    /* renamed from: g */
    private bdx f5435g;

    static {
        bcy bcyVar = new bcy();
        f5432a = bcyVar;
        bnd.m3290aD(bcy.class, bcyVar);
    }

    private bcy() {
    }

    /* renamed from: c */
    public static bcy m4136c(bls blsVar, bmr bmrVar) throws bnm {
        return (bcy) bnd.m3280aw(f5432a, blsVar, bmrVar);
    }

    /* renamed from: g */
    public static /* synthetic */ void m4132g(bcy bcyVar, bda bdaVar) {
        bdaVar.getClass();
        bcyVar.f5434f = bdaVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m4131h(bcy bcyVar, bdx bdxVar) {
        bdxVar.getClass();
        bcyVar.f5435g = bdxVar;
    }

    /* renamed from: j */
    public static bep m4130j() {
        return (bep) f5432a.m3283at();
    }

    /* renamed from: a */
    public final int m4138a() {
        return this.f5433e;
    }

    /* renamed from: d */
    public final bda m4135d() {
        bda bdaVar = this.f5434f;
        return bdaVar == null ? bda.m4118c() : bdaVar;
    }

    /* renamed from: e */
    public final bdx m4134e() {
        bdx bdxVar = this.f5435g;
        return bdxVar == null ? bdx.m3973c() : bdxVar;
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
                        return f5432a;
                    }
                    return new bep((byte[]) null, (short[]) null, (byte[]) null, (byte[]) null);
                }
                return new bcy();
            }
            return m3291aC(f5432a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
