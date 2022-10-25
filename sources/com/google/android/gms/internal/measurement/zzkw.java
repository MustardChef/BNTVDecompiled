package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzkw implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzku zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzku zzkuVar) {
        zziq zziqVar;
        this.zzb = zzkuVar;
        zziqVar = zzkuVar.zza;
        this.zza = zziqVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
