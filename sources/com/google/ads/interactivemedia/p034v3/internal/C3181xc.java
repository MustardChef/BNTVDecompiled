package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xc */
/* loaded from: classes2.dex */
public final class C3181xc {

    /* renamed from: a */
    private long f9360a;

    /* renamed from: b */
    private long f9361b;

    /* renamed from: c */
    private long f9362c;

    /* renamed from: d */
    private long f9363d;

    /* renamed from: e */
    private long f9364e;

    /* renamed from: f */
    private long f9365f;

    /* renamed from: g */
    private final boolean[] f9366g = new boolean[15];

    /* renamed from: h */
    private int f9367h;

    /* renamed from: g */
    private static int m676g(long j) {
        return (int) (j % 15);
    }

    /* renamed from: a */
    public final long m682a() {
        long j = this.f9364e;
        if (j == 0) {
            return 0L;
        }
        return this.f9365f / j;
    }

    /* renamed from: b */
    public final long m681b() {
        return this.f9365f;
    }

    /* renamed from: c */
    public final void m680c(long j) {
        long j2 = this.f9363d;
        if (j2 == 0) {
            this.f9360a = j;
        } else if (j2 == 1) {
            long j3 = j - this.f9360a;
            this.f9361b = j3;
            this.f9365f = j3;
            this.f9364e = 1L;
        } else {
            long j4 = j - this.f9362c;
            int m676g = m676g(j2);
            if (Math.abs(j4 - this.f9361b) <= 1000000) {
                this.f9364e++;
                this.f9365f += j4;
                boolean[] zArr = this.f9366g;
                if (zArr[m676g]) {
                    zArr[m676g] = false;
                    this.f9367h--;
                }
            } else {
                boolean[] zArr2 = this.f9366g;
                if (!zArr2[m676g]) {
                    zArr2[m676g] = true;
                    this.f9367h++;
                }
            }
        }
        this.f9363d++;
        this.f9362c = j;
    }

    /* renamed from: d */
    public final void m679d() {
        this.f9363d = 0L;
        this.f9364e = 0L;
        this.f9365f = 0L;
        this.f9367h = 0;
        Arrays.fill(this.f9366g, false);
    }

    /* renamed from: e */
    public final boolean m678e() {
        long j = this.f9363d;
        if (j == 0) {
            return false;
        }
        return this.f9366g[m676g(j - 1)];
    }

    /* renamed from: f */
    public final boolean m677f() {
        return this.f9363d > 15 && this.f9367h == 0;
    }
}
