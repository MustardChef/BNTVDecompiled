package com.facebook.appevents.aam;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public final class MetadataIndexer {
    private static final String TAG = "com.facebook.appevents.aam.MetadataIndexer";
    private static Boolean enabled = false;

    static /* synthetic */ void access$000() {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            updateRules();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    static /* synthetic */ Boolean access$102(Boolean bool) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return null;
        }
        try {
            enabled = bool;
            return bool;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
            return null;
        }
    }

    public static void onActivityResumed(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            if (enabled.booleanValue() && !MetadataRule.getRules().isEmpty()) {
                MetadataViewObserver.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    private static void updateRules() {
        String rawAamRules;
        if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
            return;
        }
        try {
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null || (rawAamRules = queryAppSettings.getRawAamRules()) == null) {
                return;
            }
            MetadataRule.updateRules(rawAamRules);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }

    public static void enable() {
        try {
            if (CrashShieldHandler.isObjectCrashing(MetadataIndexer.class)) {
                return;
            }
            try {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.aam.MetadataIndexer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (AttributionIdentifiers.isTrackingLimited(FacebookSdk.getApplicationContext())) {
                                return;
                            }
                            MetadataIndexer.access$000();
                            MetadataIndexer.access$102(true);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                });
            } catch (Exception e) {
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MetadataIndexer.class);
        }
    }
}
