package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzoh {
    static final zzoh zza = new zzoh(true);
    private static volatile boolean zzb = false;
    private static volatile zzoh zzc;
    private final Map zzd;

    zzoh() {
        this.zzd = new HashMap();
    }

    public static zzoh zza() {
        zzoh zzohVar = zzc;
        if (zzohVar == null) {
            synchronized (zzoh.class) {
                zzohVar = zzc;
                if (zzohVar == null) {
                    zzohVar = zza;
                    zzc = zzohVar;
                }
            }
        }
        return zzohVar;
    }

    zzoh(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
