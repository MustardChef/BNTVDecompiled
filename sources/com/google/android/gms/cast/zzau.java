package com.google.android.gms.cast;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzau implements RemoteCall {
    static final RemoteCall zza = new zzau();

    private zzau() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        int i = zzbk.zzf;
        ((com.google.android.gms.cast.internal.zzae) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzr();
        ((TaskCompletionSource) obj2).setResult(true);
    }
}
