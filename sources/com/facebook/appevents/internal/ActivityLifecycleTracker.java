package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG = "com.facebook.appevents.internal.ActivityLifecycleTracker";
    private static String appId;
    private static WeakReference<Activity> currActivity;
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture currentFuture;
    private static volatile SessionInfo currentSession;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static final Object currentFutureLock = new Object();
    private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    private static AtomicBoolean tracking = new AtomicBoolean(false);
    private static int activityReferences = 0;

    static /* synthetic */ int access$108() {
        int i = activityReferences;
        activityReferences = i + 1;
        return i;
    }

    static /* synthetic */ int access$110() {
        int i = activityReferences;
        activityReferences = i - 1;
        return i;
    }

    public static void startTracking(Application application, String str) {
        if (tracking.compareAndSet(false, true)) {
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.1
                @Override // com.facebook.internal.FeatureManager.Callback
                public void onCompleted(boolean z) {
                    if (z) {
                        CodelessManager.enable();
                    } else {
                        CodelessManager.disable();
                    }
                }
            });
            appId = str;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityCreated(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    ActivityLifecycleTracker.access$108();
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityResumed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityPaused(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
                    AppEventsLogger.onContextStop();
                    ActivityLifecycleTracker.access$110();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
                    ActivityLifecycleTracker.onActivityDestroyed(activity);
                }
            });
        }
    }

    public static boolean isInBackground() {
        return activityReferences == 0;
    }

    public static boolean isTracking() {
        return tracking.get();
    }

    public static UUID getCurrentSessionGuid() {
        if (currentSession != null) {
            return currentSession.getSessionId();
        }
        return null;
    }

    public static void onActivityCreated(Activity activity) {
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.3
            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (ActivityLifecycleTracker.currentSession == null) {
                        SessionInfo unused = ActivityLifecycleTracker.currentSession = SessionInfo.getStoredSessionInfo();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    public static void onActivityResumed(Activity activity) {
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        final Context applicationContext = activity.getApplicationContext();
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.4
            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (ActivityLifecycleTracker.currentSession == null) {
                        SessionInfo unused = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                        SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId, applicationContext);
                    } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
                        long longValue = currentTimeMillis - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
                        if (longValue > ActivityLifecycleTracker.getSessionTimeoutInSeconds() * 1000) {
                            SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                            SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId, applicationContext);
                            SessionInfo unused2 = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                        } else if (longValue > 1000) {
                            ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
                        }
                    }
                    ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                    ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onActivityPaused(Activity activity) {
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.5
            @Override // java.lang.Runnable
            public void run() {
                if (CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    if (ActivityLifecycleTracker.currentSession == null) {
                        SessionInfo unused = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    }
                    ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                    if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                        Runnable runnable = new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    if (ActivityLifecycleTracker.currentSession == null) {
                                        SessionInfo unused2 = ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                                    }
                                    if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                                        SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                                        SessionInfo.clearSavedSessionFromDisk();
                                        SessionInfo unused3 = ActivityLifecycleTracker.currentSession = null;
                                    }
                                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                                        ScheduledFuture unused4 = ActivityLifecycleTracker.currentFuture = null;
                                    }
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            }
                        };
                        synchronized (ActivityLifecycleTracker.currentFutureLock) {
                            ScheduledFuture unused2 = ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(runnable, ActivityLifecycleTracker.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                        }
                    }
                    long j = ActivityLifecycleTracker.currentActivityAppearTime;
                    AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j > 0 ? (currentTimeMillis - j) / 1000 : 0L);
                    ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onActivityDestroyed(Activity activity) {
        CodelessManager.onActivityDestroyed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSessionTimeoutInSeconds() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    private static void cancelCurrentTask() {
        synchronized (currentFutureLock) {
            if (currentFuture != null) {
                currentFuture.cancel(false);
            }
            currentFuture = null;
        }
    }

    public static Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
