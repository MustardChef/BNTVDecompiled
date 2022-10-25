package com.applovin.impl.sdk.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.applovin.impl.sdk.AppLovinBroadcastManager;

/* loaded from: classes.dex */
public class AppKilledService extends Service {
    public static final String ACTION_APP_KILLED = "com.applovin.app_killed";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        AppLovinBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(ACTION_APP_KILLED), null);
        stopSelf();
    }
}
