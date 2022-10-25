package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdt */
/* loaded from: classes2.dex */
public final class bdt extends bnd implements bok {

    /* renamed from: a */
    private static final bdt f5501a;

    /* renamed from: e */
    private int f5502e;

    /* renamed from: f */
    private bdr f5503f;

    /* renamed from: g */
    private bls f5504g = bls.f6015b;

    /* renamed from: h */
    private bls f5505h = bls.f6015b;

    static {
        bdt bdtVar = new bdt();
        f5501a = bdtVar;
        bnd.m3290aD(bdt.class, bdtVar);
    }

    private bdt() {
    }

    /* renamed from: d */
    public static bdt m3997d() {
        return f5501a;
    }

    /* renamed from: e */
    public static bdt m3996e(bls blsVar, bmr bmrVar) throws bnm {
        return (bdt) bnd.m3280aw(f5501a, blsVar, bmrVar);
    }

    /* renamed from: h */
    public static /* synthetic */ void m3993h(bdt bdtVar, bdr bdrVar) {
        bdrVar.getClass();
        bdtVar.f5503f = bdrVar;
    }

    /* renamed from: m */
    public static bep m3989m() {
        return (bep) f5501a.m3283at();
    }

    /* renamed from: a */
    public final int m4000a() {
        return this.f5502e;
    }

    /* renamed from: b */
    public final bdr m3999b() {
        bdr bdrVar = this.f5503f;
        return bdrVar == null ? bdr.m4016c() : bdrVar;
    }

    /* renamed from: f */
    public final bls m3995f() {
        return this.f5504g;
    }

    /* renamed from: g */
    public final bls m3994g() {
        return this.f5505h;
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
                        return f5501a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (short[]) null);
                }
                return new bdt();
            }
            return m3291aC(f5501a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"e", "f", "g", "h"});
        }
        return (byte) 1;
    }
}
