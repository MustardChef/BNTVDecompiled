package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjx {
    private static final zzjx zza = new zzjx();
    private final ConcurrentMap<Class<?>, zzkb<?>> zzc = new ConcurrentHashMap();
    private final zzka zzb = new zziw();

    public static zzjx zza() {
        return zza;
    }

    public final <T> zzkb<T> zza(Class<T> cls) {
        zzia.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzkb<T> zzkbVar = (zzkb<T>) this.zzc.get(cls);
        if (zzkbVar == null) {
            zzkb<T> zza2 = this.zzb.zza(cls);
            zzia.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzia.zza(zza2, "schema");
            zzkb<T> zzkbVar2 = (zzkb<T>) this.zzc.putIfAbsent(cls, zza2);
            return zzkbVar2 != null ? zzkbVar2 : zza2;
        }
        return zzkbVar;
    }

    public final <T> zzkb<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzjx() {
    }
}
