package com.google.android.gms.internal.cast;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzds<K, V> extends zzdl<K, V> {
    static final zzdl<Object, Object> zza = new zzds(null, new Object[0], 0);
    final transient Object[] zzb;

    private zzds(Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
    }

    @Override // java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdl
    final zzdm<Map.Entry<K, V>> zzc() {
        return new zzdp(this, this.zzb, 0, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdl
    final zzdm<K> zzd() {
        return new zzdq(this, new zzdr(this.zzb, 0, 0));
    }

    @Override // com.google.android.gms.internal.cast.zzdl
    final zzdg<V> zzf() {
        return new zzdr(this.zzb, 1, 0);
    }
}
