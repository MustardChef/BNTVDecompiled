package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class SafeLoggingExecutor implements Executor {
    private final Executor delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeLoggingExecutor(Executor executor) {
        this.delegate = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(new SafeLoggingRunnable(runnable));
    }

    /* loaded from: classes2.dex */
    static class SafeLoggingRunnable implements Runnable {
        private final Runnable delegate;

        SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Exception e) {
                Logging.m417e("Executor", "Background execution failure.", e);
            }
        }
    }
}
