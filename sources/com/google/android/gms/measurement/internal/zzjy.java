package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjy {
    final /* synthetic */ zzjx zza;
    private zzkb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzjx zzjxVar) {
        this.zza = zzjxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        Handler handler;
        this.zza.zzc();
        if (this.zzb != null) {
            handler = this.zza.zzc;
            handler.removeCallbacks(this.zzb);
        }
        if (this.zza.zzs().zza(zzas.zzbu)) {
            this.zza.zzr().zzr.zza(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j) {
        Handler handler;
        this.zzb = new zzkb(this, this.zza.zzl().currentTimeMillis(), j);
        handler = this.zza.zzc;
        handler.postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
