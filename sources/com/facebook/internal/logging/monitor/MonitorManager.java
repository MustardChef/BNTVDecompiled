package com.facebook.internal.logging.monitor;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

/* loaded from: classes.dex */
public class MonitorManager {
    private static MonitorCreator monitorCreator = new MonitorCreator() { // from class: com.facebook.internal.logging.monitor.MonitorManager.1
        @Override // com.facebook.internal.logging.monitor.MonitorManager.MonitorCreator
        public void enable() {
            Monitor.enable();
        }
    };

    /* loaded from: classes.dex */
    public interface MonitorCreator {
        void enable();
    }

    public static void start() {
        FetchedAppSettings appSettingsWithoutQuery;
        if (FacebookSdk.getMonitorEnabled() && (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId())) != null && appSettingsWithoutQuery.getMonitorViaDialogEnabled()) {
            monitorCreator.enable();
        }
    }

    static void setMonitorCreator(MonitorCreator monitorCreator2) {
        monitorCreator = monitorCreator2;
    }
}
