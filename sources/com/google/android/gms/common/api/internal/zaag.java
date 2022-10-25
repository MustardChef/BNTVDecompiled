package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zaag implements zaba {
    private final zabd zaa;
    private boolean zab = false;

    public zaag(zabd zabdVar) {
        this.zaa = zabdVar;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        zac(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        try {
            this.zaa.zag.zai.zaa(t);
            zaaz zaazVar = this.zaa.zag;
            Api.Client client = zaazVar.zac.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.zaa.zab.containsKey(t.getClientKey())) {
                t.setFailedResult(new Status(17));
            } else {
                t.run(client);
            }
        } catch (DeadObjectException unused) {
            this.zaa.zar(new zaae(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final boolean zad() {
        if (this.zab) {
            return false;
        }
        Set<zacv> set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zaq(null);
            return true;
        }
        this.zab = true;
        for (zacv zacvVar : set) {
            zacvVar.zab();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zar(new zaaf(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaf(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zag(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zah(int i) {
        this.zaa.zaq(null);
        this.zaa.zah.zac(i, this.zab);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zai() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zad();
        }
    }
}
