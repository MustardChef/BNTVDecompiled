package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzkc extends zzop<zzkd, zzkc> implements zzpz {
    private zzkc() {
        super(zzkd.zzc());
    }

    public final zzkc zza(zzkj zzkjVar) {
        if (this.zzb) {
            zzm();
            this.zzb = false;
        }
        zzkd.zzd((zzkd) this.zza, zzkjVar);
        return this;
    }

    public final zzkc zzb(Iterable<? extends zzjt> iterable) {
        if (this.zzb) {
            zzm();
            this.zzb = false;
        }
        zzkd.zze((zzkd) this.zza, iterable);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkc(zzjx zzjxVar) {
        super(zzkd.zzc());
    }
}
