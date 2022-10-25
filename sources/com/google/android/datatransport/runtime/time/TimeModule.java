package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;

@Module
/* loaded from: classes2.dex */
public abstract class TimeModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static Clock eventClock() {
        return new WallTimeClock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static Clock uptimeClock() {
        return new UptimeClock();
    }
}
