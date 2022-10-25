package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzgr implements Comparator<zzgp> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzgp zzgpVar, zzgp zzgpVar2) {
        int zzb;
        int zzb2;
        zzgp zzgpVar3 = zzgpVar;
        zzgp zzgpVar4 = zzgpVar2;
        zzgy zzgyVar = (zzgy) zzgpVar3.iterator();
        zzgy zzgyVar2 = (zzgy) zzgpVar4.iterator();
        while (zzgyVar.hasNext() && zzgyVar2.hasNext()) {
            zzb = zzgp.zzb(zzgyVar.zza());
            zzb2 = zzgp.zzb(zzgyVar2.zza());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgpVar3.zza(), zzgpVar4.zza());
    }
}
