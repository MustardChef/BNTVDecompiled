package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Random;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ud */
/* loaded from: classes2.dex */
public final class C3101ud {

    /* renamed from: a */
    private final Random f9045a;

    /* renamed from: b */
    private final int[] f9046b;

    /* renamed from: c */
    private final int[] f9047c;

    public C3101ud() {
        this(new Random());
    }

    /* renamed from: a */
    public final int m933a() {
        int[] iArr = this.f9046b;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    /* renamed from: b */
    public final int m932b() {
        int[] iArr = this.f9046b;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    /* renamed from: c */
    public final int m931c() {
        return this.f9046b.length;
    }

    /* renamed from: d */
    public final int m930d(int i) {
        int i2 = this.f9047c[i] + 1;
        int[] iArr = this.f9046b;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    /* renamed from: e */
    public final int m929e(int i) {
        int i2 = this.f9047c[i] - 1;
        if (i2 >= 0) {
            return this.f9046b[i2];
        }
        return -1;
    }

    /* renamed from: f */
    public final C3101ud m928f() {
        return new C3101ud(new Random(this.f9045a.nextLong()));
    }

    /* renamed from: g */
    public final C3101ud m927g(int i, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            iArr[i4] = this.f9045a.nextInt(this.f9046b.length + 1);
            int i5 = i4 + 1;
            int nextInt = this.f9045a.nextInt(i5);
            iArr2[i4] = iArr2[nextInt];
            iArr2[nextInt] = i4 + i;
            i4 = i5;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[this.f9046b.length + i2];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr4 = this.f9046b;
            if (i3 < iArr4.length + i2) {
                if (i6 >= i2 || i7 != iArr[i6]) {
                    int i8 = i7 + 1;
                    int i9 = iArr4[i7];
                    iArr3[i3] = i9;
                    if (i9 >= i) {
                        iArr3[i3] = i9 + i2;
                    }
                    i7 = i8;
                } else {
                    iArr3[i3] = iArr2[i6];
                    i6++;
                }
                i3++;
            } else {
                return new C3101ud(iArr3, new Random(this.f9045a.nextLong()));
            }
        }
    }

    /* renamed from: h */
    public final C3101ud m926h(int i, int i2) {
        int i3 = i2 - i;
        int[] iArr = new int[this.f9046b.length - i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.f9046b;
            if (i4 < iArr2.length) {
                int i6 = iArr2[i4];
                if (i6 < i || i6 >= i2) {
                    int i7 = i4 - i5;
                    if (i6 >= i) {
                        i6 -= i3;
                    }
                    iArr[i7] = i6;
                } else {
                    i5++;
                }
                i4++;
            } else {
                return new C3101ud(iArr, new Random(this.f9045a.nextLong()));
            }
        }
    }

    private C3101ud(Random random) {
        this(new int[0], random);
    }

    private C3101ud(int[] iArr, Random random) {
        this.f9046b = iArr;
        this.f9045a = random;
        this.f9047c = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.f9047c[iArr[i]] = i;
        }
    }
}
