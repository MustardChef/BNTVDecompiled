package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzbs extends zzbw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbs(zzby zzbyVar, GoogleApiClient googleApiClient) {
        super(zzbyVar, googleApiClient);
    }

    @Override // com.google.android.gms.internal.cast.zzbw, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(zzcb zzcbVar) throws RemoteException {
        doExecute(zzcbVar);
    }

    @Override // com.google.android.gms.internal.cast.zzbw
    public final void zza(zzcb zzcbVar) throws RemoteException {
        zzcbVar.zzq(new zzbv(this));
    }
}
