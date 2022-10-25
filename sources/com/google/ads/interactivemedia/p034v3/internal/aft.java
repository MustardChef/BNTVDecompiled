package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aft */
/* loaded from: classes2.dex */
public final class aft extends bnd implements bok {

    /* renamed from: a */
    private static final aft f3891a;

    /* renamed from: e */
    private int f3892e;

    /* renamed from: f */
    private bls f3893f = bls.f6015b;

    /* renamed from: g */
    private bls f3894g = bls.f6015b;

    static {
        aft aftVar = new aft();
        f3891a = aftVar;
        bnd.m3290aD(aft.class, aftVar);
    }

    private aft() {
    }

    /* renamed from: b */
    public static /* synthetic */ void m5530b(aft aftVar, bls blsVar) {
        aftVar.f3892e |= 1;
        aftVar.f3893f = blsVar;
    }

    /* renamed from: c */
    public static /* synthetic */ void m5529c(aft aftVar, bls blsVar) {
        aftVar.f3892e |= 2;
        aftVar.f3894g = blsVar;
    }

    /* renamed from: d */
    public static aga m5528d() {
        return (aga) f3891a.m3283at();
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
                        return f3891a;
                    }
                    return new aga((byte[]) null, (byte[]) null, (byte[]) null);
                }
                return new aft();
            }
            return m3291aC(f3891a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
