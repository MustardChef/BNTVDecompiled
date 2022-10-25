package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdb */
/* loaded from: classes2.dex */
public final class bdb extends bnd implements bok {

    /* renamed from: a */
    private static final bdb f5447a;

    /* renamed from: e */
    private bdc f5448e;

    /* renamed from: f */
    private int f5449f;

    static {
        bdb bdbVar = new bdb();
        f5447a = bdbVar;
        bnd.m3290aD(bdb.class, bdbVar);
    }

    private bdb() {
    }

    /* renamed from: c */
    public static bdb m4108c() {
        return f5447a;
    }

    /* renamed from: d */
    public static bdb m4107d(bls blsVar, bmr bmrVar) throws bnm {
        return (bdb) bnd.m3280aw(f5447a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m4105f(bdb bdbVar, bdc bdcVar) {
        bdcVar.getClass();
        bdbVar.f5448e = bdcVar;
    }

    /* renamed from: h */
    public static bep m4103h() {
        return (bep) f5447a.m3283at();
    }

    /* renamed from: a */
    public final int m4110a() {
        return this.f5449f;
    }

    /* renamed from: e */
    public final bdc m4106e() {
        bdc bdcVar = this.f5448e;
        return bdcVar == null ? bdc.m4100c() : bdcVar;
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
                        return f5447a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (short[]) null, (byte[]) null);
                }
                return new bdb();
            }
            return m3291aC(f5447a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
