package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.beb */
/* loaded from: classes2.dex */
public final class beb extends bnd implements bok {

    /* renamed from: a */
    private static final beb f5543a;

    /* renamed from: e */
    private String f5544e = "";

    /* renamed from: f */
    private bls f5545f = bls.f6015b;

    /* renamed from: g */
    private int f5546g;

    static {
        beb bebVar = new beb();
        f5543a = bebVar;
        bnd.m3290aD(beb.class, bebVar);
    }

    private beb() {
    }

    /* renamed from: b */
    public static beb m3947b() {
        return f5543a;
    }

    /* renamed from: j */
    public static bep m3940j() {
        return (bep) f5543a.m3283at();
    }

    /* renamed from: c */
    public final bls m3946c() {
        return this.f5545f;
    }

    /* renamed from: d */
    public final String m3945d() {
        return this.f5544e;
    }

    /* renamed from: g */
    public final int m3942g() {
        int m3949b = bea.m3949b(this.f5546g);
        return m3949b == 0 ? bea.f5541f : m3949b;
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
                        return f5543a;
                    }
                    return new bep((byte[]) null, (short[][]) null);
                }
                return new beb();
            }
            return m3291aC(f5543a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
