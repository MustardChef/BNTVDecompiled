package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzab */
/* loaded from: classes3.dex */
public final class zzab implements zzad {
    final /* synthetic */ zzs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzs zzsVar) {
        this.zza = zzsVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzad
    public final /* bridge */ /* synthetic */ Iterator zza(zzae zzaeVar, CharSequence charSequence) {
        return new zzaa(this, zzaeVar, charSequence, this.zza.zza(charSequence));
    }
}
