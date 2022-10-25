package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw */
/* loaded from: classes3.dex */
public final class zzabw extends AbstractList<String> implements RandomAccess, zzaab {
    private final zzaab zza;

    public zzabw(zzaab zzaabVar) {
        this.zza = zzaabVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzaaa) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzabv(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzabu(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final void zzf(zzym zzymVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final Object zzg(int i) {
        return this.zza.zzg(i);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final List<?> zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaab
    public final zzaab zzi() {
        return this;
    }
}
