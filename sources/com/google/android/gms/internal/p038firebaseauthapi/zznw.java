package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw */
/* loaded from: classes3.dex */
public final class zznw implements zzup<zzvx> {
    final /* synthetic */ zzuo zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzwg zzc;
    final /* synthetic */ zzww zzd;
    final /* synthetic */ zzpj zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(zzpj zzpjVar, zzuo zzuoVar, zztb zztbVar, zzwg zzwgVar, zzww zzwwVar) {
        this.zze = zzpjVar;
        this.zza = zzuoVar;
        this.zzb = zztbVar;
        this.zzc = zzwgVar;
        this.zzd = zzwwVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvx zzvxVar) {
        List<zzvz> zzb = zzvxVar.zzb();
        if (zzb == null || zzb.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzpj.zzK(this.zze, this.zzb, this.zzc, zzb.get(0), this.zzd, this.zza);
        }
    }
}
