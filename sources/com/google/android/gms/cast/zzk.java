package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzk extends com.google.android.gms.cast.internal.zzab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzm zzmVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.cast.internal.zzab, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        doExecute(zzwVar);
    }

    @Override // com.google.android.gms.cast.internal.zzab
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        try {
            zzwVar.zzt("", this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
