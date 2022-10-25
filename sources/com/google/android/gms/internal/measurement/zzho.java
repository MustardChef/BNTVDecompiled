package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzho {
    private static final zzhn<?> zza = new zzhp();
    private static final zzhn<?> zzb = zzc();

    private static zzhn<?> zzc() {
        try {
            return (zzhn) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhn<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhn<?> zzb() {
        zzhn<?> zzhnVar = zzb;
        if (zzhnVar != null) {
            return zzhnVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
