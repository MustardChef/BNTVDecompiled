package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.f */
/* loaded from: classes.dex */
public class C1644f extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public static int f2195a = -1;

    /* renamed from: b */
    private final AudioManager f2196b;

    /* renamed from: c */
    private final Context f2197c;

    /* renamed from: d */
    private final C1662k f2198d;

    /* renamed from: e */
    private final Set<InterfaceC1646a> f2199e = new HashSet();

    /* renamed from: f */
    private final Object f2200f = new Object();

    /* renamed from: g */
    private boolean f2201g;

    /* renamed from: h */
    private int f2202h;

    /* renamed from: com.applovin.impl.sdk.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1646a {
        void onRingerModeChanged(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1644f(C1662k c1662k) {
        this.f2198d = c1662k;
        Context m6677J = c1662k.m6677J();
        this.f2197c = m6677J;
        this.f2196b = (AudioManager) m6677J.getSystemService("audio");
    }

    /* renamed from: a */
    public static boolean m6738a(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: b */
    private void m6736b() {
        this.f2198d.m6588z().m6319b("AudioSessionManager", "Observing ringer mode...");
        this.f2202h = f2195a;
        this.f2197c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f2198d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2198d.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    private void m6735b(final int i) {
        if (this.f2201g) {
            return;
        }
        C1710r m6588z = this.f2198d.m6588z();
        m6588z.m6319b("AudioSessionManager", "Ringer mode is " + i);
        synchronized (this.f2200f) {
            for (final InterfaceC1646a interfaceC1646a : this.f2199e) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC1646a.onRingerModeChanged(i);
                    }
                });
            }
        }
    }

    /* renamed from: c */
    private void m6733c() {
        this.f2198d.m6588z().m6319b("AudioSessionManager", "Stopping observation of mute switch state...");
        this.f2197c.unregisterReceiver(this);
        this.f2198d.m6631ai().unregisterReceiver(this);
    }

    /* renamed from: a */
    public int m6739a() {
        return this.f2196b.getRingerMode();
    }

    /* renamed from: a */
    public void m6737a(InterfaceC1646a interfaceC1646a) {
        synchronized (this.f2200f) {
            if (this.f2199e.contains(interfaceC1646a)) {
                return;
            }
            this.f2199e.add(interfaceC1646a);
            if (this.f2199e.size() == 1) {
                m6736b();
            }
        }
    }

    /* renamed from: b */
    public void m6734b(InterfaceC1646a interfaceC1646a) {
        synchronized (this.f2200f) {
            if (this.f2199e.contains(interfaceC1646a)) {
                this.f2199e.remove(interfaceC1646a);
                if (this.f2199e.isEmpty()) {
                    m6733c();
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            m6735b(this.f2196b.getRingerMode());
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2201g = true;
            this.f2202h = this.f2196b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2201g = false;
            if (this.f2202h != this.f2196b.getRingerMode()) {
                this.f2202h = f2195a;
                m6735b(this.f2196b.getRingerMode());
            }
        }
    }
}
