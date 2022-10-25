package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.beg */
/* loaded from: classes2.dex */
public final class beg extends bnd implements bok {

    /* renamed from: a */
    private static final beg f5568a;

    /* renamed from: e */
    private int f5569e;

    /* renamed from: f */
    private bnj f5570f = m3277az();

    static {
        beg begVar = new beg();
        f5568a = begVar;
        bnd.m3290aD(beg.class, begVar);
    }

    private beg() {
    }

    /* renamed from: c */
    public static /* synthetic */ beg m3914c() {
        return f5568a;
    }

    /* renamed from: d */
    public static beg m3913d(byte[] bArr, bmr bmrVar) throws bnm {
        return (beg) bnd.m3279ax(f5568a, bArr, bmrVar);
    }

    /* renamed from: a */
    public final int m3916a() {
        return this.f5570f.size();
    }

    /* renamed from: b */
    public final int m3915b() {
        return this.f5569e;
    }

    /* renamed from: e */
    public final List m3912e() {
        return this.f5570f;
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
                        return f5568a;
                    }
                    return new bep((byte[]) null, (char[]) null, (byte[]) null, (byte[]) null);
                }
                return new beg();
            }
            return m3291aC(f5568a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"e", "f", bef.class});
        }
        return (byte) 1;
    }
}
