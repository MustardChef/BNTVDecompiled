package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdg */
/* loaded from: classes2.dex */
public final class bdg extends bnd implements bok {

    /* renamed from: a */
    private static final bdg f5461a;

    /* renamed from: e */
    private int f5462e;

    /* renamed from: f */
    private bls f5463f = bls.f6015b;

    static {
        bdg bdgVar = new bdg();
        f5461a = bdgVar;
        bnd.m3290aD(bdg.class, bdgVar);
    }

    private bdg() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdg m4075b() {
        return f5461a;
    }

    /* renamed from: c */
    public static bdg m4074c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdg) bnd.m3280aw(f5461a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4072e(bdg bdgVar, bls blsVar) {
        bdgVar.f5463f = blsVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4071f(bdg bdgVar) {
        bdgVar.f5462e = 0;
    }

    /* renamed from: g */
    public static bep m4070g() {
        return (bep) f5461a.m3283at();
    }

    /* renamed from: a */
    public final int m4076a() {
        return this.f5462e;
    }

    /* renamed from: d */
    public final bls m4073d() {
        return this.f5463f;
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
                        return f5461a;
                    }
                    return new bep((byte[]) null, (short[]) null, (char[]) null);
                }
                return new bdg();
            }
            return m3291aC(f5461a, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
