package com.google.android.gms.cast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzdc implements ResultCallback<Status> {
    final /* synthetic */ zzdd zza;
    private final long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdc(zzdd zzddVar, long j) {
        this.zza = zzddVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Status status) {
        com.google.android.gms.cast.internal.zzan zzanVar;
        Status status2 = status;
        if (status2.isSuccess()) {
            return;
        }
        zzanVar = this.zza.zza.zzb;
        zzanVar.zzN(this.zzb, status2.getStatusCode());
    }
}
