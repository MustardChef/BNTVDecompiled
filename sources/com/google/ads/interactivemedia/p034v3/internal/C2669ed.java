package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ed */
/* loaded from: classes2.dex */
public class C2669ed extends C2662dx {

    /* renamed from: a */
    public final C2666ea f7091a;

    /* renamed from: b */
    public ByteBuffer f7092b;

    /* renamed from: c */
    public boolean f7093c;

    /* renamed from: d */
    public long f7094d;

    /* renamed from: e */
    public ByteBuffer f7095e;

    /* renamed from: f */
    private final int f7096f;

    static {
        C2544af.m5676b("media3.decoder");
    }

    public C2669ed(int i) {
        this.f7091a = new C2666ea();
        this.f7096f = i;
    }

    /* renamed from: o */
    private final ByteBuffer m2445o(int i) {
        int i2 = this.f7096f;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f7092b;
        throw new C2668ec(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2662dx
    /* renamed from: b */
    public void mo1278b() {
        super.mo1278b();
        ByteBuffer byteBuffer = this.f7092b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f7095e;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f7093c = false;
    }

    /* renamed from: l */
    public final void m2448l(int i) {
        ByteBuffer byteBuffer = this.f7092b;
        if (byteBuffer == null) {
            this.f7092b = m2445o(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (capacity >= i2) {
            this.f7092b = byteBuffer;
            return;
        }
        ByteBuffer m2445o = m2445o(i2);
        m2445o.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            m2445o.put(byteBuffer);
        }
        this.f7092b = m2445o;
    }

    /* renamed from: m */
    public final void m2447m() {
        ByteBuffer byteBuffer = this.f7092b;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f7095e;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    /* renamed from: n */
    public final boolean m2446n() {
        return m2465d(1073741824);
    }

    public C2669ed() {
        this(1);
    }
}
