package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzu extends zze {
    private final /* synthetic */ zzk.zzd zzai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzk.zzd zzdVar) {
        this.zzai = zzdVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, com.google.android.gms.safetynet.zzd zzdVar) {
        this.zzai.setResult((zzk.zzd) new zzk.zzg(status, zzdVar));
    }
}
