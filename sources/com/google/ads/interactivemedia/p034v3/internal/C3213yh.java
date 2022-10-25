package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yh */
/* loaded from: classes2.dex */
public final class C3213yh {

    /* renamed from: a */
    public final List f9488a;

    /* renamed from: b */
    public final int f9489b;

    /* renamed from: c */
    public final int f9490c;

    /* renamed from: d */
    public final int f9491d;

    /* renamed from: e */
    public final float f9492e;

    /* renamed from: f */
    public final String f9493f;

    private C3213yh(List list, int i, int i2, int i3, float f, String str) {
        this.f9488a = list;
        this.f9489b = i;
        this.f9490c = i2;
        this.f9491d = i3;
        this.f9492e = f;
        this.f9493f = str;
    }

    /* renamed from: a */
    public static C3213yh m545a(C2621cj c2621cj) throws C2555ao {
        String str;
        int i;
        int i2;
        float f;
        try {
            c2621cj.m2643G(4);
            int m2633i = (c2621cj.m2633i() & 3) + 1;
            if (m2633i == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int m2633i2 = c2621cj.m2633i() & 31;
            for (int i3 = 0; i3 < m2633i2; i3++) {
                arrayList.add(m544b(c2621cj));
            }
            int m2633i3 = c2621cj.m2633i();
            for (int i4 = 0; i4 < m2633i3; i4++) {
                arrayList.add(m544b(c2621cj));
            }
            if (m2633i2 > 0) {
                C3244zl m464c = C3245zm.m464c((byte[]) arrayList.get(0), m2633i, ((byte[]) arrayList.get(0)).length);
                int i5 = m464c.f9593e;
                int i6 = m464c.f9594f;
                float f2 = m464c.f9595g;
                str = C2599bo.m3196a(m464c.f9589a, m464c.f9590b, m464c.f9591c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                str = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new C3213yh(arrayList, m2633i, i, i2, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw C2555ao.m4866a("Error parsing AVC config", e);
        }
    }

    /* renamed from: b */
    private static byte[] m544b(C2621cj c2621cj) {
        int m2629m = c2621cj.m2629m();
        int m2639c = c2621cj.m2639c();
        c2621cj.m2643G(m2629m);
        return C2599bo.m3194c(c2621cj.m2642H(), m2639c, m2629m);
    }
}
