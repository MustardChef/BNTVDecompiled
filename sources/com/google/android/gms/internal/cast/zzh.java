package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzh {
    private static final Logger zza = new Logger("ApplicationAnalytics");
    private final zzd zzb;
    private final zzj zzc;
    private final SharedPreferences zzf;
    private zzi zzg;
    private final Handler zze = new zzci(Looper.getMainLooper());
    private final Runnable zzd = new Runnable(this) { // from class: com.google.android.gms.internal.cast.zze
        private final zzh zza;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.zza = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzn();
        }
    };

    public zzh(SharedPreferences sharedPreferences, zzd zzdVar, Bundle bundle, String str) {
        this.zzf = sharedPreferences;
        this.zzb = zzdVar;
        this.zzc = new zzj(bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzh zzhVar, CastSession castSession, int i) {
        zzhVar.zzr(castSession);
        zzhVar.zzb.zzb(zzhVar.zzc.zzd(zzhVar.zzg, i), zzhi.APP_SESSION_END);
        zzhVar.zzp();
        zzhVar.zzg = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzh zzhVar, SharedPreferences sharedPreferences, String str) {
        if (zzhVar.zzu(str)) {
            zza.m369d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzhVar.zzg);
            return;
        }
        zzhVar.zzg = zzi.zzb(sharedPreferences);
        if (zzhVar.zzu(str)) {
            zza.m369d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzhVar.zzg);
            zzi.zza = zzhVar.zzg.zzd + 1;
            return;
        }
        zza.m369d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzi zza2 = zzi.zza();
        zzhVar.zzg = zza2;
        zza2.zzb = zzv();
        zzhVar.zzg.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        ((Handler) Preconditions.checkNotNull(this.zze)).postDelayed((Runnable) Preconditions.checkNotNull(this.zzd), 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp() {
        this.zze.removeCallbacks(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzq(CastSession castSession) {
        zza.m369d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzi zza2 = zzi.zza();
        this.zzg = zza2;
        zza2.zzb = zzv();
        CastDevice castDevice = castSession == null ? null : castSession.getCastDevice();
        if (castDevice != null) {
            zzs(castDevice);
        }
        Preconditions.checkNotNull(this.zzg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzr(CastSession castSession) {
        if (zzt()) {
            CastDevice castDevice = castSession != null ? castSession.getCastDevice() : null;
            if (castDevice != null && !TextUtils.equals(this.zzg.zzc, castDevice.zza())) {
                zzs(castDevice);
            }
            Preconditions.checkNotNull(this.zzg);
            return;
        }
        zza.m362w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
        zzq(castSession);
    }

    private final void zzs(CastDevice castDevice) {
        zzi zziVar = this.zzg;
        if (zziVar == null) {
            return;
        }
        zziVar.zzc = castDevice.zza();
        Preconditions.checkNotNull(this.zzg);
        this.zzg.zzf = castDevice.zzb();
    }

    @EnsuresNonNullIf(expression = {"analyticsSession"}, result = true)
    private final boolean zzt() {
        String str;
        if (this.zzg == null) {
            zza.m369d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzv = zzv();
        if (zzv == null || (str = this.zzg.zzb) == null || !TextUtils.equals(str, zzv)) {
            zza.m369d("The analytics session doesn't match the application ID %s", zzv);
            return false;
        }
        Preconditions.checkNotNull(this.zzg);
        return true;
    }

    private final boolean zzu(String str) {
        String str2;
        if (zzt()) {
            Preconditions.checkNotNull(this.zzg);
            if (str == null || (str2 = this.zzg.zzg) == null || !TextUtils.equals(str2, str)) {
                zza.m369d("The analytics session doesn't match the receiver session ID %s.", str);
                return false;
            }
            return true;
        }
        return false;
    }

    @Pure
    private static String zzv() {
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    public final void zza(SessionManager sessionManager) {
        sessionManager.addSessionManagerListener(new zzg(this, null), CastSession.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzn() {
        zzi zziVar = this.zzg;
        if (zziVar != null) {
            this.zzb.zzb(this.zzc.zza(zziVar), zzhi.APP_SESSION_PING);
        }
        zzo();
    }
}
