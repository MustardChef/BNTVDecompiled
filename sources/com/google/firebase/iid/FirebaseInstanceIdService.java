package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
@Deprecated
/* loaded from: classes3.dex */
public class FirebaseInstanceIdService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Deprecated
    public void onTokenRefresh() {
    }
}
