package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzfd extends zzfb<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzfb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzfb zzfbVar, int i, int i2) {
        this.zzc = zzfbVar;
        this.zza = i;
        this.zzb = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzeb.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzfb
    public final zzfb<E> zza(int i, int i2) {
        zzeb.zza(i, i2, this.zzb);
        zzfb zzfbVar = this.zzc;
        int i3 = this.zza;
        return (zzfb) zzfbVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzfb, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
