package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzrc extends AbstractList<String> implements RandomAccess, zzpi {
    private final zzpi zza;

    public zzrc(zzpi zzpiVar) {
        this.zza = zzpiVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzph) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzrb(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzra(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final Object zze(int i) {
        return this.zza.zze(i);
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final List<?> zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final zzpi zzg() {
        return this;
    }
}
