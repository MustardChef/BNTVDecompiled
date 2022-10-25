package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzcq extends zzcs {
    private final Handler zza;

    public zzcq(Looper looper) {
        this.zza = new Handler(looper);
    }

    @Override // com.google.android.gms.internal.cast.zzcs
    public final void zza(zzcp zzcpVar) {
        this.zza.postDelayed(zzcpVar.zzc(), 0L);
    }
}
