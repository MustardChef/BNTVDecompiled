package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qu */
/* loaded from: classes2.dex */
final class C3010qu extends C2669ed {

    /* renamed from: f */
    private long f8659f;

    /* renamed from: g */
    private int f8660g;

    /* renamed from: h */
    private int f8661h;

    public C3010qu() {
        super(2);
        this.f8661h = 32;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2669ed, com.google.ads.interactivemedia.p034v3.internal.C2662dx
    /* renamed from: b */
    public final void mo1278b() {
        super.mo1278b();
        this.f8660g = 0;
    }

    /* renamed from: o */
    public final int m1277o() {
        return this.f8660g;
    }

    /* renamed from: p */
    public final long m1276p() {
        return this.f8659f;
    }

    /* renamed from: q */
    public final void m1275q(int i) {
        C2616ce.m2687f(true);
        this.f8661h = i;
    }

    /* renamed from: r */
    public final boolean m1274r(C2669ed c2669ed) {
        ByteBuffer byteBuffer;
        C2616ce.m2687f(!c2669ed.m2446n());
        C2616ce.m2687f(!c2669ed.m2464e());
        C2616ce.m2687f(!c2669ed.m2462g());
        if (m1273s()) {
            if (this.f8660g >= this.f8661h || c2669ed.m2463f() != m2463f()) {
                return false;
            }
            ByteBuffer byteBuffer2 = c2669ed.f7092b;
            if (byteBuffer2 != null && (byteBuffer = this.f7092b) != null && byteBuffer.position() + byteBuffer2.remaining() > 3072000) {
                return false;
            }
        }
        int i = this.f8660g;
        this.f8660g = i + 1;
        if (i == 0) {
            this.f7094d = c2669ed.f7094d;
            if (c2669ed.m2461h()) {
                m2466c(1);
            }
        }
        if (c2669ed.m2463f()) {
            m2466c(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = c2669ed.f7092b;
        if (byteBuffer3 != null) {
            m2448l(byteBuffer3.remaining());
            this.f7092b.put(byteBuffer3);
        }
        this.f8659f = c2669ed.f7094d;
        return true;
    }

    /* renamed from: s */
    public final boolean m1273s() {
        return this.f8660g > 0;
    }
}
