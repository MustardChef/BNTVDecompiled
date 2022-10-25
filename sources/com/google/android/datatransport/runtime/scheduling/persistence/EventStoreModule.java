package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;

@Module
/* loaded from: classes2.dex */
public abstract class EventStoreModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SQLITE_DB_NAME")
    public static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Binds
    abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Named("SCHEMA_VERSION")
    public static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }
}
