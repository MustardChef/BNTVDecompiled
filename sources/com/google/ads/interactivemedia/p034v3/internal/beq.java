package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.beq */
/* loaded from: classes2.dex */
public final class beq extends bnd implements bok {

    /* renamed from: a */
    private static final beq f5601a;

    /* renamed from: e */
    private int f5602e;

    /* renamed from: f */
    private bls f5603f = bls.f6015b;

    static {
        beq beqVar = new beq();
        f5601a = beqVar;
        bnd.m3290aD(beq.class, beqVar);
    }

    private beq() {
    }

    /* renamed from: b */
    public static bep m3796b() {
        return (bep) f5601a.m3283at();
    }

    /* renamed from: c */
    public static /* synthetic */ beq m3795c() {
        return f5601a;
    }

    /* renamed from: d */
    public static beq m3794d(bls blsVar, bmr bmrVar) throws bnm {
        return (beq) bnd.m3280aw(f5601a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m3792f(beq beqVar, bls blsVar) {
        beqVar.f5603f = blsVar;
    }

    /* renamed from: g */
    public static /* synthetic */ void m3791g(beq beqVar) {
        beqVar.f5602e = 0;
    }

    /* renamed from: a */
    public final int m3797a() {
        return this.f5602e;
    }

    /* renamed from: e */
    public final bls m3793e() {
        return this.f5603f;
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
                        return f5601a;
                    }
                    return new bep(null);
                }
                return new beq();
            }
            return m3291aC(f5601a, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
