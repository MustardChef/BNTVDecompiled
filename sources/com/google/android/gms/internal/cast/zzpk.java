package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzpk extends zzpm {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzpk() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpk(zzpj zzpjVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzpm
    public final void zza(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzrh.zzn(obj, j);
        if (list instanceof zzpi) {
            unmodifiableList = ((zzpi) list).zzg();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if (!(list instanceof zzqf) || !(list instanceof zzpa)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                zzpa zzpaVar = (zzpa) list;
                if (zzpaVar.zza()) {
                    zzpaVar.zzb();
                    return;
                }
                return;
            }
        }
        zzrh.zzo(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.cast.zzpm
    public final <E> void zzb(Object obj, Object obj2, long j) {
        ArrayList arrayList;
        List list = (List) zzrh.zzn(obj2, j);
        int size = list.size();
        List list2 = (List) zzrh.zzn(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzpi) {
                list2 = new zzph(size);
            } else if (!(list2 instanceof zzqf) || !(list2 instanceof zzpa)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zzpa) list2).zzh(size);
            }
            zzrh.zzo(obj, j, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList2 = new ArrayList(list2.size() + size);
                arrayList2.addAll(list2);
                zzrh.zzo(obj, j, arrayList2);
                arrayList = arrayList2;
            } else if (list2 instanceof zzrc) {
                zzph zzphVar = new zzph(list2.size() + size);
                zzphVar.addAll(zzphVar.size(), (zzrc) list2);
                zzrh.zzo(obj, j, zzphVar);
                arrayList = zzphVar;
            } else if ((list2 instanceof zzqf) && (list2 instanceof zzpa)) {
                zzpa zzpaVar = (zzpa) list2;
                if (!zzpaVar.zza()) {
                    list2 = zzpaVar.zzh(list2.size() + size);
                    zzrh.zzo(obj, j, list2);
                }
            }
            list2 = arrayList;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzrh.zzo(obj, j, list);
    }
}
