package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz */
/* loaded from: classes3.dex */
public final class zzoz implements zzup<zzwg> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzuq zzuqVar;
        zzvn zzvnVar = new zzvn(zzwgVar.zze());
        zzuqVar = this.zzb.zza;
        zzuqVar.zzn(zzvnVar, new zzoy(this, this));
    }
}
