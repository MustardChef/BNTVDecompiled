package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agb */
/* loaded from: classes2.dex */
public final class agb extends bnd implements bok {

    /* renamed from: a */
    private static final agb f3944a;

    /* renamed from: e */
    private int f3945e;

    /* renamed from: f */
    private bnj f3946f = m3277az();

    /* renamed from: g */
    private bls f3947g = bls.f6015b;

    /* renamed from: h */
    private int f3948h = 1;

    /* renamed from: i */
    private int f3949i = 1;

    static {
        agb agbVar = new agb();
        f3944a = agbVar;
        bnd.m3290aD(agb.class, agbVar);
    }

    private agb() {
    }

    /* renamed from: a */
    public static aga m5376a() {
        return (aga) f3944a.m3283at();
    }

    /* renamed from: c */
    public static /* synthetic */ void m5374c(agb agbVar, bls blsVar) {
        agbVar.m5371f();
        agbVar.f3946f.add(blsVar);
    }

    /* renamed from: d */
    public static /* synthetic */ void m5373d(agb agbVar, bls blsVar) {
        agbVar.f3945e |= 1;
        agbVar.f3947g = blsVar;
    }

    /* renamed from: e */
    public static /* synthetic */ void m5372e(agb agbVar, int i) {
        agbVar.f3949i = afv.m5515b(i);
        agbVar.f3945e |= 4;
    }

    /* renamed from: f */
    private final void m5371f() {
        bnj bnjVar = this.f3946f;
        if (bnjVar.mo3269c()) {
            return;
        }
        this.f3946f = bnd.m3293aA(bnjVar);
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
                        return f3944a;
                    }
                    return new aga(null);
                }
                return new agb();
            }
            return m3291aC(f3944a, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"e", "f", "g", "h", afx.m5510a(), "i", afv.m5516a()});
        }
        return (byte) 1;
    }
}
