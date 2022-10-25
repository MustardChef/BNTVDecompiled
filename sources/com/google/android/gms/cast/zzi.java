package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzi extends zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(zzm zzmVar, GoogleApiClient googleApiClient, String str, String str2, zzbl zzblVar) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.cast.zzo, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        doExecute(zzwVar);
    }

    @Override // com.google.android.gms.cast.zzo
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        try {
            zzwVar.zzr(this.zza, this.zzb, null, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
