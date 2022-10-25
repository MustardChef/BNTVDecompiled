package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jy */
/* loaded from: classes2.dex */
public final class C2825jy extends AbstractC2813jm {

    /* renamed from: d */
    private static final int f7778d = Float.floatToIntBits(Float.NaN);

    /* renamed from: o */
    private static void m1843o(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == f7778d) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: e */
    public final void mo1801e(ByteBuffer byteBuffer) {
        ByteBuffer m1916j;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.f7692b.f7615d;
        if (i2 == 536870912) {
            m1916j = m1916j((i / 3) * 4);
            while (position < limit) {
                m1843o(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), m1916j);
                position += 3;
            }
        } else if (i2 == 805306368) {
            m1916j = m1916j(i);
            while (position < limit) {
                m1843o((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), m1916j);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        m1916j.flip();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: i */
    public final C2789ip mo1799i(C2789ip c2789ip) throws C2790iq {
        int i = c2789ip.f7615d;
        if (C2628cq.m2561V(i)) {
            return i != 4 ? new C2789ip(c2789ip.f7613b, c2789ip.f7614c, 4) : C2789ip.f7612a;
        }
        throw new C2790iq(c2789ip);
    }
}
