package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kc */
/* loaded from: classes2.dex */
public final class C2830kc extends AbstractC2813jm {

    /* renamed from: d */
    private int f7796d;

    /* renamed from: e */
    private boolean f7797e;

    /* renamed from: f */
    private byte[] f7798f;

    /* renamed from: g */
    private byte[] f7799g;

    /* renamed from: h */
    private int f7800h;

    /* renamed from: i */
    private int f7801i;

    /* renamed from: j */
    private int f7802j;

    /* renamed from: k */
    private boolean f7803k;

    /* renamed from: l */
    private long f7804l;

    public C2830kc() {
        C2616ce.m2687f(true);
        this.f7798f = C2628cq.f6966f;
        this.f7799g = C2628cq.f6966f;
    }

    /* renamed from: q */
    private final int m1826q(long j) {
        return (int) ((j * this.f7692b.f7613b) / 1000000);
    }

    /* renamed from: r */
    private final int m1825r(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > 1024) {
                int i = this.f7796d;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    /* renamed from: s */
    private final void m1824s(byte[] bArr, int i) {
        m1916j(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f7803k = true;
        }
    }

    /* renamed from: t */
    private final void m1823t(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.f7802j);
        int i2 = this.f7802j - min;
        System.arraycopy(bArr, i - i2, this.f7799g, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f7799g, i2, min);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: e */
    public final void mo1801e(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !m1915n()) {
            int i = this.f7800h;
            if (i == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f7798f.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.getShort(limit2)) > 1024) {
                            int i2 = this.f7796d;
                            position = ((limit2 / i2) * i2) + i2;
                            break;
                        }
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.f7800h = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    m1916j(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.f7803k = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i == 1) {
                int limit3 = byteBuffer.limit();
                int m1825r = m1825r(byteBuffer);
                int position2 = m1825r - byteBuffer.position();
                byte[] bArr = this.f7798f;
                int length = bArr.length;
                int i3 = this.f7801i;
                int i4 = length - i3;
                if (m1825r >= limit3 || position2 >= i4) {
                    int min = Math.min(position2, i4);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.f7798f, this.f7801i, min);
                    int i5 = this.f7801i + min;
                    this.f7801i = i5;
                    byte[] bArr2 = this.f7798f;
                    if (i5 == bArr2.length) {
                        if (this.f7803k) {
                            m1824s(bArr2, this.f7802j);
                            long j = this.f7804l;
                            int i6 = this.f7801i;
                            int i7 = this.f7802j;
                            this.f7804l = j + ((i6 - (i7 + i7)) / this.f7796d);
                            i5 = i6;
                        } else {
                            this.f7804l += (i5 - this.f7802j) / this.f7796d;
                        }
                        m1823t(byteBuffer, this.f7798f, i5);
                        this.f7801i = 0;
                        this.f7800h = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    m1824s(bArr, i3);
                    this.f7801i = 0;
                    this.f7800h = 0;
                }
            } else {
                int limit4 = byteBuffer.limit();
                int m1825r2 = m1825r(byteBuffer);
                byteBuffer.limit(m1825r2);
                this.f7804l += byteBuffer.remaining() / this.f7796d;
                m1823t(byteBuffer, this.f7799g, this.f7802j);
                if (m1825r2 < limit4) {
                    m1824s(this.f7799g, this.f7802j);
                    this.f7800h = 0;
                    byteBuffer.limit(limit4);
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: g */
    public final boolean mo1806g() {
        return this.f7797e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: i */
    public final C2789ip mo1799i(C2789ip c2789ip) throws C2790iq {
        if (c2789ip.f7615d == 2) {
            return this.f7797e ? c2789ip : C2789ip.f7612a;
        }
        throw new C2790iq(c2789ip);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: k */
    protected final void mo1798k() {
        if (this.f7797e) {
            this.f7796d = this.f7692b.f7616e;
            int m1826q = m1826q(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) * this.f7796d;
            if (this.f7798f.length != m1826q) {
                this.f7798f = new byte[m1826q];
            }
            int m1826q2 = m1826q(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) * this.f7796d;
            this.f7802j = m1826q2;
            if (this.f7799g.length != m1826q2) {
                this.f7799g = new byte[m1826q2];
            }
        }
        this.f7800h = 0;
        this.f7804l = 0L;
        this.f7801i = 0;
        this.f7803k = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: l */
    protected final void mo1797l() {
        int i = this.f7801i;
        if (i > 0) {
            m1824s(this.f7798f, i);
        }
        if (this.f7803k) {
            return;
        }
        this.f7804l += this.f7802j / this.f7796d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2813jm
    /* renamed from: m */
    protected final void mo1796m() {
        this.f7797e = false;
        this.f7802j = 0;
        this.f7798f = C2628cq.f6966f;
        this.f7799g = C2628cq.f6966f;
    }

    /* renamed from: o */
    public final long m1828o() {
        return this.f7804l;
    }

    /* renamed from: p */
    public final void m1827p(boolean z) {
        this.f7797e = z;
    }
}
