package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznt */
/* loaded from: classes3.dex */
public final class zznt implements zzup<zzxn> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznt(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxn zzxnVar) {
        zzxn zzxnVar2 = zzxnVar;
        if (zzxnVar2.zzg()) {
            this.zza.zzo(new zznq(zzxnVar2.zzf(), zzxnVar2.zze(), null));
            return;
        }
        this.zzb.zzO(new zzwg(zzxnVar2.zzc(), zzxnVar2.zzb(), Long.valueOf(zzxnVar2.zzd()), "Bearer"), null, null, false, null, this.zza, this);
    }
}
