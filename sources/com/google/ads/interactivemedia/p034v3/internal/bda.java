package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bda */
/* loaded from: classes2.dex */
public final class bda extends bnd implements bok {

    /* renamed from: a */
    private static final bda f5443a;

    /* renamed from: e */
    private int f5444e;

    /* renamed from: f */
    private bdc f5445f;

    /* renamed from: g */
    private bls f5446g = bls.f6015b;

    static {
        bda bdaVar = new bda();
        f5443a = bdaVar;
        bnd.m3290aD(bda.class, bdaVar);
    }

    private bda() {
    }

    /* renamed from: b */
    public static /* synthetic */ bda m4119b() {
        return f5443a;
    }

    /* renamed from: c */
    public static bda m4118c() {
        return f5443a;
    }

    /* renamed from: d */
    public static bda m4117d(bls blsVar, bmr bmrVar) throws bnm {
        return (bda) bnd.m3280aw(f5443a, blsVar, bmrVar);
    }

    /* renamed from: g */
    public static /* synthetic */ void m4114g(bda bdaVar, bdc bdcVar) {
        bdcVar.getClass();
        bdaVar.f5445f = bdcVar;
    }

    /* renamed from: h */
    public static /* synthetic */ void m4113h(bda bdaVar, bls blsVar) {
        bdaVar.f5446g = blsVar;
    }

    /* renamed from: j */
    public static /* synthetic */ void m4112j(bda bdaVar) {
        bdaVar.f5444e = 0;
    }

    /* renamed from: k */
    public static bep m4111k() {
        return (bep) f5443a.m3283at();
    }

    /* renamed from: a */
    public final int m4120a() {
        return this.f5444e;
    }

    /* renamed from: e */
    public final bdc m4116e() {
        bdc bdcVar = this.f5445f;
        return bdcVar == null ? bdc.m4100c() : bdcVar;
    }

    /* renamed from: f */
    public final bls m4115f() {
        return this.f5446g;
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
                        return f5443a;
                    }
                    return new bep((byte[]) null, (char[]) null, (char[]) null, (byte[]) null);
                }
                return new bda();
            }
            return m3291aC(f5443a, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"e", "f", "g"});
        }
        return (byte) 1;
    }
}
