package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzhy implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhb zza;

    private zzhy(zzhb zzhbVar) {
        this.zza = zzhbVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzq().zzw().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                this.zza.zzo();
                this.zza.zzp().zza(new zzib(this, bundle == null, data, zzkv.zza(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
            }
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzh().zza(activity, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x00a1, B:35:0x00af, B:37:0x00c2, B:40:0x00ca, B:42:0x00d0, B:43:0x00e3, B:45:0x00f6, B:47:0x00ff, B:50:0x010f, B:53:0x011f, B:56:0x0127, B:58:0x012d, B:59:0x0138, B:62:0x013f, B:66:0x0160, B:68:0x0173, B:70:0x018a, B:69:0x017b, B:72:0x0191, B:74:0x0197, B:76:0x019d, B:78:0x01a3, B:80:0x01a9, B:82:0x01b1, B:86:0x01bc, B:88:0x01ca, B:90:0x01d0, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x0081, B:28:0x008c, B:30:0x0096, B:27:0x0086), top: B:95:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010f A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x00a1, B:35:0x00af, B:37:0x00c2, B:40:0x00ca, B:42:0x00d0, B:43:0x00e3, B:45:0x00f6, B:47:0x00ff, B:50:0x010f, B:53:0x011f, B:56:0x0127, B:58:0x012d, B:59:0x0138, B:62:0x013f, B:66:0x0160, B:68:0x0173, B:70:0x018a, B:69:0x017b, B:72:0x0191, B:74:0x0197, B:76:0x019d, B:78:0x01a3, B:80:0x01a9, B:82:0x01b1, B:86:0x01bc, B:88:0x01ca, B:90:0x01d0, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x0081, B:28:0x008c, B:30:0x0096, B:27:0x0086), top: B:95:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013f A[Catch: Exception -> 0x01d6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:33:0x00a1, B:35:0x00af, B:37:0x00c2, B:40:0x00ca, B:42:0x00d0, B:43:0x00e3, B:45:0x00f6, B:47:0x00ff, B:50:0x010f, B:53:0x011f, B:56:0x0127, B:58:0x012d, B:59:0x0138, B:62:0x013f, B:66:0x0160, B:68:0x0173, B:70:0x018a, B:69:0x017b, B:72:0x0191, B:74:0x0197, B:76:0x019d, B:78:0x01a3, B:80:0x01a9, B:82:0x01b1, B:86:0x01bc, B:88:0x01ca, B:90:0x01d0, B:12:0x0044, B:15:0x0051, B:17:0x0057, B:19:0x005d, B:21:0x0063, B:23:0x0069, B:24:0x0075, B:26:0x0081, B:28:0x008c, B:30:0x0096, B:27:0x0086), top: B:95:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzh().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzh().zzb(activity);
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjz(zzj, zzj.zzl().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzjx zzj = this.zza.zzj();
        zzj.zzp().zza(new zzjw(zzj, zzj.zzl().elapsedRealtime()));
        this.zza.zzh().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzh().zzb(activity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhy(zzhb zzhbVar, zzhc zzhcVar) {
        this(zzhbVar);
    }
}
