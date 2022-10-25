package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdf */
/* loaded from: classes2.dex */
public final class bdf extends bnd implements bok {

    /* renamed from: a */
    private static final bdf f5459a;

    /* renamed from: e */
    private int f5460e;

    static {
        bdf bdfVar = new bdf();
        f5459a = bdfVar;
        bnd.m3290aD(bdf.class, bdfVar);
    }

    private bdf() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdf m4080b() {
        return f5459a;
    }

    /* renamed from: c */
    public static bdf m4079c() {
        return f5459a;
    }

    /* renamed from: d */
    public static /* synthetic */ void m4078d(bdf bdfVar) {
        bdfVar.f5460e = 16;
    }

    /* renamed from: e */
    public static bep m4077e() {
        return (bep) f5459a.m3283at();
    }

    /* renamed from: a */
    public final int m4081a() {
        return this.f5460e;
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
                        return f5459a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (char[]) null, (char[]) null);
                }
                return new bdf();
            }
            return m3291aC(f5459a, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"e"});
        }
        return (byte) 1;
    }
}
