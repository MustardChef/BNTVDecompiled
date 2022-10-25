package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyc */
/* loaded from: classes3.dex */
final class zzyc implements Comparator<zzym> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzym zzymVar, zzym zzymVar2) {
        zzym zzymVar3 = zzymVar;
        zzym zzymVar4 = zzymVar2;
        zzyb zzybVar = new zzyb(zzymVar3);
        zzyb zzybVar2 = new zzyb(zzymVar4);
        while (zzybVar.hasNext() && zzybVar2.hasNext()) {
            int compare = Integer.compare(zzybVar.zza() & 255, zzybVar2.zza() & 255);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzymVar3.zzc(), zzymVar4.zzc());
    }
}
