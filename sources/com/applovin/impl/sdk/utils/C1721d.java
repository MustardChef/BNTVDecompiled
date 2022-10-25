package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1662k;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.utils.d */
/* loaded from: classes.dex */
public class C1721d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private static final Set<C1721d> f2477a = new HashSet();

    /* renamed from: b */
    private final C1760m f2478b;

    /* renamed from: c */
    private final C1662k f2479c;

    private C1721d(long j, C1662k c1662k, final Runnable runnable) {
        this.f2478b = C1760m.m6176a(j, c1662k, new Runnable() { // from class: com.applovin.impl.sdk.utils.d.1
            @Override // java.lang.Runnable
            public void run() {
                C1721d.this.m6284a();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
        this.f2479c = c1662k;
        f2477a.add(this);
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public static C1721d m6283a(long j, C1662k c1662k, Runnable runnable) {
        return new C1721d(j, c1662k, runnable);
    }

    /* renamed from: a */
    public void m6284a() {
        this.f2478b.m6169d();
        this.f2479c.m6631ai().unregisterReceiver(this);
        f2477a.remove(this);
    }

    /* renamed from: b */
    public long m6282b() {
        return this.f2478b.m6177a();
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2478b.m6173b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2478b.m6171c();
        }
    }
}
