package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jl */
/* loaded from: classes2.dex */
public final class C2812jl {

    /* renamed from: A */
    private long f7660A;

    /* renamed from: B */
    private long f7661B;

    /* renamed from: C */
    private long f7662C;

    /* renamed from: D */
    private boolean f7663D;

    /* renamed from: E */
    private long f7664E;

    /* renamed from: F */
    private long f7665F;

    /* renamed from: a */
    private final InterfaceC2811jk f7666a;

    /* renamed from: b */
    private final long[] f7667b;

    /* renamed from: c */
    private AudioTrack f7668c;

    /* renamed from: d */
    private int f7669d;

    /* renamed from: e */
    private int f7670e;

    /* renamed from: f */
    private C2810jj f7671f;

    /* renamed from: g */
    private int f7672g;

    /* renamed from: h */
    private boolean f7673h;

    /* renamed from: i */
    private long f7674i;

    /* renamed from: j */
    private float f7675j;

    /* renamed from: k */
    private boolean f7676k;

    /* renamed from: l */
    private long f7677l;

    /* renamed from: m */
    private long f7678m;

    /* renamed from: n */
    private Method f7679n;

    /* renamed from: o */
    private long f7680o;

    /* renamed from: p */
    private boolean f7681p;

    /* renamed from: q */
    private boolean f7682q;

    /* renamed from: r */
    private long f7683r;

    /* renamed from: s */
    private long f7684s;

    /* renamed from: t */
    private long f7685t;

    /* renamed from: u */
    private long f7686u;

    /* renamed from: v */
    private int f7687v;

    /* renamed from: w */
    private int f7688w;

    /* renamed from: x */
    private long f7689x;

    /* renamed from: y */
    private long f7690y;

    /* renamed from: z */
    private long f7691z;

    public C2812jl(InterfaceC2811jk interfaceC2811jk) {
        this.f7666a = interfaceC2811jk;
        if (C2628cq.f6961a >= 18) {
            try {
                this.f7679n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f7667b = new long[10];
    }

    /* renamed from: m */
    private final long m1920m(long j) {
        return (j * 1000000) / this.f7672g;
    }

    /* renamed from: n */
    private final long m1919n() {
        AudioTrack audioTrack = this.f7668c;
        C2616ce.m2689d(audioTrack);
        if (this.f7689x != C3282C.TIME_UNSET) {
            return Math.min(this.f7660A, this.f7691z + ((((SystemClock.elapsedRealtime() * 1000) - this.f7689x) * this.f7672g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        long j = 0;
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f7673h) {
            if (playState == 2) {
                if (playbackHeadPosition == 0) {
                    this.f7686u = this.f7684s;
                }
                playState = 2;
            }
            playbackHeadPosition += this.f7686u;
        }
        if (C2628cq.f6961a <= 29) {
            if (playbackHeadPosition != 0) {
                j = playbackHeadPosition;
            } else if (this.f7684s > 0 && playState == 3) {
                if (this.f7690y == C3282C.TIME_UNSET) {
                    this.f7690y = SystemClock.elapsedRealtime();
                }
                return this.f7684s;
            }
            this.f7690y = C3282C.TIME_UNSET;
            playbackHeadPosition = j;
        }
        if (this.f7684s > playbackHeadPosition) {
            this.f7685t++;
        }
        this.f7684s = playbackHeadPosition;
        return playbackHeadPosition + (this.f7685t << 32);
    }

    /* renamed from: o */
    private final long m1918o() {
        return m1920m(m1919n());
    }

    /* renamed from: p */
    private final void m1917p() {
        this.f7677l = 0L;
        this.f7688w = 0;
        this.f7687v = 0;
        this.f7678m = 0L;
        this.f7662C = 0L;
        this.f7665F = 0L;
        this.f7676k = false;
    }

    /* renamed from: a */
    public final int m1932a(long j) {
        return this.f7670e - ((int) (j - (m1919n() * this.f7669d)));
    }

    /* renamed from: b */
    public final long m1931b(boolean z) {
        long j;
        long max;
        long j2;
        Method method;
        AudioTrack audioTrack;
        AudioTrack audioTrack2 = this.f7668c;
        C2616ce.m2689d(audioTrack2);
        if (audioTrack2.getPlayState() == 3) {
            long m1918o = m1918o();
            if (m1918o != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.f7678m >= 30000) {
                    long[] jArr = this.f7667b;
                    int i = this.f7687v;
                    jArr[i] = m1918o - nanoTime;
                    this.f7687v = (i + 1) % 10;
                    int i2 = this.f7688w;
                    if (i2 < 10) {
                        this.f7688w = i2 + 1;
                    }
                    this.f7678m = nanoTime;
                    this.f7677l = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.f7688w;
                        if (i3 >= i4) {
                            break;
                        }
                        this.f7677l += this.f7667b[i3] / i4;
                        i3++;
                    }
                }
                if (!this.f7673h) {
                    C2810jj c2810jj = this.f7671f;
                    C2616ce.m2689d(c2810jj);
                    if (c2810jj.m1934g(nanoTime)) {
                        long m1939b = c2810jj.m1939b();
                        long m1940a = c2810jj.m1940a();
                        if (Math.abs(m1939b - nanoTime) > 5000000) {
                            j2 = nanoTime;
                            this.f7666a.mo1897d(m1940a, m1939b, nanoTime, m1918o);
                            c2810jj.m1937d();
                        } else {
                            j2 = nanoTime;
                            if (Math.abs(m1920m(m1940a) - m1918o) > 5000000) {
                                this.f7666a.mo1898c(m1940a, m1939b, j2, m1918o);
                                c2810jj.m1937d();
                            } else {
                                c2810jj.m1938c();
                            }
                        }
                    } else {
                        j2 = nanoTime;
                    }
                    if (this.f7682q && (method = this.f7679n) != null) {
                        long j3 = j2;
                        if (j3 - this.f7683r >= 500000) {
                            try {
                                C2616ce.m2689d(this.f7668c);
                                int i5 = C2628cq.f6961a;
                                long intValue = (((Integer) method.invoke(audioTrack, new Object[0])).intValue() * 1000) - this.f7674i;
                                this.f7680o = intValue;
                                long max2 = Math.max(intValue, 0L);
                                this.f7680o = max2;
                                if (max2 > 5000000) {
                                    this.f7666a.mo1900a(max2);
                                    this.f7680o = 0L;
                                }
                            } catch (Exception unused) {
                                this.f7679n = null;
                            }
                            this.f7683r = j3;
                        }
                    }
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        C2810jj c2810jj2 = this.f7671f;
        C2616ce.m2689d(c2810jj2);
        boolean m1935f = c2810jj2.m1935f();
        if (m1935f) {
            max = m1920m(c2810jj2.m1940a()) + C2628cq.m2518p(nanoTime2 - c2810jj2.m1939b(), this.f7675j);
        } else {
            if (this.f7688w == 0) {
                j = m1918o();
            } else {
                j = this.f7677l + nanoTime2;
            }
            max = !z ? Math.max(0L, j - this.f7680o) : j;
        }
        if (this.f7663D != m1935f) {
            this.f7665F = this.f7662C;
            this.f7664E = this.f7661B;
        }
        long j4 = nanoTime2 - this.f7665F;
        if (j4 < 1000000) {
            long j5 = (j4 * 1000) / 1000000;
            max = ((max * j5) + ((1000 - j5) * (this.f7664E + C2628cq.m2518p(j4, this.f7675j)))) / 1000;
        }
        if (!this.f7676k) {
            long j6 = this.f7661B;
            if (max > j6) {
                this.f7676k = true;
                this.f7666a.mo1899b(System.currentTimeMillis() - C2628cq.m2511w(C2628cq.m2516r(C2628cq.m2511w(max - j6), this.f7675j)));
            }
        }
        this.f7662C = nanoTime2;
        this.f7661B = max;
        this.f7663D = m1935f;
        return max;
    }

    /* renamed from: c */
    public final long m1930c(long j) {
        return C2628cq.m2511w(m1920m(j - m1919n()));
    }

    /* renamed from: d */
    public final void m1929d(long j) {
        this.f7691z = m1919n();
        this.f7689x = SystemClock.elapsedRealtime() * 1000;
        this.f7660A = j;
    }

    /* renamed from: e */
    public final void m1928e() {
        m1917p();
        this.f7668c = null;
        this.f7671f = null;
    }

    /* renamed from: f */
    public final void m1927f(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.f7668c = audioTrack;
        this.f7669d = i2;
        this.f7670e = i3;
        this.f7671f = new C2810jj(audioTrack);
        this.f7672g = audioTrack.getSampleRate();
        boolean z2 = true;
        if (!z || C2628cq.f6961a >= 23 || (i != 5 && i != 6)) {
            z2 = false;
        }
        this.f7673h = z2;
        boolean m2560W = C2628cq.m2560W(i);
        this.f7682q = m2560W;
        this.f7674i = m2560W ? m1920m(i3 / i2) : -9223372036854775807L;
        this.f7684s = 0L;
        this.f7685t = 0L;
        this.f7686u = 0L;
        this.f7681p = false;
        this.f7689x = C3282C.TIME_UNSET;
        this.f7690y = C3282C.TIME_UNSET;
        this.f7683r = 0L;
        this.f7680o = 0L;
        this.f7675j = 1.0f;
    }

    /* renamed from: g */
    public final void m1926g() {
        C2810jj c2810jj = this.f7671f;
        C2616ce.m2689d(c2810jj);
        c2810jj.m1936e();
    }

    /* renamed from: h */
    public final boolean m1925h(long j) {
        if (j <= m1919n()) {
            if (this.f7673h) {
                AudioTrack audioTrack = this.f7668c;
                C2616ce.m2689d(audioTrack);
                return audioTrack.getPlayState() == 2 && m1919n() == 0;
            }
            return false;
        }
        return true;
    }

    /* renamed from: i */
    public final boolean m1924i() {
        AudioTrack audioTrack = this.f7668c;
        C2616ce.m2689d(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    /* renamed from: j */
    public final boolean m1923j(long j) {
        return this.f7690y != C3282C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.f7690y >= 200;
    }

    /* renamed from: k */
    public final boolean m1922k(long j) {
        AudioTrack audioTrack = this.f7668c;
        C2616ce.m2689d(audioTrack);
        int playState = audioTrack.getPlayState();
        if (this.f7673h) {
            if (playState == 2) {
                this.f7681p = false;
                return false;
            } else if (playState == 1) {
                if (m1919n() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.f7681p;
        boolean m1925h = m1925h(j);
        this.f7681p = m1925h;
        if (z && !m1925h && playState != 1) {
            this.f7666a.mo1896e(this.f7670e, C2628cq.m2511w(this.f7674i));
        }
        return true;
    }

    /* renamed from: l */
    public final boolean m1921l() {
        m1917p();
        if (this.f7689x == C3282C.TIME_UNSET) {
            C2810jj c2810jj = this.f7671f;
            C2616ce.m2689d(c2810jj);
            c2810jj.m1936e();
            return true;
        }
        return false;
    }
}
