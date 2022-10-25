package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(GreedyScheduler scheduler, RunnableScheduler runnableScheduler) {
        this.mGreedyScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
    }

    public void schedule(final WorkSpec workSpec) {
        Runnable remove = this.mRunnables.remove(workSpec.f145id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.get().debug(DelayedWorkTracker.TAG, String.format("Scheduling work %s", workSpec.f145id), new Throwable[0]);
                DelayedWorkTracker.this.mGreedyScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.f145id, runnable);
        long currentTimeMillis = System.currentTimeMillis();
        this.mRunnableScheduler.scheduleWithDelay(workSpec.calculateNextRunTime() - currentTimeMillis, runnable);
    }

    public void unschedule(String workSpecId) {
        Runnable remove = this.mRunnables.remove(workSpecId);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }
}
