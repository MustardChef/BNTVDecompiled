package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzbr extends zzbw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzby zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbr(zzby zzbyVar, GoogleApiClient googleApiClient, String str) {
        super(zzbyVar, googleApiClient);
        this.zzb = zzbyVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.cast.zzbw, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(zzcb zzcbVar) throws RemoteException {
        doExecute(zzcbVar);
    }

    @Override // com.google.android.gms.internal.cast.zzbw
    public final void zza(zzcb zzcbVar) throws RemoteException {
        zzcg zzcgVar;
        zzbu zzbuVar = new zzbu(this, zzcbVar);
        zzcgVar = this.zzb.zzd;
        zzcbVar.zzp(zzbuVar, zzcgVar, this.zza);
    }
}
