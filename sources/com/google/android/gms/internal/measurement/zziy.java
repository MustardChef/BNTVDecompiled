package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zziy implements zzjg {
    private zzjg[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziy(zzjg... zzjgVarArr) {
        this.zza = zzjgVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean zza(Class<?> cls) {
        for (zzjg zzjgVar : this.zza) {
            if (zzjgVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final zzjh zzb(Class<?> cls) {
        zzjg[] zzjgVarArr;
        for (zzjg zzjgVar : this.zza) {
            if (zzjgVar.zza(cls)) {
                return zzjgVar.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
