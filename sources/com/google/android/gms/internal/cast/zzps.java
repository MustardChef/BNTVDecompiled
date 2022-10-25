package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzps<K, V> extends LinkedHashMap<K, V> {
    private static final zzps zzb;
    private boolean zza;

    static {
        zzps zzpsVar = new zzps();
        zzb = zzpsVar;
        zzpsVar.zza = false;
    }

    private zzps() {
        this.zza = true;
    }

    private static int zze(Object obj) {
        if (obj instanceof byte[]) {
            return zzpb.zzg((byte[]) obj);
        }
        if (obj instanceof zzou) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private final void zzf() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzf();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                return true;
            }
            if (size() != map.size()) {
                return false;
            }
            for (Map.Entry<K, V> entry : entrySet()) {
                if (!map.containsKey(entry.getKey())) {
                    return false;
                }
                V value = entry.getValue();
                Object obj2 = map.get(entry.getKey());
                if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                    equals = value.equals(obj2);
                    continue;
                } else {
                    equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                    continue;
                }
                if (!equals) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzf();
        zzpb.zza(k);
        zzpb.zza(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzf();
        for (K k : map.keySet()) {
            zzpb.zza(k);
            zzpb.zza(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzf();
        return (V) super.remove(obj);
    }

    public final void zza(zzps<K, V> zzpsVar) {
        zzf();
        if (zzpsVar.isEmpty()) {
            return;
        }
        putAll(zzpsVar);
    }

    public final zzps<K, V> zzb() {
        return isEmpty() ? new zzps<>() : new zzps<>(this);
    }

    public final void zzc() {
        this.zza = false;
    }

    public final boolean zzd() {
        return this.zza;
    }

    private zzps(Map<K, V> map) {
        super(map);
        this.zza = true;
    }
}
