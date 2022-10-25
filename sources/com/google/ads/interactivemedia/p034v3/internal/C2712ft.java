package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ft */
/* loaded from: classes2.dex */
public final class C2712ft {

    /* renamed from: a */
    public C2731gl f7278a;

    /* renamed from: b */
    public int f7279b;

    /* renamed from: c */
    public boolean f7280c;

    /* renamed from: d */
    public int f7281d;

    /* renamed from: e */
    public boolean f7282e;

    /* renamed from: f */
    public int f7283f;

    /* renamed from: g */
    private boolean f7284g;

    public C2712ft(C2731gl c2731gl) {
        this.f7278a = c2731gl;
    }

    /* renamed from: a */
    public final void m2361a(int i) {
        this.f7284g = 1 == ((this.f7284g ? 1 : 0) | i);
        this.f7279b += i;
    }

    /* renamed from: b */
    public final void m2360b(int i) {
        this.f7284g = true;
        this.f7282e = true;
        this.f7283f = i;
    }

    /* renamed from: c */
    public final void m2359c(C2731gl c2731gl) {
        this.f7284g |= this.f7278a != c2731gl;
        this.f7278a = c2731gl;
    }

    /* renamed from: d */
    public final void m2358d(int i) {
        if (this.f7280c && this.f7281d != 5) {
            C2616ce.m2687f(i == 5);
            return;
        }
        this.f7284g = true;
        this.f7280c = true;
        this.f7281d = i;
    }
}
