package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzje implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzaq zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzir zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzir zzirVar, boolean z, boolean z2, zzaq zzaqVar, zzn zznVar, String str) {
        this.zzf = zzirVar;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzaqVar;
        this.zzd = zznVar;
        this.zze = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        zzeiVar = this.zzf.zzb;
        if (zzeiVar == null) {
            this.zzf.zzq().zze().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzeiVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzeiVar.zza(this.zzc, this.zzd);
                } else {
                    zzeiVar.zza(this.zzc, this.zze, this.zzf.zzq().zzx());
                }
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
