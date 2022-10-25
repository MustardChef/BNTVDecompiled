package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tv */
/* loaded from: classes2.dex */
public final class C3092tv {

    /* renamed from: a */
    private final C2621cj f8995a = new C2621cj(32);

    /* renamed from: b */
    private C3091tu f8996b;

    /* renamed from: c */
    private C3091tu f8997c;

    /* renamed from: d */
    private C3091tu f8998d;

    /* renamed from: e */
    private long f8999e;

    /* renamed from: f */
    private final C3154wc f9000f;

    public C3092tv(C3154wc c3154wc) {
        this.f9000f = c3154wc;
        C3091tu c3091tu = new C3091tu(0L);
        this.f8996b = c3091tu;
        this.f8997c = c3091tu;
        this.f8998d = c3091tu;
    }

    /* renamed from: j */
    private final int m992j(int i) {
        C3091tu c3091tu = this.f8998d;
        if (!c3091tu.f8992c) {
            C3147vw m767b = this.f9000f.m767b();
            C3091tu c3091tu2 = new C3091tu(this.f8998d.f8991b);
            c3091tu.f8993d = m767b;
            c3091tu.f8994e = c3091tu2;
            c3091tu.f8992c = true;
        }
        return Math.min(i, (int) (this.f8998d.f8991b - this.f8999e));
    }

    /* renamed from: k */
    private static C3091tu m991k(C3091tu c3091tu, long j) {
        while (j >= c3091tu.f8991b) {
            c3091tu = c3091tu.f8994e;
        }
        return c3091tu;
    }

    /* renamed from: l */
    private static C3091tu m990l(C3091tu c3091tu, long j, ByteBuffer byteBuffer, int i) {
        C3091tu m991k = m991k(c3091tu, j);
        while (i > 0) {
            int min = Math.min(i, (int) (m991k.f8991b - j));
            byteBuffer.put(m991k.f8993d.f9248a, m991k.m1003a(j), min);
            i -= min;
            j += min;
            if (j == m991k.f8991b) {
                m991k = m991k.f8994e;
            }
        }
        return m991k;
    }

    /* renamed from: m */
    private static C3091tu m989m(C3091tu c3091tu, long j, byte[] bArr, int i) {
        C3091tu m991k = m991k(c3091tu, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (m991k.f8991b - j));
            System.arraycopy(m991k.f8993d.f9248a, m991k.m1003a(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == m991k.f8991b) {
                m991k = m991k.f8994e;
            }
        }
        return m991k;
    }

    /* renamed from: n */
    private static C3091tu m988n(C3091tu c3091tu, C2669ed c2669ed, C3093tw c3093tw, C2621cj c2621cj) {
        C3091tu c3091tu2;
        int i;
        if (c2669ed.m2446n()) {
            long j = c3093tw.f9002b;
            c2621cj.m2648B(1);
            C3091tu m989m = m989m(c3091tu, j, c2621cj.m2642H(), 1);
            long j2 = j + 1;
            byte b = c2621cj.m2642H()[0];
            int i2 = b & 128;
            int i3 = b & Byte.MAX_VALUE;
            C2666ea c2666ea = c2669ed.f7091a;
            byte[] bArr = c2666ea.f7081a;
            if (bArr == null) {
                c2666ea.f7081a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            c3091tu2 = m989m(m989m, j2, c2666ea.f7081a, i3);
            long j3 = j2 + i3;
            if (i2 != 0) {
                c2621cj.m2648B(2);
                c3091tu2 = m989m(c3091tu2, j3, c2621cj.m2642H(), 2);
                j3 += 2;
                i = c2621cj.m2629m();
            } else {
                i = 1;
            }
            int[] iArr = c2666ea.f7084d;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = c2666ea.f7085e;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (i2 != 0) {
                int i4 = i * 6;
                c2621cj.m2648B(i4);
                c3091tu2 = m989m(c3091tu2, j3, c2621cj.m2642H(), i4);
                j3 += i4;
                c2621cj.m2644F(0);
                for (int i5 = 0; i5 < i; i5++) {
                    iArr2[i5] = c2621cj.m2629m();
                    iArr4[i5] = c2621cj.m2630l();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = c3093tw.f9001a - ((int) (j3 - c3093tw.f9002b));
            }
            C3252zt c3252zt = c3093tw.f9003c;
            int i6 = C2628cq.f6961a;
            c2666ea.m2449c(i, iArr2, iArr4, c3252zt.f9619b, c2666ea.f7081a, c3252zt.f9618a, c3252zt.f9620c, c3252zt.f9621d);
            long j4 = c3093tw.f9002b;
            int i7 = (int) (j3 - j4);
            c3093tw.f9002b = j4 + i7;
            c3093tw.f9001a -= i7;
        } else {
            c3091tu2 = c3091tu;
        }
        if (c2669ed.m2464e()) {
            c2621cj.m2648B(4);
            C3091tu m989m2 = m989m(c3091tu2, c3093tw.f9002b, c2621cj.m2642H(), 4);
            int m2630l = c2621cj.m2630l();
            c3093tw.f9002b += 4;
            c3093tw.f9001a -= 4;
            c2669ed.m2448l(m2630l);
            C3091tu m990l = m990l(m989m2, c3093tw.f9002b, c2669ed.f7092b, m2630l);
            c3093tw.f9002b += m2630l;
            int i8 = c3093tw.f9001a - m2630l;
            c3093tw.f9001a = i8;
            ByteBuffer byteBuffer = c2669ed.f7095e;
            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                c2669ed.f7095e = ByteBuffer.allocate(i8);
            } else {
                c2669ed.f7095e.clear();
            }
            return m990l(m990l, c3093tw.f9002b, c2669ed.f7095e, c3093tw.f9001a);
        }
        c2669ed.m2448l(c3093tw.f9001a);
        return m990l(c3091tu2, c3093tw.f9002b, c2669ed.f7092b, c3093tw.f9001a);
    }

    /* renamed from: o */
    private final void m987o(C3091tu c3091tu) {
        if (c3091tu.f8992c) {
            C3091tu c3091tu2 = this.f8998d;
            int i = (c3091tu2.f8992c ? 1 : 0) + (((int) (c3091tu2.f8990a - c3091tu.f8990a)) / 65536);
            C3147vw[] c3147vwArr = new C3147vw[i];
            for (int i2 = 0; i2 < i; i2++) {
                c3147vwArr[i2] = c3091tu.f8993d;
                c3091tu = c3091tu.m1002b();
            }
            this.f9000f.m765d(c3147vwArr);
        }
    }

    /* renamed from: p */
    private final void m986p(int i) {
        long j = this.f8999e + i;
        this.f8999e = j;
        C3091tu c3091tu = this.f8998d;
        if (j == c3091tu.f8991b) {
            this.f8998d = c3091tu.f8994e;
        }
    }

    /* renamed from: a */
    public final int m1001a(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        int m992j = m992j(i);
        C3091tu c3091tu = this.f8998d;
        int mo501a = interfaceC2746h.mo501a(c3091tu.f8993d.f9248a, c3091tu.m1003a(this.f8999e), m992j);
        if (mo501a != -1) {
            m986p(mo501a);
            return mo501a;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: b */
    public final long m1000b() {
        return this.f8999e;
    }

    /* renamed from: c */
    public final void m999c(long j) {
        C3091tu c3091tu;
        if (j != -1) {
            while (true) {
                c3091tu = this.f8996b;
                if (j < c3091tu.f8991b) {
                    break;
                }
                this.f9000f.m766c(c3091tu.f8993d);
                this.f8996b = this.f8996b.m1002b();
            }
            if (this.f8997c.f8990a < c3091tu.f8990a) {
                this.f8997c = c3091tu;
            }
        }
    }

    /* renamed from: d */
    public final void m998d(long j) {
        this.f8999e = j;
        if (j != 0) {
            C3091tu c3091tu = this.f8996b;
            if (j != c3091tu.f8990a) {
                while (this.f8999e > c3091tu.f8991b) {
                    c3091tu = c3091tu.f8994e;
                }
                C3091tu c3091tu2 = c3091tu.f8994e;
                m987o(c3091tu2);
                long j2 = c3091tu.f8991b;
                c3091tu.f8994e = new C3091tu(j2);
                this.f8998d = this.f8999e == j2 ? c3091tu.f8994e : c3091tu;
                if (this.f8997c == c3091tu2) {
                    this.f8997c = c3091tu.f8994e;
                    return;
                }
                return;
            }
        }
        m987o(this.f8996b);
        C3091tu c3091tu3 = new C3091tu(this.f8999e);
        this.f8996b = c3091tu3;
        this.f8997c = c3091tu3;
        this.f8998d = c3091tu3;
    }

    /* renamed from: e */
    public final void m997e(C2669ed c2669ed, C3093tw c3093tw) {
        m988n(this.f8997c, c2669ed, c3093tw, this.f8995a);
    }

    /* renamed from: f */
    public final void m996f(C2669ed c2669ed, C3093tw c3093tw) {
        this.f8997c = m988n(this.f8997c, c2669ed, c3093tw, this.f8995a);
    }

    /* renamed from: g */
    public final void m995g() {
        m987o(this.f8996b);
        C3091tu c3091tu = new C3091tu(0L);
        this.f8996b = c3091tu;
        this.f8997c = c3091tu;
        this.f8998d = c3091tu;
        this.f8999e = 0L;
        this.f9000f.m762g();
    }

    /* renamed from: h */
    public final void m994h() {
        this.f8997c = this.f8996b;
    }

    /* renamed from: i */
    public final void m993i(C2621cj c2621cj, int i) {
        while (i > 0) {
            int m992j = m992j(i);
            C3091tu c3091tu = this.f8998d;
            c2621cj.m2649A(c3091tu.f8993d.f9248a, c3091tu.m1003a(this.f8999e), m992j);
            i -= m992j;
            m986p(m992j);
        }
    }
}
