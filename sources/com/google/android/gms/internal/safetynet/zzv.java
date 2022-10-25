package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzv extends zze {
    private final /* synthetic */ zzk.zze zzaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzk.zze zzeVar) {
        this.zzaj = zzeVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, com.google.android.gms.safetynet.zzf zzfVar) {
        this.zzaj.setResult((zzk.zze) new zzk.zzh(status, zzfVar));
    }
}
