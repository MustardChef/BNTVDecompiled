package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.p032ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class IntegrityManager {
    public static final String INTEGRITY_TYPE_ADDRESS = "address";
    public static final String INTEGRITY_TYPE_HEALTH = "health";
    public static final String INTEGRITY_TYPE_NONE = "none";
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled = false;
    private static boolean isSampleEnabled = false;

    public static void enable() {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            enabled = true;
            isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    public static void processParameters(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            if (enabled && map.size() != 0) {
                try {
                    ArrayList<String> arrayList = new ArrayList(map.keySet());
                    JSONObject jSONObject = new JSONObject();
                    for (String str : arrayList) {
                        String str2 = map.get(str);
                        if (shouldFilter(str) || shouldFilter(str2)) {
                            map.remove(str);
                            if (!isSampleEnabled) {
                                str2 = "";
                            }
                            jSONObject.put(str, str2);
                        }
                    }
                    if (jSONObject.length() == 0) {
                        return;
                    }
                    map.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    private static boolean shouldFilter(String str) {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return false;
        }
        try {
            return !"none".equals(getIntegrityPredictionResult(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
            return false;
        }
    }

    private static String getIntegrityPredictionResult(String str) {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
            return predict == null ? "none" : predict[0];
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
            return null;
        }
    }
}
