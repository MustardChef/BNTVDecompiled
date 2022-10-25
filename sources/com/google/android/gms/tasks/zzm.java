package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzn zznVar, Task task) {
        this.zzb = zznVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            onSuccessListener = this.zzb.zzc;
            if (onSuccessListener != null) {
                onSuccessListener2 = this.zzb.zzc;
                onSuccessListener2.onSuccess(this.zza.getResult());
            }
        }
    }
}
