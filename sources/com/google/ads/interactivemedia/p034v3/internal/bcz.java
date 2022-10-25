package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcz */
/* loaded from: classes2.dex */
public final class bcz extends bnd implements bok {

    /* renamed from: a */
    private static final bcz f5436a;

    /* renamed from: e */
    private bdb f5437e;

    /* renamed from: f */
    private bdy f5438f;

    static {
        bcz bczVar = new bcz();
        f5436a = bczVar;
        bnd.m3290aD(bcz.class, bczVar);
    }

    private bcz() {
    }

    /* renamed from: b */
    public static bcz m4128b(bls blsVar, bmr bmrVar) throws bnm {
        return (bcz) bnd.m3280aw(f5436a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4125e(bcz bczVar, bdb bdbVar) {
        bdbVar.getClass();
        bczVar.f5437e = bdbVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4124f(bcz bczVar, bdy bdyVar) {
        bdyVar.getClass();
        bczVar.f5438f = bdyVar;
    }

    /* renamed from: g */
    public static bep m4123g() {
        return (bep) f5436a.m3283at();
    }

    /* renamed from: c */
    public final bdb m4127c() {
        bdb bdbVar = this.f5437e;
        return bdbVar == null ? bdb.m4108c() : bdbVar;
    }

    /* renamed from: d */
    public final bdy m4126d() {
        bdy bdyVar = this.f5438f;
        return bdyVar == null ? bdy.m3963c() : bdyVar;
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
                        return f5436a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (char[]) null, (byte[]) null);
                }
                return new bcz();
            }
            return m3291aC(f5436a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
