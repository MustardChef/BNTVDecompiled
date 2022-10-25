package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzow */
/* loaded from: classes3.dex */
final class zzow implements zzup<zzvx> {
    final /* synthetic */ zzup zza;
    final /* synthetic */ zzwg zzb;
    final /* synthetic */ zzox zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzow(zzox zzoxVar, zzup zzupVar, zzwg zzwgVar) {
        this.zzc = zzoxVar;
        this.zza = zzupVar;
        this.zzb = zzwgVar;
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
            this.zzc.zza.zzb(this.zzb, zzb.get(0));
        }
    }
}
