package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdq */
/* loaded from: classes2.dex */
public final class bdq extends bnd implements bok {

    /* renamed from: a */
    private static final bdq f5491a;

    /* renamed from: e */
    private bdr f5492e;

    static {
        bdq bdqVar = new bdq();
        f5491a = bdqVar;
        bnd.m3290aD(bdq.class, bdqVar);
    }

    private bdq() {
    }

    /* renamed from: b */
    public static bdq m4022b(bls blsVar, bmr bmrVar) throws bnm {
        return (bdq) bnd.m3280aw(f5491a, blsVar, bmrVar);
    }

    /* renamed from: d */
    public static /* synthetic */ void m4020d(bdq bdqVar, bdr bdrVar) {
        bdrVar.getClass();
        bdqVar.f5492e = bdrVar;
    }

    /* renamed from: e */
    public static bep m4019e() {
        return (bep) f5491a.m3283at();
    }

    /* renamed from: c */
    public final bdr m4021c() {
        bdr bdrVar = this.f5492e;
        return bdrVar == null ? bdr.m4016c() : bdrVar;
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
                        return f5491a;
                    }
                    return new bep((byte[]) null, (short[]) null, (byte[]) null);
                }
                return new bdq();
            }
            return m3291aC(f5491a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"e"});
        }
        return (byte) 1;
    }
}
