package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnc */
/* loaded from: classes2.dex */
public final class bnc implements bmt {

    /* renamed from: a */
    final bng f6254a;

    /* renamed from: b */
    final int f6255b;

    /* renamed from: c */
    final bpz f6256c;

    /* renamed from: d */
    final boolean f6257d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bnc(bng bngVar, int i, bpz bpzVar, boolean z) {
        this.f6254a = bngVar;
        this.f6255b = i;
        this.f6256c = bpzVar;
        this.f6257d = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: a */
    public final int mo3300a() {
        return this.f6255b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: b */
    public final boi mo3299b(boi boiVar, boj bojVar) {
        ((bmz) boiVar).m3306aW((bnd) bojVar);
        return boiVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: c */
    public final bpz mo3298c() {
        return this.f6256c;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f6255b - ((bnc) obj).f6255b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: d */
    public final bqa mo3297d() {
        return this.f6256c.m2858a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: e */
    public final boolean mo3296e() {
        return this.f6257d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: f */
    public final bon mo3295f() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bmt
    /* renamed from: g */
    public final void mo3294g() {
    }
}
