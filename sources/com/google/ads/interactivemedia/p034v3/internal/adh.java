package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adh */
/* loaded from: classes2.dex */
final class adh {

    /* renamed from: d */
    private static final byte[] f3370d = {0, 0, 1};

    /* renamed from: a */
    public int f3371a;

    /* renamed from: b */
    public int f3372b;

    /* renamed from: c */
    public byte[] f3373c = new byte[128];

    /* renamed from: e */
    private boolean f3374e;

    /* renamed from: a */
    public final void m5802a(byte[] bArr, int i, int i2) {
        if (this.f3374e) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f3373c;
            int length = bArr2.length;
            int i4 = this.f3371a + i3;
            if (length < i4) {
                this.f3373c = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.f3373c, this.f3371a, i3);
            this.f3371a += i3;
        }
    }

    /* renamed from: b */
    public final void m5801b() {
        this.f3374e = false;
        this.f3371a = 0;
        this.f3372b = 0;
    }

    /* renamed from: c */
    public final boolean m5800c(int i, int i2) {
        if (this.f3374e) {
            int i3 = this.f3371a - i2;
            this.f3371a = i3;
            if (this.f3372b != 0 || i != 181) {
                this.f3374e = false;
                return true;
            }
            this.f3372b = i3;
        } else if (i == 179) {
            this.f3374e = true;
        }
        m5802a(f3370d, 0, 3);
        return false;
    }
}
