package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zabd implements zabu, zat {
    final Map<Api.AnyClientKey<?>, Api.Client> zaa;
    final ClientSettings zac;
    final Map<Api<?>, Boolean> zad;
    final Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> zae;
    int zaf;
    final zaaz zag;
    final zabt zah;
    private final Lock zai;
    private final Condition zaj;
    private final Context zak;
    private final GoogleApiAvailabilityLight zal;
    private final zabc zam;
    @NotOnlyInitialized
    private volatile zaba zan;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zab = new HashMap();
    private ConnectionResult zao = null;

    public zabd(Context context, zaaz zaazVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends com.google.android.gms.signin.zae, SignInOptions> abstractClientBuilder, ArrayList<zas> arrayList, zabt zabtVar) {
        this.zak = context;
        this.zai = lock;
        this.zal = googleApiAvailabilityLight;
        this.zaa = map;
        this.zac = clientSettings;
        this.zad = map2;
        this.zae = abstractClientBuilder;
        this.zag = zaazVar;
        this.zah = zabtVar;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).zaa(this);
        }
        this.zam = new zabc(this, looper);
        this.zaj = lock.newCondition();
        this.zan = new zaas(this);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zai.lock();
        try {
            this.zan.zaf(bundle);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.zai.lock();
        try {
            this.zan.zah(i);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zat
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.zai.lock();
        try {
            this.zan.zag(connectionResult, api, z);
        } finally {
            this.zai.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zab(T t) {
        t.zak();
        this.zan.zab(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zac(T t) {
        t.zak();
        return (T) this.zan.zac(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final ConnectionResult zad(Api<?> api) {
        Api.AnyClientKey<?> zac = api.zac();
        if (this.zaa.containsKey(zac)) {
            if (this.zaa.get(zac).isConnected()) {
                return ConnectionResult.RESULT_SUCCESS;
            }
            if (this.zab.containsKey(zac)) {
                return this.zab.get(zac);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zae() {
        this.zan.zae();
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final ConnectionResult zaf() {
        zae();
        while (this.zan instanceof zaar) {
            try {
                this.zaj.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.zan instanceof zaag) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final ConnectionResult zag(long j, TimeUnit timeUnit) {
        zae();
        long nanos = timeUnit.toNanos(j);
        while (this.zan instanceof zaar) {
            if (nanos > 0) {
                try {
                    nanos = this.zaj.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            } else {
                zah();
                return new ConnectionResult(14, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (this.zan instanceof zaag) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        ConnectionResult connectionResult = this.zao;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zah() {
        if (this.zan.zad()) {
            this.zab.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final boolean zai() {
        return this.zan instanceof zaag;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final boolean zaj() {
        return this.zan instanceof zaar;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final boolean zak(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zal() {
        if (this.zan instanceof zaag) {
            ((zaag) this.zan).zai();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zam() {
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zan(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.zan);
        for (Api<?> api : this.zad.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.zad()).println(":");
            ((Api.Client) Preconditions.checkNotNull(this.zaa.get(api.zac()))).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zao() {
        this.zai.lock();
        try {
            this.zan = new zaar(this, this.zac, this.zad, this.zal, this.zae, this.zai, this.zak);
            this.zan.zaa();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zap() {
        this.zai.lock();
        try {
            this.zag.zad();
            this.zan = new zaag(this);
            this.zan.zaa();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaq(ConnectionResult connectionResult) {
        this.zai.lock();
        try {
            this.zao = connectionResult;
            this.zan = new zaas(this);
            this.zan.zaa();
            this.zaj.signalAll();
        } finally {
            this.zai.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zar(zabb zabbVar) {
        this.zam.sendMessage(this.zam.obtainMessage(1, zabbVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zas(RuntimeException runtimeException) {
        this.zam.sendMessage(this.zam.obtainMessage(2, runtimeException));
    }
}
