package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv */
/* loaded from: classes3.dex */
public final class zznv implements zzup<zzvp> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznv(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvp zzvpVar) {
        zzvp zzvpVar2 = zzvpVar;
        if (zzvpVar2.zzh()) {
            this.zza.zzo(new zznq(zzvpVar2.zzg(), zzvpVar2.zzf(), null));
            return;
        }
        this.zzb.zzO(new zzwg(zzvpVar2.zzc(), zzvpVar2.zzb(), Long.valueOf(zzvpVar2.zze()), "Bearer"), null, null, Boolean.valueOf(zzvpVar2.zzd()), null, this.zza, this);
    }
}
