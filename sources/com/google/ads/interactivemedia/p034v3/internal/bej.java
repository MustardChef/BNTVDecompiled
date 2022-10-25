package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bej */
/* loaded from: classes2.dex */
public final class bej extends bnd implements bok {

    /* renamed from: a */
    private static final bej f5579a;

    /* renamed from: e */
    private int f5580e;

    /* renamed from: f */
    private bek f5581f;

    static {
        bej bejVar = new bej();
        f5579a = bejVar;
        bnd.m3290aD(bej.class, bejVar);
    }

    private bej() {
    }

    /* renamed from: b */
    public static /* synthetic */ bej m3899b() {
        return f5579a;
    }

    /* renamed from: c */
    public static bej m3898c(bls blsVar, bmr bmrVar) throws bnm {
        return (bej) bnd.m3280aw(f5579a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m3896e(bej bejVar, bek bekVar) {
        bekVar.getClass();
        bejVar.f5581f = bekVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m3895f(bej bejVar) {
        bejVar.f5580e = 0;
    }

    /* renamed from: g */
    public static bep m3894g() {
        return (bep) f5579a.m3283at();
    }

    /* renamed from: a */
    public final int m3900a() {
        return this.f5580e;
    }

    /* renamed from: d */
    public final bek m3897d() {
        bek bekVar = this.f5581f;
        return bekVar == null ? bek.m3892b() : bekVar;
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
                        return f5579a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new bej();
            }
            return m3291aC(f5579a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
