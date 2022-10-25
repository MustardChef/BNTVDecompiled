package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmg */
/* loaded from: classes2.dex */
public final class bmg extends bnb implements bok {

    /* renamed from: e */
    private static final bmg f6084e;

    /* renamed from: f */
    private int f6085f;

    /* renamed from: g */
    private int f6086g;

    /* renamed from: h */
    private boolean f6087h;

    /* renamed from: i */
    private int f6088i;

    /* renamed from: j */
    private boolean f6089j;

    /* renamed from: k */
    private boolean f6090k;

    /* renamed from: l */
    private boolean f6091l;

    /* renamed from: n */
    private boolean f6093n;

    /* renamed from: p */
    private boolean f6095p;

    /* renamed from: r */
    private byte f6097r = 2;

    /* renamed from: m */
    private bnj f6092m = bor.m3116e();

    /* renamed from: o */
    private boolean f6094o = true;

    /* renamed from: q */
    private bnj f6096q = bor.m3116e();

    static {
        bmg bmgVar = new bmg();
        f6084e = bmgVar;
        bnd.m3290aD(bmg.class, bmgVar);
    }

    private bmg() {
    }

    /* renamed from: e */
    public static bmg m3355e() {
        return f6084e;
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
                            return f6084e;
                        }
                        this.f6097r = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new bmh((byte[]) null, (byte[]) null);
                }
                return new bmg();
            }
            return m3291aC(f6084e, "\u0001\u000b\u0000\u0001\u0001ϧ\u000b\u0000\u0002\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0005\u000b\u001b\fဇ\u0006\rဇ\u0007\u000eဇ\bϧЛ", new Object[]{"f", "g", bmc.m3361a(), "h", "k", "j", "i", bme.m3359a(), "l", "m", bmf.class, "n", "o", TtmlNode.TAG_P, "q", bmn.class});
        }
        return Byte.valueOf(this.f6097r);
    }
}
