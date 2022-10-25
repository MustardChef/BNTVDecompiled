package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzt extends zze {
    private final /* synthetic */ zzk.zzc zzah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzk.zzc zzcVar) {
        this.zzah = zzcVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, boolean z) {
        this.zzah.setResult((zzk.zzc) new zzk.zzj(status, z));
    }
}
