package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzkv extends zzkt<zzks, zzks> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final boolean zza(zzjy zzjyVar) {
        return false;
    }

    /* renamed from: zza  reason: avoid collision after fix types in other method */
    private static void zza2(Object obj, zzks zzksVar) {
        ((zzhy) obj).zzb = zzksVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final void zzd(Object obj) {
        ((zzhy) obj).zzb.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ int zzf(zzks zzksVar) {
        return zzksVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ int zze(zzks zzksVar) {
        return zzksVar.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzks zzc(zzks zzksVar, zzks zzksVar2) {
        zzks zzksVar3 = zzksVar;
        zzks zzksVar4 = zzksVar2;
        return zzksVar4.equals(zzks.zza()) ? zzksVar3 : zzks.zza(zzksVar3, zzksVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ void zzb(zzks zzksVar, zzlm zzlmVar) throws IOException {
        zzksVar.zza(zzlmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ void zza(zzks zzksVar, zzlm zzlmVar) throws IOException {
        zzksVar.zzb(zzlmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ void zzb(Object obj, zzks zzksVar) {
        zza2(obj, zzksVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzks zzc(Object obj) {
        zzks zzksVar = ((zzhy) obj).zzb;
        if (zzksVar == zzks.zza()) {
            zzks zzb = zzks.zzb();
            zza2(obj, zzb);
            return zzb;
        }
        return zzksVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzks zzb(Object obj) {
        return ((zzhy) obj).zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* bridge */ /* synthetic */ void zza(Object obj, zzks zzksVar) {
        zza2(obj, zzksVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    final /* synthetic */ zzks zza(zzks zzksVar) {
        zzks zzksVar2 = zzksVar;
        zzksVar2.zzc();
        return zzksVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzks zza() {
        return zzks.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    final /* synthetic */ void zza(zzks zzksVar, int i, zzks zzksVar2) {
        zzksVar.zza((i << 3) | 3, zzksVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ void zza(zzks zzksVar, int i, zzgp zzgpVar) {
        zzksVar.zza((i << 3) | 2, zzgpVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    final /* synthetic */ void zzb(zzks zzksVar, int i, long j) {
        zzksVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    final /* synthetic */ void zza(zzks zzksVar, int i, int i2) {
        zzksVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ void zza(zzks zzksVar, int i, long j) {
        zzksVar.zza(i << 3, Long.valueOf(j));
    }
}
