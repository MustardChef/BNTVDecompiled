package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afd */
/* loaded from: classes2.dex */
public final class afd extends bnd implements bok {

    /* renamed from: a */
    private static final afd f3674a;

    /* renamed from: e */
    private int f3675e;

    /* renamed from: f */
    private afe f3676f;

    /* renamed from: g */
    private afg f3677g;

    static {
        afd afdVar = new afd();
        f3674a = afdVar;
        bnd.m3290aD(afd.class, afdVar);
    }

    private afd() {
    }

    /* renamed from: b */
    public static afd m5651b(byte[] bArr, bmr bmrVar) throws bnm {
        return (afd) bnd.m3279ax(f3674a, bArr, bmrVar);
    }

    /* renamed from: c */
    public final afe m5650c() {
        afe afeVar = this.f3676f;
        return afeVar == null ? afe.m5645b() : afeVar;
    }

    /* renamed from: d */
    public final afg m5649d() {
        afg afgVar = this.f3677g;
        return afgVar == null ? afg.m5640b() : afgVar;
    }

    /* renamed from: e */
    public final boolean m5648e() {
        return (this.f3675e & 1) != 0;
    }

    /* renamed from: f */
    public final boolean m5647f() {
        return (this.f3675e & 2) != 0;
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
                        return f3674a;
                    }
                    return new afc(null);
                }
                return new afd();
            }
            return m3291aC(f3674a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
