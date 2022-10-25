package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bdz */
/* loaded from: classes2.dex */
public final class bdz extends bnd implements bok {

    /* renamed from: a */
    private static final bdz f5533a;

    /* renamed from: e */
    private int f5534e;

    /* renamed from: f */
    private int f5535f;

    static {
        bdz bdzVar = new bdz();
        f5533a = bdzVar;
        bnd.m3290aD(bdz.class, bdzVar);
    }

    private bdz() {
    }

    /* renamed from: b */
    public static /* synthetic */ bdz m3956b() {
        return f5533a;
    }

    /* renamed from: c */
    public static bdz m3955c() {
        return f5533a;
    }

    /* renamed from: d */
    public static /* synthetic */ void m3954d(bdz bdzVar, int i) {
        bdzVar.f5535f = i;
    }

    /* renamed from: f */
    public static /* synthetic */ void m3952f(bdz bdzVar, int i) {
        bdzVar.f5534e = bdw.m3977a(i);
    }

    /* renamed from: g */
    public static bep m3951g() {
        return (bep) f5533a.m3283at();
    }

    /* renamed from: a */
    public final int m3957a() {
        return this.f5535f;
    }

    /* renamed from: e */
    public final int m3953e() {
        int m3976b = bdw.m3976b(this.f5534e);
        return m3976b == 0 ? bdw.f5523g : m3976b;
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
                        return f5533a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (char[]) null, (byte[]) null);
                }
                return new bdz();
            }
            return m3291aC(f5533a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
