package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class SessionEventsState {
    private static final String TAG = "SessionEventsState";
    private String anonymousAppDeviceGUID;
    private AttributionIdentifiers attributionIdentifiers;
    private int numSkippedEventsDueToFullBuffer;
    private List<AppEvent> accumulatedEvents = new ArrayList();
    private List<AppEvent> inFlightEvents = new ArrayList();
    private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;

    protected int getMAX_ACCUMULATED_LOG_EVENTS() {
        return CrashShieldHandler.isObjectCrashing(this) ? 0 : 1000;
    }

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers, String str) {
        this.attributionIdentifiers = attributionIdentifiers;
        this.anonymousAppDeviceGUID = str;
    }

    public synchronized void addEvent(AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= getMAX_ACCUMULATED_LOG_EVENTS()) {
            this.numSkippedEventsDueToFullBuffer++;
        } else {
            this.accumulatedEvents.add(appEvent);
        }
    }

    public synchronized int getAccumulatedEventCount() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        return this.accumulatedEvents.size();
    }

    public synchronized void clearInFlightAndStats(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (z) {
            this.accumulatedEvents.addAll(this.inFlightEvents);
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
    }

    public int populateRequest(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            synchronized (this) {
                int i = this.numSkippedEventsDueToFullBuffer;
                EventDeactivationManager.processEvents(this.accumulatedEvents);
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (appEvent.isChecksumValid()) {
                        if (z || !appEvent.getIsImplicit()) {
                            jSONArray.put(appEvent.getJSONObject());
                        }
                    } else {
                        String str = TAG;
                        Utility.logd(str, "Event with invalid checksum: " + appEvent.toString());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                populateRequest(graphRequest, context, i, jSONArray, z2);
                return jSONArray.length();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public synchronized List<AppEvent> getEventsToPersist() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        List<AppEvent> list = this.accumulatedEvents;
        this.accumulatedEvents = new ArrayList();
        return list;
    }

    public synchronized void accumulatePersistedEvents(List<AppEvent> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        this.accumulatedEvents.addAll(list);
    }

    private void populateRequest(GraphRequest graphRequest, Context context, int i, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context);
                if (this.numSkippedEventsDueToFullBuffer > 0) {
                    jSONObject.put("num_skipped_events", i);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            graphRequest.setGraphObject(jSONObject);
            Bundle parameters = graphRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2 != null) {
                parameters.putString("custom_events", jSONArray2);
                graphRequest.setTag(jSONArray2);
            }
            graphRequest.setParameters(parameters);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
