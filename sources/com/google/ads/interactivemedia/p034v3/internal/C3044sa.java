package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sa */
/* loaded from: classes2.dex */
public final class C3044sa implements InterfaceC3077tg, InterfaceC2916nh {

    /* renamed from: a */
    final /* synthetic */ AbstractC3046sc f8807a;

    /* renamed from: b */
    private final Object f8808b;

    /* renamed from: c */
    private C3076tf f8809c;

    /* renamed from: d */
    private C2915ng f8810d;

    public C3044sa(AbstractC3046sc abstractC3046sc, Object obj) {
        this.f8807a = abstractC3046sc;
        this.f8809c = abstractC3046sc.m1182w(null);
        this.f8810d = abstractC3046sc.m1184u(null);
        this.f8808b = obj;
    }

    /* renamed from: m */
    private final boolean m1166m(int i, C3067sx c3067sx) {
        C3067sx c3067sx2;
        if (c3067sx != null) {
            c3067sx2 = this.f8807a.mo1110c(this.f8808b, c3067sx);
            if (c3067sx2 == null) {
                return false;
            }
        } else {
            c3067sx2 = null;
        }
        int mo1138b = this.f8807a.mo1138b(this.f8808b, i);
        C3076tf c3076tf = this.f8809c;
        if (c3076tf.f8902a != mo1138b || !C2628cq.m2563T(c3076tf.f8903b, c3067sx2)) {
            this.f8809c = this.f8807a.m1185L(mo1138b, c3067sx2);
        }
        C2915ng c2915ng = this.f8810d;
        if (c2915ng.f8182a == mo1138b && C2628cq.m2563T(c2915ng.f8183b, c3067sx2)) {
            return true;
        }
        this.f8810d = this.f8807a.m1183v(mo1138b, c3067sx2);
        return true;
    }

    /* renamed from: n */
    private static final C3064su m1165n(C3064su c3064su) {
        return c3064su;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: ag */
    public final void mo1070ag(int i, C3067sx c3067sx, C3064su c3064su) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1088c(m1165n(c3064su));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: aq */
    public final void mo1069aq(int i, C3067sx c3067sx, C3064su c3064su) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1078m(m1165n(c3064su));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: at */
    public final /* synthetic */ void mo1172at() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: b */
    public final void mo1171b(int i, C3067sx c3067sx) {
        if (m1166m(i, c3067sx)) {
            this.f8810d.m1594c();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: c */
    public final void mo1170c(int i, C3067sx c3067sx) {
        if (m1166m(i, c3067sx)) {
            this.f8810d.m1593d();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: d */
    public final void mo1169d(int i, C3067sx c3067sx, int i2) {
        if (m1166m(i, c3067sx)) {
            this.f8810d.m1592e(i2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: e */
    public final void mo1168e(int i, C3067sx c3067sx, Exception exc) {
        if (m1166m(i, c3067sx)) {
            this.f8810d.m1591f(exc);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: f */
    public final void mo1167f(int i, C3067sx c3067sx) {
        if (m1166m(i, c3067sx)) {
            this.f8810d.m1590g();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: g */
    public final void mo1068g(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1086e(c3059sp, m1165n(c3064su));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: h */
    public final void mo1067h(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1084g(c3059sp, m1165n(c3064su));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: i */
    public final void mo1066i(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su, IOException iOException, boolean z) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1082i(c3059sp, m1165n(c3064su), iOException, z);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: j */
    public final void mo1065j(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m1166m(i, c3067sx)) {
            this.f8809c.m1080k(c3059sp, m1165n(c3064su));
        }
    }
}
