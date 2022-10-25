package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adr */
/* loaded from: classes2.dex */
public final class adr implements adg {

    /* renamed from: b */
    private InterfaceC3253zu f3495b;

    /* renamed from: c */
    private boolean f3496c;

    /* renamed from: e */
    private int f3498e;

    /* renamed from: f */
    private int f3499f;

    /* renamed from: a */
    private final C2621cj f3494a = new C2621cj(10);

    /* renamed from: d */
    private long f3497d = C3282C.TIME_UNSET;

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    public final void mo5771a(C2621cj c2621cj) {
        C2616ce.m2688e(this.f3495b);
        if (this.f3496c) {
            int m2641a = c2621cj.m2641a();
            int i = this.f3499f;
            if (i < 10) {
                int min = Math.min(m2641a, 10 - i);
                System.arraycopy(c2621cj.m2642H(), c2621cj.m2639c(), this.f3494a.m2642H(), this.f3499f, min);
                if (this.f3499f + min == 10) {
                    this.f3494a.m2644F(0);
                    if (this.f3494a.m2633i() != 73 || this.f3494a.m2633i() != 68 || this.f3494a.m2633i() != 51) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f3496c = false;
                        return;
                    }
                    this.f3494a.m2643G(3);
                    this.f3498e = this.f3494a.m2634h() + 10;
                }
            }
            int min2 = Math.min(m2641a, this.f3498e - this.f3499f);
            this.f3495b.mo442e(c2621cj, min2);
            this.f3499f += min2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 5);
        this.f3495b = mo489be;
        C2935o c2935o = new C2935o();
        c2935o.m1545S(aejVar.m5730b());
        c2935o.m1532ae(MimeTypes.APPLICATION_ID3);
        mo489be.mo443b(c2935o.m1506v());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
        int i;
        C2616ce.m2688e(this.f3495b);
        if (this.f3496c && (i = this.f3498e) != 0 && this.f3499f == i) {
            long j = this.f3497d;
            if (j != C3282C.TIME_UNSET) {
                this.f3495b.mo441f(j, 1, i, 0, null);
            }
            this.f3496c = false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f3496c = true;
        if (j != C3282C.TIME_UNSET) {
            this.f3497d = j;
        }
        this.f3498e = 0;
        this.f3499f = 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3496c = false;
        this.f3497d = C3282C.TIME_UNSET;
    }
}
