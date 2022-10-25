package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdm */
/* loaded from: classes2.dex */
public final class bdm extends bnd implements bok {

    /* renamed from: a */
    private static final bdm f5479a;

    /* renamed from: e */
    private int f5480e;

    /* renamed from: f */
    private bls f5481f = bls.f6015b;

    static {
        bdm bdmVar = new bdm();
        f5479a = bdmVar;
        bnd.m3290aD(bdm.class, bdmVar);
    }

    private bdm() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdm m4039b() {
        return f5479a;
    }

    /* renamed from: c */
    public static bdm m4038c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdm) bnd.m3280aw(f5479a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4036e(bdm bdmVar, bls blsVar) {
        bdmVar.f5481f = blsVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4035f(bdm bdmVar) {
        bdmVar.f5480e = 0;
    }

    /* renamed from: g */
    public static bep m4034g() {
        return (bep) f5479a.m3283at();
    }

    /* renamed from: a */
    public final int m4040a() {
        return this.f5480e;
    }

    /* renamed from: d */
    public final bls m4037d() {
        return this.f5481f;
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
                        return f5479a;
                    }
                    return new bep((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new bdm();
            }
            return m3291aC(f5479a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
