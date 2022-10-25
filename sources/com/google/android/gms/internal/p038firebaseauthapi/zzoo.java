package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoo */
/* loaded from: classes3.dex */
final class zzoo implements zzup<zzxr> {
    final /* synthetic */ zzop zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoo(zzop zzopVar) {
        this.zza = zzopVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxr zzxrVar) {
        zzxr zzxrVar2 = zzxrVar;
        if (TextUtils.isEmpty(zzxrVar2.zzb()) || TextUtils.isEmpty(zzxrVar2.zzc())) {
            this.zza.zzb.zzk(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zza.zzc.zzO(new zzwg(zzxrVar2.zzc(), zzxrVar2.zzb(), Long.valueOf(zzwi.zza(zzxrVar2.zzb())), "Bearer"), null, null, false, null, this.zza.zzb, this);
    }
}
