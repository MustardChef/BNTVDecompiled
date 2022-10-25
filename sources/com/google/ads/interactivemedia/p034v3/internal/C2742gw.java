package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gw */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2742gw {
    public C2742gw(C2908n c2908n, SparseArray sparseArray) {
        SparseArray sparseArray2 = new SparseArray(c2908n.m1597b());
        for (int i = 0; i < c2908n.m1597b(); i++) {
            int m1598a = c2908n.m1598a(i);
            C2786im c2786im = (C2786im) sparseArray.get(m1598a);
            C2616ce.m2689d(c2786im);
            sparseArray2.append(m1598a, c2786im);
        }
    }

    /* renamed from: a */
    public static int m2167a(int i) {
        return i;
    }

    /* renamed from: b */
    public static int m2166b(int i) {
        return i & 7;
    }

    /* renamed from: c */
    public static final C2681ep m2165c(float f, float f2, long j, float f3, long j2, long j3, float f4) {
        return new C2681ep(0.97f, 1.03f, 1000L, 1.0E-7f, j2, j3, 0.999f);
    }
}
