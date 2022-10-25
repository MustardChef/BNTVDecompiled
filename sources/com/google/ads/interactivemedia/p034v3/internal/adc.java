package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adc */
/* loaded from: classes2.dex */
public final class adc implements adg {

    /* renamed from: a */
    private static final byte[] f3329a = {73, 68, 51};

    /* renamed from: b */
    private final boolean f3330b;

    /* renamed from: c */
    private final C2620ci f3331c = new C2620ci(new byte[7]);

    /* renamed from: d */
    private final C2621cj f3332d = new C2621cj(Arrays.copyOf(f3329a, 10));

    /* renamed from: e */
    private final String f3333e;

    /* renamed from: f */
    private String f3334f;

    /* renamed from: g */
    private InterfaceC3253zu f3335g;

    /* renamed from: h */
    private InterfaceC3253zu f3336h;

    /* renamed from: i */
    private int f3337i;

    /* renamed from: j */
    private int f3338j;

    /* renamed from: k */
    private int f3339k;

    /* renamed from: l */
    private boolean f3340l;

    /* renamed from: m */
    private boolean f3341m;

    /* renamed from: n */
    private int f3342n;

    /* renamed from: o */
    private int f3343o;

    /* renamed from: p */
    private int f3344p;

    /* renamed from: q */
    private boolean f3345q;

    /* renamed from: r */
    private long f3346r;

    /* renamed from: s */
    private int f3347s;

    /* renamed from: t */
    private long f3348t;

    /* renamed from: u */
    private InterfaceC3253zu f3349u;

    /* renamed from: v */
    private long f3350v;

    public adc(boolean z, String str) {
        m5813h();
        this.f3342n = -1;
        this.f3343o = -1;
        this.f3346r = C3282C.TIME_UNSET;
        this.f3348t = C3282C.TIME_UNSET;
        this.f3330b = z;
        this.f3333e = str;
    }

    /* renamed from: f */
    public static boolean m5815f(int i) {
        return (i & 65526) == 65520;
    }

    /* renamed from: g */
    private final void m5814g() {
        this.f3341m = false;
        m5813h();
    }

    /* renamed from: h */
    private final void m5813h() {
        this.f3337i = 0;
        this.f3338j = 0;
        this.f3339k = 256;
    }

    /* renamed from: i */
    private final void m5812i() {
        this.f3337i = 3;
        this.f3338j = 0;
    }

    /* renamed from: j */
    private final void m5811j(InterfaceC3253zu interfaceC3253zu, long j, int i, int i2) {
        this.f3337i = 4;
        this.f3338j = i;
        this.f3349u = interfaceC3253zu;
        this.f3350v = j;
        this.f3347s = i2;
    }

    /* renamed from: k */
    private final boolean m5810k(C2621cj c2621cj, byte[] bArr, int i) {
        int min = Math.min(c2621cj.m2641a(), i - this.f3338j);
        c2621cj.m2649A(bArr, this.f3338j, min);
        int i2 = this.f3338j + min;
        this.f3338j = i2;
        return i2 == i;
    }

    /* renamed from: l */
    private static final boolean m5809l(byte b) {
        return m5815f((b & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    /* renamed from: m */
    private static final boolean m5808m(C2621cj c2621cj, byte[] bArr, int i) {
        if (c2621cj.m2641a() < i) {
            return false;
        }
        c2621cj.m2649A(bArr, 0, i);
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: a */
    public final void mo5771a(C2621cj c2621cj) throws C2555ao {
        int i;
        int i2;
        int i3;
        C2616ce.m2689d(this.f3335g);
        int i4 = C2628cq.f6961a;
        while (c2621cj.m2641a() > 0) {
            int i5 = this.f3337i;
            int i6 = 13;
            int i7 = 2;
            if (i5 == 0) {
                byte[] m2642H = c2621cj.m2642H();
                int m2639c = c2621cj.m2639c();
                int m2638d = c2621cj.m2638d();
                while (true) {
                    if (m2639c < m2638d) {
                        i = m2639c + 1;
                        i2 = m2642H[m2639c] & 255;
                        if (this.f3339k == 512 && m5809l((byte) i2)) {
                            if (!this.f3341m) {
                                int i8 = i - 2;
                                c2621cj.m2644F(i8 + 1);
                                if (m5808m(c2621cj, this.f3331c.f6942a, 1)) {
                                    this.f3331c.m2657g(4);
                                    int m2661c = this.f3331c.m2661c(1);
                                    int i9 = this.f3342n;
                                    if (i9 == -1 || m2661c == i9) {
                                        if (this.f3343o != -1) {
                                            if (!m5808m(c2621cj, this.f3331c.f6942a, 1)) {
                                                break;
                                            }
                                            this.f3331c.m2657g(i7);
                                            if (this.f3331c.m2661c(4) == this.f3343o) {
                                                c2621cj.m2644F(i8 + 2);
                                            }
                                        }
                                        if (!m5808m(c2621cj, this.f3331c.f6942a, 4)) {
                                            break;
                                        }
                                        this.f3331c.m2657g(14);
                                        int m2661c2 = this.f3331c.m2661c(i6);
                                        if (m2661c2 >= 7) {
                                            byte[] m2642H2 = c2621cj.m2642H();
                                            int m2638d2 = c2621cj.m2638d();
                                            int i10 = i8 + m2661c2;
                                            if (i10 < m2638d2) {
                                                byte b = m2642H2[i10];
                                                if (b != -1) {
                                                    if (b == 73) {
                                                        int i11 = i10 + 1;
                                                        if (i11 == m2638d2) {
                                                            break;
                                                        } else if (m2642H2[i11] == 68) {
                                                            int i12 = i10 + 2;
                                                            if (i12 == m2638d2) {
                                                                break;
                                                            } else if (m2642H2[i12] == 51) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    int i13 = i10 + 1;
                                                    if (i13 == m2638d2) {
                                                        break;
                                                    }
                                                    byte b2 = m2642H2[i13];
                                                    if (m5809l(b2) && ((b2 & 8) >> 3) == m2661c) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        int i14 = this.f3339k;
                        int i15 = i14 | i2;
                        if (i15 == 329) {
                            i3 = 768;
                        } else if (i15 == 511) {
                            i3 = 512;
                        } else if (i15 == 836) {
                            i3 = 1024;
                        } else if (i15 == 1075) {
                            this.f3337i = 2;
                            this.f3338j = 3;
                            this.f3347s = 0;
                            this.f3332d.m2644F(0);
                            c2621cj.m2644F(i);
                            break;
                        } else if (i14 != 256) {
                            this.f3339k = 256;
                            m2639c = i - 1;
                            i6 = 13;
                            i7 = 2;
                        } else {
                            m2639c = i;
                            i6 = 13;
                            i7 = 2;
                        }
                        this.f3339k = i3;
                        m2639c = i;
                        i6 = 13;
                        i7 = 2;
                    } else {
                        c2621cj.m2644F(m2639c);
                        break;
                    }
                }
                this.f3344p = (i2 & 8) >> 3;
                this.f3340l = 1 == ((i2 & 1) ^ 1);
                if (this.f3341m) {
                    m5812i();
                } else {
                    this.f3337i = 1;
                    this.f3338j = 0;
                }
                c2621cj.m2644F(i);
            } else if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        int min = Math.min(c2621cj.m2641a(), this.f3347s - this.f3338j);
                        this.f3349u.mo442e(c2621cj, min);
                        int i16 = this.f3338j + min;
                        this.f3338j = i16;
                        int i17 = this.f3347s;
                        if (i16 == i17) {
                            long j = this.f3348t;
                            if (j != C3282C.TIME_UNSET) {
                                this.f3349u.mo441f(j, 1, i17, 0, null);
                                this.f3348t += this.f3350v;
                            }
                            m5813h();
                        }
                    } else {
                        if (m5810k(c2621cj, this.f3331c.f6942a, true != this.f3340l ? 5 : 7)) {
                            this.f3331c.m2657g(0);
                            if (!this.f3345q) {
                                int m2661c3 = this.f3331c.m2661c(2) + 1;
                                if (m2661c3 != 2) {
                                    StringBuilder sb = new StringBuilder(61);
                                    sb.append("Detected audio object type: ");
                                    sb.append(m2661c3);
                                    sb.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb.toString());
                                }
                                this.f3331c.m2655i(5);
                                int m2661c4 = this.f3331c.m2661c(3);
                                int i18 = this.f3343o;
                                int i19 = C3208yc.f9468a;
                                byte[] bArr = {(byte) (((i18 >> 1) & 7) | 16), (byte) (((m2661c4 << 3) & 120) | ((i18 << 7) & 128))};
                                C3207yb m557a = C3208yc.m557a(bArr);
                                C2935o c2935o = new C2935o();
                                c2935o.m1545S(this.f3334f);
                                c2935o.m1532ae(MimeTypes.AUDIO_AAC);
                                c2935o.m1555I(m557a.f9467c);
                                c2935o.m1556H(m557a.f9466b);
                                c2935o.m1531af(m557a.f9465a);
                                c2935o.m1544T(Collections.singletonList(bArr));
                                c2935o.m1542V(this.f3333e);
                                C2962p m1506v = c2935o.m1506v();
                                this.f3346r = 1024000000 / m1506v.f8386z;
                                this.f3335g.mo443b(m1506v);
                                this.f3345q = true;
                            } else {
                                this.f3331c.m2655i(10);
                            }
                            this.f3331c.m2655i(4);
                            int m2661c5 = this.f3331c.m2661c(13) - 7;
                            if (this.f3340l) {
                                m2661c5 -= 2;
                            }
                            m5811j(this.f3335g, this.f3346r, 0, m2661c5);
                        }
                    }
                } else if (m5810k(c2621cj, this.f3332d.m2642H(), 10)) {
                    this.f3336h.mo442e(this.f3332d, 10);
                    this.f3332d.m2644F(6);
                    m5811j(this.f3336h, 0L, 10, this.f3332d.m2634h() + 10);
                }
            } else if (c2621cj.m2641a() != 0) {
                C2620ci c2620ci = this.f3331c;
                c2620ci.f6942a[0] = c2621cj.m2642H()[c2621cj.m2639c()];
                c2620ci.m2657g(2);
                int m2661c6 = this.f3331c.m2661c(4);
                int i20 = this.f3343o;
                if (i20 == -1 || m2661c6 == i20) {
                    if (!this.f3341m) {
                        this.f3341m = true;
                        this.f3342n = this.f3344p;
                        this.f3343o = m2661c6;
                    }
                    m5812i();
                } else {
                    m5814g();
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: b */
    public final void mo5770b(InterfaceC3233za interfaceC3233za, aej aejVar) {
        aejVar.m5729c();
        this.f3334f = aejVar.m5730b();
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(aejVar.m5731a(), 1);
        this.f3335g = mo489be;
        this.f3349u = mo489be;
        if (!this.f3330b) {
            this.f3336h = new C3228yw();
            return;
        }
        aejVar.m5729c();
        InterfaceC3253zu mo489be2 = interfaceC3233za.mo489be(aejVar.m5731a(), 5);
        this.f3336h = mo489be2;
        C2935o c2935o = new C2935o();
        c2935o.m1545S(aejVar.m5730b());
        c2935o.m1532ae(MimeTypes.APPLICATION_ID3);
        mo489be2.mo443b(c2935o.m1506v());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: c */
    public final void mo5769c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: d */
    public final void mo5768d(long j, int i) {
        if (j != C3282C.TIME_UNSET) {
            this.f3348t = j;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.adg
    /* renamed from: e */
    public final void mo5767e() {
        this.f3348t = C3282C.TIME_UNSET;
        m5814g();
    }
}
