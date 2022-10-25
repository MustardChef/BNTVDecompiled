package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzjt {
    private static final zzjr zza = zzc();
    private static final zzjr zzb = new zzjq();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjr zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjr zzb() {
        return zzb;
    }

    private static zzjr zzc() {
        try {
            return (zzjr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
