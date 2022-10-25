package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.internal.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbq extends zzcf {
    final /* synthetic */ zzby zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbq(zzby zzbyVar) {
        this.zza = zzbyVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcg
    public final void zzb(int i) {
        Logger logger;
        logger = zzby.zza;
        logger.m369d("onRemoteDisplayEnded", new Object[0]);
        zzby.zzb(this.zza);
    }
}
