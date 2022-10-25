package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcv */
/* loaded from: classes2.dex */
public final class bcv extends bnd implements bok {

    /* renamed from: a */
    private static final bcv f5423a;

    /* renamed from: e */
    private int f5424e;

    /* renamed from: f */
    private bls f5425f = bls.f6015b;

    /* renamed from: g */
    private bcx f5426g;

    static {
        bcv bcvVar = new bcv();
        f5423a = bcvVar;
        bnd.m3290aD(bcv.class, bcvVar);
    }

    private bcv() {
    }

    /* renamed from: b */
    public static /* synthetic */ bcv m4158b() {
        return f5423a;
    }

    /* renamed from: c */
    public static bcv m4157c(bls blsVar, bmr bmrVar) throws bnm {
        return (bcv) bnd.m3280aw(f5423a, blsVar, bmrVar);
    }

    /* renamed from: f */
    public static /* synthetic */ void m4154f(bcv bcvVar, bls blsVar) {
        bcvVar.f5425f = blsVar;
    }

    /* renamed from: g */
    public static /* synthetic */ void m4153g(bcv bcvVar, bcx bcxVar) {
        bcxVar.getClass();
        bcvVar.f5426g = bcxVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m4152h(bcv bcvVar) {
        bcvVar.f5424e = 0;
    }

    /* renamed from: j */
    public static bep m4151j() {
        return (bep) f5423a.m3283at();
    }

    /* renamed from: a */
    public final int m4159a() {
        return this.f5424e;
    }

    /* renamed from: d */
    public final bcx m4156d() {
        bcx bcxVar = this.f5426g;
        return bcxVar == null ? bcx.m4141c() : bcxVar;
    }

    /* renamed from: e */
    public final bls m4155e() {
        return this.f5425f;
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
                        return f5423a;
                    }
                    return new bep(null, null, null, null, null, null, null);
                }
                return new bcv();
            }
            return m3291aC(f5423a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
