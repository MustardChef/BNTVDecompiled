package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.if */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2779if implements InterfaceC2608bx {

    /* renamed from: a */
    public final /* synthetic */ C2786im f7574a;

    /* renamed from: b */
    public final /* synthetic */ boolean f7575b;

    /* renamed from: c */
    private final /* synthetic */ int f7576c;

    public /* synthetic */ C2779if(C2786im c2786im, boolean z, int i) {
        this.f7576c = i;
        this.f7574a = c2786im;
        this.f7575b = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2608bx
    /* renamed from: a */
    public final void mo2093a(Object obj) {
        int i = this.f7576c;
        if (i == 0) {
            ((InterfaceC2787in) obj).mo2035C();
        } else if (i == 1) {
            InterfaceC2787in interfaceC2787in = (InterfaceC2787in) obj;
            interfaceC2787in.mo2030H();
            interfaceC2787in.mo2036B();
        } else {
            ((InterfaceC2787in) obj).mo2016V();
        }
    }
}
