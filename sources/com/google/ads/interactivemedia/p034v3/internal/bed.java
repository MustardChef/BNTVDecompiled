package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bed */
/* loaded from: classes2.dex */
public final class bed extends bnd implements bok {

    /* renamed from: a */
    private static final bed f5553a;

    /* renamed from: e */
    private String f5554e = "";

    /* renamed from: f */
    private bls f5555f = bls.f6015b;

    /* renamed from: g */
    private int f5556g;

    static {
        bed bedVar = new bed();
        f5553a = bedVar;
        bnd.m3290aD(bed.class, bedVar);
    }

    private bed() {
    }

    /* renamed from: a */
    public static /* synthetic */ bed m3937a() {
        return f5553a;
    }

    /* renamed from: b */
    public static bed m3936b() {
        return f5553a;
    }

    /* renamed from: e */
    public static /* synthetic */ void m3933e(bed bedVar, String str) {
        str.getClass();
        bedVar.f5554e = str;
    }

    /* renamed from: f */
    public static /* synthetic */ void m3932f(bed bedVar, bls blsVar) {
        bedVar.f5555f = blsVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m3930h(bed bedVar, int i) {
        bedVar.f5556g = ben.m3876a(i);
    }

    /* renamed from: j */
    public static bep m3929j() {
        return (bep) f5553a.m3283at();
    }

    /* renamed from: c */
    public final bls m3935c() {
        return this.f5555f;
    }

    /* renamed from: d */
    public final String m3934d() {
        return this.f5554e;
    }

    /* renamed from: g */
    public final int m3931g() {
        int m3875b = ben.m3875b(this.f5556g);
        return m3875b == 0 ? ben.f5595f : m3875b;
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
                        return f5553a;
                    }
                    return new bep((byte[]) null, (char[][]) null);
                }
                return new bed();
            }
            return m3291aC(f5553a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
