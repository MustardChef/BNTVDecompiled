package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.DefaultLoadControl;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.eq */
/* loaded from: classes2.dex */
public final class C2682eq {

    /* renamed from: a */
    private final C3154wc f7162a;

    /* renamed from: b */
    private final long f7163b;

    /* renamed from: c */
    private final long f7164c;

    /* renamed from: d */
    private final long f7165d;

    /* renamed from: e */
    private final long f7166e;

    /* renamed from: f */
    private final long f7167f;

    /* renamed from: g */
    private int f7168g;

    /* renamed from: h */
    private boolean f7169h;

    public C2682eq() {
        C3154wc c3154wc = new C3154wc();
        m2406i(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 0, "bufferForPlaybackMs", "0");
        m2406i(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        m2406i(50000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, "minBufferMs", "bufferForPlaybackMs");
        m2406i(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        m2406i(50000, 50000, "maxBufferMs", "minBufferMs");
        m2406i(0, 0, "backBufferDurationMs", "0");
        this.f7162a = c3154wc;
        this.f7163b = C2628cq.m2515s(50000L);
        this.f7164c = C2628cq.m2515s(50000L);
        this.f7165d = C2628cq.m2515s(2500L);
        this.f7166e = C2628cq.m2515s(5000L);
        this.f7168g = 13107200;
        this.f7167f = C2628cq.m2515s(0L);
    }

    /* renamed from: i */
    private static void m2406i(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        StringBuilder sb = new StringBuilder(str.length() + 21 + str2.length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        C2616ce.m2686g(z, sb.toString());
    }

    /* renamed from: j */
    private final void m2405j(boolean z) {
        this.f7168g = 13107200;
        this.f7169h = false;
        if (z) {
            this.f7162a.m764e();
        }
    }

    /* renamed from: a */
    public final long m2414a() {
        return this.f7167f;
    }

    /* renamed from: b */
    public final void m2413b() {
        m2405j(false);
    }

    /* renamed from: c */
    public final void m2412c() {
        m2405j(true);
    }

    /* renamed from: d */
    public final void m2411d() {
        m2405j(true);
    }

    /* renamed from: e */
    public final boolean m2410e(long j, float f, boolean z, long j2) {
        long m2516r = C2628cq.m2516r(j, f);
        long j3 = z ? this.f7166e : this.f7165d;
        if (j2 != C3282C.TIME_UNSET) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || m2516r >= j3 || this.f7162a.m768a() >= this.f7168g;
    }

    /* renamed from: f */
    public final C3154wc m2409f() {
        return this.f7162a;
    }

    /* renamed from: g */
    public final void m2408g(InterfaceC2737gr[] interfaceC2737grArr, InterfaceC3142vr[] interfaceC3142vrArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = interfaceC2737grArr.length;
            if (i < 2) {
                if (interfaceC3142vrArr[i] != null) {
                    i2 += interfaceC2737grArr[i].mo2170b() != 1 ? DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE : 13107200;
                }
                i++;
            } else {
                int max = Math.max(13107200, i2);
                this.f7168g = max;
                this.f7162a.m763f(max);
                return;
            }
        }
    }

    /* renamed from: h */
    public final boolean m2407h(long j, float f) {
        int m768a = this.f7162a.m768a();
        int i = this.f7168g;
        long j2 = this.f7163b;
        if (f > 1.0f) {
            j2 = Math.min(C2628cq.m2518p(j2, f), this.f7164c);
        }
        if (j < Math.max(j2, 500000L)) {
            boolean z = m768a < i;
            this.f7169h = z;
            if (!z && j < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.f7164c || m768a >= i) {
            this.f7169h = false;
        }
        return this.f7169h;
    }
}
