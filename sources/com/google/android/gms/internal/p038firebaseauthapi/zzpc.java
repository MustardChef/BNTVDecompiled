package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpc */
/* loaded from: classes3.dex */
public final class zzpc implements zzup<zzxi> {
    final /* synthetic */ zztb zza;
    final /* synthetic */ zzpj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpc(zzpj zzpjVar, zztb zztbVar) {
        this.zzb = zzpjVar;
        this.zza = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzxi zzxiVar) {
        zzxi zzxiVar2 = zzxiVar;
        if (zzxiVar2.zzo()) {
            this.zza.zzo(new zznq(zzxiVar2.zzn(), zzxiVar2.zzm(), zzxiVar2.zzp()));
        } else {
            zzpj.zzH(this.zzb, zzxiVar2, this.zza, this);
        }
    }
}
