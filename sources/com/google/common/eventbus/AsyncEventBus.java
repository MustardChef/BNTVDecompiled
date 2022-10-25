package com.google.common.eventbus;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, executor, Dispatcher.legacyAsync(), subscriberExceptionHandler);
    }

    public AsyncEventBus(Executor executor) {
        super(MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }
}
