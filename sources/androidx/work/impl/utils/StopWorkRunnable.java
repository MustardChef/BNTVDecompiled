package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

/* loaded from: classes.dex */
public class StopWorkRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("StopWorkRunnable");
    private final boolean mStopInForeground;
    private final WorkManagerImpl mWorkManagerImpl;
    private final String mWorkSpecId;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String workSpecId, boolean stopInForeground) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = workSpecId;
        this.mStopInForeground = stopInForeground;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean stopWork;
        WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        Processor processor = this.mWorkManagerImpl.getProcessor();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            boolean isEnqueuedInForeground = processor.isEnqueuedInForeground(this.mWorkSpecId);
            if (this.mStopInForeground) {
                stopWork = this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mWorkSpecId);
            } else {
                if (!isEnqueuedInForeground && workSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.RUNNING) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                }
                stopWork = this.mWorkManagerImpl.getProcessor().stopWork(this.mWorkSpecId);
            }
            Logger.get().debug(TAG, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.mWorkSpecId, Boolean.valueOf(stopWork)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
