package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afz */
/* loaded from: classes2.dex */
public final class afz extends bnd implements bok {

    /* renamed from: a */
    private static final afz f3923a;

    /* renamed from: e */
    private int f3924e;

    /* renamed from: f */
    private String f3925f = "";

    static {
        afz afzVar = new afz();
        f3923a = afzVar;
        bnd.m3290aD(afz.class, afzVar);
    }

    private afz() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m5503b(afz afzVar, String str) {
        str.getClass();
        afzVar.f3924e |= 1;
        afzVar.f3925f = str;
    }

    /* renamed from: c */
    public static aga m5502c() {
        return (aga) f3923a.m3283at();
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
                        return f3923a;
                    }
                    return new aga((byte[]) null, (byte[]) null);
                }
                return new afz();
            }
            return m3291aC(f3923a, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
