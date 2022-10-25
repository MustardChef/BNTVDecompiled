package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdl<K, V> implements Map<K, V>, Serializable {
    private transient zzdm<Map.Entry<K, V>> zza;
    private transient zzdm<K> zzb;
    private transient zzdg<V> zzc;

    public static <K, V> zzdl<K, V> zza() {
        return (zzdl<K, V>) zzds.zza;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        return v;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzdt.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzdm<K> zzdmVar = this.zzb;
        if (zzdmVar == null) {
            zzdm<K> zzd = zzd();
            this.zzb = zzd;
            return zzd;
        }
        return zzdmVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
            sb.append('{');
            boolean z = true;
            for (Map.Entry<K, V> entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z = false;
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("size cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // java.util.Map
    /* renamed from: zzb */
    public final zzdm<Map.Entry<K, V>> entrySet() {
        zzdm<Map.Entry<K, V>> zzdmVar = this.zza;
        if (zzdmVar == null) {
            zzdm<Map.Entry<K, V>> zzc = zzc();
            this.zza = zzc;
            return zzc;
        }
        return zzdmVar;
    }

    abstract zzdm<Map.Entry<K, V>> zzc();

    abstract zzdm<K> zzd();

    @Override // java.util.Map
    /* renamed from: zze */
    public final zzdg<V> values() {
        zzdg<V> zzdgVar = this.zzc;
        if (zzdgVar == null) {
            zzdg<V> zzf = zzf();
            this.zzc = zzf;
            return zzf;
        }
        return zzdgVar;
    }

    abstract zzdg<V> zzf();
}
