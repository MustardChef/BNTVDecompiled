package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw */
/* loaded from: classes3.dex */
public final class zztw {
    public static final Api.ClientKey<zztc> zza;
    public static final Api<zztv> zzb;
    private static final Api.AbstractClientBuilder<zztc, zztv> zzc;

    static {
        Api.ClientKey<zztc> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zztt zzttVar = new zztt();
        zzc = zzttVar;
        zzb = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzttVar, clientKey);
    }

    public static zzsy zza(Context context, zztv zztvVar) {
        return new zzsy(context, zztvVar);
    }
}
