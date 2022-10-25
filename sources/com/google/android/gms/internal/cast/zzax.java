package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
final class zzax extends Cast.Listener {
    final /* synthetic */ zzay zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzay zzayVar) {
        this.zza = zzayVar;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onVolumeChanged() {
        this.zza.zza();
    }
}
