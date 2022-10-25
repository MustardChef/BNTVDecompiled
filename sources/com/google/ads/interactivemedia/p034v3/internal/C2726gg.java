package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gg */
/* loaded from: classes2.dex */
public final class C2726gg implements InterfaceC3077tg, InterfaceC2916nh {

    /* renamed from: a */
    final /* synthetic */ C2730gk f7382a;

    /* renamed from: b */
    private final C2728gi f7383b;

    /* renamed from: c */
    private C3076tf f7384c;

    /* renamed from: d */
    private C2915ng f7385d;

    public C2726gg(C2730gk c2730gk, C2728gi c2728gi) {
        C3076tf c3076tf;
        C2915ng c2915ng;
        this.f7382a = c2730gk;
        c3076tf = c2730gk.f7398e;
        this.f7384c = c3076tf;
        c2915ng = c2730gk.f7399f;
        this.f7385d = c2915ng;
        this.f7383b = c2728gi;
    }

    /* renamed from: m */
    private final boolean m2239m(int i, C3067sx c3067sx) {
        C3076tf c3076tf;
        C2915ng c2915ng;
        C3067sx c3067sx2 = null;
        if (c3067sx != null) {
            C2728gi c2728gi = this.f7383b;
            int i2 = 0;
            while (true) {
                if (i2 >= c2728gi.f7391c.size()) {
                    break;
                } else if (((C3067sx) c2728gi.f7391c.get(i2)).f4118d == c3067sx.f4118d) {
                    c3067sx2 = c3067sx.m1103c(Pair.create(c2728gi.f7390b, c3067sx.f4115a));
                    break;
                } else {
                    i2++;
                }
            }
            if (c3067sx2 == null) {
                return false;
            }
        }
        int i3 = i + this.f7383b.f7392d;
        C3076tf c3076tf2 = this.f7384c;
        if (c3076tf2.f8902a != i3 || !C2628cq.m2563T(c3076tf2.f8903b, c3067sx2)) {
            c3076tf = this.f7382a.f7398e;
            this.f7384c = c3076tf.m1090a(i3, c3067sx2, 0L);
        }
        C2915ng c2915ng2 = this.f7385d;
        if (c2915ng2.f8182a == i3 && C2628cq.m2563T(c2915ng2.f8183b, c3067sx2)) {
            return true;
        }
        c2915ng = this.f7382a.f7399f;
        this.f7385d = c2915ng.m1596a(i3, c3067sx2);
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: ag */
    public final void mo1070ag(int i, C3067sx c3067sx, C3064su c3064su) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1088c(c3064su);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: aq */
    public final void mo1069aq(int i, C3067sx c3067sx, C3064su c3064su) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1078m(c3064su);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: at */
    public final /* synthetic */ void mo1172at() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: b */
    public final void mo1171b(int i, C3067sx c3067sx) {
        if (m2239m(i, c3067sx)) {
            this.f7385d.m1594c();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: c */
    public final void mo1170c(int i, C3067sx c3067sx) {
        if (m2239m(i, c3067sx)) {
            this.f7385d.m1593d();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: d */
    public final void mo1169d(int i, C3067sx c3067sx, int i2) {
        if (m2239m(i, c3067sx)) {
            this.f7385d.m1592e(i2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: e */
    public final void mo1168e(int i, C3067sx c3067sx, Exception exc) {
        if (m2239m(i, c3067sx)) {
            this.f7385d.m1591f(exc);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2916nh
    /* renamed from: f */
    public final void mo1167f(int i, C3067sx c3067sx) {
        if (m2239m(i, c3067sx)) {
            this.f7385d.m1590g();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: g */
    public final void mo1068g(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1086e(c3059sp, c3064su);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: h */
    public final void mo1067h(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1084g(c3059sp, c3064su);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: i */
    public final void mo1066i(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su, IOException iOException, boolean z) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1082i(c3059sp, c3064su, iOException, z);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3077tg
    /* renamed from: j */
    public final void mo1065j(int i, C3067sx c3067sx, C3059sp c3059sp, C3064su c3064su) {
        if (m2239m(i, c3067sx)) {
            this.f7384c.m1080k(c3059sp, c3064su);
        }
    }
}
