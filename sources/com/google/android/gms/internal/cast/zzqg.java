package com.google.android.gms.internal.cast;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzqg {
    private static final zzqg zza = new zzqg();
    private final ConcurrentMap<Class<?>, zzqj<?>> zzc = new ConcurrentHashMap();
    private final zzqk zzb = new zzpq();

    private zzqg() {
    }

    public static zzqg zza() {
        return zza;
    }

    public final <T> zzqj<T> zzb(Class<T> cls) {
        zzpb.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzqj<T> zzqjVar = (zzqj<T>) this.zzc.get(cls);
        if (zzqjVar == null) {
            zzqjVar = this.zzb.zza(cls);
            zzpb.zzb(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzpb.zzb(zzqjVar, "schema");
            zzqj putIfAbsent = this.zzc.putIfAbsent(cls, zzqjVar);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return zzqjVar;
    }
}
