package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzcr extends zzcs {
    private final Choreographer zza = Choreographer.getInstance();

    @Override // com.google.android.gms.internal.cast.zzcs
    public final void zza(zzcp zzcpVar) {
        this.zza.postFrameCallback(zzcpVar.zzb());
    }
}
