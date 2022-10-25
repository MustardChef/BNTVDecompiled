package com.google.android.gms.internal.cast;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzdq<K> extends zzdm<K> {
    private final transient zzdl<K, ?> zza;
    private final transient zzdk<K> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdq(zzdl<K, ?> zzdlVar, zzdk<K> zzdkVar) {
        this.zza = zzdlVar;
        this.zzb = zzdkVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdg, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzdm, com.google.android.gms.internal.cast.zzdg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdm, com.google.android.gms.internal.cast.zzdg
    public final zzdu<K> zza() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.cast.zzdm, com.google.android.gms.internal.cast.zzdg
    public final zzdk<K> zze() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final boolean zzf() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final int zzg(Object[] objArr, int i) {
        return this.zzb.zzg(objArr, 0);
    }
}
