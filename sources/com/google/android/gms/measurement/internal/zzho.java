package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzho implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzhb zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzho(zzhb zzhbVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zzhbVar;
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzy.zzv().zza(this.zza, (String) null, this.zzc, this.zzd);
    }
}
