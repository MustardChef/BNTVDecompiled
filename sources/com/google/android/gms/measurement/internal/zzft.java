package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzft implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzfr zzb;

    public zzft(zzfr zzfrVar, String str) {
        this.zzb = zzfrVar;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzq().zze().zza(this.zza, th);
    }
}
