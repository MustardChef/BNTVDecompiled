package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ri */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3025ri implements InterfaceC3032rp {

    /* renamed from: c */
    private final /* synthetic */ int f8762c;

    /* renamed from: b */
    public static final /* synthetic */ C3025ri f8761b = new C3025ri(1);

    /* renamed from: a */
    public static final /* synthetic */ C3025ri f8760a = new C3025ri(0);

    private /* synthetic */ C3025ri(int i) {
        this.f8762c = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3032rp
    /* renamed from: a */
    public final int mo1213a(Object obj) {
        if (this.f8762c == 0) {
            int i = C3033rq.f8769a;
            return ((C3019rc) obj).f8676a.startsWith("OMX.google") ? 1 : 0;
        }
        int i2 = C3033rq.f8769a;
        String str = ((C3019rc) obj).f8676a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (C2628cq.f6961a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
