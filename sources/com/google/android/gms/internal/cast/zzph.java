package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzph extends zznn<String> implements RandomAccess, zzpi {
    public static final zzpi zza;
    private static final zzph zzb;
    private final List<Object> zzc;

    static {
        zzph zzphVar = new zzph(10);
        zzb = zzphVar;
        zzphVar.zzb();
        zza = zzphVar;
    }

    public zzph() {
        this(10);
    }

    private static String zzi(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzny) {
            return ((zzny) obj).zzk(zzpb.zza);
        }
        return zzpb.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzpi) {
            collection = ((zzpi) collection).zzf();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzi(remove);
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zzi(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzd */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzny) {
            zzny zznyVar = (zzny) obj;
            String zzk = zznyVar.zzk(zzpb.zza);
            if (zznyVar.zzh()) {
                this.zzc.set(i, zzk);
            }
            return zzk;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzpb.zzd(bArr);
        if (zzpb.zzc(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final Object zze(int i) {
        return this.zzc.get(i);
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final List<?> zzf() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.cast.zzpi
    public final zzpi zzg() {
        return zza() ? new zzrc(this) : this;
    }

    @Override // com.google.android.gms.internal.cast.zzpa
    public final /* bridge */ /* synthetic */ zzpa zzh(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzph(arrayList);
    }

    public zzph(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzph(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.cast.zznn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
