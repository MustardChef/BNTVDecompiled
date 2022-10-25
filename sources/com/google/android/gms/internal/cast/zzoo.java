package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzoo implements zzpw {
    private static final zzoo zza = new zzoo();

    private zzoo() {
    }

    public static zzoo zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.cast.zzpw
    public final boolean zzb(Class<?> cls) {
        return zzos.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.cast.zzpw
    public final zzpv zzc(Class<?> cls) {
        if (!zzos.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzpv) zzos.zzt(cls.asSubclass(zzos.class)).zzb(3, null, null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
