package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzml;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzix implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzir zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzix(zzir zzirVar, AtomicReference atomicReference, zzn zznVar) {
        this.zzc = zzirVar;
        this.zza = atomicReference;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        synchronized (this.zza) {
            try {
            } catch (RemoteException e) {
                this.zzc.zzq().zze().zza("Failed to get app instance id", e);
                this.zza.notify();
            }
            if (zzml.zzb() && this.zzc.zzs().zza(zzas.zzcg) && !this.zzc.zzr().zzx().zze()) {
                this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zze().zza((String) null);
                this.zzc.zzr().zzj.zza(null);
                this.zza.set(null);
                this.zza.notify();
                return;
            }
            zzeiVar = this.zzc.zzb;
            if (zzeiVar == null) {
                this.zzc.zzq().zze().zza("Failed to get app instance id");
                this.zza.notify();
                return;
            }
            this.zza.set(zzeiVar.zzc(this.zzb));
            String str = (String) this.zza.get();
            if (str != null) {
                this.zzc.zze().zza(str);
                this.zzc.zzr().zzj.zza(str);
            }
            this.zzc.zzaj();
            this.zza.notify();
        }
    }
}
