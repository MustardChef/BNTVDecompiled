package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* loaded from: classes3.dex */
final class zzk implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzl zzlVar, Task task) {
        this.zzb = zzlVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            onFailureListener = this.zzb.zzc;
            if (onFailureListener != null) {
                onFailureListener2 = this.zzb.zzc;
                onFailureListener2.onFailure((Exception) Preconditions.checkNotNull(this.zza.getException()));
            }
        }
    }
}
