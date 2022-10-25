package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoi */
/* loaded from: classes3.dex */
public final class zzoi implements zzup<zzwg> {
    final /* synthetic */ zzxo zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoi(zzpj zzpjVar, zzxo zzxoVar, Context context, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = zzxoVar;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzuq zzuqVar;
        this.zza.zzd(zzwgVar.zze());
        zzuqVar = this.zzc.zza;
        zzuqVar.zzm(null, this.zza, new zzoh(this, this));
    }
}
