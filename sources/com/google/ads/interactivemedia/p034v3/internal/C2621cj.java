package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cj */
/* loaded from: classes2.dex */
public final class C2621cj {

    /* renamed from: a */
    private byte[] f6946a;

    /* renamed from: b */
    private int f6947b;

    /* renamed from: c */
    private int f6948c;

    public C2621cj() {
        this.f6946a = C2628cq.f6966f;
    }

    public C2621cj(byte[] bArr, int i) {
        this.f6946a = bArr;
        this.f6948c = i;
    }

    /* renamed from: A */
    public final void m2649A(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6946a, this.f6947b, bArr, i, i2);
        this.f6947b += i2;
    }

    /* renamed from: B */
    public final void m2648B(int i) {
        m2646D(m2640b() < i ? new byte[i] : this.f6946a, i);
    }

    /* renamed from: C */
    public final void m2647C(byte[] bArr) {
        m2646D(bArr, bArr.length);
    }

    /* renamed from: D */
    public final void m2646D(byte[] bArr, int i) {
        this.f6946a = bArr;
        this.f6948c = i;
        this.f6947b = 0;
    }

    /* renamed from: E */
    public final void m2645E(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.f6946a.length) {
            z = true;
        }
        C2616ce.m2687f(z);
        this.f6948c = i;
    }

    /* renamed from: F */
    public final void m2644F(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.f6948c) {
            z = true;
        }
        C2616ce.m2687f(z);
        this.f6947b = i;
    }

    /* renamed from: G */
    public final void m2643G(int i) {
        m2644F(this.f6947b + i);
    }

    /* renamed from: H */
    public final byte[] m2642H() {
        return this.f6946a;
    }

    /* renamed from: a */
    public final int m2641a() {
        return this.f6948c - this.f6947b;
    }

    /* renamed from: b */
    public final int m2640b() {
        return this.f6946a.length;
    }

    /* renamed from: c */
    public final int m2639c() {
        return this.f6947b;
    }

    /* renamed from: d */
    public final int m2638d() {
        return this.f6948c;
    }

    /* renamed from: e */
    public final int m2637e() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f6947b = i4;
        byte b3 = bArr[i3];
        this.f6947b = i4 + 1;
        return (bArr[i4] & 255) | ((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    /* renamed from: f */
    public final int m2636f() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f6947b = i4;
        byte b3 = bArr[i3];
        this.f6947b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    /* renamed from: g */
    public final int m2635g() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        this.f6947b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | (b & 255);
    }

    /* renamed from: h */
    public final int m2634h() {
        return (m2633i() << 21) | (m2633i() << 14) | (m2633i() << 7) | m2633i();
    }

    /* renamed from: i */
    public final int m2633i() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        this.f6947b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: j */
    public final int m2632j() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        this.f6947b = i3 + 2;
        return (b2 & 255) | ((b & 255) << 8);
    }

    /* renamed from: k */
    public final int m2631k() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        this.f6947b = i3 + 1;
        return (bArr[i3] & 255) | ((b & 255) << 16) | ((b2 & 255) << 8);
    }

    /* renamed from: l */
    public final int m2630l() {
        int m2637e = m2637e();
        if (m2637e >= 0) {
            return m2637e;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(m2637e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: m */
    public final int m2629m() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        this.f6947b = i2 + 1;
        return (bArr[i2] & 255) | ((b & 255) << 8);
    }

    /* renamed from: n */
    public final long m2628n() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f6947b = i4;
        byte b3 = bArr[i3];
        this.f6947b = i4 + 1;
        return ((b2 & 255) << 8) | (b & 255) | ((b3 & 255) << 16) | ((bArr[i4] & 255) << 24);
    }

    /* renamed from: o */
    public final long m2627o() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f6947b = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.f6947b = i5;
        byte b4 = bArr[i4];
        int i6 = i5 + 1;
        this.f6947b = i6;
        byte b5 = bArr[i5];
        int i7 = i6 + 1;
        this.f6947b = i7;
        byte b6 = bArr[i6];
        int i8 = i7 + 1;
        this.f6947b = i8;
        byte b7 = bArr[i7];
        this.f6947b = i8 + 1;
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (bArr[i8] & 255);
    }

    /* renamed from: p */
    public final long m2626p() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.f6947b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f6947b = i4;
        byte b3 = bArr[i3];
        this.f6947b = i4 + 1;
        return ((b2 & 255) << 16) | ((b & 255) << 24) | ((b3 & 255) << 8) | (bArr[i4] & 255);
    }

    /* renamed from: q */
    public final long m2625q() {
        long m2627o = m2627o();
        if (m2627o >= 0) {
            return m2627o;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(m2627o);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: r */
    public final String m2624r() {
        if (m2641a() == 0) {
            return null;
        }
        int i = this.f6947b;
        while (i < this.f6948c && !C2628cq.m2559X(this.f6946a[i])) {
            i++;
        }
        int i2 = this.f6947b;
        if (i - i2 >= 3) {
            byte[] bArr = this.f6946a;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                i2 += 3;
                this.f6947b = i2;
            }
        }
        String m2575H = C2628cq.m2575H(this.f6946a, i2, i - i2);
        this.f6947b = i;
        int i3 = this.f6948c;
        if (i == i3) {
            return m2575H;
        }
        byte[] bArr2 = this.f6946a;
        if (bArr2[i] == 13) {
            i++;
            this.f6947b = i;
            if (i == i3) {
                return m2575H;
            }
        }
        if (bArr2[i] == 10) {
            this.f6947b = i + 1;
        }
        return m2575H;
    }

    /* renamed from: s */
    public final String m2623s() {
        if (m2641a() == 0) {
            return null;
        }
        int i = this.f6947b;
        while (i < this.f6948c && this.f6946a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f6946a;
        int i2 = this.f6947b;
        String m2575H = C2628cq.m2575H(bArr, i2, i - i2);
        this.f6947b = i;
        if (i >= this.f6948c) {
            return m2575H;
        }
        this.f6947b = i + 1;
        return m2575H;
    }

    /* renamed from: t */
    public final String m2622t(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f6947b;
        int i3 = (i2 + i) - 1;
        String m2575H = C2628cq.m2575H(this.f6946a, i2, (i3 >= this.f6948c || this.f6946a[i3] != 0) ? i : i - 1);
        this.f6947b += i;
        return m2575H;
    }

    /* renamed from: u */
    public final String m2621u(int i) {
        return m2620v(i, atg.f5038b);
    }

    /* renamed from: v */
    public final String m2620v(int i, Charset charset) {
        byte[] bArr = this.f6946a;
        int i2 = this.f6947b;
        String str = new String(bArr, i2, i, charset);
        this.f6947b = i2 + i;
        return str;
    }

    /* renamed from: w */
    public final short m2619w() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        this.f6947b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | (b & 255));
    }

    /* renamed from: x */
    public final short m2618x() {
        byte[] bArr = this.f6946a;
        int i = this.f6947b;
        int i2 = i + 1;
        this.f6947b = i2;
        byte b = bArr[i];
        this.f6947b = i2 + 1;
        return (short) ((bArr[i2] & 255) | ((b & 255) << 8));
    }

    /* renamed from: y */
    public final void m2617y(int i) {
        if (i > m2640b()) {
            this.f6946a = Arrays.copyOf(this.f6946a, i);
        }
    }

    /* renamed from: z */
    public final void m2616z(C2620ci c2620ci, int i) {
        m2649A(c2620ci.f6942a, 0, i);
        c2620ci.m2657g(0);
    }

    public C2621cj(int i) {
        this.f6946a = new byte[i];
        this.f6948c = i;
    }

    public C2621cj(byte[] bArr) {
        this.f6946a = bArr;
        this.f6948c = bArr.length;
    }
}
