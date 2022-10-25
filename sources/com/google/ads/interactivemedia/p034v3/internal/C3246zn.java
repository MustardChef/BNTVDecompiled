package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zn */
/* loaded from: classes2.dex */
public final class C3246zn {

    /* renamed from: a */
    private byte[] f9606a;

    /* renamed from: b */
    private int f9607b;

    /* renamed from: c */
    private int f9608c;

    /* renamed from: d */
    private int f9609d;

    public C3246zn(byte[] bArr, int i, int i2) {
        m458d(bArr, i, i2);
    }

    /* renamed from: j */
    private final int m452j() {
        int i = 0;
        while (!m453i()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? m461a(i) : 0);
    }

    /* renamed from: k */
    private final void m451k() {
        int i;
        int i2 = this.f9608c;
        boolean z = true;
        if (i2 < 0 || (i2 >= (i = this.f9607b) && (i2 != i || this.f9609d != 0))) {
            z = false;
        }
        C2616ce.m2685h(z);
    }

    /* renamed from: l */
    private final boolean m450l(int i) {
        if (i < 2 || i >= this.f9607b) {
            return false;
        }
        byte[] bArr = this.f9606a;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i + (-1)] == 0;
    }

    /* renamed from: a */
    public final int m461a(int i) {
        int i2;
        this.f9609d += i;
        int i3 = 0;
        while (true) {
            i2 = this.f9609d;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.f9609d = i4;
            byte[] bArr = this.f9606a;
            int i5 = this.f9608c;
            i3 |= (bArr[i5] & 255) << i4;
            if (true != m450l(i5 + 1)) {
                r3 = 1;
            }
            this.f9608c = i5 + r3;
        }
        byte[] bArr2 = this.f9606a;
        int i6 = this.f9608c;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f9609d = 0;
            this.f9608c = i6 + (true != m450l(i6 + 1) ? 1 : 2);
        }
        m451k();
        return i7;
    }

    /* renamed from: b */
    public final int m460b() {
        int m452j = m452j();
        return (m452j % 2 == 0 ? -1 : 1) * ((m452j + 1) / 2);
    }

    /* renamed from: c */
    public final int m459c() {
        return m452j();
    }

    /* renamed from: d */
    public final void m458d(byte[] bArr, int i, int i2) {
        this.f9606a = bArr;
        this.f9608c = i;
        this.f9607b = i2;
        this.f9609d = 0;
        m451k();
    }

    /* renamed from: e */
    public final void m457e() {
        int i = this.f9609d + 1;
        this.f9609d = i;
        if (i == 8) {
            this.f9609d = 0;
            int i2 = this.f9608c;
            this.f9608c = i2 + (true == m450l(i2 + 1) ? 2 : 1);
        }
        m451k();
    }

    /* renamed from: f */
    public final void m456f(int i) {
        int i2 = this.f9608c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f9608c = i4;
        int i5 = this.f9609d + (i - (i3 * 8));
        this.f9609d = i5;
        if (i5 > 7) {
            this.f9608c = i4 + 1;
            this.f9609d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f9608c) {
                m451k();
                return;
            } else if (m450l(i2)) {
                this.f9608c++;
                i2 += 2;
            }
        }
    }

    /* renamed from: g */
    public final boolean m455g(int i) {
        int i2 = this.f9608c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.f9609d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f9607b) {
                break;
            } else if (m450l(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f9607b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    /* renamed from: h */
    public final boolean m454h() {
        int i = this.f9608c;
        int i2 = this.f9609d;
        int i3 = 0;
        while (this.f9608c < this.f9607b && !m453i()) {
            i3++;
        }
        int i4 = this.f9608c;
        int i5 = this.f9607b;
        this.f9608c = i;
        this.f9609d = i2;
        return i4 != i5 && m455g((i3 + i3) + 1);
    }

    /* renamed from: i */
    public final boolean m453i() {
        boolean z = (this.f9606a[this.f9608c] & (128 >> this.f9609d)) != 0;
        m457e();
        return z;
    }
}
