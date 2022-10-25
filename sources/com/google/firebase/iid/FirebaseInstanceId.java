package com.google.firebase.iid;

import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.RequestDeduplicator;
import com.google.firebase.iid.Store;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
@Deprecated
/* loaded from: classes3.dex */
public class FirebaseInstanceId {
    private static Store store;
    static ScheduledExecutorService syncExecutor;
    private final FirebaseApp app;
    final Executor fileIoExecutor;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    private final GmsRpc rpc;
    private boolean syncScheduledOrRunning;
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");

    FirebaseInstanceId(FirebaseApp firebaseApp, Metadata metadata, Executor executor, Executor executor2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.syncScheduledOrRunning = false;
        if (Metadata.getDefaultSenderId(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (store == null) {
                    store = new Store(firebaseApp.getApplicationContext());
                }
            }
            this.app = firebaseApp;
            this.metadata = metadata;
            this.rpc = new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi);
            this.fileIoExecutor = executor2;
            this.requestDeduplicator = new RequestDeduplicator(executor);
            this.firebaseInstallations = firebaseInstallationsApi;
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    private <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    resetStorage();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        }
    }

    private static <T> T awaitTaskAllowOnMainThread(Task<T> task) throws InterruptedException {
        Preconditions.checkNotNull(task, "Task must not be null");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.addOnCompleteListener(FirebaseInstanceId$$Lambda$1.$instance, new OnCompleteListener(countDownLatch) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$2
            private final CountDownLatch arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = countDownLatch;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task task2) {
                this.arg$1.countDown();
            }
        });
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        return (T) getResultOrThrowException(task);
    }

    private static void checkRequiredFirebaseOptions(FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(isValidAppIdFormat(firebaseApp.getOptions().getApplicationId()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(isValidApiKeyFormat(firebaseApp.getOptions().getApiKey()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public static synchronized void clearInstancesForTest() {
        synchronized (FirebaseInstanceId.class) {
            ScheduledExecutorService scheduledExecutorService = syncExecutor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
            syncExecutor = null;
            store = null;
        }
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static <T> T getResultOrThrowException(Task<T> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    private String getSubtype() {
        return FirebaseApp.DEFAULT_APP_NAME.equals(this.app.getName()) ? "" : this.app.getPersistenceKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDebugLogEnabled() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    static boolean isValidApiKeyFormat(@Nonnull String str) {
        return API_KEY_FORMAT.matcher(str).matches();
    }

    static boolean isValidAppIdFormat(@Nonnull String str) {
        return str.contains(":");
    }

    private static String rationaliseScope(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase(Constants.MessageTypes.MESSAGE)) ? "*" : str;
    }

    private void startSyncIfNecessary() {
        if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String blockingGetMasterToken() throws IOException {
        return getToken(Metadata.getDefaultSenderId(this.app), "*");
    }

    @Deprecated
    public void deleteInstanceId() throws IOException {
        checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        awaitTask(this.firebaseInstallations.delete());
        resetStorage();
    }

    @Deprecated
    public void deleteToken(String str, String str2) throws IOException {
        checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String rationaliseScope = rationaliseScope(str2);
        awaitTask(this.rpc.deleteToken(getIdWithoutTriggeringSync(), str, rationaliseScope));
        store.deleteToken(getSubtype(), str, rationaliseScope);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseApp getApp() {
        return this.app;
    }

    public long getCreationTime() {
        return store.getCreationTime(this.app.getPersistenceKey());
    }

    @Deprecated
    public String getId() {
        checkRequiredFirebaseOptions(this.app);
        startSyncIfNecessary();
        return getIdWithoutTriggeringSync();
    }

    String getIdWithoutTriggeringSync() {
        try {
            store.setCreationTime(this.app.getPersistenceKey());
            return (String) awaitTaskAllowOnMainThread(this.firebaseInstallations.getId());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Deprecated
    public Task<InstanceIdResult> getInstanceId() {
        checkRequiredFirebaseOptions(this.app);
        return getInstanceId(Metadata.getDefaultSenderId(this.app), "*");
    }

    @Deprecated
    public String getToken() {
        checkRequiredFirebaseOptions(this.app);
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            startSync();
        }
        return Store.Token.getTokenOrNull(tokenWithoutTriggeringSync);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Store.Token getTokenWithoutTriggeringSync() {
        return getTokenWithoutTriggeringSync(Metadata.getDefaultSenderId(this.app), "*");
    }

    public boolean isFcmAutoInitEnabled() {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$getInstanceId$0$FirebaseInstanceId(String str, String str2, String str3, String str4) throws Exception {
        store.saveToken(getSubtype(), str, str2, str4, this.metadata.getAppVersionCode());
        return Tasks.forResult(new InstanceIdResultImpl(str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$getInstanceId$1$FirebaseInstanceId(final String str, final String str2, final String str3) {
        return this.rpc.getToken(str, str2, str3).onSuccessTask(this.fileIoExecutor, new SuccessContinuation(this, str2, str3, str) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$4
            private final FirebaseInstanceId arg$1;
            private final String arg$2;
            private final String arg$3;
            private final String arg$4;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = str2;
                this.arg$3 = str3;
                this.arg$4 = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                return this.arg$1.lambda$getInstanceId$0$FirebaseInstanceId(this.arg$2, this.arg$3, this.arg$4, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$getInstanceId$2$FirebaseInstanceId(final String str, final String str2, Task task) throws Exception {
        final String idWithoutTriggeringSync = getIdWithoutTriggeringSync();
        Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync(str, str2);
        return !tokenNeedsRefresh(tokenWithoutTriggeringSync) ? Tasks.forResult(new InstanceIdResultImpl(idWithoutTriggeringSync, tokenWithoutTriggeringSync.token)) : this.requestDeduplicator.getOrStartGetTokenRequest(str, str2, new RequestDeduplicator.GetTokenRequest(this, idWithoutTriggeringSync, str, str2) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$3
            private final FirebaseInstanceId arg$1;
            private final String arg$2;
            private final String arg$3;
            private final String arg$4;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = idWithoutTriggeringSync;
                this.arg$3 = str;
                this.arg$4 = str2;
            }

            @Override // com.google.firebase.iid.RequestDeduplicator.GetTokenRequest
            public Task start() {
                return this.arg$1.lambda$getInstanceId$1$FirebaseInstanceId(this.arg$2, this.arg$3, this.arg$4);
            }
        });
    }

    synchronized void resetStorage() {
        store.deleteAll();
    }

    public void setFcmAutoInitEnabled(boolean z) {
        throw new IllegalStateException("FirebaseMessaging version not supported. Update to latest version.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    synchronized void startSync() {
        if (this.syncScheduledOrRunning) {
            return;
        }
        syncWithDelaySecondsInternal(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tokenNeedsRefresh(Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        checkRequiredFirebaseOptions(firebaseApp);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
        Preconditions.checkNotNull(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    Store.Token getTokenWithoutTriggeringSync(String str, String str2) {
        return store.getToken(getSubtype(), str, str2);
    }

    private Task<InstanceIdResult> getInstanceId(final String str, String str2) {
        final String rationaliseScope = rationaliseScope(str2);
        return Tasks.forResult(null).continueWithTask(this.fileIoExecutor, new Continuation(this, str, rationaliseScope) { // from class: com.google.firebase.iid.FirebaseInstanceId$$Lambda$0
            private final FirebaseInstanceId arg$1;
            private final String arg$2;
            private final String arg$3;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = str;
                this.arg$3 = rationaliseScope;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return this.arg$1.lambda$getInstanceId$2$FirebaseInstanceId(this.arg$2, this.arg$3, task);
            }
        });
    }

    @Deprecated
    public String getToken(String str, String str2) throws IOException {
        checkRequiredFirebaseOptions(this.app);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        return ((InstanceIdResult) awaitTask(getInstanceId(str, str2))).getToken();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(FirebaseApp firebaseApp, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new Metadata(firebaseApp.getApplicationContext()), FirebaseIidExecutors.newCachedSingleThreadExecutor(), FirebaseIidExecutors.newCachedSingleThreadExecutor(), provider, provider2, firebaseInstallationsApi);
    }
}
