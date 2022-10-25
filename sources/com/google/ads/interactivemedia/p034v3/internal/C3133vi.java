package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vi */
/* loaded from: classes2.dex */
public final class C3133vi implements Comparable {

    /* renamed from: a */
    public final boolean f9176a;

    /* renamed from: b */
    private final String f9177b;

    /* renamed from: c */
    private final C3135vk f9178c;

    /* renamed from: d */
    private final boolean f9179d;

    /* renamed from: e */
    private final int f9180e;

    /* renamed from: f */
    private final int f9181f;

    /* renamed from: g */
    private final int f9182g;

    /* renamed from: h */
    private final int f9183h;

    /* renamed from: i */
    private final int f9184i;

    /* renamed from: j */
    private final boolean f9185j;

    /* renamed from: k */
    private final int f9186k;

    /* renamed from: l */
    private final int f9187l;

    /* renamed from: m */
    private final int f9188m;

    /* renamed from: n */
    private final int f9189n;

    public C3133vi(C2962p c2962p, C3135vk c3135vk, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        this.f9178c = c3135vk;
        this.f9177b = C3140vp.m810d(c2962p.f8363c);
        int i6 = 0;
        this.f9179d = C3140vp.m809e(i, false);
        int i7 = 0;
        while (true) {
            i2 = Integer.MAX_VALUE;
            if (i7 >= c3135vk.f5853n.size()) {
                i7 = Integer.MAX_VALUE;
                i3 = 0;
                break;
            }
            i3 = C3140vp.m813a(c2962p, (String) c3135vk.f5853n.get(i7), false);
            if (i3 > 0) {
                break;
            }
            i7++;
        }
        this.f9181f = i7;
        this.f9180e = i3;
        int i8 = c2962p.f8365e;
        int i9 = c3135vk.f5854o;
        this.f9182g = Integer.bitCount(0);
        boolean z = true;
        this.f9185j = 1 == (c2962p.f8364d & 1);
        this.f9186k = c2962p.f8385y;
        this.f9187l = c2962p.f8386z;
        this.f9188m = c2962p.f8368h;
        int i10 = c2962p.f8368h;
        if ((i10 != -1 && i10 > c3135vk.f5856q) || ((i4 = c2962p.f8385y) != -1 && i4 > c3135vk.f5855p)) {
            z = false;
        }
        this.f9176a = z;
        String[] m2548ah = C2628cq.m2548ah();
        int i11 = 0;
        while (true) {
            if (i11 >= m2548ah.length) {
                i11 = Integer.MAX_VALUE;
                i5 = 0;
                break;
            }
            i5 = C3140vp.m813a(c2962p, m2548ah[i11], false);
            if (i5 > 0) {
                break;
            }
            i11++;
        }
        this.f9183h = i11;
        this.f9184i = i5;
        while (true) {
            if (i6 < c3135vk.f5857r.size()) {
                String str = c2962p.f8372l;
                if (str != null && str.equals(c3135vk.f5857r.get(i6))) {
                    i2 = i6;
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        this.f9189n = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(C3133vi c3133vi) {
        awp awpVar;
        awp mo4426a;
        awp awpVar2;
        if (this.f9176a && this.f9179d) {
            mo4426a = C3140vp.f9231c;
        } else {
            awpVar = C3140vp.f9231c;
            mo4426a = awpVar.mo4426a();
        }
        auo mo4567c = auo.m4561j().mo4566d(this.f9179d, c3133vi.f9179d).mo4567c(Integer.valueOf(this.f9181f), Integer.valueOf(c3133vi.f9181f), awp.m4450c().mo4426a()).mo4568b(this.f9180e, c3133vi.f9180e).mo4568b(this.f9182g, c3133vi.f9182g).mo4566d(this.f9176a, c3133vi.f9176a).mo4567c(Integer.valueOf(this.f9189n), Integer.valueOf(c3133vi.f9189n), awp.m4450c().mo4426a());
        Integer valueOf = Integer.valueOf(this.f9188m);
        Integer valueOf2 = Integer.valueOf(c3133vi.f9188m);
        boolean z = this.f9178c.f5861v;
        awpVar2 = C3140vp.f9232d;
        auo mo4567c2 = mo4567c.mo4567c(valueOf, valueOf2, awpVar2).mo4566d(this.f9185j, c3133vi.f9185j).mo4567c(Integer.valueOf(this.f9183h), Integer.valueOf(c3133vi.f9183h), awp.m4450c().mo4426a()).mo4568b(this.f9184i, c3133vi.f9184i).mo4567c(Integer.valueOf(this.f9186k), Integer.valueOf(c3133vi.f9186k), mo4426a).mo4567c(Integer.valueOf(this.f9187l), Integer.valueOf(c3133vi.f9187l), mo4426a);
        Integer valueOf3 = Integer.valueOf(this.f9188m);
        Integer valueOf4 = Integer.valueOf(c3133vi.f9188m);
        if (!C2628cq.m2563T(this.f9177b, c3133vi.f9177b)) {
            mo4426a = C3140vp.f9232d;
        }
        return mo4567c2.mo4567c(valueOf3, valueOf4, mo4426a).mo4569a();
    }
}
