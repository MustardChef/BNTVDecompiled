package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mz */
/* loaded from: classes2.dex */
public final class C2907mz implements InterfaceC2922nn {

    /* renamed from: a */
    private final Object f8166a = new Object();

    /* renamed from: b */
    private C3178x f8167b;

    /* renamed from: c */
    private InterfaceC2921nm f8168c;

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2922nn
    /* renamed from: a */
    public final InterfaceC2921nm mo1582a(C2543ae c2543ae) {
        InterfaceC2921nm interfaceC2921nm;
        C2616ce.m2689d(c2543ae.f3562b);
        C3178x c3178x = c2543ae.f3562b.f2865c;
        if (c3178x == null || C2628cq.f6961a < 18) {
            return InterfaceC2921nm.f8188b;
        }
        synchronized (this.f8166a) {
            if (!C2628cq.m2563T(c3178x, this.f8167b)) {
                this.f8167b = c3178x;
                C2646dh c2646dh = new C2646dh();
                c2646dh.m2481b(null);
                C2937ob c2937ob = new C2937ob(null, c2646dh);
                axf it = c3178x.f9344c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    c2937ob.m1486a((String) entry.getKey(), (String) entry.getValue());
                }
                C2896mo c2896mo = new C2896mo();
                c2896mo.m1630c(c3178x.f9342a, C2936oa.f8229a);
                c2896mo.m1631b(axn.m4380a(c3178x.f9348g));
                C2906my m1632a = c2896mo.m1632a(c2937ob);
                m1632a.m1605t(c3178x.m687b());
                this.f8168c = m1632a;
            }
            interfaceC2921nm = this.f8168c;
            C2616ce.m2689d(interfaceC2921nm);
        }
        return interfaceC2921nm;
    }
}
