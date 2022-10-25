package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ui */
/* loaded from: classes2.dex */
public abstract class AbstractC3106ui extends AbstractC3122uy {

    /* renamed from: a */
    public final long f9067a;

    /* renamed from: b */
    public final long f9068b;

    /* renamed from: c */
    private C3108uk f9069c;

    /* renamed from: d */
    private int[] f9070d;

    public AbstractC3106ui(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, long j, long j2, long j3, long j4, long j5) {
        super(interfaceC2637cz, c2642dd, c2962p, i, j, j2, j5);
        this.f9067a = j3;
        this.f9068b = j4;
    }

    /* renamed from: a */
    public final int m911a(int i) {
        return ((int[]) C2616ce.m2688e(this.f9070d))[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final C3108uk m910c() {
        C3108uk c3108uk = this.f9069c;
        C2616ce.m2688e(c3108uk);
        return c3108uk;
    }

    /* renamed from: d */
    public final void m909d(C3108uk c3108uk) {
        this.f9069c = c3108uk;
        this.f9070d = c3108uk.m905b();
    }
}
