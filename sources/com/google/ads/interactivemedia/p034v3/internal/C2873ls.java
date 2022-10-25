package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ls */
/* loaded from: classes2.dex */
public final class C2873ls extends AbstractC2874lt {

    /* renamed from: a */
    private final C2871lq f8054a;

    /* renamed from: f */
    private final C2883mb f8055f;

    public C2873ls(C2962p c2962p, List list, C2879ly c2879ly, List list2) {
        super(c2962p, list, c2879ly, list2);
        Uri.parse(((C2863li) list.get(0)).f8004a);
        long j = c2879ly.f8074b;
        C2871lq c2871lq = j <= 0 ? null : new C2871lq(null, c2879ly.f8073a, j);
        this.f8054a = c2871lq;
        this.f8055f = c2871lq == null ? new C2883mb(new C2871lq(null, 0L, -1L)) : null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: k */
    public final InterfaceC2850kw mo1675k() {
        return this.f8055f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: l */
    public final C2871lq mo1674l() {
        return this.f8054a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: m */
    public final void mo1673m() {
    }
}
