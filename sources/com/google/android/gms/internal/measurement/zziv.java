package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zziv extends zzit {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zziv() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzkz.zzf(obj, j);
        if (list instanceof zziq) {
            unmodifiableList = ((zziq) list).mo336h_();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzjv) && (list instanceof zzig)) {
                zzig zzigVar = (zzig) list;
                if (zzigVar.zza()) {
                    zzigVar.mo337i_();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzkz.zza(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzir zzirVar;
        List<L> arrayList;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zziq) {
                arrayList = new zzir(i);
            } else if ((zzc instanceof zzjv) && (zzc instanceof zzig)) {
                arrayList = ((zzig) zzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzkz.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(zzc.size() + i);
            arrayList2.addAll(zzc);
            zzkz.zza(obj, j, arrayList2);
            zzirVar = arrayList2;
        } else if (zzc instanceof zzku) {
            zzir zzirVar2 = new zzir(zzc.size() + i);
            zzirVar2.addAll((zzku) zzc);
            zzkz.zza(obj, j, zzirVar2);
            zzirVar = zzirVar2;
        } else if ((zzc instanceof zzjv) && (zzc instanceof zzig)) {
            zzig zzigVar = (zzig) zzc;
            if (zzigVar.zza()) {
                return zzc;
            }
            zzig zza2 = zzigVar.zza(zzc.size() + i);
            zzkz.zza(obj, j, zza2);
            return zza2;
        } else {
            return zzc;
        }
        return zzirVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzkz.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }
}
