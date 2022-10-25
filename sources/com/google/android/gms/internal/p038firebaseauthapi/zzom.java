package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom */
/* loaded from: classes3.dex */
final class zzom implements zzup<zzvx> {
    final /* synthetic */ zzup zza;
    final /* synthetic */ zzwg zzb;
    final /* synthetic */ zzon zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzom(zzon zzonVar, zzup zzupVar, zzwg zzwgVar) {
        this.zzc = zzonVar;
        this.zza = zzupVar;
        this.zzb = zzwgVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzc.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvx zzvxVar) {
        List<zzvz> zzb = zzvxVar.zzb();
        if (zzb == null || zzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzvz zzvzVar = zzb.get(0);
        zzww zzwwVar = new zzww();
        zzwwVar.zzg(this.zzb.zze());
        zzwwVar.zzl(this.zzc.zza);
        zzon zzonVar = this.zzc;
        zzpj.zzK(zzonVar.zzc, zzonVar.zzb, this.zzb, zzvzVar, zzwwVar, this.zza);
    }
}
