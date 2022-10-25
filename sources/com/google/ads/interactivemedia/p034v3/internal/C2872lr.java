package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lr */
/* loaded from: classes2.dex */
public final class C2872lr extends AbstractC2874lt implements InterfaceC2850kw {

    /* renamed from: a */
    final AbstractC2875lu f8053a;

    public C2872lr(C2962p c2962p, List list, AbstractC2875lu abstractC2875lu, List list2) {
        super(c2962p, list, abstractC2875lu, list2);
        this.f8053a = abstractC2875lu;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: a */
    public final long mo1660a(long j, long j2) {
        return this.f8053a.m1671a(j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: b */
    public final long mo1659b(long j, long j2) {
        return this.f8053a.m1669d(j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: c */
    public final long mo1658c(long j, long j2) {
        return this.f8053a.m1670b(j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: d */
    public final long mo1657d() {
        return this.f8053a.f8061a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: e */
    public final long mo1656e(long j, long j2) {
        AbstractC2875lu abstractC2875lu = this.f8053a;
        if (abstractC2875lu.f8063c != null) {
            return C3282C.TIME_UNSET;
        }
        long m1670b = abstractC2875lu.m1670b(j, j2) + abstractC2875lu.m1671a(j, j2);
        return (abstractC2875lu.m1667f(m1670b) + abstractC2875lu.m1669d(m1670b, j)) - abstractC2875lu.f8064d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: f */
    public final long mo1655f(long j) {
        return this.f8053a.mo1665c(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: g */
    public final long mo1654g(long j, long j2) {
        return this.f8053a.m1668e(j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: h */
    public final long mo1653h(long j) {
        return this.f8053a.m1667f(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: i */
    public final C2871lq mo1652i(long j) {
        return this.f8053a.mo1664g(this, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2850kw
    /* renamed from: j */
    public final boolean mo1651j() {
        return this.f8053a.mo1666h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: k */
    public final InterfaceC2850kw mo1675k() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: l */
    public final C2871lq mo1674l() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2874lt
    /* renamed from: m */
    public final void mo1673m() {
    }
}
