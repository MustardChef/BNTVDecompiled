package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzg implements SessionManagerListener<CastSession> {
    final /* synthetic */ zzh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzg(zzh zzhVar, zzf zzfVar) {
        this.zza = zzhVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnded(CastSession castSession, int i) {
        zzh.zzj(this.zza, castSession, i);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnding(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(CastSession castSession, int i) {
        zzh.zzj(this.zza, castSession, i);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumed(CastSession castSession, boolean z) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzr(castSession);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzkt zzc = zzjVar.zzc(zziVar2, z);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzc, zzhi.APP_SESSION_RESUMED);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzo();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResuming(CastSession castSession, String str) {
        SharedPreferences sharedPreferences;
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        zzh zzhVar = this.zza;
        sharedPreferences = zzhVar.zzf;
        zzh.zzl(zzhVar, sharedPreferences, str);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzkt zzb = zzjVar.zzb(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzb, zzhi.APP_SESSION_RESUMING);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStartFailed(CastSession castSession, int i) {
        zzh.zzj(this.zza, castSession, i);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarted(CastSession castSession, String str) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzr(castSession);
        zziVar = this.zza.zzg;
        zziVar.zzg = str;
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzkt zza = zzjVar.zza(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zza, zzhi.APP_SESSION_RUNNING);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzo();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarting(CastSession castSession) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        Logger logger;
        CastSession castSession2 = castSession;
        zziVar = this.zza.zzg;
        if (zziVar != null) {
            logger = zzh.zza;
            logger.m362w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzq(castSession2);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzkt zza = zzjVar.zza(zziVar2);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zza, zzhi.APP_SESSION_STARTING);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionSuspended(CastSession castSession, int i) {
        zzi zziVar;
        zzj zzjVar;
        zzi zziVar2;
        zzd zzdVar;
        this.zza.zzr(castSession);
        zziVar = this.zza.zzg;
        Preconditions.checkNotNull(zziVar);
        zzjVar = this.zza.zzc;
        zziVar2 = this.zza.zzg;
        zzkt zzd = zzjVar.zzd(zziVar2, i);
        zzdVar = this.zza.zzb;
        zzdVar.zzb(zzd, zzhi.APP_SESSION_SUSPENDED);
        r2.zzg.zzc(this.zza.zzf);
        this.zza.zzp();
    }
}
