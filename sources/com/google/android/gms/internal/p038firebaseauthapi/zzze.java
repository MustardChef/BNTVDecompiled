package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzze */
/* loaded from: classes3.dex */
final class zzze {
    private static final zzzc<?> zza = new zzzd();
    private static final zzzc<?> zzb;

    static {
        zzzc<?> zzzcVar;
        try {
            zzzcVar = (zzzc) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzzcVar = null;
        }
        zzb = zzzcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzc<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzzc<?> zzb() {
        zzzc<?> zzzcVar = zzb;
        if (zzzcVar != null) {
            return zzzcVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
