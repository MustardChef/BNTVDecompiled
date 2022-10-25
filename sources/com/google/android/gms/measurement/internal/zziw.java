package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzml;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zziw implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzw zzb;
    private final /* synthetic */ zzir zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziw(zzir zzirVar, zzn zznVar, com.google.android.gms.internal.measurement.zzw zzwVar) {
        this.zzc = zzirVar;
        this.zza = zznVar;
        this.zzb = zzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        try {
            if (zzml.zzb() && this.zzc.zzs().zza(zzas.zzcg) && !this.zzc.zzr().zzx().zze()) {
                this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zze().zza((String) null);
                this.zzc.zzr().zzj.zza(null);
                return;
            }
            zzeiVar = this.zzc.zzb;
            if (zzeiVar == null) {
                this.zzc.zzq().zze().zza("Failed to get app instance id");
                return;
            }
            String zzc = zzeiVar.zzc(this.zza);
            if (zzc != null) {
                this.zzc.zze().zza(zzc);
                this.zzc.zzr().zzj.zza(zzc);
            }
            this.zzc.zzaj();
            this.zzc.zzo().zza(this.zzb, zzc);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzo().zza(this.zzb, (String) null);
        }
    }
}
