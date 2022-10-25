package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.a */
/* loaded from: classes2.dex */
public final class C2536a {

    /* renamed from: a */
    public final long f2856a;

    /* renamed from: b */
    public final int f2857b;

    /* renamed from: c */
    public final Uri[] f2858c;

    /* renamed from: d */
    public final int[] f2859d;

    /* renamed from: e */
    public final long[] f2860e;

    /* renamed from: f */
    public final long f2861f;

    /* renamed from: g */
    public final boolean f2862g;

    public C2536a() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    /* renamed from: a */
    public final int m5985a() {
        return m5984b(-1);
    }

    /* renamed from: b */
    public final int m5984b(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.f2859d;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                break;
            }
            i3++;
        }
        return i3;
    }

    /* renamed from: c */
    public final C2536a m5983c() {
        int[] iArr = this.f2859d;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.f2860e;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, (long) C3282C.TIME_UNSET);
        return new C2536a(0, copyOf, (Uri[]) Arrays.copyOf(this.f2858c, 0), copyOf2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2536a c2536a = (C2536a) obj;
            if (this.f2857b == c2536a.f2857b && Arrays.equals(this.f2858c, c2536a.f2858c) && Arrays.equals(this.f2859d, c2536a.f2859d) && Arrays.equals(this.f2860e, c2536a.f2860e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f2857b * 961) + Arrays.hashCode(this.f2858c)) * 31) + Arrays.hashCode(this.f2859d)) * 31) + Arrays.hashCode(this.f2860e)) * 961;
    }

    private C2536a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
        C2616ce.m2687f(iArr.length == uriArr.length);
        this.f2856a = 0L;
        this.f2857b = i;
        this.f2859d = iArr;
        this.f2858c = uriArr;
        this.f2860e = jArr;
        this.f2861f = 0L;
        this.f2862g = false;
    }
}
