package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaae */
/* loaded from: classes3.dex */
final class zzaae extends zzaaf {
    private zzaae() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaae(zzaac zzaacVar) {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final <L> List<L> zza(Object obj, long j) {
        zzzt zzztVar = (zzzt) zzacc.zzn(obj, j);
        if (zzztVar.zza()) {
            return zzztVar;
        }
        int size = zzztVar.size();
        zzzt zze = zzztVar.zze(size == 0 ? 10 : size + size);
        zzacc.zzo(obj, j, zze);
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final void zzb(Object obj, long j) {
        ((zzzt) zzacc.zzn(obj, j)).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.firebase-auth-api.zzzt] */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaf
    public final <E> void zzc(Object obj, Object obj2, long j) {
        zzzt<E> zzztVar = (zzzt) zzacc.zzn(obj, j);
        zzzt<E> zzztVar2 = (zzzt) zzacc.zzn(obj2, j);
        int size = zzztVar.size();
        int size2 = zzztVar2.size();
        zzzt<E> zzztVar3 = zzztVar;
        zzztVar3 = zzztVar;
        if (size > 0 && size2 > 0) {
            boolean zza = zzztVar.zza();
            zzzt<E> zzztVar4 = zzztVar;
            if (!zza) {
                zzztVar4 = zzztVar.zze(size2 + size);
            }
            zzztVar4.addAll(zzztVar2);
            zzztVar3 = zzztVar4;
        }
        if (size > 0) {
            zzztVar2 = zzztVar3;
        }
        zzacc.zzo(obj, j, zzztVar2);
    }
}
