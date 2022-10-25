package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzos */
/* loaded from: classes3.dex */
final class zzos implements zzup<zzvr> {
    final /* synthetic */ zzot zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzos(zzot zzotVar) {
        this.zza = zzotVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvr zzvrVar) {
        zzvr zzvrVar2 = zzvrVar;
        this.zza.zzc.zzO(new zzwg(zzvrVar2.zzc(), zzvrVar2.zzb(), Long.valueOf(zzwi.zza(zzvrVar2.zzb())), "Bearer"), null, null, false, null, this.zza.zzb, this);
    }
}
