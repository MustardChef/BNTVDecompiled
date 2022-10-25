package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb */
/* loaded from: classes3.dex */
public final class zzzb {
    static final zzzb zza = new zzzb(true);
    private static volatile boolean zzb = false;
    private static volatile zzzb zzc;
    private final Map<zzza, zzzm<?, ?>> zzd;

    zzzb() {
        this.zzd = new HashMap();
    }

    public static zzzb zza() {
        zzzb zzzbVar = zzc;
        if (zzzbVar == null) {
            synchronized (zzzb.class) {
                zzzbVar = zzc;
                if (zzzbVar == null) {
                    zzzbVar = zza;
                    zzc = zzzbVar;
                }
            }
        }
        return zzzbVar;
    }

    public final <ContainingType extends zzaar> zzzm<ContainingType, ?> zzb(ContainingType containingtype, int i) {
        return (zzzm<ContainingType, ?>) this.zzd.get(new zzza(containingtype, i));
    }

    zzzb(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
