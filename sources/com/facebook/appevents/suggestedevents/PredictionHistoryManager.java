package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class PredictionHistoryManager {
    private static final String CLICKED_PATH_STORE = "com.facebook.internal.SUGGESTED_EVENTS_HISTORY";
    private static final String SUGGESTED_EVENTS_HISTORY = "SUGGESTED_EVENTS_HISTORY";
    private static final Map<String, String> clickedViewPaths = new HashMap();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static SharedPreferences shardPreferences;

    PredictionHistoryManager() {
    }

    private static void initAndWait() {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(CLICKED_PATH_STORE, 0);
            shardPreferences = sharedPreferences;
            clickedViewPaths.putAll(Utility.JsonStrToMap(sharedPreferences.getString(SUGGESTED_EVENTS_HISTORY, "")));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addPrediction(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return;
        }
        try {
            if (!initialized.get()) {
                initAndWait();
            }
            Map<String, String> map = clickedViewPaths;
            map.put(str, str2);
            shardPreferences.edit().putString(SUGGESTED_EVENTS_HISTORY, Utility.mapToJsonStr(map)).apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getPathID(View view, String str) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", str);
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    jSONArray.put(view.getClass().getSimpleName());
                    view = ViewHierarchy.getParentOfView(view);
                }
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, jSONArray);
            } catch (JSONException unused) {
            }
            return Utility.sha256hash(jSONObject.toString());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String queryEvent(String str) {
        if (CrashShieldHandler.isObjectCrashing(PredictionHistoryManager.class)) {
            return null;
        }
        try {
            Map<String, String> map = clickedViewPaths;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PredictionHistoryManager.class);
            return null;
        }
    }
}
