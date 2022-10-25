package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.so */
/* loaded from: classes2.dex */
final class C3058so implements InterfaceC2637cz {

    /* renamed from: a */
    private final InterfaceC2637cz f8847a;

    /* renamed from: b */
    private final int f8848b;

    /* renamed from: c */
    private final InterfaceC3057sn f8849c;

    /* renamed from: d */
    private final byte[] f8850d;

    /* renamed from: e */
    private int f8851e;

    public C3058so(InterfaceC2637cz interfaceC2637cz, int i, InterfaceC3057sn interfaceC3057sn) {
        C2616ce.m2687f(i > 0);
        this.f8847a = interfaceC2637cz;
        this.f8848b = i;
        this.f8849c = interfaceC3057sn;
        this.f8850d = new byte[1];
        this.f8851e = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f8851e;
        if (i3 == 0) {
            int i4 = 0;
            if (this.f8847a.mo501a(this.f8850d, 0, 1) != -1) {
                int i5 = (this.f8850d[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int a = this.f8847a.mo501a(bArr2, i4, i6);
                        if (a != -1) {
                            i4 += a;
                            i6 -= a;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.f8849c.mo1058a(new C2621cj(bArr2, i5));
                    }
                }
                i3 = this.f8848b;
                this.f8851e = i3;
            }
            return -1;
        }
        int a2 = this.f8847a.mo501a(bArr, i, Math.min(i3, i2));
        if (a2 != -1) {
            this.f8851e -= a2;
        }
        return a2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f8847a.mo1126c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public final Map mo1124e() {
        return this.f8847a.mo1124e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: f */
    public final void mo1123f(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2689d(interfaceC2659du);
        this.f8847a.mo1123f(interfaceC2659du);
    }
}
