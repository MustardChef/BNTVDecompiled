package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzpu {
    private static final zzpt zza;
    private static final zzpt zzb;

    static {
        zzpt zzptVar;
        try {
            zzptVar = (zzpt) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzptVar = null;
        }
        zza = zzptVar;
        zzb = new zzpt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzpt zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzpt zzb() {
        return zzb;
    }
}
