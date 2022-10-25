package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ExceptionAnalyzer {
    private static boolean enabled = false;

    public static void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendExceptionAnalysisReports();
        }
    }

    public static void execute(Throwable th) {
        if (enabled) {
            HashSet hashSet = new HashSet();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                FeatureManager.Feature feature = FeatureManager.getFeature(stackTraceElement.getClassName());
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            if (!FacebookSdk.getAutoLogAppEventsEnabled() || hashSet.isEmpty()) {
                return;
            }
            InstrumentData.Builder.build(new JSONArray((Collection) hashSet)).save();
        }
    }

    private static void sendExceptionAnalysisReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File file : listExceptionAnalysisReportFiles) {
            final InstrumentData load = InstrumentData.Builder.load(file);
            if (load.isValid()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", load.toString());
                    arrayList.add(GraphRequest.newPostRequest(null, String.format("%s/instruments", FacebookSdk.getApplicationId()), jSONObject, new GraphRequest.Callback() { // from class: com.facebook.internal.instrument.ExceptionAnalyzer.1
                        @Override // com.facebook.GraphRequest.Callback
                        public void onCompleted(GraphResponse graphResponse) {
                            try {
                                if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                                    InstrumentData.this.clear();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new GraphRequestBatch(arrayList).executeAsync();
    }
}
