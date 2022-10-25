package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;

/* loaded from: classes3.dex */
final class zzq extends zzk.zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzk zzkVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzx zzxVar) throws RemoteException {
        ((zzi) zzxVar.getService()).zzd(this.zzaf);
    }
}
