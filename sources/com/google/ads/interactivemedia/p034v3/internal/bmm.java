package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmm */
/* loaded from: classes2.dex */
public final class bmm extends bnd implements bok {

    /* renamed from: a */
    private static final bmm f6150a;

    /* renamed from: e */
    private int f6151e;

    /* renamed from: g */
    private boolean f6153g;

    /* renamed from: h */
    private byte f6154h = 2;

    /* renamed from: f */
    private String f6152f = "";

    static {
        bmm bmmVar = new bmm();
        f6150a = bmmVar;
        bnd.m3290aD(bmm.class, bmmVar);
    }

    private bmm() {
    }

    /* renamed from: c */
    public static /* synthetic */ bmm m3348c() {
        return f6150a;
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
                            return f6150a;
                        }
                        this.f6154h = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new bml((byte[]) null, (char[]) null);
                }
                return new bmm();
            }
            return m3291aC(f6150a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"e", "f", "g"});
        }
        return Byte.valueOf(this.f6154h);
    }
}
