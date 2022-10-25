package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe */
/* loaded from: classes3.dex */
public final class zzpe implements zzup<zzwg> {
    final /* synthetic */ UserProfileChangeRequest zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpe(zzpj zzpjVar, UserProfileChangeRequest userProfileChangeRequest, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = userProfileChangeRequest;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzwg zzwgVar2 = zzwgVar;
        zzww zzwwVar = new zzww();
        zzwwVar.zzg(zzwgVar2.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzwwVar.zzj(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzwwVar.zzk(this.zza.zza());
        }
        zzpj.zzI(this.zzc, this.zzb, zzwgVar2, zzwwVar, this);
    }
}
