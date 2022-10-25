package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1662k;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.h */
/* loaded from: classes.dex */
public class C1726h implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1662k f2486a;

    /* renamed from: b */
    private final SensorManager f2487b;

    /* renamed from: c */
    private final Sensor f2488c;

    /* renamed from: d */
    private final InterfaceC1727a f2489d;

    /* renamed from: e */
    private float f2490e;

    /* renamed from: com.applovin.impl.sdk.utils.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1727a {
        /* renamed from: b */
        void mo6244b();

        /* renamed from: c */
        void mo6243c();
    }

    public C1726h(C1662k c1662k, InterfaceC1727a interfaceC1727a) {
        this.f2486a = c1662k;
        SensorManager sensorManager = (SensorManager) c1662k.m6677J().getSystemService("sensor");
        this.f2487b = sensorManager;
        this.f2488c = sensorManager.getDefaultSensor(1);
        this.f2489d = interfaceC1727a;
    }

    /* renamed from: a */
    public void m6246a() {
        this.f2487b.unregisterListener(this);
        this.f2487b.registerListener(this, this.f2488c, (int) TimeUnit.MILLISECONDS.toMicros(50L));
        this.f2486a.m6631ai().unregisterReceiver(this);
        this.f2486a.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2486a.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    public void m6245b() {
        this.f2486a.m6631ai().unregisterReceiver(this);
        this.f2487b.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2487b.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            m6246a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.f2490e;
            float f2 = (f * 0.5f) + (max * 0.5f);
            this.f2490e = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.f2489d.mo6243c();
            } else if (f <= -0.8f || f2 >= -0.8f) {
            } else {
                this.f2489d.mo6244b();
            }
        }
    }
}
