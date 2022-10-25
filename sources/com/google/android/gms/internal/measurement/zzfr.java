package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzfr extends zzfb<Map.Entry<K, V>> {
    private final /* synthetic */ zzfo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfr(zzfo zzfoVar) {
        this.zza = zzfoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzd;
        return i;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zza.zzd;
        zzeb.zza(i, i2);
        objArr = this.zza.zzb;
        int i3 = i * 2;
        Object obj = objArr[i3];
        objArr2 = this.zza.zzb;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }
}
