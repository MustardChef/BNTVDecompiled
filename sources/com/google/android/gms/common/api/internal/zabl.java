package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zabl<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zat {
    final /* synthetic */ GoogleApiManager zaa;
    @NotOnlyInitialized
    private final Api.Client zac;
    private final ApiKey<O> zad;
    private final zaaa zae;
    private final int zah;
    private final zaco zai;
    private boolean zaj;
    private final Queue<zai> zab = new LinkedList();
    private final Set<zal> zaf = new HashSet();
    private final Map<ListenerHolder.ListenerKey<?>, zacc> zag = new HashMap();
    private final List<zabm> zak = new ArrayList();
    private ConnectionResult zal = null;
    private int zam = 0;

    public zabl(GoogleApiManager googleApiManager, GoogleApi<O> googleApi) {
        Handler handler;
        Context context;
        Handler handler2;
        this.zaa = googleApiManager;
        handler = googleApiManager.zat;
        Api.Client zaa = googleApi.zaa(handler.getLooper(), this);
        this.zac = zaa;
        this.zad = googleApi.getApiKey();
        this.zae = new zaaa();
        this.zah = googleApi.zab();
        if (!zaa.requiresSignIn()) {
            this.zai = null;
            return;
        }
        context = googleApiManager.zak;
        handler2 = googleApiManager.zat;
        this.zai = googleApi.zac(context, handler2);
    }

    public final void zaB() {
        zah();
        zaM(ConnectionResult.RESULT_SUCCESS);
        zaJ();
        Iterator<zacc> it = this.zag.values().iterator();
        while (it.hasNext()) {
            zacc next = it.next();
            if (zaN(next.zaa.getRequiredFeatures()) != null) {
                it.remove();
            } else {
                try {
                    next.zaa.registerListener(this.zac, new TaskCompletionSource<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        zaE();
        zaK();
    }

    public final void zaC(int i) {
        Handler handler;
        Handler handler2;
        long j;
        Handler handler3;
        Handler handler4;
        long j2;
        com.google.android.gms.common.internal.zal zalVar;
        zah();
        this.zaj = true;
        this.zae.zae(i, this.zac.getLastDisconnectMessage());
        handler = this.zaa.zat;
        handler2 = this.zaa.zat;
        Message obtain = Message.obtain(handler2, 9, this.zad);
        j = this.zaa.zac;
        handler.sendMessageDelayed(obtain, j);
        handler3 = this.zaa.zat;
        handler4 = this.zaa.zat;
        Message obtain2 = Message.obtain(handler4, 11, this.zad);
        j2 = this.zaa.zad;
        handler3.sendMessageDelayed(obtain2, j2);
        zalVar = this.zaa.zam;
        zalVar.zac();
        for (zacc zaccVar : this.zag.values()) {
            zaccVar.zac.run();
        }
    }

    private final boolean zaD(ConnectionResult connectionResult) {
        Object obj;
        zaab zaabVar;
        Set set;
        zaab zaabVar2;
        obj = GoogleApiManager.zag;
        synchronized (obj) {
            zaabVar = this.zaa.zaq;
            if (zaabVar != null) {
                set = this.zaa.zar;
                if (set.contains(this.zad)) {
                    zaabVar2 = this.zaa.zaq;
                    zaabVar2.zaf(connectionResult, this.zah);
                    return true;
                }
            }
            return false;
        }
    }

    private final void zaE() {
        ArrayList arrayList = new ArrayList(this.zab);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zai zaiVar = (zai) arrayList.get(i);
            if (!this.zac.isConnected()) {
                return;
            }
            if (zaF(zaiVar)) {
                this.zab.remove(zaiVar);
            }
        }
    }

    private final boolean zaF(zai zaiVar) {
        boolean z;
        Handler handler;
        Handler handler2;
        long j;
        Handler handler3;
        Handler handler4;
        long j2;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        long j3;
        if (!(zaiVar instanceof zac)) {
            zaG(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature zaN = zaN(zacVar.zaa(this));
        if (zaN == null) {
            zaG(zaiVar);
            return true;
        }
        String name = this.zac.getClass().getName();
        String name2 = zaN.getName();
        long version = zaN.getVersion();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(name2).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(name2);
        sb.append(", ");
        sb.append(version);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        z = this.zaa.zau;
        if (!z || !zacVar.zab(this)) {
            zacVar.zad(new UnsupportedApiCallException(zaN));
            return true;
        }
        zabm zabmVar = new zabm(this.zad, zaN, null);
        int indexOf = this.zak.indexOf(zabmVar);
        if (indexOf >= 0) {
            zabm zabmVar2 = this.zak.get(indexOf);
            handler5 = this.zaa.zat;
            handler5.removeMessages(15, zabmVar2);
            handler6 = this.zaa.zat;
            handler7 = this.zaa.zat;
            Message obtain = Message.obtain(handler7, 15, zabmVar2);
            j3 = this.zaa.zac;
            handler6.sendMessageDelayed(obtain, j3);
            return false;
        }
        this.zak.add(zabmVar);
        handler = this.zaa.zat;
        handler2 = this.zaa.zat;
        Message obtain2 = Message.obtain(handler2, 15, zabmVar);
        j = this.zaa.zac;
        handler.sendMessageDelayed(obtain2, j);
        handler3 = this.zaa.zat;
        handler4 = this.zaa.zat;
        Message obtain3 = Message.obtain(handler4, 16, zabmVar);
        j2 = this.zaa.zad;
        handler3.sendMessageDelayed(obtain3, j2);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (zaD(connectionResult)) {
            return false;
        }
        this.zaa.zap(connectionResult, this.zah);
        return false;
    }

    private final void zaG(zai zaiVar) {
        zaiVar.zae(this.zae, zap());
        try {
            zaiVar.zaf(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        } catch (Throwable th) {
            throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.zac.getClass().getName()), th);
        }
    }

    private final void zaH(Status status, Exception exc, boolean z) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator<zai> it = this.zab.iterator();
        while (it.hasNext()) {
            zai next = it.next();
            if (!z || next.zac == 2) {
                if (status != null) {
                    next.zac(status);
                } else {
                    next.zad(exc);
                }
                it.remove();
            }
        }
    }

    public final void zaI(Status status) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        zaH(status, null, false);
    }

    private final void zaJ() {
        Handler handler;
        Handler handler2;
        if (this.zaj) {
            handler = this.zaa.zat;
            handler.removeMessages(11, this.zad);
            handler2 = this.zaa.zat;
            handler2.removeMessages(9, this.zad);
            this.zaj = false;
        }
    }

    private final void zaK() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        long j;
        handler = this.zaa.zat;
        handler.removeMessages(12, this.zad);
        handler2 = this.zaa.zat;
        handler3 = this.zaa.zat;
        Message obtainMessage = handler3.obtainMessage(12, this.zad);
        j = this.zaa.zae;
        handler2.sendMessageDelayed(obtainMessage, j);
    }

    public final boolean zaL(boolean z) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if (this.zac.isConnected() && this.zag.size() == 0) {
            if (!this.zae.zac()) {
                this.zac.disconnect("Timing out service connection.");
                return true;
            }
            if (z) {
                zaK();
            }
            return false;
        }
        return false;
    }

    private final void zaM(ConnectionResult connectionResult) {
        for (zal zalVar : this.zaf) {
            zalVar.zac(this.zad, connectionResult, Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.zac.getEndpointPackageName() : null);
        }
        this.zaf.clear();
    }

    private final Feature zaN(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.zac.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) arrayMap.get(feature2.getName());
                if (l == null || l.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ boolean zat(zabl zablVar, boolean z) {
        return zablVar.zaL(false);
    }

    public static /* synthetic */ void zau(zabl zablVar, zabm zabmVar) {
        if (zablVar.zak.contains(zabmVar) && !zablVar.zaj) {
            if (zablVar.zac.isConnected()) {
                zablVar.zaE();
            } else {
                zablVar.zam();
            }
        }
    }

    public static /* synthetic */ void zav(zabl zablVar, zabm zabmVar) {
        Handler handler;
        Handler handler2;
        Feature feature;
        Feature[] zaa;
        if (zablVar.zak.remove(zabmVar)) {
            handler = zablVar.zaa.zat;
            handler.removeMessages(15, zabmVar);
            handler2 = zablVar.zaa.zat;
            handler2.removeMessages(16, zabmVar);
            feature = zabmVar.zab;
            ArrayList arrayList = new ArrayList(zablVar.zab.size());
            for (zai zaiVar : zablVar.zab) {
                if ((zaiVar instanceof zac) && (zaa = ((zac) zaiVar).zaa(zablVar)) != null && ArrayUtils.contains(zaa, feature)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zai zaiVar2 = (zai) arrayList.get(i);
                zablVar.zab.remove(zaiVar2);
                zaiVar2.zad(new UnsupportedApiCallException(feature));
            }
        }
    }

    public static /* synthetic */ void zaw(zabl zablVar, Status status) {
        zablVar.zaI(status);
    }

    public static /* synthetic */ ApiKey zax(zabl zablVar) {
        return zablVar.zad;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.zaa.zat;
        if (myLooper == handler.getLooper()) {
            zaB();
            return;
        }
        handler2 = this.zaa.zat;
        handler2.post(new zabh(this));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zac(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Handler handler;
        Handler handler2;
        Looper myLooper = Looper.myLooper();
        handler = this.zaa.zat;
        if (myLooper == handler.getLooper()) {
            zaC(i);
            return;
        }
        handler2 = this.zaa.zat;
        handler2.post(new zabi(this, i));
    }

    @Override // com.google.android.gms.common.api.internal.zat
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        throw null;
    }

    public final void zab(ConnectionResult connectionResult) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        Api.Client client = this.zac;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(valueOf).length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        client.disconnect(sb.toString());
        zac(connectionResult, null);
    }

    public final void zac(ConnectionResult connectionResult, Exception exc) {
        Handler handler;
        com.google.android.gms.common.internal.zal zalVar;
        boolean z;
        Status zaJ;
        Status zaJ2;
        Status zaJ3;
        Handler handler2;
        Handler handler3;
        long j;
        Handler handler4;
        Status status;
        Handler handler5;
        Handler handler6;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        zaco zacoVar = this.zai;
        if (zacoVar != null) {
            zacoVar.zad();
        }
        zah();
        zalVar = this.zaa.zam;
        zalVar.zac();
        zaM(connectionResult);
        if ((this.zac instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.getErrorCode() != 24) {
            this.zaa.zaf = true;
            handler5 = this.zaa.zat;
            handler6 = this.zaa.zat;
            handler5.sendMessageDelayed(handler6.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            status = GoogleApiManager.zab;
            zaI(status);
        } else if (this.zab.isEmpty()) {
            this.zal = connectionResult;
        } else if (exc != null) {
            handler4 = this.zaa.zat;
            Preconditions.checkHandlerThread(handler4);
            zaH(null, exc, false);
        } else {
            z = this.zaa.zau;
            if (z) {
                zaJ2 = GoogleApiManager.zaJ(this.zad, connectionResult);
                zaH(zaJ2, null, true);
                if (this.zab.isEmpty() || zaD(connectionResult) || this.zaa.zap(connectionResult, this.zah)) {
                    return;
                }
                if (connectionResult.getErrorCode() == 18) {
                    this.zaj = true;
                }
                if (!this.zaj) {
                    zaJ3 = GoogleApiManager.zaJ(this.zad, connectionResult);
                    zaI(zaJ3);
                    return;
                }
                handler2 = this.zaa.zat;
                handler3 = this.zaa.zat;
                Message obtain = Message.obtain(handler3, 9, this.zad);
                j = this.zaa.zac;
                handler2.sendMessageDelayed(obtain, j);
                return;
            }
            zaJ = GoogleApiManager.zaJ(this.zad, connectionResult);
            zaI(zaJ);
        }
    }

    public final void zad(zai zaiVar) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if (this.zac.isConnected()) {
            if (zaF(zaiVar)) {
                zaK();
                return;
            } else {
                this.zab.add(zaiVar);
                return;
            }
        }
        this.zab.add(zaiVar);
        ConnectionResult connectionResult = this.zal;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            zam();
        } else {
            zac(this.zal, null);
        }
    }

    public final void zae() {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        zaI(GoogleApiManager.zaa);
        this.zae.zad();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            zad(new zah(listenerKey, new TaskCompletionSource()));
        }
        zaM(new ConnectionResult(4));
        if (this.zac.isConnected()) {
            this.zac.onUserSignOut(new zabk(this));
        }
    }

    public final Api.Client zaf() {
        return this.zac;
    }

    public final Map<ListenerHolder.ListenerKey<?>, zacc> zag() {
        return this.zag;
    }

    public final void zah() {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        this.zal = null;
    }

    public final ConnectionResult zai() {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        return this.zal;
    }

    public final void zaj() {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if (this.zaj) {
            zam();
        }
    }

    public final void zak() {
        Handler handler;
        GoogleApiAvailability googleApiAvailability;
        Context context;
        Status status;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if (this.zaj) {
            zaJ();
            googleApiAvailability = this.zaa.zal;
            context = this.zaa.zak;
            if (googleApiAvailability.isGooglePlayServicesAvailable(context) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            zaI(status);
            this.zac.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean zal() {
        return zaL(true);
    }

    public final void zam() {
        Handler handler;
        com.google.android.gms.common.internal.zal zalVar;
        Context context;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        if (this.zac.isConnected() || this.zac.isConnecting()) {
            return;
        }
        try {
            zalVar = this.zaa.zam;
            context = this.zaa.zak;
            int zaa = zalVar.zaa(context, this.zac);
            if (zaa != 0) {
                ConnectionResult connectionResult = new ConnectionResult(zaa, null);
                String name = this.zac.getClass().getName();
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 35 + String.valueOf(valueOf).length());
                sb.append("The service for ");
                sb.append(name);
                sb.append(" is not available: ");
                sb.append(valueOf);
                Log.w("GoogleApiManager", sb.toString());
                zac(connectionResult, null);
                return;
            }
            zabo zaboVar = new zabo(this.zaa, this.zac, this.zad);
            if (this.zac.requiresSignIn()) {
                ((zaco) Preconditions.checkNotNull(this.zai)).zac(zaboVar);
            }
            try {
                this.zac.connect(zaboVar);
            } catch (SecurityException e) {
                zac(new ConnectionResult(10), e);
            }
        } catch (IllegalStateException e2) {
            zac(new ConnectionResult(10), e2);
        }
    }

    public final void zan(zal zalVar) {
        Handler handler;
        handler = this.zaa.zat;
        Preconditions.checkHandlerThread(handler);
        this.zaf.add(zalVar);
    }

    public final boolean zao() {
        return this.zac.isConnected();
    }

    public final boolean zap() {
        return this.zac.requiresSignIn();
    }

    public final int zaq() {
        return this.zah;
    }

    public final int zar() {
        return this.zam;
    }

    public final void zas() {
        this.zam++;
    }
}
