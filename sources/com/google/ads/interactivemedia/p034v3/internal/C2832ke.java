package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ke */
/* loaded from: classes2.dex */
public final class C2832ke implements InterfaceC2791ir {

    /* renamed from: b */
    private int f7827b;

    /* renamed from: c */
    private float f7828c = 1.0f;

    /* renamed from: d */
    private float f7829d = 1.0f;

    /* renamed from: e */
    private C2789ip f7830e = C2789ip.f7612a;

    /* renamed from: f */
    private C2789ip f7831f = C2789ip.f7612a;

    /* renamed from: g */
    private C2789ip f7832g = C2789ip.f7612a;

    /* renamed from: h */
    private C2789ip f7833h = C2789ip.f7612a;

    /* renamed from: i */
    private boolean f7834i;

    /* renamed from: j */
    private C2831kd f7835j;

    /* renamed from: k */
    private ByteBuffer f7836k;

    /* renamed from: l */
    private ShortBuffer f7837l;

    /* renamed from: m */
    private ByteBuffer f7838m;

    /* renamed from: n */
    private long f7839n;

    /* renamed from: o */
    private long f7840o;

    /* renamed from: p */
    private boolean f7841p;

    public C2832ke() {
        ByteBuffer byteBuffer = f7617a;
        this.f7836k = byteBuffer;
        this.f7837l = byteBuffer.asShortBuffer();
        this.f7838m = f7617a;
        this.f7827b = -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: a */
    public final C2789ip mo1810a(C2789ip c2789ip) throws C2790iq {
        if (c2789ip.f7615d == 2) {
            int i = this.f7827b;
            if (i == -1) {
                i = c2789ip.f7613b;
            }
            this.f7830e = c2789ip;
            C2789ip c2789ip2 = new C2789ip(i, c2789ip.f7614c, 2);
            this.f7831f = c2789ip2;
            this.f7834i = true;
            return c2789ip2;
        }
        throw new C2790iq(c2789ip);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: b */
    public final ByteBuffer mo1802b() {
        int m1822a;
        C2831kd c2831kd = this.f7835j;
        if (c2831kd != null && (m1822a = c2831kd.m1822a()) > 0) {
            if (this.f7836k.capacity() < m1822a) {
                ByteBuffer order = ByteBuffer.allocateDirect(m1822a).order(ByteOrder.nativeOrder());
                this.f7836k = order;
                this.f7837l = order.asShortBuffer();
            } else {
                this.f7836k.clear();
                this.f7837l.clear();
            }
            c2831kd.m1819d(this.f7837l);
            this.f7840o += m1822a;
            this.f7836k.limit(m1822a);
            this.f7838m = this.f7836k;
        }
        ByteBuffer byteBuffer = this.f7838m;
        this.f7838m = f7617a;
        return byteBuffer;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: c */
    public final void mo1809c() {
        if (mo1806g()) {
            C2789ip c2789ip = this.f7830e;
            this.f7832g = c2789ip;
            this.f7833h = this.f7831f;
            if (this.f7834i) {
                this.f7835j = new C2831kd(c2789ip.f7613b, c2789ip.f7614c, this.f7828c, this.f7829d, this.f7833h.f7613b);
            } else {
                C2831kd c2831kd = this.f7835j;
                if (c2831kd != null) {
                    c2831kd.m1820c();
                }
            }
        }
        this.f7838m = f7617a;
        this.f7839n = 0L;
        this.f7840o = 0L;
        this.f7841p = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: d */
    public final void mo1808d() {
        C2831kd c2831kd = this.f7835j;
        if (c2831kd != null) {
            c2831kd.m1818e();
        }
        this.f7841p = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: e */
    public final void mo1801e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            C2831kd c2831kd = this.f7835j;
            C2616ce.m2689d(c2831kd);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f7839n += remaining;
            c2831kd.m1817f(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: f */
    public final void mo1807f() {
        this.f7828c = 1.0f;
        this.f7829d = 1.0f;
        this.f7830e = C2789ip.f7612a;
        this.f7831f = C2789ip.f7612a;
        this.f7832g = C2789ip.f7612a;
        this.f7833h = C2789ip.f7612a;
        ByteBuffer byteBuffer = f7617a;
        this.f7836k = byteBuffer;
        this.f7837l = byteBuffer.asShortBuffer();
        this.f7838m = f7617a;
        this.f7827b = -1;
        this.f7834i = false;
        this.f7835j = null;
        this.f7839n = 0L;
        this.f7840o = 0L;
        this.f7841p = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: g */
    public final boolean mo1806g() {
        if (this.f7831f.f7613b != -1) {
            return Math.abs(this.f7828c + (-1.0f)) >= 1.0E-4f || Math.abs(this.f7829d + (-1.0f)) >= 1.0E-4f || this.f7831f.f7613b != this.f7830e.f7613b;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: h */
    public final boolean mo1800h() {
        C2831kd c2831kd;
        return this.f7841p && ((c2831kd = this.f7835j) == null || c2831kd.m1822a() == 0);
    }

    /* renamed from: i */
    public final long m1805i(long j) {
        if (this.f7840o >= 1024) {
            long j2 = this.f7839n;
            C2831kd c2831kd = this.f7835j;
            C2616ce.m2689d(c2831kd);
            long m1821b = j2 - c2831kd.m1821b();
            int i = this.f7833h.f7613b;
            int i2 = this.f7832g.f7613b;
            if (i == i2) {
                return C2628cq.m2512v(j, m1821b, this.f7840o);
            }
            return C2628cq.m2512v(j, m1821b * i, this.f7840o * i2);
        }
        return (long) (this.f7828c * j);
    }

    /* renamed from: j */
    public final void m1804j(float f) {
        if (this.f7829d != f) {
            this.f7829d = f;
            this.f7834i = true;
        }
    }

    /* renamed from: k */
    public final void m1803k(float f) {
        if (this.f7828c != f) {
            this.f7828c = f;
            this.f7834i = true;
        }
    }
}
