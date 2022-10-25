package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjg implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zzir zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjg(zzir zzirVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.zzf = zzirVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzei zzeiVar;
        synchronized (this.zza) {
            try {
                zzeiVar = this.zzf.zzb;
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; remote exception", zzeq.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
                this.zza.notify();
            }
            if (zzeiVar == null) {
                this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; not connected to service", zzeq.zza(this.zzb), this.zzc, this.zzd);
                this.zza.set(Collections.emptyList());
                this.zza.notify();
                return;
            }
            if (TextUtils.isEmpty(this.zzb)) {
                this.zza.set(zzeiVar.zza(this.zzc, this.zzd, this.zze));
            } else {
                this.zza.set(zzeiVar.zza(this.zzb, this.zzc, this.zzd));
            }
            this.zzf.zzaj();
            this.zza.notify();
        }
    }
}
