package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad */
/* loaded from: classes3.dex */
final class zzaad extends zzaaf {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzaad() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaad(zzaac zzaacVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zzf(Object obj, long j, int i) {
        zzaaa zzaaaVar;
        List<L> arrayList;
        List<L> list = (List) zzacc.zzn(obj, j);
        if (list.isEmpty()) {
            if (list instanceof zzaab) {
                arrayList = new zzaaa(i);
            } else if (!(list instanceof zzaay) || !(list instanceof zzzt)) {
                arrayList = new ArrayList<>(i);
            } else {
                arrayList = ((zzzt) list).zze(i);
            }
            zzacc.zzo(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i);
            arrayList2.addAll(list);
            zzacc.zzo(obj, j, arrayList2);
            zzaaaVar = arrayList2;
        } else if (list instanceof zzabw) {
            zzaaa zzaaaVar2 = new zzaaa(list.size() + i);
            zzaaaVar2.addAll(zzaaaVar2.size(), (zzabw) list);
            zzacc.zzo(obj, j, zzaaaVar2);
            zzaaaVar = zzaaaVar2;
        } else if ((list instanceof zzaay) && (list instanceof zzzt)) {
            zzzt zzztVar = (zzzt) list;
            if (zzztVar.zza()) {
                return list;
            }
            zzzt zze = zzztVar.zze(list.size() + i);
            zzacc.zzo(obj, j, zze);
            return zze;
        } else {
            return list;
        }
        return zzaaaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final <L> List<L> zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzacc.zzn(obj, j);
        if (list instanceof zzaab) {
            unmodifiableList = ((zzaab) list).zzi();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if (!(list instanceof zzaay) || !(list instanceof zzzt)) {
                unmodifiableList = Collections.unmodifiableList(list);
            } else {
                zzzt zzztVar = (zzzt) list;
                if (zzztVar.zza()) {
                    zzztVar.zzb();
                    return;
                }
                return;
            }
        }
        zzacc.zzo(obj, j, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final <E> void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzacc.zzn(obj2, j);
        List zzf = zzf(obj, j, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzacc.zzo(obj, j, list);
    }
}
