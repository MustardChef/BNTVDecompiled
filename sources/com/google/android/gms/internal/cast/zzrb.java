package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzrb implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzrc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrb(zzrc zzrcVar) {
        zzpi zzpiVar;
        this.zzb = zzrcVar;
        zzpiVar = zzrcVar.zza;
        this.zza = zzpiVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
