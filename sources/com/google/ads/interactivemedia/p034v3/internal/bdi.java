package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdi */
/* loaded from: classes2.dex */
public final class bdi extends bnd implements bok {

    /* renamed from: a */
    private static final bdi f5467a;

    /* renamed from: e */
    private int f5468e;

    /* renamed from: f */
    private bls f5469f = bls.f6015b;

    static {
        bdi bdiVar = new bdi();
        f5467a = bdiVar;
        bnd.m3290aD(bdi.class, bdiVar);
    }

    private bdi() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdi m4063b() {
        return f5467a;
    }

    /* renamed from: c */
    public static bdi m4062c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdi) bnd.m3280aw(f5467a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4060e(bdi bdiVar, bls blsVar) {
        bdiVar.f5469f = blsVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4059f(bdi bdiVar) {
        bdiVar.f5468e = 0;
    }

    /* renamed from: g */
    public static bep m4058g() {
        return (bep) f5467a.m3283at();
    }

    /* renamed from: a */
    public final int m4064a() {
        return this.f5468e;
    }

    /* renamed from: d */
    public final bls m4061d() {
        return this.f5469f;
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
                        return f5467a;
                    }
                    return new bep((byte[]) null, (char[]) null, (int[]) null);
                }
                return new bdi();
            }
            return m3291aC(f5467a, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
