package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p038firebaseauthapi.zzwg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class zzs implements com.google.firebase.auth.internal.zzg {
    final /* synthetic */ FirebaseAuth zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzwg zzwgVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzwgVar);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzf(zzwgVar);
        this.zza.zza(firebaseUser, zzwgVar, true, false);
    }
}
