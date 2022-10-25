package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzb implements Executor {
    static final Executor zza = new zzb();

    private zzb() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
