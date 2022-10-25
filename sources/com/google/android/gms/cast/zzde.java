package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzde implements com.google.android.gms.cast.internal.zzap {
    final /* synthetic */ zzdg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzde(zzdg zzdgVar) {
        this.zza = zzdgVar;
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zza(long j) {
        try {
            zzdg zzdgVar = this.zza;
            zzdgVar.setResult((zzdg) new zzdf(zzdgVar, new Status(2103)));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", e);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zzb(long j, int i, Object obj) {
        if (true != (obj instanceof com.google.android.gms.cast.internal.zzam)) {
            obj = null;
        }
        try {
            this.zza.setResult((zzdg) new zzdh(new Status(i), obj != null ? ((com.google.android.gms.cast.internal.zzam) obj).zza : null));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", e);
        }
    }
}
