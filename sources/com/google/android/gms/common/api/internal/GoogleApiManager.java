package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zag = new Object();
    private static GoogleApiManager zaj;
    private TelemetryData zah;
    private TelemetryLoggingClient zai;
    private final Context zak;
    private final GoogleApiAvailability zal;
    private final com.google.android.gms.common.internal.zal zam;
    @NotOnlyInitialized
    private final Handler zat;
    private volatile boolean zau;
    private long zac = 5000;
    private long zad = 120000;
    private long zae = 10000;
    private boolean zaf = false;
    private final AtomicInteger zan = new AtomicInteger(1);
    private final AtomicInteger zao = new AtomicInteger(0);
    private final Map<ApiKey<?>, zabl<?>> zap = new ConcurrentHashMap(5, 0.75f, 1);
    private zaab zaq = null;
    private final Set<ApiKey<?>> zar = new ArraySet();
    private final Set<ApiKey<?>> zas = new ArraySet();

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zau = true;
        this.zak = context;
        com.google.android.gms.internal.base.zap zapVar = new com.google.android.gms.internal.base.zap(looper, this);
        this.zat = zapVar;
        this.zal = googleApiAvailability;
        this.zam = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zau = false;
        }
        zapVar.sendMessage(zapVar.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zag) {
            GoogleApiManager googleApiManager = zaj;
            if (googleApiManager != null) {
                googleApiManager.zao.incrementAndGet();
                Handler handler = googleApiManager.zat;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    private final zabl<?> zaH(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zabl<?> zablVar = this.zap.get(apiKey);
        if (zablVar == null) {
            zablVar = new zabl<>(this, googleApi);
            this.zap.put(apiKey, zablVar);
        }
        if (zablVar.zap()) {
            this.zas.add(apiKey);
        }
        zablVar.zam();
        return zablVar;
    }

    private final <T> void zaI(TaskCompletionSource<T> taskCompletionSource, int i, GoogleApi googleApi) {
        zabx zaa2;
        if (i == 0 || (zaa2 = zabx.zaa(this, i, googleApi.getApiKey())) == null) {
            return;
        }
        Task<T> task = taskCompletionSource.getTask();
        Handler handler = this.zat;
        handler.getClass();
        task.addOnCompleteListener(zabf.zaa(handler), zaa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaJ(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String zab2 = apiKey.zab();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(zab2).length() + 63 + String.valueOf(valueOf).length());
        sb.append("API: ");
        sb.append(zab2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zah;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zam()) {
                zaL().log(telemetryData);
            }
            this.zah = null;
        }
    }

    private final TelemetryLoggingClient zaL() {
        if (this.zai == null) {
            this.zai = TelemetryLogging.getClient(this.zak);
        }
        return this.zai;
    }

    public static GoogleApiManager zaa(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zag) {
            if (zaj == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zaj = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zaj;
        }
        return googleApiManager;
    }

    public static GoogleApiManager zab() {
        GoogleApiManager googleApiManager;
        synchronized (zag) {
            Preconditions.checkNotNull(zaj, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zaj;
        }
        return googleApiManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zabl<?> zablVar;
        switch (message.what) {
            case 1:
                this.zae = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.zat.removeMessages(12);
                for (ApiKey<?> apiKey : this.zap.keySet()) {
                    Handler handler = this.zat;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.zae);
                }
                break;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator<ApiKey<?>> it = zalVar.zaa().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ApiKey<?> next = it.next();
                        zabl<?> zablVar2 = this.zap.get(next);
                        if (zablVar2 != null) {
                            if (zablVar2.zao()) {
                                zalVar.zac(next, ConnectionResult.RESULT_SUCCESS, zablVar2.zaf().getEndpointPackageName());
                            } else {
                                ConnectionResult zai = zablVar2.zai();
                                if (zai != null) {
                                    zalVar.zac(next, zai, null);
                                } else {
                                    zablVar2.zan(zalVar);
                                    zablVar2.zam();
                                }
                            }
                        } else {
                            zalVar.zac(next, new ConnectionResult(13), null);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            case 3:
                for (zabl<?> zablVar3 : this.zap.values()) {
                    zablVar3.zah();
                    zablVar3.zam();
                }
                break;
            case 4:
            case 8:
            case 13:
                zacb zacbVar = (zacb) message.obj;
                zabl<?> zablVar4 = this.zap.get(zacbVar.zac.getApiKey());
                if (zablVar4 == null) {
                    zablVar4 = zaH(zacbVar.zac);
                }
                if (!zablVar4.zap() || this.zao.get() == zacbVar.zab) {
                    zablVar4.zad(zacbVar.zaa);
                    break;
                } else {
                    zacbVar.zaa.zac(zaa);
                    zablVar4.zae();
                    break;
                }
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zabl<?>> it2 = this.zap.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabl<?> next2 = it2.next();
                        zablVar = next2.zaq() == i ? next2 : null;
                    }
                }
                if (zablVar != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        String errorString = this.zal.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(errorString);
                        sb.append(": ");
                        sb.append(errorMessage);
                        zabl.zaw(zablVar, new Status(17, sb.toString()));
                        break;
                    } else {
                        zabl.zaw(zablVar, zaJ(zabl.zax(zablVar), connectionResult));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.zak.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zak.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabg(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zae = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                zaH((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zaj();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> apiKey2 : this.zas) {
                    zabl<?> remove = this.zap.remove(apiKey2);
                    if (remove != null) {
                        remove.zae();
                    }
                }
                this.zas.clear();
                break;
            case 11:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zak();
                    break;
                }
                break;
            case 12:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zal();
                    break;
                }
                break;
            case 14:
                zaac zaacVar = (zaac) message.obj;
                ApiKey<?> zaa2 = zaacVar.zaa();
                if (!this.zap.containsKey(zaa2)) {
                    zaacVar.zab().setResult(false);
                    break;
                } else {
                    zaacVar.zab().setResult(Boolean.valueOf(zabl.zat(this.zap.get(zaa2), false)));
                    break;
                }
            case 15:
                zabm zabmVar = (zabm) message.obj;
                if (this.zap.containsKey(zabm.zaa(zabmVar))) {
                    zabl.zau(this.zap.get(zabm.zaa(zabmVar)), zabmVar);
                    break;
                }
                break;
            case 16:
                zabm zabmVar2 = (zabm) message.obj;
                if (this.zap.containsKey(zabm.zaa(zabmVar2))) {
                    zabl.zav(this.zap.get(zabm.zaa(zabmVar2)), zabmVar2);
                    break;
                }
                break;
            case 17:
                zaK();
                break;
            case 18:
                zaby zabyVar = (zaby) message.obj;
                if (zabyVar.zac == 0) {
                    zaL().log(new TelemetryData(zabyVar.zab, Arrays.asList(zabyVar.zaa)));
                    break;
                } else {
                    TelemetryData telemetryData = this.zah;
                    if (telemetryData != null) {
                        List<MethodInvocation> zab2 = telemetryData.zab();
                        if (this.zah.zaa() == zabyVar.zab && (zab2 == null || zab2.size() < zabyVar.zad)) {
                            this.zah.zac(zabyVar.zaa);
                        } else {
                            this.zat.removeMessages(17);
                            zaK();
                        }
                    }
                    if (this.zah == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zabyVar.zaa);
                        this.zah = new TelemetryData(zabyVar.zab, arrayList);
                        Handler handler2 = this.zat;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zabyVar.zac);
                        break;
                    }
                }
                break;
            case 19:
                this.zaf = false;
                break;
            default:
                int i2 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final int zac() {
        return this.zan.getAndIncrement();
    }

    public final void zad(GoogleApi<?> googleApi) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zae(zaab zaabVar) {
        synchronized (zag) {
            if (this.zaq != zaabVar) {
                this.zaq = zaabVar;
                this.zar.clear();
            }
            this.zar.addAll(zaabVar.zab());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaf(zaab zaabVar) {
        synchronized (zag) {
            if (this.zaq == zaabVar) {
                this.zaq = null;
                this.zar.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zabl zag(ApiKey<?> apiKey) {
        return this.zap.get(apiKey);
    }

    public final Task<Map<ApiKey<?>, String>> zah(Iterable<? extends HasApiKey<?>> iterable) {
        zal zalVar = new zal(iterable);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(2, zalVar));
        return zalVar.zab();
    }

    public final void zai() {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final Task<Boolean> zaj(GoogleApi<?> googleApi) {
        zaac zaacVar = new zaac(googleApi.getApiKey());
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(14, zaacVar));
        return zaacVar.zab().getTask();
    }

    public final <O extends Api.ApiOptions> void zak(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i, apiMethodImpl);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zacb(zaeVar, this.zao.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zal(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaI(taskCompletionSource, taskApiCall.zab(), googleApi);
        zag zagVar = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zacb(zagVar, this.zao.get(), googleApi)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zam() {
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null || config.getMethodInvocationTelemetryEnabled()) {
            int zab2 = this.zam.zab(this.zak, 203390000);
            return zab2 == -1 || zab2 == 0;
        }
        return false;
    }

    public final <O extends Api.ApiOptions> Task<Void> zan(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, registerListenerMethod.zab(), googleApi);
        zaf zafVar = new zaf(new zacc(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(8, new zacb(zafVar, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zao(GoogleApi<O> googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaI(taskCompletionSource, i, googleApi);
        zah zahVar = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(13, new zacb(zahVar, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zap(ConnectionResult connectionResult, int i) {
        return this.zal.zac(this.zak, connectionResult, i);
    }

    public final void zaq(ConnectionResult connectionResult, int i) {
        if (zap(connectionResult, i)) {
            return;
        }
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zar(MethodInvocation methodInvocation, int i, long j, int i2) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(18, new zaby(methodInvocation, i, j, i2)));
    }
}
