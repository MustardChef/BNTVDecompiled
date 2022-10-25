package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzof */
/* loaded from: classes3.dex */
public final class zzof implements zzup<zzxp> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzof(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxp zzxpVar) {
        zzxp zzxpVar2 = zzxpVar;
        this.zzb.zzO(new zzwg(zzxpVar2.zzc(), zzxpVar2.zzb(), Long.valueOf(zzxpVar2.zzd()), "Bearer"), null, null, Boolean.valueOf(zzxpVar2.zze()), null, this.zza, this);
    }
}
