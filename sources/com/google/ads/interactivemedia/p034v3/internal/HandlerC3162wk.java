package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wk */
/* loaded from: classes2.dex */
public final class HandlerC3162wk extends Handler implements Runnable {

    /* renamed from: a */
    public final int f9298a;

    /* renamed from: b */
    final /* synthetic */ C3167wp f9299b;

    /* renamed from: c */
    private final InterfaceC3163wl f9300c;

    /* renamed from: d */
    private final long f9301d;

    /* renamed from: e */
    private InterfaceC3160wi f9302e;

    /* renamed from: f */
    private IOException f9303f;

    /* renamed from: g */
    private int f9304g;

    /* renamed from: h */
    private Thread f9305h;

    /* renamed from: i */
    private boolean f9306i;

    /* renamed from: j */
    private volatile boolean f9307j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3162wk(C3167wp c3167wp, Looper looper, InterfaceC3163wl interfaceC3163wl, InterfaceC3160wi interfaceC3160wi, int i, long j) {
        super(looper);
        this.f9299b = c3167wp;
        this.f9300c = interfaceC3163wl;
        this.f9302e = interfaceC3160wi;
        this.f9298a = i;
        this.f9301d = j;
    }

    /* renamed from: d */
    private final void m731d() {
        ExecutorService executorService;
        HandlerC3162wk handlerC3162wk;
        this.f9303f = null;
        C3167wp c3167wp = this.f9299b;
        executorService = c3167wp.f9312d;
        handlerC3162wk = c3167wp.f9313e;
        C2616ce.m2689d(handlerC3162wk);
        executorService.execute(handlerC3162wk);
    }

    /* renamed from: e */
    private final void m730e() {
        this.f9299b.f9313e = null;
    }

    /* renamed from: a */
    public final void m734a(boolean z) {
        this.f9307j = z;
        this.f9303f = null;
        if (hasMessages(0)) {
            this.f9306i = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.f9306i = true;
                this.f9300c.mo700r();
                Thread thread = this.f9305h;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            m730e();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            InterfaceC3160wi interfaceC3160wi = this.f9302e;
            C2616ce.m2689d(interfaceC3160wi);
            interfaceC3160wi.mo702bf(this.f9300c, elapsedRealtime, elapsedRealtime - this.f9301d, true);
            this.f9302e = null;
        }
    }

    /* renamed from: b */
    public final void m733b(int i) throws IOException {
        IOException iOException = this.f9303f;
        if (iOException != null && this.f9304g > i) {
            throw iOException;
        }
    }

    /* renamed from: c */
    public final void m732c(long j) {
        HandlerC3162wk handlerC3162wk;
        handlerC3162wk = this.f9299b.f9313e;
        C2616ce.m2685h(handlerC3162wk == null);
        this.f9299b.f9313e = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            m731d();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i;
        int i2;
        int i3;
        long j;
        if (this.f9307j) {
            return;
        }
        if (message.what == 0) {
            m731d();
        } else if (message.what == 3) {
            throw ((Error) message.obj);
        } else {
            m730e();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.f9301d;
            InterfaceC3160wi interfaceC3160wi = this.f9302e;
            C2616ce.m2689d(interfaceC3160wi);
            if (this.f9306i) {
                interfaceC3160wi.mo702bf(this.f9300c, elapsedRealtime, j2, false);
                return;
            }
            int i4 = message.what;
            if (i4 == 1) {
                try {
                    interfaceC3160wi.mo704bb(this.f9300c, elapsedRealtime, j2);
                } catch (RuntimeException e) {
                    C2613cb.m2698a("LoadTask", "Unexpected exception handling load completed", e);
                    this.f9299b.f9314f = new C3166wo(e);
                }
            } else if (i4 != 2) {
            } else {
                IOException iOException = (IOException) message.obj;
                this.f9303f = iOException;
                int i5 = this.f9304g + 1;
                this.f9304g = i5;
                C3158wg mo703bc = interfaceC3160wi.mo703bc(this.f9300c, elapsedRealtime, j2, iOException, i5);
                i = mo703bc.f9294a;
                if (i == 3) {
                    this.f9299b.f9314f = this.f9303f;
                    return;
                }
                i2 = mo703bc.f9294a;
                if (i2 != 2) {
                    i3 = mo703bc.f9294a;
                    if (i3 == 1) {
                        this.f9304g = 1;
                    }
                    j = mo703bc.f9295b;
                    m732c(j != C3282C.TIME_UNSET ? mo703bc.f9295b : Math.min((this.f9304g - 1) * 1000, 5000));
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.f9306i;
                this.f9305h = Thread.currentThread();
            }
            if (z) {
                String valueOf = String.valueOf(this.f9300c.getClass().getSimpleName());
                C2616ce.m2672u(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.f9300c.mo701e();
                    C2616ce.m2671v();
                } catch (Throwable th) {
                    C2616ce.m2671v();
                    throw th;
                }
            }
            synchronized (this) {
                this.f9305h = null;
                Thread.interrupted();
            }
            if (this.f9307j) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e) {
            if (this.f9307j) {
                return;
            }
            obtainMessage(2, e).sendToTarget();
        } catch (Exception e2) {
            if (this.f9307j) {
                return;
            }
            C2613cb.m2698a("LoadTask", "Unexpected exception loading stream", e2);
            obtainMessage(2, new C3166wo(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            if (this.f9307j) {
                return;
            }
            C2613cb.m2698a("LoadTask", "OutOfMemory error loading stream", e3);
            obtainMessage(2, new C3166wo(e3)).sendToTarget();
        } catch (Error e4) {
            if (!this.f9307j) {
                C2613cb.m2698a("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        }
    }
}
