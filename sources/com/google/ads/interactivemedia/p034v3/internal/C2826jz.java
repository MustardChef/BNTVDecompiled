package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jz */
/* loaded from: classes2.dex */
public final class C2826jz implements InterfaceC2805je {

    /* renamed from: a */
    final /* synthetic */ C2828ka f7779a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2826jz(C2828ka c2828ka) {
        this.f7779a = c2828ka;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2805je
    /* renamed from: a */
    public final void mo1842a(Exception exc) {
        C2801ja c2801ja;
        C2613cb.m2698a("MediaCodecAudioRenderer", "Audio sink error", exc);
        c2801ja = this.f7779a.f7786c;
        c2801ja.m1972b(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2805je
    /* renamed from: b */
    public final void mo1841b() {
        InterfaceC2736gq interfaceC2736gq;
        InterfaceC2736gq interfaceC2736gq2;
        C2828ka c2828ka = this.f7779a;
        interfaceC2736gq = c2828ka.f7795l;
        if (interfaceC2736gq != null) {
            interfaceC2736gq2 = c2828ka.f7795l;
            interfaceC2736gq2.mo2187b();
        }
    }
}
