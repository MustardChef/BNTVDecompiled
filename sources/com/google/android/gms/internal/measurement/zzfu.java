package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzfu<E> extends zzfg<E> {
    private final transient E zza;
    private transient int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(E e) {
        this.zza = (E) zzeb.zza(e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfu(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzfx<E> zza() {
        return new zzfl(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final zzfb<E> zzh() {
        return zzfb.zza(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzfg, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzb;
        if (i == 0) {
            int hashCode = this.zza.hashCode();
            this.zzb = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final boolean zzg() {
        return this.zzb != 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzfg, com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
