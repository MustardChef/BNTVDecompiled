package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbg */
/* loaded from: classes3.dex */
final class zzbg implements zzbj {
    final /* synthetic */ zzas zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(zzas zzasVar) {
        this.zza = zzasVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final <Q> zzam<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzao(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final zzam<?> zzb() {
        zzas zzasVar = this.zza;
        return new zzao(zzasVar, zzasVar.zzh());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final Class<?> zze() {
        return null;
    }
}
