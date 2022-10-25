package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaai */
/* loaded from: classes3.dex */
final class zzaai implements zzaap {
    private final zzaap[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaai(zzaap... zzaapVarArr) {
        this.zza = zzaapVarArr;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaap
    public final boolean zzb(Class<?> cls) {
        zzaap[] zzaapVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzaapVarArr[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaap
    public final zzaao zzc(Class<?> cls) {
        zzaap[] zzaapVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzaap zzaapVar = zzaapVarArr[i];
            if (zzaapVar.zzb(cls)) {
                return zzaapVar.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
