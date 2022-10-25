package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jn */
/* loaded from: classes2.dex */
final class C2814jn extends AbstractC2813jm {

    /* renamed from: d */
    private int[] f7699d;

    /* renamed from: e */
    private int[] f7700e;

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: e */
    public final void mo1801e(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) C2616ce.m2689d(this.f7700e);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer m1916j = m1916j(((limit - position) / this.f7692b.f7616e) * this.f7693c.f7616e);
        while (position < limit) {
            for (int i : iArr) {
                m1916j.putShort(byteBuffer.getShort(i + i + position));
            }
            position += this.f7692b.f7616e;
        }
        byteBuffer.position(limit);
        m1916j.flip();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: i */
    public final C2789ip mo1799i(C2789ip c2789ip) throws C2790iq {
        int[] iArr = this.f7699d;
        if (iArr == null) {
            return C2789ip.f7612a;
        }
        if (c2789ip.f7615d != 2) {
            throw new C2790iq(c2789ip);
        }
        boolean z = c2789ip.f7614c != iArr.length;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= length) {
                return z ? new C2789ip(c2789ip.f7613b, length, 2) : C2789ip.f7612a;
            }
            int i2 = iArr[i];
            if (i2 >= c2789ip.f7614c) {
                throw new C2790iq(c2789ip);
            }
            z |= i2 != i;
            i++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: k */
    protected final void mo1798k() {
        this.f7700e = this.f7699d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: m */
    protected final void mo1796m() {
        this.f7700e = null;
        this.f7699d = null;
    }

    /* renamed from: o */
    public final void m1914o(int[] iArr) {
        this.f7699d = iArr;
    }
}
