package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdk */
/* loaded from: classes2.dex */
public final class bdk extends bnd implements bok {

    /* renamed from: a */
    private static final bdk f5473a;

    /* renamed from: e */
    private int f5474e;

    /* renamed from: f */
    private bls f5475f = bls.f6015b;

    static {
        bdk bdkVar = new bdk();
        f5473a = bdkVar;
        bnd.m3290aD(bdk.class, bdkVar);
    }

    private bdk() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdk m4051b() {
        return f5473a;
    }

    /* renamed from: c */
    public static bdk m4050c(bls blsVar, bmr bmrVar) throws bnm {
        return (bdk) bnd.m3280aw(f5473a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4048e(bdk bdkVar, bls blsVar) {
        bdkVar.f5475f = blsVar;
    }

    /* renamed from: f */
    public static /* synthetic */ void m4047f(bdk bdkVar) {
        bdkVar.f5474e = 0;
    }

    /* renamed from: g */
    public static bep m4046g() {
        return (bep) f5473a.m3283at();
    }

    /* renamed from: a */
    public final int m4052a() {
        return this.f5474e;
    }

    /* renamed from: d */
    public final bls m4049d() {
        return this.f5475f;
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
                        return f5473a;
                    }
                    return new bep((byte[]) null, (boolean[][]) null);
                }
                return new bdk();
            }
            return m3291aC(f5473a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
