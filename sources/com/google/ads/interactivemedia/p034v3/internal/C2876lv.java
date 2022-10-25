package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lv */
/* loaded from: classes2.dex */
public final class C2876lv extends AbstractC2875lu {

    /* renamed from: e */
    final List f8067e;

    public C2876lv(C2871lq c2871lq, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
        super(c2871lq, j, j2, j3, j4, list, j5, j6, j7);
        this.f8067e = list2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2875lu
    /* renamed from: c */
    public final long mo1665c(long j) {
        return this.f8067e.size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2875lu
    /* renamed from: g */
    public final C2871lq mo1664g(AbstractC2874lt abstractC2874lt, long j) {
        return (C2871lq) this.f8067e.get((int) (j - this.f8061a));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2875lu
    /* renamed from: h */
    public final boolean mo1666h() {
        return true;
    }
}
