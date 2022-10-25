package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbq */
/* loaded from: classes3.dex */
public final class zzbq implements zzbd<zzag, zzag> {
    private static final Logger zza = Logger.getLogger(zzbq.class.getName());

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbd
    public final /* bridge */ /* synthetic */ zzag zza(zzbc<zzag> zzbcVar) throws GeneralSecurityException {
        return new zzbp(zzbcVar, null);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbd
    public final Class<zzag> zzb() {
        return zzag.class;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzbd
    public final Class<zzag> zzc() {
        return zzag.class;
    }
}
