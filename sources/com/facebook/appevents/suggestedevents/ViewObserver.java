package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int MAX_TEXT_LENGTH = 300;
    private static final String TAG = "com.facebook.appevents.suggestedevents.ViewObserver";
    private static final Map<Integer, ViewObserver> observers = new HashMap();
    private WeakReference<Activity> activityWeakReference;
    private final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    private AtomicBoolean isTracking = new AtomicBoolean(false);

    static /* synthetic */ WeakReference access$000(ViewObserver viewObserver) {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return null;
        }
        try {
            return viewObserver.activityWeakReference;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewObserver.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startTrackingActivity(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return;
        }
        try {
            int hashCode = activity.hashCode();
            Map<Integer, ViewObserver> map = observers;
            if (map.containsKey(Integer.valueOf(hashCode))) {
                return;
            }
            ViewObserver viewObserver = new ViewObserver(activity);
            map.put(Integer.valueOf(hashCode), viewObserver);
            viewObserver.startTracking();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewObserver.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void stopTrackingActivity(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(ViewObserver.class)) {
            return;
        }
        try {
            int hashCode = activity.hashCode();
            Map<Integer, ViewObserver> map = observers;
            if (map.containsKey(Integer.valueOf(hashCode))) {
                map.remove(Integer.valueOf(hashCode));
                map.get(Integer.valueOf(hashCode)).stopTracking();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ViewObserver.class);
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
    }

    private void startTracking() {
        View rootView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.isTracking.getAndSet(true) || (rootView = AppEventUtility.getRootView(this.activityWeakReference.get())) == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                process();
                this.activityWeakReference.get();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stopTracking() {
        View rootView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.isTracking.getAndSet(false) && (rootView = AppEventUtility.getRootView(this.activityWeakReference.get())) != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    if (Build.VERSION.SDK_INT < 16) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    } else {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
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
            Runnable runnable = new Runnable() { // from class: com.facebook.appevents.suggestedevents.ViewObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        View rootView = AppEventUtility.getRootView((Activity) ViewObserver.access$000(ViewObserver.this).get());
                        Activity activity = (Activity) ViewObserver.access$000(ViewObserver.this).get();
                        if (rootView != null && activity != null) {
                            for (View view : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                                    String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view);
                                    if (!textOfViewRecursively.isEmpty() && textOfViewRecursively.length() <= 300) {
                                        ViewOnClickListener.attachListener(view, rootView, activity.getLocalClassName());
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                this.uiThreadHandler.post(runnable);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
