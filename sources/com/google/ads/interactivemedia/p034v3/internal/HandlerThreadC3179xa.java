package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xa */
/* loaded from: classes2.dex */
public final class HandlerThreadC3179xa extends HandlerThread implements Handler.Callback {

    /* renamed from: a */
    private RunnableC2603bs f9350a;

    /* renamed from: b */
    private Handler f9351b;

    /* renamed from: c */
    private Error f9352c;

    /* renamed from: d */
    private RuntimeException f9353d;

    /* renamed from: e */
    private C3180xb f9354e;

    public HandlerThreadC3179xa() {
        super("ExoPlayer:DummySurface");
    }

    /* renamed from: a */
    public final C3180xb m686a(int i) {
        boolean z;
        start();
        this.f9351b = new Handler(getLooper(), this);
        this.f9350a = new RunnableC2603bs(this.f9351b);
        synchronized (this) {
            z = false;
            this.f9351b.obtainMessage(1, i, 0).sendToTarget();
            while (this.f9354e == null && this.f9353d == null && this.f9352c == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.f9353d;
        if (runtimeException == null) {
            Error error = this.f9352c;
            if (error == null) {
                C3180xb c3180xb = this.f9354e;
                C2616ce.m2689d(c3180xb);
                return c3180xb;
            }
            throw error;
        }
        throw runtimeException;
    }

    /* renamed from: b */
    public final void m685b() {
        C2616ce.m2689d(this.f9351b);
        this.f9351b.sendEmptyMessage(2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    return true;
                }
                try {
                    C2616ce.m2689d(this.f9350a);
                    this.f9350a.m2711c();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                int i2 = message.arg1;
                C2616ce.m2689d(this.f9350a);
                this.f9350a.m2712b(i2);
                this.f9354e = new C3180xb(this, this.f9350a.m2713a(), i2 != 0);
                synchronized (this) {
                    notify();
                }
            } catch (Error e) {
                C2613cb.m2698a("DummySurface", "Failed to initialize dummy surface", e);
                this.f9352c = e;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e2) {
                C2613cb.m2698a("DummySurface", "Failed to initialize dummy surface", e2);
                this.f9353d = e2;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
