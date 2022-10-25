package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzg extends zzo {
    final /* synthetic */ String zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(zzm zzmVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zza = str;
    }

    @Override // com.google.android.gms.cast.zzo, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        doExecute(zzwVar);
    }

    @Override // com.google.android.gms.cast.zzo
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) throws RemoteException {
        try {
            String str = this.zza;
            LaunchOptions launchOptions = new LaunchOptions();
            launchOptions.setRelaunchIfRunning(false);
            zzwVar.zzq(str, launchOptions, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
