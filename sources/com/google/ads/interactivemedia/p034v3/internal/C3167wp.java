package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wp */
/* loaded from: classes2.dex */
public final class C3167wp implements InterfaceC3168wq {

    /* renamed from: a */
    public static final C3158wg f9309a = m716n(false, C3282C.TIME_UNSET);

    /* renamed from: b */
    public static final C3158wg f9310b = new C3158wg(2, C3282C.TIME_UNSET, null);

    /* renamed from: c */
    public static final C3158wg f9311c = new C3158wg(3, C3282C.TIME_UNSET, null);

    /* renamed from: d */
    private final ExecutorService f9312d;

    /* renamed from: e */
    private HandlerC3162wk f9313e;

    /* renamed from: f */
    private IOException f9314f;

    public C3167wp(String str) {
        this.f9312d = C2628cq.m2567P(str.length() != 0 ? "ExoPlayer:Loader:".concat(str) : new String("ExoPlayer:Loader:"));
    }

    /* renamed from: n */
    public static C3158wg m716n(boolean z, long j) {
        return new C3158wg(z ? 1 : 0, j, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3168wq
    /* renamed from: a */
    public final void mo715a() throws IOException {
        m721i(Integer.MIN_VALUE);
    }

    /* renamed from: b */
    public final long m728b(InterfaceC3163wl interfaceC3163wl, InterfaceC3160wi interfaceC3160wi, int i) {
        Looper myLooper = Looper.myLooper();
        C2616ce.m2688e(myLooper);
        this.f9314f = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new HandlerC3162wk(this, myLooper, interfaceC3163wl, interfaceC3160wi, i, elapsedRealtime).m732c(0L);
        return elapsedRealtime;
    }

    /* renamed from: g */
    public final void m723g() {
        HandlerC3162wk handlerC3162wk = this.f9313e;
        C2616ce.m2688e(handlerC3162wk);
        handlerC3162wk.m734a(false);
    }

    /* renamed from: h */
    public final void m722h() {
        this.f9314f = null;
    }

    /* renamed from: i */
    public final void m721i(int i) throws IOException {
        IOException iOException = this.f9314f;
        if (iOException != null) {
            throw iOException;
        }
        HandlerC3162wk handlerC3162wk = this.f9313e;
        if (handlerC3162wk != null) {
            if (i == Integer.MIN_VALUE) {
                i = handlerC3162wk.f9298a;
            }
            handlerC3162wk.m733b(i);
        }
    }

    /* renamed from: j */
    public final void m720j() {
        m719k(null);
    }

    /* renamed from: k */
    public final void m719k(InterfaceC3164wm interfaceC3164wm) {
        HandlerC3162wk handlerC3162wk = this.f9313e;
        if (handlerC3162wk != null) {
            handlerC3162wk.m734a(true);
        }
        if (interfaceC3164wm != null) {
            this.f9312d.execute(new RunnableC3165wn(interfaceC3164wm));
        }
        this.f9312d.shutdown();
    }

    /* renamed from: l */
    public final boolean m718l() {
        return this.f9314f != null;
    }

    /* renamed from: m */
    public final boolean m717m() {
        return this.f9313e != null;
    }
}
