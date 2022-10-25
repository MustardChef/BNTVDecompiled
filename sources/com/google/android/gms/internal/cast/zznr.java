package com.google.android.gms.internal.cast;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zznr implements Comparator<zzny> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzny zznyVar, zzny zznyVar2) {
        zzny zznyVar3 = zznyVar;
        zzny zznyVar4 = zznyVar2;
        zznq zznqVar = new zznq(zznyVar3);
        zznq zznqVar2 = new zznq(zznyVar4);
        while (zznqVar.hasNext() && zznqVar2.hasNext()) {
            int compare = Integer.compare(zznqVar.zza() & 255, zznqVar2.zza() & 255);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zznyVar3.zzc(), zznyVar4.zzc());
    }
}
