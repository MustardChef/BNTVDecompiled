package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.p032ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ViewOnClickListener implements View.OnClickListener {
    private static final String API_ENDPOINT = "%s/suggested_events";
    public static final String OTHER_EVENT = "other";
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewOnClickListener";
    private static final Set<Integer> viewsAttachedListener = new HashSet();
    private String activityName;
    private View.OnClickListener baseListener;
    private WeakReference<View> hostViewWeakReference;
    private WeakReference<View> rootViewWeakReference;

    static /* synthetic */ void access$000(String str, String str2, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            processPredictedResult(str, str2, fArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    static /* synthetic */ String access$100(ViewOnClickListener viewOnClickListener) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewOnClickListener.activityName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void attachListener(View view, View view2, String str) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            int hashCode = view.hashCode();
            Set<Integer> set = viewsAttachedListener;
            if (set.contains(Integer.valueOf(hashCode))) {
                return;
            }
            ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str));
            set.add(Integer.valueOf(hashCode));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.hostViewWeakReference = new WeakReference<>(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.activityName = str.toLowerCase().replace("activity", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View.OnClickListener onClickListener = this.baseListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            process();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void process() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View view = this.rootViewWeakReference.get();
            View view2 = this.hostViewWeakReference.get();
            if (view != null && view2 != null) {
                try {
                    String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                    String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                    if (pathID == null || queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                    jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                    predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private static boolean queryHistoryAndProcess(String str, final String str2) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return false;
        }
        try {
            final String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (queryEvent.equals("other")) {
                return true;
            }
            Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.suggestedevents.ViewOnClickListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        ViewOnClickListener.access$000(queryEvent, str2, new float[0]);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
            return false;
        }
    }

    private void predictAndProcess(final String str, final String str2, final JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Utility.runOnNonUiThread(new Runnable() { // from class: com.facebook.appevents.suggestedevents.ViewOnClickListener.2
                @Override // java.lang.Runnable
                public void run() {
                    String[] predict;
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        String lowerCase = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
                        float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                        String textFeature = FeatureExtractor.getTextFeature(str2, ViewOnClickListener.access$100(ViewOnClickListener.this), lowerCase);
                        if (denseFeatures == null || (predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature})) == null) {
                            return;
                        }
                        String str3 = predict[0];
                        PredictionHistoryManager.addPrediction(str, str3);
                        if (str3.equals("other")) {
                            return;
                        }
                        ViewOnClickListener.access$000(str3, str2, denseFeatures);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private static void processPredictedResult(String str, String str2, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            if (SuggestedEventsManager.isProductionEvents(str)) {
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
            } else if (SuggestedEventsManager.isEligibleEvents(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }

    private static void sendPredictedResult(String str, String str2, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                for (float f : fArr) {
                    sb.append(f);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString(TtmlNode.TAG_METADATA, jSONObject.toString());
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, API_ENDPOINT, FacebookSdk.getApplicationId()), null, null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewOnClickListener.class);
        }
    }
}
