package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzbj implements Executor {
    private static final zzbj zza = new zzbj();
    private final Handler zzb = new com.google.android.gms.internal.p038firebaseauthapi.zzi(Looper.getMainLooper());

    private zzbj() {
    }

    public static zzbj zza() {
        return zza;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }
}
