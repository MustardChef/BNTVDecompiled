package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.beh */
/* loaded from: classes2.dex */
public final class beh extends bnd implements bok {

    /* renamed from: a */
    private static final beh f5571a;

    /* renamed from: e */
    private String f5572e = "";

    /* renamed from: f */
    private int f5573f;

    /* renamed from: g */
    private int f5574g;

    /* renamed from: h */
    private int f5575h;

    static {
        beh behVar = new beh();
        f5571a = behVar;
        bnd.m3290aD(beh.class, behVar);
    }

    private beh() {
    }

    /* renamed from: a */
    public static /* synthetic */ beh m3911a() {
        return f5571a;
    }

    /* renamed from: b */
    public static /* synthetic */ void m3910b(beh behVar, String str) {
        str.getClass();
        behVar.f5572e = str;
    }

    /* renamed from: c */
    public static /* synthetic */ void m3909c(beh behVar, int i) {
        behVar.f5574g = i;
    }

    /* renamed from: d */
    public static /* synthetic */ void m3908d(beh behVar, int i) {
        behVar.f5575h = ben.m3876a(i);
    }

    /* renamed from: e */
    public static /* synthetic */ void m3907e(beh behVar, int i) {
        behVar.f5573f = bec.m3939a(i);
    }

    /* renamed from: f */
    public static bep m3906f() {
        return (bep) f5571a.m3283at();
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
                        return f5571a;
                    }
                    return new bep((byte[]) null, (char[]) null);
                }
                return new beh();
            }
            return m3291aC(f5571a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"e", "f", "g", "h"});
        }
        return (byte) 1;
    }
}
