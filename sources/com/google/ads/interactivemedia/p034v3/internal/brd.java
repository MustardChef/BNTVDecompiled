package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brd */
/* loaded from: classes2.dex */
public final class brd extends bnd implements bok {

    /* renamed from: a */
    private static final brd f6875a;

    /* renamed from: f */
    private byte f6877f = 2;

    /* renamed from: e */
    private bnj f6876e = m3277az();

    static {
        brd brdVar = new brd();
        f6875a = brdVar;
        bnd.m3290aD(brd.class, brdVar);
    }

    private brd() {
    }

    /* renamed from: e */
    public static brd m2733e() {
        return f6875a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnd
    /* renamed from: i */
    protected final Object mo2732i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return f6875a;
                        }
                        this.f6877f = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new brb(null, null);
                }
                return new brd();
            }
            return m3291aC(f6875a, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"e", brc.class});
        }
        return Byte.valueOf(this.f6877f);
    }
}
