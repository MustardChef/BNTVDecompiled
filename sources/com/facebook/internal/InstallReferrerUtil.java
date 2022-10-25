package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public class InstallReferrerUtil {
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    /* loaded from: classes.dex */
    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    static /* synthetic */ void access$000() {
        if (CrashShieldHandler.isObjectCrashing(InstallReferrerUtil.class)) {
            return;
        }
        try {
            updateReferrer();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstallReferrerUtil.class);
        }
    }

    private InstallReferrerUtil() {
    }

    public static void tryUpdateReferrerInfo(Callback callback) {
        if (CrashShieldHandler.isObjectCrashing(InstallReferrerUtil.class)) {
            return;
        }
        try {
            if (isUpdated()) {
                return;
            }
            tryConnectReferrerInfo(callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstallReferrerUtil.class);
        }
    }

    private static void tryConnectReferrerInfo(final Callback callback) {
        if (CrashShieldHandler.isObjectCrashing(InstallReferrerUtil.class)) {
            return;
        }
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
            try {
                build.startConnection(new InstallReferrerStateListener() { // from class: com.facebook.internal.InstallReferrerUtil.1
                    @Override // com.android.installreferrer.api.InstallReferrerStateListener
                    public void onInstallReferrerServiceDisconnected() {
                    }

                    @Override // com.android.installreferrer.api.InstallReferrerStateListener
                    public void onInstallReferrerSetupFinished(int i) {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (i != 0) {
                                if (i != 2) {
                                    return;
                                }
                                InstallReferrerUtil.access$000();
                                return;
                            }
                            try {
                                String installReferrer = InstallReferrerClient.this.getInstallReferrer().getInstallReferrer();
                                if (installReferrer != null && (installReferrer.contains("fb") || installReferrer.contains("facebook"))) {
                                    callback.onReceiveReferrerUrl(installReferrer);
                                }
                                InstallReferrerUtil.access$000();
                            } catch (RemoteException unused) {
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstallReferrerUtil.class);
        }
    }

    private static void updateReferrer() {
        if (CrashShieldHandler.isObjectCrashing(InstallReferrerUtil.class)) {
            return;
        }
        try {
            FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstallReferrerUtil.class);
        }
    }

    private static boolean isUpdated() {
        if (CrashShieldHandler.isObjectCrashing(InstallReferrerUtil.class)) {
            return false;
        }
        try {
            return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InstallReferrerUtil.class);
            return false;
        }
    }
}
