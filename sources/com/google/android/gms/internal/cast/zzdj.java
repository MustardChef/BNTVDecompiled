package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzdj extends zzdk {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzdk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdj(zzdk zzdkVar, int i, int i2) {
        this.zzc = zzdkVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzda.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzdk, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzdg
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzdk
    public final zzdk zzh(int i, int i2) {
        zzda.zzc(i, i2, this.zzb);
        zzdk zzdkVar = this.zzc;
        int i3 = this.zza;
        return zzdkVar.subList(i + i3, i2 + i3);
    }
}
