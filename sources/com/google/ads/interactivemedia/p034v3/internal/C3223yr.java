package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.yr */
/* loaded from: classes2.dex */
public final class C3223yr implements InterfaceC3230yy {

    /* renamed from: b */
    private final InterfaceC2746h f9529b;

    /* renamed from: c */
    private final long f9530c;

    /* renamed from: d */
    private long f9531d;

    /* renamed from: f */
    private int f9533f;

    /* renamed from: g */
    private int f9534g;

    /* renamed from: e */
    private byte[] f9532e = new byte[65536];

    /* renamed from: a */
    private final byte[] f9528a = new byte[4096];

    static {
        C2544af.m5676b("media3.extractor");
    }

    public C3223yr(InterfaceC2746h interfaceC2746h, long j, long j2) {
        this.f9529b = interfaceC2746h;
        this.f9531d = j;
        this.f9530c = j2;
    }

    /* renamed from: m */
    private final int m509m(byte[] bArr, int i, int i2) {
        int i3 = this.f9534g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.f9532e, 0, bArr, i, min);
        m504r(min);
        return min;
    }

    /* renamed from: n */
    private final int m508n(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int mo501a = this.f9529b.mo501a(bArr, i + i3, i2 - i3);
        if (mo501a == -1) {
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        return i3 + mo501a;
    }

    /* renamed from: o */
    private final int m507o(int i) {
        int min = Math.min(this.f9534g, i);
        m504r(min);
        return min;
    }

    /* renamed from: p */
    private final void m506p(int i) {
        if (i != -1) {
            this.f9531d += i;
        }
    }

    /* renamed from: q */
    private final void m505q(int i) {
        int i2 = this.f9533f + i;
        int length = this.f9532e.length;
        if (i2 > length) {
            this.f9532e = Arrays.copyOf(this.f9532e, C2628cq.m2531c(length + length, 65536 + i2, i2 + 524288));
        }
    }

    /* renamed from: r */
    private final void m504r(int i) {
        int i2 = this.f9534g - i;
        this.f9534g = i2;
        this.f9533f = 0;
        byte[] bArr = this.f9532e;
        byte[] bArr2 = i2 < bArr.length + (-524288) ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.f9532e = bArr2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws IOException {
        int m509m = m509m(bArr, i, i2);
        if (m509m == 0) {
            m509m = m508n(bArr, i, i2, 0, true);
        }
        m506p(m509m);
        return m509m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: b */
    public final long mo500b() {
        return this.f9530c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: c */
    public final long mo499c() {
        return this.f9531d + this.f9533f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: d */
    public final long mo498d() {
        return this.f9531d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: e */
    public final void mo497e(int i) throws IOException {
        m510j(i, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: f */
    public final void mo496f(byte[] bArr, int i, int i2) throws IOException {
        mo492k(bArr, i, i2, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: g */
    public final void mo495g(byte[] bArr, int i, int i2) throws IOException {
        mo491l(bArr, i, i2, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: h */
    public final void mo494h() {
        this.f9533f = 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: i */
    public final void mo493i(int i) throws IOException {
        int m507o = m507o(i);
        while (m507o < i && m507o != -1) {
            m507o = m508n(this.f9528a, -m507o, Math.min(i, m507o + 4096), m507o, false);
        }
        m506p(m507o);
    }

    /* renamed from: j */
    public final boolean m510j(int i, boolean z) throws IOException {
        m505q(i);
        int i2 = this.f9534g - this.f9533f;
        while (i2 < i) {
            i2 = m508n(this.f9532e, this.f9533f, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.f9534g = this.f9533f + i2;
        }
        this.f9533f += i;
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: k */
    public final boolean mo492k(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (m510j(i2, z)) {
            System.arraycopy(this.f9532e, this.f9533f - i2, bArr, i, i2);
            return true;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy
    /* renamed from: l */
    public final boolean mo491l(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int m509m = m509m(bArr, i, i2);
        while (m509m < i2 && m509m != -1) {
            m509m = m508n(bArr, i, i2, m509m, z);
        }
        m506p(m509m);
        return m509m != -1;
    }
}
