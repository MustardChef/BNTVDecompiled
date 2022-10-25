package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zziv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzir zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(zzir zzirVar, AtomicReference atomicReference, zzn zznVar, boolean z) {
        this.zzd = zzirVar;
        this.zza = atomicReference;
        this.zzb = zznVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        synchronized (this.zza) {
            try {
                zzeiVar = this.zzd.zzb;
            } catch (RemoteException e) {
                this.zzd.zzq().zze().zza("Failed to get all user properties; remote exception", e);
                this.zza.notify();
            }
            if (zzeiVar == null) {
                this.zzd.zzq().zze().zza("Failed to get all user properties; not connected to service");
                this.zza.notify();
                return;
            }
            this.zza.set(zzeiVar.zza(this.zzb, this.zzc));
            this.zzd.zzaj();
            this.zza.notify();
        }
    }
}
