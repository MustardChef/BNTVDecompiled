package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zv */
/* loaded from: classes2.dex */
public final class C3254zv {

    /* renamed from: a */
    private final byte[] f9622a = new byte[10];

    /* renamed from: b */
    private boolean f9623b;

    /* renamed from: c */
    private int f9624c;

    /* renamed from: d */
    private long f9625d;

    /* renamed from: e */
    private int f9626e;

    /* renamed from: f */
    private int f9627f;

    /* renamed from: g */
    private int f9628g;

    /* renamed from: a */
    public final void m438a(InterfaceC3253zu interfaceC3253zu, C3252zt c3252zt) {
        if (this.f9624c > 0) {
            interfaceC3253zu.mo441f(this.f9625d, this.f9626e, this.f9627f, this.f9628g, c3252zt);
            this.f9624c = 0;
        }
    }

    /* renamed from: b */
    public final void m437b() {
        this.f9623b = false;
        this.f9624c = 0;
    }

    /* renamed from: c */
    public final void m436c(InterfaceC3253zu interfaceC3253zu, long j, int i, int i2, int i3, C3252zt c3252zt) {
        C2616ce.m2684i(this.f9628g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f9623b) {
            int i4 = this.f9624c;
            int i5 = i4 + 1;
            this.f9624c = i5;
            if (i4 == 0) {
                this.f9625d = j;
                this.f9626e = i;
                this.f9627f = 0;
            }
            this.f9627f += i2;
            this.f9628g = i3;
            if (i5 >= 16) {
                m438a(interfaceC3253zu, c3252zt);
            }
        }
    }

    /* renamed from: d */
    public final void m435d(InterfaceC3230yy interfaceC3230yy) throws IOException {
        if (this.f9623b) {
            return;
        }
        interfaceC3230yy.mo496f(this.f9622a, 0, 10);
        interfaceC3230yy.mo494h();
        byte[] bArr = this.f9622a;
        int i = C3210ye.f9476a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.f9623b = true;
        }
    }
}
