package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zaar implements zaba {
    private final zabd zaa;
    private final Lock zab;
    private final Context zac;
    private final GoogleApiAvailabilityLight zad;
    private ConnectionResult zae;
    private int zaf;
    private int zah;
    private com.google.android.gms.signin.zae zak;
    private boolean zal;
    private boolean zam;
    private boolean zan;
    private IAccountAccessor zao;
    private boolean zap;
    private boolean zaq;
    private final ClientSettings zar;
    private final Map<Api<?>, Boolean> zas;
    private final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zat;
    private int zag = 0;
    private final Bundle zai = new Bundle();
    private final Set<Api.AnyClientKey> zaj = new HashSet();
    private final ArrayList<Future<?>> zau = new ArrayList<>();

    public zaar(zabd zabdVar, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zaa = zabdVar;
        this.zar = clientSettings;
        this.zas = map;
        this.zad = googleApiAvailabilityLight;
        this.zat = abstractClientBuilder;
        this.zab = lock;
        this.zac = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaA() {
        if (this.zah != 0) {
            return;
        }
        if (!this.zam || this.zan) {
            ArrayList arrayList = new ArrayList();
            this.zag = 1;
            this.zah = this.zaa.zaa.size();
            for (Api.AnyClientKey<?> anyClientKey : this.zaa.zaa.keySet()) {
                if (this.zaa.zab.containsKey(anyClientKey)) {
                    if (zaz()) {
                        zaB();
                    }
                } else {
                    arrayList.add(this.zaa.zaa.get(anyClientKey));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.zau.add(zabe.zaa().submit(new zaam(this, arrayList)));
        }
    }

    private final void zaB() {
        this.zaa.zap();
        zabe.zaa().execute(new zaah(this));
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (this.zap) {
                zaeVar.zab((IAccountAccessor) Preconditions.checkNotNull(this.zao), this.zaq);
            }
            zaG(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zaa.zab.keySet()) {
            ((Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(anyClientKey))).disconnect();
        }
        this.zaa.zah.zaa(this.zai.isEmpty() ? null : this.zai);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaC(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int priority = api.zaa().getPriority();
        if ((!z || connectionResult.hasResolution() || this.zad.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) && (this.zae == null || priority < this.zaf)) {
            this.zae = connectionResult;
            this.zaf = priority;
        }
        this.zaa.zab.put(api.zac(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaD() {
        this.zam = false;
        this.zaa.zag.zad = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.zaj) {
            if (!this.zaa.zab.containsKey(anyClientKey)) {
                this.zaa.zab.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zaE(ConnectionResult connectionResult) {
        return this.zal && !connectionResult.hasResolution();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaF(ConnectionResult connectionResult) {
        zaH();
        zaG(!connectionResult.hasResolution());
        this.zaa.zaq(connectionResult);
        this.zaa.zah.zab(connectionResult);
    }

    private final void zaG(boolean z) {
        com.google.android.gms.signin.zae zaeVar = this.zak;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z) {
                zaeVar.zac();
            }
            zaeVar.disconnect();
            ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.zar);
            this.zao = null;
        }
    }

    private final void zaH() {
        ArrayList<Future<?>> arrayList = this.zau;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).cancel(true);
        }
        this.zau.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zaI(int i) {
        if (this.zag != i) {
            Log.w("GACConnecting", this.zaa.zag.zae());
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Unexpected callback in ");
            sb.append(valueOf);
            Log.w("GACConnecting", sb.toString());
            int i2 = this.zah;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("mRemainingConnections=");
            sb2.append(i2);
            Log.w("GACConnecting", sb2.toString());
            String zaJ = zaJ(this.zag);
            String zaJ2 = zaJ(i);
            StringBuilder sb3 = new StringBuilder(zaJ.length() + 70 + zaJ2.length());
            sb3.append("GoogleApiClient connecting is in step ");
            sb3.append(zaJ);
            sb3.append(" but received callback for step ");
            sb3.append(zaJ2);
            Log.e("GACConnecting", sb3.toString(), new Exception());
            zaF(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    private static final String zaJ(int i) {
        return i != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set zap(zaar zaarVar) {
        ClientSettings clientSettings = zaarVar.zar;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.getRequiredScopes());
        Map<Api<?>, com.google.android.gms.common.internal.zab> zaa = zaarVar.zar.zaa();
        for (Api<?> api : zaa.keySet()) {
            if (!zaarVar.zaa.zab.containsKey(api.zac())) {
                hashSet.addAll(zaa.get(api).zaa);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zay(zaar zaarVar, com.google.android.gms.signin.internal.zak zakVar) {
        if (zaarVar.zaI(0)) {
            ConnectionResult zaa = zakVar.zaa();
            if (!zaa.isSuccess()) {
                if (!zaarVar.zaE(zaa)) {
                    zaarVar.zaF(zaa);
                    return;
                }
                zaarVar.zaD();
                zaarVar.zaA();
                return;
            }
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.checkNotNull(zakVar.zab());
            ConnectionResult zab = zavVar.zab();
            if (zab.isSuccess()) {
                zaarVar.zan = true;
                zaarVar.zao = (IAccountAccessor) Preconditions.checkNotNull(zavVar.zaa());
                zaarVar.zap = zavVar.zac();
                zaarVar.zaq = zavVar.zad();
                zaarVar.zaA();
                return;
            }
            String valueOf = String.valueOf(zab);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("GACConnecting", sb.toString(), new Exception());
            zaarVar.zaF(zab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zaz() {
        int i = this.zah - 1;
        this.zah = i;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GACConnecting", this.zaa.zag.zae());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zaF(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.zae;
        if (connectionResult != null) {
            this.zaa.zaf = this.zaf;
            zaF(connectionResult);
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
        this.zaa.zab.clear();
        this.zam = false;
        this.zae = null;
        this.zag = 0;
        this.zal = true;
        this.zan = false;
        this.zap = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.zas.keySet()) {
            Api.Client client = (Api.Client) Preconditions.checkNotNull(this.zaa.zaa.get(api.zac()));
            z |= api.zaa().getPriority() == 1;
            boolean booleanValue = this.zas.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.zam = true;
                if (booleanValue) {
                    this.zaj.add(api.zac());
                } else {
                    this.zal = false;
                }
            }
            hashMap.put(client, new zaai(this, api, booleanValue));
        }
        if (z) {
            this.zam = false;
        }
        if (this.zam) {
            Preconditions.checkNotNull(this.zar);
            Preconditions.checkNotNull(this.zat);
            this.zar.zae(Integer.valueOf(System.identityHashCode(this.zaa.zag)));
            zaap zaapVar = new zaap(this, null);
            Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder = this.zat;
            Context context = this.zac;
            Looper looper = this.zaa.zag.getLooper();
            ClientSettings clientSettings = this.zar;
            this.zak = abstractClientBuilder.buildClient(context, looper, clientSettings, (ClientSettings) clientSettings.zac(), (GoogleApiClient.ConnectionCallbacks) zaapVar, (GoogleApiClient.OnConnectionFailedListener) zaapVar);
        }
        this.zah = this.zaa.zaa.size();
        this.zau.add(zabe.zaa().submit(new zaal(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        this.zaa.zag.zaa.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final boolean zad() {
        zaH();
        zaG(true);
        this.zaa.zaq(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zae() {
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaf(Bundle bundle) {
        if (zaI(1)) {
            if (bundle != null) {
                this.zai.putAll(bundle);
            }
            if (zaz()) {
                zaB();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zag(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zaI(1)) {
            zaC(connectionResult, api, z);
            if (zaz()) {
                zaB();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zah(int i) {
        zaF(new ConnectionResult(8, null));
    }
}
