package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adw */
/* loaded from: classes2.dex */
public final class adw implements aek {

    /* renamed from: a */
    private final adg f3541a;

    /* renamed from: b */
    private final C2620ci f3542b = new C2620ci(new byte[10]);

    /* renamed from: c */
    private int f3543c = 0;

    /* renamed from: d */
    private int f3544d;

    /* renamed from: e */
    private C2626co f3545e;

    /* renamed from: f */
    private boolean f3546f;

    /* renamed from: g */
    private boolean f3547g;

    /* renamed from: h */
    private boolean f3548h;

    /* renamed from: i */
    private int f3549i;

    /* renamed from: j */
    private int f3550j;

    /* renamed from: k */
    private boolean f3551k;

    /* renamed from: l */
    private long f3552l;

    public adw(adg adgVar) {
        this.f3541a = adgVar;
    }

    /* renamed from: d */
    private final void m5761d(int i) {
        this.f3543c = i;
        this.f3544d = 0;
    }

    /* renamed from: e */
    private final boolean m5760e(C2621cj c2621cj, byte[] bArr, int i) {
        int min = Math.min(c2621cj.m2641a(), i - this.f3544d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            c2621cj.m2643G(min);
        } else {
            c2621cj.m2649A(bArr, this.f3544d, min);
        }
        int i2 = this.f3544d + min;
        this.f3544d = i2;
        return i2 == i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: a */
    public final void mo5727a(C2621cj c2621cj, int i) throws C2555ao {
        C2616ce.m2688e(this.f3545e);
        int i2 = -1;
        int i3 = 2;
        if ((i & 1) != 0) {
            int i4 = this.f3543c;
            if (i4 != 0 && i4 != 1) {
                if (i4 != 2) {
                    int i5 = this.f3550j;
                    if (i5 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i5);
                        sb.append(" more bytes");
                        Log.w("PesReader", sb.toString());
                    }
                    this.f3541a.mo5769c();
                } else {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            m5761d(1);
        }
        int i6 = i;
        while (c2621cj.m2641a() > 0) {
            int i7 = this.f3543c;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != i3) {
                        int m2641a = c2621cj.m2641a();
                        int i8 = this.f3550j;
                        int i9 = i8 != i2 ? m2641a - i8 : 0;
                        if (i9 > 0) {
                            m2641a -= i9;
                            c2621cj.m2645E(c2621cj.m2639c() + m2641a);
                        }
                        this.f3541a.mo5771a(c2621cj);
                        int i10 = this.f3550j;
                        if (i10 != i2) {
                            int i11 = i10 - m2641a;
                            this.f3550j = i11;
                            if (i11 == 0) {
                                this.f3541a.mo5769c();
                                m5761d(1);
                            }
                        }
                    } else {
                        if (m5760e(c2621cj, this.f3542b.f6942a, Math.min(10, this.f3549i)) && m5760e(c2621cj, null, this.f3549i)) {
                            this.f3542b.m2657g(0);
                            long j = C3282C.TIME_UNSET;
                            this.f3552l = C3282C.TIME_UNSET;
                            if (this.f3546f) {
                                this.f3542b.m2655i(4);
                                int m2661c = this.f3542b.m2661c(3);
                                this.f3542b.m2655i(1);
                                int m2661c2 = this.f3542b.m2661c(15);
                                this.f3542b.m2655i(1);
                                long m2661c3 = (m2661c2 << 15) | (m2661c << 30) | this.f3542b.m2661c(15);
                                this.f3542b.m2655i(1);
                                if (!this.f3548h && this.f3547g) {
                                    this.f3542b.m2655i(4);
                                    int m2661c4 = this.f3542b.m2661c(3);
                                    this.f3542b.m2655i(1);
                                    int m2661c5 = this.f3542b.m2661c(15);
                                    this.f3542b.m2655i(1);
                                    int m2661c6 = this.f3542b.m2661c(15);
                                    this.f3542b.m2655i(1);
                                    this.f3545e.m2590b((m2661c4 << 30) | (m2661c5 << 15) | m2661c6);
                                    this.f3548h = true;
                                }
                                j = this.f3545e.m2590b(m2661c3);
                                this.f3552l = j;
                            }
                            i6 |= true != this.f3551k ? 0 : 4;
                            this.f3541a.mo5768d(j, i6);
                            m5761d(3);
                            i2 = -1;
                        }
                    }
                } else if (m5760e(c2621cj, this.f3542b.f6942a, 9)) {
                    int i12 = 0;
                    this.f3542b.m2657g(0);
                    int m2661c7 = this.f3542b.m2661c(24);
                    if (m2661c7 != 1) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("Unexpected start code prefix: ");
                        sb2.append(m2661c7);
                        Log.w("PesReader", sb2.toString());
                        i2 = -1;
                        this.f3550j = -1;
                    } else {
                        this.f3542b.m2655i(8);
                        int m2661c8 = this.f3542b.m2661c(16);
                        this.f3542b.m2655i(5);
                        this.f3551k = this.f3542b.m2653k();
                        this.f3542b.m2655i(2);
                        this.f3546f = this.f3542b.m2653k();
                        this.f3547g = this.f3542b.m2653k();
                        this.f3542b.m2655i(6);
                        int m2661c9 = this.f3542b.m2661c(8);
                        this.f3549i = m2661c9;
                        if (m2661c8 == 0) {
                            this.f3550j = -1;
                        } else {
                            int i13 = (m2661c8 - 3) - m2661c9;
                            this.f3550j = i13;
                            if (i13 < 0) {
                                StringBuilder sb3 = new StringBuilder(47);
                                sb3.append("Found negative packet payload size: ");
                                sb3.append(i13);
                                Log.w("PesReader", sb3.toString());
                                i2 = -1;
                                this.f3550j = -1;
                                i12 = 2;
                            }
                        }
                        i2 = -1;
                        i12 = 2;
                    }
                    m5761d(i12);
                } else {
                    i2 = -1;
                }
            } else {
                c2621cj.m2643G(c2621cj.m2641a());
            }
            i3 = 2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: b */
    public final void mo5726b(C2626co c2626co, InterfaceC3233za interfaceC3233za, aej aejVar) {
        this.f3545e = c2626co;
        this.f3541a.mo5770b(interfaceC3233za, aejVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: c */
    public final void mo5725c() {
        this.f3543c = 0;
        this.f3544d = 0;
        this.f3548h = false;
        this.f3541a.mo5767e();
    }
}
