package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdd */
/* loaded from: classes2.dex */
public final class bdd extends bnd implements bok {

    /* renamed from: a */
    private static final bdd f5452a;

    /* renamed from: e */
    private int f5453e;

    /* renamed from: f */
    private bdf f5454f;

    /* renamed from: g */
    private bls f5455g = bls.f6015b;

    static {
        bdd bddVar = new bdd();
        f5452a = bddVar;
        bnd.m3290aD(bdd.class, bddVar);
    }

    private bdd() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdd m4096b() {
        return f5452a;
    }

    /* renamed from: c */
    public static bdd m4095c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdd) bnd.m3280aw(f5452a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m4092f(bdd bddVar, bdf bdfVar) {
        bdfVar.getClass();
        bddVar.f5454f = bdfVar;
    }

    /* renamed from: g */
    public static /* synthetic */ void m4091g(bdd bddVar, bls blsVar) {
        bddVar.f5455g = blsVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m4090h(bdd bddVar) {
        bddVar.f5453e = 0;
    }

    /* renamed from: j */
    public static bep m4089j() {
        return (bep) f5452a.m3283at();
    }

    /* renamed from: a */
    public final int m4097a() {
        return this.f5453e;
    }

    /* renamed from: d */
    public final bdf m4094d() {
        bdf bdfVar = this.f5454f;
        return bdfVar == null ? bdf.m4079c() : bdfVar;
    }

    /* renamed from: e */
    public final bls m4093e() {
        return this.f5455g;
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
                        return f5452a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (char[]) null);
                }
                return new bdd();
            }
            return m3291aC(f5452a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
