package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzor */
/* loaded from: classes3.dex */
public final class zzor implements zzup<zzxk> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzor(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxk zzxkVar) {
        zzxk zzxkVar2 = zzxkVar;
        this.zzb.zzO(new zzwg(zzxkVar2.zzc(), zzxkVar2.zzb(), Long.valueOf(zzxkVar2.zzd()), "Bearer"), null, null, Boolean.valueOf(zzxkVar2.zze()), null, this.zza, this);
    }
}
