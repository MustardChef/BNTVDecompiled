package com.google.ads.interactivemedia.p034v3.internal;

import androidx.core.view.MotionEventCompat;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ci */
/* loaded from: classes2.dex */
public final class C2620ci {

    /* renamed from: a */
    public byte[] f6942a;

    /* renamed from: b */
    private int f6943b;

    /* renamed from: c */
    private int f6944c;

    /* renamed from: d */
    private int f6945d;

    public C2620ci() {
        this.f6942a = C2628cq.f6966f;
    }

    /* renamed from: n */
    private final void m2650n() {
        int i;
        int i2 = this.f6943b;
        boolean z = true;
        if (i2 < 0 || (i2 >= (i = this.f6945d) && (i2 != i || this.f6944c != 0))) {
            z = false;
        }
        C2616ce.m2685h(z);
    }

    /* renamed from: a */
    public final int m2663a() {
        return ((this.f6945d - this.f6943b) * 8) - this.f6944c;
    }

    /* renamed from: b */
    public final int m2662b() {
        return (this.f6943b * 8) + this.f6944c;
    }

    /* renamed from: c */
    public final int m2661c(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.f6944c += i;
        int i3 = 0;
        while (true) {
            i2 = this.f6944c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.f6944c = i4;
            byte[] bArr = this.f6942a;
            int i5 = this.f6943b;
            this.f6943b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.f6942a;
        int i6 = this.f6943b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f6944c = 0;
            this.f6943b = i6 + 1;
        }
        m2650n();
        return i7;
    }

    /* renamed from: d */
    public final void m2660d() {
        if (this.f6944c == 0) {
            return;
        }
        this.f6944c = 0;
        this.f6943b++;
        m2650n();
    }

    /* renamed from: e */
    public final void m2659e(byte[] bArr) {
        m2658f(bArr, bArr.length);
    }

    /* renamed from: f */
    public final void m2658f(byte[] bArr, int i) {
        this.f6942a = bArr;
        this.f6943b = 0;
        this.f6944c = 0;
        this.f6945d = i;
    }

    /* renamed from: g */
    public final void m2657g(int i) {
        int i2 = i / 8;
        this.f6943b = i2;
        this.f6944c = i - (i2 * 8);
        m2650n();
    }

    /* renamed from: h */
    public final void m2656h() {
        int i = this.f6944c + 1;
        this.f6944c = i;
        if (i == 8) {
            this.f6944c = 0;
            this.f6943b++;
        }
        m2650n();
    }

    /* renamed from: i */
    public final void m2655i(int i) {
        int i2 = i / 8;
        int i3 = this.f6943b + i2;
        this.f6943b = i3;
        int i4 = this.f6944c + (i - (i2 * 8));
        this.f6944c = i4;
        if (i4 > 7) {
            this.f6943b = i3 + 1;
            this.f6944c = i4 - 8;
        }
        m2650n();
    }

    /* renamed from: j */
    public final void m2654j(int i) {
        C2616ce.m2685h(this.f6944c == 0);
        this.f6943b += i;
        m2650n();
    }

    /* renamed from: k */
    public final boolean m2653k() {
        boolean z = (this.f6942a[this.f6943b] & (128 >> this.f6944c)) != 0;
        m2656h();
        return z;
    }

    /* renamed from: l */
    public final void m2652l(int i) {
        int i2;
        int i3 = i & 16383;
        int min = Math.min(8 - this.f6944c, 14);
        int i4 = this.f6944c;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.f6942a;
        int i6 = this.f6943b;
        byte b = (byte) (((MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        bArr[i6] = b;
        int i7 = 14 - min;
        bArr[i6] = (byte) (b | ((i3 >>> i7) << i5));
        int i8 = i6 + 1;
        while (i7 > 8) {
            i7 -= 8;
            this.f6942a[i8] = (byte) (i3 >>> i7);
            i8++;
        }
        byte[] bArr2 = this.f6942a;
        byte b2 = (byte) (bArr2[i8] & ((1 << i2) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i3 & ((1 << i7) - 1)) << (8 - i7)) | b2);
        m2655i(14);
        m2650n();
    }

    /* renamed from: m */
    public final void m2651m(byte[] bArr, int i) {
        int i2 = i >> 3;
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.f6942a;
            int i4 = this.f6943b;
            int i5 = i4 + 1;
            this.f6943b = i5;
            byte b = bArr2[i4];
            int i6 = this.f6944c;
            byte b2 = (byte) (b << i6);
            bArr[i3] = b2;
            bArr[i3] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | b2);
        }
        int i7 = i & 7;
        if (i7 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i2] & (255 >> i7));
        bArr[i2] = b3;
        int i8 = this.f6944c;
        if (i8 + i7 > 8) {
            byte[] bArr3 = this.f6942a;
            int i9 = this.f6943b;
            this.f6943b = i9 + 1;
            b3 = (byte) (b3 | ((bArr3[i9] & 255) << i8));
            bArr[i2] = b3;
            i8 -= 8;
        }
        int i10 = i8 + i7;
        this.f6944c = i10;
        byte[] bArr4 = this.f6942a;
        int i11 = this.f6943b;
        bArr[i2] = (byte) (((byte) (((255 & bArr4[i11]) >> (8 - i10)) << (8 - i7))) | b3);
        if (i10 == 8) {
            this.f6944c = 0;
            this.f6943b = i11 + 1;
        }
        m2650n();
    }

    public C2620ci(byte[] bArr) {
        int length = bArr.length;
        this.f6942a = bArr;
        this.f6945d = length;
    }
}
