package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bds */
/* loaded from: classes2.dex */
public final class bds extends bnd implements bok {

    /* renamed from: a */
    private static final bds f5497a;

    /* renamed from: e */
    private int f5498e;

    /* renamed from: f */
    private bdt f5499f;

    /* renamed from: g */
    private bls f5500g = bls.f6015b;

    static {
        bds bdsVar = new bds();
        f5497a = bdsVar;
        bnd.m3290aD(bds.class, bdsVar);
    }

    private bds() {
    }

    /* renamed from: c */
    public static bds m4007c(bls blsVar, bmr bmrVar) throws bnm {
        return (bds) bnd.m3280aw(f5497a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m4004f(bds bdsVar, bdt bdtVar) {
        bdtVar.getClass();
        bdsVar.f5499f = bdtVar;
    }

    /* renamed from: j */
    public static bep m4001j() {
        return (bep) f5497a.m3283at();
    }

    /* renamed from: a */
    public final int m4009a() {
        return this.f5498e;
    }

    /* renamed from: d */
    public final bdt m4006d() {
        bdt bdtVar = this.f5499f;
        return bdtVar == null ? bdt.m3997d() : bdtVar;
    }

    /* renamed from: e */
    public final bls m4005e() {
        return this.f5500g;
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
                        return f5497a;
                    }
                    return new bep((byte[]) null, (char[]) null, (short[]) null);
                }
                return new bds();
            }
            return m3291aC(f5497a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
