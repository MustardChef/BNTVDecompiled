package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zabn implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabo zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabn(zabo zaboVar, ConnectionResult connectionResult) {
        this.zab = zaboVar;
        this.zaa = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        ApiKey apiKey;
        Api.Client client;
        Api.Client client2;
        Api.Client client3;
        Api.Client client4;
        map = this.zab.zaa.zap;
        apiKey = this.zab.zac;
        zabl zablVar = (zabl) map.get(apiKey);
        if (zablVar == null) {
            return;
        }
        if (this.zaa.isSuccess()) {
            this.zab.zaf = true;
            client = this.zab.zab;
            if (client.requiresSignIn()) {
                this.zab.zag();
                return;
            }
            try {
                client3 = this.zab.zab;
                client4 = this.zab.zab;
                client3.getRemoteService(null, client4.getScopesForConnectionlessNonSignIn());
                return;
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                client2 = this.zab.zab;
                client2.disconnect("Failed to get service from broker.");
                zablVar.zac(new ConnectionResult(10), null);
                return;
            }
        }
        zablVar.zac(this.zaa, null);
    }
}
