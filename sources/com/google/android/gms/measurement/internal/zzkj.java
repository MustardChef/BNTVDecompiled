package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public class zzkj extends zzgr implements zzgt {
    protected final zzkl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkj(zzkl zzklVar) {
        super(zzklVar.zzu());
        Preconditions.checkNotNull(zzklVar);
        this.zza = zzklVar;
    }

    public zzfo zzj() {
        return this.zza.zzc();
    }

    public zzaf zzi() {
        return this.zza.zze();
    }

    public zzr zzh() {
        return this.zza.zzf();
    }

    /* renamed from: f_ */
    public zzkr mo331f_() {
        return this.zza.zzh();
    }

    public zzjr zzf() {
        return this.zza.zzi();
    }
}
