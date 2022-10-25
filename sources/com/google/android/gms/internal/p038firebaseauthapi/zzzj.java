package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj */
/* loaded from: classes3.dex */
final class zzzj implements zzaap {
    private static final zzzj zza = new zzzj();

    private zzzj() {
    }

    public static zzzj zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaap
    public final boolean zzb(Class<?> cls) {
        return zzzo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaap
    public final zzaao zzc(Class<?> cls) {
        if (!zzzo.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzaao) zzzo.zzx(cls.asSubclass(zzzo.class)).zzj(3, null, null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
