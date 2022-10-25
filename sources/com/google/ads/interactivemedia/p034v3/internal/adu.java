package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adu */
/* loaded from: classes2.dex */
final class adu {

    /* renamed from: a */
    public byte[] f3533a;

    /* renamed from: b */
    public int f3534b;

    /* renamed from: c */
    private final int f3535c;

    /* renamed from: d */
    private boolean f3536d;

    /* renamed from: e */
    private boolean f3537e;

    public adu(int i) {
        this.f3535c = i;
        byte[] bArr = new byte[131];
        this.f3533a = bArr;
        bArr[2] = 1;
    }

    /* renamed from: a */
    public final void m5766a(byte[] bArr, int i, int i2) {
        if (this.f3536d) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f3533a;
            int length = bArr2.length;
            int i4 = this.f3534b + i3;
            if (length < i4) {
                this.f3533a = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.f3533a, this.f3534b, i3);
            this.f3534b += i3;
        }
    }

    /* renamed from: b */
    public final void m5765b() {
        this.f3536d = false;
        this.f3537e = false;
    }

    /* renamed from: c */
    public final void m5764c(int i) {
        C2616ce.m2685h(!this.f3536d);
        boolean z = i == this.f3535c;
        this.f3536d = z;
        if (z) {
            this.f3534b = 3;
            this.f3537e = false;
        }
    }

    /* renamed from: d */
    public final boolean m5763d(int i) {
        if (this.f3536d) {
            this.f3534b -= i;
            this.f3536d = false;
            this.f3537e = true;
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m5762e() {
        return this.f3537e;
    }
}
