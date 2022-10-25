package com.facebook.appevents.p032ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.ml.ModelManager */
/* loaded from: classes.dex */
public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String SDK_MODEL_ASSET = "%s/model_asset";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    private static final Map<String, TaskHandler> mTaskHandlers = new ConcurrentHashMap();
    private static final Integer MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = Arrays.asList("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = Arrays.asList("none", "address", IntegrityManager.INTEGRITY_TYPE_HEALTH);

    static /* synthetic */ boolean access$000(long j) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return false;
        }
        try {
            return isValidTimestamp(j);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return false;
        }
    }

    static /* synthetic */ JSONObject access$100() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            return fetchModels();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    static /* synthetic */ void access$200(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            addModels(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    static /* synthetic */ void access$300() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            enableMTML();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    static /* synthetic */ float[] access$400(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            return parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.appevents.ml.ModelManager$4 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C20064 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$appevents$ml$ModelManager$Task;

        static {
            int[] iArr = new int[Task.values().length];
            $SwitchMap$com$facebook$appevents$ml$ModelManager$Task = iArr;
            try {
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$appevents$ml$ModelManager$Task[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.facebook.appevents.ml.ModelManager$Task */
    /* loaded from: classes.dex */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public String toKey() {
            int i = C20064.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            return i != 1 ? i != 2 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "app_event_pred" : "integrity_detect";
        }

        public String toUseCase() {
            int i = C20064.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return "MTML_APP_EVENT_PRED";
            }
            return "MTML_INTEGRITY_DETECT";
        }
    }

    public static void enable() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.ml.ModelManager.1
                /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x006e, Exception -> 0x0072, TryCatch #2 {Exception -> 0x0072, all -> 0x006e, blocks: (B:5:0x000b, B:7:0x001d, B:10:0x0024, B:12:0x002f, B:14:0x003d, B:16:0x0043, B:22:0x0067, B:18:0x0049, B:21:0x0050, B:11:0x002a), top: B:28:0x000b }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        r7 = this;
                        java.lang.String r0 = "model_request_timestamp"
                        java.lang.String r1 = "models"
                        boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                        if (r2 == 0) goto Lb
                        return
                    Lb:
                        android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
                        r4 = 0
                        android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        r3 = 0
                        java.lang.String r3 = r2.getString(r1, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r3 == 0) goto L2a
                        boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r4 == 0) goto L24
                        goto L2a
                    L24:
                        org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        r4.<init>(r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        goto L2f
                    L2a:
                        org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        r4.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                    L2f:
                        r5 = 0
                        long r5 = r2.getLong(r0, r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        boolean r3 = com.facebook.internal.FeatureManager.isEnabled(r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r3 == 0) goto L49
                        int r3 = r4.length()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r3 == 0) goto L49
                        boolean r3 = com.facebook.appevents.p032ml.ModelManager.access$000(r5)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r3 != 0) goto L67
                    L49:
                        org.json.JSONObject r4 = com.facebook.appevents.p032ml.ModelManager.access$100()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        if (r4 != 0) goto L50
                        return
                    L50:
                        android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        r0.apply()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                    L67:
                        com.facebook.appevents.p032ml.ModelManager.access$200(r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        com.facebook.appevents.p032ml.ModelManager.access$300()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L72
                        goto L72
                    L6e:
                        r0 = move-exception
                        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r7)
                    L72:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.p032ml.ModelManager.RunnableC20031.run():void");
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private static boolean isValidTimestamp(long j) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class) || j == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - j < ((long) MODEL_REQUEST_INTERVAL_MILLISECONDS.intValue());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return false;
        }
    }

    private static void addModels(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    TaskHandler build = TaskHandler.build(jSONObject.getJSONObject(keys.next()));
                    if (build != null) {
                        mTaskHandlers.put(build.useCase, build);
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private static JSONObject parseRawJsonObject(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(VERSION_ID_KEY, jSONObject3.getString(VERSION_ID_KEY));
                    jSONObject4.put(USE_CASE_KEY, jSONObject3.getString(USE_CASE_KEY));
                    jSONObject4.put(THRESHOLD_KEY, jSONObject3.getJSONArray(THRESHOLD_KEY));
                    jSONObject4.put(ASSET_URI_KEY, jSONObject3.getString(ASSET_URI_KEY));
                    if (jSONObject3.has(RULES_URI_KEY)) {
                        jSONObject4.put(RULES_URI_KEY, jSONObject3.getString(RULES_URI_KEY));
                    }
                    jSONObject2.put(jSONObject3.getString(USE_CASE_KEY), jSONObject4);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                return new JSONObject();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private static JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", strArr));
            GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format(SDK_MODEL_ASSET, FacebookSdk.getApplicationId()), null);
            newGraphPathRequest.setSkipClientToken(true);
            newGraphPathRequest.setParameters(bundle);
            JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private static void enableMTML() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = null;
            int i = 0;
            for (Map.Entry<String, TaskHandler> entry : mTaskHandlers.entrySet()) {
                String key = entry.getKey();
                if (key.equals(Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                    TaskHandler value = entry.getValue();
                    str = value.assetUri;
                    i = Math.max(i, value.versionId);
                    if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                        arrayList.add(value.setOnPostExecute(new Runnable() { // from class: com.facebook.appevents.ml.ModelManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    SuggestedEventsManager.enable();
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }));
                    }
                }
                if (key.equals(Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                    TaskHandler value2 = entry.getValue();
                    String str2 = value2.assetUri;
                    int max = Math.max(i, value2.versionId);
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                        arrayList.add(value2.setOnPostExecute(new Runnable() { // from class: com.facebook.appevents.ml.ModelManager.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    IntegrityManager.enable();
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        }));
                    }
                    str = str2;
                    i = max;
                }
            }
            if (str == null || i <= 0 || arrayList.isEmpty()) {
                return;
            }
            TaskHandler.execute(new TaskHandler(MTML_USE_CASE, str, null, i, null), arrayList);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
        }
    }

    private static boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return false;
        }
        try {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                if (!resourceLocale.getLanguage().contains("en")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return false;
        }
    }

    private static float[] parseJsonArray(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    fArr[i] = Float.parseFloat(jSONArray.getString(i));
                } catch (JSONException unused) {
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    public static File getRuleFile(Task task) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.ruleFile;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    public static String[] predict(Task task, float[][] fArr, String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            TaskHandler taskHandler = mTaskHandlers.get(task.toUseCase());
            if (taskHandler != null && taskHandler.model != null) {
                int length = strArr.length;
                int length2 = fArr[0].length;
                MTensor mTensor = new MTensor(new int[]{length, length2});
                for (int i = 0; i < length; i++) {
                    System.arraycopy(fArr[i], 0, mTensor.getData(), i * length2, length2);
                }
                MTensor predictOnMTML = taskHandler.model.predictOnMTML(mTensor, strArr, task.toKey());
                float[] fArr2 = taskHandler.thresholds;
                if (predictOnMTML != null && fArr2 != null && predictOnMTML.getData().length != 0 && fArr2.length != 0) {
                    int i2 = C20064.$SwitchMap$com$facebook$appevents$ml$ModelManager$Task[task.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return processSuggestedEventResult(predictOnMTML, fArr2);
                    }
                    return processIntegrityDetectionResult(predictOnMTML, fArr2);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private static String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            String[] strArr = new String[shape];
            if (shape2 != fArr.length) {
                return null;
            }
            for (int i = 0; i < shape; i++) {
                strArr[i] = "other";
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    if (data[(i * shape2) + i2] >= fArr[i2]) {
                        strArr[i] = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    private static String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(ModelManager.class)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            String[] strArr = new String[shape];
            if (shape2 != fArr.length) {
                return null;
            }
            for (int i = 0; i < shape; i++) {
                strArr[i] = "none";
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    if (data[(i * shape2) + i2] >= fArr[i2]) {
                        strArr[i] = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                    }
                }
            }
            return strArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ModelManager.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.facebook.appevents.ml.ModelManager$TaskHandler */
    /* loaded from: classes.dex */
    public static class TaskHandler {
        String assetUri;
        Model model;
        private Runnable onPostExecute;
        File ruleFile;
        String ruleUri;
        float[] thresholds;
        String useCase;
        int versionId;

        TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }

        TaskHandler setOnPostExecute(Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        static TaskHandler build(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                return new TaskHandler(jSONObject.getString(ModelManager.USE_CASE_KEY), jSONObject.getString(ModelManager.ASSET_URI_KEY), jSONObject.optString(ModelManager.RULES_URI_KEY, null), jSONObject.getInt(ModelManager.VERSION_ID_KEY), ModelManager.access$400(jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY)));
            } catch (Exception unused) {
                return null;
            }
        }

        static void execute(TaskHandler taskHandler) {
            execute(taskHandler, Collections.singletonList(taskHandler));
        }

        static void execute(TaskHandler taskHandler, final List<TaskHandler> list) {
            deleteOldFiles(taskHandler.useCase, taskHandler.versionId);
            download(taskHandler.assetUri, taskHandler.useCase + "_" + taskHandler.versionId, new FileDownloadTask.Callback() { // from class: com.facebook.appevents.ml.ModelManager.TaskHandler.1
                @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                public void onComplete(File file) {
                    final Model build = Model.build(file);
                    if (build != null) {
                        for (final TaskHandler taskHandler2 : list) {
                            TaskHandler.download(taskHandler2.ruleUri, taskHandler2.useCase + "_" + taskHandler2.versionId + "_rule", new FileDownloadTask.Callback() { // from class: com.facebook.appevents.ml.ModelManager.TaskHandler.1.1
                                @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
                                public void onComplete(File file2) {
                                    taskHandler2.model = build;
                                    taskHandler2.ruleFile = file2;
                                    if (taskHandler2.onPostExecute != null) {
                                        taskHandler2.onPostExecute.run();
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }

        private static void deleteOldFiles(String str, int i) {
            File[] listFiles;
            File mlDir = Utils.getMlDir();
            if (mlDir == null || (listFiles = mlDir.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            String str2 = str + "_" + i;
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith(str) && !name.startsWith(str2)) {
                    file.delete();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void download(String str, String str2, FileDownloadTask.Callback callback) {
            File file = new File(Utils.getMlDir(), str2);
            if (str == null || file.exists()) {
                callback.onComplete(file);
            } else {
                new FileDownloadTask(str, file, callback).execute(new String[0]);
            }
        }
    }
}
