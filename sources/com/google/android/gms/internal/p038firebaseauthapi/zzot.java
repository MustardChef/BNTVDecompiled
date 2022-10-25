package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot */
/* loaded from: classes3.dex */
public final class zzot implements zzup<zzwg> {
    final /* synthetic */ zzvq zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzot(zzpj zzpjVar, zzvq zzvqVar, Context context, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = zzvqVar;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        zzuq zzuqVar;
        this.zza.zzc(zzwgVar.zze());
        zzuqVar = this.zzc.zza;
        zzuqVar.zzr(null, this.zza, new zzos(this));
    }
}
