package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnn */
/* loaded from: classes2.dex */
final class bnn extends InputStream {

    /* renamed from: a */
    private Iterator f6269a;

    /* renamed from: b */
    private ByteBuffer f6270b;

    /* renamed from: c */
    private int f6271c = 0;

    /* renamed from: d */
    private int f6272d;

    /* renamed from: e */
    private int f6273e;

    /* renamed from: f */
    private boolean f6274f;

    /* renamed from: g */
    private byte[] f6275g;

    /* renamed from: h */
    private int f6276h;

    /* renamed from: i */
    private long f6277i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bnn(Iterable iterable) {
        this.f6269a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            this.f6271c++;
        }
        this.f6272d = -1;
        if (m3246b()) {
            return;
        }
        this.f6270b = bnk.f6267d;
        this.f6272d = 0;
        this.f6273e = 0;
        this.f6277i = 0L;
    }

    /* renamed from: a */
    private final void m3247a(int i) {
        int i2 = this.f6273e + i;
        this.f6273e = i2;
        if (i2 == this.f6270b.limit()) {
            m3246b();
        }
    }

    /* renamed from: b */
    private final boolean m3246b() {
        this.f6272d++;
        if (this.f6269a.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) this.f6269a.next();
            this.f6270b = byteBuffer;
            this.f6273e = byteBuffer.position();
            if (this.f6270b.hasArray()) {
                this.f6274f = true;
                this.f6275g = this.f6270b.array();
                this.f6276h = this.f6270b.arrayOffset();
            } else {
                this.f6274f = false;
                this.f6277i = bpu.m2899e(this.f6270b);
                this.f6275g = null;
            }
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte m2903a;
        if (this.f6272d == this.f6271c) {
            return -1;
        }
        if (this.f6274f) {
            m2903a = this.f6275g[this.f6273e + this.f6276h];
            m3247a(1);
        } else {
            m2903a = bpu.m2903a(this.f6273e + this.f6277i);
            m3247a(1);
        }
        return m2903a & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6272d == this.f6271c) {
            return -1;
        }
        int limit = this.f6270b.limit();
        int i3 = this.f6273e;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.f6274f) {
            System.arraycopy(this.f6275g, i3 + this.f6276h, bArr, i, i2);
            m3247a(i2);
        } else {
            int position = this.f6270b.position();
            ByteBuffer byteBuffer = (ByteBuffer) this.f6270b.position(this.f6273e);
            this.f6270b.get(bArr, i, i2);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.f6270b.position(position);
            m3247a(i2);
        }
        return i2;
    }
}
