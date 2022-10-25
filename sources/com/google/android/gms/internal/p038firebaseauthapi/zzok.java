package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok */
/* loaded from: classes3.dex */
public final class zzok implements zzup<zzwg> {
    final /* synthetic */ zzxg zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzok(zzpj zzpjVar, zzxg zzxgVar, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = zzxgVar;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzuq zzuqVar;
        this.zza.zzf(true);
        this.zza.zzb(zzwgVar.zze());
        zzuqVar = this.zzc.zza;
        zzuqVar.zzd(null, this.zza, new zzoj(this, this));
    }
}
