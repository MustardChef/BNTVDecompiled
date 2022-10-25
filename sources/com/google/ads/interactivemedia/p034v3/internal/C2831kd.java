package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kd */
/* loaded from: classes2.dex */
final class C2831kd {

    /* renamed from: a */
    private final int f7805a;

    /* renamed from: b */
    private final int f7806b;

    /* renamed from: c */
    private final float f7807c;

    /* renamed from: d */
    private final float f7808d;

    /* renamed from: e */
    private final float f7809e;

    /* renamed from: f */
    private final int f7810f;

    /* renamed from: g */
    private final int f7811g;

    /* renamed from: h */
    private final int f7812h;

    /* renamed from: i */
    private final short[] f7813i;

    /* renamed from: j */
    private short[] f7814j;

    /* renamed from: k */
    private int f7815k;

    /* renamed from: l */
    private short[] f7816l;

    /* renamed from: m */
    private int f7817m;

    /* renamed from: n */
    private short[] f7818n;

    /* renamed from: o */
    private int f7819o;

    /* renamed from: p */
    private int f7820p;

    /* renamed from: q */
    private int f7821q;

    /* renamed from: r */
    private int f7822r;

    /* renamed from: s */
    private int f7823s;

    /* renamed from: t */
    private int f7824t;

    /* renamed from: u */
    private int f7825u;

    /* renamed from: v */
    private int f7826v;

    public C2831kd(int i, int i2, float f, float f2, int i3) {
        this.f7805a = i;
        this.f7806b = i2;
        this.f7807c = f;
        this.f7808d = f2;
        this.f7809e = i / i3;
        this.f7810f = i / 400;
        int i4 = i / 65;
        this.f7811g = i4;
        int i5 = i4 + i4;
        this.f7812h = i5;
        this.f7813i = new short[i5];
        int i6 = i5 * i2;
        this.f7814j = new short[i6];
        this.f7816l = new short[i6];
        this.f7818n = new short[i6];
    }

    /* renamed from: g */
    private final int m1816g(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.f7806b;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                i9 += Math.abs(sArr[i4 + i10] - sArr[(i4 + i2) + i10]);
            }
            int i11 = i9 * i7;
            int i12 = i5 * i2;
            if (i11 < i12) {
                i5 = i9;
            }
            if (i11 < i12) {
                i7 = i2;
            }
            int i13 = i9 * i6;
            int i14 = i8 * i2;
            if (i13 > i14) {
                i8 = i9;
            }
            if (i13 > i14) {
                i6 = i2;
            }
            i2++;
        }
        this.f7825u = i5 / i7;
        this.f7826v = i8 / i6;
        return i7;
    }

    /* renamed from: h */
    private final void m1815h(short[] sArr, int i, int i2) {
        short[] m1811l = m1811l(this.f7816l, this.f7817m, i2);
        this.f7816l = m1811l;
        int i3 = this.f7806b;
        System.arraycopy(sArr, i * i3, m1811l, this.f7817m * i3, i3 * i2);
        this.f7817m += i2;
    }

    /* renamed from: i */
    private final void m1814i(short[] sArr, int i, int i2) {
        int i3 = this.f7812h / i2;
        int i4 = this.f7806b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f7813i[i7] = (short) (i8 / i5);
        }
    }

    /* renamed from: j */
    private static void m1813j(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    /* renamed from: l */
    private final short[] m1811l(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.f7806b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    /* renamed from: a */
    public final int m1822a() {
        int i = this.f7817m * this.f7806b;
        return i + i;
    }

    /* renamed from: b */
    public final int m1821b() {
        int i = this.f7815k * this.f7806b;
        return i + i;
    }

    /* renamed from: c */
    public final void m1820c() {
        this.f7815k = 0;
        this.f7817m = 0;
        this.f7819o = 0;
        this.f7820p = 0;
        this.f7821q = 0;
        this.f7822r = 0;
        this.f7823s = 0;
        this.f7824t = 0;
        this.f7825u = 0;
        this.f7826v = 0;
    }

    /* renamed from: d */
    public final void m1819d(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f7806b, this.f7817m);
        shortBuffer.put(this.f7816l, 0, this.f7806b * min);
        int i = this.f7817m - min;
        this.f7817m = i;
        short[] sArr = this.f7816l;
        int i2 = this.f7806b;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    /* renamed from: e */
    public final void m1818e() {
        int i;
        int i2 = this.f7815k;
        float f = this.f7807c;
        float f2 = this.f7808d;
        int i3 = this.f7817m + ((int) ((((i2 / (f / f2)) + this.f7819o) / (this.f7809e * f2)) + 0.5f));
        short[] sArr = this.f7814j;
        int i4 = this.f7812h;
        this.f7814j = m1811l(sArr, i2, i4 + i4 + i2);
        int i5 = 0;
        while (true) {
            int i6 = this.f7812h;
            i = i6 + i6;
            int i7 = this.f7806b;
            if (i5 >= i * i7) {
                break;
            }
            this.f7814j[(i7 * i2) + i5] = 0;
            i5++;
        }
        this.f7815k += i;
        m1812k();
        if (this.f7817m > i3) {
            this.f7817m = i3;
        }
        this.f7815k = 0;
        this.f7822r = 0;
        this.f7819o = 0;
    }

    /* renamed from: f */
    public final void m1817f(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.f7806b;
        int i2 = remaining / i;
        int i3 = i * i2;
        short[] m1811l = m1811l(this.f7814j, this.f7815k, i2);
        this.f7814j = m1811l;
        shortBuffer.get(m1811l, this.f7815k * this.f7806b, (i3 + i3) / 2);
        this.f7815k += i2;
        m1812k();
    }

    /* renamed from: k */
    private final void m1812k() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.f7817m;
        float f = this.f7807c;
        float f2 = this.f7808d;
        float f3 = f / f2;
        float f4 = this.f7809e * f2;
        double d = f3;
        float f5 = 1.0f;
        int i10 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i11 = this.f7815k;
            if (i11 >= this.f7812h) {
                int i12 = 0;
                while (true) {
                    int i13 = this.f7822r;
                    if (i13 > 0) {
                        int min = Math.min(this.f7812h, i13);
                        m1815h(this.f7814j, i12, min);
                        this.f7822r -= min;
                        i12 += min;
                    } else {
                        short[] sArr = this.f7814j;
                        int i14 = this.f7805a;
                        int i15 = i14 > 4000 ? i14 / 4000 : 1;
                        if (this.f7806b == i10 && i15 == i10) {
                            i = m1816g(sArr, i12, this.f7810f, this.f7811g);
                        } else {
                            m1814i(sArr, i12, i15);
                            int m1816g = m1816g(this.f7813i, 0, this.f7810f / i15, this.f7811g / i15);
                            if (i15 != i10) {
                                int i16 = m1816g * i15;
                                int i17 = i15 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                int i20 = this.f7810f;
                                if (i18 < i20) {
                                    i18 = i20;
                                }
                                int i21 = this.f7811g;
                                if (i19 > i21) {
                                    i19 = i21;
                                }
                                if (this.f7806b == i10) {
                                    i = m1816g(sArr, i12, i18, i19);
                                } else {
                                    m1814i(sArr, i12, i10);
                                    i = m1816g(this.f7813i, 0, i18, i19);
                                }
                            } else {
                                i = m1816g;
                            }
                        }
                        int i22 = this.f7825u;
                        int i23 = (i22 == 0 || (i4 = this.f7823s) == 0 || this.f7826v > i22 * 3 || i22 + i22 <= this.f7824t * 3) ? i : i4;
                        this.f7824t = i22;
                        this.f7823s = i;
                        if (d > 1.0d) {
                            short[] sArr2 = this.f7814j;
                            if (f3 >= 2.0f) {
                                i3 = (int) (i23 / ((-1.0f) + f3));
                            } else {
                                this.f7822r = (int) ((i23 * (2.0f - f3)) / ((-1.0f) + f3));
                                i3 = i23;
                            }
                            short[] m1811l = m1811l(this.f7816l, this.f7817m, i3);
                            this.f7816l = m1811l;
                            int i24 = i3;
                            m1813j(i3, this.f7806b, m1811l, this.f7817m, sArr2, i12, sArr2, i12 + i23);
                            this.f7817m += i24;
                            i12 += i23 + i24;
                        } else {
                            int i25 = i23;
                            short[] sArr3 = this.f7814j;
                            if (f3 < 0.5f) {
                                i2 = (int) ((i25 * f3) / (f5 - f3));
                            } else {
                                this.f7822r = (int) ((i25 * ((f3 + f3) - 1.0f)) / (f5 - f3));
                                i2 = i25;
                            }
                            int i26 = i25 + i2;
                            short[] m1811l2 = m1811l(this.f7816l, this.f7817m, i26);
                            this.f7816l = m1811l2;
                            int i27 = this.f7806b;
                            System.arraycopy(sArr3, i12 * i27, m1811l2, this.f7817m * i27, i27 * i25);
                            m1813j(i2, this.f7806b, this.f7816l, this.f7817m + i25, sArr3, i12 + i25, sArr3, i12);
                            this.f7817m += i26;
                            i12 += i2;
                        }
                    }
                    if (this.f7812h + i12 > i11) {
                        break;
                    }
                    f5 = 1.0f;
                    i10 = 1;
                }
                int i28 = this.f7815k - i12;
                short[] sArr4 = this.f7814j;
                int i29 = this.f7806b;
                System.arraycopy(sArr4, i12 * i29, sArr4, 0, i29 * i28);
                this.f7815k = i28;
                f5 = 1.0f;
            }
        } else {
            m1815h(this.f7814j, 0, this.f7815k);
            this.f7815k = 0;
        }
        if (f4 == f5 || this.f7817m == i9) {
            return;
        }
        int i30 = this.f7805a;
        int i31 = (int) (i30 / f4);
        while (true) {
            if (i31 <= 16384 && i30 <= 16384) {
                break;
            }
            i31 /= 2;
            i30 /= 2;
        }
        int i32 = this.f7817m - i9;
        short[] m1811l3 = m1811l(this.f7818n, this.f7819o, i32);
        this.f7818n = m1811l3;
        short[] sArr5 = this.f7816l;
        int i33 = this.f7806b;
        System.arraycopy(sArr5, i9 * i33, m1811l3, this.f7819o * i33, i33 * i32);
        this.f7817m = i9;
        this.f7819o += i32;
        int i34 = 0;
        while (true) {
            i5 = this.f7819o;
            i6 = i5 - 1;
            if (i34 >= i6) {
                break;
            }
            while (true) {
                i7 = this.f7820p + 1;
                i8 = this.f7821q;
                if (i7 * i31 <= i8 * i30) {
                    break;
                }
                this.f7816l = m1811l(this.f7816l, this.f7817m, 1);
                int i35 = 0;
                while (true) {
                    int i36 = this.f7806b;
                    if (i35 < i36) {
                        short[] sArr6 = this.f7816l;
                        int i37 = this.f7817m;
                        short[] sArr7 = this.f7818n;
                        int i38 = (i34 * i36) + i35;
                        short s = sArr7[i38];
                        short s2 = sArr7[i38 + i36];
                        int i39 = this.f7821q;
                        int i40 = this.f7820p;
                        int i41 = (i40 + 1) * i31;
                        int i42 = i41 - (i39 * i30);
                        int i43 = i41 - (i40 * i31);
                        sArr6[(i37 * i36) + i35] = (short) (((s * i42) + ((i43 - i42) * s2)) / i43);
                        i35++;
                    }
                }
                this.f7821q++;
                this.f7817m++;
            }
            this.f7820p = i7;
            if (i7 == i30) {
                this.f7820p = 0;
                C2616ce.m2685h(i8 == i31);
                this.f7821q = 0;
            }
            i34++;
        }
        if (i6 != 0) {
            short[] sArr8 = this.f7818n;
            int i44 = this.f7806b;
            System.arraycopy(sArr8, i6 * i44, sArr8, 0, (i5 - i6) * i44);
            this.f7819o -= i6;
        }
    }
}
