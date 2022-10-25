package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzop */
/* loaded from: classes3.dex */
public final class zzop implements zzup<zzwg> {
    final /* synthetic */ String zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(zzpj zzpjVar, String str, zztb zztbVar) {
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
        zzxq zzxqVar = new zzxq(zzwgVar.zze(), this.zza);
        zzuqVar = this.zzc.zza;
        zzuqVar.zzs(zzxqVar, new zzoo(this));
    }
}
