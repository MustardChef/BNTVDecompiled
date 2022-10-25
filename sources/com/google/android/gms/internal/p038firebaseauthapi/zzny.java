package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzny */
/* loaded from: classes3.dex */
public final class zzny implements zzup<zzvx> {
    final /* synthetic */ zzuo zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zztb zzf;
    final /* synthetic */ zzwg zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzny(zzpj zzpjVar, zzuo zzuoVar, String str, String str2, Boolean bool, zze zzeVar, zztb zztbVar, zzwg zzwgVar) {
        this.zza = zzuoVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzeVar;
        this.zzf = zztbVar;
        this.zzg = zzwgVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzvx zzvxVar) {
        List<zzvz> zzb = zzvxVar.zzb();
        if (zzb == null || zzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i = 0;
        zzvz zzvzVar = zzb.get(0);
        zzwo zzq = zzvzVar.zzq();
        List<zzwm> zza = zzq != null ? zzq.zza() : null;
        if (zza != null && !zza.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                while (i < zza.size()) {
                    if (!zza.get(i).zzd().equals(this.zzb)) {
                        i++;
                    }
                }
            }
            zza.get(i).zzf(this.zzc);
            break;
        }
        zzvzVar.zzo(this.zzd.booleanValue());
        zzvzVar.zzs(this.zze);
        this.zzf.zzb(this.zzg, zzvzVar);
    }
}
