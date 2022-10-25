package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzpl extends zzpm {
    private zzpl() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpl(zzpj zzpjVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzpm
    public final void zza(Object obj, long j) {
        ((zzpa) zzrh.zzn(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.cast.zzpa] */
    @Override // com.google.android.gms.internal.cast.zzpm
    public final <E> void zzb(Object obj, Object obj2, long j) {
        zzpa<E> zzpaVar = (zzpa) zzrh.zzn(obj, j);
        zzpa<E> zzpaVar2 = (zzpa) zzrh.zzn(obj2, j);
        int size = zzpaVar.size();
        int size2 = zzpaVar2.size();
        zzpa<E> zzpaVar3 = zzpaVar;
        zzpaVar3 = zzpaVar;
        if (size > 0 && size2 > 0) {
            boolean zza = zzpaVar.zza();
            zzpa<E> zzpaVar4 = zzpaVar;
            if (!zza) {
                zzpaVar4 = zzpaVar.zzh(size2 + size);
            }
            zzpaVar4.addAll(zzpaVar2);
            zzpaVar3 = zzpaVar4;
        }
        if (size > 0) {
            zzpaVar2 = zzpaVar3;
        }
        zzrh.zzo(obj, j, zzpaVar2);
    }
}
