package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzon */
/* loaded from: classes3.dex */
public final class zzon implements zzup<zzwg> {
    final /* synthetic */ String zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzon(zzpj zzpjVar, String str, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = str;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzuq zzuqVar;
        zzwg zzwgVar2 = zzwgVar;
        zzvw zzvwVar = new zzvw(zzwgVar2.zze());
        zzuqVar = this.zzc.zza;
        zzuqVar.zzh(zzvwVar, new zzom(this, this, zzwgVar2));
    }
}
