package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzog */
/* loaded from: classes3.dex */
public final class zzog implements zzup<zzwg> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zztb zzc;
    final /* synthetic */ zzpj zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzog(zzpj zzpjVar, String str, String str2, zztb zztbVar) {
        this.zzd = zzpjVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzc.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzwg zzwgVar2 = zzwgVar;
        zzww zzwwVar = new zzww();
        zzwwVar.zzg(zzwgVar2.zze());
        zzwwVar.zzh(this.zza);
        zzwwVar.zzi(this.zzb);
        zzpj.zzI(this.zzd, this.zzc, zzwgVar2, zzwwVar, this);
    }
}
