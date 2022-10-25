package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdc */
/* loaded from: classes2.dex */
public final class bdc extends bnd implements bok {

    /* renamed from: a */
    private static final bdc f5450a;

    /* renamed from: e */
    private int f5451e;

    static {
        bdc bdcVar = new bdc();
        f5450a = bdcVar;
        bnd.m3290aD(bdc.class, bdcVar);
    }

    private bdc() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdc m4101b() {
        return f5450a;
    }

    /* renamed from: c */
    public static bdc m4100c() {
        return f5450a;
    }

    /* renamed from: d */
    public static /* synthetic */ void m4099d(bdc bdcVar) {
        bdcVar.f5451e = 16;
    }

    /* renamed from: e */
    public static bep m4098e() {
        return (bep) f5450a.m3283at();
    }

    /* renamed from: a */
    public final int m4102a() {
        return this.f5451e;
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
                        return f5450a;
                    }
                    return new bep((byte[]) null, (int[]) null, (byte[]) null);
                }
                return new bdc();
            }
            return m3291aC(f5450a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"e"});
        }
        return (byte) 1;
    }
}
