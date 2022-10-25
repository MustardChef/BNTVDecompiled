package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EventDeactivationManager {
    private static boolean enabled = false;
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static final Set<String> deprecatedEvents = new HashSet();

    public static void enable() {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            enabled = true;
            initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    private static synchronized void initialize() {
        FetchedAppSettings queryAppSettings;
        synchronized (EventDeactivationManager.class) {
            if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
                return;
            }
            try {
                queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            } catch (Exception unused) {
            }
            if (queryAppSettings == null) {
                return;
            }
            String restrictiveDataSetting = queryAppSettings.getRestrictiveDataSetting();
            if (!restrictiveDataSetting.isEmpty()) {
                JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                deprecatedParamFilters.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        if (jSONObject2.optBoolean("is_deprecated_event")) {
                            deprecatedEvents.add(next);
                        } else {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                            DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(next, new ArrayList());
                            if (optJSONArray != null) {
                                deprecatedParamFilter.deprecateParams = Utility.convertJSONArrayToList(optJSONArray);
                            }
                            deprecatedParamFilters.add(deprecatedParamFilter);
                        }
                    }
                }
            }
        }
    }

    public static void processEvents(List<AppEvent> list) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            if (enabled) {
                Iterator<AppEvent> it = list.iterator();
                while (it.hasNext()) {
                    if (deprecatedEvents.contains(it.next().getName())) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    public static void processDeprecatedParameters(Map<String, String> map, String str) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            if (enabled) {
                ArrayList<String> arrayList = new ArrayList(map.keySet());
                for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                    if (deprecatedParamFilter.eventName.equals(str)) {
                        for (String str2 : arrayList) {
                            if (deprecatedParamFilter.deprecateParams.contains(str2)) {
                                map.remove(str2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DeprecatedParamFilter {
        List<String> deprecateParams;
        String eventName;

        DeprecatedParamFilter(String str, List<String> list) {
            this.eventName = str;
            this.deprecateParams = list;
        }
    }
}
