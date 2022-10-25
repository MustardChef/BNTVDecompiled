package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns */
/* loaded from: classes3.dex */
public final class zzns implements zzup<zzwz> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzns(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwz zzwzVar) {
        zzwz zzwzVar2 = zzwzVar;
        this.zzb.zzO(new zzwg(zzwzVar2.zzc(), zzwzVar2.zzb(), Long.valueOf(zzwzVar2.zzd()), "Bearer"), null, null, true, null, this.zza, this);
    }
}
