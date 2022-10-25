package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adf */
/* loaded from: classes2.dex */
public final class adf implements adg {

    /* renamed from: a */
    private final List f3364a;

    /* renamed from: b */
    private final InterfaceC3253zu[] f3365b;

    /* renamed from: c */
    private boolean f3366c;

    /* renamed from: d */
    private int f3367d;

    /* renamed from: e */
    private int f3368e;

    /* renamed from: f */
    private long f3369f = C3282C.TIME_UNSET;

    public adf(List list) {
        this.f3364a = list;
        this.f3365b = new InterfaceC3253zu[list.size()];
    }

    /* renamed from: f */
    private final boolean m5803f(C2621cj c2621cj, int i) {
        if (c2621cj.m2641a() == 0) {
            return false;
        }
        if (c2621cj.m2633i() != i) {
            this.f3366c = false;
        }
        this.f3367d--;
        return this.f3366c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    public final void mo5771a(C2621cj c2621cj) {
        InterfaceC3253zu[] interfaceC3253zuArr;
        if (this.f3366c) {
            if (this.f3367d != 2 || m5803f(c2621cj, 32)) {
                if (this.f3367d != 1 || m5803f(c2621cj, 0)) {
                    int m2639c = c2621cj.m2639c();
                    int m2641a = c2621cj.m2641a();
                    for (InterfaceC3253zu interfaceC3253zu : this.f3365b) {
                        c2621cj.m2644F(m2639c);
                        interfaceC3253zu.mo442e(c2621cj, m2641a);
                    }
                    this.f3368e += m2641a;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        for (int i = 0; i < this.f3365b.length; i++) {
            aeg aegVar = (aeg) this.f3364a.get(i);
            aejVar.m5729c();
            InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 3);
            C2935o c2935o = new C2935o();
            c2935o.m1545S(aejVar.m5730b());
            c2935o.m1532ae(MimeTypes.APPLICATION_DVBSUBS);
            c2935o.m1544T(Collections.singletonList(aegVar.f3606b));
            c2935o.m1542V(aegVar.f3605a);
            mo489be.mo443b(c2935o.m1506v());
            this.f3365b[i] = mo489be;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
        if (this.f3366c) {
            if (this.f3369f != C3282C.TIME_UNSET) {
                for (InterfaceC3253zu interfaceC3253zu : this.f3365b) {
                    interfaceC3253zu.mo441f(this.f3369f, 1, this.f3368e, 0, null);
                }
            }
            this.f3366c = false;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.f3366c = true;
        if (j != C3282C.TIME_UNSET) {
            this.f3369f = j;
        }
        this.f3368e = 0;
        this.f3367d = 2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3366c = false;
        this.f3369f = C3282C.TIME_UNSET;
    }
}
