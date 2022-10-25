package org.acra.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.builder.LastActivityManager;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;
import org.acra.sender.JobSenderService;
import org.acra.sender.LegacySenderService;
import org.acra.util.SystemServices;

/* compiled from: ProcessFinisher.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m107d2 = {"Lorg/acra/util/ProcessFinisher;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "lastActivityManager", "Lorg/acra/builder/LastActivityManager;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;Lorg/acra/builder/LastActivityManager;)V", "endApplication", "", "finishLastActivity", "uncaughtExceptionThread", "Ljava/lang/Thread;", "killProcessAndExit", "stopServices", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ProcessFinisher {
    private final CoreConfiguration config;
    private final Context context;
    private final LastActivityManager lastActivityManager;

    public ProcessFinisher(Context context, CoreConfiguration config, LastActivityManager lastActivityManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(lastActivityManager, "lastActivityManager");
        this.context = context;
        this.config = config;
        this.lastActivityManager = lastActivityManager;
    }

    public final void endApplication() {
        stopServices();
        killProcessAndExit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: finishLastActivity$lambda-2  reason: not valid java name */
    public static final void m10746finishLastActivity$lambda2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.finish();
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Finished ", activity.getClass()));
        }
    }

    private final void stopServices() {
        if (this.config.getStopServicesOnCrash()) {
            try {
                SystemServices systemServices = SystemServices.INSTANCE;
                List<ActivityManager.RunningServiceInfo> runningServices = SystemServices.getActivityManager(this.context).getRunningServices(Integer.MAX_VALUE);
                int myPid = Process.myPid();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == myPid && !Intrinsics.areEqual(LegacySenderService.class.getName(), runningServiceInfo.service.getClassName()) && !Intrinsics.areEqual(JobSenderService.class.getName(), runningServiceInfo.service.getClassName())) {
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(runningServiceInfo.service);
                            this.context.stopService(intent);
                        } catch (SecurityException unused) {
                            if (ACRA.DEV_LOGGING) {
                                ACRALog aCRALog = ACRA.log;
                                String str = ACRA.LOG_TAG;
                                aCRALog.mo69d(str, "Unable to stop Service " + runningServiceInfo.service.getClassName() + ". Permission denied");
                            }
                        }
                    }
                }
            } catch (SystemServices.ServiceNotReachedException e) {
                ACRA.log.mo66e(ACRA.LOG_TAG, "Unable to stop services", e);
            }
        }
    }

    private final void killProcessAndExit() {
        Process.killProcess(Process.myPid());
        System.exit(10);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final void finishLastActivity(Thread thread) {
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "Finishing activities prior to killing the Process");
        }
        boolean z = false;
        for (final Activity activity : this.lastActivityManager.getLastActivities()) {
            Runnable runnable = new Runnable() { // from class: org.acra.util.-$$Lambda$ProcessFinisher$0h46YQR9hD7rWwuxoj69yAAE-oc
                @Override // java.lang.Runnable
                public final void run() {
                    ProcessFinisher.m10746finishLastActivity$lambda2(activity);
                }
            };
            if (thread == activity.getMainLooper().getThread()) {
                runnable.run();
            } else {
                z = true;
                activity.runOnUiThread(runnable);
            }
        }
        if (z) {
            this.lastActivityManager.waitForAllActivitiesDestroy(100);
        }
        this.lastActivityManager.clearLastActivities();
    }
}
