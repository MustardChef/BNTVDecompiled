package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bei */
/* loaded from: classes2.dex */
public final class bei extends bnd implements bok {

    /* renamed from: a */
    private static final bei f5576a;

    /* renamed from: e */
    private int f5577e;

    /* renamed from: f */
    private bnj f5578f = m3277az();

    static {
        bei beiVar = new bei();
        f5576a = beiVar;
        bnd.m3290aD(bei.class, beiVar);
    }

    private bei() {
    }

    /* renamed from: a */
    public static /* synthetic */ bei m3905a() {
        return f5576a;
    }

    /* renamed from: b */
    public static /* synthetic */ void m3904b(bei beiVar, int i) {
        beiVar.f5577e = i;
    }

    /* renamed from: c */
    public static /* synthetic */ void m3903c(bei beiVar, beh behVar) {
        behVar.getClass();
        beiVar.m3901e();
        beiVar.f5578f.add(behVar);
    }

    /* renamed from: d */
    public static bep m3902d() {
        return (bep) f5576a.m3283at();
    }

    /* renamed from: e */
    private final void m3901e() {
        bnj bnjVar = this.f5578f;
        if (bnjVar.mo3269c()) {
            return;
        }
        this.f5578f = bnd.m3293aA(bnjVar);
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
                        return f5576a;
                    }
                    return new bep((byte[]) null, (byte[]) null, (char[]) null);
                }
                return new bei();
            }
            return m3291aC(f5576a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"e", "f", beh.class});
        }
        return (byte) 1;
    }
}
