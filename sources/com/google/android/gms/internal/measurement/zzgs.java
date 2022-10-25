package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzgs extends zzgu {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzgp zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgs(zzgp zzgpVar) {
        this.zzc = zzgpVar;
        this.zzb = zzgpVar.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }
}
