package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wc */
/* loaded from: classes2.dex */
public final class C3154wc {

    /* renamed from: a */
    private final byte[] f9263a;

    /* renamed from: b */
    private final C3147vw[] f9264b;

    /* renamed from: c */
    private int f9265c;

    /* renamed from: d */
    private int f9266d;

    /* renamed from: e */
    private int f9267e;

    /* renamed from: f */
    private C3147vw[] f9268f;

    public C3154wc() {
        C2616ce.m2687f(true);
        C2616ce.m2687f(true);
        this.f9267e = 0;
        this.f9268f = new C3147vw[100];
        this.f9263a = null;
        this.f9264b = new C3147vw[1];
    }

    /* renamed from: a */
    public final synchronized int m768a() {
        return this.f9266d * 65536;
    }

    /* renamed from: b */
    public final synchronized C3147vw m767b() {
        C3147vw c3147vw;
        this.f9266d++;
        int i = this.f9267e;
        if (i > 0) {
            C3147vw[] c3147vwArr = this.f9268f;
            int i2 = i - 1;
            this.f9267e = i2;
            c3147vw = c3147vwArr[i2];
            C2616ce.m2689d(c3147vw);
            this.f9268f[this.f9267e] = null;
        } else {
            c3147vw = new C3147vw(new byte[65536], 0);
        }
        return c3147vw;
    }

    /* renamed from: c */
    public final synchronized void m766c(C3147vw c3147vw) {
        C3147vw[] c3147vwArr = this.f9264b;
        c3147vwArr[0] = c3147vw;
        m765d(c3147vwArr);
    }

    /* renamed from: d */
    public final synchronized void m765d(C3147vw[] c3147vwArr) {
        int length = this.f9267e + c3147vwArr.length;
        C3147vw[] c3147vwArr2 = this.f9268f;
        int length2 = c3147vwArr2.length;
        if (length >= length2) {
            this.f9268f = (C3147vw[]) Arrays.copyOf(c3147vwArr2, Math.max(length2 + length2, length));
        }
        for (C3147vw c3147vw : c3147vwArr) {
            C3147vw[] c3147vwArr3 = this.f9268f;
            int i = this.f9267e;
            this.f9267e = i + 1;
            c3147vwArr3[i] = c3147vw;
        }
        this.f9266d -= c3147vwArr.length;
        notifyAll();
    }

    /* renamed from: e */
    public final synchronized void m764e() {
        m763f(0);
    }

    /* renamed from: f */
    public final synchronized void m763f(int i) {
        int i2 = this.f9265c;
        this.f9265c = i;
        if (i < i2) {
            m762g();
        }
    }

    /* renamed from: g */
    public final synchronized void m762g() {
        int max = Math.max(0, C2628cq.m2532b(this.f9265c, 65536) - this.f9266d);
        int i = this.f9267e;
        if (max >= i) {
            return;
        }
        Arrays.fill(this.f9268f, max, i, (Object) null);
        this.f9267e = max;
    }
}
