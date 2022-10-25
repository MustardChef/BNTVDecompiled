package com.facebook.internal.logging;

import java.util.Collection;

/* loaded from: classes.dex */
public interface LoggingStore {
    Collection<ExternalLog> readAndClearStore();

    void saveLogsToDisk(Collection<ExternalLog> collection);
}
