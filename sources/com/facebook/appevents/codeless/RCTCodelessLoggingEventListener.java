package com.facebook.appevents.codeless;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class RCTCodelessLoggingEventListener {
    private static final String TAG = "com.facebook.appevents.codeless.RCTCodelessLoggingEventListener";

    public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding eventBinding, View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(RCTCodelessLoggingEventListener.class)) {
            return null;
        }
        try {
            return new AutoLoggingOnTouchListener(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RCTCodelessLoggingEventListener.class);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class AutoLoggingOnTouchListener implements View.OnTouchListener {
        private View.OnTouchListener existingOnTouchListener;
        private WeakReference<View> hostView;
        private EventBinding mapping;
        private WeakReference<View> rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
            this.supportCodelessLogging = false;
            if (eventBinding == null || view == null || view2 == null) {
                return;
            }
            this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            this.mapping = eventBinding;
            this.hostView = new WeakReference<>(view2);
            this.rootView = new WeakReference<>(view);
            this.supportCodelessLogging = true;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                logEvent();
            }
            View.OnTouchListener onTouchListener = this.existingOnTouchListener;
            return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
        }

        private void logEvent() {
            EventBinding eventBinding = this.mapping;
            if (eventBinding == null) {
                return;
            }
            final String eventName = eventBinding.getEventName();
            final Bundle parameters = CodelessMatcher.getParameters(this.mapping, this.rootView.get(), this.hostView.get());
            if (parameters.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                parameters.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(parameters.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
            }
            parameters.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(eventName, parameters);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        }

        public boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }
    }
}
