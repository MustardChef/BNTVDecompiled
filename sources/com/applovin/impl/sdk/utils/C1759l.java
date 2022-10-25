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
import com.applovin.impl.sdk.p029c.C1568b;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.l */
/* loaded from: classes.dex */
public class C1759l implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final int f2563a;

    /* renamed from: b */
    private final float f2564b;

    /* renamed from: c */
    private final SensorManager f2565c;

    /* renamed from: d */
    private final Sensor f2566d;

    /* renamed from: e */
    private final Sensor f2567e;

    /* renamed from: f */
    private final C1662k f2568f;

    /* renamed from: g */
    private float[] f2569g;

    /* renamed from: h */
    private float f2570h;

    public C1759l(C1662k c1662k) {
        this.f2568f = c1662k;
        SensorManager sensorManager = (SensorManager) c1662k.m6677J().getSystemService("sensor");
        this.f2565c = sensorManager;
        this.f2566d = sensorManager.getDefaultSensor(9);
        this.f2567e = sensorManager.getDefaultSensor(4);
        this.f2563a = ((Integer) c1662k.m6656a(C1568b.f1830dS)).intValue();
        this.f2564b = ((Float) c1662k.m6656a(C1568b.f1829dR)).floatValue();
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void m6180a() {
        this.f2565c.unregisterListener(this);
        if (((Boolean) this.f2568f.m6678I().m7003a(C1568b.f1827dP)).booleanValue()) {
            this.f2565c.registerListener(this, this.f2566d, (int) TimeUnit.MILLISECONDS.toMicros(this.f2563a));
        }
        if (((Boolean) this.f2568f.m6678I().m7003a(C1568b.f1828dQ)).booleanValue()) {
            this.f2565c.registerListener(this, this.f2567e, (int) TimeUnit.MILLISECONDS.toMicros(this.f2563a));
        }
    }

    /* renamed from: b */
    public float m6179b() {
        return this.f2570h;
    }

    /* renamed from: c */
    public float m6178c() {
        float[] fArr = this.f2569g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(fArr[2] / 9.81f));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2565c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            m6180a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f2569g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.f2570h * this.f2564b;
            this.f2570h = f;
            this.f2570h = f + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
