package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.db */
/* loaded from: classes2.dex */
public final class C2640db extends InputStream {

    /* renamed from: a */
    private final InterfaceC2637cz f6997a;

    /* renamed from: b */
    private final C2642dd f6998b;

    /* renamed from: f */
    private long f7002f;

    /* renamed from: d */
    private boolean f7000d = false;

    /* renamed from: e */
    private boolean f7001e = false;

    /* renamed from: c */
    private final byte[] f6999c = new byte[1];

    public C2640db(InterfaceC2637cz interfaceC2637cz, C2642dd c2642dd) {
        this.f6997a = interfaceC2637cz;
        this.f6998b = c2642dd;
    }

    /* renamed from: b */
    private final void m2501b() throws IOException {
        if (this.f7000d) {
            return;
        }
        this.f6997a.mo1127b(this.f6998b);
        this.f7000d = true;
    }

    /* renamed from: a */
    public final void m2502a() throws IOException {
        m2501b();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f7001e) {
            return;
        }
        this.f6997a.mo1125d();
        this.f7001e = true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (read(this.f6999c) == -1) {
            return -1;
        }
        return this.f6999c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        C2616ce.m2685h(!this.f7001e);
        m2501b();
        int a = this.f6997a.mo501a(bArr, i, i2);
        if (a == -1) {
            return -1;
        }
        this.f7002f += a;
        return a;
    }
}
