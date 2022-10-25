package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcw */
/* loaded from: classes2.dex */
public final class bcw extends bnd implements bok {

    /* renamed from: a */
    private static final bcw f5427a;

    /* renamed from: e */
    private int f5428e;

    /* renamed from: f */
    private bcx f5429f;

    static {
        bcw bcwVar = new bcw();
        f5427a = bcwVar;
        bnd.m3290aD(bcw.class, bcwVar);
    }

    private bcw() {
    }

    /* renamed from: c */
    public static bcw m4148c(bls blsVar, bmr bmrVar) throws bnm {
        return (bcw) bnd.m3280aw(f5427a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4146e(bcw bcwVar, bcx bcxVar) {
        bcxVar.getClass();
        bcwVar.f5429f = bcxVar;
    }

    /* renamed from: g */
    public static bep m4144g() {
        return (bep) f5427a.m3283at();
    }

    /* renamed from: a */
    public final int m4150a() {
        return this.f5428e;
    }

    /* renamed from: d */
    public final bcx m4147d() {
        bcx bcxVar = this.f5429f;
        return bcxVar == null ? bcx.m4141c() : bcxVar;
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
                        return f5427a;
                    }
                    return new bep((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new bcw();
            }
            return m3291aC(f5427a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
