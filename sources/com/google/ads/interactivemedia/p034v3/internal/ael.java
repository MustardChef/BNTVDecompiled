package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ael */
/* loaded from: classes2.dex */
public final class ael {

    /* renamed from: a */
    private final List f3616a;

    /* renamed from: b */
    private final InterfaceC3253zu[] f3617b;

    public ael(List list) {
        this.f3616a = list;
        this.f3617b = new InterfaceC3253zu[list.size()];
    }

    /* renamed from: a */
    public final void m5724a(long j, C2621cj c2621cj) {
        if (c2621cj.m2641a() < 9) {
            return;
        }
        int m2637e = c2621cj.m2637e();
        int m2637e2 = c2621cj.m2637e();
        int m2633i = c2621cj.m2633i();
        if (m2637e == 434 && m2637e2 == 1195456820 && m2633i == 3) {
            C2539ab.m5954j(j, c2621cj, this.f3617b);
        }
    }

    /* renamed from: b */
    public final void m5723b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        for (int i = 0; i < this.f3617b.length; i++) {
            aejVar.m5729c();
            InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 3);
            C2962p c2962p = (C2962p) this.f3616a.get(i);
            String str = c2962p.f8372l;
            boolean z = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z = false;
            }
            String valueOf = String.valueOf(str);
            C2616ce.m2686g(z, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            C2935o c2935o = new C2935o();
            c2935o.m1545S(aejVar.m5730b());
            c2935o.m1532ae(str);
            c2935o.m1530ag(c2962p.f8364d);
            c2935o.m1542V(c2962p.f8363c);
            c2935o.m1558F(c2962p.f8358D);
            c2935o.m1544T(c2962p.f8374n);
            mo489be.mo443b(c2935o.m1506v());
            this.f3617b[i] = mo489be;
        }
    }
}
