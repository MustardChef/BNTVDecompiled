package com.google.android.gms.internal.p038firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj */
/* loaded from: classes3.dex */
public final class zzuj implements Runnable {
    final /* synthetic */ zzul zza;
    final /* synthetic */ zzuk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzuj(zzuk zzukVar, zzul zzulVar) {
        this.zzb = zzukVar;
        this.zza = zzulVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            if (!this.zzb.zza.zzh.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzh.get(0), new Object[0]);
            }
        }
    }
}
