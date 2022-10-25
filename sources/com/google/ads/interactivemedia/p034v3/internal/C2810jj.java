package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jj */
/* loaded from: classes2.dex */
final class C2810jj {

    /* renamed from: a */
    private final C2809ji f7654a;

    /* renamed from: b */
    private int f7655b;

    /* renamed from: c */
    private long f7656c;

    /* renamed from: d */
    private long f7657d;

    /* renamed from: e */
    private long f7658e;

    /* renamed from: f */
    private long f7659f;

    public C2810jj(AudioTrack audioTrack) {
        if (C2628cq.f6961a >= 19) {
            this.f7654a = new C2809ji(audioTrack);
            m1936e();
            return;
        }
        this.f7654a = null;
        m1933h(3);
    }

    /* renamed from: h */
    private final void m1933h(int i) {
        this.f7655b = i;
        long j = 10000;
        if (i == 0) {
            this.f7658e = 0L;
            this.f7659f = -1L;
            this.f7656c = System.nanoTime() / 1000;
        } else if (i == 1) {
            this.f7657d = 10000L;
            return;
        } else {
            j = (i == 2 || i == 3) ? 10000000L : 500000L;
        }
        this.f7657d = j;
    }

    /* renamed from: a */
    public final long m1940a() {
        C2809ji c2809ji = this.f7654a;
        if (c2809ji != null) {
            return c2809ji.m1943a();
        }
        return -1L;
    }

    /* renamed from: b */
    public final long m1939b() {
        C2809ji c2809ji = this.f7654a;
        return c2809ji != null ? c2809ji.m1942b() : C3282C.TIME_UNSET;
    }

    /* renamed from: c */
    public final void m1938c() {
        if (this.f7655b == 4) {
            m1936e();
        }
    }

    /* renamed from: d */
    public final void m1937d() {
        m1933h(4);
    }

    /* renamed from: e */
    public final void m1936e() {
        if (this.f7654a != null) {
            m1933h(0);
        }
    }

    /* renamed from: f */
    public final boolean m1935f() {
        return this.f7655b == 2;
    }

    /* renamed from: g */
    public final boolean m1934g(long j) {
        C2809ji c2809ji = this.f7654a;
        if (c2809ji != null && j - this.f7658e >= this.f7657d) {
            this.f7658e = j;
            boolean m1941c = c2809ji.m1941c();
            int i = this.f7655b;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && m1941c) {
                            m1936e();
                            return true;
                        }
                    } else if (!m1941c) {
                        m1936e();
                        return false;
                    }
                } else if (m1941c) {
                    if (this.f7654a.m1943a() > this.f7659f) {
                        m1933h(2);
                        return true;
                    }
                } else {
                    m1936e();
                }
            } else if (m1941c) {
                if (this.f7654a.m1942b() < this.f7656c) {
                    return false;
                }
                this.f7659f = this.f7654a.m1943a();
                m1933h(1);
                return true;
            } else if (j - this.f7656c > 500000) {
                m1933h(3);
            }
            return m1941c;
        }
        return false;
    }
}
