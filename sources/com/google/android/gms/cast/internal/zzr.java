package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzr implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzv zzvVar, zzw zzwVar, int i) {
        this.zza = zzwVar;
        this.zzb = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cast.Listener listener;
        listener = this.zza.zzh;
        listener.onApplicationDisconnected(this.zzb);
    }
}
