package com.facebook.internal.logging.monitor;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Monitor {
    private static boolean isEnabled;
    private static final Random random = new Random();
    private static Integer defaultSamplingRate = 1000;
    private static final LoggingManager monitorLoggingManager = MonitorLoggingManager.getInstance(MonitorLoggingQueue.getInstance(), MonitorLoggingStore.getInstance());
    private static final MetricsUtil metricsUtil = MetricsUtil.getInstance();
    private static final Map<String, Integer> samplingRatesMap = new HashMap();
    private static final AtomicLong UNIQUE_EXTRA_ID = new AtomicLong(0);

    private Monitor() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void enable() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            if (isEnabled) {
                return;
            }
            isEnabled = true;
            loadSamplingRatesMapAsync();
            monitorLoggingManager.flushLoggingStore();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    static void loadSamplingRatesMapAsync() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.logging.monitor.Monitor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        JSONObject fetchSamplingRate = Monitor.fetchSamplingRate();
                        if (fetchSamplingRate != null) {
                            Monitor.updateSamplingRateMap(fetchSamplingRate);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    static JSONObject fetchSamplingRate() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", MonitorLogServerProtocol.MONITOR_CONFIG);
            GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, FacebookSdk.getApplicationId(), null);
            newGraphPathRequest.setSkipClientToken(true);
            newGraphPathRequest.setParameters(bundle);
            return newGraphPathRequest.executeAndWait().getJSONObject();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return null;
        }
    }

    static void updateSamplingRateMap(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONObject(MonitorLogServerProtocol.MONITOR_CONFIG).getJSONArray(MonitorLogServerProtocol.SAMPLE_RATES);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString(SDKConstants.PARAM_KEY);
                int i2 = jSONObject2.getInt("value");
                if (MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY.equals(string)) {
                    defaultSamplingRate = Integer.valueOf(i2);
                } else {
                    samplingRatesMap.put(string, Integer.valueOf(i2));
                }
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            if (isEnabled && isSampled(performanceEventName.toString())) {
                metricsUtil.startMeasureFor(performanceEventName, j);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void startMeasurePerfFor(PerformanceEventName performanceEventName) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            startMeasurePerfFor(performanceEventName, getCurrentThreadID());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            MonitorLog stopMeasureFor = metricsUtil.stopMeasureFor(performanceEventName, j);
            if (stopMeasureFor.isValid()) {
                addLog(stopMeasureFor);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void stopMeasurePerfFor(PerformanceEventName performanceEventName) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            stopMeasurePerfFor(performanceEventName, getCurrentThreadID());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            metricsUtil.removeTempMetricsDataFor(performanceEventName, getCurrentThreadID());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static void cancelMeasurePerfFor(PerformanceEventName performanceEventName, long j) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            metricsUtil.removeTempMetricsDataFor(performanceEventName, j);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static long generateExtraId() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return 0L;
        }
        try {
            return UNIQUE_EXTRA_ID.incrementAndGet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return 0L;
        }
    }

    private static long getCurrentThreadID() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return 0L;
        }
        try {
            return Thread.currentThread().getId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return 0L;
        }
    }

    static void addLog(ExternalLog externalLog) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return;
        }
        try {
            if (isEnabled) {
                monitorLoggingManager.addLog(externalLog);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
        }
    }

    public static boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return false;
        }
        try {
            return isEnabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return false;
        }
    }

    static boolean isSampled(String str) {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return false;
        }
        try {
            if (Utility.isNullOrEmpty(str)) {
                return false;
            }
            int intValue = defaultSamplingRate.intValue();
            Map<String, Integer> map = samplingRatesMap;
            if (map.containsKey(str)) {
                intValue = map.get(str).intValue();
            }
            if (intValue > 0) {
                return random.nextInt(intValue) == 0;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return false;
        }
    }

    static Integer getDefaultSamplingRate() {
        if (CrashShieldHandler.isObjectCrashing(Monitor.class)) {
            return null;
        }
        try {
            return defaultSamplingRate;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Monitor.class);
            return null;
        }
    }
}
