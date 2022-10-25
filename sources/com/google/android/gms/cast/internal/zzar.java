package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.cast.zzci;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzar {
    zzap zzb;
    Runnable zzc;
    private final long zze;
    private static final Logger zzg = new Logger("RequestTracker");
    public static final Object zzd = new Object();
    long zza = -1;
    private final Handler zzf = new zzci(Looper.getMainLooper());

    public zzar(long j) {
        this.zze = j;
    }

    private final boolean zzg(int i, Object obj) {
        synchronized (zzd) {
            if (this.zza != -1) {
                zzh(i, null, String.format(Locale.ROOT, "clearing request %d", Long.valueOf(this.zza)));
                return true;
            }
            return false;
        }
    }

    private final void zzh(int i, Object obj, String str) {
        zzg.m369d(str, new Object[0]);
        Object obj2 = zzd;
        synchronized (obj2) {
            zzap zzapVar = this.zzb;
            if (zzapVar != null) {
                zzapVar.zzb(this.zza, i, obj);
            }
            this.zza = -1L;
            this.zzb = null;
            synchronized (obj2) {
                Runnable runnable = this.zzc;
                if (runnable != null) {
                    this.zzf.removeCallbacks(runnable);
                    this.zzc = null;
                }
            }
        }
    }

    public final void zza(long j, zzap zzapVar) {
        zzap zzapVar2;
        long j2;
        Object obj = zzd;
        synchronized (obj) {
            zzapVar2 = this.zzb;
            j2 = this.zza;
            this.zza = j;
            this.zzb = zzapVar;
        }
        if (zzapVar2 != null) {
            zzapVar2.zza(j2);
        }
        synchronized (obj) {
            Runnable runnable = this.zzc;
            if (runnable != null) {
                this.zzf.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable(this) { // from class: com.google.android.gms.cast.internal.zzaq
                private final zzar zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            };
            this.zzc = runnable2;
            this.zzf.postDelayed(runnable2, this.zze);
        }
    }

    public final boolean zzb() {
        boolean z;
        synchronized (zzd) {
            z = this.zza != -1;
        }
        return z;
    }

    public final boolean zzc(long j) {
        boolean z;
        synchronized (zzd) {
            long j2 = this.zza;
            z = false;
            if (j2 != -1 && j2 == j) {
                z = true;
            }
        }
        return z;
    }

    public final boolean zzd(long j, int i, Object obj) {
        synchronized (zzd) {
            long j2 = this.zza;
            if (j2 == -1 || j2 != j) {
                return false;
            }
            zzh(i, obj, String.format(Locale.ROOT, "request %d completed", Long.valueOf(j)));
            return true;
        }
    }

    public final boolean zze(int i) {
        return zzg(2002, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf() {
        synchronized (zzd) {
            if (this.zza == -1) {
                return;
            }
            zzg(15, null);
        }
    }
}
