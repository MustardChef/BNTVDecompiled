package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
@Deprecated
/* loaded from: classes2.dex */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    /* loaded from: classes2.dex */
    public interface PooledExecutorFactory {
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zza == null) {
                zza = new zza();
            }
            pooledExecutorFactory = zza;
        }
        return pooledExecutorFactory;
    }
}
