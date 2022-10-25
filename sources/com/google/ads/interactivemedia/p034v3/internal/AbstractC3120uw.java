package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.uw */
/* loaded from: classes2.dex */
public abstract class AbstractC3120uw extends AbstractC3112uo {

    /* renamed from: a */
    private byte[] f9140a;

    /* renamed from: b */
    private volatile boolean f9141b;

    public AbstractC3120uw(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd, C2962p c2962p, int i, byte[] bArr) {
        super(interfaceC2637cz, c2642dd, 3, c2962p, i, C3282C.TIME_UNSET, C3282C.TIME_UNSET);
        this.f9140a = bArr == null ? C2628cq.f6966f : bArr;
    }

    /* renamed from: a */
    protected abstract void mo856a(byte[] bArr, int i) throws IOException;

    /* renamed from: c */
    public final byte[] m855c() {
        return this.f9140a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    public final void mo701e() throws IOException {
        try {
            this.f9103n.mo1127b(this.f9096g);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.f9141b) {
                byte[] bArr = this.f9140a;
                int length = bArr.length;
                if (length < i2 + 16384) {
                    this.f9140a = Arrays.copyOf(bArr, length + 16384);
                }
                i = this.f9103n.mo501a(this.f9140a, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.f9141b) {
                mo856a(this.f9140a, i2);
            }
        } finally {
            C2616ce.m2682k(this.f9103n);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
        this.f9141b = true;
    }
}
