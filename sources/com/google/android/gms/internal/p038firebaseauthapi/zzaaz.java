package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaz */
/* loaded from: classes3.dex */
public final class zzaaz {
    private static final zzaaz zza = new zzaaz();
    private final ConcurrentMap<Class<?>, zzabd<?>> zzc = new ConcurrentHashMap();
    private final zzabe zzb = new zzaaj();

    private zzaaz() {
    }

    public static zzaaz zza() {
        return zza;
    }

    public final <T> zzabd<T> zzb(Class<T> cls) {
        zzzu.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzabd<T> zzabdVar = (zzabd<T>) this.zzc.get(cls);
        if (zzabdVar == null) {
            zzabdVar = this.zzb.zza(cls);
            zzzu.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzzu.zzb(zzabdVar, "schema");
            zzabd putIfAbsent = this.zzc.putIfAbsent(cls, zzabdVar);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return zzabdVar;
    }
}
