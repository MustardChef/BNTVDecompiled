package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adp */
/* loaded from: classes2.dex */
final class adp {

    /* renamed from: a */
    private final InterfaceC3253zu f3467a;

    /* renamed from: b */
    private long f3468b;

    /* renamed from: c */
    private boolean f3469c;

    /* renamed from: d */
    private int f3470d;

    /* renamed from: e */
    private long f3471e;

    /* renamed from: f */
    private boolean f3472f;

    /* renamed from: g */
    private boolean f3473g;

    /* renamed from: h */
    private boolean f3474h;

    /* renamed from: i */
    private boolean f3475i;

    /* renamed from: j */
    private boolean f3476j;

    /* renamed from: k */
    private long f3477k;

    /* renamed from: l */
    private long f3478l;

    /* renamed from: m */
    private boolean f3479m;

    public adp(InterfaceC3253zu interfaceC3253zu) {
        this.f3467a = interfaceC3253zu;
    }

    /* renamed from: e */
    private final void m5775e(int i) {
        long j = this.f3478l;
        if (j == C3282C.TIME_UNSET) {
            return;
        }
        boolean z = this.f3479m;
        long j2 = this.f3468b;
        long j3 = this.f3477k;
        this.f3467a.mo441f(j, z ? 1 : 0, (int) (j2 - j3), i, null);
    }

    /* renamed from: a */
    public final void m5779a(long j, int i, boolean z) {
        if (this.f3476j && this.f3473g) {
            this.f3479m = this.f3469c;
            this.f3476j = false;
        } else if (this.f3474h || this.f3473g) {
            if (z && this.f3475i) {
                m5775e(i + ((int) (j - this.f3468b)));
            }
            this.f3477k = this.f3468b;
            this.f3478l = this.f3471e;
            this.f3479m = this.f3469c;
            this.f3475i = true;
        }
    }

    /* renamed from: b */
    public final void m5778b(byte[] bArr, int i, int i2) {
        if (this.f3472f) {
            int i3 = this.f3470d;
            int i4 = (i + 2) - i3;
            if (i4 >= i2) {
                this.f3470d = i3 + (i2 - i);
                return;
            }
            this.f3473g = (bArr[i4] & 128) != 0;
            this.f3472f = false;
        }
    }

    /* renamed from: c */
    public final void m5777c() {
        this.f3472f = false;
        this.f3473g = false;
        this.f3474h = false;
        this.f3475i = false;
        this.f3476j = false;
    }

    /* renamed from: d */
    public final void m5776d(long j, int i, int i2, long j2, boolean z) {
        boolean z2 = false;
        this.f3473g = false;
        this.f3474h = false;
        this.f3471e = j2;
        this.f3470d = 0;
        this.f3468b = j;
        if (i2 >= 32 && i2 != 40) {
            if (this.f3475i && !this.f3476j) {
                if (z) {
                    m5775e(i);
                }
                this.f3475i = false;
            }
            if (i2 <= 35 || i2 == 39) {
                this.f3474h = !this.f3476j;
                this.f3476j = true;
            }
        }
        boolean z3 = i2 >= 16 && i2 <= 21;
        this.f3469c = z3;
        this.f3472f = (z3 || i2 <= 9) ? true : true;
    }
}
