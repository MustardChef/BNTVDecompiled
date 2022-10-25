package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaa */
/* loaded from: classes3.dex */
final class zzaa extends zzac {
    final /* synthetic */ zzr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzab zzabVar, zzae zzaeVar, CharSequence charSequence, zzr zzrVar) {
        super(zzaeVar, charSequence);
        this.zza = zzrVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzac
    public final int zzc(int i) {
        if (((zzt) this.zza).zza.find(i)) {
            return ((zzt) this.zza).zza.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzac
    public final int zzd(int i) {
        return ((zzt) this.zza).zza.end();
    }
}
