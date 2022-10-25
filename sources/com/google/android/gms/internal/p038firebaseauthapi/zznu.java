package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznu */
/* loaded from: classes3.dex */
public final class zznu implements zzup<zzwg> {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ zztb zzb;
    final /* synthetic */ zzpj zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznu(zzpj zzpjVar, EmailAuthCredential emailAuthCredential, zztb zztbVar) {
        this.zzc = zzpjVar;
        this.zza = emailAuthCredential;
        this.zzb = zztbVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zzb.zzk(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    public final /* bridge */ /* synthetic */ void zzb(zzwg zzwgVar) {
        this.zzc.zzN(new zzvo(this.zza, zzwgVar.zze()), this.zzb);
    }
}
