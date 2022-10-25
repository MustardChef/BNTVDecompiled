package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zg */
/* loaded from: classes2.dex */
public final class C3239zg {

    /* renamed from: a */
    private final C2621cj f9562a = new C2621cj(10);

    /* renamed from: a */
    public final C2549ak m481a(InterfaceC3230yy interfaceC3230yy, aan aanVar) throws IOException {
        C2549ak c2549ak = null;
        int i = 0;
        while (true) {
            try {
                interfaceC3230yy.mo496f(this.f9562a.m2642H(), 0, 10);
                this.f9562a.m2644F(0);
                if (this.f9562a.m2631k() != 4801587) {
                    break;
                }
                this.f9562a.m2643G(3);
                int m2634h = this.f9562a.m2634h();
                int i2 = m2634h + 10;
                if (c2549ak == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f9562a.m2642H(), 0, bArr, 0, 10);
                    interfaceC3230yy.mo496f(bArr, 10, m2634h);
                    c2549ak = new aap(aanVar).m5975c(bArr, i2);
                } else {
                    interfaceC3230yy.mo497e(m2634h);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        interfaceC3230yy.mo494h();
        interfaceC3230yy.mo497e(i);
        return c2549ak;
    }
}
