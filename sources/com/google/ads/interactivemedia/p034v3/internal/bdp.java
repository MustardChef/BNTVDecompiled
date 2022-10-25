package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdp */
/* loaded from: classes2.dex */
public final class bdp extends bnd implements bok {

    /* renamed from: a */
    private static final bdp f5489a;

    /* renamed from: e */
    private bed f5490e;

    static {
        bdp bdpVar = new bdp();
        f5489a = bdpVar;
        bnd.m3290aD(bdp.class, bdpVar);
    }

    private bdp() {
    }

    /* renamed from: a */
    public static /* synthetic */ bdp m4028a() {
        return f5489a;
    }

    /* renamed from: b */
    public static bdp m4027b() {
        return f5489a;
    }

    /* renamed from: d */
    public static /* synthetic */ void m4025d(bdp bdpVar, bed bedVar) {
        bedVar.getClass();
        bdpVar.f5490e = bedVar;
    }

    /* renamed from: e */
    public static bep m4024e() {
        return (bep) f5489a.m3283at();
    }

    /* renamed from: c */
    public final bed m4026c() {
        bed bedVar = this.f5490e;
        return bedVar == null ? bed.m3936b() : bedVar;
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
                        return f5489a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
                }
                return new bdp();
            }
            return m3291aC(f5489a, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"e"});
        }
        return (byte) 1;
    }
}
