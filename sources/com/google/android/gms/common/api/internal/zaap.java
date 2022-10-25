package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zaap implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ zaar zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zaap(zaar zaarVar, zaah zaahVar) {
        this.zaa = zaarVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings;
        com.google.android.gms.signin.zae zaeVar;
        clientSettings = this.zaa.zar;
        ClientSettings clientSettings2 = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        zaeVar = this.zaa.zak;
        ((com.google.android.gms.signin.zae) Preconditions.checkNotNull(zaeVar)).zaa(new zaao(this.zaa));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean zaE;
        lock = this.zaa.zab;
        lock.lock();
        try {
            zaE = this.zaa.zaE(connectionResult);
            if (zaE) {
                this.zaa.zaD();
                this.zaa.zaA();
            } else {
                this.zaa.zaF(connectionResult);
            }
        } finally {
            lock2 = this.zaa.zab;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
