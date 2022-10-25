package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zm */
/* loaded from: classes2.dex */
public final class C3245zm {

    /* renamed from: a */
    public static final byte[] f9602a = {0, 0, 0, 1};

    /* renamed from: b */
    public static final float[] f9603b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c */
    private static final Object f9604c = new Object();

    /* renamed from: d */
    private static int[] f9605d = new int[10];

    /* renamed from: a */
    public static int m466a(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        C2616ce.m2685h(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            m463d(zArr);
            return i - 3;
        } else if (i3 <= 1 || !zArr[1] || bArr[i] != 1) {
            if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
                int i4 = i2 - 1;
                int i5 = i + 2;
                while (i5 < i4) {
                    byte b = bArr[i5];
                    if ((b & 254) == 0) {
                        int i6 = i5 - 2;
                        if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                            m463d(zArr);
                            return i6;
                        }
                        i5 = i6;
                    }
                    i5 += 3;
                }
                zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
                zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
                zArr[2] = bArr[i4] == 0;
                return i2;
            }
            m463d(zArr);
            return i - 1;
        } else {
            m463d(zArr);
            return i - 2;
        }
    }

    /* renamed from: b */
    public static int m465b(byte[] bArr, int i) {
        int i2;
        synchronized (f9604c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = f9605d;
                    if (iArr.length <= i4) {
                        int length = iArr.length;
                        f9605d = Arrays.copyOf(iArr, length + length);
                    }
                    f9605d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f9605d[i7] - i5;
                System.arraycopy(bArr, i5, bArr, i6, i8);
                int i9 = i6 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i6 = i10 + 1;
                bArr[i10] = 0;
                i5 += i8 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i6, i2 - i6);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016b  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.p034v3.internal.C3244zl m464c(byte[] r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3245zm.m464c(byte[], int, int):com.google.ads.interactivemedia.v3.internal.zl");
    }

    /* renamed from: d */
    public static void m463d(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    /* renamed from: e */
    public static C3243zk m462e(byte[] bArr, int i) {
        C3246zn c3246zn = new C3246zn(bArr, 4, i);
        int m459c = c3246zn.m459c();
        int m459c2 = c3246zn.m459c();
        c3246zn.m457e();
        return new C3243zk(m459c, m459c2, c3246zn.m453i());
    }
}
