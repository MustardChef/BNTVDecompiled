package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kf */
/* loaded from: classes2.dex */
public final class C2833kf extends AbstractC2813jm {

    /* renamed from: d */
    private int f7842d;

    /* renamed from: e */
    private int f7843e;

    /* renamed from: f */
    private boolean f7844f;

    /* renamed from: g */
    private int f7845g;

    /* renamed from: h */
    private byte[] f7846h = C2628cq.f6966f;

    /* renamed from: i */
    private int f7847i;

    /* renamed from: j */
    private long f7848j;

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: b */
    public final ByteBuffer mo1802b() {
        int i;
        if (super.mo1800h() && (i = this.f7847i) > 0) {
            m1916j(i).put(this.f7846h, 0, this.f7847i).flip();
            this.f7847i = 0;
        }
        return super.mo1802b();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: e */
    public final void mo1801e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.f7845g);
        this.f7848j += min / this.f7692b.f7616e;
        this.f7845g -= min;
        byteBuffer.position(position + min);
        if (this.f7845g > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.f7847i + i2) - this.f7846h.length;
        ByteBuffer m1916j = m1916j(length);
        int m2531c = C2628cq.m2531c(length, 0, this.f7847i);
        m1916j.put(this.f7846h, 0, m2531c);
        int m2531c2 = C2628cq.m2531c(length - m2531c, 0, i2);
        byteBuffer.limit(byteBuffer.position() + m2531c2);
        m1916j.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - m2531c2;
        int i4 = this.f7847i - m2531c;
        this.f7847i = i4;
        byte[] bArr = this.f7846h;
        System.arraycopy(bArr, m2531c, bArr, 0, i4);
        byteBuffer.get(this.f7846h, this.f7847i, i3);
        this.f7847i += i3;
        m1916j.flip();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: h */
    public final boolean mo1800h() {
        return super.mo1800h() && this.f7847i == 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: i */
    public final C2789ip mo1799i(C2789ip c2789ip) throws C2790iq {
        if (c2789ip.f7615d == 2) {
            this.f7844f = true;
            return (this.f7842d == 0 && this.f7843e == 0) ? C2789ip.f7612a : c2789ip;
        }
        throw new C2790iq(c2789ip);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: k */
    protected final void mo1798k() {
        if (this.f7844f) {
            this.f7844f = false;
            int i = this.f7843e;
            int i2 = this.f7692b.f7616e;
            this.f7846h = new byte[i * i2];
            this.f7845g = this.f7842d * i2;
        }
        this.f7847i = 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: l */
    protected final void mo1797l() {
        int i;
        if (this.f7844f) {
            if (this.f7847i > 0) {
                this.f7848j += i / this.f7692b.f7616e;
            }
            this.f7847i = 0;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: m */
    protected final void mo1796m() {
        this.f7846h = C2628cq.f6966f;
    }

    /* renamed from: o */
    public final long m1795o() {
        return this.f7848j;
    }

    /* renamed from: p */
    public final void m1794p() {
        this.f7848j = 0L;
    }

    /* renamed from: q */
    public final void m1793q(int i, int i2) {
        this.f7842d = i;
        this.f7843e = i2;
    }
}
