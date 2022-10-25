package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoh */
/* loaded from: classes3.dex */
final class zzoh implements zzup<zzxp> {
    final /* synthetic */ zzup zza;
    final /* synthetic */ zzoi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoh(zzoi zzoiVar, zzup zzupVar) {
        this.zzb = zzoiVar;
        this.zza = zzupVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxp zzxpVar) {
        zzxp zzxpVar2 = zzxpVar;
        if (TextUtils.isEmpty(zzxpVar2.zzf())) {
            this.zzb.zzc.zzO(new zzwg(zzxpVar2.zzc(), zzxpVar2.zzb(), Long.valueOf(zzxpVar2.zzd()), "Bearer"), null, "phone", Boolean.valueOf(zzxpVar2.zze()), null, this.zzb.zzb, this.zza);
            return;
        }
        this.zzb.zzb.zzl(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzc(zzxpVar2.zzg(), zzxpVar2.zzf()));
    }
}
