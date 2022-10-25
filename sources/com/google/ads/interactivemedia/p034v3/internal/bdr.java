package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdr */
/* loaded from: classes2.dex */
public final class bdr extends bnd implements bok {

    /* renamed from: a */
    private static final bdr f5493a;

    /* renamed from: e */
    private bdu f5494e;

    /* renamed from: f */
    private bdp f5495f;

    /* renamed from: g */
    private int f5496g;

    static {
        bdr bdrVar = new bdr();
        f5493a = bdrVar;
        bnd.m3290aD(bdr.class, bdrVar);
    }

    private bdr() {
    }

    /* renamed from: c */
    public static bdr m4016c() {
        return f5493a;
    }

    /* renamed from: e */
    public static /* synthetic */ void m4014e(bdr bdrVar, bdu bduVar) {
        bduVar.getClass();
        bdrVar.f5494e = bduVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4013f(bdr bdrVar, bdp bdpVar) {
        bdpVar.getClass();
        bdrVar.f5495f = bdpVar;
    }

    /* renamed from: j */
    public static bep m4010j() {
        return (bep) f5493a.m3283at();
    }

    /* renamed from: a */
    public final bdp m4018a() {
        bdp bdpVar = this.f5495f;
        return bdpVar == null ? bdp.m4027b() : bdpVar;
    }

    /* renamed from: d */
    public final bdu m4015d() {
        bdu bduVar = this.f5494e;
        return bduVar == null ? bdu.m3987b() : bduVar;
    }

    /* renamed from: g */
    public final int m4012g() {
        int m4029b = bdo.m4029b(this.f5496g);
        return m4029b == 0 ? bdo.f5487e : m4029b;
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
                        return f5493a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (byte[]) null, (char[]) null);
                }
                return new bdr();
            }
            return m3291aC(f5493a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
