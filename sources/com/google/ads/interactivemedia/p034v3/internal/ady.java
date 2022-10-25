package com.google.ads.interactivemedia.p034v3.internal;

import androidx.core.view.InputDeviceCompat;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ady */
/* loaded from: classes2.dex */
public final class ady implements aek {

    /* renamed from: a */
    private final adx f3553a;

    /* renamed from: b */
    private final C2621cj f3554b = new C2621cj(32);

    /* renamed from: c */
    private int f3555c;

    /* renamed from: d */
    private int f3556d;

    /* renamed from: e */
    private boolean f3557e;

    /* renamed from: f */
    private boolean f3558f;

    public ady(adx adxVar) {
        this.f3553a = adxVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: a */
    public final void mo5727a(C2621cj c2621cj, int i) {
        int i2 = i & 1;
        int m2639c = i2 != 0 ? c2621cj.m2639c() + c2621cj.m2633i() : -1;
        if (this.f3558f) {
            if (i2 == 0) {
                return;
            }
            this.f3558f = false;
            c2621cj.m2644F(m2639c);
            this.f3556d = 0;
        }
        while (c2621cj.m2641a() > 0) {
            int i3 = this.f3556d;
            if (i3 < 3) {
                if (i3 == 0) {
                    int m2633i = c2621cj.m2633i();
                    c2621cj.m2644F(c2621cj.m2639c() - 1);
                    if (m2633i == 255) {
                        this.f3558f = true;
                        return;
                    }
                }
                int min = Math.min(c2621cj.m2641a(), 3 - this.f3556d);
                c2621cj.m2649A(this.f3554b.m2642H(), this.f3556d, min);
                int i4 = this.f3556d + min;
                this.f3556d = i4;
                if (i4 == 3) {
                    this.f3554b.m2644F(0);
                    this.f3554b.m2645E(3);
                    this.f3554b.m2643G(1);
                    int m2633i2 = this.f3554b.m2633i();
                    int m2633i3 = this.f3554b.m2633i();
                    this.f3557e = (m2633i2 & 128) != 0;
                    this.f3555c = (((m2633i2 & 15) << 8) | m2633i3) + 3;
                    int m2640b = this.f3554b.m2640b();
                    int i5 = this.f3555c;
                    if (m2640b < i5) {
                        int m2640b2 = this.f3554b.m2640b();
                        this.f3554b.m2617y(Math.min((int) InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, m2640b2 + m2640b2)));
                    }
                }
            } else {
                int min2 = Math.min(c2621cj.m2641a(), this.f3555c - i3);
                c2621cj.m2649A(this.f3554b.m2642H(), this.f3556d, min2);
                int i6 = this.f3556d + min2;
                this.f3556d = i6;
                int i7 = this.f3555c;
                if (i6 != i7) {
                    continue;
                } else {
                    if (this.f3557e) {
                        if (C2628cq.m2539aq(this.f3554b.m2642H(), i7) != 0) {
                            this.f3558f = true;
                            return;
                        }
                        this.f3554b.m2645E(this.f3555c - 4);
                    } else {
                        this.f3554b.m2645E(i7);
                    }
                    this.f3554b.m2644F(0);
                    this.f3553a.mo5751a(this.f3554b);
                    this.f3556d = 0;
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: b */
    public final void mo5726b(C2626co c2626co, InterfaceC3233za interfaceC3233za, aej aejVar) {
        this.f3553a.mo5750b(c2626co, interfaceC3233za, aejVar);
        this.f3558f = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aek
    /* renamed from: c */
    public final void mo5725c() {
        this.f3558f = true;
    }
}
