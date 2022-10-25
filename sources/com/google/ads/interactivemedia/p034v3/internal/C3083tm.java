package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tm */
/* loaded from: classes2.dex */
final class C3083tm implements InterfaceC3098ua {

    /* renamed from: a */
    final /* synthetic */ C3086tp f8925a;

    /* renamed from: b */
    private final int f8926b;

    public C3083tm(C3086tp c3086tp, int i) {
        this.f8925a = c3086tp;
        this.f8926b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: a */
    public final int mo890a(C2717fy c2717fy, C2669ed c2669ed, int i) {
        return this.f8925a.m1026g(this.f8926b, c2717fy, c2669ed, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: b */
    public final int mo889b(long j) {
        return this.f8925a.m1023j(this.f8926b, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: d */
    public final void mo886d() throws IOException {
        this.f8925a.m1044F(this.f8926b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3098ua
    /* renamed from: g */
    public final boolean mo883g() {
        return this.f8925a.m1042I(this.f8926b);
    }
}
