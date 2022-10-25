package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abh */
/* loaded from: classes2.dex */
final class abh {

    /* renamed from: a */
    private final C2621cj f3064a = new C2621cj(8);

    /* renamed from: b */
    private int f3065b;

    /* renamed from: b */
    private final long m5911b(InterfaceC3230yy interfaceC3230yy) throws IOException {
        int i = 0;
        interfaceC3230yy.mo496f(this.f3064a.m2642H(), 0, 1);
        int i2 = this.f3064a.m2642H()[0] & 255;
        if (i2 != 0) {
            int i3 = 128;
            int i4 = 0;
            while ((i2 & i3) == 0) {
                i3 >>= 1;
                i4++;
            }
            int i5 = i2 & (~i3);
            interfaceC3230yy.mo496f(this.f3064a.m2642H(), 1, i4);
            while (i < i4) {
                i++;
                i5 = (this.f3064a.m2642H()[i] & 255) + (i5 << 8);
            }
            this.f3065b += i4 + 1;
            return i5;
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: a */
    public final boolean m5912a(InterfaceC3230yy interfaceC3230yy) throws IOException {
        long m5911b;
        int i;
        long mo500b = interfaceC3230yy.mo500b();
        long j = 1024;
        int i2 = (mo500b > (-1L) ? 1 : (mo500b == (-1L) ? 0 : -1));
        if (i2 != 0 && mo500b <= 1024) {
            j = mo500b;
        }
        int i3 = (int) j;
        interfaceC3230yy.mo496f(this.f3064a.m2642H(), 0, 4);
        long m2626p = this.f3064a.m2626p();
        this.f3065b = 4;
        while (m2626p != 440786851) {
            int i4 = this.f3065b + 1;
            this.f3065b = i4;
            if (i4 == i3) {
                return false;
            }
            interfaceC3230yy.mo496f(this.f3064a.m2642H(), 0, 1);
            m2626p = ((m2626p << 8) & (-256)) | (this.f3064a.m2642H()[0] & 255);
        }
        long m5911b2 = m5911b(interfaceC3230yy);
        long j2 = this.f3065b;
        if (m5911b2 != Long.MIN_VALUE && (i2 == 0 || j2 + m5911b2 < mo500b)) {
            while (true) {
                int i5 = (this.f3065b > (j2 + m5911b2) ? 1 : (this.f3065b == (j2 + m5911b2) ? 0 : -1));
                if (i5 < 0) {
                    if (m5911b(interfaceC3230yy) == Long.MIN_VALUE || (m5911b = m5911b(interfaceC3230yy)) < 0) {
                        return false;
                    }
                    if (i != 0) {
                        int i6 = (int) m5911b;
                        interfaceC3230yy.mo497e(i6);
                        this.f3065b += i6;
                    }
                } else if (i5 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
