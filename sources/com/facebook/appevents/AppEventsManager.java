package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.p032ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public class AppEventsManager {
    public static void start() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsManager.class)) {
            return;
        }
        try {
            FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsManager.FetchedAppSettingsCallback() { // from class: com.facebook.appevents.AppEventsManager.1
                @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                public void onError() {
                }

                @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
                public void onSuccess(FetchedAppSettings fetchedAppSettings) {
                    FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.1.1
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public void onCompleted(boolean z) {
                            if (z) {
                                MetadataIndexer.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.1.2
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public void onCompleted(boolean z) {
                            if (z) {
                                RestrictiveDataManager.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.1.3
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public void onCompleted(boolean z) {
                            if (z) {
                                ModelManager.enable();
                            }
                        }
                    });
                    FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: com.facebook.appevents.AppEventsManager.1.4
                        @Override // com.facebook.internal.FeatureManager.Callback
                        public void onCompleted(boolean z) {
                            if (z) {
                                EventDeactivationManager.enable();
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsManager.class);
        }
    }
}
