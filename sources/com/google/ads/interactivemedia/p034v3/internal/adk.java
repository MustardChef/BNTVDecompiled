package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adk */
/* loaded from: classes2.dex */
final class adk {

    /* renamed from: a */
    private final InterfaceC3253zu f3398a;

    /* renamed from: b */
    private boolean f3399b;

    /* renamed from: c */
    private boolean f3400c;

    /* renamed from: d */
    private boolean f3401d;

    /* renamed from: e */
    private int f3402e;

    /* renamed from: f */
    private int f3403f;

    /* renamed from: g */
    private long f3404g;

    /* renamed from: h */
    private long f3405h;

    public adk(InterfaceC3253zu interfaceC3253zu) {
        this.f3398a = interfaceC3253zu;
    }

    /* renamed from: a */
    public final void m5796a(byte[] bArr, int i, int i2) {
        if (this.f3400c) {
            int i3 = this.f3403f;
            int i4 = (i + 1) - i3;
            if (i4 >= i2) {
                this.f3403f = i3 + (i2 - i);
                return;
            }
            this.f3401d = ((bArr[i4] & 192) >> 6) == 0;
            this.f3400c = false;
        }
    }

    /* renamed from: b */
    public final void m5795b(long j, int i, boolean z) {
        if (this.f3402e == 182 && z && this.f3399b) {
            long j2 = this.f3405h;
            if (j2 != C3282C.TIME_UNSET) {
                long j3 = this.f3404g;
                this.f3398a.mo441f(j2, this.f3401d ? 1 : 0, (int) (j - j3), i, null);
            }
        }
        if (this.f3402e != 179) {
            this.f3404g = j;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5794c(int r5, long r6) {
        /*
            r4 = this;
            r4.f3402e = r5
            r0 = 0
            r4.f3401d = r0
            r1 = 179(0xb3, float:2.51E-43)
            r2 = 182(0xb6, float:2.55E-43)
            r3 = 1
            if (r5 == r2) goto L13
            if (r5 != r1) goto L11
            r5 = 179(0xb3, float:2.51E-43)
            goto L13
        L11:
            r1 = 0
            goto L14
        L13:
            r1 = 1
        L14:
            r4.f3399b = r1
            if (r5 != r2) goto L19
            goto L1a
        L19:
            r3 = 0
        L1a:
            r4.f3400c = r3
            r4.f3403f = r0
            r4.f3405h = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.adk.m5794c(int, long):void");
    }

    /* renamed from: d */
    public final void m5793d() {
        this.f3399b = false;
        this.f3400c = false;
        this.f3401d = false;
        this.f3402e = -1;
    }
}
