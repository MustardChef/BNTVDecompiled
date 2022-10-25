package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brc */
/* loaded from: classes2.dex */
public final class brc extends bnd implements bok {

    /* renamed from: a */
    private static final brc f6870a;

    /* renamed from: e */
    private int f6871e;

    /* renamed from: h */
    private byte f6874h = 2;

    /* renamed from: f */
    private String f6872f = "";

    /* renamed from: g */
    private String f6873g = "";

    static {
        brc brcVar = new brc();
        f6870a = brcVar;
        bnd.m3290aD(brc.class, brcVar);
    }

    private brc() {
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
                            return f6870a;
                        }
                        this.f6874h = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new brb(null);
                }
                return new brc();
            }
            return m3291aC(f6870a, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔈ\u0001", new Object[]{"e", "f", "g"});
        }
        return Byte.valueOf(this.f6874h);
    }
}
