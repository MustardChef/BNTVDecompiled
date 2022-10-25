package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzqe {
    private static final zzqd zza;
    private static final zzqd zzb;

    static {
        zzqd zzqdVar;
        try {
            zzqdVar = (zzqd) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzqdVar = null;
        }
        zza = zzqdVar;
        zzb = new zzqd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqd zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqd zzb() {
        return zzb;
    }
}
