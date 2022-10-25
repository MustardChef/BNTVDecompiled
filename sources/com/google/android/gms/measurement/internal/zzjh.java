package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjh implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzz zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzz zze;
    private final /* synthetic */ zzir zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjh(zzir zzirVar, boolean z, boolean z2, zzz zzzVar, zzn zznVar, zzz zzzVar2) {
        this.zzf = zzirVar;
        this.zzb = z2;
        this.zzc = zzzVar;
        this.zzd = zznVar;
        this.zze = zzzVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        zzeiVar = this.zzf.zzb;
        if (zzeiVar == null) {
            this.zzf.zzq().zze().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzeiVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzeiVar.zza(this.zzc, this.zzd);
                } else {
                    zzeiVar.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
