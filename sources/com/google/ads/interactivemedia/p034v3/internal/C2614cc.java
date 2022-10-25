package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cc */
/* loaded from: classes2.dex */
public final class C2614cc {

    /* renamed from: a */
    private int f6930a;

    /* renamed from: b */
    private long[] f6931b = new long[32];

    /* renamed from: a */
    public final int m2695a() {
        return this.f6930a;
    }

    /* renamed from: b */
    public final long m2694b(int i) {
        if (i < 0 || i >= this.f6930a) {
            int i2 = this.f6930a;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.f6931b[i];
    }

    /* renamed from: c */
    public final void m2693c(long j) {
        int i = this.f6930a;
        long[] jArr = this.f6931b;
        if (i == jArr.length) {
            this.f6931b = Arrays.copyOf(jArr, i + i);
        }
        long[] jArr2 = this.f6931b;
        int i2 = this.f6930a;
        this.f6930a = i2 + 1;
        jArr2[i2] = j;
    }
}
