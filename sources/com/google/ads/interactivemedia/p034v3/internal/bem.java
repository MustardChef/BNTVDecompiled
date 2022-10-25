package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bem */
/* loaded from: classes2.dex */
public final class bem extends bnd implements bok {

    /* renamed from: a */
    private static final bem f5587a;

    /* renamed from: e */
    private String f5588e = "";

    /* renamed from: f */
    private bed f5589f;

    static {
        bem bemVar = new bem();
        f5587a = bemVar;
        bnd.m3290aD(bem.class, bemVar);
    }

    private bem() {
    }

    /* renamed from: b */
    public static /* synthetic */ bem m3881b() {
        return f5587a;
    }

    /* renamed from: c */
    public static bem m3880c() {
        return f5587a;
    }

    /* renamed from: d */
    public static bem m3879d(bls blsVar, bmr bmrVar) throws bnm {
        return (bem) bnd.m3280aw(f5587a, blsVar, bmrVar);
    }

    /* renamed from: a */
    public final bed m3882a() {
        bed bedVar = this.f5589f;
        return bedVar == null ? bed.m3936b() : bedVar;
    }

    /* renamed from: e */
    public final String m3878e() {
        return this.f5588e;
    }

    /* renamed from: f */
    public final boolean m3877f() {
        return this.f5589f != null;
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
                        return f5587a;
                    }
                    return new bep((byte[]) null, (boolean[]) null);
                }
                return new bem();
            }
            return m3291aC(f5587a, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"e", "f"});
        }
        return (byte) 1;
    }
}
