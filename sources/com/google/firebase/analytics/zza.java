package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzag;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* loaded from: classes3.dex */
final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzag zzagVar;
        zzagVar = this.zza.zzb;
        return zzagVar.zzh();
    }
}
