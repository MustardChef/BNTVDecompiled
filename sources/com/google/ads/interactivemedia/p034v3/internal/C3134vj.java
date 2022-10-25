package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vj */
/* loaded from: classes2.dex */
public final class C3134vj implements Comparable {

    /* renamed from: a */
    private final boolean f9190a;

    /* renamed from: b */
    private final boolean f9191b;

    public C3134vj(C2962p c2962p, int i) {
        this.f9190a = 1 == (c2962p.f8364d & 1);
        this.f9191b = C3140vp.m809e(i, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(C3134vj c3134vj) {
        return auo.m4561j().mo4566d(this.f9191b, c3134vj.f9191b).mo4566d(this.f9190a, c3134vj.f9190a).mo4569a();
    }
}
