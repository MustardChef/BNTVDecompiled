package com.facebook.internal.logging;

/* loaded from: classes.dex */
public interface LoggingManager {
    void addLog(ExternalLog externalLog);

    void flushAndWait();

    void flushLoggingStore();
}
