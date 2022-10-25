package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzam {
    private static final Logger zzg = new Logger("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    final long zzc;
    final HandlerThread zzd;
    final Handler zze;
    final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.m340v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzh = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new com.google.android.gms.internal.p038firebaseauthapi.zzi(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp2.getName());
        this.zzc = 300000L;
    }

    public final void zza() {
        Logger logger = zzg;
        long j = this.zza;
        long j2 = this.zzc;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j - j2);
        logger.m340v(sb.toString(), new Object[0]);
        zzc();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zzc, 0L) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzc() {
        this.zze.removeCallbacks(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            long j2 = this.zzb;
            j = j2 + j2;
        } else {
            j = i != 960 ? 30L : 960L;
        }
        this.zzb = j;
        this.zza = DefaultClock.getInstance().currentTimeMillis() + (this.zzb * 1000);
        Logger logger = zzg;
        long j3 = this.zza;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j3);
        logger.m340v(sb.toString(), new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
