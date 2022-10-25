package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzku extends AbstractList<String> implements zziq, RandomAccess {
    private final zziq zza;

    public zzku(zziq zziqVar) {
        this.zza = zziqVar;
    }

    @Override // com.google.android.gms.internal.measurement.zziq
    /* renamed from: h_ */
    public final zziq mo336h_() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zziq
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zziq
    public final void zza(zzgp zzgpVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzkx(this, i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzkw(this);
    }

    @Override // com.google.android.gms.internal.measurement.zziq
    public final List<?> zzb() {
        return this.zza.zzb();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
