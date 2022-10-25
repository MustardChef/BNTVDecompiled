package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yw */
/* loaded from: classes2.dex */
public final class C3228yw implements InterfaceC3253zu {

    /* renamed from: a */
    private final byte[] f9544a = new byte[4096];

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: a */
    public final /* synthetic */ int mo444a(InterfaceC2746h interfaceC2746h, int i, boolean z) {
        return C2539ab.m5959e(this, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: b */
    public final void mo443b(C2962p c2962p) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: e */
    public final /* synthetic */ void mo442e(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this, c2621cj, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: f */
    public final void mo441f(long j, int i, int i2, int i3, C3252zt c3252zt) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: h */
    public final int mo440h(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        int mo501a = interfaceC2746h.mo501a(this.f9544a, 0, Math.min(4096, i));
        if (mo501a == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return mo501a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: i */
    public final void mo439i(C2621cj c2621cj, int i) {
        c2621cj.m2643G(i);
    }
}
