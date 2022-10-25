package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bel */
/* loaded from: classes2.dex */
public final class bel extends bnd implements bok {

    /* renamed from: a */
    private static final bel f5584a;

    /* renamed from: e */
    private int f5585e;

    /* renamed from: f */
    private bem f5586f;

    static {
        bel belVar = new bel();
        f5584a = belVar;
        bnd.m3290aD(bel.class, belVar);
    }

    private bel() {
    }

    /* renamed from: b */
    public static /* synthetic */ bel m3888b() {
        return f5584a;
    }

    /* renamed from: c */
    public static bel m3887c(bls blsVar, bmr bmrVar) throws bnm {
        return (bel) bnd.m3280aw(f5584a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m3885e(bel belVar, bem bemVar) {
        bemVar.getClass();
        belVar.f5586f = bemVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m3884f(bel belVar) {
        belVar.f5585e = 0;
    }

    /* renamed from: g */
    public static bep m3883g() {
        return (bep) f5584a.m3283at();
    }

    /* renamed from: a */
    public final int m3889a() {
        return this.f5585e;
    }

    /* renamed from: d */
    public final bem m3886d() {
        bem bemVar = this.f5586f;
        return bemVar == null ? bem.m3880c() : bemVar;
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
                        return f5584a;
                    }
                    return new bep((byte[]) null, (byte[]) null);
                }
                return new bel();
            }
            return m3291aC(f5584a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
