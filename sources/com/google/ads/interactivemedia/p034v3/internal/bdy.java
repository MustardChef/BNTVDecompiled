package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdy */
/* loaded from: classes2.dex */
public final class bdy extends bnd implements bok {

    /* renamed from: a */
    private static final bdy f5529a;

    /* renamed from: e */
    private bdz f5530e;

    /* renamed from: f */
    private int f5531f;

    /* renamed from: g */
    private int f5532g;

    static {
        bdy bdyVar = new bdy();
        f5529a = bdyVar;
        bnd.m3290aD(bdy.class, bdyVar);
    }

    private bdy() {
    }

    /* renamed from: c */
    public static bdy m3963c() {
        return f5529a;
    }

    /* renamed from: d */
    public static bdy m3962d(bls blsVar, bmr bmrVar) throws bnm {
        return (bdy) bnd.m3280aw(f5529a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m3960f(bdy bdyVar, bdz bdzVar) {
        bdzVar.getClass();
        bdyVar.f5530e = bdzVar;
    }

    /* renamed from: h */
    public static bep m3958h() {
        return (bep) f5529a.m3283at();
    }

    /* renamed from: a */
    public final int m3965a() {
        return this.f5531f;
    }

    /* renamed from: e */
    public final bdz m3961e() {
        bdz bdzVar = this.f5530e;
        return bdzVar == null ? bdz.m3955c() : bdzVar;
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
                        return f5529a;
                    }
                    return new bep((byte[]) null, (char[]) null, (char[]) null);
                }
                return new bdy();
            }
            return m3291aC(f5529a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
