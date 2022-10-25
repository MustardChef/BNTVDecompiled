package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzol */
/* loaded from: classes3.dex */
public final class zzol implements zzup<zzwg> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzol(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzwg zzwgVar2 = zzwgVar;
        zzww zzwwVar = new zzww();
        zzwwVar.zzg(zzwgVar2.zze());
        zzwwVar.zzh(null);
        zzwwVar.zzi(null);
        zzpj.zzI(this.zzb, this.zza, zzwgVar2, zzwwVar, this);
    }
}
