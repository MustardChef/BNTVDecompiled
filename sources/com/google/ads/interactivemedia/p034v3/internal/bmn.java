package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmn */
/* loaded from: classes2.dex */
public final class bmn extends bnd implements bok {

    /* renamed from: a */
    private static final bmn f6155a;

    /* renamed from: e */
    private int f6156e;

    /* renamed from: h */
    private long f6159h;

    /* renamed from: i */
    private long f6160i;

    /* renamed from: j */
    private double f6161j;

    /* renamed from: m */
    private byte f6164m = 2;

    /* renamed from: f */
    private bnj f6157f = bor.m3116e();

    /* renamed from: g */
    private String f6158g = "";

    /* renamed from: k */
    private bls f6162k = bls.f6015b;

    /* renamed from: l */
    private String f6163l = "";

    static {
        bmn bmnVar = new bmn();
        f6155a = bmnVar;
        bnd.m3290aD(bmn.class, bmnVar);
    }

    private bmn() {
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
                            return f6155a;
                        }
                        this.f6164m = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new bml(null);
                }
                return new bmn();
            }
            return m3291aC(f6155a, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"e", "f", bmm.class, "g", "h", "i", "j", "k", "l"});
        }
        return Byte.valueOf(this.f6164m);
    }
}
