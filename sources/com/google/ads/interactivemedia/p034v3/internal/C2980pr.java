package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pr */
/* loaded from: classes2.dex */
public final class C2980pr implements InterfaceC2995qf {

    /* renamed from: a */
    private final InterfaceC2995qf f8497a;

    /* renamed from: b */
    private final List f8498b;

    public C2980pr(InterfaceC2995qf interfaceC2995qf, List list) {
        this.f8497a = interfaceC2995qf;
        this.f8498b = list;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2995qf
    /* renamed from: a */
    public final InterfaceC3169wr mo1326a() {
        return new C3036rt(this.f8497a.mo1326a(), this.f8498b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2995qf
    /* renamed from: b */
    public final InterfaceC3169wr mo1325b(C2983pu c2983pu, C2990qa c2990qa) {
        return new C3036rt(this.f8497a.mo1325b(c2983pu, c2990qa), this.f8498b);
    }
}
