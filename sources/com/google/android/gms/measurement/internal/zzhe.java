package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzhe implements Runnable {
    private final /* synthetic */ zzhb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(zzhb zzhbVar) {
        this.zza = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zza();
    }
}
