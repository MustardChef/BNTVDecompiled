package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aew */
/* loaded from: classes2.dex */
public final class aew extends bnd implements bok {

    /* renamed from: a */
    private static final aew f3634a;

    /* renamed from: e */
    private int f3635e;

    /* renamed from: f */
    private int f3636f;

    /* renamed from: i */
    private boolean f3639i;

    /* renamed from: g */
    private boolean f3637g = true;

    /* renamed from: h */
    private String f3638h = "unknown_host";

    /* renamed from: j */
    private boolean f3640j = true;

    static {
        aew aewVar = new aew();
        f3634a = aewVar;
        bnd.m3290aD(aew.class, aewVar);
    }

    private aew() {
    }

    /* renamed from: a */
    public static /* synthetic */ aew m5692a() {
        return f3634a;
    }

    /* renamed from: f */
    public static /* synthetic */ void m5687f(aew aewVar) {
        aewVar.f3635e |= 16;
        aewVar.f3640j = false;
    }

    /* renamed from: g */
    public static /* synthetic */ void m5686g(aew aewVar) {
        aewVar.f3635e |= 4;
        aewVar.f3638h = "a.3.25.1";
    }

    /* renamed from: h */
    public static /* synthetic */ void m5685h(aew aewVar) {
        aewVar.f3635e |= 8;
        aewVar.f3639i = false;
    }

    /* renamed from: k */
    public static /* synthetic */ void m5683k(aew aewVar, int i) {
        aewVar.f3636f = aex.m5680b(i);
        aewVar.f3635e |= 1;
    }

    /* renamed from: l */
    public static afc m5682l() {
        return (afc) f3634a.m3283at();
    }

    /* renamed from: b */
    public final String m5691b() {
        return this.f3638h;
    }

    /* renamed from: c */
    public final boolean m5690c() {
        return this.f3639i;
    }

    /* renamed from: d */
    public final boolean m5689d() {
        return this.f3640j;
    }

    /* renamed from: e */
    public final boolean m5688e() {
        return this.f3637g;
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
                        return f3634a;
                    }
                    return new afc(null, null, null);
                }
                return new aew();
            }
            return m3291aC(f3634a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"e", "f", aex.m5681a(), "g", "h", "i", "j"});
        }
        return (byte) 1;
    }

    /* renamed from: j */
    public final int m5684j() {
        int m5679c = aex.m5679c(this.f3636f);
        return m5679c == 0 ? aex.f3641a : m5679c;
    }
}
