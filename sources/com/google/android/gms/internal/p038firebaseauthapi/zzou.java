package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzou */
/* loaded from: classes3.dex */
public final class zzou implements zzup<zzvt> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzou(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvt zzvtVar) {
        zzvt zzvtVar2 = zzvtVar;
        this.zzb.zzO(new zzwg(zzvtVar2.zzc(), zzvtVar2.zzb(), Long.valueOf(zzwi.zza(zzvtVar2.zzb())), "Bearer"), null, null, false, null, this.zza, this);
    }
}
