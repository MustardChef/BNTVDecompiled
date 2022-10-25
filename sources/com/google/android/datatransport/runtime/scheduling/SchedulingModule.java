package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;

@Module
/* loaded from: classes2.dex */
public abstract class SchedulingModule {
    @Binds
    abstract Scheduler scheduler(DefaultScheduler defaultScheduler);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new JobInfoScheduler(context, eventStore, schedulerConfig);
        }
        return new AlarmManagerScheduler(context, eventStore, clock, schedulerConfig);
    }
}
