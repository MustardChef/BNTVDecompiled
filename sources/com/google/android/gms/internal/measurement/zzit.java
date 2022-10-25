package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
abstract class zzit {
    private static final zzit zza = new zziv();
    private static final zzit zzb = new zziu();

    private zzit() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzit zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzit zzb() {
        return zzb;
    }
}
