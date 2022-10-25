package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.v */
/* loaded from: classes.dex */
public class C1770v {

    /* renamed from: b */
    private static final AtomicBoolean f2599b = new AtomicBoolean();

    /* renamed from: a */
    final C1662k f2600a;

    /* renamed from: c */
    private final AtomicBoolean f2601c = new AtomicBoolean();

    /* renamed from: d */
    private final AtomicBoolean f2602d = new AtomicBoolean();

    /* renamed from: e */
    private Date f2603e;

    /* renamed from: f */
    private Date f2604f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1770v(final C1662k c1662k) {
        this.f2600a = c1662k;
        final Application application = (Application) c1662k.m6677J();
        application.registerActivityLifecycleCallbacks(new AbstractC1718a() { // from class: com.applovin.impl.sdk.v.1
            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                C1770v.this.m6129d();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.applovin.impl.sdk.v.2
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
                if (i == 20) {
                    C1770v.this.m6128e();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() { // from class: com.applovin.impl.sdk.v.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (Utils.isCurrentProcessInForeground()) {
                        C1770v.this.m6129d();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C1770v.this.m6128e();
                }
            }
        }, intentFilter);
        if (((Boolean) c1662k.m6656a(C1568b.f1802cq)).booleanValue() && f2599b.compareAndSet(false, true)) {
            final Intent intent = new Intent(application, AppKilledService.class);
            application.startService(intent);
            c1662k.m6631ai().registerReceiver(new AppLovinBroadcastManager.Receiver() { // from class: com.applovin.impl.sdk.v.4
                @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
                public void onReceive(Context context, Intent intent2, Map<String, Object> map) {
                    application.stopService(intent);
                    c1662k.m6631ai().unregisterReceiver(this);
                }
            }, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6129d() {
        if (this.f2602d.compareAndSet(true, false)) {
            m6126g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m6128e() {
        if (this.f2602d.compareAndSet(false, true)) {
            m6127f();
        }
    }

    /* renamed from: f */
    private void m6127f() {
        this.f2600a.m6588z().m6319b("SessionTracker", "Application Paused");
        this.f2600a.m6631ai().sendBroadcastSync(new Intent("com.applovin.application_paused"), null);
        if (this.f2601c.get()) {
            return;
        }
        boolean booleanValue = ((Boolean) this.f2600a.m6656a(C1568b.f1851dn)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f2600a.m6656a(C1568b.f1853dp)).longValue());
        if (this.f2603e == null || System.currentTimeMillis() - this.f2603e.getTime() >= millis) {
            ((EventServiceImpl) this.f2600a.m6593u()).trackEvent("paused");
            if (booleanValue) {
                this.f2603e = new Date();
            }
        }
        if (booleanValue) {
            return;
        }
        this.f2603e = new Date();
    }

    /* renamed from: g */
    private void m6126g() {
        this.f2600a.m6588z().m6319b("SessionTracker", "Application Resumed");
        boolean booleanValue = ((Boolean) this.f2600a.m6656a(C1568b.f1851dn)).booleanValue();
        long longValue = ((Long) this.f2600a.m6656a(C1568b.f1852do)).longValue();
        this.f2600a.m6631ai().sendBroadcastSync(new Intent("com.applovin.application_resumed"), null);
        if (this.f2601c.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(longValue);
        if (this.f2604f == null || System.currentTimeMillis() - this.f2604f.getTime() >= millis) {
            ((EventServiceImpl) this.f2600a.m6593u()).trackEvent("resumed");
            if (booleanValue) {
                this.f2604f = new Date();
            }
        }
        if (!booleanValue) {
            this.f2604f = new Date();
        }
        this.f2600a.m6669R().m6893a(C1586f.f2042k);
    }

    /* renamed from: a */
    public boolean m6134a() {
        return this.f2602d.get();
    }

    /* renamed from: b */
    public void m6132b() {
        this.f2601c.set(true);
    }

    /* renamed from: c */
    public void m6130c() {
        this.f2601c.set(false);
    }
}
