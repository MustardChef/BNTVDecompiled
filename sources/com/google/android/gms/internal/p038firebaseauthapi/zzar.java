package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar */
/* loaded from: classes3.dex */
public abstract class zzar<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zza;

    public zzar(Class<PrimitiveT> cls) {
        this.zza = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zzb(KeyT keyt) throws GeneralSecurityException;
}
