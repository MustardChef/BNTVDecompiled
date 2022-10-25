package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzju;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjq<T extends Context & zzju> {
    private final T zza;

    public zzjq(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() {
        zzfu.zza(this.zza, null, null).zzq().zzw().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzfu.zza(this.zza, null, null).zzq().zzw().zza("Local AppMeasurementService is shutting down");
    }

    public final int zza(final Intent intent, int i, final int i2) {
        final zzeq zzq = zzfu.zza(this.zza, null, null).zzq();
        if (intent == null) {
            zzq.zzh().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzq.zzw().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable(this, i2, zzq, intent) { // from class: com.google.android.gms.measurement.internal.zzjt
                private final zzjq zza;
                private final int zzb;
                private final zzeq zzc;
                private final Intent zzd;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = i2;
                    this.zzc = zzq;
                    this.zzd = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc, this.zzd);
                }
            });
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzkl zza = zzkl.zza(this.zza);
        zza.zzp().zza(new zzjv(this, zza, runnable));
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfz(zzkl.zza(this.zza));
        }
        zzc().zzh().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzw().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zza(final JobParameters jobParameters) {
        final zzeq zzq = zzfu.zza(this.zza, null, null).zzq();
        String string = jobParameters.getExtras().getString("action");
        zzq.zzw().zza("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zza(new Runnable(this, zzq, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzjs
                private final zzjq zza;
                private final zzeq zzb;
                private final JobParameters zzc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = zzq;
                    this.zzc = jobParameters;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc);
                }
            });
            return true;
        }
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onRebind called with null intent");
            return;
        }
        zzc().zzw().zza("onRebind called. action", intent.getAction());
    }

    private final zzeq zzc() {
        return zzfu.zza(this.zza, null, null).zzq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzeq zzeqVar, JobParameters jobParameters) {
        zzeqVar.zzw().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzeq zzeqVar, Intent intent) {
        if (this.zza.zza(i)) {
            zzeqVar.zzw().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzw().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }
}
