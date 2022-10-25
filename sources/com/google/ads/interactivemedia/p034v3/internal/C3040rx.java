package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rx */
/* loaded from: classes2.dex */
final class C3040rx implements InterfaceC3098ua {

    /* renamed from: a */
    public final InterfaceC3098ua f8788a;

    /* renamed from: b */
    final /* synthetic */ C3041ry f8789b;

    /* renamed from: c */
    private boolean f8790c;

    public C3040rx(C3041ry c3041ry, InterfaceC3098ua interfaceC3098ua) {
        this.f8789b = c3041ry;
        this.f8788a = interfaceC3098ua;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        if (this.f8789b.m1179j()) {
            return -3;
        }
        if (this.f8790c) {
            c2669ed.m2466c(4);
            return -4;
        }
        int mo890a = this.f8788a.mo890a(c2717fy, c2669ed, i);
        if (mo890a == -5) {
            C2962p c2962p = c2717fy.f7335b;
            C2616ce.m2689d(c2962p);
            int i2 = c2962p.f8356B;
            if (i2 != 0 || c2962p.f8357C != 0) {
                int i3 = this.f8789b.f8792b != Long.MIN_VALUE ? 0 : c2962p.f8357C;
                C2935o m1426b = c2962p.m1426b();
                m1426b.m1550N(i2);
                m1426b.m1549O(i3);
                c2717fy.f7335b = m1426b.m1506v();
            }
            return -5;
        }
        C3041ry c3041ry = this.f8789b;
        long j = c3041ry.f8792b;
        if (j == Long.MIN_VALUE || ((mo890a != -4 || c2669ed.f7094d < j) && !(mo890a == -3 && c3041ry.mo888bg() == Long.MIN_VALUE && !c2669ed.f7093c))) {
            return mo890a;
        }
        c2669ed.mo1278b();
        c2669ed.m2466c(4);
        this.f8790c = true;
        return -4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        if (this.f8789b.m1179j()) {
            return -3;
        }
        return this.f8788a.mo889b(j);
    }

    /* renamed from: c */
    public final void m1180c() {
        this.f8790c = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() throws IOException {
        this.f8788a.mo886d();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        return !this.f8789b.m1179j() && this.f8788a.mo883g();
    }
}
