package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;

@Module
/* loaded from: classes2.dex */
public abstract class SchedulingConfigModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static SchedulerConfig config(Clock clock) {
        return SchedulerConfig.getDefault(clock);
    }
}
