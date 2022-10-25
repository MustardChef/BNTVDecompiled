package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.act */
/* loaded from: classes2.dex */
public final class act implements InterfaceC3229yx {

    /* renamed from: a */
    private final C2962p f3271a;

    /* renamed from: c */
    private InterfaceC3253zu f3273c;

    /* renamed from: e */
    private int f3275e;

    /* renamed from: f */
    private long f3276f;

    /* renamed from: g */
    private int f3277g;

    /* renamed from: h */
    private int f3278h;

    /* renamed from: b */
    private final C2621cj f3272b = new C2621cj(9);

    /* renamed from: d */
    private int f3274d = 0;

    public act(C2962p c2962p) {
        this.f3271a = c2962p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        this.f3272b.m2648B(8);
        interfaceC3230yy.mo496f(this.f3272b.m2642H(), 0, 8);
        return this.f3272b.m2637e() == 1380139777;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        C2616ce.m2688e(this.f3273c);
        while (true) {
            int i = this.f3274d;
            if (i == 0) {
                this.f3272b.m2648B(8);
                if (!interfaceC3230yy.mo491l(this.f3272b.m2642H(), 0, 8, true)) {
                    return -1;
                }
                if (this.f3272b.m2637e() == 1380139777) {
                    this.f3275e = this.f3272b.m2633i();
                    this.f3274d = 1;
                } else {
                    throw new IOException("Input not RawCC");
                }
            } else if (i != 1) {
                while (this.f3277g > 0) {
                    this.f3272b.m2648B(3);
                    interfaceC3230yy.mo495g(this.f3272b.m2642H(), 0, 3);
                    this.f3273c.mo442e(this.f3272b, 3);
                    this.f3278h += 3;
                    this.f3277g--;
                }
                int i2 = this.f3278h;
                if (i2 > 0) {
                    this.f3273c.mo441f(this.f3276f, 1, i2, 0, null);
                }
                this.f3274d = 1;
                return 0;
            } else {
                int i3 = this.f3275e;
                if (i3 == 0) {
                    this.f3272b.m2648B(5);
                    if (!interfaceC3230yy.mo491l(this.f3272b.m2642H(), 0, 5, true)) {
                        break;
                    }
                    this.f3276f = (this.f3272b.m2626p() * 1000) / 45;
                    this.f3277g = this.f3272b.m2633i();
                    this.f3278h = 0;
                    this.f3274d = 2;
                } else if (i3 == 1) {
                    this.f3272b.m2648B(9);
                    if (!interfaceC3230yy.mo491l(this.f3272b.m2642H(), 0, 9, true)) {
                        break;
                    }
                    this.f3276f = this.f3272b.m2627o();
                    this.f3277g = this.f3272b.m2633i();
                    this.f3278h = 0;
                    this.f3274d = 2;
                } else {
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Unsupported version number: ");
                    sb.append(i3);
                    throw C2555ao.m4866a(sb.toString(), null);
                }
            }
        }
        this.f3274d = 0;
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        interfaceC3233za.mo487w(new C3249zq(C3282C.TIME_UNSET));
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(0, 3);
        this.f3273c = mo489be;
        mo489be.mo443b(this.f3271a);
        interfaceC3233za.mo488m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3274d = 0;
    }
}
