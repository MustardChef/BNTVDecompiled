package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmk */
/* loaded from: classes2.dex */
public final class bmk extends bnb implements bok {

    /* renamed from: e */
    private static final bmk f6141e;

    /* renamed from: f */
    private int f6142f;

    /* renamed from: g */
    private boolean f6143g;

    /* renamed from: h */
    private boolean f6144h;

    /* renamed from: i */
    private boolean f6145i;

    /* renamed from: j */
    private boolean f6146j;

    /* renamed from: m */
    private byte f6149m = 2;

    /* renamed from: k */
    private String f6147k = "";

    /* renamed from: l */
    private bnj f6148l = bor.m3116e();

    static {
        bmk bmkVar = new bmk();
        f6141e = bmkVar;
        bnd.m3290aD(bmk.class, bmkVar);
    }

    private bmk() {
    }

    /* renamed from: e */
    public static bmk m3349e() {
        return f6141e;
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
                            return f6141e;
                        }
                        this.f6149m = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new bmh((byte[]) null, (char[]) null);
                }
                return new bmk();
            }
            return m3291aC(f6141e, "\u0001\u0006\u0000\u0001\u0001ϧ\u0006\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004ϧЛ", new Object[]{"f", "g", "h", "i", "j", "k", "l", bmn.class});
        }
        return Byte.valueOf(this.f6149m);
    }
}
