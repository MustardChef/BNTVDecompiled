package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjx extends zzg {
    protected final zzkf zza;
    protected final zzkd zzb;
    private Handler zzc;
    private final zzjy zzd;

    public zzjx(zzfu zzfuVar) {
        super(zzfuVar);
        this.zza = new zzkf(this);
        this.zzb = new zzkd(this);
        this.zzd = new zzjy(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzy() {
        return false;
    }

    public final void zzaa() {
        zzc();
        if (this.zzc == null) {
            this.zzc = new com.google.android.gms.internal.measurement.zzq(Looper.getMainLooper());
        }
    }

    public final void zzb(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity resumed, time", Long.valueOf(j));
        if (zzs().zza(zzas.zzbu)) {
            if (zzs().zzh().booleanValue() || zzr().zzr.zza()) {
                this.zzb.zza(j);
            }
            this.zzd.zza();
        } else {
            this.zzd.zza();
            if (zzs().zzh().booleanValue()) {
                this.zzb.zza(j);
            }
        }
        zzkf zzkfVar = this.zza;
        zzkfVar.zza.zzc();
        if (zzkfVar.zza.zzy.zzaa()) {
            if (!zzkfVar.zza.zzs().zza(zzas.zzbu)) {
                zzkfVar.zza.zzr().zzr.zza(false);
            }
            zzkfVar.zza(zzkfVar.zza.zzl().currentTimeMillis(), false);
        }
    }

    public final void zzc(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zza(j);
        if (zzs().zzh().booleanValue()) {
            this.zzb.zzb(j);
        }
        zzkf zzkfVar = this.zza;
        if (zzkfVar.zza.zzs().zza(zzas.zzbu)) {
            return;
        }
        zzkfVar.zza.zzr().zzr.zza(true);
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    public final long zza(long j) {
        return this.zzb.zzc(j);
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public static /* synthetic */ void zza(zzjx zzjxVar, long j) {
        zzjxVar.zzb(j);
    }
}
