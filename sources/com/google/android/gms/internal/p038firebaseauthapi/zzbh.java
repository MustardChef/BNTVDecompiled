package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbh */
/* loaded from: classes3.dex */
final class zzbh implements zzbj {
    final /* synthetic */ zzbf zza;
    final /* synthetic */ zzas zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(zzbf zzbfVar, zzas zzasVar) {
        this.zza = zzbfVar;
        this.zzb = zzasVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final <Q> zzam<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzbe(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbj
    public final zzam<?> zzb() {
        zzbf zzbfVar = this.zza;
        return new zzbe(zzbfVar, this.zzb, zzbfVar.zzh());
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
        return this.zzb.getClass();
    }
}
