package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.Store;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes3.dex */
public class SyncTask implements Runnable {
    private final FirebaseInstanceId iid;
    private final long nextDelaySeconds;
    ExecutorService processorExecutor = FirebaseIidExecutors.newCachedSingleThreadExecutor();
    private final PowerManager.WakeLock syncWakeLock;

    /* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
    /* loaded from: classes3.dex */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable
        private SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                if (FirebaseInstanceId.isDebugLogEnabled()) {
                    Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
                }
                this.task.iid.enqueueTaskWithDelaySeconds(this.task, 0L);
                this.task.getContext().unregisterReceiver(this);
                this.task = null;
            }
        }

        public void registerReceiver() {
            if (FirebaseInstanceId.isDebugLogEnabled()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.task.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SyncTask(FirebaseInstanceId firebaseInstanceId, long j) {
        this.iid = firebaseInstanceId;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private void invokeOnTokenRefresh(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.iid.getApp().getName())) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(this.iid.getApp().getName());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(getContext(), this.processorExecutor).process(intent);
        }
    }

    Context getContext() {
        return this.iid.getApp().getApplicationContext();
    }

    boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean maybeRefreshToken() throws IOException {
        Store.Token tokenWithoutTriggeringSync = this.iid.getTokenWithoutTriggeringSync();
        if (this.iid.tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            try {
                String blockingGetMasterToken = this.iid.blockingGetMasterToken();
                if (blockingGetMasterToken == null) {
                    Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                    return false;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Token successfully retrieved");
                }
                if (tokenWithoutTriggeringSync == null || !blockingGetMasterToken.equals(tokenWithoutTriggeringSync.token)) {
                    invokeOnTokenRefresh(blockingGetMasterToken);
                }
                return true;
            } catch (IOException e) {
                if (GmsRpc.isErrorMessageForRetryableError(e.getMessage())) {
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                    sb.append("Token retrieval failed: ");
                    sb.append(message);
                    sb.append(". Will retry token retrieval");
                    Log.w("FirebaseInstanceId", sb.toString());
                    return false;
                } else if (e.getMessage() == null) {
                    Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                    return false;
                } else {
                    throw e;
                }
            } catch (SecurityException unused) {
                Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            try {
                this.iid.setSyncScheduledOrRunning(true);
                if (!this.iid.isGmsCorePresent()) {
                    this.iid.setSyncScheduledOrRunning(false);
                    if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                        return;
                    }
                } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(getContext()) || isDeviceConnected()) {
                    if (maybeRefreshToken()) {
                        this.iid.setSyncScheduledOrRunning(false);
                    } else {
                        this.iid.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                    }
                    if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                        return;
                    }
                } else {
                    new ConnectivityChangeReceiver(this).registerReceiver();
                    if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                        return;
                    }
                }
            } catch (IOException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.iid.setSyncScheduledOrRunning(false);
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            }
            this.syncWakeLock.release();
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
            throw th;
        }
    }
}
