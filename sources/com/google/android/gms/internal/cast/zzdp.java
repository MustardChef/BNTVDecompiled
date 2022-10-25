package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzdp<K, V> extends zzdm<Map.Entry<K, V>> {
    private final transient zzdl<K, V> zza;
    private final transient Object[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdp(zzdl<K, V> zzdlVar, Object[] objArr, int i, int i2) {
        this.zza = zzdlVar;
        this.zzb = objArr;
    }

    @Override // com.google.android.gms.internal.cast.zzdg, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzdm, com.google.android.gms.internal.cast.zzdg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdm, com.google.android.gms.internal.cast.zzdg
    public final zzdu<Map.Entry<K, V>> zza() {
        return zze().listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final boolean zzf() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final int zzg(Object[] objArr, int i) {
        return zze().zzg(objArr, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdm
    final zzdk<Map.Entry<K, V>> zzh() {
        return new zzdo(this);
    }
}
