package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdx */
/* loaded from: classes2.dex */
public final class bdx extends bnd implements bok {

    /* renamed from: a */
    private static final bdx f5525a;

    /* renamed from: e */
    private int f5526e;

    /* renamed from: f */
    private bdz f5527f;

    /* renamed from: g */
    private bls f5528g = bls.f6015b;

    static {
        bdx bdxVar = new bdx();
        f5525a = bdxVar;
        bnd.m3290aD(bdx.class, bdxVar);
    }

    private bdx() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdx m3974b() {
        return f5525a;
    }

    /* renamed from: c */
    public static bdx m3973c() {
        return f5525a;
    }

    /* renamed from: d */
    public static bdx m3972d(bls blsVar, bmr bmrVar) throws bnm {
        return (bdx) bnd.m3280aw(f5525a, blsVar, bmrVar);
    }

    /* renamed from: g */
    public static /* synthetic */ void m3969g(bdx bdxVar, bdz bdzVar) {
        bdzVar.getClass();
        bdxVar.f5527f = bdzVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m3968h(bdx bdxVar, bls blsVar) {
        bdxVar.f5528g = blsVar;
    }

    /* renamed from: j */
    public static /* synthetic */ void m3967j(bdx bdxVar) {
        bdxVar.f5526e = 0;
    }

    /* renamed from: k */
    public static bep m3966k() {
        return (bep) f5525a.m3283at();
    }

    /* renamed from: a */
    public final int m3975a() {
        return this.f5526e;
    }

    /* renamed from: e */
    public final bdz m3971e() {
        bdz bdzVar = this.f5527f;
        return bdzVar == null ? bdz.m3955c() : bdzVar;
    }

    /* renamed from: f */
    public final bls m3970f() {
        return this.f5528g;
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
                        return f5525a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new bdx();
            }
            return m3291aC(f5525a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
