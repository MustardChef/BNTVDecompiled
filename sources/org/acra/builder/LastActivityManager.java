package org.acra.builder;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.collections.WeakStack;

/* compiled from: LastActivityManager.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m107d2 = {"Lorg/acra/builder/LastActivityManager;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "(Landroid/app/Application;)V", "activityStack", "Lorg/acra/collections/WeakStack;", "Landroid/app/Activity;", "destroyedCondition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "lastActivities", "", "getLastActivities", "()Ljava/util/List;", "lastActivity", "getLastActivity", "()Landroid/app/Activity;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clearLastActivities", "", "waitForAllActivitiesDestroy", "timeOutInMillis", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class LastActivityManager {
    private final WeakStack<Activity> activityStack;
    private final Condition destroyedCondition;
    private final ReentrantLock lock;

    public LastActivityManager(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.activityStack = new WeakStack<>();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.destroyedCondition = reentrantLock.newCondition();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: org.acra.builder.LastActivityManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityCreated ", activity.getClass()));
                }
                LastActivityManager.this.activityStack.add(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityStarted ", activity.getClass()));
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityResumed ", activity.getClass()));
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityPaused ", activity.getClass()));
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityStopped ", activity.getClass()));
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivitySaveInstanceState ", activity.getClass()));
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (ACRA.DEV_LOGGING) {
                    ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("onActivityDestroyed ", activity.getClass()));
                }
                ReentrantLock reentrantLock2 = LastActivityManager.this.lock;
                LastActivityManager lastActivityManager = LastActivityManager.this;
                reentrantLock2.lock();
                try {
                    lastActivityManager.activityStack.remove(activity);
                    lastActivityManager.destroyedCondition.signalAll();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock2.unlock();
                }
            }
        });
    }

    public final Activity getLastActivity() {
        if (this.activityStack.isEmpty()) {
            return null;
        }
        return this.activityStack.peek();
    }

    public final List<Activity> getLastActivities() {
        return new ArrayList(this.activityStack);
    }

    public final void clearLastActivities() {
        this.activityStack.clear();
    }

    public final void waitForAllActivitiesDestroy(int i) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis;
            while (!this.activityStack.isEmpty()) {
                long j2 = i;
                if (currentTimeMillis + j2 <= j) {
                    break;
                }
                this.destroyedCondition.await((currentTimeMillis - j) + j2, TimeUnit.MILLISECONDS);
                j = System.currentTimeMillis();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
