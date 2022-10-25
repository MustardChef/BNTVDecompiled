package com.google.android.gms.cast.framework.media;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbk implements com.google.android.gms.cast.internal.zzap {
    final /* synthetic */ zzbm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(zzbm zzbmVar) {
        this.zza = zzbmVar;
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zza(long j) {
        try {
            zzbm zzbmVar = this.zza;
            zzbmVar.setResult(new zzbl(zzbmVar, new Status(2103)));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestReplaced", e);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzap
    public final void zzb(long j, int i, Object obj) {
        if (true != (obj instanceof com.google.android.gms.cast.internal.zzam)) {
            obj = null;
        }
        try {
            this.zza.setResult(new zzbn(new Status(i), obj != null ? ((com.google.android.gms.cast.internal.zzam) obj).zza : null, obj != null ? ((com.google.android.gms.cast.internal.zzam) obj).zzb : null));
        } catch (IllegalStateException e) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestCompleted", e);
        }
    }
}
