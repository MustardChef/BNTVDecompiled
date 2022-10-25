package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class NewThreadScheduler extends Scheduler {
    final ThreadFactory threadFactory;
    private static final String THREAD_NAME_PREFIX = "RxNewThreadScheduler";
    private static final String KEY_NEWTHREAD_PRIORITY = "rx3.newthread-priority";
    private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_NEWTHREAD_PRIORITY, 5).intValue())));

    public NewThreadScheduler() {
        this(THREAD_FACTORY);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
