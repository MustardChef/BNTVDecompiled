package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzbu {
    private final Map<String, String> zza = new HashMap();
    private final Map<String, String> zzb = new HashMap();
    private final Map<String, Integer> zzc = new HashMap();

    public final zzbu zza(String str, String str2, int i) {
        this.zza.put(str, str2);
        this.zzb.put(str2, str);
        this.zzc.put(str, Integer.valueOf(i));
        return this;
    }

    public final String zzb(String str) {
        return this.zza.get(str);
    }

    public final String zzc(String str) {
        return this.zzb.get(str);
    }

    public final int zzd(String str) {
        Integer num = this.zzc.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
