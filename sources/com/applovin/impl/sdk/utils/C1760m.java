package com.applovin.impl.sdk.utils;

import com.applovin.impl.sdk.C1662k;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.applovin.impl.sdk.utils.m */
/* loaded from: classes.dex */
public class C1760m {

    /* renamed from: a */
    private final C1662k f2571a;

    /* renamed from: b */
    private Timer f2572b;

    /* renamed from: c */
    private long f2573c;

    /* renamed from: d */
    private long f2574d;

    /* renamed from: e */
    private final Runnable f2575e;

    /* renamed from: f */
    private long f2576f;

    /* renamed from: g */
    private final Object f2577g = new Object();

    private C1760m(C1662k c1662k, Runnable runnable) {
        this.f2571a = c1662k;
        this.f2575e = runnable;
    }

    /* renamed from: a */
    public static C1760m m6176a(long j, C1662k c1662k, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        } else if (runnable != null) {
            C1760m c1760m = new C1760m(c1662k, runnable);
            c1760m.f2573c = System.currentTimeMillis();
            c1760m.f2574d = j;
            try {
                Timer timer = new Timer();
                c1760m.f2572b = timer;
                timer.schedule(c1760m.m6168e(), j);
            } catch (OutOfMemoryError e) {
                c1662k.m6588z().m6318b("Timer", "Failed to create timer due to OOM error", e);
            }
            return c1760m;
        } else {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
    }

    /* renamed from: e */
    private TimerTask m6168e() {
        return new TimerTask() { // from class: com.applovin.impl.sdk.utils.m.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    C1760m.this.f2575e.run();
                    synchronized (C1760m.this.f2577g) {
                        C1760m.this.f2572b = null;
                    }
                } catch (Throwable th) {
                    try {
                        if (C1760m.this.f2571a != null) {
                            C1760m.this.f2571a.m6588z().m6318b("Timer", "Encountered error while executing timed task", th);
                        }
                        synchronized (C1760m.this.f2577g) {
                            C1760m.this.f2572b = null;
                        }
                    } catch (Throwable th2) {
                        synchronized (C1760m.this.f2577g) {
                            C1760m.this.f2572b = null;
                            throw th2;
                        }
                    }
                }
            }
        };
    }

    /* renamed from: a */
    public long m6177a() {
        if (this.f2572b != null) {
            return this.f2574d - (System.currentTimeMillis() - this.f2573c);
        }
        return this.f2574d - this.f2576f;
    }

    /* renamed from: b */
    public void m6173b() {
        synchronized (this.f2577g) {
            Timer timer = this.f2572b;
            if (timer != null) {
                timer.cancel();
                this.f2576f = Math.max(1L, System.currentTimeMillis() - this.f2573c);
                this.f2572b = null;
            }
        }
    }

    /* renamed from: c */
    public void m6171c() {
        synchronized (this.f2577g) {
            long j = this.f2576f;
            if (j > 0) {
                long j2 = this.f2574d - j;
                this.f2574d = j2;
                if (j2 < 0) {
                    this.f2574d = 0L;
                }
                Timer timer = new Timer();
                this.f2572b = timer;
                timer.schedule(m6168e(), this.f2574d);
                this.f2573c = System.currentTimeMillis();
                this.f2576f = 0L;
            }
        }
    }

    /* renamed from: d */
    public void m6169d() {
        synchronized (this.f2577g) {
            Timer timer = this.f2572b;
            if (timer != null) {
                timer.cancel();
                this.f2572b = null;
                this.f2576f = 0L;
            }
        }
    }
}
