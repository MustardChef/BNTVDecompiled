package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afq */
/* loaded from: classes2.dex */
public final class afq extends bnd implements bok {

    /* renamed from: a */
    private static final afq f3786a;

    /* renamed from: e */
    private int f3787e;

    /* renamed from: f */
    private long f3788f = -1;

    /* renamed from: g */
    private long f3789g = -1;

    /* renamed from: h */
    private long f3790h = -1;

    /* renamed from: i */
    private long f3791i = -1;

    /* renamed from: j */
    private long f3792j = -1;

    /* renamed from: k */
    private long f3793k = -1;

    /* renamed from: l */
    private long f3794l = -1;

    static {
        afq afqVar = new afq();
        f3786a = afqVar;
        bnd.m3290aD(afq.class, afqVar);
    }

    private afq() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m5603b(afq afqVar, long j) {
        afqVar.f3787e |= 4;
        afqVar.f3790h = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m5602c(afq afqVar, long j) {
        afqVar.f3787e |= 8;
        afqVar.f3791i = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m5601d(afq afqVar, long j) {
        afqVar.f3787e |= 16;
        afqVar.f3792j = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ void m5600e(afq afqVar, long j) {
        afqVar.f3787e |= 32;
        afqVar.f3793k = j;
    }

    /* renamed from: f */
    public static aga m5599f() {
        return (aga) f3786a.m3283at();
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
                        return f3786a;
                    }
                    return new aga((byte[]) null, (short[]) null);
                }
                return new afq();
            }
            return m3291aC(f3786a, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006", new Object[]{"e", "f", "g", "h", "i", "j", "k", "l"});
        }
        return (byte) 1;
    }
}
