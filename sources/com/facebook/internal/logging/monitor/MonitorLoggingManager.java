package com.facebook.internal.logging.monitor;

import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.logging.LoggingCache;
import com.facebook.internal.logging.LoggingManager;
import com.facebook.internal.logging.LoggingStore;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MonitorLoggingManager implements LoggingManager {
    private static final String ENTRIES_KEY = "entries";
    private static final int FLUSH_PERIOD = 5;
    private static final String MONITORING_ENDPOINT = "monitorings";
    private static MonitorLoggingManager monitorLoggingManager;
    private ScheduledFuture flushTimer;
    private LoggingCache logQueue;
    private LoggingStore logStore;
    private static final Integer MAX_LOG_NUMBER_PER_REQUEST = 100;
    private static String deviceOSVersion = Build.VERSION.RELEASE;
    private static String deviceModel = Build.MODEL;
    private final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private final Runnable flushRunnable = new Runnable() { // from class: com.facebook.internal.logging.monitor.MonitorLoggingManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                MonitorLoggingManager.this.flushAndWait();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    };

    private MonitorLoggingManager(LoggingCache loggingCache, LoggingStore loggingStore) {
        if (this.logQueue == null) {
            this.logQueue = loggingCache;
        }
        if (this.logStore == null) {
            this.logStore = loggingStore;
        }
    }

    public static synchronized MonitorLoggingManager getInstance(LoggingCache loggingCache, LoggingStore loggingStore) {
        MonitorLoggingManager monitorLoggingManager2;
        synchronized (MonitorLoggingManager.class) {
            if (monitorLoggingManager == null) {
                monitorLoggingManager = new MonitorLoggingManager(loggingCache, loggingStore);
            }
            monitorLoggingManager2 = monitorLoggingManager;
        }
        return monitorLoggingManager2;
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void addLog(final ExternalLog externalLog) {
        this.singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.internal.logging.monitor.MonitorLoggingManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (!MonitorLoggingManager.this.logQueue.addLog(externalLog)) {
                        if (MonitorLoggingManager.this.flushTimer == null) {
                            MonitorLoggingManager monitorLoggingManager2 = MonitorLoggingManager.this;
                            monitorLoggingManager2.flushTimer = monitorLoggingManager2.singleThreadExecutor.schedule(MonitorLoggingManager.this.flushRunnable, 5L, TimeUnit.MINUTES);
                            return;
                        }
                        return;
                    }
                    MonitorLoggingManager.this.flushAndWait();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void flushAndWait() {
        ScheduledFuture scheduledFuture = this.flushTimer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        try {
            new GraphRequestBatch(buildRequests(this.logQueue)).executeAsync();
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.internal.logging.LoggingManager
    public void flushLoggingStore() {
        this.logQueue.addLogs(this.logStore.readAndClearStore());
        flushAndWait();
    }

    static List<GraphRequest> buildRequests(LoggingCache loggingCache) {
        ArrayList arrayList = new ArrayList();
        if (Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
            return arrayList;
        }
        while (!loggingCache.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < MAX_LOG_NUMBER_PER_REQUEST.intValue() && !loggingCache.isEmpty(); i++) {
                arrayList2.add(loggingCache.fetchLog());
            }
            GraphRequest buildPostRequestFromLogs = buildPostRequestFromLogs(arrayList2);
            if (buildPostRequestFromLogs != null) {
                arrayList.add(buildPostRequestFromLogs);
            }
        }
        return arrayList;
    }

    static GraphRequest buildPostRequestFromLogs(List<? extends ExternalLog> list) {
        String packageName = FacebookSdk.getApplicationContext().getPackageName();
        JSONArray jSONArray = new JSONArray();
        for (ExternalLog externalLog : list) {
            jSONArray.put(externalLog.convertToJSONObject());
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_OS_VERSION, deviceOSVersion);
            jSONObject.put(MonitorLogServerProtocol.PARAM_DEVICE_MODEL, deviceModel);
            jSONObject.put(MonitorLogServerProtocol.PARAM_UNIQUE_APPLICATION_ID, packageName);
            jSONObject.put(ENTRIES_KEY, jSONArray.toString());
            return GraphRequest.newPostRequest(null, String.format("%s/monitorings", FacebookSdk.getApplicationId()), jSONObject, null);
        } catch (JSONException unused) {
            return null;
        }
    }
}
