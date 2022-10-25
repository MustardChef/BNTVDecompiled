package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ConcurrentModificationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wx */
/* loaded from: classes2.dex */
public final class C3175wx implements InterfaceC3160wi {

    /* renamed from: a */
    private final InterfaceC3174ww f9336a;

    public C3175wx(InterfaceC3174ww interfaceC3174ww) {
        this.f9336a = interfaceC3174ww;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        if (!C3177wz.m692h()) {
            this.f9336a.mo706a(new IOException(new ConcurrentModificationException()));
        } else {
            this.f9336a.mo705b();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    public final C3158wg mo703bc(InterfaceC3163wl interfaceC3163wl, long j, long j2, IOException iOException, int i) {
        this.f9336a.mo706a(iOException);
        return C3167wp.f9310b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
    }
}
