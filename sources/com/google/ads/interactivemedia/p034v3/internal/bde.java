package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bde */
/* loaded from: classes2.dex */
public final class bde extends bnd implements bok {

    /* renamed from: a */
    private static final bde f5456a;

    /* renamed from: e */
    private bdf f5457e;

    /* renamed from: f */
    private int f5458f;

    static {
        bde bdeVar = new bde();
        f5456a = bdeVar;
        bnd.m3290aD(bde.class, bdeVar);
    }

    private bde() {
    }

    /* renamed from: c */
    public static bde m4086c(bls blsVar, bmr bmrVar) throws bnm {
        return (bde) bnd.m3280aw(f5456a, blsVar, bmrVar);
    }

    /* renamed from: e */
    public static /* synthetic */ void m4084e(bde bdeVar, bdf bdfVar) {
        bdfVar.getClass();
        bdeVar.f5457e = bdfVar;
    }

    /* renamed from: g */
    public static bep m4082g() {
        return (bep) f5456a.m3283at();
    }

    /* renamed from: a */
    public final int m4088a() {
        return this.f5458f;
    }

    /* renamed from: d */
    public final bdf m4085d() {
        bdf bdfVar = this.f5457e;
        return bdfVar == null ? bdf.m4079c() : bdfVar;
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
                        return f5456a;
                    }
                    return new bep((byte[]) null, (char[]) null, (byte[]) null, (char[]) null);
                }
                return new bde();
            }
            return m3291aC(f5456a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
