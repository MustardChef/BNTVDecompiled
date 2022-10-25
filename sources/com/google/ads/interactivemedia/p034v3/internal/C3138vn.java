package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vn */
/* loaded from: classes2.dex */
public final class C3138vn implements Comparable {

    /* renamed from: a */
    public final boolean f9213a;

    /* renamed from: b */
    private final boolean f9214b;

    /* renamed from: c */
    private final boolean f9215c;

    /* renamed from: d */
    private final boolean f9216d;

    /* renamed from: e */
    private final int f9217e;

    /* renamed from: f */
    private final int f9218f;

    /* renamed from: g */
    private final int f9219g;

    /* renamed from: h */
    private final int f9220h;

    /* renamed from: i */
    private final boolean f9221i;

    public C3138vn(C2962p c2962p, C3135vk c3135vk, int i, String str) {
        avg avgVar;
        int i2;
        boolean z = false;
        this.f9214b = C3140vp.m809e(i, false);
        int i3 = c2962p.f8364d;
        int i4 = c3135vk.f9193A;
        this.f9215c = 1 == (i3 & 1);
        this.f9216d = (i3 & 2) != 0;
        if (c3135vk.f5858s.isEmpty()) {
            avgVar = avg.m4514o("");
        } else {
            avgVar = c3135vk.f5858s;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= avgVar.size()) {
                i5 = Integer.MAX_VALUE;
                i2 = 0;
                break;
            }
            boolean z2 = c3135vk.f5860u;
            i2 = C3140vp.m813a(c2962p, (String) avgVar.get(i5), false);
            if (i2 > 0) {
                break;
            }
            i5++;
        }
        this.f9217e = i5;
        this.f9218f = i2;
        int bitCount = Integer.bitCount(c2962p.f8365e & c3135vk.f5859t);
        this.f9219g = bitCount;
        this.f9221i = (c2962p.f8365e & 1088) != 0;
        int m813a = C3140vp.m813a(c2962p, str, C3140vp.m810d(str) == null);
        this.f9220h = m813a;
        if (i2 > 0 || ((c3135vk.f5858s.isEmpty() && bitCount > 0) || this.f9215c || (this.f9216d && m813a > 0))) {
            z = true;
        }
        this.f9213a = z;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(C3138vn c3138vn) {
        auo mo4568b = auo.m4561j().mo4566d(this.f9214b, c3138vn.f9214b).mo4567c(Integer.valueOf(this.f9217e), Integer.valueOf(c3138vn.f9217e), awp.m4450c().mo4426a()).mo4568b(this.f9218f, c3138vn.f9218f).mo4568b(this.f9219g, c3138vn.f9219g).mo4566d(this.f9215c, c3138vn.f9215c).mo4567c(Boolean.valueOf(this.f9216d), Boolean.valueOf(c3138vn.f9216d), this.f9218f == 0 ? awp.m4450c() : awp.m4450c().mo4426a()).mo4568b(this.f9220h, c3138vn.f9220h);
        if (this.f9219g == 0) {
            mo4568b = mo4568b.mo4565e(this.f9221i, c3138vn.f9221i);
        }
        return mo4568b.mo4569a();
    }
}
