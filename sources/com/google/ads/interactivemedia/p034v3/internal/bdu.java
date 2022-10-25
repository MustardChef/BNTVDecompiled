package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdu */
/* loaded from: classes2.dex */
public final class bdu extends bnd implements bok {

    /* renamed from: a */
    private static final bdu f5506a;

    /* renamed from: e */
    private int f5507e;

    /* renamed from: f */
    private int f5508f;

    /* renamed from: g */
    private bls f5509g = bls.f6015b;

    static {
        bdu bduVar = new bdu();
        f5506a = bduVar;
        bnd.m3290aD(bdu.class, bduVar);
    }

    private bdu() {
    }

    /* renamed from: b */
    public static bdu m3987b() {
        return f5506a;
    }

    /* renamed from: j */
    public static bep m3980j() {
        return (bep) f5506a.m3283at();
    }

    /* renamed from: c */
    public final bls m3986c() {
        return this.f5509g;
    }

    /* renamed from: e */
    public final int m3984e() {
        int m3978b = bdv.m3978b(this.f5507e);
        return m3978b == 0 ? bdv.f5515f : m3978b;
    }

    /* renamed from: f */
    public final int m3983f() {
        int m3976b = bdw.m3976b(this.f5508f);
        return m3976b == 0 ? bdw.f5523g : m3976b;
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
                        return f5506a;
                    }
                    return new bep((byte[]) null, (int[][]) null);
                }
                return new bdu();
            }
            return m3291aC(f5506a, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
