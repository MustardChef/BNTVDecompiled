package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzok {
    private static final zzoi<?> zza = new zzoj();
    private static final zzoi<?> zzb;

    static {
        zzoi<?> zzoiVar;
        try {
            zzoiVar = (zzoi) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzoiVar = null;
        }
        zzb = zzoiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzoi<?> zzb() {
        zzoi<?> zzoiVar = zzb;
        if (zzoiVar != null) {
            return zzoiVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
