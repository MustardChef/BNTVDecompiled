package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.um */
/* loaded from: classes2.dex */
final class C3110um implements InterfaceC3253zu {

    /* renamed from: a */
    public C2962p f9077a;

    /* renamed from: b */
    private final int f9078b;

    /* renamed from: c */
    private final int f9079c;

    /* renamed from: d */
    private final C2962p f9080d;

    /* renamed from: e */
    private final C3228yw f9081e = new C3228yw();

    /* renamed from: f */
    private InterfaceC3253zu f9082f;

    /* renamed from: g */
    private long f9083g;

    public C3110um(int i, int i2, C2962p c2962p) {
        this.f9078b = i;
        this.f9079c = i2;
        this.f9080d = c2962p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: a */
    public final /* synthetic */ int mo444a(InterfaceC2746h interfaceC2746h, int i, boolean z) {
        return C2539ab.m5959e(this, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: b */
    public final void mo443b(C2962p c2962p) {
        C2962p c2962p2 = this.f9080d;
        if (c2962p2 != null) {
            c2962p = c2962p.m1424d(c2962p2);
        }
        this.f9077a = c2962p;
        InterfaceC3253zu interfaceC3253zu = this.f9082f;
        int i = C2628cq.f6961a;
        interfaceC3253zu.mo443b(this.f9077a);
    }

    /* renamed from: c */
    public final void m903c(C3108uk c3108uk, long j) {
        if (c3108uk == null) {
            this.f9082f = this.f9081e;
            return;
        }
        this.f9083g = j;
        InterfaceC3253zu m904c = c3108uk.m904c(this.f9079c);
        this.f9082f = m904c;
        C2962p c2962p = this.f9077a;
        if (c2962p != null) {
            m904c.mo443b(c2962p);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: e */
    public final /* synthetic */ void mo442e(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this, c2621cj, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: f */
    public final void mo441f(long j, int i, int i2, int i3, C3252zt c3252zt) {
        long j2 = this.f9083g;
        if (j2 != C3282C.TIME_UNSET && j >= j2) {
            this.f9082f = this.f9081e;
        }
        InterfaceC3253zu interfaceC3253zu = this.f9082f;
        int i4 = C2628cq.f6961a;
        interfaceC3253zu.mo441f(j, i, i2, i3, c3252zt);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: h */
    public final int mo440h(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        InterfaceC3253zu interfaceC3253zu = this.f9082f;
        int i2 = C2628cq.f6961a;
        return interfaceC3253zu.mo444a(interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: i */
    public final void mo439i(C2621cj c2621cj, int i) {
        InterfaceC3253zu interfaceC3253zu = this.f9082f;
        int i2 = C2628cq.f6961a;
        interfaceC3253zu.mo442e(c2621cj, i);
    }
}
