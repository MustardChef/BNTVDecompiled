package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.oy */
/* loaded from: classes2.dex */
final class C2960oy implements InterfaceC3098ua {

    /* renamed from: a */
    private final int f8351a;

    /* renamed from: b */
    private final C2967pe f8352b;

    /* renamed from: c */
    private int f8353c = -1;

    public C2960oy(C2967pe c2967pe, int i) {
        this.f8352b = c2967pe;
        this.f8351a = i;
    }

    /* renamed from: f */
    private final boolean m1428f() {
        int i = this.f8353c;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        int i2 = this.f8353c;
        if (i2 == -3) {
            c2669ed.m2467a(4);
            return -4;
        } else if (m1428f()) {
            return this.f8352b.m1398e(i2, c2717fy, c2669ed, i);
        } else {
            return -3;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        if (m1428f()) {
            return this.f8352b.m1397f(this.f8353c, j);
        }
        return 0;
    }

    /* renamed from: c */
    public final void m1430c() {
        C2616ce.m2687f(this.f8353c == -1);
        this.f8353c = this.f8352b.m1399d(this.f8351a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() throws IOException {
        int i = this.f8353c;
        if (i == -2) {
            throw new C2971pi(this.f8352b.m1396g().m4121b(this.f8351a).m4193b(0).f8372l);
        }
        if (i == -1) {
            this.f8352b.m1392n();
        } else if (i != -3) {
            this.f8352b.m1391q(i);
        }
    }

    /* renamed from: e */
    public final void m1429e() {
        if (this.f8353c != -1) {
            this.f8352b.m1417A(this.f8351a);
            this.f8353c = -1;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        int i = this.f8353c;
        return i == -3 || (m1428f() && this.f8352b.m1416B(i));
    }
}
