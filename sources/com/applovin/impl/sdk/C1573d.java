package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.utils.C1760m;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.d */
/* loaded from: classes.dex */
public class C1573d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private C1760m f1961a;

    /* renamed from: b */
    private final Object f1962b = new Object();

    /* renamed from: c */
    private final AtomicBoolean f1963c = new AtomicBoolean();

    /* renamed from: d */
    private final C1662k f1964d;

    /* renamed from: e */
    private final WeakReference<InterfaceC1575a> f1965e;

    /* renamed from: f */
    private long f1966f;

    /* renamed from: com.applovin.impl.sdk.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1575a {
        void onAdRefresh();
    }

    public C1573d(C1662k c1662k, InterfaceC1575a interfaceC1575a) {
        this.f1965e = new WeakReference<>(interfaceC1575a);
        this.f1964d = c1662k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6965h() {
        synchronized (this.f1962b) {
            this.f1961a = null;
            if (!((Boolean) this.f1964d.m6656a(C1567a.f1641s)).booleanValue()) {
                this.f1964d.m6631ai().unregisterReceiver(this);
            }
        }
    }

    /* renamed from: i */
    private void m6964i() {
        if (((Boolean) this.f1964d.m6656a(C1567a.f1640r)).booleanValue()) {
            m6969d();
        }
    }

    /* renamed from: j */
    private void m6963j() {
        if (((Boolean) this.f1964d.m6656a(C1567a.f1640r)).booleanValue()) {
            synchronized (this.f1962b) {
                if (this.f1964d.m6638ab().m6134a()) {
                    this.f1964d.m6588z().m6319b("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                    return;
                }
                C1760m c1760m = this.f1961a;
                if (c1760m != null) {
                    c1760m.m6171c();
                }
            }
        }
    }

    /* renamed from: a */
    public void m6974a(long j) {
        synchronized (this.f1962b) {
            m6970c();
            this.f1966f = j;
            this.f1961a = C1760m.m6176a(j, this.f1964d, new Runnable() { // from class: com.applovin.impl.sdk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    C1573d.this.m6965h();
                    InterfaceC1575a interfaceC1575a = (InterfaceC1575a) C1573d.this.f1965e.get();
                    if (interfaceC1575a != null) {
                        interfaceC1575a.onAdRefresh();
                    }
                }
            });
            if (!((Boolean) this.f1964d.m6656a(C1567a.f1641s)).booleanValue()) {
                this.f1964d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
                this.f1964d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
                this.f1964d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                this.f1964d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.f1964d.m6656a(C1567a.f1640r)).booleanValue() && (this.f1964d.m6637ac().m6332b() || this.f1964d.m6638ab().m6134a())) {
                this.f1961a.m6173b();
            }
            if (this.f1963c.compareAndSet(true, false) && ((Boolean) this.f1964d.m6656a(C1567a.f1642t)).booleanValue()) {
                this.f1964d.m6588z().m6319b("AdRefreshManager", "Pausing refresh for a previous request.");
                this.f1961a.m6173b();
            }
        }
    }

    /* renamed from: a */
    public boolean m6975a() {
        boolean z;
        synchronized (this.f1962b) {
            z = this.f1961a != null;
        }
        return z;
    }

    /* renamed from: b */
    public long m6972b() {
        long m6177a;
        synchronized (this.f1962b) {
            C1760m c1760m = this.f1961a;
            m6177a = c1760m != null ? c1760m.m6177a() : -1L;
        }
        return m6177a;
    }

    /* renamed from: c */
    public void m6970c() {
        synchronized (this.f1962b) {
            C1760m c1760m = this.f1961a;
            if (c1760m != null) {
                c1760m.m6169d();
                m6965h();
            }
        }
    }

    /* renamed from: d */
    public void m6969d() {
        synchronized (this.f1962b) {
            C1760m c1760m = this.f1961a;
            if (c1760m != null) {
                c1760m.m6173b();
            } else {
                this.f1964d.m6588z().m6319b("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                this.f1963c.set(true);
            }
        }
    }

    /* renamed from: e */
    public void m6968e() {
        synchronized (this.f1962b) {
            C1760m c1760m = this.f1961a;
            if (c1760m != null) {
                c1760m.m6171c();
            } else {
                this.f1963c.set(false);
            }
        }
    }

    /* renamed from: f */
    public void m6967f() {
        if (((Boolean) this.f1964d.m6656a(C1567a.f1639q)).booleanValue()) {
            m6969d();
        }
    }

    /* renamed from: g */
    public void m6966g() {
        InterfaceC1575a interfaceC1575a;
        if (((Boolean) this.f1964d.m6656a(C1567a.f1639q)).booleanValue()) {
            synchronized (this.f1962b) {
                if (this.f1964d.m6637ac().m6332b()) {
                    this.f1964d.m6588z().m6319b("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                    return;
                }
                boolean z = false;
                if (this.f1961a != null) {
                    long m6972b = this.f1966f - m6972b();
                    long longValue = ((Long) this.f1964d.m6656a(C1567a.f1638p)).longValue();
                    if (longValue < 0 || m6972b <= longValue) {
                        this.f1961a.m6171c();
                    } else {
                        m6970c();
                        z = true;
                    }
                }
                if (!z || (interfaceC1575a = this.f1965e.get()) == null) {
                    return;
                }
                interfaceC1575a.onAdRefresh();
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m6967f();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m6966g();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            m6964i();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            m6963j();
        }
    }
}
