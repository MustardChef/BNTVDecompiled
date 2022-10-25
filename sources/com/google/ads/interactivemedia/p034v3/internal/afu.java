package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afu */
/* loaded from: classes2.dex */
public final class afu extends bnd implements bok {

    /* renamed from: a */
    private static final afu f3895a;

    /* renamed from: e */
    private int f3896e;

    /* renamed from: f */
    private bls f3897f = bls.f6015b;

    /* renamed from: g */
    private bls f3898g = bls.f6015b;

    /* renamed from: h */
    private bls f3899h = bls.f6015b;

    /* renamed from: i */
    private bls f3900i = bls.f6015b;

    static {
        afu afuVar = new afu();
        f3895a = afuVar;
        bnd.m3290aD(afu.class, afuVar);
    }

    private afu() {
    }

    /* renamed from: b */
    public static afu m5526b(byte[] bArr, bmr bmrVar) throws bnm {
        return (afu) bnd.m3279ax(f3895a, bArr, bmrVar);
    }

    /* renamed from: g */
    public static /* synthetic */ void m5521g(afu afuVar, bls blsVar) {
        afuVar.f3896e |= 1;
        afuVar.f3897f = blsVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m5520h(afu afuVar, bls blsVar) {
        afuVar.f3896e |= 2;
        afuVar.f3898g = blsVar;
    }

    /* renamed from: j */
    public static /* synthetic */ void m5519j(afu afuVar, bls blsVar) {
        afuVar.f3896e |= 4;
        afuVar.f3899h = blsVar;
    }

    /* renamed from: k */
    public static /* synthetic */ void m5518k(afu afuVar, bls blsVar) {
        afuVar.f3896e |= 8;
        afuVar.f3900i = blsVar;
    }

    /* renamed from: l */
    public static aga m5517l() {
        return (aga) f3895a.m3283at();
    }

    /* renamed from: c */
    public final bls m5525c() {
        return this.f3897f;
    }

    /* renamed from: d */
    public final bls m5524d() {
        return this.f3898g;
    }

    /* renamed from: e */
    public final bls m5523e() {
        return this.f3900i;
    }

    /* renamed from: f */
    public final bls m5522f() {
        return this.f3899h;
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
                        return f3895a;
                    }
                    return new aga((byte[]) null, (char[]) null);
                }
                return new afu();
            }
            return m3291aC(f3895a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"e", "f", "g", "h", "i"});
        }
        return (byte) 1;
    }
}
