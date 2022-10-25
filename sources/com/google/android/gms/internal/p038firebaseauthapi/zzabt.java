package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabt */
/* loaded from: classes3.dex */
final class zzabt extends zzabr<zzabs, zzabs> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final boolean zza(zzabc zzabcVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ void zzb(zzabs zzabsVar, int i, long j) {
        zzabsVar.zzh(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    final /* bridge */ /* synthetic */ void zzc(zzabs zzabsVar, int i, int i2) {
        zzabsVar.zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    final /* bridge */ /* synthetic */ void zzd(zzabs zzabsVar, int i, long j) {
        zzabsVar.zzh((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ void zze(zzabs zzabsVar, int i, zzym zzymVar) {
        zzabsVar.zzh((i << 3) | 2, zzymVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    final /* bridge */ /* synthetic */ void zzf(zzabs zzabsVar, int i, zzabs zzabsVar2) {
        zzabsVar.zzh((i << 3) | 3, zzabsVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ zzabs zzg() {
        return zzabs.zzb();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    final /* bridge */ /* synthetic */ zzabs zzh(zzabs zzabsVar) {
        zzabs zzabsVar2 = zzabsVar;
        zzabsVar2.zzd();
        return zzabsVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ void zzi(Object obj, zzabs zzabsVar) {
        ((zzzo) obj).zzc = zzabsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ zzabs zzj(Object obj) {
        return ((zzzo) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ zzabs zzk(Object obj) {
        zzzo zzzoVar = (zzzo) obj;
        zzabs zzabsVar = zzzoVar.zzc;
        if (zzabsVar == zzabs.zza()) {
            zzabs zzb = zzabs.zzb();
            zzzoVar.zzc = zzb;
            return zzb;
        }
        return zzabsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ void zzl(Object obj, zzabs zzabsVar) {
        ((zzzo) obj).zzc = zzabsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final void zzm(Object obj) {
        ((zzzo) obj).zzc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ zzabs zzo(zzabs zzabsVar, zzabs zzabsVar2) {
        zzabs zzabsVar3 = zzabsVar2;
        return zzabsVar3.equals(zzabs.zza()) ? zzabsVar : zzabs.zzc(zzabsVar, zzabsVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ int zzp(zzabs zzabsVar) {
        return zzabsVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ int zzq(zzabs zzabsVar) {
        return zzabsVar.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabr
    public final /* bridge */ /* synthetic */ void zzr(zzabs zzabsVar, zzyx zzyxVar) throws IOException {
        zzabsVar.zzi(zzyxVar);
    }
}
