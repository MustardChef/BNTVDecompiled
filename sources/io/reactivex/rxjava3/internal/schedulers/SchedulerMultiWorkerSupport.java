package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;

/* loaded from: classes4.dex */
public interface SchedulerMultiWorkerSupport {

    /* loaded from: classes4.dex */
    public interface WorkerCallback {
        void onWorker(int index, Scheduler.Worker worker);
    }

    void createWorkers(int number, WorkerCallback callback);
}
