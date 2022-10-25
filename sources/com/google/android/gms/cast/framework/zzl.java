package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzl extends zzq {
    final /* synthetic */ CastSession zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzl(CastSession castSession, zzi zziVar) {
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.framework.zzr
    public final void zzb(String str, String str2) {
        com.google.android.gms.cast.zzq zzqVar;
        com.google.android.gms.cast.zzq zzqVar2;
        zzqVar = this.zza.zzh;
        if (zzqVar != null) {
            zzqVar2 = this.zza.zzh;
            ((zzbk) zzqVar2).zzr(str, str2, null).addOnCompleteListener(new OnCompleteListener(this) { // from class: com.google.android.gms.cast.framework.zzj
                private final zzl zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CastSession.zzi(this.zza.zza, "joinApplication", task);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.framework.zzr
    public final void zzc(String str, LaunchOptions launchOptions) {
        com.google.android.gms.cast.zzq zzqVar;
        com.google.android.gms.cast.zzq zzqVar2;
        zzqVar = this.zza.zzh;
        if (zzqVar != null) {
            zzqVar2 = this.zza.zzh;
            zzqVar2.zzf(str, launchOptions).addOnCompleteListener(new OnCompleteListener(this) { // from class: com.google.android.gms.cast.framework.zzk
                private final zzl zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CastSession.zzi(this.zza.zza, "launchApplication", task);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.framework.zzr
    public final void zzd(String str) {
        com.google.android.gms.cast.zzq zzqVar;
        com.google.android.gms.cast.zzq zzqVar2;
        zzqVar = this.zza.zzh;
        if (zzqVar != null) {
            zzqVar2 = this.zza.zzh;
            zzqVar2.zzg(str);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzr
    public final void zze(int i) {
        CastSession.zzf(this.zza, i);
    }
}
