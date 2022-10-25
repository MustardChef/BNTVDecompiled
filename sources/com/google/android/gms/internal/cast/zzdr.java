package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzdr extends zzdk<Object> {
    private final transient Object[] zza;
    private final transient int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdr(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzda.zza(i, 0, FirebaseAnalytics.Param.INDEX);
        return this.zza[i + i + this.zzb];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzdg
    public final boolean zzf() {
        return true;
    }
}
