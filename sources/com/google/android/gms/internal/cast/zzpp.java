package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzpp implements zzpw {
    private final zzpw[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpp(zzpw... zzpwVarArr) {
        this.zza = zzpwVarArr;
    }

    @Override // com.google.android.gms.internal.cast.zzpw
    public final boolean zzb(Class<?> cls) {
        zzpw[] zzpwVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzpwVarArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzpw
    public final zzpv zzc(Class<?> cls) {
        zzpw[] zzpwVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzpw zzpwVar = zzpwVarArr[i];
            if (zzpwVar.zzb(cls)) {
                return zzpwVar.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
