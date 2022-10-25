package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.q */
/* loaded from: classes.dex */
public class C1707q {

    /* renamed from: a */
    private final C1662k f2446a;

    /* renamed from: c */
    private long f2448c;

    /* renamed from: f */
    private long f2451f;

    /* renamed from: g */
    private Object f2452g;

    /* renamed from: b */
    private final AtomicBoolean f2447b = new AtomicBoolean();

    /* renamed from: d */
    private final Object f2449d = new Object();

    /* renamed from: e */
    private final AtomicBoolean f2450e = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1707q(C1662k c1662k) {
        this.f2446a = c1662k;
    }

    /* renamed from: a */
    public void m6334a(final Object obj) {
        this.f2446a.m6630aj().m6523a(obj);
        if (!C1391c.m7597a(obj) && this.f2447b.compareAndSet(false, true)) {
            this.f2452g = obj;
            this.f2448c = System.currentTimeMillis();
            C1710r m6588z = this.f2446a.m6588z();
            m6588z.m6319b("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f2448c);
            this.f2446a.m6631ai().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final long longValue = ((Long) this.f2446a.m6656a(C1568b.f1730bW)).longValue();
            if (longValue >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.q.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (C1707q.this.f2447b.get() && System.currentTimeMillis() - C1707q.this.f2448c >= longValue) {
                            C1707q.this.f2446a.m6588z().m6319b("FullScreenAdTracker", "Resetting \"display\" state...");
                            C1707q.this.m6330b(obj);
                        }
                    }
                }, longValue);
            }
        }
    }

    /* renamed from: a */
    public void m6333a(boolean z) {
        synchronized (this.f2449d) {
            this.f2450e.set(z);
            if (z) {
                this.f2451f = System.currentTimeMillis();
                C1710r m6588z = this.f2446a.m6588z();
                m6588z.m6319b("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f2451f);
                final long longValue = ((Long) this.f2446a.m6656a(C1568b.f1729bV)).longValue();
                if (longValue >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.q.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (C1707q.this.m6336a() && System.currentTimeMillis() - C1707q.this.f2451f >= longValue) {
                                C1707q.this.f2446a.m6588z().m6319b("FullScreenAdTracker", "Resetting \"pending display\" state...");
                                C1707q.this.f2450e.set(false);
                            }
                        }
                    }, longValue);
                }
            } else {
                this.f2451f = 0L;
                C1710r m6588z2 = this.f2446a.m6588z();
                m6588z2.m6319b("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
            }
        }
    }

    /* renamed from: a */
    public boolean m6336a() {
        return this.f2450e.get();
    }

    /* renamed from: b */
    public void m6330b(Object obj) {
        this.f2446a.m6630aj().m6520b(obj);
        if (!C1391c.m7597a(obj) && this.f2447b.compareAndSet(true, false)) {
            this.f2452g = null;
            C1710r m6588z = this.f2446a.m6588z();
            m6588z.m6319b("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            this.f2446a.m6631ai().sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    /* renamed from: b */
    public boolean m6332b() {
        return this.f2447b.get();
    }

    /* renamed from: c */
    public Object m6329c() {
        return this.f2452g;
    }
}
