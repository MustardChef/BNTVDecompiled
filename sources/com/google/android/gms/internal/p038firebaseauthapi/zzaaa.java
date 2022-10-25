package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa */
/* loaded from: classes3.dex */
public final class zzaaa extends zzxv<String> implements RandomAccess, zzaab {
    public static final zzaab zza;
    private static final zzaaa zzb;
    private final List<Object> zzc;

    static {
        zzaaa zzaaaVar = new zzaaa(10);
        zzb = zzaaaVar;
        zzaaaVar.zzb();
        zza = zzaaaVar;
    }

    public zzaaa() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzym) {
            return ((zzym) obj).zzq(zzzu.zza);
        }
        return zzzu.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzaab) {
            collection = ((zzaab) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zzc();
        return zzj(this.zzc.set(i, (String) obj));
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
        if (obj instanceof zzym) {
            zzym zzymVar = (zzym) obj;
            String zzq = zzymVar.zzq(zzzu.zza);
            if (zzymVar.zzi()) {
                this.zzc.set(i, zzq);
            }
            return zzq;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzzu.zzd(bArr);
        if (zzzu.zzc(bArr)) {
            this.zzc.set(i, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzzt
    public final /* bridge */ /* synthetic */ zzzt zze(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzaaa(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final void zzf(zzym zzymVar) {
        zzc();
        this.zzc.add(zzymVar);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final Object zzg(int i) {
        return this.zzc.get(i);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final zzaab zzi() {
        return zza() ? new zzabw(this) : this;
    }

    public zzaaa(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzaaa(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxv, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
