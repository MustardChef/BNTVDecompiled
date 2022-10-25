package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.fp */
/* loaded from: classes2.dex */
public final class C2708fp implements InterfaceC2736gq {

    /* renamed from: a */
    final /* synthetic */ C2715fw f7265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2708fp(C2715fw c2715fw) {
        this.f7265a = c2715fw;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2736gq
    /* renamed from: a */
    public final void mo2188a(long j) {
        if (j >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.f7265a.f7297D = true;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2736gq
    /* renamed from: b */
    public final void mo2187b() {
        InterfaceC2605bu interfaceC2605bu;
        interfaceC2605bu = this.f7265a.f7314g;
        interfaceC2605bu.mo2602h(2);
    }
}
