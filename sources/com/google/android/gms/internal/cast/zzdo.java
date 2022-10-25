package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzdo extends zzdk<Map.Entry> {
    final /* synthetic */ zzdp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdo(zzdp zzdpVar) {
        this.zza = zzdpVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        Object[] objArr;
        Object[] objArr2;
        zzda.zza(i, 0, FirebaseAnalytics.Param.INDEX);
        objArr = this.zza.zzb;
        int i2 = i + i;
        Object obj = objArr[i2];
        objArr2 = this.zza.zzb;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdg
    public final boolean zzf() {
        return true;
    }
}
