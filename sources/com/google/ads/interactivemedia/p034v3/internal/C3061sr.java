package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sr */
/* loaded from: classes2.dex */
public final class C3061sr extends C3056sm {

    /* renamed from: c */
    public static final Object f8861c = new Object();

    /* renamed from: d */
    private final Object f8862d;

    /* renamed from: e */
    private final Object f8863e;

    private C3061sr(AbstractC2586bb abstractC2586bb, Object obj, Object obj2) {
        super(abstractC2586bb);
        this.f8862d = obj;
        this.f8863e = obj2;
    }

    /* renamed from: s */
    public static C3061sr m1113s(C2543ae c2543ae) {
        return new C3061sr(new C3062ss(c2543ae), C2585ba.f5346a, f8861c);
    }

    /* renamed from: t */
    public static C3061sr m1112t(AbstractC2586bb abstractC2586bb, Object obj, Object obj2) {
        return new C3061sr(abstractC2586bb, obj, obj2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C3056sm, com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: a */
    public final int mo925a(Object obj) {
        Object obj2;
        AbstractC2586bb abstractC2586bb = this.f8846b;
        if (f8861c.equals(obj) && (obj2 = this.f8863e) != null) {
            obj = obj2;
        }
        return abstractC2586bb.mo925a(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C3056sm, com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: d */
    public final C2583az mo922d(int i, C2583az c2583az, boolean z) {
        this.f8846b.mo922d(i, c2583az, z);
        if (C2628cq.m2563T(c2583az.f5313b, this.f8863e) && z) {
            c2583az.f5313b = f8861c;
        }
        return c2583az;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C3056sm, com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: e */
    public final C2585ba mo921e(int i, C2585ba c2585ba, long j) {
        this.f8846b.mo921e(i, c2585ba, j);
        if (C2628cq.m2563T(c2585ba.f5348b, this.f8862d)) {
            c2585ba.f5348b = C2585ba.f5346a;
        }
        return c2585ba;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C3056sm, com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: f */
    public final Object mo920f(int i) {
        Object mo920f = this.f8846b.mo920f(i);
        return C2628cq.m2563T(mo920f, this.f8863e) ? f8861c : mo920f;
    }

    /* renamed from: r */
    public final C3061sr m1114r(AbstractC2586bb abstractC2586bb) {
        return new C3061sr(abstractC2586bb, this.f8862d, this.f8863e);
    }
}
