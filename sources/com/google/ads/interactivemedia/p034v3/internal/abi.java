package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abi */
/* loaded from: classes2.dex */
final class abi {

    /* renamed from: a */
    private static final long[] f3066a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f3067b = new byte[8];

    /* renamed from: c */
    private int f3068c;

    /* renamed from: d */
    private int f3069d;

    /* renamed from: b */
    public static int m5909b(int i) {
        int i2 = 0;
        while (i2 < 8) {
            int i3 = ((f3066a[i2] & i) > 0L ? 1 : ((f3066a[i2] & i) == 0L ? 0 : -1));
            i2++;
            if (i3 != 0) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public static long m5908c(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= ~f3066a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    /* renamed from: a */
    public final int m5910a() {
        return this.f3069d;
    }

    /* renamed from: d */
    public final long m5907d(InterfaceC3230yy interfaceC3230yy, boolean z, boolean z2, int i) throws IOException {
        if (this.f3068c == 0) {
            if (!interfaceC3230yy.mo491l(this.f3067b, 0, 1, z)) {
                return -1L;
            }
            int m5909b = m5909b(this.f3067b[0] & 255);
            this.f3069d = m5909b;
            if (m5909b != -1) {
                this.f3068c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.f3069d;
        if (i2 > i) {
            this.f3068c = 0;
            return -2L;
        }
        if (i2 != 1) {
            interfaceC3230yy.mo495g(this.f3067b, 1, i2 - 1);
        }
        this.f3068c = 0;
        return m5908c(this.f3067b, this.f3069d, z2);
    }

    /* renamed from: e */
    public final void m5906e() {
        this.f3068c = 0;
        this.f3069d = 0;
    }
}
