package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.utils.C1760m;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
/* loaded from: classes.dex */
public class C1545b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1662k f1554a;

    /* renamed from: b */
    private final InterfaceC1547a f1555b;

    /* renamed from: c */
    private C1760m f1556c;

    /* renamed from: d */
    private final Object f1557d = new Object();

    /* renamed from: e */
    private long f1558e;

    /* renamed from: com.applovin.impl.sdk.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1547a {
        void onAdExpired();
    }

    public C1545b(C1662k c1662k, InterfaceC1547a interfaceC1547a) {
        this.f1554a = c1662k;
        this.f1555b = interfaceC1547a;
    }

    /* renamed from: b */
    private void m7060b() {
        C1760m c1760m = this.f1556c;
        if (c1760m != null) {
            c1760m.m6169d();
            this.f1556c = null;
        }
    }

    /* renamed from: c */
    private void m7059c() {
        synchronized (this.f1557d) {
            m7060b();
        }
    }

    /* renamed from: d */
    private void m7058d() {
        boolean z;
        synchronized (this.f1557d) {
            long currentTimeMillis = this.f1558e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                m7063a();
                z = true;
            } else {
                m7062a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.f1555b.onAdExpired();
        }
    }

    /* renamed from: a */
    public void m7063a() {
        synchronized (this.f1557d) {
            m7060b();
            this.f1554a.m6631ai().unregisterReceiver(this);
        }
    }

    /* renamed from: a */
    public void m7062a(long j) {
        synchronized (this.f1557d) {
            m7063a();
            this.f1558e = System.currentTimeMillis() + j;
            this.f1554a.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f1554a.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f1554a.m6656a(C1567a.f1607F)).booleanValue() || !this.f1554a.m6638ab().m6134a()) {
                this.f1556c = C1760m.m6176a(j, this.f1554a, new Runnable() { // from class: com.applovin.impl.sdk.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1545b.this.m7063a();
                        C1545b.this.f1555b.onAdExpired();
                    }
                });
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m7059c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m7058d();
        }
    }
}
